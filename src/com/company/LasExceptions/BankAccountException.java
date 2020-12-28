package com.company.LasExceptions;

public class BankAccountException extends Throwable {
    public BankAccountException(String mensaje) {
        super(mensaje);
    }
}
