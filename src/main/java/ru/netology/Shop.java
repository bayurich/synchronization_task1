package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    //  Продавец
    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);

    public Car buyCar(){
        System.out.println("Покупатель '" + Thread.currentThread().getName() + "' зашел в автосалон");
        Car car = sellCar();
        System.out.println("Покупатель '" + Thread.currentThread().getName() + "' уехал на новеньком авто ");

        return car;
    }

    public Car sellCar(){
        return seller.sellCar();
    }

    public void makeCar(){
        seller.getCar();
    }

    public List<Car> getCars() {
        return cars;
    }
}
