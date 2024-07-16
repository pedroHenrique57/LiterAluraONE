package edu.hiikkie.LiterAlura.application.useCases.Livro;

import edu.hiikkie.LiterAlura.application.entities.Livro;
import edu.hiikkie.LiterAlura.infrastructure.DB.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroUseCases implements InterfaceLivroUseCases{

  LivroRepository livroRepository;

  @Autowired
  public LivroUseCases(LivroRepository livroRepository) {
    this.livroRepository = livroRepository;
  }

  @Override
  public List<Livro> listarLivrosRegistrados() {
    return livroRepository.findAll();
  }

  @Override
  public List<Livro> listarLivrosIdioma(String idioma) {
    return livroRepository.filtrarPorLingua(idioma);
  }

  @Override
  public void salvarLivro(Livro livro) {
    try {
      livroRepository.save(livro);
    } catch (Exception e) {
      //Faz nada só para não printar no console os erros de valor já existente da tabela.
    }

  }
}
