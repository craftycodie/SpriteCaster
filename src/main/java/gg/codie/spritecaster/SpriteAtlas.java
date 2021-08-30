package gg.codie.spritecaster;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteAtlas {
    private final BufferedImage[][] sprites;
    private final int rowCount = 16;
    private final int colCount = 16;
    private final int spriteSize = 16;
    public SpriteAtlas(BufferedImage[][] sprites) {
        this.sprites = sprites;
    }

    public BufferedImage getImage() {
        BufferedImage atlas = new BufferedImage(spriteSize * rowCount, spriteSize * colCount, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = atlas.createGraphics();

        for(int row = 0; row < rowCount; row++) {
            for(int col = 0; col < colCount; col++) {
                if (sprites[row][col] != null) {
                    graphics2D.drawImage(sprites[row][col], col * spriteSize, row * spriteSize, null);
                }
            }
        }

//        atlas.getGraphics().drawImage()

        return atlas;
    }
}
