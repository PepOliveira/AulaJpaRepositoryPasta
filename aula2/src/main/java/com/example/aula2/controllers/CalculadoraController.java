package com.example.aula2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.aula2.dtos.CalculadoraRequestDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CalculadoraController {
    @GetMapping("somar")
    public Double somar(@RequestParam("n1") Double num1,
            @RequestParam("n2") Double num2) {
        return num1 + num2;
    }

    @GetMapping("subtrair/{n1}/{n2}")
    public Double subtrair(@PathVariable("n1") Double num1,
            @PathVariable("n2") Double num2) {
        return num1 - num2;
    }

    @PostMapping("multiplicar")
    public Double multiplicar(
            @RequestBody CalculadoraRequestDTO calc) {
        return calc.getNum1() * calc.getNum2();
    }

    @PutMapping("dividir")
    public Double dividir(
            @RequestBody CalculadoraRequestDTO calc) {
        return calc.getNum1() / calc.getNum2();
    }

    @DeleteMapping("excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        return "Excluindo o id " + id;
    }

}
