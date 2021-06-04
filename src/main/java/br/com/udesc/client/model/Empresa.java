package br.com.udesc.client.model;

import java.util.List;

/**
 *
 * @author fabio
 */
public class Empresa {

    private String nome;
    private String cnpj;
    private String endereco;
    private String cpfPessoa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", cpfPessoa=" + cpfPessoa + '}';
    }

}
