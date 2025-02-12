package com.example.aula1.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MeuController {
    @GetMapping("/ola")
    public String getOlaMundo(@RequestParam("n") String nome,
            @RequestParam("t") String tipo) {
        return "Olá " + tipo + " " + nome + "!";
    }

    @GetMapping("/cliente/{id}")
    public String getCliente(@PathVariable("id") int id) {
        return "Cliente de id: " + id;
    }

}
