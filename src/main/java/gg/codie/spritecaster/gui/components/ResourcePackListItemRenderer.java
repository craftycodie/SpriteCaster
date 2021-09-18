package gg.codie.spritecaster.gui.components;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class ResourcePackListItemRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = -7799441088157759804L;
    private FileSystemView fileSystemView;
    private JLabel label;
    private Color backgroundSelectionColor = Color.decode("#713A91");
    private Color backgroundNonSelectionColor = Color.decode("#2C2C3B");

    public ResourcePackListItemRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean selected,
            boolean expanded) {

        ResourcePackListItem item = (ResourcePackListItem)value;



        label.setText(fileSystemView.getSystemDisplayName(item.getFile()));
        label.setToolTipText(item.getFile().getPath());
        Font list1Font = this.getFont(null, -1, 24, label.getFont());
        label.setIcon(item.getImageIcon());

        label.setFont(list1Font);

        if (selected) {
            label.setBackground(backgroundSelectionColor);
        } else {
            label.setBackground(backgroundNonSelectionColor);
        }

        return label;
    }

    private Font getFont(String fontName, int style, int size, Font currentFont) {
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