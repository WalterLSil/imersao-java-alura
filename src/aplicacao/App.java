package aplicacao;

import config.ClienteHttp;
import entidades.Filme;
import util.ExtratordeFilmes;
import util.GeradorFigurinhas;
import util.JsonParser;

import java.util.List;

public class App {
    public static void main(String[] args)  {

        try {
            // fazer uma conexão HTTP e buscar os top 250 filmes
            String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
            ClienteHttp clienteHttp = new ClienteHttp(url);
            String body = clienteHttp.ObterResponse();

        // extrair só os dados que interessam (titulo, poster, classificação)

        List<Filme> listaDeFilmes = ExtratordeFilmes.parseToFilme(body);

        GeradorFigurinhas geradorFigurinhas = new GeradorFigurinhas();

        // exibir e manipular os dados
        for (Filme filme : listaDeFilmes) {
            System.out.println(filme.getTitulo());
            System.out.println(filme.getImagem().getUrl());
            System.out.println(filme.getAvaliacao());
            int estrelas = (int) ((int) filme.getAvaliacao() * 0.5);
            StringBuilder stb = new StringBuilder();
            for (int i = 0; i != estrelas; i++) {
                stb.append("\u2B50");
                System.out.print("\u2B50");
            }

            geradorFigurinhas.cria(filme.getImagem(), filme.getTitulo(), String.valueOf(stb));

            System.out.println();
        }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    }

