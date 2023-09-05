package br.com.fiap.cadastroaluno.repository;

import br.com.fiap.cadastroaluno.domain.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("from Aluno a " +
            "where a.nome like %:nome%")
    List<Aluno> buscarAlunoPorNome(String nome);

    List<Aluno> findAllByNomeLike(String nome);
}