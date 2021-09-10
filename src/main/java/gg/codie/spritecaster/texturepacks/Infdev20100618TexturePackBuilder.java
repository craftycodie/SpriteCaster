package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.SpriteAtlas;
import gg.codie.spritecaster.SpriteAtlasBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePackStack;
import gg.codie.spritecaster.resources.textures.ResourcePackTexture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Infdev20100618TexturePackBuilder extends Alpha11201TexturePackBuilder {
    public Infdev20100618TexturePackBuilder(ResourcePackStack resourcePack) {
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_LEFT), 3, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_FRONT_RIGHT), 3, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CRAFTING_TABLE_TOP), 3, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_FRONT), 3, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_SIDE), 3, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.SPONGE), 4, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.GLASS), 4, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.ORE_DIAMOND), 4, 3)
                .registerSprite(tintLeavesGreen(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FANCY)), 4, 5)
                .registerSprite(tintLeavesGreen(resourcePack.getTexture(ResourcePackTexture.Block.LEAVES_FAST)), 4, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_LEFT), 4, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.DOUBLE_CHEST_BACK_RIGHT), 4, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SCISSORS), 4, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.CRAFTING_TABLE_SIDE_SAW), 4, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_BURNING), 4, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.FURNACE_TOP), 4, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_WHITE), 5, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.TORCH), 6, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_DOOR_TOP), 6, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.LADDER), 6, 4)
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
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOODEN_DOOR_BOTTOM), 7, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL_CORNER), 8, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.RAIL), 9, 1)
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

                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_RED), 5, 1)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_ORANGE), 5, 2)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_YELLOW), 5, 3)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_CHARTREUSE), 5, 4)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIME), 5, 5)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_SPRING_GREEN), 5, 6)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_CYAN), 5, 7)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_CAPRI), 5, 8)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_ULTRAMARINE), 5, 9)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_VIOLET), 5, 10)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_PURPLE), 5, 11)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_MAGENTA), 5, 12)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_ROSE), 5, 13)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_DARK_GREY), 5, 14)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_LIGHT_GREY), 5, 15)
                .registerSprite(resourcePack.getTexture(ResourcePackTexture.Block.WOOL_WHITE), 5, 16)

                .build();
    }

    @Override
    public String getMinecraftVersion() {
        return "infdev-201000618";
    }
}
