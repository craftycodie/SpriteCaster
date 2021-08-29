package gg.codie.spritecaster.resourcepacks;

import gg.codie.spritecaster.resources.textures.ITexture;

import javax.imageio.stream.ImageInputStream;
import java.util.Map;

public class ResourcePack {
    public final Map<ITexture, ImageInputStream> textures;
    public final String info;

    public ResourcePack(String info, Map<ITexture, ImageInputStream> textures) {
        this.textures = textures;
        this.info = info;
    }
}
