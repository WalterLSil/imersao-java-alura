package util;

import entidades.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratordeFilmes {

    public static List<Filme> parseToFilme(String body) throws Exception {
        List<Filme> filmes = new ArrayList<>();
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        for (Map<String,String> filme: listaDeFilmes) {
            String titulo = filme.get("title");
            String imagem = filme.get("image");
            Double avaliacao = Double.parseDouble(filme.get("imDbRating"));
            filmes.add(new Filme(titulo, imagem, avaliacao));
        }
        return filmes;

    }

}
