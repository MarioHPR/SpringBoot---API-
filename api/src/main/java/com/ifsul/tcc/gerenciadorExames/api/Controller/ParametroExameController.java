package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.ParametroExame;
import com.ifsul.tcc.gerenciadorExames.api.Service.ParametroExameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/parametroExame")
public class ParametroExameController extends AbstractController<ParametroExameService, ParametroExame, Integer> {
}
