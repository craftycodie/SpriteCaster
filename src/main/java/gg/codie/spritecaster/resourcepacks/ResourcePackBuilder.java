package gg.codie.spritecaster.resourcepacks;

import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
            textures.put(texture, getSprite(relativePath));
        } catch (Exception ex) {
//            ex.printStackTrace();
        }

        return this;
    }

    public ResourcePack build() {
            this.withTexture(ResourcePackTexture.Block.GRASS_TOP, "assets/minecraft/textures/block/grass_block_top.png")
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
                .withTexture(ResourcePackTexture.Block.COBWEB, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.RED_FLOWER, "assets/minecraft/textures/block/poppy.png")
                .withTexture(ResourcePackTexture.Block.YELLOW_FLOWER, "assets/minecraft/textures/block/.png")
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
                .withTexture(ResourcePackTexture.Block.CHEST_TOP, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CHEST_SIDE, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CHEST_FRONT, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.RED_MUSHROOM, "assets/minecraft/textures/block/red_mushroom.png")
                .withTexture(ResourcePackTexture.Block.BROWN_MUSHROOM, "assets/minecraft/textures/block/brown_mushroom.png")
                .withTexture(ResourcePackTexture.Block.ORE_GOLD, "assets/minecraft/textures/block/gold_ore.png")
                .withTexture(ResourcePackTexture.Block.ORE_IRON, "assets/minecraft/textures/block/iron_ore.png")
                .withTexture(ResourcePackTexture.Block.ORE_COAL, "assets/minecraft/textures/block/coal_ore.png")
                .withTexture(ResourcePackTexture.Block.BOOKSHELF, "assets/minecraft/textures/block/bookshelf.png")
                .withTexture(ResourcePackTexture.Block.MOSSY_COBBLESTONE, "assets/minecraft/textures/block/mossy_cobblestone.png")
                .withTexture(ResourcePackTexture.Block.OBSIDIAN, "assets/minecraft/textures/block/obsidian.png")
                .withTexture(ResourcePackTexture.Block.GRASS_SIDE_OVERLAY, "assets/minecraft/textures/block/grass_side_overlay.png")
                .withTexture(ResourcePackTexture.Block.TALL_GRASS, "assets/minecraft/textures/block/tall_grass.png")
                .withTexture(ResourcePackTexture.Block.GRASS_TOP_SNOWY, "assets/minecraft/textures/block/grass_top.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_LEFT, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_RIGHT, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CRAFTING_TABLE_TOP, "assets/minecraft/textures/block/crafting_table_top.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_FRONT, "assets/minecraft/textures/block/furnace_front.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_SIDE, "assets/minecraft/textures/block/furnace_side.png")
                .withTexture(ResourcePackTexture.Block.DISPENSER_FRONT, "assets/minecraft/textures/block/dispenser_front.png")
                .withTexture(ResourcePackTexture.Block.SPONGE, "assets/minecraft/textures/block/sponge.png")
                .withTexture(ResourcePackTexture.Block.GLASS, "assets/minecraft/textures/block/glass.png")
                .withTexture(ResourcePackTexture.Block.ORE_DIAMOND, "assets/minecraft/textures/block/diamond_ore.png")
                .withTexture(ResourcePackTexture.Block.ORE_REDSTONE, "assets/minecraft/textures/block/redstone_ore.png")
                .withTexture(ResourcePackTexture.Block.LEAVES_FANCY, "assets/minecraft/textures/block/oak_leaves.png")
                .withTexture(ResourcePackTexture.Block.LEAVES_FAST, "assets/minecraft/textures/block/oak_leaves.png")
                .withTexture(ResourcePackTexture.Block.DEADBUSH, "assets/minecraft/textures/block/dead_bush.png")
                .withTexture(ResourcePackTexture.Block.FERN, "assets/minecraft/textures/block/fern.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_LEFT, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_RIGHT, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SCISSORS, "assets/minecraft/textures/block/crafting_table_front.png")
                .withTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SAW, "assets/minecraft/textures/block/crafting_table_side.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_BURNING, "assets/minecraft/textures/block/furnace_front_on.png")
                .withTexture(ResourcePackTexture.Block.FURNACE_TOP, "assets/minecraft/textures/block/furnace_top.png")
                .withTexture(ResourcePackTexture.Block.SPRUCE_SAPLING, "assets/minecraft/textures/block/spruce_sapling.png")
                .withTexture(ResourcePackTexture.Block.WOOL_WHITE, "assets/minecraft/textures/block/white_wool.png")
                .withTexture(ResourcePackTexture.Block.MOB_SPAWNER, "assets/minecraft/textures/block/monster_spawner.png")
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
                .withTexture(ResourcePackTexture.Block.IRON_DOOR_TOP, "assets/minecraft/textures/block/iron_door_rop.png")
                .withTexture(ResourcePackTexture.Block.LADDER, "assets/minecraft/textures/block/ladder.png")
                .withTexture(ResourcePackTexture.Block.TRAPDOOR, "assets/minecraft/textures/block/oak_trapdoor.png")
                .withTexture(ResourcePackTexture.Block.FARMLAND_WET, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.FARMLAND_DRY, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_0, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_1, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_2, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_3, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_4, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_5, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_6, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WHEAT_7, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.LEVER, "assets/minecraft/textures/block/.png")
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
                .withTexture(ResourcePackTexture.Block.RAIL_CORNER, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WOOL_BLACK, "assets/minecraft/textures/block/black_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_DARK_GREY, "assets/minecraft/textures/block/gray_wool.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_TORCH_OFF, "assets/minecraft/textures/block/redstone_torch_off.png")
                .withTexture(ResourcePackTexture.Block.LOG_SPRUCE, "assets/minecraft/textures/block/spruce_log.png")
                .withTexture(ResourcePackTexture.Block.LOG_BIRCH, "assets/minecraft/textures/block/birch_log.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_SIDE, "assets/minecraft/textures/block/pumpkin_side.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_FRONT, "assets/minecraft/textures/block/pumpkin_side.png")
                .withTexture(ResourcePackTexture.Block.PUMPKIN_FRONT_LIT, "assets/minecraft/textures/block/jack_o_lantern.png")
                .withTexture(ResourcePackTexture.Block.CAKE_TOP, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CACTUS_SIDE, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CAKE_SIDE_EATEN, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.CAKE_BOTTOM, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.RAIL, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.WOOL_RED, "assets/minecraft/textures/block/red_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_PINK, "assets/minecraft/textures/block/pink_wool.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_OFF, "assets/minecraft/textures/block/repeater.png")
                .withTexture(ResourcePackTexture.Block.LEAVES_FANCY_SPRUCE, "assets/minecraft/textures/block/spruce_leaves.png")
                .withTexture(ResourcePackTexture.Block.LEAVES_FAST_SPRUCE, "assets/minecraft/textures/block/spruce_leaves.png")
                .withTexture(ResourcePackTexture.Block.BED_LOWER_TOP, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.BED_UPPER_TOP, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.BLOCK_OF_LAPIS, "assets/minecraft/textures/block/lapis_block.png")
                .withTexture(ResourcePackTexture.Block.WOOL_DARK_GREEN, "assets/minecraft/textures/block/green_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_LIME, "assets/minecraft/textures/block/lime_wool.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_ON, "assets/minecraft/textures/block/repeater_on.png")
                .withTexture(ResourcePackTexture.Block.BED_FRONT, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.BED_LOWER_SIDE, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.BED_UPPER_SIDE, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.BED_BACK, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.ORE_LAPIS, "assets/minecraft/textures/block/lapis_ore.png")
                .withTexture(ResourcePackTexture.Block.WOOL_BROWN, "assets/minecraft/textures/block/brown_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_YELLOW, "assets/minecraft/textures/block/yellow_wool.png")
                .withTexture(ResourcePackTexture.Block.RAIL_POWERED_OFF, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_CROSS, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.REDSTONE_LINE, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.SANDSTONE_TOP, "assets/minecraft/textures/block/sandstone_top.png")
                .withTexture(ResourcePackTexture.Block.WOOL_DARK_BLUE, "assets/minecraft/textures/block/blue_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_LIGHT_BLUE, "assets/minecraft/textures/block/light_blue_wool.png")
                .withTexture(ResourcePackTexture.Block.RAIL_POWERED_ON, "assets/minecraft/textures/block/.png")
                .withTexture(ResourcePackTexture.Block.SANDSTONE_SIDE, "assets/minecraft/textures/block/sandstone.png")
                .withTexture(ResourcePackTexture.Block.WOOL_PURPLE, "assets/minecraft/textures/block/purple_wool.png")
                .withTexture(ResourcePackTexture.Block.WOOL_MAGENTA, "assets/minecraft/textures/block/magenta_wool.png")
                .withTexture(ResourcePackTexture.Block.RAIL_DETECTOR, "assets/minecraft/textures/block/.png")
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

        return new ResourcePack(name, info, textures);
    }
}
