package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Endereco extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "LOCALIDADE_SEQ", sequenceName = "LOCALIDADE_SEQ")
    @GeneratedValue(generator = "LOCALIDADE_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private int numero;
    @Column(length = 8, columnDefinition = "CHAR", nullable = false)
    private String cep;
    @Column(nullable = false)
    private String bairro;

    // chaves estrangeiras ----
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    @JsonBackReference
    private Cidade cidade;

    @OneToOne(mappedBy = "endereco")
    @JsonManagedReference
    private Usuario usuario;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
