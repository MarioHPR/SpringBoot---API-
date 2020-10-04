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
public class ConsultaRepositoryTest {

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
    private InstituicaoRepository instituicaoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @BeforeAll
    public void init(){
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

        // Consulta
        Consulta consulta = new Consulta();
        consulta.setInstituicao(instituicaoRepository.findByNome("Hospital"));
        consulta.setUsuario(usuarioRepository.findById(1).get());
        consulta.setDiagnostico("Gripe");
        consulta.setPrescricao("Tomar remedio de 12 em 12 horas.");
        consulta.setNomeMedico("Dr Tim");
        consulta.setDataConsulta(new Date(System.currentTimeMillis()));
        consulta.setLinkImage("");

        consultaRepository.save(consulta);
    }

    @Test
    public void buscarConsultaPorId() {
        assertTrue(consultaRepository.findById(1).isPresent());
    }

    @Test
    public void buscarConsultaPorDiagnostico() {
        assertEquals("Gripe", consultaRepository.findByDiagnostico("Gripe").getDiagnostico());
    }

    @Test void buscarTodasConsultasPorNomeMedico() {
        assertEquals(1, consultaRepository.findAllByNomeMedico("Dr Tim").size());
    }

    @Test
    public void buscarConsultaPorIdInexistenteRetornarFalse() {
        assertFalse(consultaRepository.findById(2).isPresent());
    }

    @Test
    public void buscarConsultaPorDiagnosticoInexistenteRetornarNull() {
        assertNull(consultaRepository.findByDiagnostico("Corona"));
    }

    @Test
    public void buscarTodasConsultasPorNomeMedicoInexistenteRetornarTamanhoZero() {
        assertEquals(0,consultaRepository.findAllByNomeMedico("Dr Zoon").size());
    }

}
