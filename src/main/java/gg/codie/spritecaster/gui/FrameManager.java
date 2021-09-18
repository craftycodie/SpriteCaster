package gg.codie.spritecaster.gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

public class FrameManager {
    private static JFrame singleton;

    public static void init() {
        try {
            FlatIntelliJLaf.setup();
            FlatDarkPurpleIJTheme.setup();
            final Properties properties = new Properties();
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(".properties"));
            singleton = new JFrame("SpriteCaster " + properties.getProperty("version") + " (" + properties.getProperty("commit") + ")");
            singleton.setContentPane(new WelcomeScreen().contentPane);
            singleton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            singleton.setSize(500, 600);
            singleton.setResizable(false);
            ImageIcon iconImage = new ImageIcon(WelcomeScreen.class.getResource("/icon.png"));
            singleton.setIconImage(iconImage.getImage());
            singleton.pack();
            singleton.setLocationRelativeTo(null);
            singleton.setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static JFrame getInstance() {
        return singleton;
    }
}
