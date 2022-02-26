/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Image;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.BridgeRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.ImageRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.BridgeService;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.ImageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private BridgeService bridgeService;

    @Override
    @Transactional(readOnly = true)
    public Optional<Image> findByName(String name) {
        return imageRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Image> findImagesByIdBridge(Long idBridge) {
        List<Image> list = new ArrayList<>();
        for (Image image : this.findAll()) {
            if (image.getBridgeBridgeId().getBridgeId() != null) {
                if (Objects.equals(image.getBridgeBridgeId().getBridgeId(), idBridge)) {
                    list.add(image);
                }
            }
        }

        return list;
    }

    @Override
    @Transactional
    public Image saveInBridge(Long idBridge, Image image) {
        for (Bridge bridge : bridgeService.findAll()) {
            if (bridge.getBridgeId() == idBridge) {
                image.setBridgeBridgeId(bridge);
            }
        }
        return imageRepository.save(image);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

}
