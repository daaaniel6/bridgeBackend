/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Comment;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.CommentRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.BridgeService;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.CommentService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author daniel
 */

@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private BridgeService bridgeService;
    
    @Override
    @Transactional
    public Comment saveInBridge(Long idBridge, Comment comment) {
        for (Bridge bridge : bridgeService.findAll()) {
            if (Objects.equals(bridge.getBridgeId(), idBridge)) {
                comment.setBridge(bridge);
            }
        }
        return commentRepository.save(comment);
    }
}
