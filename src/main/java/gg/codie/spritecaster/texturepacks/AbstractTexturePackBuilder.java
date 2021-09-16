package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.resourcepacks.ResourcePackStack;
import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

public abstract class AbstractTexturePackBuilder {
    private HashMap<String, BufferedImage> textures = new HashMap<>();
    private HashMap<String, byte[]> files = new HashMap<>();

    public AbstractTexturePackBuilder addTexture(TexturePackTexture texture, BufferedImage image) {
        textures.put(texture.getPath(), image);
        return this;
    }

    public AbstractTexturePackBuilder addTexture(String texture, BufferedImage image) {
        textures.put(texture, image);
        return this;
    }

    public AbstractTexturePackBuilder addFile(TexturePackFile texturePackFile, byte[] content) {
        files.put(texturePackFile.getPath(), content);
        return this;
    }

    public TexturePack build() {
        addTexture(TexturePackTexture.PACK, resourcePack.getTexture(ResourcePackTexture.PACK));
        addFile(TexturePackFile.PACK_FILE, resourcePack.getDescription().getBytes(StandardCharsets.UTF_8));
        addFile(TexturePackFile.SPRITECASTER_INFO, getSpriteCasterInfo().getBytes(StandardCharsets.UTF_8));
        addMineOnlineTextures();

        return new TexturePack(resourcePack.getName() + "-" + getMinecraftVersion(), resourcePack.getDescription(), textures, files);
    }

    private String getSpriteCasterInfo() {
        try {
            final Properties properties = new Properties();
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(".properties"));
            return "Resource Pack converted with SpriteCaster v" + properties.getProperty("version") + " (" + properties.getProperty("commit") + ")";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
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

    protected final ResourcePackStack resourcePack;

    AbstractTexturePackBuilder(ResourcePackStack resourcePack) {
        this.resourcePack = resourcePack;
    }
}
