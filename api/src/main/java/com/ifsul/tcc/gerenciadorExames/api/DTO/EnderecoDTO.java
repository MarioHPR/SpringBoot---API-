package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Cidade;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;

public class EnderecoDTO {

    private Integer id;
    private String logradouro;
    private int numero;
    private String cep;
    private String bairro;
    private Cidade cidade;

    public EnderecoDTO() {}

    public EnderecoDTO(Endereco endereco) {
        this.id         = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.numero     = endereco.getNumero();
        this.cep        = endereco.getCep();
        this.bairro     = endereco.getBairro();
        this.cidade     = endereco.getCidade();
    }

    public Endereco convert (){
        Endereco endereco = new Endereco();
        endereco.setId(this.id);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setCep(this.cep);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);

        return endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
