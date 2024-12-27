package com.nobunagastudios.zombies;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nobunagastudios.zombies.assethandler.AssetHandler;
import com.nobunagastudios.zombies.screens.MainMenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameApplication extends Game {
    public SpriteBatch spriteBatch;
    public AssetHandler assetHandler;

    @Override
    public void create() {
        assetHandler = new AssetHandler();
        assetHandler.loadAllAssets();
        assetHandler.getAssetManager().finishLoading();

        spriteBatch = new SpriteBatch();

        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
