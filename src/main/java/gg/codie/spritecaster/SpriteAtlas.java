package gg.codie.spritecaster;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
        BufferedImage atlas = new BufferedImage(spriteSize * colCount, spriteSize * rowCount, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = atlas.createGraphics();

        for(int row = 0; row < rowCount; row++) {
            for(int col = 0; col < colCount; col++) {
                if (sprites[row][col] != null) {
                    BufferedImage slot = sprites[row][col];
                    if (slot.getWidth() < spriteSize) {
                        AffineTransform at = new AffineTransform();
                        at.scale(spriteSize / slot.getWidth(), spriteSize / slot.getWidth());
                        AffineTransformOp scaleOp =
                                new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
                        graphics2D.drawImage(scaleOp.filter(slot, null), col * spriteSize, row * spriteSize, null);
                        continue;
                    }
                    graphics2D.drawImage(sprites[row][col], col * spriteSize, row * spriteSize, null);
                }
            }
        }

//        atlas.getGraphics().drawImage()

        return atlas;
    }
}
