package br.gov.al.sefaz.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@Configuration
@Profile("vault")
@Import(EnvironmentVaultConfiguration.class)
@VaultPropertySource(
        value = "${sefaz-vault.secrets-path}",
        propertyNamePrefix = "vault."
)
public class VaultConfiguration {

}
