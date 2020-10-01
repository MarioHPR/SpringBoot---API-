package com.ifsul.tcc.gerenciadorExames.api.Service;

import com.ifsul.tcc.gerenciadorExames.api.ApiApplication;
import com.ifsul.tcc.gerenciadorExames.api.Entity.EntityAbstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class AbstractService<
        R extends CrudRepository<E, T>,
        E extends EntityAbstract, T>{

    Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @Autowired
    R repository;

    @Transactional( rollbackFor = Exception.class )
    public E salvar(E entidade) {
        logger.warn("Se tiver campos faltando, não ira salvar a Entidade!");
        try{
            return repository.save(entidade);
        }catch (Exception e){
            System.err.println(e.getMessage());
            //throw new RuntimeException(e.getCause());
            logger.error("Erro ao salvar entidade:" + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Transactional( rollbackFor = Exception.class )
    public E editar( E entidade, T id ) {
        entidade.setId(id);
        return repository.save(entidade);
    }

    public List<E> todos() {
        return (List<E>) repository.findAll();
    }

    public E porId( T id ){
        return repository.findById(id).get();
    }
}
