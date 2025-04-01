package com.example.projetoescola.repositories;

//JpaRepository recebe primeiro a classe ou entidade e o segundo parametro é o tipo de dado da chave primaria da entidade


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoescola.models.CategoriaCurso;


public interface CategoriaCursoRepository extends JpaRepository<CategoriaCurso, Integer> { 
    //dentro do <> voce coloca as coisas da classe -> como no CategoriaCurso eu tenho Integer eu coloco Integer 
    //tipo de dado da chave primaria da entidade CategoriaCurso é Integer



    

}
