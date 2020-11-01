package com.ifsul.tcc.gerenciadorExames.api.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties("contatos")
public class TipoContato extends EntityAbstract<Integer> {
    @Id
    @SequenceGenerator(name = "TIPO_CONTATO_SEQ", sequenceName = "TIPO_CONTATO_SEQ")
    @GeneratedValue(generator = "TIPO_CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "tipoContato")
    @JsonManagedReference
    private List<Contato> contatos;

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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
