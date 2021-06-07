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
 * @author Fábio
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
        }

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

        String msg = "";
        switch (operacao) {
            case 1: // INSERT
                if (entidade == 1) {
                    msg = controllerPessoa.inserirPessoa();
                    enviarDados(msg);
                    receberDados();
                }
                if (entidade == 2) {
                    msg = controllerEmpresa.inserirEmpresa();
                    enviarDados(msg);
                    receberDados();
                }
                menu();
                break;
            case 2: // UPDATE
                if (entidade == 1) {
                    msg = controllerPessoa.listarPessoas();
                    enviarDados(msg);
                    receberDados();
                    msg = controllerPessoa.atualizarPessoa();
                    enviarDados(msg);
                    receberDados();
                }
                if (entidade == 2) {
                    msg = controllerEmpresa.listarEmpresas();
                    enviarDados(msg);
                    receberDados();
                    msg = controllerEmpresa.atualizarEmpresa();
                    enviarDados(msg);
                    receberDados();
                }
                menu();
                break;
            case 3: // GET
                if (entidade == 1) {
                    msg = controllerPessoa.buscarPessoaPorCpf();
                    enviarDados(msg);
                    receberDados(); // retorno da pessoa
                }
                if (entidade == 2) {
                    msg = controllerEmpresa.buscarEmpresaporCnpj();
                    System.out.println("GET: " + msg);
                    enviarDados(msg);
                    receberDados();
                }
                menu();
                break;
            case 4: //DELETE
                if (entidade == 1) {
                    msg = controllerPessoa.deletarPessoaPorCpf();
                    enviarDados(msg);
                    receberDados();
                }
                if (entidade == 2) {
                    msg = controllerEmpresa.deletarEmpresaporCnpj();
                    enviarDados(msg);
                    receberDados();
                }
                menu();
                break;
            case 5: //LIST
                if (entidade == 1) {
                    msg = controllerPessoa.listarPessoas();
                    enviarDados(msg);
                    receberDados();
                }
                if (entidade == 2) {
                    msg = controllerEmpresa.listarEmpresas();
                    enviarDados(msg);
                    receberDados();
                }
                menu();
                break;
            case 6: // SAIR DA APLICAÇÃO
                sc.close();
                s.close();
                break;
            default:
                System.out.println("Opção inválida.");
                menu();
                break;
        }

    }

//    public static String menuAuxiliar() throws IOException {
//        String msg = "";
//        System.out.println("Deseja vincular a pessoa à uma empresa? [s/n]");
//        String opcao = sc.next();
//        if (opcao.equalsIgnoreCase("s")) {
//            System.out.println("Escreva o CNPJ de uma empresa:");
//            enviarDados("2LIST**");
//            msg += sc.nextLine();
//        }
//        return msg;
//    }

}
