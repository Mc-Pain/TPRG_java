package vending;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vending.*;


/**
 *
 * @author vdid1
 */
public class moneyStorageTest {
    moneyStorage test;// = new moneyStorage(10);
    int startmoney = 10;
    public void addMoneyTest()
    {
        int addmoney;
        System.out.println("addMoney test");
        
        test = new moneyStorage(startmoney);
        System.out.println("test 1");
        System.out.println("add 20");
        addmoney = 20;
        try 
        {
            test.addMoney(addmoney);
            if(test.outputMoneySum()!=addmoney+startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 2");
        System.out.println("add 0");
        addmoney = 0;
        try 
        {
            test.addMoney(addmoney);
            if(test.outputMoneySum()!=startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 3");
        System.out.println("add -10");
        addmoney = -10;
        try 
        {
            test.addMoney(addmoney);
            if(test.outputMoneySum()!=startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 4");
        System.out.println("add Integer.MAX_VALUE");
        addmoney = Integer.MAX_VALUE;
        try 
        {
            test.addMoney(addmoney);
            if(test.outputMoneySum()<startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 5");
        System.out.println("add Integer.MIN_VALUE");
        addmoney = Integer.MIN_VALUE;
        try 
        {
            test.addMoney(addmoney);
            if(test.outputMoneySum()!=startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
   
    public void outputMoneyTest()
    {
        int outmoney;
        System.out.println("outputMoney test");
        
        test = new moneyStorage(startmoney);
        System.out.println("test 1");
        System.out.println("output 0");
        outmoney = 0;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 2");
        System.out.println("output 10");
        outmoney = 10;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != startmoney - outmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 3");
        System.out.println("output 5");
        outmoney = 5;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != startmoney - outmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 4");
        System.out.println("output 20");
        outmoney = 20;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != 0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 5");
        System.out.println("output -10");
        outmoney = -10;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 6");
        System.out.println("output Integer.MAX_VALUE");
        outmoney = Integer.MAX_VALUE;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != 0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 7");
        System.out.println("output Integer.MIN_VALUE");
        outmoney = Integer.MIN_VALUE;
        try 
        {
            test.outputMoney(outmoney);
            if(test.outputMoneySum() != startmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new moneyStorage(startmoney);
        System.out.println("test 7");
        System.out.println("output all");
        int res;
        try 
        {
            res = test.outputMoney();
            if (res != startmoney || test.outputMoneySum() != 0) 
                System.out.println("error");    
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
}