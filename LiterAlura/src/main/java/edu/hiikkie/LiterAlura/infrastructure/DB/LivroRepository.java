package edu.hiikkie.LiterAlura.infrastructure.DB;

import edu.hiikkie.LiterAlura.application.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

  @Query("SELECT l FROM Livro l WHERE l.linguas = :linguaParametro ")
  List<Livro> filtrarPorLingua(String linguaParametro);
}
