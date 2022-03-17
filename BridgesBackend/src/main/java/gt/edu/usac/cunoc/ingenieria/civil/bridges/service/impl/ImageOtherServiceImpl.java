/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ImageOther;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Other;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.ImageOtherRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.ImageOtherService;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.OtherService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class ImageOtherServiceImpl implements ImageOtherService {

    @Autowired
    private ImageOtherRepository imageOtherRepository;

    @Autowired
    private OtherService otherService;

    @Override
    public ImageOther saveInOther(Long idOther, ImageOther image) {
        for (Other other : otherService.findAll()) {
            if (Objects.equals(other.getOtherId(), idOther)) {
                image.setOtherOtherId(other);
            }
        }
        return imageOtherRepository.save(image);
    }

}
