/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending;

/**
 *
 * @author vdid1
 */
public class Test_vendingMachine {
    vendingMachine test = new vendingMachine();
    
    public void test_unloadStorage()
    {        
        test = new vendingMachine();
        int tmpsum = test.MStorage.outputMoneySum();
        System.out.println("unloadStorage test");

        System.out.println("test 1");
//        System.out.println("");
        try 
        {
            test.unloadStorage();
            if(test.MStorage.outputMoneySum()==tmpsum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

    }
    
    public void test_inputStorage()
    {   
        test = new vendingMachine();
        int tmpsum;
        int input;
        System.out.println("inputStorage test");

        System.out.println("test 1");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test normal input");
        input = 100;
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum+input)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        System.out.println("test 2");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test Integer.MAX_VALUE input");
        input = Integer.MAX_VALUE;
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum+input||
               test.MStorage.outputMoneySum() < 0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 3");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test Integer.MIN_VALUE input");
        input = Integer.MIN_VALUE;
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 4");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test 0 input");
        input = 0;
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 5");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test -10 input");
        input = -10;
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 6");
        String strinput;
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test empty string input");
        strinput = "";
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 7");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test text string input");
        strinput = "lalala";
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 7");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test normal string input");
        strinput = "10";
        try 
        {
            test.inputStorage(input);
            if(test.MStorage.outputMoneySum()!= tmpsum + Integer.parseInt(strinput))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    public void test_reloadProduct()
    {
        test = new vendingMachine();
        System.out.println("reloadProduct test");
        String testname = "test";
        int testcost = 10;
        int testnum = 1;
        int inputnum;
        
        System.out.println("test 1");
        test.PStorage.addProduct(testname, testcost, testnum);
        inputnum = 1;
        System.out.println("test normal input");
        try 
        {
            test.reloadProduct(0, inputnum);
            if(test.PStorage.products.elementAt(0).getLeft()!=testnum+inputnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();

        System.out.println("test 2");
        test.PStorage.addProduct(testname, testcost, testnum);
        inputnum = Integer.MAX_VALUE;
        System.out.println("test Integer.MAX_VALUE input");
        try 
        {
            test.reloadProduct(0, inputnum);
            if(test.PStorage.products.elementAt(0).getLeft()!=testnum+inputnum||
               test.PStorage.products.elementAt(0).getLeft()<0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();

        System.out.println("test 3");
        test.PStorage.addProduct(testname, testcost, testnum);
        inputnum = 0;
        System.out.println("test 0 input");
        try 
        {
            test.reloadProduct(0, inputnum);
            if(test.PStorage.products.elementAt(0).getLeft()!=testnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 4");
        test.PStorage.addProduct(testname, testcost, testnum);
        inputnum = -5;
        System.out.println("test -5 input");
        try 
        {
            test.reloadProduct(0, inputnum);
            if(test.PStorage.products.elementAt(0).getLeft()!=testnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 5");
        test.PStorage.addProduct(testname, testcost, testnum);
        inputnum = Integer.MIN_VALUE;
        System.out.println("test Integer.MIN_VALUE input");
        try 
        {
            test.reloadProduct(0, inputnum);
            if(test.PStorage.products.elementAt(0).getLeft()!=testnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 5");
        test.PStorage.products.clear();
        inputnum = 1;
        System.out.println("test not exist product");
        try 
        {
            test.reloadProduct(0, inputnum);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    public void test_addProduct()
    {
        test = new vendingMachine();
        System.out.println("addProduct test");
        String testname;
        int testcost;
        
        System.out.println("test 1");
        testname = "test";
        testcost = 10;
        test.PStorage.products.clear();
        System.out.println("test normal input");
        try 
        {
            test.addProduct(testname, testcost);
            if(test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 2");
        testname = "test";
        testcost = Integer.MAX_VALUE;
        test.PStorage.products.clear();
        System.out.println("test Integer.MAX_VALUE cost input");
        try 
        {
            test.addProduct(testname, testcost);
            if(test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 3");
        testname = "test";
        testcost = 0;
        test.PStorage.products.clear();
        System.out.println("test 0 cost input");
        try 
        {
            test.addProduct(testname, testcost);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 4");
        testname = "test";
        testcost = -5;
        test.PStorage.products.clear();
        System.out.println("test -5 cost input");
        try 
        {
            test.addProduct(testname, testcost);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();

        System.out.println("test 5");
        testname = "test";
        testcost = Integer.MIN_VALUE;
        test.PStorage.products.clear();
        System.out.println("test Integer.MIN_VALUE cost input");
        try 
        {
            test.addProduct(testname, testcost);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 6");
        testname = "";
        testcost = 10;
        test.PStorage.products.clear();
        System.out.println("test empty name input");
        try 
        {
            test.addProduct(testname, testcost);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
    }
    
    public void test_changeProduct()
    {
        test = new vendingMachine();
        System.out.println("changeProduct test");
        String testname = "test";
        int testcost = 10;
        int testnum = 1;
        String newname;
        int newcost;
        
        System.out.println("test 1");
        test.PStorage.addProduct(testname, testcost, testnum);
        newname = "test2";
        newcost = 20;
        System.out.println("test normal input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(!test.PStorage.products.elementAt(0).getName().equals(newname))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 2");
        test.PStorage.addProduct(testname, testcost, testnum);
        newname = "";
        newcost = 20;
        System.out.println("test empty name input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(test.PStorage.products.elementAt(0).getName().equals(newname))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 3");
        test.PStorage.addProduct(testname, testcost, testnum);
        newname = "test2";
        newcost = 0;
        System.out.println("test 0 cost input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(test.PStorage.products.elementAt(0).getName().equals(newname))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 4");
        test.PStorage.addProduct(testname, testcost, testnum);
        newname = "test2";
        newcost = Integer.MAX_VALUE;
        System.out.println("test Integer.MAX_VALUE cost input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(!test.PStorage.products.elementAt(0).getName().equals(newname))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 5");
        test.PStorage.addProduct(testname, testcost, testnum);
        newname = "test2";
        newcost = Integer.MIN_VALUE;
        System.out.println("test Integer.MIN_VALUE cost input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(test.PStorage.products.elementAt(0).getName().equals(newname))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 6");
        test.PStorage.addProduct(testname, testcost, testnum);
        newname = "test2";
        newcost = -5;
        System.out.println("test -5 cost input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(test.PStorage.products.elementAt(0).getName().equals(newname))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 7");
        newname = "test2";
        newcost = 20;
        System.out.println("test not exist prod input");
        try 
        {
            test.changeProduct(0,newname, newcost);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
    }
    
    public void test_deleteProduct()
    {
        test = new vendingMachine();
        System.out.println("deleteProduct test");
        String testname = "test";
        int testcost = 10;
        int testnum = 1;
        
        System.out.println("test 1");
        test.PStorage.addProduct(testname, testcost, testnum);
        System.out.println("test normal input");
        try 
        {
            test.deleteProduct(0);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 2");
        System.out.println("test not exist product input");
        try 
        {
            test.deleteProduct(0);
            if(!test.PStorage.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
    }
    
    public void test_inputMoney()
    {
        test = new vendingMachine();
        int tmpsum;
        int input;
        System.out.println("inputMoney test");

        System.out.println("test 1");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        input = 100;
        System.out.println("test normal input");
        try 
        {
            test.inputMoney(input);
            if(test.MStorage.outputMoneySum()!= tmpsum+input||
               Integer.parseInt(test.getBalance_str())!=input)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        System.out.println("test 2");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        input = Integer.MAX_VALUE;
        System.out.println("test Integer.MAX_VALUE input");
        try 
        {
            test.inputMoney(input);
            if(test.MStorage.outputMoneySum() < 0||
               Integer.parseInt(test.getBalance_str())!=input||
               Integer.parseInt(test.getBalance_str())<0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 3");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        input = 0;
        System.out.println("test 0 input");
        try 
        {
            test.inputMoney(input);
            if(test.MStorage.outputMoneySum() != tmpsum||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 4");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        input = -10;
        System.out.println("test -10 input");
        try 
        {
            test.inputMoney(input);
            if(test.MStorage.outputMoneySum() != tmpsum||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        System.out.println("test 5");
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        input = Integer.MIN_VALUE;
        System.out.println("test Integer.MIN_VALUE input");
        try 
        {
            test.inputMoney(input);
            if(test.MStorage.outputMoneySum() != tmpsum||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }        
    }
    
    public void test_outputMoney()
    {
        test = new vendingMachine();
        int tmpsum;
        int delivery;
        System.out.println("outputMoney test");
        
        System.out.println("test 1");
        delivery = 100;
        test.inputMoney(delivery);
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test normal input");
        try 
        {
            test.outputMoney();
            if(test.MStorage.outputMoneySum()!= tmpsum-delivery||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 2");
        delivery = Integer.MAX_VALUE;
        test.inputMoney(delivery);
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test MAX_VALUE input");
        try 
        {
            test.outputMoney();
            if(test.MStorage.outputMoneySum()!= tmpsum-delivery||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 3");
        delivery = 0;
        test.inputMoney(delivery);
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test 0 input");
        try 
        {
            test.outputMoney();
            if(test.MStorage.outputMoneySum()!= tmpsum-delivery||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 4");
        delivery = Integer.MIN_VALUE;
        test.inputMoney(delivery);
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test MIN_VALUE input");
        try 
        {
            test.outputMoney();
            if(test.MStorage.outputMoneySum()!= tmpsum||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("test 5");
        delivery = -5;
        test.inputMoney(delivery);
        test.MStorage = new moneyStorage(10000);
        tmpsum = test.MStorage.outputMoneySum();
        System.out.println("test -5 input");
        try 
        {
            test.outputMoney();
            if(test.MStorage.outputMoneySum()!= tmpsum||
               Integer.parseInt(test.getBalance_str())!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }        
    }
    
    public void test_buyProduct()
    {
        test = new vendingMachine();
        int tmpsum;
        int inpmoney;
        String testname = "test";
        int testcost = 100;
        int testnum = 1;
        System.out.println("buyProduct test");
        
        System.out.println("test 1");
        inpmoney = 100;
        test.inputMoney(inpmoney);
        System.out.println("test normal input");
        test.PStorage.addProduct(testname, testcost, testnum);        
        try 
        {
            if(!test.buyProduct(0)||
                Integer.parseInt(test.getBalance_str())!= inpmoney-test.PStorage.products.elementAt(0).getCost()||
                test.PStorage.products.elementAt(0).getLeft() == testnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 2");
        inpmoney = Integer.MAX_VALUE;
        test.inputMoney(inpmoney);
        System.out.println("test Integer.MAX_VALUE input");
        test.PStorage.addProduct(testname, testcost, testnum);        
        try 
        {
            if(!test.buyProduct(0)||
                Integer.parseInt(test.getBalance_str())!= inpmoney-test.PStorage.products.elementAt(0).getCost()||
                test.PStorage.products.elementAt(0).getLeft() == testnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();

        System.out.println("test 3");
        inpmoney = 0;
        test.inputMoney(inpmoney);
        System.out.println("test not enough input");
        test.PStorage.addProduct(testname, testcost, testnum);        
        try 
        {
            if( test.buyProduct(0)||
                Integer.parseInt(test.getBalance_str())== inpmoney-test.PStorage.products.elementAt(0).getCost()||
                test.PStorage.products.elementAt(0).getLeft() != testnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
        
        System.out.println("test 4");
        inpmoney = 10;
        test.inputMoney(inpmoney);
        System.out.println("test prod not exist input");
        try 
        {
            if(!test.buyProduct(0)||
                Integer.parseInt(test.getBalance_str())!= inpmoney)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        test.PStorage.products.clear();
    }
}
