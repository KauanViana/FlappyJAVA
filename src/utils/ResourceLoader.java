package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResourceLoader {

    public static BufferedImage getSprite(String path) {

        try {
            // Carrega a imagem a partir da pasta 'res' na raiz do projeto
            return ImageIO.read(new File("res/sprites/" + path));
        } catch (IOException e) {
            System.err.println("Erro ao carregar o sprite: res/" + path);
            e.printStackTrace();
            return null;
        }

    }
}