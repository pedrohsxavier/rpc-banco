package com.gugawag.rpc.banco;

import java.io.Serializable;

public class Conta implements Serializable {

    private String numero;
    private double saldo;

    public Conta(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

}