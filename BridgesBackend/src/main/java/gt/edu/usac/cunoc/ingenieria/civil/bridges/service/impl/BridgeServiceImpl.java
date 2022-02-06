/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.BridgeRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.BridgeService;

/**
 *
 * @author daniel
 */

@Service
public class BridgeServiceImpl implements BridgeService {

    @Autowired
    private BridgeRepository bridgeRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Bridge> findAll() {
        return bridgeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Bridge> findById(Long id) {
        return bridgeRepository.findById(id);
    }

    @Override
    @Transactional
    public Bridge save(Bridge departament) {
        return bridgeRepository.save(departament);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bridgeRepository.deleteById(id);

    }

}
