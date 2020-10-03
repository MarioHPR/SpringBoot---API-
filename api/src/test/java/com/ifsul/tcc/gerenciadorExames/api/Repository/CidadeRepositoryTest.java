package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Cidade;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CidadeRepositoryTest {

    @Autowired
    private CidadeRepository repository;

    @BeforeEach
    public void init(){
        Cidade cidade = new Cidade();
        cidade.setNome("Porto Alegre");
        repository.save(cidade);
    }

    @Test
    @Order(1)
    public void buscarPorId() {
        assertTrue(repository.findById(1).isPresent());
    }

    @Test
    @Order(2)
    public void buscarPorNome(){
        assertEquals("Porto Alegre", repository.findByNome("Porto Alegre").getNome());
    }

    @Test
    public void buscarTodasAsCidadesInseridasRetornarTamanhoDois(){
        Cidade cidade2 = new Cidade();
        cidade2.setNome("São Jerônimo");
        repository.save(cidade2);

        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void buscarIdInexistenteRetornarFalse(){
        assertFalse(repository.findById(2).isPresent());
    }

    @Test
    public void buscarNomeInexistenteRetornarNull(){
        assertNull(repository.findByNome("Charq"));
    }
}
