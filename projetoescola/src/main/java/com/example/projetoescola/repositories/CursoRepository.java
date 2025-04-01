package com.example.projetoescola.repositories;

import java.util.List;

import javax.management.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoescola.models.Curso;


public  interface CursoRepository extends JpaRepository<Curso, Long> {  
    //interface é como se fosse um modelo para a criação da classe 
    //criar o basico é isso

public List<Curso>findByNome(String nome);
//permite que crie consultas personalizadas, ou seja, nessa vamos consultar o nome do curso 
//A primeira parte — como find — é o introdutor e o restante — como ByNome — são os critérios 
//basicamente -> select * from curso where nome = ?

public List<Curso>findByNomeLike(String nome);
//select * from curso where nome like ?
//o like é para pesquisar por parte do nome
    
}
