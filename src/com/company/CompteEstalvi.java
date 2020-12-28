package com.company;

import com.company.LasExceptions.BankAccountException;

import java.util.ArrayList;
import java.util.List;

public class CompteEstalvi {
    private String numCompte;
    private double saldo;
    private List<Client> llista_usuaris = new ArrayList<>();

    @Override
    public String toString() {
        return "CompteEstalvi{" +
                "llista_usuaris=" + llista_usuaris +
                '}';
    }

    public CompteEstalvi(String numCompte) {
        this.numCompte = numCompte;
        saldo = 500;
    }

    /**
        Afegeix un usuari d'aquest compte
        @param client
        @return quantitat d'usuaris que té el compte

     **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    /**
     Elimina un usuari d'aquest compte,
     Com que no pot quedar un compte sense usuari, si és l'ùltim és llança una excepció
     @param dni
     @return quantitat d'usuaris que té el compte
     @throws BankAccountException
     **/

    public void removeUser(String nombre) {
        llista_usuaris.removeIf(u -> {
            try {
                return nombre.equals(u.getNom()) && remover();
            } catch (BankAccountException e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    private boolean remover() throws BankAccountException {

        if (llista_usuaris.size() >= 2) {
            return true;
        } else {
            throw new BankAccountException(ExceptionMessage.ACCOUNT_ZERO_USER);
        }
    }

    /**
     * Afegeix m diners al saldo
     * @param m
     */
    public void ingressar(double m) {
        saldo += m;
    }

    /**
     * Treu m diners del compte si n'hi han suficient sinó es llança l'excepció
     * @param m
     * @throws BankAccountException
     */
    public void treure(double m) throws BankAccountException {

        if (saldo < m) {
            throw new BankAccountException(ExceptionMessage.ACCOUNT_OVERDRAFT);
        } else {
            saldo -= m;
        }
    }



    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() {
        return llista_usuaris;
    }
}
