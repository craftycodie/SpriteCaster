package gg.codie.spritecaster;

import javax.imageio.stream.ImageInputStream;

public class SpriteAtlasBuilder {
    private ImageInputStream[][] sprites = new ImageInputStream[16][16];

    public SpriteAtlasBuilder registerSprite(ImageInputStream spriteStream, int row, int column) {
        sprites[row-1][column-1] = spriteStream;
        return this;
    }

    public SpriteAtlas build() {
        return new SpriteAtlas(sprites);
    }
}
