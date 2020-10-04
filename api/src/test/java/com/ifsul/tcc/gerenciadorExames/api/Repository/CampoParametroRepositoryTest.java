package com.ifsul.tcc.gerenciadorExames.api.Repository;
import com.ifsul.tcc.gerenciadorExames.api.Entity.CampoParametro;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CampoParametroRepositoryTest {

    @Autowired
    private CampoParametroRepository campoParametroRepository;

    @BeforeAll
    public void init() {
        CampoParametro campoParametro = new CampoParametro();
        campoParametro.setCampo("Hemoglobina");
        campoParametroRepository.save(campoParametro);
    }

    @Test
    public void buscarCampoParametroPorId() {
        assertTrue(campoParametroRepository.findById(1).isPresent());
    }

    @Test
    public void buscarCampoParametroPeloCampo(){
        assertEquals("Hemoglobina", campoParametroRepository.findByCampo("Hemoglobina").getCampo());
    }

    @Test
    public void buscarCampoParametroPorIdInexistenteRetornarFalse() {
        assertFalse(campoParametroRepository.findById(2).isPresent());
    }

    @Test
    public void buscarCampoParametroPeloCampoInexistenteRetornarNUll() {
        assertNull(campoParametroRepository.findByCampo("Teste"));
    }
}
