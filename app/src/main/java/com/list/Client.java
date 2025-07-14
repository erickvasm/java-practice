package com.list;

import lombok.Getter;

@Getter
public class Client {
    private String name;
    private int accountNumber;
    private double balance;

    public Client(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

}
