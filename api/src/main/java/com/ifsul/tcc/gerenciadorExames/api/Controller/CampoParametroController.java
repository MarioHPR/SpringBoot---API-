package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.CampoParametro;
import com.ifsul.tcc.gerenciadorExames.api.Service.CampoParametroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/campoParametro")
public class CampoParametroController extends AbstractController<CampoParametroService, CampoParametro, Integer> {
}
