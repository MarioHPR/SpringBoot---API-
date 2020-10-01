package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Cidade;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;

import java.util.List;

public class CidadeDTO {

    private Integer id;
    private String nome;
    private List<Endereco> enderecos;

    public CidadeDTO(){}

    public CidadeDTO(Cidade cidade){
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.enderecos = cidade.getEnderecos();
    }

    public Cidade convert(){
        Cidade cidade = new Cidade();
        cidade.setId(this.id);
        cidade.setNome(this.nome);
        cidade.setEnderecos(this.enderecos);
        return cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEstados() {
        return enderecos;
    }

    public void setEstados(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
