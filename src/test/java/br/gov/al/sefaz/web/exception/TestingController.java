package br.gov.al.sefaz.web.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestingController {

    @GetMapping
    @RequestMapping("/exception-translator")
    public String test() {
        throw new UnsupportedOperationException("Exceção de teste");
    }

}
