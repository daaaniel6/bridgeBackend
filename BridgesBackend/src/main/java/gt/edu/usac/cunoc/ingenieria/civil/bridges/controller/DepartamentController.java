/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.controller;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Departament;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.DepartamentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */
//sustantivo en plural 
@RestController
@RequestMapping("/api/departaments")
public class DepartamentController {

    @Autowired
    private DepartamentService departamentService;

    
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        Optional<Departament> oDepartament = departamentService.findById(id);
        if (!oDepartament.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oDepartament);
    }

    
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Departament> readAll() {
        List<Departament> departaments = StreamSupport.stream(departamentService.findAll().spliterator(), false).collect(Collectors.toList());
        return departaments;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Departament> listarPorId(@PathVariable("id") Integer id) throws  Exception{
//        Departament obj = departamentService.listarPorId(id);
//        if(obj == null){
//            throw  new Exception("No se encontro el id");
//        }
//        return new ResponseEntity<>(obj,HttpStatus.OK);
//    }
}
