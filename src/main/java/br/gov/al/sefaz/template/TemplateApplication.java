package br.gov.al.sefaz.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.util.ObjectUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class TemplateApplication {

	private static final Logger log = LoggerFactory.getLogger(TemplateApplication.class);

	public static void main(String[] args) {
		var context = SpringApplication.run(TemplateApplication.class, args);
        logApplicationStartup(context.getEnvironment());
	}

	private static void logApplicationStartup(Environment env) {
        var protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        var serverPort = env.getProperty("server.port");
        var contextPath = env.getProperty("server.servlet.context-path");
        if (ObjectUtils.isEmpty(contextPath)) {
            contextPath = "/";
        }
        var hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("""
            ----------------------------------------------------------
            \tApplication '{}' is running! Access URLs:
            \tLocal: \t\t{}://localhost:{}{}
            \tExternal: \t{}://{}:{}{}
            \tProfile(s): \t{}
            ----------------------------------------------------------
            """,
            env.getProperty("spring.application.name"),
            protocol,
            serverPort,
            contextPath,
            protocol,
            hostAddress,
            serverPort,
            contextPath,
            env.getActiveProfiles());

    }
}
