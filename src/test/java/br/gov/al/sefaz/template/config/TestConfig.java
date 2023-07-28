package br.gov.al.sefaz.template.config;

import br.gov.al.sefaz.web.exception.TestingController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TestingController controllerTeste() {
        return new TestingController();
    }

}
