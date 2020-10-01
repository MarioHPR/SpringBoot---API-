package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class TipoExame extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "TIPO_EXAME_SEQ", sequenceName = "TIPO_EXAME_SEQ")
    @GeneratedValue(generator = "TIPO_EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nomeExame;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @OneToMany(mappedBy = "tipoExame")
    @JsonManagedReference
    private List<Exame> exames;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
}
