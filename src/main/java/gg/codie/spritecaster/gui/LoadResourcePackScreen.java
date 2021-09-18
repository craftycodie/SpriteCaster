package gg.codie.spritecaster.gui;

import gg.codie.spritecaster.SpriteCasterFiles;
import gg.codie.spritecaster.gui.components.ResourcePackListItem;
import gg.codie.spritecaster.gui.components.ResourcePackListItemRenderer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Locale;

public class LoadResourcePackScreen {

    public JPanel contentPane;
    private JPanel logoPanel;
    private JButton selectButton;
    private JList list1;
    private JButton browseButton;

    public LoadResourcePackScreen() {
        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("/logo.png")));
        logoPanel.add(logoLabel);

        File dir = new File(SpriteCasterFiles.MINECRAFT_RESOURCE_PACKS_PATH);
        File[] directoryListing = dir.listFiles();
        DefaultListModel demoList = new DefaultListModel();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.getName().endsWith(".zip"))
                    demoList.addElement(new ResourcePackListItem(child));
            }
        }

        list1.setCellRenderer(new ResourcePackListItemRenderer());
        list1.setModel(demoList);
        selectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectResourcePack(((ResourcePackListItem) list1.getSelectedValue()).getFile());
            }
        });
        browseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser j = new JFileChooser(SpriteCasterFiles.MINECRAFT_RESOURCE_PACKS_PATH);
                j.setDialogTitle("SpriteCaster - Select Resource Pack");
                j.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.getName().endsWith(".zip");
                    }

                    @Override
                    public String getDescription() {
                        return "Zip Archives";
                    }
                });

                FrameManager.getInstance().setVisible(false);
                int r = j.showSaveDialog(FrameManager.getInstance());

                if (r == JFileChooser.APPROVE_OPTION)
                {
                    selectResourcePack(j.getSelectedFile());
                }
                FrameManager.getInstance().setVisible(true);
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectButton.setEnabled(list1.getSelectedValue() != null);
            }
        });
    }

    private void selectResourcePack(File resourcePackFile) {
        if (resourcePackFile == null || !resourcePackFile.exists()) return;
        FrameManager.getInstance().setContentPane(new ConvertingScreen(resourcePackFile).contentPane);
        FrameManager.getInstance().pack();
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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        panel1.setMinimumSize(new Dimension(500, 600));
        panel1.setPreferredSize(new Dimension(500, 600));
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setMaximumSize(new Dimension(500, 600));
        contentPane.setMinimumSize(new Dimension(500, 600));
        contentPane.setPreferredSize(new Dimension(500, 600));
        panel1.add(contentPane, BorderLayout.CENTER);
        contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        logoPanel = new JPanel();
        logoPanel.setLayout(new BorderLayout(0, 0));
        logoPanel.setAlignmentY(0.5f);
        logoPanel.setMaximumSize(new Dimension(450, 53));
        logoPanel.setMinimumSize(new Dimension(450, 53));
        logoPanel.setPreferredSize(new Dimension(450, 53));
        contentPane.add(logoPanel, BorderLayout.NORTH);
        logoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel2, BorderLayout.SOUTH);
        selectButton = new JButton();
        selectButton.setActionCommand("selectResourcePack");
        selectButton.setEnabled(false);
        selectButton.setLabel("Select");
        selectButton.setText("Select");
        panel2.add(selectButton, BorderLayout.EAST);
        browseButton = new JButton();
        browseButton.setActionCommand("selectResourcePack");
        browseButton.setLabel("Browse");
        browseButton.setText("Browse");
        panel2.add(browseButton, BorderLayout.WEST);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel3, BorderLayout.CENTER);
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel3.add(scrollPane1, BorderLayout.CENTER);
        list1 = new JList();
        Font list1Font = this.$$$getFont$$$(null, -1, 24, list1.getFont());
        if (list1Font != null) list1.setFont(list1Font);
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        defaultListModel1.addElement("Faithless 16x");
        defaultListModel1.addElement("Paper Cut Out");
        defaultListModel1.addElement("Some Other Resource Pack");
        list1.setModel(defaultListModel1);
        scrollPane1.setViewportView(list1);
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

}
