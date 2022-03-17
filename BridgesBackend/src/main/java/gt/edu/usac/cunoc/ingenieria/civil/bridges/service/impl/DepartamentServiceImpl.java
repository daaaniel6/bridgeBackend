/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Departament;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.DepartamentRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.DepartamentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */

@Service
public class DepartamentServiceImpl implements DepartamentService{

    @Autowired
    private DepartamentRepository departamentRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Departament> findAll() {
        return departamentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Departament> findById(Integer id) {
        return departamentRepository.findById(id);
    }
    
}
