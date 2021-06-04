package br.com.udesc.client.controller;

import br.com.udesc.client.model.Pessoa;
import br.com.udesc.client.utils.Utils;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fabio
 */
public class ControllerPessoa {

    Pessoa pessoa;
    Utils utils;
    Scanner in;
    String mensagem;

    public String inserirPessoa() throws IOException {
        pessoa = new Pessoa();
        utils  = new Utils();
        in     = new Scanner(System.in);

        System.out.println("Favor informar o nome da pessoa: ");
        String nomePessoa = in.nextLine();
        pessoa.setNome(utils.padronizaInsercao(nomePessoa, 100));

        System.out.println("Favor informar o CPF: ");
        String cpf = in.nextLine();
        pessoa.setCpf(utils.padronizaInsercao(cpf, 11));

        System.out.println("Favor informar o endereço: ");
        String enderecoPessoa = in.nextLine();
        pessoa.setEndereco(utils.padronizaInsercao(enderecoPessoa, 100));

        String cnpjEmpresa = "*";
        pessoa.setCnpjEmpresa(utils.padronizaInsercao(cnpjEmpresa, 14));

        mensagem  = "1INSERT";                 //   7 bytes
        mensagem += pessoa.getCpf();          //  11 bytes
        mensagem += pessoa.getNome();         // 100 bytes
        mensagem += pessoa.getEndereco();     // 100 bytes 
        mensagem += pessoa.getCnpjEmpresa();  //  14 bytes  => 232 bytes

        return mensagem;
    }

    public void atualizarPessoa() {
        System.out.println("Pessoa atualizada.");
    }

    public void selecionarPessoa() {
        System.out.println("Pessoa selecionada.");
    }

    public void listarPessoas() {
        System.out.println("Pessoas listada.");
    }

}
