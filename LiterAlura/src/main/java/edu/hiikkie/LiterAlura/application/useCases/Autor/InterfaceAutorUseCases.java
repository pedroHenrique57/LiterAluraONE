package edu.hiikkie.LiterAlura.application.useCases.Autor;

import edu.hiikkie.LiterAlura.application.entities.Autor;

import java.util.List;

public interface InterfaceAutorUseCases {
  List<Autor> listarAutoresRegistrados();
  List<Autor> listarAutoresVivosPorPeriodo(int anoBase, int anoFinal);
}
