package edu.hiikkie.LiterAlura.application.useCases.Autor;

import edu.hiikkie.LiterAlura.application.entities.Autor;
import edu.hiikkie.LiterAlura.infrastructure.DB.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorUseCases implements InterfaceAutorUseCases{

  AutorRepository autorRepository;

  @Autowired
  public AutorUseCases(AutorRepository autorRepository) {
    this.autorRepository = autorRepository;
  }

  @Override
  public List<Autor> listarAutoresRegistrados() {
    return autorRepository.findAll();
  }

  @Override
  public List<Autor> listarAutoresVivosPorPeriodo(int anoBase, int anoFinal) {
    return autorRepository.filtrarPorAnoNascimentoEAnoMorte(anoBase,anoFinal);
  }
}
