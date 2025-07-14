package com.hilos;

public class Users extends Thread {

    public static void main(String[] args) {
        Product rice = new Product("Arroz", 10);

        //  Lambda
        new Thread(() -> rice.reserve(5)).start();

        // No Lambda
        new Thread(() -> {
            rice.reserveOptionTwo(5);
        }).start();

        new Thread(() -> rice.reserve(1)).start();
    }
}
