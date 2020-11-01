package com.ifsul.tcc.gerenciadorExames.api.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Contato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import com.ifsul.tcc.gerenciadorExames.api.Repository.ContatoRepository;
import com.ifsul.tcc.gerenciadorExames.api.Repository.TipoContatoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ContatoControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TipoContatoRepository tipoContatoRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveRetornar200QuandoConsultarContato() throws Exception {
        URI uri = new URI("/api/contato/todos");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers
                .status()
                .is(200)
        );
    }

    @Test
    public void salvarERetornarUmContato() throws Exception {
        URI uri = new URI("/api/contato/novo");

        /// tipo contato
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("email");
        /// contato
        Contato contato = new Contato();
        contato.setTipoContato(tipoContatoRepository.save(tipoContato));
        contato.setValor("teste@gmail.com");

        String json = objectMapper.writeValueAsString(contato);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers
                .jsonPath("$.id").exists()
        ).andExpect(MockMvcResultMatchers
                .jsonPath("$.valor").value("teste@gmail.com")
        );
    }

    @Test
    public void deveRetornarUmContato() throws Exception{

        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("celular");

        Contato contato = new Contato();
        contato.setTipoContato(tipoContatoRepository.save(tipoContato));
        contato.setValor("99999999");

        Contato newContato = contatoRepository.save(contato);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/contato/ver/{id}", newContato.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers
                .status()
                .isOk()
        ).andExpect(MockMvcResultMatchers
                .jsonPath("$.valor").value("99999999")
        );
    }
}
