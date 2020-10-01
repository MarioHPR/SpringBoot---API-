package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Instituicao extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "INSTITUICAO_SEQ", sequenceName = "INSTITUICAO_SEQ")
    @GeneratedValue(generator = "INSTITUICAO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LOCAL", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "instituicao")
    @JsonManagedReference
    private List<Exame> exame;

    @OneToMany(mappedBy = "instituicao")
    @JsonManagedReference
    private List<Consulta> consultas;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
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
