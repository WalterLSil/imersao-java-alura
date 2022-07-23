package util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Caneta {

    private Font fonte;
    private static Graphics2D graphics;

    public static void copiandoImagem(BufferedImage copiaImagem, BufferedImage imagemOriginal){
        graphics = (Graphics2D) copiaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
    }
    public static void copiandoImagem(BufferedImage copiaImagem, BufferedImage imagemOriginal, int x, int y){
        graphics = (Graphics2D) copiaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, x, y, null);
    }

    public static void definicaoFonte(String nome, int estilo, int tamanho, Color color){
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, tamanho);
        graphics.setColor(color);
        graphics.setFont(fonte);
    }

    public static void escreverMensagem(String mensagem, int x, int y){
        graphics.drawString(mensagem, x, y);
    }
}
