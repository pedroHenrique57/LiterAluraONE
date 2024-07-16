package edu.hiikkie.LiterAlura.application.entities.deserializeEntities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hiikkie.LiterAlura.application.entities.Autor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDeserializer(
    @JsonAlias("title")
    String titulo,

    @JsonAlias("authors")
    List<AutorDeserializer> autores,

    @JsonAlias("download_count")
    int contagemDownloads,

    @JsonAlias("languages")
    List<String> linguas


) {
}
