package gg.codie.spritecaster.texturepacks;

public enum TexturePackFile {
    PACK_FILE("pack.txt"),
    WATER_STILL_MCMETA("custom_water_still.mcmeta"),
    WATER_FLOWING_MCMETA("custom_water_flowing.mcmeta"),
    LAVA_STILL_MCMETA("custom_lava_still.mcmeta"),
    LAVA_FLOWING_MCMETA("custom_lava_flowing.mcmeta"),
    FIRE_0("custom_fire_n_s.mcmeta"),
    FIRE_1("custom_fire_e_w.mcmeta"),
    PORTAL_MCMETA("custom_portal.mcmeta"),
    GEAR_CLOCKWISE_MCMETA("custom_gear_clockwise.mcmeta"),
    GEAR_COUNTER_CLOCKWISE_MCMETA("custom_gear_counter_clockwise.mcmeta"),
    SPRITECASTER_INFO("spritecaster.txt");

    private String path;
    TexturePackFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
