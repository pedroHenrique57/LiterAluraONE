package edu.hiikkie.LiterAlura.application.useCases.Livro;

import edu.hiikkie.LiterAlura.application.entities.Livro;

import java.util.List;

public interface InterfaceLivroUseCases {
  List<Livro> listarLivrosRegistrados();
  List<Livro> listarLivrosIdioma(String idioma);
  void salvarLivro(Livro livro);
}
