package gg.codie.spritecaster.resourcepacks;

import gg.codie.minecraft.MinecraftVersionsService;
import gg.codie.spritecaster.SpriteCasterFiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

public class ResourcePackStack extends LinkedList<ResourcePack> implements IResourcePack {
    public ResourcePackStack() {
        super();
        addDefaultResources();
    }

    private void addDefaultResources() {
        try {
            ZipFile resourcePackZip = new ZipFile(new File(SpriteCasterFiles.SPRITECASTER_BACKUPS_ZIP));
            ResourcePack resourcePack = new ResourcePackBuilder(resourcePackZip).build();
            add(resourcePack);
            resourcePackZip = new MinecraftVersionsService().getLatestVersion();
            resourcePack = new ResourcePackBuilder(resourcePackZip).build();
            add(resourcePack);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage getTexture(String texture) {
        for (int i = size(); i > 0; i--) {
            ResourcePack resourcePack = get(i - 1);
            BufferedImage bufferedImage = resourcePack.getTexture(texture);
            if (bufferedImage != null) {
                BufferedImage correctedType = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = correctedType.createGraphics();
                g2.drawImage(bufferedImage, 0, 0, null);
                return correctedType;
            }
        }
        System.err.println("No texture available for " + texture);

        return null;
    }

    @Override
    public BufferedImage getTexture(Enum texture) {
        return getTexture(texture.name());
    }

    @Override
    public byte[] getFile(String path) {
        for (int i = size(); i > 0; i--) {
            ResourcePack resourcePack = get(i - 1);
            byte[] content = resourcePack.getFile(path);
            if (content != null) {
                return content;
            }
        }
        System.err.println("No file available for " + path);

        return null;
    }

    @Override
    public String getName() {
        if (size() == 3) return get(2).getName();
        return "ResourcePackStack-" + hashCode();
    }

    @Override
    public String getDescription() {
        if (size() == 3) return get(2).getDescription();

        return subList(2, size() - 2).stream().map(resourcePack -> resourcePack.getName()).collect(Collectors.joining(", "));
    }
}
