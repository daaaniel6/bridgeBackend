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
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ConcreteRow;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Council;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Image;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ImageOther;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ProtectionWorks;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Stapes;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Stretch;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.RowWidth;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.RowWidthPile;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.SlabAccess;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.SteelRow;
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
    public Bridge save(Bridge bridge) {
        for (Stapes stape : bridge.getStapesList()) {
            stape.setBridgeBridgeId(bridge);
            for (RowWidth rowWidth : stape.getRowWidthList()) {
                rowWidth.setStapesStapesId(stape);
            }
        }
        for(Stretch stretch: bridge.getStretchList()){
            stretch.setBridgeBridgeId(bridge);
        }
        for (RowWidthPile rowWidthPile : bridge.getPilePileId().getRowWidthPileList()) {
            rowWidthPile.setPilePileId(bridge.getPilePileId());
        }
        for (ConcreteRow concreteRow : bridge.getSuperstructureSuperstructureId().getConcreteRowList()) {
            concreteRow.setSuperstructureSuperstructureId(bridge.getSuperstructureSuperstructureId());
        }
        for (SteelRow steelRow : bridge.getSuperstructureSuperstructureId().getSteelRowList()) {
            steelRow.setSuperstructureSuperstructureId(bridge.getSuperstructureSuperstructureId());
        }
        for (Council council : bridge.getNonStructuralElementsNonStructuralElementsId().getCouncilList()) {
            council.setNonStructuralElementsNonStructuralElementsId(bridge.getNonStructuralElementsNonStructuralElementsId());
        }
        for (SlabAccess slabAccess : bridge.getNonStructuralElementsNonStructuralElementsId().getSlabAccessList()) {
            slabAccess.setNonStructuralElementsNonStructuralElementsId(bridge.getNonStructuralElementsNonStructuralElementsId());
        }
        for (ProtectionWorks protectionWorks : bridge.getNonStructuralElementsNonStructuralElementsId().getProtectionWorksList()) {
            protectionWorks.setNonStructuralElementsNonStructuralElementsId(bridge.getNonStructuralElementsNonStructuralElementsId());
        }
        for (Image image : bridge.getImageList()) {
            image.setBridgeBridgeId(bridge);
        }
        for (ImageOther imageOther : bridge.getOtherOtherId().getImageOtherList()) {
            imageOther.setOtherOtherId(bridge.getOtherOtherId());
        }
        
        return bridgeRepository.save(bridge);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        bridgeRepository.deleteById(id);

    }

}
