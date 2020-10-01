package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.*;

import java.util.List;

public class InstituicaoDTO {

    private Integer id;
    private String nome;
    private Endereco endereco;
    private Usuario usuario;
    private List<Exame> exame;
    private List<Consulta> consultas;

    public InstituicaoDTO() {}

    public InstituicaoDTO(Instituicao instituicao) {
        this.id   = instituicao.getId();
        this.nome = instituicao.getNome();
        this.endereco  = instituicao.getEndereco();
        this.exame     = instituicao.getExame();
        this.usuario   = instituicao.getUsuario();
        this.consultas = instituicao.getConsultas();
    }

    public Instituicao convert(){
        Instituicao instituicao = new Instituicao();
        instituicao.setId(this.id);
        instituicao.setNome(this.nome);
        instituicao.setEndereco(this.endereco);
        instituicao.setExame(this.exame);
        instituicao.setUsuario(this.usuario);
        instituicao.setConsultas(this.consultas);
        return instituicao;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }
}
