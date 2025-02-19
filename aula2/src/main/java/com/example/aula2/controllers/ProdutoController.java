package com.example.aula2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula2.models.Produto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    private long idInicial = 1;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Produto produto) {
        produto.setId(idInicial++);
        produtos.add(produto);
    }

    @GetMapping()
    public List<Produto> getProdutos() {
        return produtos;
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }

    @PutMapping("{id}")
    public void editar(@PathVariable Long id,
            @RequestBody Produto produto) {
        Produto prod = produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow();

        prod.setNome(produto.getNome());
        prod.setPreco(produto.getPreco());

    }

}
