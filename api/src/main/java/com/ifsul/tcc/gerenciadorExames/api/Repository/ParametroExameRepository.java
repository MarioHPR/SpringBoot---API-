package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.CampoParametro;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Exame;
import com.ifsul.tcc.gerenciadorExames.api.Entity.ParametroExame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroExameRepository extends CrudRepository<ParametroExame, Integer> {
    ParametroExame findByExame(Exame exame);
    ParametroExame findByCampoParametro(CampoParametro campoParametro);
}
