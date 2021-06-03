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
    private List<String> pessoas;

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

    public List<String> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<String> pessoas) {
        this.pessoas = pessoas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nome=" + nome + ", cnpj=" + cnpj + ", pessoas=" + pessoas + '}';
    }

}
