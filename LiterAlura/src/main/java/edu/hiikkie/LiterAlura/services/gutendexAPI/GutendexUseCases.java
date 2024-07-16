package edu.hiikkie.LiterAlura.services.gutendexAPI;

import edu.hiikkie.LiterAlura.application.entities.Livro;
import edu.hiikkie.LiterAlura.application.entities.deserializeEntities.LivroDeserializer;
import edu.hiikkie.LiterAlura.application.useCases.Livro.LivroUseCases;
import edu.hiikkie.LiterAlura.services.JsonToEntityConverter.JsonToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GutendexUseCases {

  private final GutendexConnection gutendexConnection;
  private final JsonToEntityConverter jsonToEntityConverter;
  private final LivroUseCases livroUseCases;

  @Autowired
  public GutendexUseCases(GutendexConnection gutendexConnection, JsonToEntityConverter jsonToEntityConverter, LivroUseCases livroUseCases) {
    this.gutendexConnection = gutendexConnection;
    this.jsonToEntityConverter = jsonToEntityConverter;
    this.livroUseCases = livroUseCases;
  }

  public List<Livro> consultarLivro(String nomeLivro) throws IOException, InterruptedException {
    // Formata o query param para fazer a requisição.
    String queryParameterConsultarLivro = "search=" + nomeLivro.replace(" ", "%20");
    // Faz a requisição e a salva em uma var
    List<Livro> response = (List<Livro>) jsonToEntityConverter.converterDados(gutendexConnection.consultaAPI(queryParameterConsultarLivro), LivroDeserializer.class);
    // Manda a lista de livros em String para salvar. motivo: regra de negocio. não questione. só aceite. é isso.
    salvarLivro(response);
    // Retorna a lista de livros em string para consumo do método.
    return response;
  }

  private void salvarLivro(List<Livro> listaLivros) throws IOException, InterruptedException {
    for (Livro livro : listaLivros) {
        livroUseCases.salvarLivro(livro);
    }
  }
}
