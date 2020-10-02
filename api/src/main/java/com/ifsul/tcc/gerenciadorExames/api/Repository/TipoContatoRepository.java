package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContatoRepository extends CrudRepository<TipoContato,Integer> {
    TipoContato findByNome(String nome);
}
