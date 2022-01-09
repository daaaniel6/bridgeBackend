/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.Rol;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.enums.NameRol;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByNameRol(NameRol nameRol){
        return rolRepository.findByNameRol(nameRol);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
