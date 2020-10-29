package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import com.ifsul.tcc.gerenciadorExames.api.Service.TipoContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( value = "/api/tipoContato" )
public class TipoContatoController/* extends AbstractController<TipoContatoService, TipoContato,Integer> */{

    @Autowired
    TipoContatoService service;

    @GetMapping(value = "/todos")
    @ResponseBody
    public List<TipoContato> todos() {
        return service.todos();
    }



    @PostMapping(value = "/novo")
    @ResponseBody
    //@Override
    public TipoContato salvar(@RequestBody TipoContato entidade) {
        System.out.println("/////////////////////");
        System.out.println("/////////////////////");
        System.out.println(entidade.getNome());
        System.out.println("/////////////////////");
        System.out.println("/////////////////////");
        return service.salvar(entidade);
    }

    @GetMapping(value = "/ver/{id}")
    @ResponseBody
    public TipoContato especifico(@PathVariable Integer id) {
        return service.porId(id);
    }

    @PutMapping(value = "/editar/{id}")
    @ResponseBody
    public TipoContato editar(@PathVariable  Integer id, @RequestBody TipoContato entidade) {
        return service.editar(entidade,id);
    }
}
