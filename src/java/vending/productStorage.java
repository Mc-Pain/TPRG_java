package vending;

import java.util.Vector;

public class productStorage {

    public Vector<product> products = new Vector<product>();

    public boolean delProduct(int productNumber) { //удалить продукт
        if (products.size() > productNumber) { //проверка на null
            products.removeElementAt(productNumber);
            return true;
        } else {
            return false;
        }
    }

    public void addProduct(String _name, int _cost, int _numLeft) { //добавить продукт
        product newproduct = new product(_name, _cost, _numLeft);
        products.add(newproduct);
    }

    public void addProduct(String _name, int _cost, int _numLeft, int place) { //добавить продукт
        product newproduct = new product(_name, _cost, _numLeft);
        products.add(place, newproduct);
    }

    public boolean changeProduct(int productNumber, String _name, int _cost) {
        if (products.size() > productNumber && !_name.equals("") && _cost > 0) {
            delProduct(productNumber);
            addProduct(_name, _cost, 0, productNumber);
            return true;
        } else {
            return false;
        }
    }

    public boolean loadProduct(int productNumber, int amount) {
        if (products.size() > productNumber) {
            return products.elementAt(productNumber).reload(amount);
        } else {
            return false;
        }
    }

    public boolean decProduct(int productNumber) { //минус один продукт
        if (products.size() > productNumber) {
            return products.elementAt(productNumber).decrement();
        } else {
            return false;
        }
    }

    public product outputProductSum() { //вывод информации обо всех продуктах
        throw new UnsupportedOperationException();
    }
}
