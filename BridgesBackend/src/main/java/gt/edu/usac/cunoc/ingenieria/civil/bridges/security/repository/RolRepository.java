/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.security.repository;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.entity.Rol;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.security.enums.NameRol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author daniel
 */
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNameRol(NameRol nameRol);
}
