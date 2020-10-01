package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class TipoContatoDTO {

    private Integer id;
    private String nome;
    private List<Contato> contatos;

    public TipoContatoDTO() {}

    public TipoContatoDTO(TipoContato tipoContato) {
        this.id = tipoContato.getId();
        this.nome = tipoContato.getNome();
        this.contatos = tipoContato.getContatos();
    }

    public TipoContato convert(){
        TipoContato newTipoContato = new TipoContato();

        newTipoContato.setId(this.id);
        newTipoContato.setNome(this.nome);
        newTipoContato.setContatos(this.contatos);
        return newTipoContato;
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
