/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Image;
import java.util.Optional;

/**
 *
 * @author daniel
 */
public interface ImageService {
    Optional<Image> findByName(String name);
    
    Iterable<Image> findAll();
    
    Iterable<Image> findImagesByIdBridge(Long idBridge);
    
    Image saveInBridge(Long idBridge, Image image);
    
    void deleteById(Long id);
    
    public Optional<Image> findById(Long id);
    
   
}
