/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.dto.ChangePasswordDTO;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.dto.EmailValuesDTO;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.emailpassword.service.EmailService;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.User;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service.UserService;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
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

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;

    private static final String subject = "Cambio de Contraseña";

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
        Optional<User> userOpt = userService.getByUserNameOrEmail(dto.getMailTo());
        if (!userOpt.isPresent()) {
            return new ResponseEntity<>("No existe ningun usuario con esas credenciales", HttpStatus.NOT_FOUND);
        }
        User user = userOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(user.getEmail());
        dto.setSubject(subject);
        dto.setUserName(user.getUserName());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        user.setTokenPassword(tokenPassword);
        userService.save(user);
        emailService.sendEmail(dto);
        return new ResponseEntity("Correo con plantilla enviado con éxito", HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordDTO dto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos mal puestos", HttpStatus.BAD_REQUEST);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            return new ResponseEntity<>("Las contraseñas no coinciden", HttpStatus.BAD_REQUEST);
        }
        Optional<User> userOpt = userService.getByTokenPassword(dto.getTokenPassword());
        if (!userOpt.isPresent()) {
            return new ResponseEntity<>("No existe ningun usuario con esas credenciales", HttpStatus.NOT_FOUND);
        }
        User user = userOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(newPassword);
        user.setTokenPassword(null);
        userService.save(user);
        return new ResponseEntity("Contraseña cambiada con éxito", HttpStatus.OK);
    }

}
