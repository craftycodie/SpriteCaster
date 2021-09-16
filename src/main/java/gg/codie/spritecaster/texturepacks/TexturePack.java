package gg.codie.spritecaster.texturepacks;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TexturePack {
    private final HashMap<TexturePackTexture, BufferedImage> textures;
    public final String name;
    private final String info;

    public TexturePack(String name, String info, HashMap<TexturePackTexture, BufferedImage> textures) {
        this.textures = textures;
        this.name = name;
        this.info = info;
    }

    public void save() {
        File tempFolder = new File(name + File.separator);
        tempFolder.mkdir();

        if (info != null) {
            try (PrintStream out = new PrintStream(new FileOutputStream(new File(tempFolder, "pack.txt")))) {
                out.print(info);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            final Properties properties = new Properties();
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(".properties"));
            try (PrintStream out = new PrintStream(new FileOutputStream(new File(tempFolder, "spritecaster.txt")))) {
                out.print("Resource Pack converted with SpriteCaster v" + properties.getProperty("version") + " (" + properties.getProperty("commit") + ")");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        textures.forEach((texture, image) -> {
            if (image == null) {
                System.out.println("MISSING TEXTURE " + texture);
                return;
            }
            File textureFile = new File(tempFolder, texture.getPath());
            try {
                textureFile.mkdirs();
                textureFile.createNewFile();
                ImageIO.write(image, "png", textureFile);
            } catch (IOException e) {
                System.err.println(texture.getPath());
                e.printStackTrace();
            }
        });

        try {
            Files.deleteIfExists(Paths.get(name + ".zip"));
            Path p = Files.createFile(Paths.get(name + ".zip"));
            try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p))) {
                Path pp = Paths.get(name + File.separator);
                Files.walk(pp)
                        .filter(path -> !Files.isDirectory(path))
                        .forEach(path -> {
                            ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                            try {
                                zs.putNextEntry(zipEntry);
                                Files.copy(path, zs);
                                zs.closeEntry();
                            } catch (IOException e) {
                                System.err.println(e);
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
