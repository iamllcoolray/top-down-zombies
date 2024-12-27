package com.nobunagastudios.zombies.assethandler;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetHandler {
    private AssetManager assetManager;

    public static final AssetDescriptor<Skin> SKIN = new AssetDescriptor<>("ui/uiskin.json", Skin.class, new SkinLoader.SkinParameter("ui/uiskin.atlas"));

    public AssetHandler() {
        assetManager = new AssetManager();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void loadAllAssets(){
        assetManager.load(SKIN);
    }
}
