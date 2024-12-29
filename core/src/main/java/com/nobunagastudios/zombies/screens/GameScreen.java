package com.nobunagastudios.zombies.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nobunagastudios.zombies.GameApplication;
import com.nobunagastudios.zombies.gamelogic.Player;

public class GameScreen implements Screen {
    private GameApplication game;
    private Viewport viewport;
    private Player player;
    private Texture backgroundTexture;
    private Sprite playerSprite;
    private Vector2 playerPosition;

    public GameScreen(GameApplication game) {
        this.game = game;
    }

    @Override
    public void show() {
        backgroundTexture = new Texture("sprites/background.png");
        viewport = new FitViewport(backgroundTexture.getWidth(), backgroundTexture.getHeight());
        player = new Player(viewport);
        playerPosition = player.getPlayerPosition();
        playerSprite = player.getPlayerSprite();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();

        player.update(delta);
        playerSprite.setPosition(playerPosition.x - (playerSprite.getWidth() / 2), playerPosition.y - (playerSprite.getHeight() / 2));
        playerSprite.setRotation(player.getPlayerRotationAngle());

        game.spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        game.spriteBatch.begin();

        game.spriteBatch.draw(backgroundTexture, 0, 0);
        playerSprite.draw(game.spriteBatch);

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
        backgroundTexture.dispose();
    }
}
