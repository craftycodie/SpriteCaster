package gg.codie.spritecaster.texturepacks;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TexturePack {
    private final HashMap<TexturePackTexture, BufferedImage> textures;
    public final String name;

    public TexturePack(String name, HashMap<TexturePackTexture, BufferedImage> textures) {
        this.textures = textures;
        this.name = name;
    }

    public void save() {
        File tempFolder = new File(name + File.separator);
        tempFolder.mkdir();
        textures.forEach((texture, image) -> {
            File textureFile = new File(tempFolder, texture.getPath());
            try {
                textureFile.createNewFile();
                ImageIO.write(image, "png", textureFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
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
