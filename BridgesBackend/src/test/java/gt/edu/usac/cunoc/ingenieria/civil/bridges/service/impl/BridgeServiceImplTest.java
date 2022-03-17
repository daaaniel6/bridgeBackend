/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gt.edu.usac.cunoc.ingenieria.civil.bridges.service.impl;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gt.edu.usac.cunoc.ingenieria.civil.bridges.repository.BridgeRepository;
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
import static org.mockito.Mockito.*;


/**
 *
 * @author daniel
 */
@RunWith(MockitoJUnitRunner.class)
public class BridgeServiceImplTest {

    @Mock
    private BridgeRepository bridgeRepository;

    @InjectMocks
    private BridgeServiceImpl bridgeService;

    private Bridge bridge;
    
    public BridgeServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //MockitoAnnotations.initMocks(this);


        bridge = new Bridge();
        bridge.setName("Puente");
        bridge.setBridgeId(1L);
        bridge.setStapesList(new ArrayList<>());
        bridge.setStretchList(new ArrayList<>());
        Pile pile = new Pile();
        pile.setRowWidthPileList(new ArrayList<>());
        bridge.setPilePileId(pile);
        Superstructure superstructure = new Superstructure();
        superstructure.setConcreteRowList(new ArrayList<>());
        superstructure.setSteelRowList(new ArrayList<>());
        bridge.setSuperstructureSuperstructureId(superstructure);
        NonStructuralElements nonStructuralElements = new NonStructuralElements();
        nonStructuralElements.setCouncilList(new ArrayList<>());
        nonStructuralElements.setSlabAccessList(new ArrayList<>());
        nonStructuralElements.setProtectionWorksList(new ArrayList<>());
        bridge.setNonStructuralElementsNonStructuralElementsId(nonStructuralElements);
        Other other = new Other();
        other.setImageOtherList(new ArrayList<>());
        bridge.setOtherOtherId(other);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class BridgeServiceImpl.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        List<Bridge> expResult = new ArrayList<>();
        expResult.add(bridge);
        when(bridgeRepository.findAll()).thenReturn(expResult);

        Iterable<Bridge> result = bridgeService.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class BridgeServiceImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Optional<Bridge> optBridge = Optional.of(bridge);
        when(bridgeRepository.findById(1L)).thenReturn(optBridge);
        Bridge result = bridgeService.findById(1L).get();
        Bridge expResult = bridge;
        assertEquals(expResult, result);
        assertNotNull(bridgeService.findById(1L));
    }

    /**
     * Test of save method, of class BridgeServiceImpl.
     */
    @Test
    public void testSave() {
         System.out.println("save");
        when(bridgeRepository.save(any(Bridge.class))).thenReturn(bridge);

        Stapes stapes = new Stapes();
        bridge.getStapesList().add(stapes);
        RowWidth rowWidth = new RowWidth();
        List<RowWidth> rowWidthList = new ArrayList<>();
        rowWidthList.add(rowWidth);
        stapes.setRowWidthList(rowWidthList);
        Stretch stretch = new Stretch();
        bridge.getStretchList().add(stretch);
        RowWidthPile rowWidthPile = new RowWidthPile();
        bridge.getPilePileId().getRowWidthPileList().add(rowWidthPile);
        ConcreteRow concreteRow = new ConcreteRow();
        bridge.getSuperstructureSuperstructureId().getConcreteRowList().add(concreteRow);
        SteelRow steelRow = new SteelRow();
        bridge.getSuperstructureSuperstructureId().getSteelRowList().add(steelRow);
        Council council = new Council();
        bridge.getNonStructuralElementsNonStructuralElementsId().getCouncilList().add(council);
        SlabAccess slabAccess = new SlabAccess();
        bridge.getNonStructuralElementsNonStructuralElementsId().getSlabAccessList().add(slabAccess);
        ProtectionWorks protectionWorks = new ProtectionWorks();
        bridge.getNonStructuralElementsNonStructuralElementsId().getProtectionWorksList().add(protectionWorks);
        ImageOther imageOther = new ImageOther();
        bridge.getOtherOtherId().getImageOtherList().add(imageOther);

        Bridge result = bridgeService.save(bridge);
        Bridge expResult = bridge;




        assertEquals(expResult, result);

        assertEquals(new Long(1L), bridge.getStretchList().get(0).getBridgeBridgeId().getBridgeId());

    }

    /**
     * Test of deleteById method, of class BridgeServiceImpl.
     */
    /*@Test
    public void testDeleteById() {

    }*/
    
}
