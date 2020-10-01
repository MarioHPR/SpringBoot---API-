package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Usuario extends EntityAbstract<Integer> {
    @Id
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "USUARIO_SEQ")
    @GeneratedValue(generator = "USUARIO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(length = 11, columnDefinition = "CHAR", nullable = false, unique = true)
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;

    // chaves estrangeiras

    @OneToOne
    @JsonBackReference
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Contato> contatos;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Instituicao> instituicoes;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<TipoExame> tipoExames;

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
