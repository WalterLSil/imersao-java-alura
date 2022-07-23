package entidades;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Imagem {

    private String url;
    InputStream inputStream;
    File file;
    BufferedImage imagem;

    public Imagem(String url) throws Exception {
        this.url = url;
        inputStream = new URL(url).openStream();
        imagem = ImageIO.read(inputStream);
    }

    public Imagem(File file) throws Exception {
        inputStream = new FileInputStream(file);
        imagem = ImageIO.read(inputStream);
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public BufferedImage cirarNovaImagem(int altura, int largura){

        int larguraOld = imagem.getWidth();
        int alturaOld = imagem.getHeight();
        altura += alturaOld;
        largura += larguraOld;
        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        return novaImagem;
    }
}
