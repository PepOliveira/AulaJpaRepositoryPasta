package com.example.projetoescola;

import java.util.List;
import com.example.projetoescola.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.models.Professor;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository,
			@Autowired PessoaRepository pessoaRepository, 
			@Autowired ProfessorRepository professorRepository) {
		return args -> {

			System.out.println("---- Inserindo Professores ----");
			professorRepository.saveAll(List.of
			(new Professor(null, "João Paulo", 4490.0), 
			new Professor(null, "Maria Julia", 6700.0),
			new Professor(null, "Ana", 7127.0), 
			new Professor(null, "Pedro Henrique", 8648.0)));	

			System.out.println("---- Professores com salário maior que 5000 ----");
			List<Professor> professoresMaior = professorRepository.findBySalarioGreaterThanEqual(5000.0);
			professoresMaior.forEach(System.out::println);

			System.out.println("---- Professores com salário menor que 5000 ----");
			List<Professor> professoresMenor = professorRepository.findBySalarioLessThanEqual(5000.0);
			professoresMenor.forEach(System.out::println);

			System.out.println("---- Professores com nome iniciando com A ----");
			List<Professor> professoresA = professorRepository.findByNomeStartingWith("A");
			professoresA.forEach(System.out::println);

			System.out.println("---- Inserindo Cursos ----");
			cursoRepository.save(new Curso(null, "teste", 2000));
			cursoRepository.save(new Curso(null, "teste2", 2050));

			System.out.println("---- Cursos por Nome ----");
			List<Curso> cursos = cursoRepository.findByNome("teste");
			cursos.forEach(System.out::println);

			System.out.println("---- Cursos por Nome LIKE ----");
			cursos = cursoRepository.findByNomeLike("t%");
			cursos.forEach(System.out::println);

			System.out.println("---- Listando Cursos ----");
			List<Curso> listaCursos = cursoRepository.findAll();
			listaCursos.forEach(System.out::println);

			System.out.println("---- Insere Categoria ----");
			CategoriaCurso categ = categoriaRepository.save(new CategoriaCurso(null, "Informática"));

			System.out.println("---- Vincular Curso na categoria ----");
			Curso c1 = cursoRepository.findAll().get(0);
			c1.setCategoriaCurso(categ);
			cursoRepository.save(c1);

			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa = pessoaRepository.save(new Pessoa(null, "João"));
			Pessoa pessoa2 = pessoaRepository.save(new Pessoa(null, "Maria"));

			System.out.println("*** Vincular pessoa ao curso ***");
			c1.addPessoa(pessoa);
			c1.addPessoa(pessoa2);

			cursoRepository.save(c1);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}
}
