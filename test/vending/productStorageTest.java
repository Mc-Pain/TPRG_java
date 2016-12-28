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
 * @author McPain
 */
public class productStorageTest {

    productStorage test;
    int startcost = 200;
    String startname = "test";
    int startnum = 4;

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
     * Test of delProduct method, of class productStorage
     */
    @Test
    public void testDelProduct() {
        System.out.println("delProduct - delete test");
        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, startnum);
            instance.delProduct(0);
            if (!(instance.products.elementAt(0) == null)){
                fail("Error!");
            }
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of addProduct method, of class productStorage.
     */
    @Test
    public void testAddProduct_3args() {
        System.out.println("addProduct - 3args");
        String _name = "test";
        int _cost = 50;
        int _numLeft = 5;

        try {
            productStorage instance = new productStorage();
            instance.addProduct(_name, _cost, _numLeft);
            instance.addProduct(_name, _cost + 25, _numLeft);
            product newproduct = instance.products.elementAt(1);
            if (newproduct.getCost() != _cost+25){
                fail("Error!");
            }
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of addProduct method, of class productStorage.
     */
    @Test
    public void testAddProduct_4args() {
        System.out.println("addProduct - 4args");
        String _name = "test2";
        int _cost = 45;
        int _numLeft = 7;
        int place = 0;

        try {
            productStorage instance = new productStorage();
            instance.addProduct(_name, _cost, _numLeft);
            instance.addProduct(_name, _cost + 25, _numLeft, place);
            product newproduct = instance.products.elementAt(0);
            if (newproduct.getCost() != _cost+25){
                fail("Error!");
            }
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeProduct method, of class productStorage.
     */
    @Test
    public void testChangeProduct() {
        System.out.println("changeProduct");
        int productNumber = 0;
        String _name = "prod";
        int _cost = 30;

        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, startnum);
            instance.changeProduct(productNumber, _name, _cost);
            product newproduct = instance.products.elementAt(0);
            if (!newproduct.getName().equals(_name) || newproduct.getCost() != _cost){
                fail("Error!");
            }
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of loadProduct method, of class productStorage - postive test
     */
    @Test
    public void testLoadProduct_pos() {
        System.out.println("loadProduct - pos test");
        int productNumber = 0;
        int start = 4;
        int amount = 2;
        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, start);
            int expResult = amount + startnum;
            int result = instance.loadProduct(productNumber, amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of loadProduct method, of class productStorage - null test
     */
    @Test
    public void testLoadProduct_nul() {
        System.out.println("loadProduct - nul test");
        int productNumber = 0;
        int start = 4;
        int amount = 0;
        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, start);
            int expResult = startnum;
            int result = instance.loadProduct(productNumber, amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of loadProduct method, of class productStorage - negative test
     */
    @Test
    public void testLoadProduct_neg() {
        System.out.println("loadProduct - neg test");
        int productNumber = 0;
        int start = 4;
        int amount = -5;
        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, start);
            int expResult = startnum;
            int result = instance.loadProduct(productNumber, amount);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of decProduct method, of class productStorage - positve test
     */
    @Test
    public void testDecProduct_pos() {
        System.out.println("decProduct - pos");
        int productNumber = 0;
        int num = 2;
        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, num);
            int expResult = num - 1;
            int result = instance.decProduct(productNumber);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of decProduct method, of class productStorage - null test
     */
    @Test
    public void testDecProduct_nul() {
        System.out.println("decProduct - nul");
        int productNumber = 0;
        int num = 0;
        try {
            productStorage instance = new productStorage();
            instance.addProduct(startname, startcost, num);
            int expResult = 0;
            int result = instance.decProduct(productNumber);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
}
