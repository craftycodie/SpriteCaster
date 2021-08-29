package gg.codie.spritecaster.resourcepacks;

import gg.codie.spritecaster.resources.textures.ITexture;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.stream.ImageInputStream;
import java.util.Map;

public class ResourcePackBuilder {
    Map<ITexture, ImageInputStream> textures;
    String info = null;

    public ResourcePackBuilder withInfo(String info) {
        this.info = info;
        return this;
    }

    public ResourcePackBuilder withTexture(ITexture texture, String relativePath) {
        throw new NotImplementedException();
//        textures.put(texture, )
//        return this;
    }

    public ResourcePack build() {
        return new ResourcePack(info, textures);
    }
}
