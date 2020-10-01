package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.CampoParametro;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ParametroExame;

import java.util.List;

public class CampoParametroDTO {

    private Integer id;
    private String valor;
    private List<ParametroExame> parametroExames;

    public CampoParametroDTO() {}

    public CampoParametroDTO(CampoParametro campoParametro) {
        this.id = campoParametro.getId();
        this.valor = campoParametro.getCampo();
        this.parametroExames = campoParametro.getParametroExames();
    }

    public CampoParametro convert(){
        CampoParametro campoParametro = new CampoParametro();
        campoParametro.setId(this.id);
        campoParametro.setCampo(this.valor);
        campoParametro.setParametroExames(this.parametroExames);
        return campoParametro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<ParametroExame> getParametroExames() {
        return parametroExames;
    }

    public void setParametroExames(List<ParametroExame> parametroExames) {
        this.parametroExames = parametroExames;
    }
}
