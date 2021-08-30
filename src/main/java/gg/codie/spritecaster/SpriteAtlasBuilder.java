package gg.codie.spritecaster;

import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;

public class SpriteAtlasBuilder {
    private BufferedImage[][] sprites = new BufferedImage[16][16];

    public SpriteAtlasBuilder registerSprite(BufferedImage spriteStream, int row, int column) {
        sprites[row-1][column-1] = spriteStream;
        return this;
    }

    public SpriteAtlas build() {
        return new SpriteAtlas(sprites);
    }
}
