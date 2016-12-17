package vending;

public class vending_machine {
    private int tmpMoney; //деньги в автомате
    private int delivery; //сдача
    private String message;
    public product_storage PStorage; //хранилище продуктов
    public money_storage MStorage; //хранилище денег
    public boolean console; //консоль управления

    public vending_machine() { //конструктор
        message = "";
        tmpMoney = 0;
        console = false;
        PStorage = new product_storage();
        MStorage = new money_storage(10000); //в хранилище денег по умолчанию 10к рублей
    }
    
    public void inputMoney(String aMoney){
        try{
            int money=0;
            money=Integer.parseInt(aMoney);
            this.inputMoney(money);
        } catch (NumberFormatException e){ // на случай апокалипсиса
            this.inputMoney(0);
            setMessage("Здесь должна ыть шутка про тестировщика в баре");
        }
    }

    public void inputMoney(int aMoney) { //пользователь вводит деньги в автомат
        if (aMoney > 0) {
            tmpMoney += aMoney;
            MStorage.addmoney(aMoney);
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
            setMessage(String.format("Заберите сдачу: %1$d рублей", delivery));
            tmpMoney = 0;
        } else if (tmpMoney == 0) {
            setMessage("Вы ничего не внесли");
        } else {
            setMessage("Как можно получить отрицательную сумму?");
        }
    }
    
    public boolean deliveryTest(){ //можно ли получить сдачу?
        return (tmpMoney > 0);
    }
    
    public void deliveryReset(){ //можно ли получить сдачу?
        setMessage(String.format("Вы забрали: %1$d рублей", delivery));
        delivery=0;
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
        if (this.tmpMoney < cost){
            this.setMessage(String.format("Недостаточно денег.<br/>Стоимость товара: %1$d", cost));            
            return false;
        } else {
            PStorage.decproduct(productNumber);
            this.tmpMoney-=cost;
            this.setMessage(String.format("Куплен товар под номером %1$d<br/>Осталось %2$s шт.", productNumber, this.PStorage.products.elementAt(productNumber).getLeft()));
            return true;
        }
    }
}
