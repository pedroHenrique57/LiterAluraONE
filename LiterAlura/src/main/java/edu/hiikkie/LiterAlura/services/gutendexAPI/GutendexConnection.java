package edu.hiikkie.LiterAlura.services.gutendexAPI;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GutendexConnection {

  public String consultaAPI(String queryParameter) throws IOException, InterruptedException {
    //Cria a URL para a consulta da moeda correta
    String URL = "https://gutendex.com/books?" + queryParameter;

    // Cria um HTTPClient
    HttpClient client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.ALWAYS)
        .build();

    //Cria o URI do URL

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL))
        .build();

    // Faz a requisição
    HttpResponse<String> requestResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

    // Retorna o retorno da requisição
    return requestResponse.body();
  }
}
