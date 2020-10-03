package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContatoRepositoryTest {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private TipoContatoRepository tipoContatoRepository;

    @BeforeEach
    public void init(){
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("email");

        Contato contato = new Contato();
        contato.setTipoContato(tipoContatoRepository.save(tipoContato));
        contato.setValor("teste@gmail.com");
        contatoRepository.save(contato);
    }

    @Test
    @Order(1)
    public void buscarContatoPorId() {
        assertTrue(contatoRepository.findById(1).isPresent());
    }

    @Test
    public void buscarContatoPorValor(){
        assertEquals("teste@gmail.com", contatoRepository.findByValor("teste@gmail.com").getValor());
    }

    @Test
    public void buscarTodosPorTipoContato(){
        TipoContato tipoContato = tipoContatoRepository.findByNome("email");
        String resultado = contatoRepository.findAllByTipoContato(tipoContato).get(0).getValor();
        assertEquals("teste@gmail.com", resultado);
    }

    @Test
    public void buscarTodosContatosInseridos() {
        System.out.println("///////////////////TESTE/////////////");
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("Celular");

        Contato contato = new Contato();
        contato.setTipoContato(tipoContatoRepository.save(tipoContato));
        contato.setValor("99998888");
        contatoRepository.save(contato);

        assertEquals(2, contatoRepository.findAll().size());
    }

    @Test
    public void buscarIdInexistenteRetornarNull() {
        assertFalse(contatoRepository.findById(3).isPresent());
    }

    @Test
    public void buscarPorValorInexistenteRetornarNull() {
        assertNull(contatoRepository.findByValor("telefone"));
    }

    @Test
    public void buscarPorTipoContatoInexistenteRetornarTamanhoZero() {
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("Facebook");
        TipoContato newTipo = tipoContatoRepository.save(tipoContato);
        assertEquals(0, contatoRepository.findAllByTipoContato(newTipo).size());
    }
}
