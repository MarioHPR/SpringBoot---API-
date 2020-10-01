package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.*;

import java.sql.Date;
import java.util.List;

public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String login;
    private String senha;
    private Endereco endereco;
    private List<Contato> contatos;
    private List<Instituicao> instituicoes;
    private List<TipoExame> tipoExames;
    private List<Consulta> consultas;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.id    = usuario.getId();
        this.nome  = usuario.getNome();
        this.cpf   = usuario.getCpf();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.endereco   = usuario.getEndereco();
        this.contatos   = usuario.getContatos();
        this.consultas  = usuario.getConsultas();
        this.tipoExames = usuario.getTipoExames();
        this.instituicoes   = usuario.getInstituicoes();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public Usuario convert(){
        Usuario newUsuario = new Usuario();
        newUsuario.setId(this.id);
        newUsuario.setNome(this.nome);
        newUsuario.setCpf(this.cpf);
        newUsuario.setDataNascimento(this.dataNascimento);
        newUsuario.setLogin(this.login);
        newUsuario.setSenha(this.senha);
        newUsuario.setEndereco(this.endereco);
        newUsuario.setContatos(this.contatos);
        newUsuario.setConsultas(this.consultas);
        newUsuario.setTipoExames(this.tipoExames);
        newUsuario.setInstituicoes(this.instituicoes);
        return newUsuario;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Instituicao> getInstituicoes() {
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<TipoExame> getTipoExames() {
        return tipoExames;
    }

    public void setTipoExames(List<TipoExame> tipoExames) {
        this.tipoExames = tipoExames;
    }
}
