package vending;

public class moneyStorage {

    private int _money;

    moneyStorage(int money) {
        if (money >= 0) {
            this._money = money;
        } else {
            this._money = 0;
        }
    }

    public void addMoney(int aAddMoney) { //загрузка денег
        if (aAddMoney > 0) {
            _money += aAddMoney;
        }
    }

    public void outputMoney(int aOutMoney) { //выгрузка денег
        if (aOutMoney > 0) {
            if (aOutMoney > _money) { //денег не хватило
                _money = 0;
            } else {
                _money -= aOutMoney;
            }
        }
    }

    public int outputMoney() { //выгрузка всех денег
        if (_money > 0) {
            int temp = _money;
            _money = 0;
            return temp;
        } else {
            return 0;
        }
    }

    public int outputMoneySum() { //кол-во денег в хранилище
        return _money;
    }
}
