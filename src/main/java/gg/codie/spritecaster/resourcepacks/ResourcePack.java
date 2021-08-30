package gg.codie.spritecaster.resourcepacks;

import java.awt.image.BufferedImage;
import java.util.Map;

public class ResourcePack {
    private final Map<Enum, BufferedImage> textures;
    public final String info;
    public final String name;

    public BufferedImage getTexture(Enum texture) {
//        if (texture == Block.GRASS_TOP_ALPHA) {
//            return Block.GRASS_TOP.green()
//        }

        if(textures.get(texture) == null) {
            System.err.println("No texture available for " + texture.name());
        }

        return textures.get(texture);
    }

    public ResourcePack(String name, String info, Map<Enum, BufferedImage> textures) {
        this.textures = textures;
        this.info = info;
        this.name = name;
    }
}
