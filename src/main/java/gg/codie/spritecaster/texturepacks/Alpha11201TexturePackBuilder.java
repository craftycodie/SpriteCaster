package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.SpriteAtlas;
import gg.codie.spritecaster.SpriteAtlasBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePackStack;
import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Alpha11201TexturePackBuilder extends Beta1501TexturePackBuilder {
    public Alpha11201TexturePackBuilder(ResourcePackStack resourcePack) {
        super(resourcePack);
    }

    @Override
    protected SpriteAtlas createTerrain() {
        int scale = resourcePack.getTexture(ResourcePackTexture.Block.STONE).getWidth() / 16;

        return new SpriteAtlasBuilder()
                .setSpriteSize(16 * scale)
                .registerSprite(tintGrassGreen(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_TOP)), 1, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.STONE), 1, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DIRT), 1, 3)
                .registerSprite(getGrassSideWithTintedOverlay(), 1, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_PLANKS), 1, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.STONE_SLAB_SIDE), 1, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.STONE_SLAB_TOP), 1, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BRICKS), 1, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TNT_SIDE), 1, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TNT_TOP), 1, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TNT_BOTTOM), 1, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.COBWEB), 1, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RED_FLOWER), 1, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.YELLOW_FLOWER), 1, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SAPLING), 1, 16)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.COBBLESTONE), 2, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BEDROCK), 2, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SAND), 2, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GRAVEL), 2, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LOG_SIDE), 2, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LOG_TOP), 2, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BLOCK_OF_IRON), 2, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BLOCK_OF_GOLD), 2, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BLOCK_OF_DIAMOND), 2, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CHEST_TOP), 2, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CHEST_SIDE), 2, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CHEST_FRONT), 2, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RED_MUSHROOM), 2, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BROWN_MUSHROOM), 2, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_GOLD), 3, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_IRON), 3, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_COAL), 3, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BOOKSHELF), 3, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.MOSSY_COBBLESTONE), 3, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.OBSIDIAN), 3, 6)
                .registerSprite(tintGrassGreen(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_SIDE_OVERLAY)), 3, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TALL_GRASS), 3, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_TOP_SNOWY), 3, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_LEFT), 3, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_RIGHT), 3, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CRAFTING_TABLE_TOP), 3, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_FRONT), 3, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_SIDE), 3, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DISPENSER_FRONT), 3, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SPONGE), 4, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GLASS), 4, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_DIAMOND), 4, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_REDSTONE), 4, 4)
                .registerSprite(tintLeavesGreen(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FANCY)), 4, 5)
                .registerSprite(tintLeavesGreen(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FAST)), 4, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DEADBUSH), 4, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FERN), 4, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_LEFT), 4, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_RIGHT), 4, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SCISSORS), 4, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SAW), 4, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_BURNING), 4, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_TOP), 4, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SPRUCE_SAPLING), 4, 16)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_WHITE), 5, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.MOB_SPAWNER), 5, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SNOW), 5, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ICE), 5, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_SIDE_SNOWY), 5, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CACTUS_TOP), 5, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CACTUS_SIDE), 5, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CACTUS_BOTTOM), 5, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CLAY), 5, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SUGAR_CANE_BLOCK), 5, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.NOTEBLOCK), 5, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.JUKEBOX_TOP), 5, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BIRCH_SAPLING), 5, 16)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TORCH), 6, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_DOOR_TOP), 6, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.IRON_DOOR_TOP), 6, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LADDER), 6, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_CROSS_OFF), 6, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_LINE_OFF), 6, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_CROSS_ON), 7, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_LINE_ON), 7, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FARMLAND_WET), 6, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FARMLAND_DRY), 6, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_0), 6, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_1), 6, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_2), 6, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_3), 6, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_4), 6, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_5), 6, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_6), 6, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WHEAT_7), 6, 16)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LEVER), 7, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_DOOR_BOTTOM), 7, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.IRON_DOOR_BOTTOM), 7, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_TORCH_ON), 7, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PUMPKIN_TOP), 7, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.NETHERRACK), 7, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SOUL_SAND), 7, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GLOWSTONE), 7, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_CORNER), 8, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_BLACK), 8, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_DARK_GREY), 8, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_TORCH_OFF), 8, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LOG_SPRUCE), 8, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LOG_BIRCH), 8, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PUMPKIN_SIDE), 8, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PUMPKIN_FRONT), 8, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PUMPKIN_FRONT_LIT), 8, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_TOP), 8, 10)
                .registerSprite(moveBlockUp(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_SIDE), 8), 8, 11)
                .registerSprite(moveBlockUp(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_SIDE_EATEN), 8), 8, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_BOTTOM), 8, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL), 9, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_RED), 9, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_PINK), 9, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_OFF), 9, 4)
                .registerSprite(tintSpruceLeavesGreen(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FANCY_SPRUCE)), 9, 5)
                .registerSprite(tintSpruceLeavesGreen(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FAST_SPRUCE)), 9, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_LOWER_TOP), 9, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_UPPER_TOP), 9, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BLOCK_OF_LAPIS), 10, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_DARK_GREEN), 10, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIME), 10, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_ON), 10, 4)
                .registerSprite(moveBlockUp(resourcePack.getTexture(ResourcePackTexture.Block.BED_FRONT), 7), 10, 6)
                .registerSprite(moveBlockUp(resourcePack.getTexture(ResourcePackTexture.Block.BED_LOWER_SIDE), 7), 10, 7)
                .registerSprite(moveBlockUp(resourcePack.getTexture(ResourcePackTexture.Block.BED_UPPER_SIDE), 7), 10, 8)
                .registerSprite(moveBlockUp(resourcePack.getTexture(ResourcePackTexture.Block.BED_BACK), 7), 10, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_LAPIS), 11, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_BROWN), 11, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_YELLOW), 11, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_POWERED_OFF), 11, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_CROSS), 11, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_LINE), 11, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SANDSTONE_TOP), 12, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_DARK_BLUE), 12, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIGHT_BLUE), 12, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_POWERED_ON), 12, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SANDSTONE_SIDE), 13, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_PURPLE), 13, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_MAGENTA), 13, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_DETECTOR), 13, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SANDSTONE_BOTTOM), 14, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_TEAL), 14, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_ORANGE), 14, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIGHT_GREY), 15, 2)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_0)), 16, 1)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_1)), 16, 2)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_2)), 16, 3) // Electric Boogaloo
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_3)), 16, 4)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_4)), 16, 5)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_5)), 16, 6)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_6)), 16, 7)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_7)), 16, 8)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_8)), 16, 9)
                .registerSprite(addGreyBackgroud(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_9)), 16, 10)
                .build();
    }

    protected BufferedImage getGrassSideWithTintedOverlay() {
        BufferedImage tintedOverlay = tintGrassGreen(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_SIDE_OVERLAY));
        BufferedImage grassSide = resourcePack.getTexture(ResourcePackTexture.Block.GRASS_SIDE);
        BufferedImage tintedGrassSide = new BufferedImage(grassSide.getWidth(), grassSide.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = tintedGrassSide.createGraphics();
        g2.drawImage(grassSide, 0, 0, null);
        g2.drawImage(tintedOverlay, 0, 0, null);
        return tintedGrassSide;
    }

    protected BufferedImage tintGrassGreen(BufferedImage master) {
        int imgWidth = master.getWidth();
        int imgHeight = master.getHeight();

        BufferedImage imgMask = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imgMask.createGraphics();
        applyQualityRenderingHints(g2);

        g2.drawImage(master, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.5f));
        g2.setColor(Color.decode("#7CBD6B"));

        g2.fillRect(0, 0, master.getWidth(), master.getHeight());
        g2.dispose();

        BufferedImage tinted = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = tinted.createGraphics();
        applyQualityRenderingHints(g2);
        g2.drawImage(master, 0, 0, null);
        g2.drawImage(imgMask, 0, 0, null);
        g2.dispose();

        return tinted;
    }

    protected BufferedImage tintLeavesGreen(BufferedImage master) {
        int imgWidth = master.getWidth();
        int imgHeight = master.getHeight();

        BufferedImage imgMask = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imgMask.createGraphics();
        applyQualityRenderingHints(g2);

        g2.drawImage(master, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.5f));
        g2.setColor(Color.decode("#48B518"));

        g2.fillRect(0, 0, master.getWidth(), master.getHeight());
        g2.dispose();

        BufferedImage tinted = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = tinted.createGraphics();
        applyQualityRenderingHints(g2);
        g2.drawImage(master, 0, 0, null);
        g2.drawImage(imgMask, 0, 0, null);
        g2.dispose();

        return tinted;
    }

    protected BufferedImage tintSpruceLeavesGreen(BufferedImage master) {
        int imgWidth = master.getWidth();
        int imgHeight = master.getHeight();

        BufferedImage imgMask = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imgMask.createGraphics();
        applyQualityRenderingHints(g2);

        g2.drawImage(master, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.5f));
        g2.setColor(Color.decode("#619961"));

        g2.fillRect(0, 0, master.getWidth(), master.getHeight());
        g2.dispose();

        BufferedImage tinted = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = tinted.createGraphics();
        applyQualityRenderingHints(g2);
        g2.drawImage(master, 0, 0, null);
        g2.drawImage(imgMask, 0, 0, null);
        g2.dispose();

        return tinted;
    }

    private void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    @Override
    public String getMinecraftVersion() {
        return "a1.1.2_01";
    }
}
