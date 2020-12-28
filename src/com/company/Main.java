package com.company;

import com.company.LasExceptions.BankAccountException;
import com.company.LasExceptions.ClientAccountException;

import javax.xml.transform.TransformerException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClientAccountException, BankAccountException, TransformerException {

        Scanner scanner = new Scanner(System.in);


        /*System.out.println("------ BIENVENIDO ------");*/

        System.out.print("Introduce la cuenta: ");
        String numCuenta = scanner.next();

        /*System.out.print("Nombre: ");
        String nombre = scanner.next();

        System.out.print("Apellido: ");
        String apellido = scanner.next();

        System.out.print("DNI: ");
        String dni = scanner.next();

        Client client = new Client(nombre, apellido, dni);*/
        Client cliente1 = new Client("Gustavo", "Becker", "1234");
        Client cliente2 = new Client("Horacio", "Dealer", "1234");

        CompteEstalvi compteEstalvi1 = new CompteEstalvi("1234");
        CompteEstalvi compteEstalvi2 = new CompteEstalvi("5678");
        CompteEstalvi compteEstalvi = new CompteEstalvi(numCuenta);

        /*compteEstalvi.addUser(client);*/
        compteEstalvi.addUser(cliente1);
        compteEstalvi.addUser(cliente2);

        int opcion;

        do {
            ;
            System.out.println("\n1. Ingresar Dinero");
            System.out.println("2. Sacar Dinero");
            System.out.println("3. Borrar Usuario");
            System.out.println("4. Transferencia");
            System.out.println("5. Ver Informacion Cuentas");
            System.out.println("6. Salir");
            System.out.print("\nQue quieres hacer?: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.print("Cuanto dinero quieres ingresar: ");
                    double saldo = scanner.nextDouble();
                    compteEstalvi.ingressar(saldo);
                    System.out.println("Saldo disponible: " + compteEstalvi.getSaldo());
                    break;
                }
                case 2: {
                    System.out.print("Cuanto dinero quieres sacar?: ");
                    double saldo = scanner.nextDouble();
                    compteEstalvi.treure(saldo);
                    System.out.println("Saldo disponible: " + compteEstalvi.getSaldo());
                    break;
                }
                case 3: {

                    System.out.println("\nUsuarios: \n");

                    for (Client e: compteEstalvi.getLlista_usuaris()) {
                        System.out.println(e.getNom());
                    }

                    System.out.print("Que usuario quieres borrar: ");

                    compteEstalvi.removeUser(scanner.next());

                    for (Client e: compteEstalvi.getLlista_usuaris()) {
                        System.out.println(e.getNom());
                    }

                    System.out.println("Hasta luego! :)");

                    break;
                }
                case 4: {

                    System.out.print("A que cuenta quieres transferir dinero: ");
                    String cuenta = scanner.next();
                    if (cuenta.equals(compteEstalvi1.getNumCompte()) || cuenta.equals(compteEstalvi2.getNumCompte())) {
                        System.out.print("Saldo disponible: " + compteEstalvi.getSaldo());
                        System.out.print("\nCuanto dinero quieres transferir?: ");
                        double dineroTranferir = scanner.nextDouble();
                        if (cuenta.equals(compteEstalvi1.getNumCompte())){
                            if (compteEstalvi.getSaldo() > dineroTranferir) {
                                compteEstalvi.ingressar(dineroTranferir);
                                compteEstalvi.treure(dineroTranferir);
                                System.out.println("Saldo restante: " + compteEstalvi.getSaldo());
                            } else {
                                throw new BankAccountException(ExceptionMessage.TRANSFER_ERROR);
                            }
                        } else {
                            if (compteEstalvi.getSaldo() > dineroTranferir) {
                                compteEstalvi2.ingressar(dineroTranferir);
                                compteEstalvi.treure(dineroTranferir);
                                System.out.println("Saldo restante: " + compteEstalvi.getSaldo());
                            } else {
                                throw new BankAccountException(ExceptionMessage.TRANSFER_ERROR);
                            }
                        }
                    } else {
                        throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
                    }
                }
            }
        } while (opcion != 6);
    }
}
