package com.example.modulo3;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController()
@AllArgsConstructor
public class LanguageController {
    private LanguageRepository repository;

    @GetMapping()
    public String getAllUsers() {
        String body = StreamSupport.stream(repository.findAll().spliterator(), true)
                .map(x -> "<li>" + x.getName() + "</li>")
                .reduce("", (a, b) -> a + b);
        return "<h1>Modulo 3 Gonzalo Mora Conexión MySQL</h1>" +
                "<h3>  Lenguajes de programación</h3></br></br>" +
                "<ul>" + body + "</ul>";
    }
}