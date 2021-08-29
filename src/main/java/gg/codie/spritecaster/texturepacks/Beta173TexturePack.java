package gg.codie.spritecaster.texturepacks;

import gg.codie.spritecaster.SpriteAtlas;
import gg.codie.spritecaster.SpriteAtlasBuilder;
import gg.codie.spritecaster.resourcepacks.ResourcePack;
import gg.codie.spritecaster.resources.textures.Block;

import java.util.zip.ZipFile;

public class Beta173TexturePack implements ITexturePack {
    SpriteAtlas terrainAtlas;
    SpriteAtlas itemAtlas;

    @Override
    public ITexturePack fromResourcePack(ResourcePack resourcePack) {
        Beta173TexturePack texturePack = new Beta173TexturePack();

        texturePack.terrainAtlas = new SpriteAtlasBuilder()
                .registerSprite(resourcePack.textures.get(Block.GRASS_TOP), 1, 1)
                .registerSprite(resourcePack.textures.get(Block.STONE), 1, 2)
                .registerSprite(resourcePack.textures.get(Block.DIRT), 1, 3)
                .registerSprite(resourcePack.textures.get(Block.GRASS_SIDE), 1, 4)
                .registerSprite(resourcePack.textures.get(Block.WOODEN_PLANKS), 1, 5)
                .registerSprite(resourcePack.textures.get(Block.STONE_SLAB_SIDE), 1, 6)
                .registerSprite(resourcePack.textures.get(Block.STONE_SLAB_TOP), 1, 7)
                .registerSprite(resourcePack.textures.get(Block.BRICK), 1, 8)
                .registerSprite(resourcePack.textures.get(Block.TNT_SIDE), 1, 9)
                .registerSprite(resourcePack.textures.get(Block.TNT_TOP), 1, 10)
                .registerSprite(resourcePack.textures.get(Block.TNT_BOTTOM), 1, 11)
                .registerSprite(resourcePack.textures.get(Block.COBWEB), 1, 12)
                .registerSprite(resourcePack.textures.get(Block.RED_FLOWER), 1, 13)
                .registerSprite(resourcePack.textures.get(Block.YELLOW_FLOWER), 1, 14)
                // empty
                .registerSprite(resourcePack.textures.get(Block.SAPLING), 1, 16)

                .registerSprite(resourcePack.textures.get(Block.COBBLESTONE), 2, 1)
                .registerSprite(resourcePack.textures.get(Block.BEDROCK), 2, 2)
                .registerSprite(resourcePack.textures.get(Block.SAND), 2, 3)
                .registerSprite(resourcePack.textures.get(Block.GRAVEL), 2, 4)
                .registerSprite(resourcePack.textures.get(Block.LOG_SIDE), 2, 5)
                .registerSprite(resourcePack.textures.get(Block.LOG_TOP), 2, 6)
                .registerSprite(resourcePack.textures.get(Block.BLOCK_OF_IRON), 2, 7)
                .registerSprite(resourcePack.textures.get(Block.BLOCK_OF_GOLD), 2, 8)
                .registerSprite(resourcePack.textures.get(Block.BLOCK_OF_DIAMOND), 2, 9)
                .registerSprite(resourcePack.textures.get(Block.CHEST_TOP), 2, 10)
                .registerSprite(resourcePack.textures.get(Block.CHEST_SIDE), 2, 11)
                .registerSprite(resourcePack.textures.get(Block.CHEST_FRONT), 2, 12)
                .registerSprite(resourcePack.textures.get(Block.RED_MUSHROOM), 2, 13)
                .registerSprite(resourcePack.textures.get(Block.BROWN_MUSHROOM), 2, 14)
                // empty (unused but sometimes is dark blue)
                // empty

                .registerSprite(resourcePack.textures.get(Block.ORE_GOLD), 3, 1)
                .registerSprite(resourcePack.textures.get(Block.ORE_IRON), 3, 2)
                .registerSprite(resourcePack.textures.get(Block.ORE_COAL), 3, 3)
                .registerSprite(resourcePack.textures.get(Block.BOOKSHELF), 3, 4)
                .registerSprite(resourcePack.textures.get(Block.MOSSY_COBBLESTONE), 3, 5)
                .registerSprite(resourcePack.textures.get(Block.OBSIDIAN), 3, 6)
                .registerSprite(resourcePack.textures.get(Block.GRASS_SIDE_OVERLAY), 3, 7)
                .registerSprite(resourcePack.textures.get(Block.TALL_GRASS), 3, 8)
                // empty (unused but sometimes contains a grass texture.)
                .registerSprite(resourcePack.textures.get(Block.DOUBLE_CHEST_FRONT_LEFT), 3, 10)
                .registerSprite(resourcePack.textures.get(Block.DOUBLE_CHEST_FRONT_RIGHT), 3, 11)
                .registerSprite(resourcePack.textures.get(Block.CRAFTING_TABLE_TOP), 3, 12)
                .registerSprite(resourcePack.textures.get(Block.FURNACE_FRONT), 3, 13)
                .registerSprite(resourcePack.textures.get(Block.FURNACE_SIDE), 3, 14)
                .registerSprite(resourcePack.textures.get(Block.DISPENSER_FRONT), 3, 15)
                // empty

                .registerSprite(resourcePack.textures.get(Block.SPONGE), 4, 1)
                .registerSprite(resourcePack.textures.get(Block.GLASS), 4, 2)
                .registerSprite(resourcePack.textures.get(Block.ORE_DIAMOND), 4, 3)
                .registerSprite(resourcePack.textures.get(Block.ORE_REDSTONE), 4, 4)
                .registerSprite(resourcePack.textures.get(Block.LEAVES_FANCY), 4, 5)
                .registerSprite(resourcePack.textures.get(Block.LEAVES_FAST), 4, 6)
                // empty
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )
//                .registerSprite(resourcePack.textures.get(Block.), 4, )

//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
//                .registerSprite(resourcePack.textures.get(Block.), , )
                .build();

        return this;
    }

    @Override
    public ZipFile save() {
        return null;
    }
}
