package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o servico no RMI Registry local. Perceba que o cliente nao connhece a implementacao do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry("10.0.4.227", 1099);
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao metodo remoto, como se fosse executar localmente
                    double valor = banco.saldo(conta);
                    System.out.println("Conta: " + conta + "; Saldo: " + valor);
                    break;
                }
                case 2: {
                    //chamada ao metodo remoto, como se fosse executar localmente
                    int n = banco.quantidadeContas();
                    System.out.println("Numero de contas: " + n);
                    break;
                }
                case 3: {
                    System.out.println("Informe o numero da nova conta: ");
                    String conta = entrada.next();
                    if (banco.adicionarConta(conta) != null)
                        System.out.println("Conta criada com sucesso!");
                    else
                        System.out.println("Erro na criacao da conta.");
                    break;
                }
                case 4: {
                    System.out.println("Informe o numero da conta: ");
                    String conta = entrada.next();
                    if (banco.pesquisarConta(conta) != null)
                        System.out.println("Conta: " + conta);
                    else
                        System.out.println("Conta inexistente.");
                    break;
                }
                case 5: {
                    System.out.println("Informe o numero da conta: ");
                    String conta = entrada.next();
                    if (banco.removerConta(conta))
                        System.out.println("Conta removida com sucesso");
                    else
                        System.out.println("Conta nao encontrada.");
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastrar nova conta");
        System.out.println("4 - Pesquisar conta");
        System.out.println("5 - Remover conta");
        System.out.println("9 - Sair");
    }

}
