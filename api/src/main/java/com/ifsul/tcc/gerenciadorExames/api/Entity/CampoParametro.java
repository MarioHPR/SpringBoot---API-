package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class CampoParametro extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "CAMPO_PARAMETRO_SEQ", sequenceName = "CAMPO_PARAMETRO_SEQ")
    @GeneratedValue(generator = "CAMPO_PARAMETRO_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String campo;

    @OneToMany(mappedBy = "campoParametro")
    @JsonManagedReference
    private List<ParametroExame> parametroExames;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public List<ParametroExame> getParametroExames() {
        return parametroExames;
    }

    public void setParametroExames(List<ParametroExame> parametroExames) {
        this.parametroExames = parametroExames;
    }
}
