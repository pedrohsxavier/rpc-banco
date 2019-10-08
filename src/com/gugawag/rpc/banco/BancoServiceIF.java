package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    Conta adicionarConta(String conta) throws RemoteException;
    Conta pesquisarConta(String conta) throws RemoteException;
    boolean removerConta(String conta) throws RemoteException;
}

