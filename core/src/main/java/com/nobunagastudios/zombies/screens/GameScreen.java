package com.nobunagastudios.zombies.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nobunagastudios.zombies.GameApplication;

public class GameScreen implements Screen {
    private GameApplication game;
    private Viewport viewport;
    OrthographicCamera camera;
    private Texture background;

    public GameScreen(GameApplication game) {
        this.game = game;
    }

    @Override
    public void show() {
        background = new Texture("sprites/background.png");
        viewport = new FitViewport(background.getWidth(), background.getHeight());
        camera = new OrthographicCamera(viewport.getWorldWidth(), viewport.getWorldHeight());
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();

        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        game.spriteBatch.draw(background, 0, 0);

        game.spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.spriteBatch.dispose();
        background.dispose();
    }
}
