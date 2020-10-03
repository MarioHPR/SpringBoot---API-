package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Cidade;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Endereco;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @BeforeAll
    public void init(){
        Cidade cidade = new Cidade();
        cidade.setNome("São Jerônimo");
        Cidade newCidade = cidadeRepository.save(cidade);

        Endereco endereco = new Endereco();
        endereco.setCidade(newCidade);
        endereco.setCep("96700000");
        endereco.setBairro("Passo D'Areia");
        endereco.setLogradouro("Rua Antonio Ruiz");
        endereco.setNumero(179);
        enderecoRepository.save(endereco);
    }

    @Test
    @Order(1)
    public void buscarPorId(){
        assertTrue(enderecoRepository.findById(1).isPresent());
    }

    @Test
    public void buscarIdInexistenteRetornarFalse(){
        assertFalse(enderecoRepository.findById(2).isPresent());
    }

}
