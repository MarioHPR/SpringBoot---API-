package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;
import com.ifsul.tcc.gerenciadorExames.api.Service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/endereco")
public class EnderecoController extends AbstractController<EnderecoService, Endereco,Integer> {
}
