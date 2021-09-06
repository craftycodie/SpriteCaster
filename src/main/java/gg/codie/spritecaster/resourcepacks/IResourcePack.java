package gg.codie.spritecaster.resourcepacks;

import java.awt.image.BufferedImage;
import java.util.Map;

public interface IResourcePack {
    BufferedImage getTexture(Enum texture);
    String getName();
    String getDescription();
}
