/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Comment;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.BridgeRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.CommentRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.BridgeService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 *
 * @author daniel
 */
@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private BridgeService bridgeService;

    @InjectMocks
    private CommentServiceImpl commentService;

    private Comment comment;

    public CommentServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        comment = new Comment();
        comment.setCommentId(1L);
        comment.setComment("comment");

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveInBridge method, of class CommentServiceImpl.
     */
    @Test
    public void testSaveInBridge() {
        System.out.println("saveInBridge");
        //Arrange
        Bridge bridge = new Bridge();
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(bridge);
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);
        when(bridgeService.findAll()).thenReturn(bridges);

        //Act
        Comment result = commentService.saveInBridge(1L, comment);
        Comment expResult = comment;

        //Assert
        assertEquals(expResult, result);
        assertNotNull(result);
    }
    
}
