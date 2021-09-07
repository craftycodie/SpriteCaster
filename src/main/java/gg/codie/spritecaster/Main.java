package gg.codie.spritecaster;

import gg.codie.spritecaster.resourcepacks.ResourcePack;
import gg.codie.spritecaster.resourcepacks.ResourcePackBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePackStack;
import gg.codie.spritecaster.texturepacks.Beta17TexturePackBuilder;
import gg.codie.spritecaster.texturepacks.TexturePack;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("SpriteCaster loaded.");

        System.out.println("Converting resource pack...");
        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/Faithless16x.zip"));
//        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/Archive.zip"));
//        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/PaperCutOut_je-1.17.X.zip"));

        ResourcePack resourcePack = new ResourcePackBuilder(resourcePackZip).build();
        ResourcePackStack resourcePackStack = new ResourcePackStack();
        resourcePackStack.add(resourcePack);
        TexturePack texturePack = new Beta17TexturePackBuilder(resourcePackStack).build();

        texturePack.save();
        System.out.println("Done!");
    }
}
