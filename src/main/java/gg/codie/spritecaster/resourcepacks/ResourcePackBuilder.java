package gg.codie.spritecaster.resourcepacks;

import gg.codie.spritecaster.resources.textures.ResourcePackTexture;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.zip.ZipFile;

public class ResourcePackBuilder {
    HashMap<Enum, BufferedImage> textures = new HashMap<>();
    String info = null;
    final String name;
    ZipFile resourcePackZip;

    public ResourcePackBuilder(ZipFile resourcePack) {
        this.resourcePackZip = resourcePack;
        this.name = resourcePack.getName().replace(".zip", "");
    }

    public ResourcePackBuilder withInfo(String info) {
        this.info = info;
        return this;
    }

    private BufferedImage getSprite(String texturePath) throws IOException {
        return ImageIO.read(this.resourcePackZip.getInputStream(this.resourcePackZip.getEntry(texturePath)));
    }

    public ResourcePackBuilder withTexture(Enum texture, String relativePath) {
        try {
            BufferedImage sprite = getSprite(relativePath);
            textures.put(texture, sprite);

            if (texture == ResourcePackTexture.Block.LEAVES_FANCY) {
                BufferedImage leaves = sprite;
                BufferedImage black = new BufferedImage(leaves.getWidth(), leaves.getHeight(), BufferedImage.TYPE_INT_BGR);
                BufferedImage fastLeaves = new BufferedImage(leaves.getWidth(), leaves.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics2D = fastLeaves.createGraphics();
                graphics2D.drawImage(black, 0, 0, null);
                graphics2D.drawImage(leaves, 0, 0, null);
                textures.put(ResourcePackTexture.Block.LEAVES_FAST, fastLeaves);
            }

            if (texture == ResourcePackTexture.Block.BED_UPPER_TOP) {
                int scale = sprite.getWidth() / 64;
                BufferedImage bedUpperTop = sprite.getSubimage(6 * scale, 6 * scale, 16 * scale, 16 * scale);
                BufferedImage rotatedBedUpperTop = new BufferedImage(bedUpperTop.getWidth(), bedUpperTop.getHeight(), bedUpperTop.getType());
                Graphics2D graphics2D = rotatedBedUpperTop.createGraphics();
                graphics2D.rotate(Math.toRadians(90), rotatedBedUpperTop.getWidth() / 2, rotatedBedUpperTop.getHeight() / 2);
                graphics2D.drawImage(bedUpperTop, 0, 0, null);
                textures.put(texture, rotatedBedUpperTop);
            }

            if (texture == ResourcePackTexture.Block.BED_LOWER_TOP) {
                int scale = sprite.getWidth() / 64;
                BufferedImage bedUpperTop = sprite.getSubimage(6 * scale, 28  * scale, 16 * scale, 16 * scale);
                BufferedImage rotatedBedUpperTop = new BufferedImage(bedUpperTop.getWidth(), bedUpperTop.getHeight(), bedUpperTop.getType());
                Graphics2D graphics2D = rotatedBedUpperTop.createGraphics();
                graphics2D.rotate(Math.toRadians(90), rotatedBedUpperTop.getWidth() / 2, rotatedBedUpperTop.getHeight() / 2);
                graphics2D.drawImage(bedUpperTop, 0, 0, null);
                textures.put(texture, rotatedBedUpperTop);
            }

            if (texture == ResourcePackTexture.Block.BED_FRONT) {
                int scale = sprite.getWidth() / 64;
//                BufferedImage bedFrontTop = sprite.getSubimage(22 * scale, 22     * scale, 16 * scale, 5 * scale);
                BufferedImage bedFront = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                BufferedImage bedFrontTop = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = bedFrontTop.createGraphics();
                graphics2D.rotate(Math.toRadians(180), bedFrontTop.getWidth() / 2, bedFrontTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(22 * scale, 22 * scale, 16 * scale, 5 * scale), 0, 3 * scale, null);
                BufferedImage bedLeg = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                graphics2D = bedLeg.createGraphics();
                graphics2D.rotate(Math.toRadians(270), bedFrontTop.getWidth() / 2, bedFrontTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 0, null);
                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 13 * scale, null);
                graphics2D = bedFront.createGraphics();
                graphics2D.drawImage(bedFrontTop, 0, 0, null);
                graphics2D.drawImage(bedLeg, 0, 0, null);
                textures.put(texture, bedFront);
            }

            if (texture == ResourcePackTexture.Block.BED_BACK) {
                int scale = sprite.getWidth() / 64;
//                BufferedImage bedFrontTop = sprite.getSubimage(22 * scale, 22     * scale, 16 * scale, 5 * scale);
                BufferedImage bedBack = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                BufferedImage bedBackTop = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = bedBackTop.createGraphics();
                graphics2D.rotate(Math.toRadians(180), bedBackTop.getWidth() / 2, bedBackTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(6 * scale, 0 * scale, 16 * scale, 5 * scale), 0, 3 * scale, null);
                BufferedImage bedLeg = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                graphics2D = bedLeg.createGraphics();
                graphics2D.rotate(Math.toRadians(270), bedBackTop.getWidth() / 2, bedBackTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 0, null);
                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 13 * scale, null);
                graphics2D = bedBack.createGraphics();
                graphics2D.drawImage(bedBackTop, 0, 0, null);
                graphics2D.drawImage(bedLeg, 0, 0, null);
                textures.put(texture, bedBack);
            }

            if (texture == ResourcePackTexture.Block.BED_UPPER_SIDE) {
                int scale = sprite.getWidth() / 64;
//                BufferedImage bedFrontTop = sprite.getSubimage(22 * scale, 22     * scale, 16 * scale, 5 * scale);
                BufferedImage bedUpperSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                BufferedImage bedUpperSideTop = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = bedUpperSideTop.createGraphics();
                graphics2D.rotate(Math.toRadians(90), bedUpperSideTop.getWidth() / 2, bedUpperSideTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(23 * scale, 6 * scale, 5 * scale, 16 * scale), 8 * scale, 0, null);
                BufferedImage bedLeg = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                graphics2D = bedLeg.createGraphics();
                graphics2D.rotate(Math.toRadians(270), bedUpperSideTop.getWidth() / 2, bedUpperSideTop.getHeight() / 2);
//                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 0, null);
                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 13 * scale, null);
                graphics2D = bedUpperSide.createGraphics();
                graphics2D.drawImage(bedUpperSideTop, 0, 0, null);
                graphics2D.drawImage(bedLeg, 0, 0, null);
                textures.put(texture, bedUpperSide);
            }

            if (texture == ResourcePackTexture.Block.BED_LOWER_SIDE) {
                int scale = sprite.getWidth() / 64;
//                BufferedImage bedFrontTop = sprite.getSubimage(22 * scale, 22     * scale, 16 * scale, 5 * scale);
                BufferedImage bedUpperSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                BufferedImage bedUpperSideTop = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = bedUpperSideTop.createGraphics();
                graphics2D.rotate(Math.toRadians(90), bedUpperSideTop.getWidth() / 2, bedUpperSideTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(23 * scale, 28 * scale, 5 * scale, 16 * scale), 8 * scale, 0, null);
                BufferedImage bedLeg = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                graphics2D = bedLeg.createGraphics();
                graphics2D.rotate(Math.toRadians(270), bedUpperSideTop.getWidth() / 2, bedUpperSideTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 0, null);
//                graphics2D.drawImage(sprite.getSubimage(50 * scale, 3 * scale, 3 * scale, 3 * scale), 0, 13 * scale, null);
                graphics2D = bedUpperSide.createGraphics();
                graphics2D.drawImage(bedUpperSideTop, 0, 0, null);
                graphics2D.drawImage(bedLeg, 0, 0, null);
                textures.put(texture, bedUpperSide);
            }

            if (texture == ResourcePackTexture.Block.CHEST_FRONT) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestFront = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestFront.createGraphics();
                graphics2D.rotate(Math.toRadians(180), chestFront.getWidth() / 2, chestFront.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(42 * scale, 14 * scale,  14 * scale, 5 * scale), scale, 10 * scale, null);
                graphics2D.drawImage(sprite.getSubimage(42 * scale, 33 * scale,  14 * scale, 10 * scale), scale, scale, null);
                graphics2D.drawImage(sprite.getSubimage(0, scale,  2 * scale, 4 * scale), 7 * scale, 8 * scale, null);
                chestFront = upscaleChest(chestFront);
                textures.put(texture, chestFront);
            }

            if (texture == ResourcePackTexture.Block.CHEST_SIDE) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestSide.createGraphics();
                graphics2D.rotate(Math.toRadians(180), chestSide.getWidth() / 2, chestSide.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(28 * scale, 14 * scale,  14 * scale, 5 * scale), scale, 10 * scale, null);
                graphics2D.drawImage(sprite.getSubimage(28 * scale, 33 * scale,  14 * scale, 10 * scale), scale, scale, null);
                chestSide = upscaleChest(chestSide);
                textures.put(texture, chestSide);
            }

            if (texture == ResourcePackTexture.Block.CHEST_TOP) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestTop = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestTop.createGraphics();
                graphics2D.rotate(Math.toRadians(180), chestTop.getWidth() / 2, chestTop.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(28 * scale, 0 * scale,  14 * scale, 14 * scale), scale, scale, null);
                chestTop = upscaleChest(chestTop);
                textures.put(texture, chestTop);
            }

            if (texture == ResourcePackTexture.Block.DOUBLE_CHEST_BACK_RIGHT) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestSide.createGraphics();
                graphics2D.drawImage(flipVertical(sprite.getSubimage(14 * scale, 14 * scale,  15 * scale, 5 * scale)), scale, scale, null);
                graphics2D.drawImage(flipVertical(sprite.getSubimage(14 * scale, 33 * scale,  15 * scale, 10 * scale)), scale, 5 * scale, null);
                chestSide = flipHorizontal(chestSide);
                chestSide = upscaleChest(chestSide);
                textures.put(texture, chestSide);
            }

            if (texture == ResourcePackTexture.Block.DOUBLE_CHEST_BACK_LEFT) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestSide.createGraphics();
                graphics2D.drawImage(flipVertical(sprite.getSubimage(14 * scale, 14 * scale,  15 * scale, 5 * scale)), 0, scale, null);
                graphics2D.drawImage(flipVertical(sprite.getSubimage(14 * scale, 33 * scale,  15 * scale, 10 * scale)), 0, 5 * scale, null);
                chestSide = flipHorizontal(chestSide);
                chestSide = upscaleChest(chestSide);
                textures.put(texture, chestSide);
            }

            if (texture == ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_RIGHT) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestSide.createGraphics();
                graphics2D.drawImage(flipVertical(sprite.getSubimage(43 * scale, 14 * scale,  15 * scale, 5 * scale)), 0, scale, null);
                graphics2D.drawImage(flipVertical(sprite.getSubimage(43 * scale, 33 * scale,  15 * scale, 10 * scale)), 0, 5 * scale, null);
                graphics2D.rotate(Math.toRadians(180), chestSide.getWidth() / 2, chestSide.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(3 * scale, scale,  scale, 4 * scale),  15 * scale, 8 * scale, null);
                BufferedImage chestLeft = chestSide.getSubimage(0, scale, scale, 14 * scale);
                chestSide = upscaleChest(chestSide);
                textures.put(texture, chestSide);
            }

            if (texture == ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_LEFT) {
                int scale = sprite.getWidth() / 64;
                BufferedImage chestSide = new BufferedImage(16 * scale, 16 * scale, sprite.getType());
                Graphics2D graphics2D = chestSide.createGraphics();
                graphics2D.drawImage(flipVertical(sprite.getSubimage(43 * scale, 14 * scale,  15 * scale, 5 * scale)), scale, scale, null);
                graphics2D.drawImage(flipVertical(sprite.getSubimage(43 * scale, 33 * scale,  15 * scale, 10 * scale)), scale, 5 * scale, null);
                graphics2D.rotate(Math.toRadians(180), chestSide.getWidth() / 2, chestSide.getHeight() / 2);
                graphics2D.drawImage(sprite.getSubimage(scale, scale,  scale, 4 * scale),  0, 8 * scale, null);
                chestSide = upscaleChest(chestSide);
                textures.put(texture, chestSide);
            }

            if (texture == ResourcePackTexture.Block.LEAVES_FANCY_SPRUCE) {
                BufferedImage leaves = sprite;
                BufferedImage black = new BufferedImage(leaves.getWidth(), leaves.getHeight(), BufferedImage.TYPE_INT_BGR);
                BufferedImage fastLeaves = new BufferedImage(leaves.getWidth(), leaves.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics2D = fastLeaves.createGraphics();
                graphics2D.drawImage(black, 0, 0, null);
                graphics2D.drawImage(leaves, 0, 0, null);
                textures.put(ResourcePackTexture.Block.LEAVES_FAST_SPRUCE, fastLeaves);
            }

            if (texture == ResourcePackTexture.Block.REDSTONE_LINE) {
                BufferedImage redstoneLine = new BufferedImage(sprite.getWidth(), sprite.getHeight(), sprite.getType());
                Graphics2D graphics2D = redstoneLine.createGraphics();
                graphics2D.rotate(Math.toRadians(90), redstoneLine.getWidth() / 2, redstoneLine.getHeight() / 2);
                graphics2D.drawImage(sprite, 0, 0, null);
                textures.put(texture, redstoneLine);
                BufferedImage redstoneCross = new BufferedImage(redstoneLine.getWidth(), redstoneLine.getHeight(), redstoneLine.getType());
                graphics2D = redstoneCross.createGraphics();
                graphics2D.drawImage(redstoneLine, 0, 0, null);
                graphics2D.rotate(Math.toRadians(90), redstoneCross.getWidth() / 2, redstoneCross.getHeight() / 2);
                graphics2D.drawImage(redstoneLine, 0, 0, null);
                textures.put(ResourcePackTexture.Block.REDSTONE_CROSS, redstoneCross);
            }

            if (texture == ResourcePackTexture.ENVIRONMENT_MOON_PHASES) {
                textures.put(texture, sprite.getSubimage(0, 0, sprite.getWidth() / 4, sprite.getHeight() / 2));
            }
        } catch (Exception ex) {
//            ex.printStackTrace();
        }



        return this;
    }

    private BufferedImage flipVertical(BufferedImage in) {
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -in.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(in, null);
    }

    private BufferedImage upscaleChest(BufferedImage in) {
        int scale = in.getWidth() / 16;
        BufferedImage chest = new BufferedImage(in.getWidth(), in.getHeight(), in.getType());
        Graphics2D graphics2D = chest.createGraphics();
        graphics2D.drawImage(in.getSubimage(scale, scale, scale, 14 * scale), 0, scale, null);
        graphics2D.drawImage(in.getSubimage(scale, scale, scale, scale), 0, 0, null);
        graphics2D.drawImage(in.getSubimage(14 * scale, scale, scale, scale), 15 * scale, 0, null);
        graphics2D.drawImage(in.getSubimage(14 * scale, 14 * scale, scale, scale), 15 * scale, 15 * scale, null);
        graphics2D.drawImage(in.getSubimage(scale, 14 * scale, scale, scale), 0, 15 * scale, null);
        graphics2D.drawImage(in.getSubimage(scale, scale, 14 * scale, scale), scale, 0, null);
        graphics2D.drawImage(in.getSubimage(14 * scale, scale, scale, 14 * scale), 15 * scale, scale, null);
        graphics2D.drawImage(in.getSubimage(scale, 14 * scale, 14 * scale, scale), scale, 15 * scale, null);
        graphics2D.drawImage(in.getSubimage(0, 0, 16 * scale, 16 * scale), 0, 0, null);
        return chest;
    }

    private BufferedImage flipHorizontal(BufferedImage in) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-in.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(in, null);
    }

    private ResourcePackBuilder withBlocks() {
        return this.withTexture(ResourcePackTexture.Block.GRASS_TOP, "assets/minecraft/textures/block/grass_block_top.png")
                .withTexture(ResourcePackTexture.Block.STONE, "assets/minecraft/textures/block/stone.png")
                .withTexture(ResourcePackTexture.Block.DIRT, "assets/minecraft/textures/block/dirt.png")
                .withTexture(ResourcePackTexture.Block.GRASS_SIDE, "assets/minecraft/textures/block/grass_block_side.png")
                .withTexture(ResourcePackTexture.Block.WOODEN_PLANKS, "assets/minecraft/textures/block/oak_planks.png")
                .withTexture(ResourcePackTexture.Block.STONE_SLAB_SIDE, "assets/minecraft/textures/block/smooth_stone_slab_side.png")
                .withTexture(ResourcePackTexture.Block.STONE_SLAB_TOP, "assets/minecraft/textures/block/smooth_stone.png")
                .withTexture(ResourcePackTexture.Block.BRICK, "assets/minecraft/textures/block/bricks.png")
                .withTexture(ResourcePackTexture.Block.TNT_SIDE, "assets/minecraft/textures/block/tnt_side.png")
                .withTexture(ResourcePackTexture.Block.TNT_TOP, "assets/minecraft/textures/block/tnt_top.png")
                .withTexture(ResourcePackTexture.Block.TNT_BOTTOM, "assets/minecraft/textures/block/tnt_bottom.png")
                .withTexture(ResourcePackTexture.Block.COBWEB, "assets/minecraft/textures/block/cobweb.png")
                .withTexture(ResourcePackTexture.Block.RED_FLOWER, "assets/minecraft/textures/block/poppy.png")
                .withTexture(ResourcePackTexture.Block.YELLOW_FLOWER, "assets/minecraft/textures/block/dandelion.png")
                .withTexture(ResourcePackTexture.Block.SAPLING, "assets/minecraft/textures/block/oak_sapling.png")
                .withTexture(ResourcePackTexture.Block.COBBLESTONE, "assets/minecraft/textures/block/cobblestone.png")
                .withTexture(ResourcePackTexture.Block.BEDROCK, "assets/minecraft/textures/block/bedrock.png")
                .withTexture(ResourcePackTexture.Block.SAND, "assets/minecraft/textures/block/sand.png")
                .withTexture(ResourcePackTexture.Block.GRAVEL, "assets/minecraft/textures/block/gravel.png")
                .withTexture(ResourcePackTexture.Block.LOG_SIDE, "assets/minecraft/textures/block/oak_log.png")
                .withTexture(ResourcePackTexture.Block.LOG_TOP, "assets/minecraft/textures/block/oak_log_top.png")
                .withTexture(ResourcePackTexture.Block.BLOCK_OF_IRON, "assets/minecraft/textures/block/iron_block.png")
                .withTexture(ResourcePackTexture.Block.BLOCK_OF_GOLD, "assets/minecraft/textures/block/gold_block.png")
                .withTexture(ResourcePackTexture.Block.BLOCK_OF_DIAMOND, "assets/minecraft/textures/block/diamond_block.png")
                .withTexture(ResourcePackTexture.Block.CHEST_TOP, "assets/minecraft/textures/entity/chest/normal.png")
                .withTexture(ResourcePackTexture.Block.CHEST_SIDE, "assets/minecraft/textures/entity/chest/normal.png")
                .withTexture(ResourcePackTexture.Block.CHEST_FRONT, "assets/minecraft/textures/entity/chest/normal.png")
                .withTexture(ResourcePackTexture.Block.RED_MUSHROOM, "assets/minecraft/textures/block/red_mushroom.png")
                .withTexture(ResourcePackTexture.Block.BROWN_MUSHROOM, "assets/minecraft/textures/block/brown_mushroom.png")
                .withTexture(ResourcePackTexture.Block.ORE_GOLD, "assets/minecraft/textures/block/gold_ore.png")
                .withTexture(ResourcePackTexture.Block.ORE_IRON, "assets/minecraft/textures/block/iron_ore.png")
                .withTexture(ResourcePackTexture.Block.ORE_COAL, "assets/minecraft/textures/block/coal_ore.png")
                .withTexture(ResourcePackTexture.Block.BOOKSHELF, "assets/minecraft/textures/block/bookshelf.png")
                .withTexture(ResourcePackTexture.Block.MOSSY_COBBLESTONE, "assets/minecraft/textures/block/mossy_cobblestone.png")
                .withTexture(ResourcePackTexture.Block.OBSIDIAN, "assets/minecraft/textures/block/obsidian.png")
                .withTexture(ResourcePackTexture.Block.GRASS_SIDE_OVERLAY, "assets/minecraft/textures/block/grass_block_side_overlay.png")
                .withTexture(ResourcePackTexture.Block.TALL_GRASS, "assets/minecraft/textures/block/grass.png")
                .withTexture(ResourcePackTexture.Block.GRASS_TOP_SNOWY, "assets/minecraft/textures/block/grass_block_top.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_LEFT, "assets/minecraft/textures/entity/chest/normal_left.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_RIGHT, "assets/minecraft/textures/entity/chest/normal_right.png")
                .withTexture(ResourcePackTexture.Block.CRAFTING_TABLE_TOP, "assets/minecraft/textures/block/crafting_table_top.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_FRONT, "assets/minecraft/textures/block/furnace_front.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_SIDE, "assets/minecraft/textures/block/furnace_side.png")
                .withTexture(ResourcePackTexture.Block.DISPENSER_FRONT, "assets/minecraft/textures/block/dispenser_front.png")
                .withTexture(ResourcePackTexture.Block.SPONGE, "assets/minecraft/textures/block/sponge.png")
                .withTexture(ResourcePackTexture.Block.GLASS, "assets/minecraft/textures/block/glass.png")
                .withTexture(ResourcePackTexture.Block.ORE_DIAMOND, "assets/minecraft/textures/block/diamond_ore.png")
                .withTexture(ResourcePackTexture.Block.ORE_REDSTONE, "assets/minecraft/textures/block/redstone_ore.png")
                .withTexture(ResourcePackTexture.Block.LEAVES_FANCY, "assets/minecraft/textures/block/oak_leaves.png")
                .withTexture(ResourcePackTexture.Block.DEADBUSH, "assets/minecraft/textures/block/dead_bush.png")
                .withTexture(ResourcePackTexture.Block.FERN, "assets/minecraft/textures/block/fern.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_LEFT, "assets/minecraft/textures/entity/chest/normal_left.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_RIGHT, "assets/minecraft/textures/entity/chest/normal_right.png")
                .withTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SCISSORS, "assets/minecraft/textures/block/crafting_table_front.png")
                .withTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SAW, "assets/minecraft/textures/block/crafting_table_side.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_BURNING, "assets/minecraft/textures/block/furnace_front_on.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_TOP, "assets/minecraft/textures/block/furnace_top.png")
                .withTexture(ResourcePackTexture.Block.SPRUCE_SAPLING, "assets/minecraft/textures/block/spruce_sapling.png")
                .withTexture(ResourcePackTexture.Block.WOOL_WHITE, "assets/minecraft/textures/block/white_wool.png")
                .withTexture(ResourcePackTexture.Block.MOB_SPAWNER, "assets/minecraft/textures/block/spawner.png")
                .withTexture(ResourcePackTexture.Block.SNOW, "assets/minecraft/textures/block/snow.png")
                .withTexture(ResourcePackTexture.Block.ICE, "assets/minecraft/textures/block/ice.png")
                .withTexture(ResourcePackTexture.Block.GRASS_SIDE_SNOWY, "assets/minecraft/textures/block/grass_block_snow.png")
                .withTexture(ResourcePackTexture.Block.CACTUS_TOP, "assets/minecraft/textures/block/cactus_top.png")
                .withTexture(ResourcePackTexture.Block.CACTUS_SIDE, "assets/minecraft/textures/block/cactus_side.png")
                .withTexture(ResourcePackTexture.Block.CACTUS_BOTTOM, "assets/minecraft/textures/block/cactus_bottom.png")
                .withTexture(ResourcePackTexture.Block.CLAY, "assets/minecraft/textures/block/clay.png")
                .withTexture(ResourcePackTexture.Block.SUGAR_CANE, "assets/minecraft/textures/block/sugar_cane.png")
                .withTexture(ResourcePackTexture.Block.NOTEBLOCK, "assets/minecraft/textures/block/note_block.png")
                .withTexture(ResourcePackTexture.Block.JUKEBOX_TOP, "assets/minecraft/textures/block/jukebox_top.png")
                .withTexture(ResourcePackTexture.Block.BIRCH_SAPLING, "assets/minecraft/textures/block/birch_sapling.png")
                .withTexture(ResourcePackTexture.Block.TORCH, "assets/minecraft/textures/block/torch.png")
                .withTexture(ResourcePackTexture.Block.WOODEN_DOOR_TOP, "assets/minecraft/textures/block/oak_door_top.png")
                .withTexture(ResourcePackTexture.Block.IRON_DOOR_TOP, "assets/minecraft/textures/block/iron_door_top.png")
                .withTexture(ResourcePackTexture.Block.LADDER, "assets/minecraft/textures/block/ladder.png")
                .withTexture(ResourcePackTexture.Block.TRAPDOOR, "assets/minecraft/textures/block/oak_trapdoor.png")
                .withTexture(ResourcePackTexture.Block.FARMLAND_WET, "assets/minecraft/textures/block/farmland_moist.png")
                .withTexture(ResourcePackTexture.Block.FARMLAND_DRY, "assets/minecraft/textures/block/farmland.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_0, "assets/minecraft/textures/block/wheat_stage0.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_1, "assets/minecraft/textures/block/wheat_stage1.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_2, "assets/minecraft/textures/block/wheat_stage2.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_3, "assets/minecraft/textures/block/wheat_stage3.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_4, "assets/minecraft/textures/block/wheat_stage4.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_5, "assets/minecraft/textures/block/wheat_stage5.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_6, "assets/minecraft/textures/block/wheat_stage6.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_7, "assets/minecraft/textures/block/wheat_stage7.png")
                .withTexture(ResourcePackTexture.Block.LEVER, "assets/minecraft/textures/block/lever.png")
                .withTexture(ResourcePackTexture.Block.WOODEN_DOOR_BOTTOM, "assets/minecraft/textures/block/oak_door_bottom.png")
                .withTexture(ResourcePackTexture.Block.IRON_DOOR_BOTTOM, "assets/minecraft/textures/block/iron_door_bottom.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_TORCH_ON, "assets/minecraft/textures/block/redstone_torch.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_TOP, "assets/minecraft/textures/block/pumpkin_top.png")
                .withTexture(ResourcePackTexture.Block.NETHERRACK, "assets/minecraft/textures/block/netherrack.png")
                .withTexture(ResourcePackTexture.Block.SOUL_SAND, "assets/minecraft/textures/block/soul_sand.png")
                .withTexture(ResourcePackTexture.Block.GLOWSTONE, "assets/minecraft/textures/block/glowstone.png")
                .withTexture(ResourcePackTexture.Block.PISTON_HEAD_STICKY, "assets/minecraft/textures/block/piston_top_sticky.png")
                .withTexture(ResourcePackTexture.Block.PISTON_HEAD, "assets/minecraft/textures/block/piston_top.png")
                .withTexture(ResourcePackTexture.Block.PISTON_SIDE, "assets/minecraft/textures/block/piston_side.png")
                .withTexture(ResourcePackTexture.Block.PISTON_BACK, "assets/minecraft/textures/block/piston_bottom.png")
                .withTexture(ResourcePackTexture.Block.PISTON_FRONT, "assets/minecraft/textures/block/piston_inner.png")
                .withTexture(ResourcePackTexture.Block.RAIL_CORNER, "assets/minecraft/textures/block/rail_corner.png")
                .withTexture(ResourcePackTexture.Block.WOOL_BLACK, "assets/minecraft/textures/block/black_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_DARK_GREY, "assets/minecraft/textures/block/gray_wool.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_TORCH_OFF, "assets/minecraft/textures/block/redstone_torch_off.png")
                .withTexture(ResourcePackTexture.Block.LOG_SPRUCE, "assets/minecraft/textures/block/spruce_log.png")
                .withTexture(ResourcePackTexture.Block.LOG_BIRCH, "assets/minecraft/textures/block/birch_log.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_SIDE, "assets/minecraft/textures/block/pumpkin_side.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_FRONT, "assets/minecraft/textures/block/pumpkin_side.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_FRONT_LIT, "assets/minecraft/textures/block/jack_o_lantern.png")
                .withTexture(ResourcePackTexture.Block.CAKE_TOP, "assets/minecraft/textures/block/cake_top.png")
                .withTexture(ResourcePackTexture.Block.CAKE_SIDE, "assets/minecraft/textures/block/cake_side.png")
                .withTexture(ResourcePackTexture.Block.CAKE_SIDE_EATEN, "assets/minecraft/textures/block/cake_inner.png")
                .withTexture(ResourcePackTexture.Block.CAKE_BOTTOM, "assets/minecraft/textures/block/cake_bottom.png")
                .withTexture(ResourcePackTexture.Block.RAIL, "assets/minecraft/textures/block/rail.png")
                .withTexture(ResourcePackTexture.Block.WOOL_RED, "assets/minecraft/textures/block/red_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_PINK, "assets/minecraft/textures/block/pink_wool.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_OFF, "assets/minecraft/textures/block/repeater.png")
                .withTexture(ResourcePackTexture.Block.LEAVES_FANCY_SPRUCE, "assets/minecraft/textures/block/spruce_leaves.png")
                .withTexture(ResourcePackTexture.Block.BED_LOWER_TOP, "assets/minecraft/textures/entity/bed/red.png")
                .withTexture(ResourcePackTexture.Block.BED_UPPER_TOP, "assets/minecraft/textures/entity/bed/red.png")
                .withTexture(ResourcePackTexture.Block.BLOCK_OF_LAPIS, "assets/minecraft/textures/block/lapis_block.png")
                .withTexture(ResourcePackTexture.Block.WOOL_DARK_GREEN, "assets/minecraft/textures/block/green_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_LIME, "assets/minecraft/textures/block/lime_wool.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_ON, "assets/minecraft/textures/block/repeater_on.png")
                .withTexture(ResourcePackTexture.Block.BED_FRONT, "assets/minecraft/textures/entity/bed/red.png")
                .withTexture(ResourcePackTexture.Block.BED_LOWER_SIDE, "assets/minecraft/textures/entity/bed/red.png")
                .withTexture(ResourcePackTexture.Block.BED_UPPER_SIDE, "assets/minecraft/textures/entity/bed/red.png")
                .withTexture(ResourcePackTexture.Block.BED_BACK, "assets/minecraft/textures/entity/bed/red.png")
                .withTexture(ResourcePackTexture.Block.ORE_LAPIS, "assets/minecraft/textures/block/lapis_ore.png")
                .withTexture(ResourcePackTexture.Block.WOOL_BROWN, "assets/minecraft/textures/block/brown_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_YELLOW, "assets/minecraft/textures/block/yellow_wool.png")
                .withTexture(ResourcePackTexture.Block.RAIL_POWERED_OFF, "assets/minecraft/textures/block/powered_rail.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_CROSS, "assets/minecraft/textures/block/redstone_dust_dot.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_LINE, "assets/minecraft/textures/block/redstone_dust_line0.png")
                .withTexture(ResourcePackTexture.Block.SANDSTONE_TOP, "assets/minecraft/textures/block/sandstone_top.png")
                .withTexture(ResourcePackTexture.Block.WOOL_DARK_BLUE, "assets/minecraft/textures/block/blue_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_LIGHT_BLUE, "assets/minecraft/textures/block/light_blue_wool.png")
                .withTexture(ResourcePackTexture.Block.RAIL_POWERED_ON, "assets/minecraft/textures/block/powered_rail_on.png")
                .withTexture(ResourcePackTexture.Block.SANDSTONE_SIDE, "assets/minecraft/textures/block/sandstone.png")
                .withTexture(ResourcePackTexture.Block.WOOL_PURPLE, "assets/minecraft/textures/block/purple_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_MAGENTA, "assets/minecraft/textures/block/magenta_wool.png")
                .withTexture(ResourcePackTexture.Block.RAIL_DETECTOR, "assets/minecraft/textures/block/detector_rail.png")
                .withTexture(ResourcePackTexture.Block.SANDSTONE_BOTTOM, "assets/minecraft/textures/block/sandstone_bottom.png")
                .withTexture(ResourcePackTexture.Block.WOOL_CYAN, "assets/minecraft/textures/block/cyan_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_ORANGE, "assets/minecraft/textures/block/orange_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_LIGHT_GREY, "assets/minecraft/textures/block/light_gray_wool.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_0, "assets/minecraft/textures/block/destroy_stage_0.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_1, "assets/minecraft/textures/block/destroy_stage_1.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_2, "assets/minecraft/textures/block/destroy_stage_2.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_3, "assets/minecraft/textures/block/destroy_stage_3.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_4, "assets/minecraft/textures/block/destroy_stage_4.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_5, "assets/minecraft/textures/block/destroy_stage_5.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_6, "assets/minecraft/textures/block/destroy_stage_6.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_7, "assets/minecraft/textures/block/destroy_stage_7.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_8, "assets/minecraft/textures/block/destroy_stage_8.png")
                .withTexture(ResourcePackTexture.Block.BREAKING_9, "assets/minecraft/textures/block/destroy_stage_8.png");
    }

    private ResourcePackBuilder withItems() {
        return this
                .withTexture(ResourcePackTexture.Item.HELMET_CLOTH, "assets/minecraft/textures/item/leather_helmet_overlay.png")
                .withTexture(ResourcePackTexture.Item.HELMET_CHAIN, "assets/minecraft/textures/item/chainmail_helmet.png")
                .withTexture(ResourcePackTexture.Item.HELMET_IRON, "assets/minecraft/textures/item/iron_helmet.png")
                .withTexture(ResourcePackTexture.Item.HELMET_DIAMOND, "assets/minecraft/textures/item/diamond_helmet.png")
                .withTexture(ResourcePackTexture.Item.HELMET_GOLD, "assets/minecraft/textures/item/golden_helmet.png")
                .withTexture(ResourcePackTexture.Item.FLINT_AND_STEEL, "assets/minecraft/textures/item/flint_and_steel.png")
                .withTexture(ResourcePackTexture.Item.FLINT, "assets/minecraft/textures/item/flint.png")
                .withTexture(ResourcePackTexture.Item.COAL, "assets/minecraft/textures/item/coal.png")
                .withTexture(ResourcePackTexture.Item.STRING, "assets/minecraft/textures/item/string.png")
                .withTexture(ResourcePackTexture.Item.WHEAT_SEEDS, "assets/minecraft/textures/item/wheat_seeds.png")
                .withTexture(ResourcePackTexture.Item.APPLE, "assets/minecraft/textures/item/apple.png")
                .withTexture(ResourcePackTexture.Item.GAPPLE, "assets/minecraft/textures/item/golden_apple.png")
                .withTexture(ResourcePackTexture.Item.EGG, "assets/minecraft/textures/item/egg.png")
                .withTexture(ResourcePackTexture.Item.SUGAR, "assets/minecraft/textures/item/sugar.png")
                .withTexture(ResourcePackTexture.Item.SNOWBALL, "assets/minecraft/textures/item/snowball.png")
                .withTexture(ResourcePackTexture.Item.HELMET_INVENTORY, "assets/minecraft/textures/item/empty_armor_slot_helmet.png")
                .withTexture(ResourcePackTexture.Item.CHEST_CLOTH, "assets/minecraft/textures/item/leather_chestplate_overlay.png")
                .withTexture(ResourcePackTexture.Item.CHEST_CHAIN, "assets/minecraft/textures/item/chainmail_chestplate.png")
                .withTexture(ResourcePackTexture.Item.CHEST_IRON, "assets/minecraft/textures/item/iron_chestplate.png")
                .withTexture(ResourcePackTexture.Item.CHEST_DIAMOND, "assets/minecraft/textures/item/diamond_chestplate.png")
                .withTexture(ResourcePackTexture.Item.CHEST_GOLD, "assets/minecraft/textures/item/golden_chestplate.png")
                .withTexture(ResourcePackTexture.Item.BOW, "assets/minecraft/textures/item/bow.png")
                .withTexture(ResourcePackTexture.Item.BRICK, "assets/minecraft/textures/item/brick.png")
                .withTexture(ResourcePackTexture.Item.INGOT_IRON, "assets/minecraft/textures/item/iron_ingot.png")
                .withTexture(ResourcePackTexture.Item.FEATHER, "assets/minecraft/textures/item/feather.png")
                .withTexture(ResourcePackTexture.Item.WHEAT, "assets/minecraft/textures/item/wheat.png")
                .withTexture(ResourcePackTexture.Item.PAINTING, "assets/minecraft/textures/item/painting.png")
                .withTexture(ResourcePackTexture.Item.SUGAR_CANE, "assets/minecraft/textures/item/sugar_cane.png")
                .withTexture(ResourcePackTexture.Item.BONE, "assets/minecraft/textures/item/bone.png")
                .withTexture(ResourcePackTexture.Item.CAKE, "assets/minecraft/textures/item/cake.png")
                .withTexture(ResourcePackTexture.Item.SLIMEBALL, "assets/minecraft/textures/item/slime_ball.png")
                .withTexture(ResourcePackTexture.Item.CHEST_INVENTORY, "assets/minecraft/textures/item/empty_armor_slot_chestplate.png")
                .withTexture(ResourcePackTexture.Item.LEGS_CLOTH, "assets/minecraft/textures/item/leather_leggings_overlay.png")
                .withTexture(ResourcePackTexture.Item.LEGS_CHAIN, "assets/minecraft/textures/item/chainmail_leggings.png")
                .withTexture(ResourcePackTexture.Item.LEGS_IRON, "assets/minecraft/textures/item/iron_leggings.png")
                .withTexture(ResourcePackTexture.Item.LEGS_DIAMOND, "assets/minecraft/textures/item/diamond_leggings.png")
                .withTexture(ResourcePackTexture.Item.LEGS_GOLD, "assets/minecraft/textures/item/golden_leggings.png")
                .withTexture(ResourcePackTexture.Item.ARROW, "assets/minecraft/textures/item/arrow.png")
                .withTexture(ResourcePackTexture.Item.INGOT_GOLD, "assets/minecraft/textures/item/gold_ingot.png")
                .withTexture(ResourcePackTexture.Item.GUNPOWDER, "assets/minecraft/textures/item/gunpowder.png")
                .withTexture(ResourcePackTexture.Item.BREAD, "assets/minecraft/textures/item/bread.png")
                .withTexture(ResourcePackTexture.Item.SIGN, "assets/minecraft/textures/item/oak_sign.png")
                .withTexture(ResourcePackTexture.Item.DOOR_WOODEN, "assets/minecraft/textures/item/oak_door.png")
                .withTexture(ResourcePackTexture.Item.DOOR_IRON, "assets/minecraft/textures/item/iron_door.png")
                .withTexture(ResourcePackTexture.Item.BED, "assets/minecraft/textures/item/red_bed.png")
                .withTexture(ResourcePackTexture.Item.LEGS_INVENTORY, "assets/minecraft/textures/item/empty_armor_slot_leggings.png")
                .withTexture(ResourcePackTexture.Item.BOOTS_CLOTH, "assets/minecraft/textures/item/leather_boots_overlay.png")
                .withTexture(ResourcePackTexture.Item.BOOTS_CHAIN, "assets/minecraft/textures/item/chainmail_boots.png")
                .withTexture(ResourcePackTexture.Item.BOOTS_IRON, "assets/minecraft/textures/item/iron_boots.png")
                .withTexture(ResourcePackTexture.Item.BOOTS_DIAMOND, "assets/minecraft/textures/item/diamond_boots.png")
                .withTexture(ResourcePackTexture.Item.BOOTS_GOLD, "assets/minecraft/textures/item/golden_boots.png")
                .withTexture(ResourcePackTexture.Item.STICK, "assets/minecraft/textures/item/stick.png")
                .withTexture(ResourcePackTexture.Item.COMPASS_BASE, "assets/minecraft/textures/item/compass.png")
                .withTexture(ResourcePackTexture.Item.DIAMOND, "assets/minecraft/textures/item/diamond.png")
                .withTexture(ResourcePackTexture.Item.REDSTONE, "assets/minecraft/textures/item/redstone.png")
                .withTexture(ResourcePackTexture.Item.CLAY, "assets/minecraft/textures/item/clay_ball.png")
                .withTexture(ResourcePackTexture.Item.PAPER, "assets/minecraft/textures/item/paper.png")
                .withTexture(ResourcePackTexture.Item.BOOK, "assets/minecraft/textures/item/book.png")
                .withTexture(ResourcePackTexture.Item.MAP, "assets/minecraft/textures/item/map.png")
                .withTexture(ResourcePackTexture.Item.BOOTS_INVENTORY, "assets/minecraft/textures/item/empty_armor_slot_boots.png")
                .withTexture(ResourcePackTexture.Item.SWORD_WOOD, "assets/minecraft/textures/item/wooden_sword.png")
                .withTexture(ResourcePackTexture.Item.SWORD_STONE, "assets/minecraft/textures/item/stone_sword.png")
                .withTexture(ResourcePackTexture.Item.SWORD_IRON, "assets/minecraft/textures/item/iron_sword.png")
                .withTexture(ResourcePackTexture.Item.SWORD_DIAMOND, "assets/minecraft/textures/item/diamond_sword.png")
                .withTexture(ResourcePackTexture.Item.SWORD_GOLD, "assets/minecraft/textures/item/golden_sword.png")
                .withTexture(ResourcePackTexture.Item.FISHING_ROD, "assets/minecraft/textures/item/fishing_rod.png")
                .withTexture(ResourcePackTexture.Item.CLOCK_BASE, "assets/minecraft/textures/item/clock.png")
                .withTexture(ResourcePackTexture.Item.BOWL, "assets/minecraft/textures/item/bowl.png")
                .withTexture(ResourcePackTexture.Item.MUSHROOM_SOUP, "assets/minecraft/textures/item/mushroom_stew.png")
                .withTexture(ResourcePackTexture.Item.GLOWSTONE_DUST, "assets/minecraft/textures/item/glowstone_dust.png")
                .withTexture(ResourcePackTexture.Item.BUCKET, "assets/minecraft/textures/item/bucket.png")
                .withTexture(ResourcePackTexture.Item.BUCKET_WATER, "assets/minecraft/textures/item/water_bucket.png")
                .withTexture(ResourcePackTexture.Item.BUCKET_LAVA, "assets/minecraft/textures/item/lava_bucket.png")
                .withTexture(ResourcePackTexture.Item.BUCKET_MILK, "assets/minecraft/textures/item/milk_bucket.png")
                .withTexture(ResourcePackTexture.Item.INK_SAC, "assets/minecraft/textures/item/ink_sac.png")
                .withTexture(ResourcePackTexture.Item.DYE_GREY, "assets/minecraft/textures/item/gray_dye.png")
                .withTexture(ResourcePackTexture.Item.SHOVEL_WOOD, "assets/minecraft/textures/item/wooden_shovel.png")
                .withTexture(ResourcePackTexture.Item.SHOVEL_STONE, "assets/minecraft/textures/item/stone_shovel.png")
                .withTexture(ResourcePackTexture.Item.SHOVEL_IRON, "assets/minecraft/textures/item/iron_shovel.png")
                .withTexture(ResourcePackTexture.Item.SHOVEL_DIAMOND, "assets/minecraft/textures/item/diamond_shovel.png")
                .withTexture(ResourcePackTexture.Item.SHOVEL_GOLD, "assets/minecraft/textures/item/golden_shovel.png")
                .withTexture(ResourcePackTexture.Item.FISHING_ROD_THROWN, "assets/minecraft/textures/item/fishing_rod_cast.png")
                .withTexture(ResourcePackTexture.Item.REDSTONE_REPEATER, "assets/minecraft/textures/item/repeater.png")
                .withTexture(ResourcePackTexture.Item.PORKCHOP, "assets/minecraft/textures/item/porkchop.png")
                .withTexture(ResourcePackTexture.Item.COOKED_PORKCHOP, "assets/minecraft/textures/item/cooked_porkchop.png")
                .withTexture(ResourcePackTexture.Item.FISH, "assets/minecraft/textures/item/cod.png")
                .withTexture(ResourcePackTexture.Item.COOKED_FISH, "assets/minecraft/textures/item/cooked_cod.png")
                .withTexture(ResourcePackTexture.Item.COOKIE, "assets/minecraft/textures/item/cookie.png")
                .withTexture(ResourcePackTexture.Item.SHEARS, "assets/minecraft/textures/item/shears.png")
                .withTexture(ResourcePackTexture.Item.DYE_RED, "assets/minecraft/textures/item/red_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_PINK, "assets/minecraft/textures/item/pink_dye.png")
                .withTexture(ResourcePackTexture.Item.PICKAXE_WOOD, "assets/minecraft/textures/item/wooden_pickaxe.png")
                .withTexture(ResourcePackTexture.Item.PICKAXE_STONE, "assets/minecraft/textures/item/stone_pickaxe.png")
                .withTexture(ResourcePackTexture.Item.PICKAXE_IRON, "assets/minecraft/textures/item/iron_pickaxe.png")
                .withTexture(ResourcePackTexture.Item.PICKAXE_DIAMOND, "assets/minecraft/textures/item/diamond_pickaxe.png")
                .withTexture(ResourcePackTexture.Item.PICKAXE_GOLD, "assets/minecraft/textures/item/golden_pickaxe.png")
                .withTexture(ResourcePackTexture.Item.LEATHER, "assets/minecraft/textures/item/leather.png")
                .withTexture(ResourcePackTexture.Item.SADDLE, "assets/minecraft/textures/item/saddle.png")
                .withTexture(ResourcePackTexture.Item.DYE_DARK_GREEN, "assets/minecraft/textures/item/green_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_LIME, "assets/minecraft/textures/item/lime_dye.png")
                .withTexture(ResourcePackTexture.Item.AXE_WOODEN, "assets/minecraft/textures/item/wooden_axe.png")
                .withTexture(ResourcePackTexture.Item.AXE_STONE, "assets/minecraft/textures/item/stone_axe.png")
                .withTexture(ResourcePackTexture.Item.AXE_IRON, "assets/minecraft/textures/item/iron_axe.png")
                .withTexture(ResourcePackTexture.Item.AXE_DIAMOND, "assets/minecraft/textures/item/diamond_axe.png")
                .withTexture(ResourcePackTexture.Item.AXE_GOLD, "assets/minecraft/textures/item/golden_axe.png")
                .withTexture(ResourcePackTexture.Item.DYE_BROWN, "assets/minecraft/textures/item/brown_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_YELLOW, "assets/minecraft/textures/item/yellow_dye.png")
                .withTexture(ResourcePackTexture.Item.HOE_WOODEN, "assets/minecraft/textures/item/wooden_hoe.png")
                .withTexture(ResourcePackTexture.Item.HOE_STONE, "assets/minecraft/textures/item/stone_hoe.png")
                .withTexture(ResourcePackTexture.Item.HOE_IRON, "assets/minecraft/textures/item/iron_hoe.png")
                .withTexture(ResourcePackTexture.Item.HOE_DIAMOND, "assets/minecraft/textures/item/diamond_hoe.png")
                .withTexture(ResourcePackTexture.Item.HOE_GOLD, "assets/minecraft/textures/item/golden_hoe.png")
                .withTexture(ResourcePackTexture.Item.MINECART, "assets/minecraft/textures/item/minecart.png")
                .withTexture(ResourcePackTexture.Item.BOAT, "assets/minecraft/textures/item/oak_boat.png")
                .withTexture(ResourcePackTexture.Item.DYE_DARK_BLUE, "assets/minecraft/textures/item/blue_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_LIGHT_BLUE, "assets/minecraft/textures/item/light_blue_dye.png")
                .withTexture(ResourcePackTexture.Item.MINECART_CHEST, "assets/minecraft/textures/item/chest_minecart.png")
                .withTexture(ResourcePackTexture.Item.DYE_PURPLE, "assets/minecraft/textures/item/purple_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_MAGENTA, "assets/minecraft/textures/item/magenta_dye.png")
                .withTexture(ResourcePackTexture.Item.MINECART_FURNACE, "assets/minecraft/textures/item/furnace_minecart.png")
                .withTexture(ResourcePackTexture.Item.DYE_TEAL, "assets/minecraft/textures/item/cyan_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_ORANGE, "assets/minecraft/textures/item/orange_dye.png")
                .withTexture(ResourcePackTexture.Item.DYE_LIGHT_GREY, "assets/minecraft/textures/item/light_gray_dye.png")
                .withTexture(ResourcePackTexture.Item.BONE_MEAL, "assets/minecraft/textures/item/bone_meal.png")
                .withTexture(ResourcePackTexture.Item.RECORD_13, "assets/minecraft/textures/item/music_disc_13.png")
                .withTexture(ResourcePackTexture.Item.RECORD_CAT, "assets/minecraft/textures/item/music_disc_cat.png");
    }

    private String readTextFile(String path) {
        try {
            InputStream input = resourcePackZip.getInputStream(resourcePackZip.getEntry(path));
            BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            StringBuilder file = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                file.append("\n").append(line);
            }
            return file.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ResourcePack build() {
        this
                .withInfo(new JSONObject(readTextFile("pack.mcmeta")).getJSONObject("pack").getString("description"))
                .withBlocks()
                .withItems()
                .withTexture(ResourcePackTexture.Gui.WIDGETS, "assets/minecraft/textures/gui/widgets.png")
                .withTexture(ResourcePackTexture.Gui.INVENTORY, "assets/minecraft/textures/gui/container/inventory.png")
                .withTexture(ResourcePackTexture.PACK, "pack.png")
                .withTexture(ResourcePackTexture.Block.WATER_STILL, "assets/minecraft/textures/block/water_still.png")
                .withTexture(ResourcePackTexture.FONT, "assets/minecraft/textures/font/ascii.png")
                .withTexture(ResourcePackTexture.Armour.CHAIN_UPPER, "assets/minecraft/textures/models/armor/chainmail_layer_1.png")
                .withTexture(ResourcePackTexture.Armour.CHAIN_LOWER, "assets/minecraft/textures/models/armor/chainmail_layer_2.png")
                .withTexture(ResourcePackTexture.Armour.LEATHER_UPPER_OVERLAY, "assets/minecraft/textures/models/armor/leather_layer_1_overlay.png")
                .withTexture(ResourcePackTexture.Armour.LEATHER_LOWER_OVERLAY, "assets/minecraft/textures/models/armor/leather_layer_2_overlay.png")
                .withTexture(ResourcePackTexture.Armour.LEATHER_UPPER, "assets/minecraft/textures/models/armor/leather_layer_1.png")
                .withTexture(ResourcePackTexture.Armour.LEATHER_LOWER, "assets/minecraft/textures/models/armor/leather_layer_2.png")
                .withTexture(ResourcePackTexture.Armour.DIAMOND_UPPER, "assets/minecraft/textures/models/armor/diamond_layer_1.png")
                .withTexture(ResourcePackTexture.Armour.DIAMOND_LOWER, "assets/minecraft/textures/models/armor/diamond_layer_2.png")
                .withTexture(ResourcePackTexture.Armour.GOLD_UPPER, "assets/minecraft/textures/models/armor/gold_layer_1.png")
                .withTexture(ResourcePackTexture.Armour.GOLD_LOWER, "assets/minecraft/textures/models/armor/gold_layer_2.png")
                .withTexture(ResourcePackTexture.Armour.IRON_UPPER, "assets/minecraft/textures/models/armor/iron_layer_1.png")
                .withTexture(ResourcePackTexture.Armour.IRON_LOWER, "assets/minecraft/textures/models/armor/iron_layer_2.png")
                .withTexture(ResourcePackTexture.Mob.CREEPER_CHARGE, "")
                .withTexture(ResourcePackTexture.Painting.ALBAN, "assets/minecraft/textures/painting/alban.png")
                .withTexture(ResourcePackTexture.Painting.AZTEC, "assets/minecraft/textures/painting/aztec.png")
                .withTexture(ResourcePackTexture.Painting.AZTEC2, "assets/minecraft/textures/painting/aztec2.png")
                .withTexture(ResourcePackTexture.Painting.BACK, "assets/minecraft/textures/painting/back.png")
                .withTexture(ResourcePackTexture.Painting.BOMB, "assets/minecraft/textures/painting/bomb.png")
                .withTexture(ResourcePackTexture.Painting.BURNING_SKULL, "assets/minecraft/textures/painting/burning_skull.png")
                .withTexture(ResourcePackTexture.Painting.BUST, "assets/minecraft/textures/painting/bust.png")
                .withTexture(ResourcePackTexture.Painting.COURBET, "assets/minecraft/textures/painting/courbet.png")
                .withTexture(ResourcePackTexture.Painting.CREEBET, "assets/minecraft/textures/painting/creebet.png")
                .withTexture(ResourcePackTexture.Painting.DONKEY_KONG, "assets/minecraft/textures/painting/donkey_kong.png")
                .withTexture(ResourcePackTexture.Painting.FIGHTERS, "assets/minecraft/textures/painting/fighters.png")
                .withTexture(ResourcePackTexture.Painting.KEBAB, "assets/minecraft/textures/painting/kebab.png")
                .withTexture(ResourcePackTexture.Painting.MATCH, "assets/minecraft/textures/painting/match.png")
                .withTexture(ResourcePackTexture.Painting.PIGSCENE, "assets/minecraft/textures/painting/pigscene.png")
                .withTexture(ResourcePackTexture.Painting.GRAHAM, "assets/minecraft/textures/painting/graham.png")
                .withTexture(ResourcePackTexture.Painting.POOL, "assets/minecraft/textures/painting/pool.png")
                .withTexture(ResourcePackTexture.Painting.SEA, "assets/minecraft/textures/painting/sea.png")
                .withTexture(ResourcePackTexture.Painting.SKELETON, "assets/minecraft/textures/painting/skeleton.png")
                .withTexture(ResourcePackTexture.Painting.SKULL_AND_ROSES, "assets/minecraft/textures/painting/skull_and_roses.png")
                .withTexture(ResourcePackTexture.Painting.SUNSET, "assets/minecraft/textures/painting/sunset.png")
                .withTexture(ResourcePackTexture.Painting.VOID, "assets/minecraft/textures/painting/void.png")
                .withTexture(ResourcePackTexture.Painting.WANDERER, "assets/minecraft/textures/painting/wanderer.png")
                .withTexture(ResourcePackTexture.Painting.WASTELAND, "assets/minecraft/textures/painting/wasteland.png")
                .withTexture(ResourcePackTexture.Painting.PLANT, "assets/minecraft/textures/painting/plant.png")
                .withTexture(ResourcePackTexture.Painting.STAGE, "assets/minecraft/textures/painting/stage.png")
                .withTexture(ResourcePackTexture.Painting.POINTER, "assets/minecraft/textures/painting/pointer.png")
                .withTexture(ResourcePackTexture.ENVIRONMENT_CLOUDS, "assets/minecraft/textures/environment/clouds.png")
                .withTexture(ResourcePackTexture.ENVIRONMENT_RAIN, "assets/minecraft/textures/environment/rain.png")
                .withTexture(ResourcePackTexture.ENVIRONMENT_SNOW, "assets/minecraft/textures/environment/snow.png")
                .withTexture(ResourcePackTexture.ENVIRONMENT_SUN, "assets/minecraft/textures/environment/sun.png")
                .withTexture(ResourcePackTexture.ENVIRONMENT_MOON_PHASES, "assets/minecraft/textures/environment/moon_phases.png")
                .withTexture(ResourcePackTexture.Gui.CONTAINER, "assets/minecraft/textures/gui/container/generic_54.png")
                .withTexture(ResourcePackTexture.Gui.CRAFTING, "assets/minecraft/textures/gui/container/crafting_table.png")
                .withTexture(ResourcePackTexture.Gui.FURNACE, "assets/minecraft/textures/gui/container/furnace.png")
                .withTexture(ResourcePackTexture.Gui.ICONS, "assets/minecraft/textures/gui/icons.png")
                .withTexture(ResourcePackTexture.Gui.LOGO, "assets/minecraft/textures/gui/title/minecraft.png")
                .withTexture(ResourcePackTexture.Gui.SLOT, "")
                .withTexture(ResourcePackTexture.Gui.TRAP, "")
                .withTexture(ResourcePackTexture.Gui.UNKNOWN_PACK, "assets/minecraft/textures/misc/unknown_pack.png")
                .withTexture(ResourcePackTexture.ITEM_ARROWS, "assets/minecraft/textures/entity/projectiles/arrow.png")
                .withTexture(ResourcePackTexture.ITEM_BOAT, "")
                .withTexture(ResourcePackTexture.ITEM_CART, "assets/minecraft/textures/entity/minecart.png")
                .withTexture(ResourcePackTexture.ITEM_SIGN, "assets/minecraft/textures/entity/signs/oak.png")
                .withTexture(ResourcePackTexture.Item.CLOCK_DIAL, "")
                .withTexture(ResourcePackTexture.FOLIAGE_COLOR, "")
                .withTexture(ResourcePackTexture.GRASS_COLOR, "")
                .withTexture(ResourcePackTexture.MAP_BACKGROUND, "")
                .withTexture(ResourcePackTexture.MAP_ICONS, "")
                .withTexture(ResourcePackTexture.PUMPKIN_BLUR, "assets/minecraft/textures/misc/pumpkinblur.png")
                .withTexture(ResourcePackTexture.SHADOW, "")
                .withTexture(ResourcePackTexture.VIGNETTE, "assets/minecraft/textures/misc/vignette.png")
                .withTexture(ResourcePackTexture.WATER_BLUR, "")
                .withTexture(ResourcePackTexture.WATER_COLOR, "")
//                .withTexture(ResourcePackTexture.Mob.STEVE, "")
                .withTexture(ResourcePackTexture.Mob.CHICKEN, "assets/minecraft/textures/entity/chicken.png")
                .withTexture(ResourcePackTexture.Mob.COW, "")
                .withTexture(ResourcePackTexture.Mob.CREEPER, "")
                .withTexture(ResourcePackTexture.Mob.GHAST_FIRE, "")
                .withTexture(ResourcePackTexture.Mob.GHAST, "")
                .withTexture(ResourcePackTexture.Mob.PIG, "assets/minecraft/textures/entity/pig/pig.png")
                .withTexture(ResourcePackTexture.Mob.PIG_SADDLE, "assets/minecraft/textures/entity/pig/pig_saddle.png")
                .withTexture(ResourcePackTexture.Mob.SHEEP_FUR, "assets/minecraft/textures/entity/sheep/sheep_fur.png")
                .withTexture(ResourcePackTexture.Mob.SHEEP, "assets/minecraft/textures/entity/sheep/sheep.png")
                .withTexture(ResourcePackTexture.Mob.SKELETON, "")
                .withTexture(ResourcePackTexture.Mob.SLIME, "")
                .withTexture(ResourcePackTexture.Mob.SPIDER_EYES, "")
                .withTexture(ResourcePackTexture.Mob.SPIDER, "")
                .withTexture(ResourcePackTexture.Mob.SQUID, "")
                .withTexture(ResourcePackTexture.Mob.WOLF_ANGRY, "")
                .withTexture(ResourcePackTexture.Mob.DOGGY, "")
                .withTexture(ResourcePackTexture.Mob.WOLF, "")
                .withTexture(ResourcePackTexture.Mob.ZOMBIE, "")
                .withTexture(ResourcePackTexture.Gui.PANORAMA0, "assets/minecraft/textures/gui/title/background/panorama_0.png")
                .withTexture(ResourcePackTexture.Gui.PANORAMA1, "assets/minecraft/textures/gui/title/background/panorama_1.png")
                .withTexture(ResourcePackTexture.Gui.PANORAMA2, "assets/minecraft/textures/gui/title/background/panorama_2.png")
                .withTexture(ResourcePackTexture.Gui.PANORAMA3, "assets/minecraft/textures/gui/title/background/panorama_3.png")
                .withTexture(ResourcePackTexture.Gui.PANORAMA4, "assets/minecraft/textures/gui/title/background/panorama_4.png")
                .withTexture(ResourcePackTexture.Gui.PANORAMA5, "assets/minecraft/textures/gui/title/background/panorama_5.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_0, "assets/minecraft/textures/particle/generic_0.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_1, "assets/minecraft/textures/particle/generic_1.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_2, "assets/minecraft/textures/particle/generic_2.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_3, "assets/minecraft/textures/particle/generic_3.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_4, "assets/minecraft/textures/particle/generic_4.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_5, "assets/minecraft/textures/particle/generic_5.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_6, "assets/minecraft/textures/particle/generic_6.png")
                .withTexture(ResourcePackTexture.Particle.GENERIC_7, "assets/minecraft/textures/particle/generic_7.png")
                .withTexture(ResourcePackTexture.Particle.BUBBLE, "assets/minecraft/textures/particle/bubble.png")
                .withTexture(ResourcePackTexture.Particle.FISHING_HOOK, "assets/minecraft/textures/entity/fishing_hook.png")
                .withTexture(ResourcePackTexture.Particle.FLAME, "assets/minecraft/textures/particle/flame.png")
                .withTexture(ResourcePackTexture.Particle.HEART, "assets/minecraft/textures/particle/heart.png")
                .withTexture(ResourcePackTexture.Particle.LAVA, "assets/minecraft/textures/particle/lava.png")
                .withTexture(ResourcePackTexture.Particle.NOTE, "assets/minecraft/textures/particle/note.png")
                .withTexture(ResourcePackTexture.Particle.SPLASH_0, "assets/minecraft/textures/particle/splash_0.png")
                .withTexture(ResourcePackTexture.Particle.SPLASH_1, "assets/minecraft/textures/particle/splash_1.png")
                .withTexture(ResourcePackTexture.Particle.SPLASH_2, "assets/minecraft/textures/particle/splash_2.png")
                .withTexture(ResourcePackTexture.Particle.SPLASH_3, "assets/minecraft/textures/particle/splash_3.png")
        ;



        return new ResourcePack(name, info, textures);
    }
}
