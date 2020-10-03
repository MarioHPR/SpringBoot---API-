package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TipoContatoRepositoryTest {

    @Autowired
    private TipoContatoRepository repository;

    @BeforeEach
    public  void init(){
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("email");
        repository.save(tipoContato);
    }

    @Test
    public void buscarPeloId() {
        assertEquals(1, repository.findById(1).get().getId());
    }

    @Test
    public void buscarPorNome(){
        assertEquals("email", repository.findByNome("email").getNome());
    }

    @Test
    public void buscarTodosTipoContatosInseridos() {
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("Celular");
        repository.save(tipoContato);

        List<TipoContato> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(repository.findByNome("email"));
        resultadoEsperado.add(repository.findByNome("Celular"));

        assertEquals(resultadoEsperado, repository.findAll());
    }

    @Test
    public void buscarIdInexistenteRetornarNull() {
        assertFalse(repository.findById(2).isPresent());
    }

    @Test
    public void buscarPorNomeInexistenteRetornarNull() {
        assertNull(repository.findByNome("telefone"));
    }

}
