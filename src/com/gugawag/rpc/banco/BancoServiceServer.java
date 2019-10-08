package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    //private Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        //saldoContas = new HashMap<>();
        //saldoContas.put("1", 100.0);
        //saldoContas.put("2", 156.0);
        //saldoContas.put("3", 950.0);
        contas = new ArrayList<Conta>();
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        Conta c = pesquisarConta(conta);
        if (c != null)
            return c.getSaldo();
        else
            return -1;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public Conta adicionarConta(String conta) throws RemoteException {
        Conta c = pesquisarConta(conta);
        if (c == null) {
            c = new Conta(conta);
            contas.add(c);
            return c;
        }
        return null;
    }

    @Override
    public Conta pesquisarConta(String conta) throws RemoteException {
        for (Conta c: contas)
            if (conta.equals(c.getNumero()))
                return c;
        return null;
    }

    @Override
    public boolean removerConta(String conta) throws RemoteException {
        Conta c = pesquisarConta(conta);
        if (c != null) {
            contas.remove(c);
            return true;
        } else
            return false;
    }

}
