package edu.hiikkie.LiterAlura.application.entities;

import edu.hiikkie.LiterAlura.application.entities.deserializeEntities.LivroDeserializer;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Livros")
public class Livro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(unique = true, nullable = false)
  String titulo;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  List<Autor> autores;

  String linguas;

  int contagemDownloads;

  public Livro(LivroDeserializer livroDeserializer) {
    this.titulo = livroDeserializer.titulo();
    this.autores = Autor.mapToAutoresList(livroDeserializer.autores());
    this.linguas = String.join(", ", livroDeserializer.linguas());
    this.contagemDownloads = livroDeserializer.contagemDownloads();
  }

  public Livro() {

  }

  @Override
  public String toString() {
    return "\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x"+
           "\nLIVRO: " +
           "\nNome: " + titulo +
           "\nIdioma: " + linguas +
           "\nAutor: " + autores.toString() +
           "\nQuantidade De Downloads: " + contagemDownloads +
           "\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n";
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Autor> getAutores() {
    return autores;
  }

  public void setAutores(List<Autor> autores) {
    this.autores = autores;
  }

  public int getContagemDownloads() {
    return contagemDownloads;
  }

  public void setContagemDownloads(int contagemDownloads) {
    this.contagemDownloads = contagemDownloads;
  }

  public String getLinguas() {
    return linguas;
  }

  public void setLinguas(String linguas) {
    this.linguas = linguas;
  }
}
