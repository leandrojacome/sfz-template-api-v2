package br.gov.al.sefaz.web.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping
    @RequestMapping("/test/exception-translator")
    public String testExceptionTranslator() {
        throw new UnsupportedOperationException("Exceção de teste");
    }

    @GetMapping
    @RequestMapping("/api/401-endpoint")
    public String test403Endpoint() {
        return "OK";
    }

}
