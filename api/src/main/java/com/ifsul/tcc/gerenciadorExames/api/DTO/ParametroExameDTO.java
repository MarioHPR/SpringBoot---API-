package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.CampoParametro;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ParametroExame;

public class ParametroExameDTO {

    private Integer id;
    private String valor;
    private Exame exame;
    private CampoParametro campoParametro;

    public ParametroExameDTO() {}

    public ParametroExameDTO(ParametroExame parametroExame) {
        this.id = parametroExame.getId();
        this.valor = parametroExame.getValor();
        this.exame = parametroExame.getExame();
        this.campoParametro = parametroExame.getCampoParametro();
    }

    public ParametroExame convert(){
        ParametroExame parametroExame = new ParametroExame();
        parametroExame.setId(this.id);
        parametroExame.setValor(this.valor);
        parametroExame.setExame(this.exame);
        parametroExame.setCampoParametro(this.campoParametro);
        return parametroExame;
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
