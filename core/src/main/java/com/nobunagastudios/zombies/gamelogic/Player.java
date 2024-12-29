package com.nobunagastudios.zombies.gamelogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player{
    private Viewport viewport;
    private Texture playerSprite;
    private Vector2 playerPosition;
    private int playerSpeed;
    private boolean isPlayerHit;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        playerSprite = new Texture("sprites/player.png");
        playerPosition = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        playerSpeed = 300;
        isPlayerHit = false;
    }

    public void update(float delta){
        movement(delta);
    }

    private void movement(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            if(playerPosition.x > (playerSprite.getWidth() / 2)) {
                playerPosition.x -= playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            if(playerPosition.x < viewport.getWorldWidth() - (playerSprite.getWidth() / 2)) {
                playerPosition.x += playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            if(playerPosition.y < viewport.getWorldHeight() - (playerSprite.getHeight() / 2)) {
                playerPosition.y += playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            if(playerPosition.y > (playerSprite.getHeight() / 2)) {
                playerPosition.y -= playerSpeed * delta;
            }
        }
    }

    public Texture getPlayerSprite() {
        return playerSprite;
    }

    public Vector2 getPlayerPosition() {
        return playerPosition;
    }
}
