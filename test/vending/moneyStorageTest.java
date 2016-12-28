package vending;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author vdid1
 */
public class moneyStorageTest {
    moneyStorage test;// = new moneyStorage(10);
    int startmoney = 10;

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
     * Test of addMoney method, of class moneyStorage - null money
     */
    @Test
    public void testAddMoney_null() {
        System.out.println("addMoney - null test");
        int aAddMoney = 0;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.addMoney(aAddMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
     /**
     * Test of addMoney method, of class moneyStorage - negative test
     */
    @Test
    public void testAddMoney_negative() {
        System.out.println("addMoney - negative test");
        int aAddMoney = -50;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.addMoney(aAddMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of addMoney method, of class moneyStorage - positive test
     */
    @Test
    public void testAddMoney_positive() {
        System.out.println("addMoney - positive test");
        int aAddMoney = 50;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.addMoney(aAddMoney);
            assertEquals(10050, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }

    /**
     * Test of addMoney method, of class moneyStorage - overflow test
     */
    @Test
    public void testAddMoney_overflow() {
        System.out.println("addMoney - overflow test");
        int aAddMoney = Integer.MAX_VALUE;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.addMoney(aAddMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of addMoney method, of class moneyStorage - underflow test
     */
    @Test
    public void testAddMoney_underflow() {
        System.out.println("addMoney - underflow test");
        int aAddMoney = Integer.MIN_VALUE;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.addMoney(aAddMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }

    /**
     * Test of outputMoney method, of class moneyStorage - null money
     */
    @Test
    public void testOutputMoney_nullint() {
        System.out.println("outputMoney - null test");
        int aOutMoney = 0;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney(aOutMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of outputMoney method, of class moneyStorage - negatve test
     */
    @Test
    public void testOutputMoney_negtest() {
        System.out.println("outputMoney - negative test");
        int aOutMoney = -50;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney(aOutMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of outputMoney method, of class moneyStorage - positive test
     */
    @Test
    public void testOutputMoney_postest() {
        System.out.println("outputMoney - positive test");
        int aOutMoney = +50;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney(aOutMoney);
            assertEquals(9950, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of outputMoney method, of class moneyStorage - negatve overflow
     */
    @Test
    public void testOutputMoney_negovf() {
        System.out.println("outputMoney - underflow test");
        int aOutMoney = Integer.MIN_VALUE;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney(aOutMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of outputMoney method, of class moneyStorage - positive overflow
     */
    @Test
    public void testOutputMoney_posovf() {
        System.out.println("outputMoney - overflow test");
        int aOutMoney = Integer.MAX_VALUE;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney(aOutMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    /**
     * Test of outputMoney method, of class moneyStorage - overdraft
     */
    @Test
    public void testOutputMoney_overdraft() {
        System.out.println("outputMoney - overdraft test");
        int aOutMoney = 20000;
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney(aOutMoney);
            assertEquals(10000, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }

    /**
     * Test of outputMoney method, of class moneyStorage.
     */
    @Test
    public void testOutputMoney_0args() {
        System.out.println("outputMoney - 0args");
        moneyStorage instance = new moneyStorage(10000);
        
        try{
            instance.outputMoney();
            assertEquals(0, instance.outputMoneySum());
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
}