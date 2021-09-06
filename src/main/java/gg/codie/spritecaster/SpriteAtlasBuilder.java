package gg.codie.spritecaster;

import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;

public class SpriteAtlasBuilder {
    private BufferedImage[][] sprites = new BufferedImage[16][16];
    private int rowCount = 16;
    private int colCount = 16;
    private int spriteSize = 0;

    public SpriteAtlasBuilder setRowCount(int rowCount) {
        this.rowCount = rowCount;
        return this;
    }

    public SpriteAtlasBuilder setColCount(int colCount) {
        this.colCount = colCount;
        return this;
    }

    public SpriteAtlasBuilder registerSprite(BufferedImage sprite, int row, int column) {
        // Animated sprites are tall, we only take the top square.
        if (sprite != null) {
            sprites[row - 1][column - 1] = sprite.getSubimage(0, 0, sprite.getWidth(), sprite.getWidth());
            if (sprite.getWidth() > spriteSize)
                spriteSize = sprite.getWidth();
        }
        return this;
    }

    public SpriteAtlas build() {
        return new SpriteAtlas(sprites, rowCount, colCount, spriteSize);
    }
}
