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
        addMineOnlineTextures();

        return new TexturePack(resourcePack.name + "-" + getMinecraftVersion(), resourcePack.info, textures);
    }

    private void addMineOnlineTextures() {
        addTexture(TexturePackTexture.MINEONLINE_GUI_ICONS, resourcePack.getTexture(ResourcePackTexture.Gui.ICONS));
        addTexture(TexturePackTexture.PANORAMA0, resourcePack.getTexture(ResourcePackTexture.Gui.PANORAMA0));
        addTexture(TexturePackTexture.PANORAMA1, resourcePack.getTexture(ResourcePackTexture.Gui.PANORAMA1));
        addTexture(TexturePackTexture.PANORAMA2, resourcePack.getTexture(ResourcePackTexture.Gui.PANORAMA2));
        addTexture(TexturePackTexture.PANORAMA3, resourcePack.getTexture(ResourcePackTexture.Gui.PANORAMA3));
        addTexture(TexturePackTexture.PANORAMA4, resourcePack.getTexture(ResourcePackTexture.Gui.PANORAMA4));
        addTexture(TexturePackTexture.PANORAMA5, resourcePack.getTexture(ResourcePackTexture.Gui.PANORAMA5));
    }

    abstract String getMinecraftVersion();

    protected final ResourcePack resourcePack;

    AbstractTexturePackBuilder(ResourcePack resourcePack) {
        this.resourcePack = resourcePack;
    }
}
