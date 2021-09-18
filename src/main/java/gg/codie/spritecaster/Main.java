package gg.codie.spritecaster;

import gg.codie.spritecaster.gui.FrameManager;
import gg.codie.spritecaster.resourcepacks.ResourcePack;
import gg.codie.spritecaster.resourcepacks.ResourcePackBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePackStack;
import gg.codie.spritecaster.texturepacks.*;
import gg.codie.spritecaster.utils.Logging;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipFile;

public class Main {
    public static void main(String[] args) throws IOException {
        final Properties properties = new Properties();
        properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(".properties"));
        Logging.enableLogging();
        System.out.println("&&& SpriteCaster v" + properties.getProperty("version") + " (" + properties.getProperty("commit") + ") &&&");
        FrameManager.init();
    }
}
