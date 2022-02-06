/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.service.RolService;

/**
 *
 * @author daniel
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService roleService;

    @Override
    public void run(String... args) throws Exception {
        // Rol rolAdmin = new Rol(NameRol.ROL_ADMIN);
        // Rol rolUser = new Rol(NameRol.ROL_USER);
        // roleService.save(rolAdmin);
        // roleService.save(rolUser);
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
