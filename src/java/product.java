public class product {
    private String _name;
    private int _cost;
    private int _numLeft; //сколько осталось
    
    product(String _name, int _cost, int _numLeft){ //конструктор
        this._name=_name;
        this._cost=_cost;
        this._numLeft=_numLeft;
    }
    
    void changeCost(int newCost){ //приспичило изменить цену
        if (newCost > 0){
            _cost=newCost;
        }
    }
    
    void reload(int number){ //приспичило догрузить продукт
        if (number > 0){
            _numLeft+=number;
        }
    }
    
    int decrement(){ //продукт минус один
        if(_numLeft > 0){
            _numLeft--;
        } else {
            Error e = new Error("Товар распродан!");
            throw e;
        }
        return _numLeft;
    }
    
    String getInfo(){
        return String.format("%1$s</br>Цена: %2$d</br>Осталось: %3$d шт.", _name, _cost, _numLeft);
    }
}