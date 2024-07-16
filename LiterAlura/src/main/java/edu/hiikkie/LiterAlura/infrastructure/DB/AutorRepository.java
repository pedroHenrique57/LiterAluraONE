package edu.hiikkie.LiterAlura.infrastructure.DB;

import edu.hiikkie.LiterAlura.application.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

  @Query("SELECT a FROM Autor a WHERE a.anoNascimento BETWEEN :anoNascimento AND :anoMorte AND a.anoMorte BETWEEN :anoNascimento AND :anoMorte")
  List<Autor> filtrarPorAnoNascimentoEAnoMorte(int anoNascimento, int anoMorte);
}
