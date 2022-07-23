package entidades;

import java.io.IOException;

public class Filme {

    private String titulo;
    private Imagem imagem;
    private double avaliacao;

    public Filme(String titulo, String url, double avaliacao) throws Exception {
        this.titulo = titulo;
        imagem = new Imagem (url);
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(String url) {
        imagem.setUrl(url);
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

}
