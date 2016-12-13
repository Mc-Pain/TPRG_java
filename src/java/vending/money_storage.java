package vending;

public class money_storage {

    private int _money;

    money_storage(int money) {
        if (money >= 0) {
            this._money = money;
        } else {
            this._money = 0;
        }
    }

    public void addmoney(int aAddMoney) { //загрузка денег
        if (aAddMoney > 0) {
            _money += aAddMoney;
        }
    }

    public void outputmoney(int aOutMoney) { //выгрузка денег (?)
        if (aOutMoney > 0) {
            if (aOutMoney > _money) { //денег не хватило
                _money = 0;
            } else {
                _money -= aOutMoney;
            }
        }
    }

    public int outputmoneysum() { //кол-во денег в хранилище
        return _money;
    }
}
