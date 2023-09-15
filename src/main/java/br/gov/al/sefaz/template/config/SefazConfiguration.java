package br.gov.al.sefaz.template.config;

import br.gov.al.sefaz.database.config.EnableSefazOracleDatabase;
import br.gov.al.sefaz.logging.spring.EnableSefazLogging;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSefazLogging
@EnableSefazOracleDatabase
public class SefazConfiguration {
}
