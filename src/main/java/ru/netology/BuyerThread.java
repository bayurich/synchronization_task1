package ru.netology;

import java.util.Random;

public class BuyerThread extends Thread {

    final int TIME_BUYERS_GAP = 2000;
    final int COUNT_BUYERS = 12;

    Shop shop;

    public BuyerThread(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i=1; i <= COUNT_BUYERS; i++){
            try {
                Thread.sleep(TIME_BUYERS_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(null, shop::buyCar, "Покупатель " + i).start();
        }
    }
}
