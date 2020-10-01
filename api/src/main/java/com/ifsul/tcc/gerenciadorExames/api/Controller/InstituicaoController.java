package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Service.InstituicaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/instituicao")
public class InstituicaoController extends AbstractController<InstituicaoService, Instituicao, Integer> {
}
