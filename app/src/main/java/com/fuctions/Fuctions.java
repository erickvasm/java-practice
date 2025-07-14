package com.fuctions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Fuctions {

    public static void main(String[] args) {
        System.out.println("Sum: " + biFunctions(5, 2));
        System.out.println("Cast: " + functions("5"));
    }

    static int biFunctions(int numer1, int numer2){
        // Return Integer, get int and int // static method for sum
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        // To use Function a BiFunction, we need to put '.apply'
        return sum.apply(numer1, numer2);
    }

    static int functions(String numer1){
        // Return Integer, get String  // static method for sum
        Function<String, Integer> sum = Integer::parseInt;
        // To use Function a BiFunction, we need to pu '.apply'
        return sum.apply(numer1);
    }
}
