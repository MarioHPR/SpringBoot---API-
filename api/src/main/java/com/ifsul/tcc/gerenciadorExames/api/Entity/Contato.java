package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = {"tipoContato", "usuario"})
public class Contato extends EntityAbstract<Integer> {
    @Id
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "CONTATO_SEQ")
    @GeneratedValue(generator = "CONTATO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "ID_TIPO_CONTATO")
    @JsonIgnore
    private TipoContato tipoContato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "ID_USUARIO")
    @JsonIgnore
    private Usuario usuario;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
