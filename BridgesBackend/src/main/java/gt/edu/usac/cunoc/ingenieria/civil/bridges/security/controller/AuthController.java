/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.controller;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.dto.JwtDto;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.dto.LoginUser;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.dto.NewUser;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.Rol;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.User;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.enums.NameRol;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.jwt.JwtProvider;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service.RolService;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    //Fixme: Eliminar @Valid
    //new Message("campos mal puestos o email invalido")
    @PostMapping("/newUser")
    public ResponseEntity<?> newUser(@Validated @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("campos mal puestos o email invalido", HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUserName(newUser.getUsername())) {
            return new ResponseEntity("Ese user nombre ya existe", HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity("Ese email ya existe", HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByNameRol(NameRol.ROL_USER).get());
        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByNameRol(NameRol.ROL_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>("Usuario guardado", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Validated @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("campos mal puestos ", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
