package com.ifsul.tcc.gerenciadorExames.api.Repository;
import com.ifsul.tcc.gerenciadorExames.api.Entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TipoExameRepositoryTest {

    @Autowired
    private TipoContatoRepository tipoContatoRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TipoExameRepository tipoExameRepository;

    @BeforeAll
    public void init() {
        // TipoContato
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("email");
        // contato
        Contato contato = new Contato();
        contato.setTipoContato(tipoContatoRepository.save(tipoContato));
        contato.setValor("teste@gmail.com");
        // cidade
        Cidade cidade = new Cidade();
        cidade.setNome("Porto Alegre");
        // endereço
        Endereco endereco = new Endereco();
        endereco.setCidade(cidadeRepository.save(cidade));
        endereco.setCep("98700000");
        endereco.setBairro("Passo DAreia");
        endereco.setLogradouro("Rua teste");
        endereco.setNumero(123);
        // usuario
        Usuario usuario = new Usuario();
        List<Contato> listContato = new ArrayList<>();
        listContato.add(contatoRepository.save(contato));
        usuario.setContatos(listContato);
        usuario.setEndereco(enderecoRepository.save(endereco));
        usuario.setNome("Mario");
        usuario.setCpf("12345678998");
        usuario.setDataNascimento(new Date(System.currentTimeMillis()));
        usuario.setLogin("mario");
        usuario.setSenha("1234567");

        usuarioRepository.save(usuario);

        // TipoExame
        TipoExame tipoExame = new TipoExame();
        tipoExame.setNomeExame("Hemograma");
        tipoExame.setUsuario(usuarioRepository.findById(1).get());

        tipoExameRepository.save(tipoExame);
    }

    @Test
    public void buscarTipoExamePorId() {
        assertTrue(tipoExameRepository.findById(1).isPresent());
    }

    @Test
    public void buscarTipoExamePorNomeExame() {
        assertEquals("Hemograma", tipoExameRepository.findByNomeExame("Hemograma").getNomeExame());
    }

    @Test
    public void buscarTipoExamePorIdInexistenteRetornarFalse() {
        assertFalse(tipoExameRepository.findById(2).isPresent());
    }

    @Test
    public void buscarTipoExamePorNomeExameInexistenteRetornarNull() {
        assertNull(tipoExameRepository.findByNomeExame("Raio"));
    }

}
