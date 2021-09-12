package gg.codie.spritecaster;

import gg.codie.spritecaster.resourcepacks.ResourcePack;
import gg.codie.spritecaster.resourcepacks.ResourcePackBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePackStack;
import gg.codie.spritecaster.texturepacks.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipFile;

public class Main {
    public static void main(String[] args) throws IOException {
        final Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(".properties"));
            System.out.println("&&&&& SpriteCaster v" + properties.getProperty("version") + " (" + properties.get("commit") + ") &&&&&");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("SpriteCaster loaded.");

        System.out.println("Converting resource pack...");
//        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/Faithless16x.zip"));
//        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/Archive.zip"));
//        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/PaperCutOut_je-1.17.X.zip"));
//        ZipFile resourcePackZip = new ZipFile(new File("/Volumes/Internal Storage/Projects/GitHub/SpriteCaster/src/main/resources/test/Lithos+v1.56+for+1.17.1+.zip"));
        ZipFile resourcePackZip = new ZipFile(new File("C:\\Users\\codie\\Downloads\\PaperCutOut_4.zip"));


        ResourcePack resourcePack = new ResourcePackBuilder(resourcePackZip).build();
        ResourcePackStack resourcePackStack = new ResourcePackStack();
        resourcePackStack.add(resourcePack);
        TexturePack b173TexturePack = new Beta173TexturePackBuilder(resourcePackStack).build();
        TexturePack b166texturePack = new Beta166TexturePackBuilder(resourcePackStack).build();
        TexturePack b1501TexturePack = new Beta1501TexturePackBuilder(resourcePackStack).build();
        TexturePack a11201TexturePack = new Alpha11201TexturePackBuilder(resourcePackStack).build();
        TexturePack a1010TexturePack = new Alpha1010TexturePackBuilder(resourcePackStack).build();
        TexturePack infdev20100618TexturePack = new Infdev20100618TexturePackBuilder(resourcePackStack).build();
        TexturePack indev20100205TexturePack = new Indev20100205TexturePackBuilder(resourcePackStack).build();


        b166texturePack.save();
        b173TexturePack.save();
        b1501TexturePack.save();
        a11201TexturePack.save();
        a1010TexturePack.save();
        infdev20100618TexturePack.save();
        indev20100205TexturePack.save();


        System.out.println("Done!");
    }
}
