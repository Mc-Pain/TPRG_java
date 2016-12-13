public class vending_machine {
    private int tmpMoney; //деньги в автомате
    public product_storage PStorage; //хранилище продуктов
    public money_storage MStorage; //хранилище денег
    public boolean console; //консоль управления

    vending_machine(){ //конструктор
        tmpMoney=0;
        console=false;
    }
    
    public void inputMoney(int aMoney) { //пользователь вводит деньги в автомат
        if (aMoney > 0) {
            tmpMoney += aMoney;
            MStorage.addmoney(aMoney);
            outputMessage(String.format("Вы внесли %1$d рублей. </br>Баланс: %2$d рублей", aMoney, tmpMoney));
        } else if(aMoney == 0) {
            outputMessage("Вы внесли НИЧЕГО. Поздравляем!");
        } else {
            outputMessage("Ограбить хотите, да?");
        }
    }

    public void outputMoney() { //получение сдачи
        if (tmpMoney > 0){
            tmpMoney = 0;
        } else if(tmpMoney == 0){
            outputMessage("Вы ничего не внесли");
        } else {
            outputMessage("Как можно получить отрицательную сумму?");
        }
    }

    public void outputMessage(String aMessage) {
        throw new UnsupportedOperationException();
        //TODO: здесь будет фигня, которая выводит что-то на страницу
    }

    public void getProductInfo(int productNumber) { //получение информации о продукте
        outputMessage(PStorage.products.elementAt(productNumber).getInfo());
    }
    
    public void buyProduct(int productNumber) {
        try {
            PStorage.decproduct(productNumber);
        } catch (Error e){
            outputMessage(e.getMessage());
        }
    }
}