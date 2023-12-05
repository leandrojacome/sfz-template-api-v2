package br.gov.al.sefaz.template.config;

import br.gov.al.sefaz.database.config.EnableSefazOracleDatabase;
import br.gov.al.sefaz.logging.spring.EnableSefazLogging;
import br.gov.al.sefaz.security.configuration.EnableSefazJwtSecurity;
import br.gov.al.sefaz.security.service.AuthenticationContextService;
import br.gov.al.sefaz.security.service.UsuarioScaAutenticadoFornecedorIdentidadeHistoricoDados;
import br.gov.al.sefaz.web.exceptionhandling.config.EnableSefazExceptionHandling;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Atenção: A ordem de declaração das configurações pode afetar o funcionamento da aplicação
@Configuration
@EnableSefazLogging
@EnableSefazExceptionHandling
@EnableSefazJwtSecurity
@EnableSefazOracleDatabase
public class SefazConfiguration {

    // TODO: implementar bean para fornecer identidade de histórico com base na autenticação do Token JWT
    @Bean
    UsuarioScaAutenticadoFornecedorIdentidadeHistoricoDados fornecedoridentidadeHistoricoDados(
            AuthenticationContextService authenticationContextService) {
        return new UsuarioScaAutenticadoFornecedorIdentidadeHistoricoDados(authenticationContextService);
    }

}
