package gg.codie.spritecaster.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedImageUtils {
    public static BufferedImage tint(BufferedImage sourceImage, Color color) {
        return tint(sourceImage, color, false);
    }

    public static BufferedImage tint(BufferedImage sourceImage, Color color, boolean forceGreyscale) {
        BufferedImage bufferedImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.createGraphics().drawImage(sourceImage, 0, 0, null);

//        if (forceGreyscale)
            bufferedImage = greyscale(bufferedImage);

        for(int x = 0; x < bufferedImage.getWidth(); x++){
            for(int y = 0; y < bufferedImage.getHeight(); y++){
                Color pixel = new Color(bufferedImage.getRGB(x, y), true);

                int red = pixel.getRed();
                int green = pixel.getBlue();
                int blue = pixel.getGreen();

//                // Ignore pixels that aren't grey.
//                if (red != green || red != blue)
//                    continue;

                red = (int)(red * ((float)color.getRed() / 255));
                green = (int)(green * ((float)color.getGreen() / 255));
                blue = (int)(blue * ((float)color.getBlue() / 255));

                red = Math.min(red, 255);
                green = Math.min(green, 255);
                blue = Math.min(blue, 255);

                pixel = new Color(red, green, blue, pixel.getAlpha());

                bufferedImage.setRGB(x, y, pixel.getRGB());
            }
        }

        return bufferedImage;
    }

    public static BufferedImage greyscale(BufferedImage sourceImage)
    {
        BufferedImage img = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        img.createGraphics().drawImage(sourceImage, 0, 0, null);

        for (int x = 0; x < img.getWidth(); ++x)
            for (int y = 0; y < img.getHeight(); ++y)
            {
                Color pixel = new Color(img.getRGB(x, y), true);
                int red = pixel.getRed();
                int green = pixel.getBlue();
                int blue = pixel.getGreen();

                // Normalize and gamma correct:
                float rr = (float) Math.pow(red / 255.0, 2.2);
                float gg = (float) Math.pow(green / 255.0, 2.2);
                float bb = (float) Math.pow(blue / 255.0, 2.2);

                // Calculate luminance:
                float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                // Gamma compand and rescale to byte range:
                int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                pixel = new Color(grayLevel, grayLevel, grayLevel, pixel.getAlpha());
                img.setRGB(x, y, pixel.getRGB());
            }

        return img;
    }
}