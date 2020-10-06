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
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExameRepositoryTest {

    @Autowired
    private TipoContatoRepository tipoContatoRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private InstituicaoRepository instituicaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired

    private TipoExameRepository tipoExameRepository;
    @Autowired
    private ExameRepository exameRepository;

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

        // Endereço
        Endereco endereco2 = new Endereco();
        endereco2.setCidade(cidadeRepository.findByNome("Porto Alegre"));
        endereco2.setCep("98711110");
        endereco2.setBairro("Rio Branco");
        endereco2.setLogradouro("Rua teste");
        endereco2.setNumero(123);
        //Instituicao
        Instituicao instituicao = new Instituicao();
        instituicao.setNome("Hospital");
        instituicao.setEndereco(enderecoRepository.save(endereco2));
        instituicao.setUsuario(usuarioRepository.findById(1).get());

        instituicaoRepository.save(instituicao);

        // TipoExame
        TipoExame tipoExame = new TipoExame();
        tipoExame.setNomeExame("Hemograma");
        tipoExame.setUsuario(usuarioRepository.findById(1).get());

        tipoExameRepository.save(tipoExame);

        // Exame
        Exame exame = new Exame();
        exame.setTipoExame(tipoExameRepository.findByNomeExame("Hemograma"));
        exame.setLinkImage("");
        exame.setInstituicao(instituicaoRepository.findByNome("Hospital"));
        exame.setDataExame(new Date(2020,02,02));

        exameRepository.save(exame);
    }

    @Test
    public void buscarExamePorId() {
        assertTrue(exameRepository.findById(1).isPresent());
    }

    @Test
    public void buscarExamePorData() {
        assertTrue(exameRepository.findByDataExame(new Date(2020,02,02)).getId().equals(1));
    }

    @Test
    public void buscarTodosExamesPorTipoExame() {

        // Exame
        Exame exame = new Exame();
        exame.setTipoExame(tipoExameRepository.findByNomeExame("Hemograma"));
        exame.setLinkImage("");
        exame.setInstituicao(instituicaoRepository.findByNome("Hospital"));
        exame.setDataExame(new Date(2020,04,04));

        exameRepository.save(exame);

        assertEquals(2, exameRepository.findAllByTipoExame(tipoExameRepository.findById(1).get()).size());
    }

    @Test
    public void buscarExamePorIdInexistenteRetornarFalse(){
        assertFalse(exameRepository.findById(2).isPresent());
    }

    @Test
    public void buscarExamePorDataInexistenteRetornarNull() {
        assertNull(exameRepository.findByDataExame(new Date(1999,02,02)));
    }

    @Test
    public void buscarTodosExamesPorTipoExameInexistenteRetornarNull(){
        TipoExame tipoExame = new TipoExame();
        tipoExame.setNomeExame("RaioX");
        tipoExameRepository.save(tipoExame);
        assertEquals(0, exameRepository.findAllByTipoExame(tipoExameRepository.findById(2).get()).size());
    }

}
