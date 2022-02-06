/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.BridgeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author daniel
 */

@RestController
@RequestMapping("/api/bridges")
@CrossOrigin(origins = "*")
public class BridgeController {

    @Autowired
    private BridgeService bridgeService;

    @GetMapping("/{id}")
    public ResponseEntity<Bridge> read(@PathVariable Long id) {
        Optional<Bridge> oDepartament = bridgeService.findById(id);
        if (!oDepartament.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oDepartament.get());
    }

    @GetMapping
    @ApiOperation("Mustra la lista de puentes")
    public ResponseEntity<List<Bridge>> readAll() {
        List<Bridge> departaments = StreamSupport.stream(bridgeService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(departaments);
    }
    
    @PostMapping
    public ResponseEntity<Bridge> create(@RequestBody Bridge bridge){
        System.out.println("Creando.............");
        return ResponseEntity.status(HttpStatus.CREATED).body(bridgeService.save(bridge));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Bridge> update(@RequestBody Bridge bridge, @PathVariable Long id){
        Optional<Bridge> bridgeOptional = bridgeService.findById(id);
        if(!bridgeOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(bridge, bridgeOptional.get());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(bridgeService.save(bridgeOptional.get()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!bridgeService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        bridgeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
