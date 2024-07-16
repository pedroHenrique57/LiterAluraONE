package edu.hiikkie.LiterAlura.application.entities.deserializeEntities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDeserializer(
    @JsonAlias("name")
    String nome,

    @JsonAlias("birth_year")
    int anoNascimento,

    @JsonAlias("death_year")
    int anoMorte
) {
}

