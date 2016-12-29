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
     * Test of inputMoney method, of class vendingMachine - positive test
     */
    @Test
    public void testInputMoney_pos() {
        System.out.println("inputMoney - pos");
        int aMoney = 500;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(10500, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputMoney method, of class vendingMachine - null test
     */
    @Test
    public void testInputMoney_nul() {
        System.out.println("inputMoney - nul");
        int aMoney = 0;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputMoney method, of class vendingMachine - negatve test
     */
    @Test
    public void testInputMoney_neg() {
        System.out.println("inputMoney - neg");
        int aMoney = -500;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputMoney method, of class vendingMachine - overflow test
     */
    @Test
    public void testInputMoney_ovf() {
        System.out.println("inputMoney - ovf");
        int aMoney = Integer.MAX_VALUE;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputMoney method, of class vendingMachine - null string test
     */
    @Test
    public void testInputMoney_nulstr() {
        System.out.println("inputMoney - nulstr");
        String aMoney = "";

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputMoney method, of class vendingMachine - fake string test
     */
    @Test
    public void testInputMoney_fakestr() {
        System.out.println("inputMoney - fakestr");
        String aMoney = "test";

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(10000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of inputMoney method, of class vendingMachine - regular string
     * test
     */
    @Test
    public void testInputMoney_regstr() {
        System.out.println("inputMoney - regstr");
        String aMoney = "1000";

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(aMoney);
            assertEquals(11000, instance.getStorageAmount());

        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of outputMoney method, of class vendingMachine - positive test
     */
    @Test
    public void testOutputMoney_pos() {
        System.out.println("outputMoney - positive");
        int tmp_money = 100;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(tmp_money);
            instance.outputMoney();
            int expResultStorage = 10000;
            int resultStorage = instance.getStorageAmount();
            assertEquals(expResultStorage, resultStorage);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of outputMoney method, of class vendingMachine - null test
     */
    @Test
    public void testOutputMoney_nul() {
        System.out.println("outputMoney - null");
        int tmp_money = 0;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(tmp_money);
            instance.outputMoney();
            int expResultStorage = 10000;
            int resultStorage = instance.getStorageAmount();
            assertEquals(expResultStorage, resultStorage);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of outputMoney method, of class vendingMachine - negative test
     */
    @Test
    public void testOutputMoney_neg() {
        System.out.println("outputMoney - negative");
        int tmp_money = -100;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(tmp_money);
            instance.outputMoney();
            int expResultStorage = 10000;
            int resultStorage = instance.getStorageAmount();
            assertEquals(expResultStorage, resultStorage);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }
    
    /**
     * Test of outputMoney method, of class vendingMachine - overflow test
     */
    @Test
    public void testOutputMoney_ovf() {
        System.out.println("outputMoney - overflow");
        int tmp_money = 15000;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(tmp_money);
            instance.outputMoney();
            int expResultStorage = 10000;
            int resultStorage = instance.getStorageAmount();
            assertEquals(expResultStorage, resultStorage);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of buyProduct method, of class vendingMachine - normal test
     */
    @Test
    public void testBuyProduct_normal() {
        System.out.println("buyProduct - normal");
        int productNumber = 0;
        int inpMoney = 100;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            instance.reloadProduct(productNumber, 5);
            instance.inputMoney(inpMoney);
            boolean expResult = true;
            boolean result = instance.buyProduct(productNumber);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of buyProduct method, of class vendingMachine - product is sold
     */
    @Test
    public void testBuyProduct_sold() {
        System.out.println("buyProduct - sold");
        int productNumber = 0;
        int inpMoney = 100;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            instance.inputMoney(inpMoney);
            boolean expResult = false;
            boolean result = instance.buyProduct(productNumber);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of buyProduct method, of class vendingMachine - too expensive
     */
    @Test
    public void testBuyProduct_notenough() {
        System.out.println("buyProduct - not enough");
        int productNumber = 0;
        int inpMoney = 100;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 200);
            instance.inputMoney(inpMoney);
            boolean expResult = false;
            boolean result = instance.buyProduct(productNumber);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of buyProduct method, of class vendingMachine - product is null
     */
    @Test
    public void testBuyProduct_null() {
        System.out.println("buyProduct - null");
        int productNumber = 0;
        int inpMoney = 100;

        try {
            vendingMachine instance = new vendingMachine();
            instance.inputMoney(inpMoney);
            boolean expResult = false;
            boolean result = instance.buyProduct(productNumber);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of deleteProduct method, of class vendingMachine - exist
     */
    @Test
    public void testDeleteProduct_exist() {
        System.out.println("deleteProduct - exist");
        int productNumber = 0;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            boolean expResult = true;
            boolean result = instance.deleteProduct(productNumber);
            assertEquals (expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of deleteProduct method, of class vendingMachine - not exist
     */
    @Test
    public void testDeleteProduct_notexist() {
        System.out.println("deleteProduct - not exist");
        int productNumber = 0;

        try {
            vendingMachine instance = new vendingMachine();
            boolean expResult = false;
            boolean result = instance.deleteProduct(productNumber);
            assertEquals (expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeProduct method, of class vendingMachine - normal test
     */
    @Test
    public void testChangeProduct_normal() {
        System.out.println("changeProduct - normal");
        int productNumber = 0;
        String _name = "newtest";
        int _cost = 80;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            boolean expResult = true;
            boolean result = instance.changeProduct(productNumber, _name, _cost);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeProduct method, of class vendingMachine - null cost
     */
    @Test
    public void testChangeProduct_nullcost() {
        System.out.println("changeProduct - nullcost");
        int productNumber = 0;
        String _name = "newtest";
        int _cost = 0;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            boolean expResult = false;
            boolean result = instance.changeProduct(productNumber, _name, _cost);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeProduct method, of class vendingMachine - negatve cost
     */
    @Test
    public void testChangeProduct_negcost() {
        System.out.println("changeProduct - nullcost");
        int productNumber = 0;
        String _name = "newtest";
        int _cost = -40;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            boolean expResult = false;
            boolean result = instance.changeProduct(productNumber, _name, _cost);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeProduct method, of class vendingMachine - null string
     */
    @Test
    public void testChangeProduct_nullstr() {
        System.out.println("changeProduct - nullcost");
        int productNumber = 0;
        String _name = "";
        int _cost = 80;

        try {
            vendingMachine instance = new vendingMachine();
            instance.addProduct("test", 50);
            boolean expResult = false;
            boolean result = instance.changeProduct(productNumber, _name, _cost);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of changeProduct method, of class vendingMachine - not exist
     */
    @Test
    public void testChangeProduct_notexist() {
        System.out.println("changeProduct - not exist");
        int productNumber = 0;
        String _name = "newtest";
        int _cost = 0;

        try {
            vendingMachine instance = new vendingMachine();
            boolean expResult = false;
            boolean result = instance.changeProduct(productNumber, _name, _cost);
            assertEquals(expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of addProduct method, of class vendingMachine - normal input
     */
    @Test
    public void testAddProduct_pos() {
        System.out.println("addProduct - pos");
        String _name = "test";
        int _cost = 30;
        vendingMachine instance = new vendingMachine();
        try {
            boolean result = instance.addProduct(_name, _cost);
            boolean expResult = true;
            assertEquals (expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of addProduct method, of class vendingMachine - null test
     */
    @Test
    public void testAddProduct_nul() {
        System.out.println("addProduct - nul");
        String _name = "test";
        int _cost = 0;
        vendingMachine instance = new vendingMachine();
        try {
            boolean result = instance.addProduct(_name, _cost);
            boolean expResult = false;
            assertEquals (expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of addProduct method, of class vendingMachine - negative test
     */
    @Test
    public void testAddProduct_neg() {
        System.out.println("addProduct - neg");
        String _name = "test";
        int _cost = -30;
        vendingMachine instance = new vendingMachine();
        try {
            boolean result = instance.addProduct(_name, _cost);
            boolean expResult = false;
            assertEquals (expResult, result);
        } catch (Exception a) {
            fail(a.getMessage());
        }
    }

    /**
     * Test of addProduct method, of class vendingMachine - null string test
     */
    @Test
    public void testAddProduct_nulstr() {
        System.out.println("addProduct - nulstr");
        String _name = "";
        int _cost = 50;
        vendingMachine instance = new vendingMachine();
        try {
            boolean result = instance.addProduct(_name, _cost);
            boolean expResult = false;
            assertEquals (expResult, result);
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
            boolean result = instance.reloadProduct(productNumber, count);
            boolean expResult = true;
            assertEquals(expResult, result);
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
            boolean result = instance.reloadProduct(productNumber, count);
            boolean expResult = false;
            assertEquals(expResult, result);
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
            boolean result = instance.reloadProduct(productNumber, count);
            boolean expResult = false;
            assertEquals(expResult, result);
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
            boolean result = instance.reloadProduct(productNumber, count);
            boolean expResult = false;
            assertEquals(expResult, result);
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
            boolean result = instance.reloadProduct(productNumber, count);
            boolean expResult = false;
            assertEquals(expResult, result);
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
