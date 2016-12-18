package vending;

public class vendingMachine {

    private int tmpMoney; //деньги в автомате
    private int delivery; //сдача
    private String message;
    public productStorage PStorage; //хранилище продуктов
    public moneyStorage MStorage; //хранилище денег

    public vendingMachine() { //конструктор
        message = "";
        tmpMoney = 0;
        PStorage = new productStorage();
        MStorage = new moneyStorage(10000); //в хранилище денег по умолчанию 10к рублей
    }

    public void inputMoney(String aMoney) {
        try {
            int money = Integer.parseInt(aMoney);
            this.inputMoney(money);
        } catch (NumberFormatException e) { // на случай апокалипсиса
            this.inputMoney(0);
            setMessage("Здесь должна ыть шутка про тестировщика в баре");
        }
    }

    public void inputMoney(int aMoney) { //пользователь вводит деньги в автомат
        if (aMoney > 0) {
            tmpMoney += aMoney;
            MStorage.addMoney(aMoney);
            setMessage(String.format("Вы внесли %1$d рублей.", aMoney));
        } else if (aMoney == 0) {
            setMessage("Вы внесли НИЧЕГО. Поздравляем!");
        } else {
            setMessage("Ограбить хотите, да?");
        }
    }

    public void outputMoney() { //получение сдачи
        if (tmpMoney > 0) {
            delivery += tmpMoney;
            MStorage.outputMoney(tmpMoney);
            setMessage(String.format("Заберите сдачу: %1$d рублей", delivery));
            tmpMoney = 0;
        } else if (tmpMoney == 0) {
            setMessage("Вы ничего не внесли");
        } else {
            setMessage("Как можно получить отрицательную сумму?");
        }
    }

    public boolean deliveryTest() { //можно ли получить сдачу?
        if (getStorageAmount() > 1000) {
            return (tmpMoney > 0);
        } else {
            return false;
        }
    }

    public void deliveryReset() { //можно ли получить сдачу?
        setMessage(String.format("Вы забрали: %1$d рублей", delivery));
        delivery = 0;
    }

    public String getBalance_str() { //получение баланса
        return String.format("%1$d", tmpMoney);
    }

    public void setMessage(String aMessage) { //вывод сообщения
        this.message = aMessage;
    }

    public String getMessage() { //вывод сообщения
        return this.message;
    }

    public void getProductInfo(int productNumber) { //получение информации о продукте
        this.setMessage(PStorage.products.elementAt(productNumber).getInfo());
    }

    public boolean buyProduct(int productNumber) { //покупка продукта
        int cost = this.PStorage.products.elementAt(productNumber).getCost();
        if (this.tmpMoney < cost) {
            this.setMessage(String.format("Недостаточно денег.<br/>Стоимость товара: %1$d", cost));
            return false;
        } else {
            PStorage.decProduct(productNumber);
            this.tmpMoney -= cost;
            this.setMessage(String.format("Куплен товар под номером %1$d<br/>Осталось %2$s шт.", productNumber, this.PStorage.products.elementAt(productNumber).getLeft()));
            return true;
        }
    }

    public void deleteProduct(int productNumber) {
        this.setMessage(String.format("Продукт %1$s удален", PStorage.products.elementAt(productNumber).getName()));
        PStorage.delProduct(productNumber);
    }

    public void changeProduct(int productNumber, String _name, int _cost) {
        this.setMessage("Продукт заменён");
        PStorage.changeProduct(productNumber, _name, _cost);
    }

    public void addProduct(String _name, int _cost) { //добавить продукт
        this.setMessage("Продукт добавлен");
        PStorage.addProduct(_name, _cost, 0);
    }

    public void reloadProduct(int productNumber, int count) { //дозагрузка продукта
        PStorage.loadProduct(productNumber, count);
        this.setMessage(String.format("Продукт %1$d загружен<br>Количество: %2$d шт.", productNumber, PStorage.products.elementAt(productNumber).getLeft()));
    }

    public int getStorageAmount() { //получение кол-ва денег в хранилище
        return MStorage.outputMoneySum();
    }

    public void inputStorage(String aMoney) {
        try {
            int money = Integer.parseInt(aMoney);
            this.inputStorage(money);
        } catch (NumberFormatException e) { // на случай апокалипсиса
            this.inputStorage(0);
            setMessage("Здесь должна быть шутка про тестировщика в баре");
        }
    }

    public void inputStorage(int aMoney) { //оператор загружает деньги в хранилище
        if (aMoney > 0) {
            MStorage.addMoney(aMoney);
            setMessage(String.format("Вы загрузили %1$d рублей.", aMoney));
        } else if (aMoney == 0) {
            setMessage("Вы загрузили НИЧЕГО. Поздравляем!");
        } else {
            setMessage("Ограбить хотите, да?");
        }
    }

    public void unloadStorage() { //оператор выгружает всю выручку
        setMessage(String.format("Вы выгрузили %1$d рублей.", MStorage.outputMoneySum()));
        MStorage.outputMoney();
    }
}
