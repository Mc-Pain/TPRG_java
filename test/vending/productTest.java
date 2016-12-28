package vending;

import org.junit.*;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vdid1
 */
public class productTest {

    product test;// = new moneyStorage(10);
    int startcost = 10;
    String startname = "test";
    int startnum = 1;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of changeCost method, of class product - positive test
     */
    @Test
    public void testChangeCost_pos() {
        System.out.println("changeCost - pos");
        int newCost = 80;

        try {
            product instance = new product("пыщь!", 50, 5);
            instance.changeCost(newCost);
            assertEquals(80, instance.getCost());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeCost method, of class product - negative test
     */
    @Test
    public void testChangeCost_neg() {
        System.out.println("changeCost - neg");
        int newCost = -80;

        try {
            product instance = new product("пыщь!", 50, 5);
            instance.changeCost(newCost);
            assertEquals(50, instance.getCost());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeCost method, of class product - null test
     */
    @Test
    public void testChangeCost_nul() {
        System.out.println("changeCost - nul");
        int newCost = 0;

        try {
            product instance = new product("пыщь!", 50, 5);
            instance.changeCost(newCost);
            assertEquals(50, instance.getCost());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of reload method, of class product - positive test
     */
    @Test
    public void testReload_pos() {
        System.out.println("reload - pos");
        int amount = 4;

        try {
            product instance = new product("пыщь!", 50, 5);
            int expResult = amount + 5;
            int result = instance.reload(amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of reload method, of class product - null test
     */
    @Test
    public void testReload_nul() {
        System.out.println("reload - pos");
        int amount = 0;

        try {
            product instance = new product("пыщь!", 50, 5);
            int expResult = 5;
            int result = instance.reload(amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of reload method, of class product - negative test
     */
    @Test
    public void testReload_neg() {
        System.out.println("reload - neg");
        int amount = -2;

        try {
            product instance = new product("пыщь!", 50, 5);
            int expResult = 5;
            int result = instance.reload(amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of reload method, of class product - overflow test
     */
    @Test
    public void testReload_ovf() {
        System.out.println("reload - ovf");
        int amount = Integer.MAX_VALUE;

        try {
            product instance = new product("пыщь!", 50, 5);
            int expResult = 5;
            int result = instance.reload(amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of decrement method, of class product.
     */
    @Test
    public void testDecrement() {
        System.out.println("decrement");

        try {
            product instance = new product("пыщь!", 50, 5);
            int expResult = 4;
            int result = instance.decrement();
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
}
