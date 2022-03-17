/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.ImageOther;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Other;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.ImageOtherRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.service.OtherService;
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
public class ImageOtherServiceImplTest {

    @Mock
    private ImageOtherRepository imageOtherRepository;
    @Mock
    private OtherService otherService;

    @InjectMocks
    private ImageOtherServiceImpl imageOtherService;

    private ImageOther imageOther;

    public ImageOtherServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.imageOther = new ImageOther();
        imageOther.setImageOtherId(1L);
        imageOther.setName("name");
        Other other = new Other();
        imageOther.setOtherOtherId(other);
        imageOther.setOtherOtherId(new Other());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveInOther method, of class ImageOtherServiceImpl.
     */
    @Test
    public void testSaveInOther() {
        System.out.println("saveInOther");
        when(imageOtherRepository.save(any(ImageOther.class))).thenReturn(this.imageOther);
        List<Other> list = new ArrayList<>();
        list.add(imageOther.getOtherOtherId());
        when(otherService.findAll()).thenReturn(list);

        ImageOther result = imageOtherService.saveInOther(1L ,this.imageOther);
        ImageOther expResult = this.imageOther;




        assertEquals(expResult, result);
    }
    
}
