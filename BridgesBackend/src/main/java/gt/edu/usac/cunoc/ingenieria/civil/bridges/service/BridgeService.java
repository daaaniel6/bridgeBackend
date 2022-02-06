/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service;

import java.util.Optional;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;

/**
 *
 * @author daniel
 */

/**
 * patron de diseño fachada
 */
public interface BridgeService {

    public Iterable<Bridge> findAll();

    public Optional<Bridge> findById(Long id);

    public Bridge save(Bridge departament);

    public void deleteById(Long id);

}
