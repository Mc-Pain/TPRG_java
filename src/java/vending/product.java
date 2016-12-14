package vending;

public class product {
    private String _name;
    private int _cost;
    private int _numLeft; //сколько осталось

    public product(String _name, int _cost, int _numLeft) { //конструктор
        this._name = _name;
        this._cost = _cost;
        this._numLeft = _numLeft;
    }

    public void changeCost(int newCost) { //приспичило изменить цену
        if (newCost > 0) {
            _cost = newCost;
        }
    }

    public void reload(int number) { //приспичило догрузить продукт
        if (number > 0) {
            _numLeft += number;
        }
    }

    public int decrement() { //продукт минус один
        if (_numLeft > 0) {
            _numLeft--;
        }
        return _numLeft;
    }

    public String getInfo() {
        return String.format("%1$s</br>Цена: %2$d</br>Осталось: %3$d шт.", _name, _cost, _numLeft);
    }

    public String getName() {
        return String.format("%1$s", _name);
    }
    
    public String getCost() {
        return String.format("%1$s", _cost);
    }
    
    public String getLeft() {
        return String.format("%1$s", _numLeft);
    }
}
