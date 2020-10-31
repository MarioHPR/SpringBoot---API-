package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import com.ifsul.tcc.gerenciadorExames.api.Service.TipoContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( value = "/api/tipoContato" )
public class TipoContatoController extends AbstractController<TipoContatoService, TipoContato,Integer> {
}
