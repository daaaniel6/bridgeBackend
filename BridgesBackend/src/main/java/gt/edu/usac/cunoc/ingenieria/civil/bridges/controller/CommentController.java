/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.controller;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Comment;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.CommentService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
    
    @PostMapping("bridges/{idBridge}/send")
    public ResponseEntity<Comment> uplaodImageInBridge(@PathVariable("idBridge") Long idBridge, @RequestBody Comment comment) throws IOException {
       return ResponseEntity.status(HttpStatus.CREATED).body(commentService.saveInBridge(idBridge, comment));
    }
    
}
