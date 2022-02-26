/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.controller;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Image;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.ImageRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
                compressBytes(
                        file.getBytes()
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(imageRepository.save(img));
    }

    @PostMapping("bridge/{idBridge}/upload")
    public ResponseEntity<Image> uplaodImageInBridge(@PathVariable("idBridge") Long idBridge, @RequestParam("imageFile") MultipartFile file) throws IOException {
        Image img = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.saveInBridge(idBridge, img));
    }

    @GetMapping(path = {"/get/{imageName}"})
    public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<Image> retrievedImage = imageService.findByName(imageName);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getComment(),
                decompressBytes(retrievedImage.get().getImage()));
        return img;
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() throws IOException {
        List<Image> imagesDecompress = new ArrayList<>();
        List<Image> images = StreamSupport.stream(imageService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        for (Image image : images) {
            Image imageDecompress = new Image(image.getName(), image.getComment(),image.getImage());
            imagesDecompress.add(imageDecompress);
        }
        return ResponseEntity.ok(imagesDecompress);
    }
    
    @GetMapping("bridge/{idBridge}")
    public ResponseEntity<List<Image>> getImagesByBridge(@PathVariable("idBridge") Long idBridge) throws IOException {
        List<Image> images = StreamSupport.stream(imageService.findImagesByIdBridge(idBridge).spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(images);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!imageService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        imageService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
