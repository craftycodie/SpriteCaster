package gg.codie.spritecaster;

import javax.imageio.stream.ImageInputStream;

public class SpriteAtlas {
    private final ImageInputStream[][] sprites;
    public SpriteAtlas(ImageInputStream[][] sprites) {
        this.sprites = sprites;
    }
}
