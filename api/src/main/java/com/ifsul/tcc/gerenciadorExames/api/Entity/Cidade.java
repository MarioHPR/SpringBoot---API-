package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cidade extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "CIDADE_SEQ", sequenceName = "CIDADE_SEQ")
    @GeneratedValue(generator = "CIDADE_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cidade")
    @JsonManagedReference
    private List<Endereco> enderecos;

    @Override
    public Integer getId() {
        return id;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
