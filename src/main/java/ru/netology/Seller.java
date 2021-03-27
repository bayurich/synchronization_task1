package ru.netology;

public class Seller {

    final int TIME_SELLER_PROCESSING = 2000;
    final int TIME_CAR_MAKING = 5000;

    private Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized Car sellCar() {
        try{
            while (shop.getCars().size() == 0) {
                System.out.println("Машин нет. Покупателю '" + Thread.currentThread().getName() + "' нужно подождать");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " получил сигнал о наличии машины");
            Thread.sleep(TIME_SELLER_PROCESSING);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return shop.getCars().remove(0);
    }


    public synchronized void getCar() {
        try{
            Thread.sleep(TIME_CAR_MAKING);
            Car car = new CarToyota();
            shop.getCars().add(car);
            System.out.println("Производитель '" + Thread.currentThread().getName() + "' выпустил 1 авто: " + car.getBrand());
            notifyAll();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
