package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.SpriteCasterFiles;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TexturePack {
    private final HashMap<String, BufferedImage> textures;
    private final HashMap<String, byte[]> files;
    public final String name;
    private final String info;

    public TexturePack(String name, String info, HashMap<String, BufferedImage> textures, HashMap<String, byte[]> files) {
        this.textures = textures;
        this.files = files;
        this.name = name;
        this.info = info;
    }

    public void save() {
        File tempFolder = new File(SpriteCasterFiles.SPRITECASTER_TEMP_FOLDER + name);
        tempFolder.mkdir();

        files.forEach((file, content) -> {
            if (content == null) {
                System.out.println("MISSING FILE " + file);
                return;
            }
            try (PrintStream out = new PrintStream(new FileOutputStream(new File(tempFolder, file)))) {
                out.print(new String(content));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        textures.forEach((texture, image) -> {
            if (image == null) {
                System.out.println("MISSING TEXTURE " + texture);
                return;
            }
            File textureFile = new File(tempFolder, texture);
            try {
                textureFile.mkdirs();
                textureFile.createNewFile();
                ImageIO.write(image, "png", textureFile);
            } catch (IOException e) {
                System.err.println(texture);
                e.printStackTrace();
            }
        });

        try {
            Files.deleteIfExists(new File(SpriteCasterFiles.MINECRAFT_TEXTURE_PACKS_PATH + name + ".zip").toPath());
            Path p = Files.createFile(new File(SpriteCasterFiles.MINECRAFT_TEXTURE_PACKS_PATH + name + ".zip").toPath());
            try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p))) {
                Path pp = Paths.get(SpriteCasterFiles.SPRITECASTER_TEMP_FOLDER + name + File.separator);
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
                FileUtils.deleteDirectory(tempFolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
