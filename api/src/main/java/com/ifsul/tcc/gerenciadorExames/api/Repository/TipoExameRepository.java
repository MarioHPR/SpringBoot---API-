package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoExame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoExameRepository extends CrudRepository<TipoExame, Integer> {
    TipoExame findByNomeExame(String nomeExame);
}
