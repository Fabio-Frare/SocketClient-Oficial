package br.com.udesc.client;

import br.com.udesc.client.controller.ControllerEmpresa;
import br.com.udesc.client.controller.ControllerPessoa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author fabio
 */
public class Client {

    private static final int porta = 80;
    private static final String address = "localhost";

    private static ControllerPessoa controllerPessoa;
    private static ControllerEmpresa controllerEmpresa;

    private static Socket s;
    private static Scanner sc;

    public static void main(String[] args) throws IOException {

        while (true) {

            menu();
//            receberDados();
        }

//        s.close();
    }

    public static void enviarDados(String msg) throws IOException {
        s = new Socket(address, porta);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(msg);
        pr.flush();
    }

    public static void receberDados() throws IOException {
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("server: " + str);
    }

    public static void menu() throws IOException {
        System.out.println("Qual operação você deseja fazer?"
                + "\n1 - Inserir "
                + "\n2 - Atualizar "
                + "\n3 - Buscar"
                + "\n4 - Deletar"
                + "\n5 - Listar"
                + "\n6 - sair");
        sc = new Scanner(System.in);
        int operacao = sc.nextInt();

        String[] operacoes = {"inserir", "atualizar", "buscar", "deletar", "listar"};
        System.out.println("Deseja " + operacoes[operacao - 1] + ": "
                + "\n1 - Pessoa"
                + "\n2 - Empresa");
        int entidade = sc.nextInt();

        controllerPessoa = new ControllerPessoa();
        controllerEmpresa = new ControllerEmpresa();
        
        System.out.println("Operação: " + operacao);
        System.out.println("entidade: " + entidade);
        String msg = "";
        switch (operacao) {
            case 1:
                if (entidade == 1) {
                    msg = controllerPessoa.inserirPessoa();
                    msg += menuAuxiliar();
                    receberDados();
                    enviarDados(msg);
                    System.out.println("switch pessoa: " + msg);                    
                } else {
                    msg = controllerEmpresa.inserirEmpresa();
                    enviarDados(msg);
                    System.out.println("switch empresa: " + msg);
                }
                break;
            case 2:
//                controller.atualizarPessoa();
                break;
            case 3:
//                controller.selecionarPessoa();
                break;
            case 4:
//                
                break;
            case 5:
                if (entidade == 1) {
                    msg = controllerPessoa.listarPessoas();
                    System.out.println("entrou switch case listar pessoa" + msg);
                    enviarDados(msg);
                    receberDados();
                    menu();
                } else {
                    msg = controllerEmpresa.listarEmpresas();
                    System.out.println("entrou switch case listar empresa " + msg);
                    enviarDados(msg);
                    receberDados();
                    menu();
                }
                break;
            case 6:
                sc.close();
                break;
            default:
                System.out.println("Opção inválida.");
                sc.close();
                break;
        }

    }

    public static String menuAuxiliar() throws IOException {
        String msg = "";
        System.out.println("Deseja vincular a pessoa à uma empresa? [s/n]");
        String opcao = sc.next();
        if (opcao.equalsIgnoreCase("s")) {
            System.out.println("Escreva o CNPJ de uma empresa:");
            enviarDados("2LIST**");
            msg += sc.nextLine();
        }
        return msg;
    }

}
