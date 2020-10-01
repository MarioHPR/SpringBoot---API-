package com.ifsul.tcc.gerenciadorExames.api.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Exame extends EntityAbstract<Integer> {

    @Id
    @SequenceGenerator(name = "EXAME_SEQ", sequenceName = "EXAME_SEQ")
    @GeneratedValue(generator = "EXAME_SEQ", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String linkImage;

    @Column(nullable = false)
    private Date dataExame;

    // chaves
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_INSTITUICAO")
    private Instituicao instituicao;

    @OneToMany(mappedBy = "exame")
    @JsonManagedReference
    private List<ParametroExame> parametroExames;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ID_TIPO_EXAME")
    private TipoExame tipoExame;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
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
