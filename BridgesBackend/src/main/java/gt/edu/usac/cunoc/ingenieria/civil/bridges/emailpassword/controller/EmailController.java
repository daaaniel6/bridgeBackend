/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.dto.EmailValuesDTO;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.service.EmailService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author daniel
 */

@RestController
@RequestMapping("/email-password")
@CrossOrigin
public class EmailController {

    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        dto.setMailFrom(mailFrom);
        dto.setSubject("Cambio de contraseña");
        dto.setUserName("Juan");
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        emailService.sendEmail(dto);
        return new ResponseEntity("Correo con plantilla enviado con éxito", HttpStatus.OK);
    }

}
