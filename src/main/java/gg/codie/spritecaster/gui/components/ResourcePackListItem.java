package gg.codie.spritecaster.gui.components;

import gg.codie.spritecaster.gui.WelcomeScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.zip.ZipFile;

public class ResourcePackListItem {
    private final File file;
    private ImageIcon imageIcon;

    public String getName() {
        return getFile().getName();
    }

    public File getFile() {
        return file;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public ResourcePackListItem(File file) {
        this.file = file;
        this.imageIcon = new ImageIcon(new ImageIcon(WelcomeScreen.class.getResource("/unknown_pack.png")).getImage().getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));

        try {
            ZipFile zipFile = new ZipFile(file);
            if (zipFile.getEntry("pack.png") != null) {
                imageIcon = new ImageIcon(ImageIO.read(zipFile.getInputStream(zipFile.getEntry("pack.png"))).getScaledInstance(32, 32, Image.SCALE_AREA_AVERAGING));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
