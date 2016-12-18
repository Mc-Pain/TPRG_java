package vending;

import java.util.Vector;

public class forwarder { //ненужный класс

    public Vector<product> _unnamed_product_ = new Vector<product>();
    public moneyStorage _unnamed_money_storage_;
    public productStorage _unnamed_product_storage_;

    public void refillMoney(int aRefillMoney) {
        throw new UnsupportedOperationException();
    }

    public void refillProduct(product aRefillproduct) {
        throw new UnsupportedOperationException();
    }

    public boolean getMoney(int aGetmoney) {
        throw new UnsupportedOperationException();
    }

    public void getproduct(product aGetProduct) {
        throw new UnsupportedOperationException();
    }
}
