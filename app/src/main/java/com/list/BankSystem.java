package com.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;

/**
 * List iterator, Set, Optional
 */
public class BankSystem {
    private List<Client> clients = new ArrayList<>();
    private Set<Integer> accountNumbers = new HashSet<>();

    public void addClient(Client client) {
        if (accountNumbers.add(client.getAccountNumber())) {
            clients.add(client);
        } else {
            System.out.println("El número de cuenta ya existe: " + client.getAccountNumber());
        }
    }

    public Optional<Client> findClientByAccount(int accountNumber) {
        return clients.stream()
                .filter(client -> client.getAccountNumber() == accountNumber)
                .findFirst();
    }

    public boolean hasNegativeBalance() {
        return clients.stream().anyMatch(client -> client.getBalance() < 0);
    }

    public void updateClientList() {
        ListIterator<Client> listIterator = clients.listIterator();
        while (listIterator.hasNext()) {
            Client client = listIterator.next();
            System.out.println("Cliente: " + client.getName() + ", Saldo: " + client.getBalance());
        }

        while (listIterator.hasPrevious()) {
            Client client = listIterator.previous();
            System.out.println("Recorriendo en reversa - Cliente: " + client.getName());
        }
    }

    public void printClientFields() {
        if (clients.isEmpty()) {
            System.out.println("No hay clientes en el sistema.");
            return;
        }
        Field[] fields = Client.class.getDeclaredFields();
        System.out.println("Campos de la clase Client:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();

        bankSystem.addClient(new Client("Juan Pérez", 12345, 100.0));
        bankSystem.addClient(new Client("María García", 67890, -50.0));
        bankSystem.addClient(new Client("Ana López", 54321, 250.0));

        Optional<Client> clientOpt = bankSystem.findClientByAccount(12345);
        clientOpt.ifPresent(client -> System.out.println("Cliente encontrado: " + client.getName()));
        if (clientOpt.isEmpty()) {
            System.out.println("Cliente no encontrado.");
        }

        boolean hasNegative = bankSystem.hasNegativeBalance();
        System.out.println("¿Algún cliente tiene saldo negativo? " + hasNegative);

        bankSystem.updateClientList();

        bankSystem.printClientFields();
    }
}
