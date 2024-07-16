package edu.hiikkie.LiterAlura.application.entities;

import edu.hiikkie.LiterAlura.application.entities.deserializeEntities.AutorDeserializer;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Autores")
public class Autor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(unique = true, nullable = false)
  String nome;

  int anoNascimento;

  int anoMorte;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  List<Livro> livros;

  public Autor(AutorDeserializer autorDeserializer) {
    this.anoMorte = autorDeserializer.anoMorte();
    this.anoNascimento = autorDeserializer.anoNascimento();
    this.nome = autorDeserializer.nome();
  }

  public Autor() {
  }

  public static Autor mapToAutor(AutorDeserializer AutorDeserializer) {
    Autor autor = new Autor();
    autor.setNome(AutorDeserializer.nome());
    autor.setAnoMorte(AutorDeserializer.anoMorte());
    autor.setAnoNascimento(AutorDeserializer.anoNascimento());
    return autor;
  }

  public static List<Autor> mapToAutoresList(List<AutorDeserializer> autoresDeserializables) {
    return autoresDeserializables.stream()
        .map(Autor::mapToAutor)
        .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="+
           "\nAUTOR: " +
           "\nNome: " + nome +
           "\nData De Nascimento: " + anoNascimento +
           "\nData De Falecimento: " + anoMorte +
           "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getAnoNascimento() {
    return anoNascimento;
  }

  public int getAnoMorte() {
    return anoMorte;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setAnoNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
  }

  public void setAnoMorte(int anoMorte) {
    this.anoMorte = anoMorte;
  }

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }
}

