package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.SpriteAtlas;
import gg.codie.spritecaster.SpriteAtlasBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePack;
import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.image.BufferedImage;

public class Beta17TexturePackBuilder extends AbstractTexturePackBuilder {
    SpriteAtlas terrainAtlas;
    SpriteAtlas itemAtlas;

    private SpriteAtlas createTerrain() {
        return new SpriteAtlasBuilder()
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_TOP), 1, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.STONE), 1, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DIRT), 1, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_SIDE), 1, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_PLANKS), 1, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.STONE_SLAB_SIDE), 1, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.STONE_SLAB_TOP), 1, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BRICK), 1, 8)
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GRASS_SIDE_OVERLAY), 3, 7)
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FANCY), 4, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FAST), 4, 6)
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SUGAR_CANE), 5, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.NOTEBLOCK), 5, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.JUKEBOX_TOP), 5, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BIRCH_SAPLING), 5, 16)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TORCH), 6, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_DOOR_TOP), 6, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.IRON_DOOR_TOP), 6, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LADDER), 6, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TRAPDOOR), 6, 5)
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PISTON_HEAD_STICKY), 7, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PISTON_HEAD), 7, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PISTON_SIDE), 7, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PISTON_BACK), 7, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.PISTON_FRONT), 7, 15)
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_SIDE), 8, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_SIDE_EATEN), 8, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CAKE_BOTTOM), 8, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL), 9, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_RED), 9, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_PINK), 9, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_OFF), 9, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FANCY_SPRUCE), 9, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FAST_SPRUCE), 9, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_LOWER_TOP), 9, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_UPPER_TOP), 9, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BLOCK_OF_LAPIS), 10, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_DARK_GREEN), 10, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIME), 10, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_REPEATER_ON), 10, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_FRONT), 10, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_LOWER_SIDE), 10, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_UPPER_TOP), 10, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BED_BACK), 10, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_LAPIS), 11, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_BROWN), 11, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_YELLOW), 11, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_POWERED_OFF), 11, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_POWERED_ON), 11, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_CROSS), 11, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.REDSTONE_LINE), 11, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SANDSTONE_TOP), 12, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_DARK_BLUE), 12, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIGHT_BLUE), 12, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_POWERED_ON), 12, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SANDSTONE_SIDE), 13, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_PURPLE), 13, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_MAGENTA), 13, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_DETECTOR), 13, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SANDSTONE_BOTTOM), 14, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_CYAN), 14, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_ORANGE), 14, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIGHT_GREY), 15, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_0), 16, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_1), 16, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_2), 16, 3) // Electric Boogaloo
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_3), 16, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_4), 16, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_5), 16, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_6), 16, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_7), 16, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_8), 16, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.BREAKING_9), 16, 10)
                .build();
    }

    private SpriteAtlas createItems() {
        return new SpriteAtlasBuilder()
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HELMET_CLOTH), 1, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HELMET_CHAIN), 1, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HELMET_IRON), 1, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HELMET_DIAMOND), 1, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HELMET_GOLD), 1, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.FLINT_AND_STEEL), 1, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.FLINT), 1, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.COAL), 1, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.STRING), 1, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.WHEAT_SEEDS), 1, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.APPLE), 1, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.GAPPLE), 1, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.EGG), 1, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SUGAR), 1, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SNOWBALL), 1, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HELMET_INVENTORY), 1, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CHEST_CLOTH), 2, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CHEST_CHAIN), 2, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CHEST_IRON), 2, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CHEST_DIAMOND), 2, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CHEST_GOLD), 2, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOW), 2, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BRICK), 2, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.INGOT_IRON), 2, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.FEATHER), 2, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.WHEAT), 2, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PAINTING), 2, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SUGAR_CANE), 2, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BONE), 2, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CAKE), 2, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SLIMEBALL), 2, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CHEST_INVENTORY), 2, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEGS_CLOTH), 3, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEGS_CHAIN), 3, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEGS_IRON), 3, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEGS_DIAMOND), 3, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEGS_GOLD), 3, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.ARROW), 3, 6)
//                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.QUIVER), 3, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.INGOT_GOLD), 3, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.GUNPOWDER), 3, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BREAD), 3, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SIGN), 3, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DOOR_WOODEN), 3, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DOOR_IRON), 3, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BED), 3, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEGS_INVENTORY), 3, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOTS_CLOTH), 4, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOTS_CHAIN), 4, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOTS_IRON), 4, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOTS_DIAMOND), 4, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOTS_GOLD), 4, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.STICK), 4, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.COMPASS_BASE), 4, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DIAMOND), 4, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.REDSTONE), 4, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CLAY), 4, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PAPER), 4, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOK), 4, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.MAP), 4, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOOTS_INVENTORY), 4, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SWORD_WOOD), 5, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SWORD_STONE), 5, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SWORD_IRON), 5, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SWORD_DIAMOND), 5, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SWORD_GOLD), 5, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.FISHING_ROD), 5, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.CLOCK_BASE), 5, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOWL), 5, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.MUSHROOM_SOUP), 5, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.GLOWSTONE_DUST), 5, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BUCKET), 5, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BUCKET_WATER), 5, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BUCKET_LAVA), 5, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BUCKET_MILK), 5, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.INK_SAC), 5, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_GREY), 5, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SHOVEL_WOOD), 6, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SHOVEL_STONE), 6, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SHOVEL_IRON), 6, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SHOVEL_DIAMOND), 6, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SHOVEL_GOLD), 6, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.FISHING_ROD_THROWN), 6, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.REDSTONE_REPEATER), 6, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PORKCHOP), 6, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.COOKED_PORKCHOP), 6, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.FISH), 6, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.COOKED_FISH), 6, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.COOKIE), 6, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SHEARS), 6, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_RED), 6, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_PINK), 6, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PICKAXE_WOOD), 7, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PICKAXE_STONE), 7, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PICKAXE_IRON), 7, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PICKAXE_DIAMOND), 7, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.PICKAXE_GOLD), 7, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.LEATHER), 7, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.SADDLE), 7, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_DARK_GREEN), 7, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_LIME), 7, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.AXE_WOODEN), 8, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.AXE_STONE), 8, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.AXE_IRON), 8, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.AXE_DIAMOND), 8, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.AXE_GOLD), 8, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_BROWN), 8, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_YELLOW), 8, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HOE_WOODEN), 9, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HOE_STONE), 9, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HOE_IRON), 9, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HOE_DIAMOND), 9, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.HOE_GOLD), 9, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.MINECART), 9, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BOAT), 9, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_DARK_BLUE), 9, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_LIGHT_BLUE), 9, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.MINECART_CHEST), 10, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_PURPLE), 10, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_MAGENTA), 10, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.MINECART_FURNACE), 11, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_TEAL), 11, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_ORANGE), 11, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.DYE_LIGHT_GREY), 12, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.BONE_MEAL), 12, 16)

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.RECORD_13), 16, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Item.RECORD_CAT), 16, 2)

                .build();

    }

    public Beta17TexturePackBuilder(ResourcePack resourcePack) {
        super(resourcePack);

        terrainAtlas = createTerrain();
        itemAtlas = createItems();

        BufferedImage terrain = terrainAtlas.getImage();
        BufferedImage items = itemAtlas.getImage();

        addTexture(TexturePackTexture.TERRAIN, terrain);
        addTexture(TexturePackTexture.ITEMS, items);

        addTexture(TexturePackTexture.GUI_WIDGETS, resourcePack.getTexture(ResourcePackTexture.Gui.WIDGETS));
        addTexture(TexturePackTexture.GUI_INVENTORY, resourcePack.getTexture(ResourcePackTexture.Gui.INVENTORY));
        addTexture(TexturePackTexture.GUI_BACKGROUND, resourcePack.getTexture(ResourcePackTexture.Block.DIRT));
        addTexture(TexturePackTexture.WATER_STILL, resourcePack.getTexture(ResourcePackTexture.Block.WATER_STILL));
        addTexture(TexturePackTexture.WATER_FLOWING, resourcePack.getTexture(ResourcePackTexture.Block.WATER_FLOWING));
        addTexture(TexturePackTexture.GRASS_COLOR, resourcePack.getTexture(ResourcePackTexture.GRASS_COLOR));
        addTexture(TexturePackTexture.FONT, resourcePack.getTexture(ResourcePackTexture.FONT));
        addTexture(TexturePackTexture.CHAINMAIL_ARMOUR_LOWER, resourcePack.getTexture(ResourcePackTexture.Armour.CHAIN_LOWER));
        addTexture(TexturePackTexture.CHAINMAIL_ARMOUR_UPPER, resourcePack.getTexture(ResourcePackTexture.Armour.CHAIN_UPPER));
        addTexture(TexturePackTexture.CLOTH_ARMOUR_LOWER, resourcePack.getTexture(ResourcePackTexture.Armour.LEATHER_LOWER));
        addTexture(TexturePackTexture.CLOTH_ARMOUR_UPPER, resourcePack.getTexture(ResourcePackTexture.Armour.LEATHER_UPPER));
        addTexture(TexturePackTexture.DIAMOND_ARMOUR_LOWER, resourcePack.getTexture(ResourcePackTexture.Armour.DIAMOND_LOWER));
        addTexture(TexturePackTexture.DIAMOND_ARMOUR_UPPER, resourcePack.getTexture(ResourcePackTexture.Armour.DIAMOND_UPPER));
        addTexture(TexturePackTexture.GOLDEN_ARMOUR_UPPER, resourcePack.getTexture(ResourcePackTexture.Armour.GOLD_UPPER));
        addTexture(TexturePackTexture.GOLDEN_ARMOUR_LOWER, resourcePack.getTexture(ResourcePackTexture.Armour.GOLD_LOWER));
        addTexture(TexturePackTexture.IRON_ARMOUR_UPPER, resourcePack.getTexture(ResourcePackTexture.Armour.IRON_UPPER));
        addTexture(TexturePackTexture.IRON_ARMOUR_LOWER, resourcePack.getTexture(ResourcePackTexture.Armour.IRON_LOWER));
        addTexture(TexturePackTexture.CLOUDS, resourcePack.getTexture(ResourcePackTexture.ENVIRONMENT_CLOUDS));
        addTexture(TexturePackTexture.RAIN, resourcePack.getTexture(ResourcePackTexture.ENVIRONMENT_RAIN));
        addTexture(TexturePackTexture.SNOW, resourcePack.getTexture(ResourcePackTexture.ENVIRONMENT_SNOW));
        addTexture(TexturePackTexture.GUI_CONTAINER, resourcePack.getTexture(ResourcePackTexture.Gui.CONTAINER));
        addTexture(TexturePackTexture.GUI_CRAFTING, resourcePack.getTexture(ResourcePackTexture.Gui.CRAFTING));
        addTexture(TexturePackTexture.GUI_LOGO, resourcePack.getTexture(ResourcePackTexture.Gui.LOGO));
//        addTexture(TexturePackTexture.GUI_PARTICLES, resourcePack.getTexture(ResourcePackTexture))
//        addTexture(TexturePackTexture.GUI_SLOT, resourcePack)
//        addTexture(TexturePackTexture.GUI_DISPENSER, resourcePack.getTexture(ResourcePackTexture.Gui.D))
        addTexture(TexturePackTexture.UNKNOWN_PACK, resourcePack.getTexture(ResourcePackTexture.Gui.UNKNOWN_PACK));
        addTexture(TexturePackTexture.ITEM_ARROWS, resourcePack.getTexture(ResourcePackTexture.ITEM_ARROWS));
        addTexture(TexturePackTexture.ITEM_BOAT, resourcePack.getTexture(ResourcePackTexture.ITEM_BOAT));
        addTexture(TexturePackTexture.ITEM_CART, resourcePack.getTexture(ResourcePackTexture.ITEM_CART));
        addTexture(TexturePackTexture.ITEM_SIGN, resourcePack.getTexture(ResourcePackTexture.ITEM_SIGN));
        addTexture(TexturePackTexture.PUMPKIN_BLUR, resourcePack.getTexture(ResourcePackTexture.PUMPKIN_BLUR));
        addTexture(TexturePackTexture.VIGNETTE, resourcePack.getTexture(ResourcePackTexture.VIGNETTE));
//        addTexture(TexturePackTexture.WATER_BLUR, ResourcePackTexture.Block.WATER_BLUR)
        addTexture(TexturePackTexture.SHEEP, resourcePack.getTexture(ResourcePackTexture.Mob.SHEEP));
        addTexture(TexturePackTexture.SHEEP_FUR, resourcePack.getTexture(ResourcePackTexture.Mob.SHEEP_FUR));
        addTexture(TexturePackTexture.MCLOGO, resourcePack.getTexture(ResourcePackTexture.Gui.LOGO));
        addTexture(TexturePackTexture.MOON, resourcePack.getTexture(ResourcePackTexture.ENVIRONMENT_MOON_PHASES));
        addTexture(TexturePackTexture.SUN, resourcePack.getTexture(ResourcePackTexture.ENVIRONMENT_SUN));






    }

    @Override
    public String getMinecraftVersion() {
        return "b1.7";
    }
}
