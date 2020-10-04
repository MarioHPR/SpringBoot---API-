package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    Consulta findByDiagnostico(String diagnostico);
    List<Consulta> findAllByNomeMedico(String nomeMedico);
}
