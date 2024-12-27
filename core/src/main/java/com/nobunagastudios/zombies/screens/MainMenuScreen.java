package com.nobunagastudios.zombies.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nobunagastudios.zombies.GameApplication;
import com.nobunagastudios.zombies.assethandler.AssetHandler;

/** Main Menu screen of the application. Displayed after the application is created. */
public class MainMenuScreen implements Screen {
    private GameApplication game;
    private Viewport viewport;
    private Stage stage;
    private Table table;
    private AssetManager assetManager;
    private Skin skin;
    public MainMenuScreen(GameApplication game) {
        this.game = game;
        assetManager = game.assetHandler.getAssetManager();
        skin = assetManager.get(AssetHandler.SKIN);
    }

    @Override
    public void show() {
        // Prepare your screen here.
        viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage(viewport, game.spriteBatch);
        table = new Table();
        table.setFillParent(true);

        stage.addActor(table);
        addMainMenuButton("Play");
        addMainMenuButton("Settings");
        addMainMenuButton("Quit");
    }

    private TextButton addMainMenuButton(String buttonName){
        TextButton button = new TextButton(buttonName, skin);
        table.add(button).width(150).height(50).padBottom(20);
        table.row();
        return button;
    }

    @Override
    public void render(float delta) {
        // Draw your screen here. "delta" is the time since last render in seconds.
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        stage.act();
        stage.draw();

        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        game.spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
        viewport.update(width, height);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        game.spriteBatch.dispose();
    }
}
