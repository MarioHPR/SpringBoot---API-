package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

import java.sql.Date;

public class ConsultaDTO {

    private Integer id;
    private String diagnostico;
    private String prescricao;
    private String nomeMedico;
    private String linkImage;
    private Date dataConsulta;
    private Usuario usuario;
    private Instituicao instituicao;

    public ConsultaDTO() {}

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.diagnostico = consulta.getDiagnostico();
        this.prescricao = consulta.getPrescricao();
        this.nomeMedico = consulta.getNomeMedico();
        this.linkImage = consulta.getLinkImage();
        this.dataConsulta = consulta.getDataConsulta();
        this.usuario = consulta.getUsuario();
        this.instituicao = consulta.getInstituicao();
    }

    public Consulta convert(){
        Consulta consulta = new Consulta();
        consulta.setId(this.id);
        consulta.setDiagnostico(this.diagnostico);
        consulta.setPrescricao(this.prescricao);
        consulta.setNomeMedico(this.nomeMedico);
        consulta.setLinkImage(this.linkImage);
        consulta.setDataConsulta(this.dataConsulta);
        consulta.setUsuario(this.usuario);
        consulta.setInstituicao(this.instituicao);
        return consulta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
