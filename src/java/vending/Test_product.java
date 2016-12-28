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
public class Test_product {
    product test;// = new moneyStorage(10);
    int startcost = 10;
    String startname = "test";
    int startnum = 1;
    public void test_changeCost()
    {
        int newcost;
        System.out.println("changeCost test");
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 1");
        System.out.println("new cost 20");
        newcost = 20;
        try 
        {
            test.changeCost(newcost);
            if(test.getCost()!=newcost)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 2");
        System.out.println("new cost 0");
        newcost = 0;
        try 
        {
            test.changeCost(newcost);
            if(test.getCost()==newcost)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 3");
        System.out.println("new cost -20");
        newcost = -20;
        try 
        {
            test.changeCost(newcost);
            if(test.getCost()!=startcost)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 4");
        System.out.println("new cost Integer.MAX_VALUE");
        newcost = Integer.MAX_VALUE;
        try 
        {
            test.changeCost(newcost);
            if(test.getCost()!=newcost)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test = new product(startname,startcost,startnum);
        System.out.println("test 5");
        System.out.println("new cost Integer.MIN_VALUE");
        newcost = Integer.MIN_VALUE;
        try 
        {
            test.changeCost(newcost);
            if(test.getCost()!=startcost)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }        
    }
    
    public void test_reload()
    {
        int loadnum;
        System.out.println("reload test");
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 1");
        System.out.println("load 10");
        loadnum = 10;
        try 
        {
            test.reload(loadnum);
            if(test.getLeft()!=startnum+loadnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 2");
        System.out.println("load -10");
        loadnum = -10;
        try 
        {
            test.reload(loadnum);
            if(test.getLeft()!=startnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 3");
        System.out.println("load 0");
        loadnum = 0;
        try 
        {
            test.reload(loadnum);
            if(test.getLeft()!=startnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 4");
        System.out.println("load Integer.MAX_VALUE");
        loadnum = Integer.MAX_VALUE;
        try 
        {
            test.reload(loadnum);
            if(test.getLeft()<0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,startnum);
        System.out.println("test 5");
        System.out.println("load Integer.MIN_VALUE");
        loadnum = Integer.MIN_VALUE;
        try 
        {
            test.reload(loadnum);
            if(test.getLeft()!=startnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    public void test_decrement()
    {
        System.out.println("decrement test");
        
        test = new product(startname,startcost,1);
        System.out.println("test 1");
        System.out.println("product num = 1");
        try 
        {
            if(test.decrement()!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        System.out.println("decrement test");
        
        test = new product(startname,startcost,0);
        System.out.println("test 2");
        System.out.println("product num = 0");
        try 
        {
            if(test.decrement()!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test = new product(startname,startcost,Integer.MAX_VALUE);
        System.out.println("test 3");
        System.out.println("product num = Integer.MAX_VALUE");
        try 
        {
            if(test.decrement()!=(Integer.MAX_VALUE-1))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
    }
}
