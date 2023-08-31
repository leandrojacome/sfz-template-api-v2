package br.gov.al.sefaz.template;

import br.gov.al.sefaz.template.domain.Conta;
import br.gov.al.sefaz.template.repository.ContaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TemplateApplicationTest {

	@Autowired MockMvc mockMvc;

	@Autowired ContaRepository contaRepository;

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

	@Test
	@Rollback
	void jpaDeveFuncionarComoEsperado() {

		var sequencialConta = 1L;
		var saldo = new BigDecimal(10);

		var conta = new Conta();
		conta.setSequencialConta(sequencialConta);
		conta.setSaldo(saldo);

		contaRepository.save(conta);

		var contaRecuperada = contaRepository.findById(sequencialConta);
		Assertions.assertThat(contaRecuperada).isPresent();
		Assertions.assertThat(contaRecuperada.get().getSaldo()).isEqualTo(saldo);

	}
}
