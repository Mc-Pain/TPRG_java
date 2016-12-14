package vending;

import java.util.Vector;

public class product_storage {

    public Vector<product> products = new Vector<product>();

    public void delproduct(int productNumber) { //удалить продукт
        products.removeElementAt(productNumber);
    }

    public void addproduct(String _name, int _cost, int _numLeft) { //добавить продукт
        product newproduct = new product(_name, _cost, _numLeft);
        products.add(newproduct);
    }

    public void decproduct(int productNumber) { //минус один продукт
        products.elementAt(productNumber).decrement();
    }

    public product outputproductsum() { //вывод информации обо всех продуктах
        throw new UnsupportedOperationException();
    }
}
