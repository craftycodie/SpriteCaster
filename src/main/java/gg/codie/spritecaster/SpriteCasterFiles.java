package gg.codie.spritecaster;

import gg.codie.common.utils.OSUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SpriteCasterFiles {
    public static final String OLD_MINECRAFT_FOLDER = getOldMinecraftDirectory().getPath();
    public static final String NEW_MINECRAFT_FOLDER = getNewMinecraftDirectory().getPath();
    public static final String SPRITECASTER_FOLDER = getSpriteCasterDirectory().getPath() + File.separator;

    public static final String SPRITECASTER_TEMP_FOLDER = SPRITECASTER_FOLDER + "temp" + File.separator;
    public static final String SPRITECASTER_LATEST_LOG = SPRITECASTER_FOLDER + "latest.log";
    public static final String SPRITECASTER_BACKUPS_ZIP = SPRITECASTER_FOLDER + "SpriteCasterBackups.zip";


    public static final String MINECRAFT_TEXTURE_PACKS_PATH = OLD_MINECRAFT_FOLDER + File.separator + "texturepacks" + File.separator;
    public static final String MINECRAFT_RESOURCE_PACKS_PATH = NEW_MINECRAFT_FOLDER + File.separator + "resourcepacks" + File.separator;
    public static final String MINECRAFT_VERSIONS_PATH = NEW_MINECRAFT_FOLDER + File.separator + "versions" + File.separator;

    private static File getSpriteCasterDirectory() {
        File workingDirectory;
        String applicationData, userHome = System.getProperty("user.home", ".");

        switch (OSUtils.getPlatform()) {
            case solaris:
                workingDirectory = new File(userHome, ".spritecaster/");
                break;
            case windows:
                applicationData = System.getenv("APPDATA");
                if (applicationData != null) {
                    workingDirectory = new File(applicationData, "." + "spritecaster/");
                    break;
                }
                workingDirectory = new File(userHome, ".spritecaster/");
                break;
            case macosx:
                workingDirectory = new File(userHome, "Library/Application Support/spritecaster/");
                break;
            default:
                workingDirectory = new File(userHome, "spritecaster/"); break;
        }
        if (!workingDirectory.exists() && !workingDirectory.mkdirs())
            throw new RuntimeException("The working directory could not be created: " + workingDirectory);

        return workingDirectory;
    }

    private static File getOldMinecraftDirectory() {
        File workingDirectory;
        String applicationData, userHome = System.getProperty("user.home", ".");

        switch (OSUtils.getPlatform()) {
            case solaris:
                workingDirectory = new File(userHome, ".minecraft/");
                break;
            case windows:
                applicationData = System.getenv("APPDATA");
                if (applicationData != null) {
                    workingDirectory = new File(applicationData, ".minecraft/");
                    break;
                }
                workingDirectory = new File(userHome, ".minecraft/");
                break;
            case macosx:
                workingDirectory = new File(userHome, "Library/Application Support/minecraft/");
                break;
            default:
                workingDirectory = new File(userHome, "minecraft/"); break;
        }
        if (!workingDirectory.exists() && !workingDirectory.mkdirs())
            throw new RuntimeException("The working directory could not be created: " + workingDirectory);

        return workingDirectory;
    }

    public static File getNewMinecraftDirectory() {
        File workingDirectory;
        String userHome = System.getProperty("user.home", ".");

        switch (OSUtils.getPlatform()) {
            case solaris:
            case windows:
            case macosx:
                workingDirectory = getOldMinecraftDirectory();
                break;
            default:
                workingDirectory = new File(userHome, ".minecraft/"); break;
        }
        if (!workingDirectory.exists() && !workingDirectory.mkdirs())
            throw new RuntimeException("The working directory could not be created: " + workingDirectory);

        return workingDirectory;
    }

    static public void exportSpriteCasterBackups() throws Exception {
        InputStream stream = null;
        OutputStream resStreamOut = null;
        if (new File(SPRITECASTER_BACKUPS_ZIP).exists())
            return;

        try {
            stream = SpriteCasterFiles.class.getResourceAsStream("/SpriteCasterBackups.zip");//note that each / is a directory down in the "jar tree" been the jar the root of the tree

            int readBytes;
            byte[] buffer = new byte[4096];
            resStreamOut = new FileOutputStream(SPRITECASTER_BACKUPS_ZIP);
            while ((readBytes = stream.read(buffer)) > 0) {
                resStreamOut.write(buffer, 0, readBytes);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            stream.close();
            resStreamOut.close();
        }
    }

    static {
        new File(MINECRAFT_TEXTURE_PACKS_PATH).mkdirs();
        new File(MINECRAFT_RESOURCE_PACKS_PATH).mkdirs();
        new File(SPRITECASTER_TEMP_FOLDER).mkdirs();
        try {
            exportSpriteCasterBackups();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}