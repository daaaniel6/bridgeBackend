/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.Departament;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.DepartamentRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author daniel
 */
@RunWith(MockitoJUnitRunner.class)
public class DepartamentServiceImplTest {

    @Mock
    private DepartamentRepository departamentRepository;

    @InjectMocks
    private DepartamentServiceImpl departamentService;

    private Departament departament;
    
    public DepartamentServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        departament = new Departament();
        departament.setDepartamentId(1);
        departament.setName("San Marcos");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class DepartamentServiceImpl.
     */
    @Test
    public void testFindAll() {
        //arrange, act y assert
        System.out.println("findAll");
        List<Departament> expResult = new ArrayList<>();
        expResult.add(departament);
        when(departamentRepository.findAll()).thenReturn(expResult);

        Iterable<Departament> result = departamentService.findAll();

        assertEquals(expResult, result);
    }

   

    /**
     * Test of findById method, of class DepartamentServiceImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        when(departamentRepository.findById(1)).thenReturn(Optional.of(departament));
        Departament result = departamentService.findById(1).get();
        Departament expResult = departament;
        assertEquals(expResult, result);
    }

    
    
}
