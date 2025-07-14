package com.udemy.cadenas;

import java.util.Scanner;

/**
 * La tarea consiste en crear una nueva clase con el método main llamada DetalleDeFactura, se requiere desarrollar
 * un programa que reciba datos de la factura utilizando la clase Scanner de la siguiente manera:
 * Reciba el nombre de la factura o descripción, utilizar método nextLine() para obtener el nombre de la factura
 * con espacios.
 * Reciba 2 precios de productos de tipo double, utilizar método nextDouble() para obtener precios con decimales
 * (,). Calcule el total, sume ambos precios y agregue un valor de impuesto del 19%
 * <p>
 * Se pide mostrar en un solo String el nombre de la factura, el monto total bruto (antes de impuesto), el impuesto
 * y el monto total neto incluyendo impuesto.
 * <p>
 * Por ejemplo, el resultado podría ser algo así:
 * La factura producto de oficina tiene un total bruto de 134.78, con un impuesto de 25.6082 y el monto después
 * de impuesto es de 160.3882
 */
public class Cadenas {

    public static Scanner scanner = new Scanner(System.in);
    public static final int IMPUESTO = 19;
    public static String factura;

    public static void detalleDeFactura() {
        System.out.println("Ingrese el nombre de la factura: ");
        factura = scanner.nextLine();
        solicitarMontos();
    }

    public static void solicitarMontos() {
        System.out.println("Ingrese precio del producto 1");
        Double precioProducto = scanner.nextDouble();

        System.out.println("Ingrese precio del producto 2");
        Double precioProducto2 = scanner.nextDouble();

        scanner.nextLine(); // limpiar buffer

        calcularMontos(precioProducto, precioProducto2);
    }

    public static void calcularMontos(Double precioProducto1, Double precioProducto2) {
        System.out.println("La Factura producto de "+ factura);

        Double precioBruto = precioProducto1 + precioProducto2;
        System.out.println("Precio bruto: " + precioBruto);

        Double precioImpuesto = precioBruto * (IMPUESTO/100.00);
        System.out.println("Precio impuesto: " + precioImpuesto);

        Double precioFinal = precioBruto + precioImpuesto;
        System.out.println("Precio final: " + precioFinal);
    }


    public static void main(String[] args) {
        detalleDeFactura();
    }

}
