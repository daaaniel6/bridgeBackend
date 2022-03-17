/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Other;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.OtherRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */
@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    private OtherRepository otherRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Other> findAll() {
        return otherRepository.findAll();
    }

}
