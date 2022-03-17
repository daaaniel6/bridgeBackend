/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Departament;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author daniel
 */

public interface DepartamentService {

    public Iterable<Departament> findAll();

    public Optional<Departament> findById(Integer id);

}
