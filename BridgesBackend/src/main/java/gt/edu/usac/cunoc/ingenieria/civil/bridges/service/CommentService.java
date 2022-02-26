/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Comment;

/**
 *
 * @author daniel
 */
public interface CommentService {
    
    Comment saveInBridge(Long idBridge, Comment comment);
    
}
