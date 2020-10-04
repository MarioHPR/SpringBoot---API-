package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.CampoParametro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampoParametroRepository extends CrudRepository<CampoParametro, Integer> {
    CampoParametro findByCampo(String campo);
}
