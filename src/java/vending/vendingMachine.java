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
            setMessage("Здесь должна быть шутка про тестировщика в баре");
        }
    }

    public void inputMoney(int aMoney) { //пользователь вводит деньги в автомат
        if (aMoney > 0) {
            if (Integer.MAX_VALUE - aMoney > tmpMoney) {
                if (Integer.MAX_VALUE - aMoney > MStorage.outputMoneySum()) {
                    tmpMoney += aMoney;
                    MStorage.addMoney(aMoney);
                    setMessage(String.format("Вы внесли %1$d рублей.", aMoney));
                } else {
                    setMessage("Переполнение хранилища");
                }
            } else {
                setMessage("Переполнение введенных денег");
            }
        } else if (aMoney == 0) {
            setMessage("Вы внесли НИЧЕГО. Поздравляем!");
        } else {
            setMessage("Ограбить хотите, да?");
        }
    }

    public void outputMoney() { //получение сдачи
        if (tmpMoney > 0) { //в автомате есть деньги
            if (Integer.MAX_VALUE - tmpMoney > delivery) {
                delivery += tmpMoney;
                if (MStorage.outputMoney(tmpMoney)) { //денег хватило на сдачу
                    setMessage(String.format("Заберите сдачу: %1$d рублей", delivery));
                    tmpMoney = 0;
                } else {
                    setMessage("Нет сдачи");
                }
            } else {
                setMessage("Ошибка переполнения сдачи");
            }
        } else if (tmpMoney == 0) {
            setMessage("Вы ничего не внесли");
        } else {
            setMessage("Как можно получить отрицательную сумму?");
        }
    }

    public boolean deliveryTest() { //можно ли получить сдачу?
        if (getStorageAmount() > 1000 && getStorageAmount() > tmpMoney) {
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
        if (this.PStorage.products.size() > productNumber) {
            int cost = this.PStorage.products.elementAt(productNumber).getCost();
            if (this.PStorage.products.elementAt(productNumber).getLeft() > 0) { //проверка на распроданность
                if (this.tmpMoney < cost) { //хватает ли денег?
                    this.setMessage(String.format("Недостаточно денег.<br/>Стоимость товара: %1$d", cost));
                    return false;
                } else { //да, хватает
                    PStorage.decProduct(productNumber);
                    this.tmpMoney -= cost;
                    this.setMessage(String.format("Куплен товар под номером %1$d<br/>Осталось %2$s шт.", productNumber, this.PStorage.products.elementAt(productNumber).getLeft()));
                    return true;
                }
            } else {
                this.setMessage(String.format("Товар под номером %1$d распродан.", productNumber));
                return false;
            }
        } else {
            this.setMessage(String.format("Выбранного товара не существует"));
            return false;
        }
    }

    public boolean deleteProduct(int productNumber) {
        if (PStorage.delProduct(productNumber)) {
            this.setMessage(String.format("Продукт %1$s удален", productNumber));
            return true;
        } else {
            this.setMessage("Не удалось удалить продукт");
            return false;
        }
    }

    public boolean changeProduct(int productNumber, String _name, int _cost) {
        if (PStorage.changeProduct(productNumber, _name, _cost)) {
            this.setMessage("Продукт заменён");
            return true;
        } else {
            this.setMessage("Не удалось заменить продукт");
            return false;
        }
    }

    public boolean addProduct(String _name, int _cost) { //добавить продукт
        if (_cost > 0 && !_name.equals("")) {
            this.setMessage("Продукт добавлен");
            PStorage.addProduct(_name, _cost, 0);
            return true;
        } else {
            this.setMessage("Неверные данные");
            return false;
        }
    }

    public boolean reloadProduct(int productNumber, int count) { //дозагрузка продукта
        if (PStorage.loadProduct(productNumber, count)) {
            this.setMessage(String.format("Продукт %1$d загружен<br>Количество: %2$d шт.", productNumber, PStorage.products.elementAt(productNumber).getLeft()));
            return true;
        } else {
            this.setMessage(String.format("Продукт не загружен"));
            return false;
        }
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

            if (Integer.MAX_VALUE - aMoney > MStorage.outputMoneySum()) {
                MStorage.addMoney(aMoney);
                setMessage(String.format("Вы загрузили %1$d рублей.", aMoney));
            } else {
                setMessage("Хранилище переполнено");
            }
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
