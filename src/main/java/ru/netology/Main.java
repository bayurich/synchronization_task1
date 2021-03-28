package ru.netology;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    final static Shop shop = new Shop();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

    public static void main(String[] args) {

        new BuyerThread(shop).start();

        new MakerThread(shop).start();
    }

    public static void log(String mes){
        System.out.println(sdf.format(new Date()) + mes);
    }
}
