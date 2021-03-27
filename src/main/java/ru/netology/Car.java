package ru.netology;

public abstract class Car {
    private CarBrands brand;

    public Car(CarBrands brand) {
        this.brand = brand;
    }

    public CarBrands getBrand() {
        return brand;
    }
}
