package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.resourcepacks.ResourcePack;

import java.util.zip.ZipFile;

public interface ITexturePack {
    public ITexturePack fromResourcePack(ResourcePack resourcePack);
    public ZipFile save();
}
