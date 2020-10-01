package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ParametroExame extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "PARAMETRO_EXAME_SEQ", sequenceName = "PARAMETRO_EXAME_SEQ")
    @GeneratedValue(generator = "PARAMETRO_EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String valor;

    // chaves

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_EXAME")
    private Exame exame;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_CAMPO")
    private CampoParametro campoParametro;

    @Override
    public Integer getId() {
        return this.id;
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

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public CampoParametro getCampoParametro() {
        return campoParametro;
    }

    public void setCampoParametro(CampoParametro campoParametro) {
        this.campoParametro = campoParametro;
    }
}
