package edu.hiikkie.LiterAlura.application;

import edu.hiikkie.LiterAlura.application.useCases.Autor.AutorUseCases;
import edu.hiikkie.LiterAlura.application.useCases.Livro.LivroUseCases;
import edu.hiikkie.LiterAlura.services.gutendexAPI.GutendexUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class MainApplication {
  boolean loopIteracao = true;

  GutendexUseCases gutendexUseCases;
  LivroUseCases livroUseCases;
  AutorUseCases autorUseCases;

  @Autowired
  public MainApplication(GutendexUseCases gutendexUseCases, LivroUseCases LivroUseCases, AutorUseCases autorUseCases) {
    this.gutendexUseCases = gutendexUseCases;
    this.livroUseCases = LivroUseCases;
    this.autorUseCases = autorUseCases;
  }

  public void run() throws IOException, InterruptedException {
    Scanner scanner = new Scanner(System.in);
    do {
      String menu = """
          **********************************************
                       Escolha uma opção:
                       
          1 - Buscar livro pelo titulo
          2 - Listar livros registrados
          3 - Listar autores registrados
          4 - Listar autores vivos em determinado ano
          5 - Listar livros em determinado idioma
                
          0 - Sair
          **********************************************""";
      System.out.println(menu);
      int escolha = scanner.nextInt();
      scanner.nextLine();

      switch (escolha) {
        case 1:
          System.out.println("Digite o titulo: ");
          System.out.println(gutendexUseCases.consultarLivro(scanner.nextLine()).toString());
          break;
        case 2:
          System.out.println(livroUseCases.listarLivrosRegistrados());
          break;
        case 3:
          System.out.println(autorUseCases.listarAutoresRegistrados());
          break;
        case 4:
          System.out.println("Escreva por favor o ano inicial da filtragem");
          int anoInicial = scanner.nextInt();
          scanner.nextLine();
          System.out.println("Agora escreva o ano final da filtragem");
          int anoFinal = scanner.nextInt();
          scanner.nextLine();

          System.out.println("!-!-!-!-!-!-!-!-!-!-!\nAqui está a lista de autores vivos nesse período:\n");
          System.out.println(autorUseCases.listarAutoresVivosPorPeriodo(anoInicial, anoFinal).toString());
          break;
        case 5:
          System.out.println("Escreva o idioma.");
          System.out.println("""
          **********************************************
          Sugestões:
          pt- Português
          en- Inglês
          de- Alemão
          fi- finlandês
          **********************************************""");
          System.out.println(livroUseCases.listarLivrosIdioma(scanner.nextLine()));
          break;
        case 0:
          loopIteracao = false;
          break;
        default:
          System.out.println("Opção inválida");
          break;
      }

    } while (loopIteracao);
  }
}
