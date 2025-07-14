package com.hilos;

import java.util.concurrent.locks.ReentrantLock;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product {

    private String name;
    private int quantityAvailable;
    private final ReentrantLock lock = new ReentrantLock();

    public synchronized void reserve(int quantity) {
        if (quantityAvailable >= quantity) {
            System.out.println("Reserve " + quantity + " of the product " + name);
            quantityAvailable -= quantity;
            System.out.println("Reserve successfully. Available quantity: " + quantityAvailable);
        } else {
            System.out.println("Error: There is not enough available quantity of " + name);
            throw new RuntimeException("Not enough quantity available");
        }
    }

    // INFO: Better option
    public void reserveOptionTwo(int quantity) {
        lock.lock();
        try {
            if (quantityAvailable >= quantity) {
                quantityAvailable -= quantity;
                System.out.println("Reserved " + quantity + " of " + name + ". Remaining: " + quantityAvailable);
            } else {
                System.out.println("Not enough quantity available for " + name + ". Requested: " + quantity + ", Available: " + quantityAvailable);
            }
        } finally {
            lock.unlock();
        }
    }
}
