package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoescola.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    public List<Professor> findBySalario (Double salario);

    public List<Professor> findBySalarioGreaterThanEqual (Double salario);
    //perguntar se aq é pra usar GreaterThan -> usar para o salario do professsor maior que
    public List<Professor> findBySalarioLessThanEqual (Double salario);
    //LessThanEqual -> usar para o salario do professor menor que
    public List<Professor> findByNomeStartingWith (String nome);
    //StatingWith -> usar para o nome do professor
    
}
