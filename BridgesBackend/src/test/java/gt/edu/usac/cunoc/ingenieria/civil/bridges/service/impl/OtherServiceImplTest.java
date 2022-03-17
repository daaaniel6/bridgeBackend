/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Bridge;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Departament;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Other;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.BridgeRepository;
import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.OtherRepository;
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
import static org.mockito.Mockito.when;

/**
 *
 * @author daniel
 */
@RunWith(MockitoJUnitRunner.class)
public class OtherServiceImplTest {

    @Mock
    private OtherRepository otherRepository;

    @InjectMocks
    private OtherServiceImpl otherService;

    private Other other;
    
    public OtherServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        other = new Other();
        other.setOtherId(1L);
        other.setObservation("observation");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class OtherServiceImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Other> expResult = new ArrayList<>();
        expResult.add(other);
        when(otherRepository.findAll()).thenReturn(expResult);

        Iterable<Other> result = otherService.findAll();
        assertEquals(expResult, result);
        //assertNotNull(result);
    }
    
}
