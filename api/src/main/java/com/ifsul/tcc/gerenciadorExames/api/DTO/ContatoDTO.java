package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
//import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

public class ContatoDTO {

    private Integer id;
    private String valor;
    private TipoContato tipoContato;
    //private Usuario usuario;

    public ContatoDTO() {}

    public ContatoDTO(Contato contato) {
        this.id = contato.getId();
        this.valor = contato.getValor();
        this.tipoContato = contato.getTipoContato();
        //this.usuario = contato.getUsuario();
    }

    public Contato convert(){
        Contato newContato = new Contato();
        newContato.setId(this.id);
        newContato.setValor(this.valor);
        newContato.setTipoContato(this.tipoContato);
        //newContato.setUsuario(this.usuario);
        return newContato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/
}
