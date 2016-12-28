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
public class vendingMachineTest {

    public vendingMachineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of inputMoney method, of class vendingMachine.
     */
    @Test
    public void testInputMoney_String() {
        System.out.println("inputMoney");
        String aMoney = "";
        vendingMachine instance = new vendingMachine();
        instance.inputMoney(aMoney);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputMoney method, of class vendingMachine.
     */
    @Test
    public void testInputMoney_int() {
        System.out.println("inputMoney");
        int aMoney = 0;
        vendingMachine instance = new vendingMachine();
        instance.inputMoney(aMoney);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of outputMoney method, of class vendingMachine.
     */
    @Test
    public void testOutputMoney() {
        System.out.println("outputMoney");
        vendingMachine instance = new vendingMachine();
        instance.outputMoney();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deliveryTest method, of class vendingMachine.
     */
    @Test
    public void testDeliveryTest() {
        System.out.println("deliveryTest");
        vendingMachine instance = new vendingMachine();
        boolean expResult = false;
        boolean result = instance.deliveryTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deliveryReset method, of class vendingMachine.
     */
    @Test
    public void testDeliveryReset() {
        System.out.println("deliveryReset");
        vendingMachine instance = new vendingMachine();
        instance.deliveryReset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance_str method, of class vendingMachine.
     */
    @Test
    public void testGetBalance_str() {
        System.out.println("getBalance_str");
        vendingMachine instance = new vendingMachine();
        String expResult = "";
        String result = instance.getBalance_str();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class vendingMachine.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String aMessage = "";
        vendingMachine instance = new vendingMachine();
        instance.setMessage(aMessage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class vendingMachine.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        vendingMachine instance = new vendingMachine();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductInfo method, of class vendingMachine.
     */
    @Test
    public void testGetProductInfo() {
        System.out.println("getProductInfo");
        int productNumber = 0;
        vendingMachine instance = new vendingMachine();
        instance.getProductInfo(productNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buyProduct method, of class vendingMachine.
     */
    @Test
    public void testBuyProduct() {
        System.out.println("buyProduct");
        int productNumber = 0;
        vendingMachine instance = new vendingMachine();
        boolean expResult = false;
        boolean result = instance.buyProduct(productNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class vendingMachine.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        int productNumber = 0;
        vendingMachine instance = new vendingMachine();
        instance.deleteProduct(productNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeProduct method, of class vendingMachine.
     */
    @Test
    public void testChangeProduct() {
        System.out.println("changeProduct");
        int productNumber = 0;
        String _name = "";
        int _cost = 0;
        vendingMachine instance = new vendingMachine();
        instance.changeProduct(productNumber, _name, _cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduct method, of class vendingMachine.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        String _name = "test";
        int _cost = 30;
        vendingMachine instance = new vendingMachine();
        try {
            instance.addProduct(_name, _cost);
            
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of reloadProduct method, of class vendingMachine - positive test
     */
    @Test
    public void testReloadProduct_pos() {
        System.out.println("reloadProduct - pos");
        int productNumber = 0;
        int count = 5;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            instance.reloadProduct(productNumber, count);
            assertEquals(count, instance.PStorage.products.elementAt(productNumber).getLeft());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of reloadProduct method, of class vendingMachine - null test
     */
    @Test
    public void testReloadProduct_nul() {
        System.out.println("reloadProduct - nul");
        int productNumber = 0;
        int count = 0;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            instance.reloadProduct(productNumber, count);
            assertEquals(0, instance.PStorage.products.elementAt(productNumber).getLeft());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of reloadProduct method, of class vendingMachine - negatve test
     */
    @Test
    public void testReloadProduct_neg() {
        System.out.println("reloadProduct - neg");
        int productNumber = 0;
        int count = -2;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            instance.reloadProduct(productNumber, count);
            assertEquals(0, instance.PStorage.products.elementAt(productNumber).getLeft());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of reloadProduct method, of class vendingMachine - overflow test
     */
    @Test
    public void testReloadProduct_ovf() {
        System.out.println("reloadProduct - ovf");
        int productNumber = 0;
        int count = Integer.MAX_VALUE;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            instance.reloadProduct(productNumber, count);
            assertEquals(0, instance.PStorage.products.elementAt(productNumber).getLeft());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of reloadProduct method, of class vendingMachine - not exist test
     */
    @Test
    public void testReloadProduct_notexst() {
        System.out.println("reloadProduct - not exist");
        int productNumber = 0;
        int count = 5;

        try {
            vendingMachine instance = new vendingMachine();
            instance.reloadProduct(productNumber, count);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - positive test
     */
    @Test
    public void testInputStorage_pos() {
        System.out.println("inputStorage - pos");
        int aMoney = 500;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(10500, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - null test
     */
    @Test
    public void testInputStorage_nul() {
        System.out.println("inputStorage - nul");
        int aMoney = 0;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - negatve test
     */
    @Test
    public void testInputStorage_neg() {
        System.out.println("inputStorage - neg");
        int aMoney = -500;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - overflow test
     */
    @Test
    public void testInputStorage_ovf() {
        System.out.println("inputStorage - ovf");
        int aMoney = Integer.MAX_VALUE;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - null string test
     */
    @Test
    public void testInputStorage_nulstr() {
        System.out.println("inputStorage - nulstr");
        String aMoney = "";

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - fake string test
     */
    @Test
    public void testInputStorage_fakestr() {
        System.out.println("inputStorage - fakestr");
        String aMoney = "test";

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputStorage method, of class vendingMachine - regular string
     * test
     */
    @Test
    public void testInputStorage_regstr() {
        System.out.println("inputStorage - regstr");
        String aMoney = "1000";

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputStorage(aMoney);
            assertEquals(11000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of unloadStorage method, of class vendingMachine.
     */
    @Test
    public void testUnloadStorage() {
        System.out.println("unloadStorage");
        vendingMachine instance = new vendingMachine();

        try {
            instance.unloadStorage();
            assertEquals(0, instance.getStorageAmount());
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

}
