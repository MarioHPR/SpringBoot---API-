package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ParametroExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;

import java.sql.Date;
import java.util.List;

public class ExameDTO {

    private Integer id;
    private String linkImage;
    private Date dataExame;
    private Instituicao instituicao;
    private TipoExame tipoExame;
    private List<ParametroExame> parametroExames;

    public ExameDTO() {}

    public ExameDTO(Exame exame) {
        this.id = exame.getId();
        this.linkImage = exame.getLinkImage();
        this.dataExame = exame.getDataExame();
        this.instituicao = exame.getInstituicao();
        this.tipoExame   = exame.getTipoExame();
        this.parametroExames = exame.getParametroExames();
    }

    public Exame convert(){
        Exame exame = new Exame();
        exame.setId(this.id);
        exame.setLinkImage(this.linkImage);
        exame.setDataExame(this.dataExame);
        exame.setInstituicao(this.instituicao);
        exame.setTipoExame(this.tipoExame);
        exame.setParametroExames(this.parametroExames);
        return exame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public List<ParametroExame> getParametroExames() {
        return parametroExames;
    }

    public void setParametroExames(List<ParametroExame> parametroExames) {
        this.parametroExames = parametroExames;
    }
}
