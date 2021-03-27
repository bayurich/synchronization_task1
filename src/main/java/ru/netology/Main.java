package ru.netology;

public class Main {
    final static Shop shop = new Shop();

    public static void main(String[] args) {

        /* так не работает, дожидается авто только первый покупатель и все. ПОчему?
        for (int i=1; i <=10; i++){
            new Thread(null, shop::buyCar, "Покупатель " + i).start();
        }*/
        //вот так работает
        new BuyerThread(shop).start();

        new MakerThread(shop).start();
    }
}
