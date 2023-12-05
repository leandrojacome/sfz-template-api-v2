package br.gov.al.sefaz.web.exceptionhandling.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(ProblemHandlingConfiguration.class)
public @interface EnableSefazExceptionHandling {
}
