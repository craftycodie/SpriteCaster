package gg.codie.spritecaster.gui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class WelcomeScreen extends JFrame {
    public JPanel contentPane;
    private JPanel logoPanel;
    private JButton selectResourcePackButton;

    public WelcomeScreen() {
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/logo.png")));
        logoPanel.add(logoLabel);
        selectResourcePackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrameManager.getInstance().setContentPane(new LoadResourcePackScreen().contentPane);
                FrameManager.getInstance().pack();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setMaximumSize(new Dimension(500, 600));
        contentPane.setMinimumSize(new Dimension(500, 600));
        contentPane.setPreferredSize(new Dimension(500, 600));
        contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        logoPanel = new JPanel();
        logoPanel.setLayout(new BorderLayout(0, 0));
        logoPanel.setAlignmentY(0.5f);
        logoPanel.setMaximumSize(new Dimension(450, 53));
        logoPanel.setMinimumSize(new Dimension(450, 53));
        logoPanel.setPreferredSize(new Dimension(450, 53));
        contentPane.add(logoPanel, BorderLayout.NORTH);
        logoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel1, BorderLayout.SOUTH);
        selectResourcePackButton = new JButton();
        selectResourcePackButton.setActionCommand("selectResourcePack");
        selectResourcePackButton.setLabel("Select Resource Pack");
        selectResourcePackButton.setText("Select Resource Pack");
        panel1.add(selectResourcePackButton, BorderLayout.CENTER);
        final JLabel label1 = new JLabel();
        label1.setAutoscrolls(false);
        label1.setDoubleBuffered(false);
        label1.setFocusCycleRoot(false);
        Font label1Font = this.$$$getFont$$$(null, Font.PLAIN, 22, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(2);
        label1.setHorizontalTextPosition(2);
        label1.setText("<html><br/><h1>Welcome</h1>This application allows you to convert modern <br/>Minecraft resource packs to the old texture pack format.<br/><br/>Begin by selecting a resource pack to convert!</html>");
        label1.setVerticalAlignment(1);
        label1.setVerticalTextPosition(0);
        contentPane.add(label1, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
