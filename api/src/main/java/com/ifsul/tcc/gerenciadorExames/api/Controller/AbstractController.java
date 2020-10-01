package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.EntityAbstract;
import com.ifsul.tcc.gerenciadorExames.api.Service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<S extends AbstractService, E extends EntityAbstract, T>{

    @Autowired
    S service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<E> todos() {
        return service.todos();
    }


    @PostMapping(value = "/novo")
    @ResponseBody
    public E salvar(@RequestBody E entidade){
        return (E) service.salvar(entidade);
    }

    // ex: localhost:8080/api/pais/ver/1
    @GetMapping(value = "/ver/{id}")
    @ResponseBody
    public E especifico(@PathVariable T id){
        return (E)service.porId(id);
    }

    @PutMapping(value = "editar/{id}")
    @ResponseBody
    public E editar(@PathVariable T id, @RequestBody E entidade){
        return (E)service.editar(entidade,id);
    }

}
