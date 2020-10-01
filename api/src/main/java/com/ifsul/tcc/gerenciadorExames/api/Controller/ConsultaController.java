package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;
import com.ifsul.tcc.gerenciadorExames.api.Service.ConsultaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/consulta")
public class ConsultaController extends AbstractController<ConsultaService, Consulta, Integer> {
}
