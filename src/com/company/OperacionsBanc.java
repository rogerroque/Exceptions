package com.company;

public class OperacionsBanc {

    public static boolean verifyDNI(String dni)  {

        String DNI = "1234";

        if (dni.equals(DNI)) {
            return true;
        } else {
            return false;
        }
    }
}
