package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Integer> {
    Exame findByDataExame(Date dataExame);
    List<Exame> findAllByTipoExame(TipoExame tipoExame);
}
