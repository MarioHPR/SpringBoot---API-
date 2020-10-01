package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Cidade;
import com.ifsul.tcc.gerenciadorExames.api.Service.CidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cidade")
public class CidadeController extends AbstractController<CidadeService, Cidade, Integer> {
}
