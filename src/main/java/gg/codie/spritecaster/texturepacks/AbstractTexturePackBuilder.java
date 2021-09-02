package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.resourcepacks.ResourcePack;
import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.zip.ZipFile;

public abstract class AbstractTexturePackBuilder {
    private HashMap<TexturePackTexture, BufferedImage> textures = new HashMap<TexturePackTexture, BufferedImage>();

    public AbstractTexturePackBuilder addTexture(TexturePackTexture texture, BufferedImage image) {
        textures.put(texture, image);
        return this;
    }

    public TexturePack build() {
        addTexture(TexturePackTexture.PACK, resourcePack.getTexture(ResourcePackTexture.PACK));

        return new TexturePack(resourcePack.name + "-" + getMinecraftVersion(), resourcePack.info, textures);
    }

    private void addMineOnlineTextures() {
        //addTexture()
    }

    abstract String getMinecraftVersion();

    protected final ResourcePack resourcePack;

    AbstractTexturePackBuilder(ResourcePack resourcePack) {
        this.resourcePack = resourcePack;
    }
}
