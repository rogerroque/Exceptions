package com.company;

import com.company.LasExceptions.ClientAccountException;

public class Client {
    private String Nom;
    private String Cognoms;
    private String DNI;

    public Client(String nom, String cognoms, String DNI) throws ClientAccountException {
        Nom = nom;
        Cognoms = cognoms;
        if(OperacionsBanc.verifyDNI(DNI)) {
            this.DNI = DNI;
        } else {
            throw new ClientAccountException(ExceptionMessage.WRONG_DNI);
        }
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public void setCognoms(String cognoms) {
        Cognoms = cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }



}
