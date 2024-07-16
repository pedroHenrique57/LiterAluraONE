package edu.hiikkie.LiterAlura.services.JsonToEntityConverter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hiikkie.LiterAlura.application.entities.Autor;
import edu.hiikkie.LiterAlura.application.entities.Livro;
import edu.hiikkie.LiterAlura.application.entities.deserializeEntities.AutorDeserializer;
import edu.hiikkie.LiterAlura.application.entities.deserializeEntities.LivroDeserializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsonToEntityConverter implements InterfaceJsonToEntityConverter{
  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public <T> List<?> converterDados(String json, Class<T> classe) {

    try {
      // Cria um Json node para navegar nas arrays do json.
      JsonNode jNodeResponse = mapper.readTree(json);

      if (classe == LivroDeserializer.class) {
        // Cria um List para salvar os elementos.
        List<Livro> listaLivro = new ArrayList<>();

        // Para cada elemento do results, deserialize e adicione na listaLivro
        for (JsonNode jNodeResults : jNodeResponse.get("results")) {
          // deserializa os dados
          LivroDeserializer livroDeserializer = mapper.treeToValue(jNodeResults, LivroDeserializer.class);
          //Converte para um livro de persistencia e adiciona na lista
          listaLivro.add(new Livro(livroDeserializer));
        }
        // Apos rodar iteração com todos os livros, retorne a listaLivro
        return listaLivro;

      } else if (classe == AutorDeserializer.class) {
        // Cria um List para salvar os elementos.
        List<Autor> listaAutor = new ArrayList<>();
        // Cria um Json node para navegar nas arrays do json.
        // Para cada livro dentro de resultado, faça:
          for (JsonNode jNodeResults : jNodeResponse.get("results")) {
            // Para cada AutorDeserializer dentro de livro, faça:
            JsonNode authorsNode = jNodeResults.get("authors");

              // Adicione cada autor a lista
              for (JsonNode jNodeAuthors : jNodeResults) {
                AutorDeserializer AutorDeserializer = mapper.treeToValue(jNodeAuthors, AutorDeserializer.class);
                listaAutor.add(new Autor(AutorDeserializer));
              }
          }
        // Apos rodar iteração com todos os autores de livros, retorne a listaAutor
        return listaAutor;
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
