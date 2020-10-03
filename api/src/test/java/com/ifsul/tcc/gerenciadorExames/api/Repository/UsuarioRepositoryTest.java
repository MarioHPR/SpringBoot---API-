package com.ifsul.tcc.gerenciadorExames.api.Repository;


import com.ifsul.tcc.gerenciadorExames.api.Entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

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

    @BeforeAll
    public void init(){
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("email");
        // contato | tipoContato
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
    }

    @Test
    public void buscarPorIdRetornarTrue() {
        assertTrue(usuarioRepository.findById(1).isPresent());
    }

    @Test
    public void buscarUsuarioInexistenteRetornarFalse(){
        assertFalse(usuarioRepository.findById(2).isPresent());
    }

    @Test
    public void buscarUsuarioPorLoginRetornarTrue(){
        assertTrue(usuarioRepository.findByLogin("mario").isPresent());
    }

    @Test
    public void buscarUsuarioPorLoginInexistenteRetornarFalse() {
        assertFalse(usuarioRepository.findByLogin("naoExiste").isPresent());
    }

    @Test
    public void buscarUsuarioPorLoginESenhaRetornarTrue(){
        assertTrue(usuarioRepository.findByLoginAndSenha("mario","1234567").isPresent());
    }

    @Test
    public void buscarUsuarioPorLoginESenhaInexistenteRetornarFalse(){
        assertFalse(usuarioRepository.findByLoginAndSenha("Teste","123456789").isPresent());
    }
}
