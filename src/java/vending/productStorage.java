package vending;

import java.util.Vector;

public class productStorage {

    public Vector<product> products = new Vector<product>();

    public void delProduct(int productNumber) { //удалить продукт
        products.removeElementAt(productNumber);
    }

    public void addProduct(String _name, int _cost, int _numLeft) { //добавить продукт
        product newproduct = new product(_name, _cost, _numLeft);
        products.add(newproduct);
    }

    public void addProduct(String _name, int _cost, int _numLeft, int place) { //добавить продукт
        product newproduct = new product(_name, _cost, _numLeft);
        products.add(place, newproduct);
    }

    public void changeProduct(int productNumber, String _name, int _cost) {
        delProduct(productNumber);
        addProduct(_name, _cost, 0, productNumber);
    }

    public int loadProduct(int productNumber, int amount) {
        return products.elementAt(productNumber).reload(amount);
    }

    public int decProduct(int productNumber) { //минус один продукт
        return products.elementAt(productNumber).decrement();
    }

    public product outputProductSum() { //вывод информации обо всех продуктах
        throw new UnsupportedOperationException();
    }
}
