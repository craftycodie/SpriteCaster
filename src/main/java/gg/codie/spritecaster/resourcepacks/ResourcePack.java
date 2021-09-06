package gg.codie.spritecaster.resourcepacks;

import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class ResourcePack implements IResourcePack {
    private final Map<Enum, BufferedImage> textures;
    final String info;
    final String name;

    public BufferedImage getTexture(Enum texture) {
//        if (texture == Block.GRASS_TOP_ALPHA) {
//            return Block.GRASS_TOP.green()
//        }

//        if(textures.get(texture) == null) {
//            System.err.println("No texture available for " + texture.name());
//        }

        return textures.get(texture);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return info;
    }

    public ResourcePack(String name, String info, Map<Enum, BufferedImage> textures) {
        this.textures = textures;
        this.info = info;
        this.name = name;
    }
}
