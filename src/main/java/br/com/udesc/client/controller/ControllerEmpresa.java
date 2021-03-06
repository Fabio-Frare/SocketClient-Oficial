package br.com.udesc.client.controller;

import br.com.udesc.client.model.Empresa;
import br.com.udesc.client.utils.Utils;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author fabio
 */
public class ControllerEmpresa {

    Empresa empresa;
    Utils utils;
    Scanner in;
    String mensagem;

    public String inserirEmpresa() throws IOException {
        empresa = new Empresa();
        utils = new Utils();
        in = new Scanner(System.in);

        System.out.println("Favor informar o nome da empresa: ");
        String nomeEmpresa = in.nextLine();
        empresa.setNome(utils.padronizaInsercao(nomeEmpresa, 100));

        System.out.println("Favor informar o CNPJ: ");
        String cnpj = in.nextLine();
        empresa.setCnpj(utils.padronizaInsercao(cnpj, 14));

        System.out.println("Favor informar o endereço: ");
        String enderecoEmpresa = in.nextLine();
        empresa.setEndereco(utils.padronizaInsercao(enderecoEmpresa, 100));

        String cpfPessoa = "*";
        empresa.setCpfPessoa(utils.padronizaInsercao(cpfPessoa, 11));

        mensagem = "2INSERT";               //   7 bytes
        mensagem += empresa.getCnpj();      //  14 bytes
        mensagem += empresa.getNome();      // 100 bytes
        mensagem += empresa.getEndereco();  // 100 bytes 
        mensagem += empresa.getCpfPessoa(); //  11 bytes  => 232 bytes

        System.out.println("Controler pessoa insert " + mensagem);

        return mensagem;
    }

    public String atualizarEmpresa() {
        empresa = new Empresa();
        utils = new Utils();
        in = new Scanner(System.in);

        System.out.println("Favor informar o CNPJ: ");
        String cnpj = in.nextLine();
        empresa.setCnpj(utils.padronizaInsercao(cnpj, 14));

        System.out.println("Favor informar o nome da empresa: ");
        String nomeEmpresa = in.nextLine();
        empresa.setNome(utils.padronizaInsercao(nomeEmpresa, 100));

        System.out.println("Favor informar o endereço: ");
        String enderecoEmpresa = in.nextLine();
        empresa.setEndereco(utils.padronizaInsercao(enderecoEmpresa, 100));

        String cpfPessoa = "*";
        empresa.setCpfPessoa(utils.padronizaInsercao(cpfPessoa, 11));

        mensagem = "2UPDATE";                //   7 bytes
        mensagem += empresa.getCnpj();       //  11 bytes
        mensagem += empresa.getNome();       // 100 bytes
        mensagem += empresa.getEndereco();   // 100 bytes 
        mensagem += empresa.getCpfPessoa();  //  14 bytes  => 232 bytes

        return mensagem;
    }

    public String listarEmpresas() {
        return "2LIST**";
    }

    public String buscarEmpresaporCnpj() {
        Scanner sc = new Scanner(System.in);
        String cnpj = "";
        System.out.println("Favor informar o CNPJ da empresa: ");
        cnpj = sc.nextLine();
        return "2GET***" + cnpj;
    }

    public String deletarEmpresaporCnpj() {
        Scanner sc = new Scanner(System.in);
        String cnpj = "";
        System.out.println("Favor informar o CNPJ da empresa: ");
        cnpj = sc.nextLine();
        return "2DELETE" + cnpj;
    }

}
