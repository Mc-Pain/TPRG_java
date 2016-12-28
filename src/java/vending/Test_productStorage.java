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
public class Test_productStorage {
    productStorage test;
    int startcost = 10;
    String startname = "test";
    int startnum = 1;
    public void test_addProduct()
    {
        System.out.println("addProduct test");

        test.products.clear();
        System.out.println("test 1");
        System.out.println("test normal add product");
        try 
        {
            test.addProduct(startname, startcost, startnum);
            if(test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 2");
        System.out.println("test with startnum = 0");
        try 
        {
            test.addProduct(startname, startcost, 0);
            if(test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 3");
        System.out.println("test with startnum = -1");
        try 
        {
            test.addProduct(startname, startcost, -1);
            if(test.products.isEmpty()||test.products.elementAt(0).getLeft()!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 4");
        System.out.println("test with startnum = Integer.MAX_VALUE");
        try 
        {
            test.addProduct(startname, startcost, Integer.MAX_VALUE);
            if(test.products.isEmpty()||test.products.elementAt(0).getLeft()!=Integer.MAX_VALUE)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 4");
        System.out.println("test with startnum = Integer.MIN_VALUE");
        try 
        {
            test.addProduct(startname, startcost, Integer.MIN_VALUE);
            if(test.products.isEmpty()||test.products.elementAt(0).getLeft()!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        System.out.println("addProduct test");
//==============================================================================
        test.products.clear();
        System.out.println("test 6");
        System.out.println("test with startcost = 0");
        try 
        {
            test.addProduct(startname, 0, startnum);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 7");
        System.out.println("test with startcost = -1");
        try 
        {
            test.addProduct(startname, -1, startnum);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 8");
        System.out.println("test with startcost = Integer.MAX_VALUE");
        try 
        {
            test.addProduct(startname, Integer.MAX_VALUE, startnum);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getCost()!=Integer.MAX_VALUE)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 9");
        System.out.println("test with startcost = Integer.MIN_VALUE");
        try 
        {
            test.addProduct(startname, Integer.MIN_VALUE, startnum);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
//==============================================================================
        test.products.clear();
        System.out.println("test 9");
        System.out.println("test with startname = ");
        try 
        {
            test.addProduct("", startcost, startnum);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 10");
        System.out.println("addprod up to another");
        try 
        {
            test.addProduct("test2", 20, 20, 1);
            if(!startname.equals(test.products.elementAt(0).getName())
               ||!"test2".equals(test.products.elementAt(1).getName()))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 11");
        System.out.println("addprod to -1 pos");
        try 
        {
            test.addProduct(startname, startcost, startnum, -1);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    public void test_delProduct()
    {
        System.out.println("decProduct test");

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 1");
        System.out.println("test normal del product");
        try 
        {
            test.decProduct(0);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 2");
        System.out.println("test del not exist product");
        try 
        {
            test.delProduct(0);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    public void test_changeProduct()
    {
        System.out.println("changeProduct test");

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 1");
        System.out.println("test normal add product");
        try 
        {
            test.changeProduct(0, "test2", startnum);
            if(test.products.isEmpty()||
              !test.products.elementAt(0).getName().equals("test2"))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        System.out.println("test 2");
        System.out.println("test change prod at empty vector");
        try 
        {
            test.changeProduct(0, "test2", startnum);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }

    public void test_loadProduct()
    {
        System.out.println("loadProduct test");
        int loaded;

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 1");
        System.out.println("test normal load product");
        loaded = 1;
        try 
        {
            test.loadProduct(0, loaded);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!= startnum+loaded)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 2");
        System.out.println("test load 0");
        loaded = 0;
        try 
        {
            test.loadProduct(0, loaded);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!= startnum+loaded)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 3");
        System.out.println("test load -1");
        loaded = -1;
        try 
        {
            test.loadProduct(0, loaded);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!= startnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 4");
        System.out.println("test load Integer.MAX_VALUE");
        loaded = Integer.MAX_VALUE;
        try 
        {
            test.loadProduct(0, loaded);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!= startnum+loaded ||
               test.products.elementAt(0).getLeft()<0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 5");
        System.out.println("test load Integer.MIN_VALUE");
        loaded = Integer.MIN_VALUE;
        try 
        {
            test.loadProduct(0, loaded);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!= startnum)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
//==============================================================================
        test.products.clear();
        System.out.println("test 6");
        System.out.println("test normal load not exist product");
        loaded = 1;
        try 
        {
            test.loadProduct(0, loaded);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
    
    public void test_decProduct()
    {
        System.out.println("decProduct test");
        
        test.products.clear();
        test.addProduct(startname, startcost, startnum);
        System.out.println("test 1");
        System.out.println("test normal dec product");
        try 
        {
            test.decProduct(0);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test.products.clear();
        System.out.println("test 2");
        System.out.println("test dec not exist product");
        try 
        {
            test.decProduct(0);
            if(!test.products.isEmpty())
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        test.addProduct(startname, startcost, 0);
        System.out.println("test 3");
        System.out.println("test dec product num = 0");
        try 
        {
            test.decProduct(0);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!=0)
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }

        test.products.clear();
        test.addProduct(startname, startcost, Integer.MAX_VALUE);
        System.out.println("test 4");
        System.out.println("test dec product num = Integer.MAX_VALUE");
        try 
        {
            test.decProduct(0);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!=(Integer.MAX_VALUE-1))
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
        
        test.products.clear();
        test.addProduct(startname, startcost, -5);
        System.out.println("test 5");
        System.out.println("test dec product num = -n");
        try 
        {
            test.decProduct(0);
            if(test.products.isEmpty()||
               test.products.elementAt(0).getLeft()!=0  )
                System.out.println("error");
            else System.out.println("success");
        }
        catch (Exception a)
        {
            System.out.println("catch error");
        }
    }
}
