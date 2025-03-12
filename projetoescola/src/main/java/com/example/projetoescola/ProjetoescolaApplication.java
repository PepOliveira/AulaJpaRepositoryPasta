package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository,
			@Autowired PessoaRepository pessoaRepository) {
		return args -> {
			System.out.println("---- Inserindo Cursos ----");
			cursoRepository.salvar(
					new Curso(null, "teste", 2000));
			cursoRepository.salvar(
					new Curso(null, "teste2", 2050));
			System.out.println("---- Listando Cursos ----");
			List<Curso> listaCursos = cursoRepository.obterTodos();
			listaCursos.forEach(System.out::println);
			System.out.println("---- Insere Categoria ----");
			CategoriaCurso categ = categoriaRepository.salvar(
					new CategoriaCurso(null, "Informática"));
			System.out.println("---- Vincular Curso na categoria ----");
			Curso c1 = cursoRepository.obterTodos().get(0);
			c1.setCategoriaCurso(categ);
			cursoRepository.salvar(c1);
			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa = pessoaRepository.salvar(
					new Pessoa(null, "João"));

			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa2 = pessoaRepository.salvar(
					new Pessoa(null, "maria"));

			System.out.println("*** Vincular pessoa ao curso ***");
			c1.addPessoa(pessoa);
			c1.addPessoa(pessoa2);

			cursoRepository.salvar(c1);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
