package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends CrudRepository<Contato,Integer> {
    Optional<Contato> findById(Integer id);
    Contato findByValor(String valor);
    List<Contato> findAllByTipoContato(TipoContato tipoContato);
    List<Contato> findAll();
}
