/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.ImageRepository;
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

import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * @author daniel
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageServiceImplTest {

    @Mock
    private ImageRepository imageRepository;

    @Mock
    private BridgeService bridgeService;

    @InjectMocks
    private ImageServiceImpl imageService;

    private Image image;

    public ImageServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        image = new Image();
        image.setImageId(1L);
        image.setName("name");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByName method, of class ImageServiceImpl.
     */
    /*@Test
    public void testFindByName() {
        System.out.println("findByName");

    }*/

    /**
     * Test of findById method, of class ImageServiceImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        //arrange
        Image expResult = image;
        when(imageRepository.findById(image.getImageId())).thenReturn(Optional.of(image));
        //act
        Image result = imageService.findById(image.getImageId()).get();
        //assert
        assertEquals(expResult, result);


    }

    /**
     * Test of findAll method, of class ImageServiceImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        //arrange
        List<Image> expResult = new ArrayList<>();
        expResult.add(image);
        when(imageRepository.findAll()).thenReturn(expResult);
        //act
        Iterable<Image> result = imageService.findAll();
        //assert
        assertEquals(expResult, result);
    }

    /**
     * Test of findImagesByIdBridge method, of class ImageServiceImpl.
     */
    @Test
    public void testFindImagesByIdBridge() {
        System.out.println("findImagesByIdBridge");
        //arrange
        Bridge bridge = new Bridge();
        bridge.setBridgeId(1L);
        image.setBridgeBridgeId(bridge);
        List<Image> expResult = new ArrayList<>();
        expResult.add(image);
        when(imageRepository.findAll()).thenReturn(expResult);

        //act
        Iterable<Image> result = imageService.findImagesByIdBridge(1L);

        //assert
        assertEquals(expResult, result);

    }

    /**
     * Test of saveInBridge method, of class ImageServiceImpl.
     */
    @Test
    public void testSaveInBridge() {
        System.out.println("saveInBridge");
        //arrange
        Bridge bridge = new Bridge();
        bridge.setBridgeId(1L);
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(bridge);
        when(bridgeService.findAll()).thenReturn(bridges);
        when(imageRepository.save(image)).thenReturn(image);
        //act
        Image result = imageService.saveInBridge( 1L,image);
        //assert
        assertEquals(1L, result.getBridgeBridgeId().getBridgeId().longValue());
    }

    /**
     * Test of deleteById method, of class ImageServiceImpl.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        doNothing().when(imageRepository).deleteById(1L);
        
        imageService.deleteById(1L);
        
        Mockito.verify(imageRepository).deleteById(1L);
    }

}
