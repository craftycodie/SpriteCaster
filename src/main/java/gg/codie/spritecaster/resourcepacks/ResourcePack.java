package gg.codie.spritecaster.resourcepacks;

import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class ResourcePack implements IResourcePack {
    private final Map<Enum, BufferedImage> textures;
    private final Map<String, byte[]> files;
    final String info;
    final String name;

    public BufferedImage getTexture(Enum texture) {
        return textures.get(texture);
    }

    public byte[] getFile(String path) {
        return files.get(path);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return info;
    }

    public ResourcePack(String name, String info, Map<Enum, BufferedImage> textures, Map<String, byte[]> files) {
        this.textures = textures;
        this.info = info;
        this.name = name;
        this.files = files;
    }
}
