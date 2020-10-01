package com.ifsul.tcc.gerenciadorExames.api.DTO;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

import java.util.List;

public class TipoExameDTO {

    private Integer id;
    private String nomeExame;
    private Usuario usuario;
    private List<Exame> exames;

    public TipoExameDTO() {}

    public TipoExameDTO(TipoExame tipoExame) {
        this.id = tipoExame.getId();
        this.nomeExame = tipoExame.getNomeExame();
        this.usuario = tipoExame.getUsuario();
        this.exames = tipoExame.getExames();
    }

    public TipoExame convert(){
        TipoExame tipoExame = new TipoExame();
        tipoExame.setId(this.id);
        tipoExame.setNomeExame(this.nomeExame);
        tipoExame.setUsuario(this.usuario);
        tipoExame.setExames(this.exames);
        return tipoExame;
    }

    public Integer getId() {
        return id;
    }

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
