/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.controller;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ImageOther;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.ImageOtherService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author daniel
 * 
 * working with documents pdfs
 */

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "*")
public class ImageOtherController {
    
    @Autowired
    ImageOtherService imageService;
    
    
    @PostMapping("others/{idOther}/upload")
    public ResponseEntity<ImageOther> uplaodImageInBridge(@PathVariable("idOther") Long idOther, @RequestParam("imageFile") MultipartFile file) throws IOException {
        ImageOther img = new ImageOther(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.saveInOther(idOther, img));
    }
    
}
