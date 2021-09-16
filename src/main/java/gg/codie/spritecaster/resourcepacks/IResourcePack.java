package gg.codie.spritecaster.resourcepacks;

import java.awt.image.BufferedImage;
import java.util.Map;

public interface IResourcePack {
    BufferedImage getTexture(Enum texture);
    byte[] getFile(String path);
    String getName();
    String getDescription();
}
