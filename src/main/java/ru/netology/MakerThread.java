package ru.netology;

public class MakerThread extends Thread {

    final int TIME_MAKERS_GAP = 1000;
    final int COUNT_MAKERS = 10;

    Shop shop;

    public MakerThread(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i=1; i <= COUNT_MAKERS; i++){
            try {
                Thread.sleep(TIME_MAKERS_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(null, shop::makeCar, "Производитель " + CarBrands.Toyota.name()).start();
        }
    }
}
