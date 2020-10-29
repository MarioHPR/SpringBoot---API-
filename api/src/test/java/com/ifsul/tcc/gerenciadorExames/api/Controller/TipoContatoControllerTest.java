package com.ifsul.tcc.gerenciadorExames.api.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifsul.tcc.gerenciadorExames.api.Entity.TipoContato;
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
public class TipoContatoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TipoContatoRepository repository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveRetornar200QuandoConsultarTipoContato() throws Exception {
        URI uri = new URI("/api/tipoContato/todos");
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
    public void salvarERetornarUmTipoContato() throws Exception {
        URI uri = new URI("/api/tipoContato/novo");
        String json = "{\"nome\":\"telefone\"}";

        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("telefone");
        String json2 = objectMapper.writeValueAsString(tipoContato);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json2)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers
                    .jsonPath("$.id").exists()
                ).andExpect(MockMvcResultMatchers
                    .jsonPath("$.nome").value("telefone")
                );
    }

    @Test
    public void deveRetornarUmTipoContato() throws Exception{

        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("novo telefone");

        TipoContato newTipoContato = repository.save(tipoContato);
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/tipoContato/ver/{id}", newTipoContato.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers
                .status()
                .isOk()
        ).andExpect(MockMvcResultMatchers
                .jsonPath("$.nome").value("novo telefone")
        );

    }
}
