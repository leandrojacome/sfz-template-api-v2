package br.gov.al.sefaz.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TemplateApplicationTest {

	@Autowired MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void exceptionTranslatorDeveTradurzirExcecao() throws Exception {

		var resultado = mockMvc.perform(get("/test/exception-translator"));

		resultado.andExpect(status().isNotImplemented())
				.andExpect(jsonPath("$.title", equalTo("Not Implemented")))
				.andExpect(jsonPath("$.detail", equalTo("Exceção de teste")));

	}
}
