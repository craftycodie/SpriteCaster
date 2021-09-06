package gg.codie.spritecaster;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteAtlas {
    private final BufferedImage[][] sprites;
    private final int rowCount;
    private final int colCount;
    private final int spriteSize;
    public SpriteAtlas(BufferedImage[][] sprites, int rowCount, int colCount, int spriteSize) {
        this.sprites = sprites;
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.spriteSize = spriteSize;
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
