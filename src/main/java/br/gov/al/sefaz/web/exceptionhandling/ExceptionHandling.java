package br.gov.al.sefaz.web.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

@ControllerAdvice
public class ExceptionHandling implements ProblemHandling, SecurityAdviceTrait {
}
