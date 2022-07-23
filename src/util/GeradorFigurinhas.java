package util;

import entidades.Imagem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GeradorFigurinhas {

    public GeradorFigurinhas() {
    }

    public void cria(Imagem imagem, String nomeArquivo, String mensagemMeme) throws Exception {

        // leitura da imagem
        Imagem imagemOriginal = imagem;

        // cria nova imagem em memória com transparência e com tamanho novo
        BufferedImage novaImagem = imagemOriginal.cirarNovaImagem(200,0);

        // copiar a imagem original pra novo imagem (em memória)
        Caneta.copiandoImagem(novaImagem, imagemOriginal.getImagem());

        // configurar a fonte
        Caneta.definicaoFonte(Font.SANS_SERIF, Font.BOLD,300,Color.YELLOW);

        // escrever uma frase na nova imagem
        Caneta.escreverMensagem(mensagemMeme, 100, 1638);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("src/saidas/ "+ nomeArquivo + ".png"));

    }
    /*
    public void cria(File file, String nomeArquivo) throws Exception {

        // leitura da imagem
        InputStream inputStream = new FileInputStream(file);
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 100, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
 */
}