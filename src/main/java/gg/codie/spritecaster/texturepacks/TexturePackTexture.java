package gg.codie.spritecaster.texturepacks;

public enum TexturePackTexture {
    TERRAIN("terrain.png");

    private String path;
    TexturePackTexture(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
