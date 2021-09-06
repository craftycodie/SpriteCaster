package gg.codie.spritecaster.resourcepacks;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

public class ResourcePackStack extends LinkedList<ResourcePack> implements IResourcePack {
    public ResourcePackStack() {
        super();
        addDefaultResources();
    }

    private void addDefaultResources() {
        try {
            ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/Default-Pack-1.17.X.zip"));
            ResourcePack resourcePack = new ResourcePackBuilder(resourcePackZip).build();
            add(resourcePack);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage getTexture(Enum texture) {
        for (int i = size(); i > 0; i--) {
            ResourcePack resourcePack = get(i - 1);
            BufferedImage bufferedImage = resourcePack.getTexture(texture);
            if (bufferedImage != null)
                return bufferedImage;
        }
        System.err.println("No texture available for " + texture.name());

        return null;
    }

    @Override
    public String getName() {
        if (size() == 2) return get(1).getName();
        return "ResourcePackStack-" + hashCode();
    }

    @Override
    public String getDescription() {
        if (size() == 2) return get(1).getDescription();

        return subList(0, size() - 1).stream().map(resourcePack -> resourcePack.getName()).collect(Collectors.joining(", "));
    }
}