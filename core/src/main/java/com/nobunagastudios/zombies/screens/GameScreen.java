package com.nobunagastudios.zombies.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nobunagastudios.zombies.GameApplication;
import com.nobunagastudios.zombies.gamelogic.Player;

public class GameScreen implements Screen {
    private GameApplication game;
    private Viewport viewport;
    private OrthographicCamera camera;
    private Player player;
    private Texture backgroundSprite;
    private  Texture playerSprite;
    private Vector2 playerPosition;

    public GameScreen(GameApplication game) {
        this.game = game;
    }

    @Override
    public void show() {
        backgroundSprite = new Texture("sprites/background.png");
        viewport = new FitViewport(backgroundSprite.getWidth(), backgroundSprite.getHeight());
        camera = new OrthographicCamera(viewport.getWorldWidth(), viewport.getWorldHeight());
        player = new Player(viewport);
        playerPosition = player.getPlayerPosition();
        playerSprite = player.getPlayerSprite();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();

        player.update(delta);

        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        game.spriteBatch.draw(backgroundSprite, 0, 0);
        game.spriteBatch.draw(playerSprite, playerPosition.x - (playerSprite.getWidth() / 2), playerPosition.y - (playerSprite.getHeight() / 2));

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
        backgroundSprite.dispose();
    }
}
