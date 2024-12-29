package com.nobunagastudios.zombies.gamelogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Player{
    private Viewport viewport;
    private Texture playerTexture;
    private Sprite playerSprite;
    private Vector2 playerPosition;
    private Vector2 mousePosition;
    private int playerSpeed;
    private float playerRotationSpeed;
    private float playerRotationAngle;
    private boolean isPlayerHit;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        playerTexture = new Texture("sprites/player.png");
        playerSprite = new Sprite(playerTexture);
        playerPosition = new Vector2((viewport.getWorldWidth() / 2), (viewport.getWorldHeight() / 2));
        mousePosition = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        playerSpeed = 300;
        playerRotationSpeed = 100f;
        playerRotationAngle = 0;
        isPlayerHit = false;
    }

    public void update(float delta){
        movement(delta);
    }

    private void movement(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)){
            if(playerPosition.x > (playerTexture.getWidth() / 2)) {
                playerPosition.x -= playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)){
            if(playerPosition.x < viewport.getWorldWidth() - (playerTexture.getWidth() / 2)) {
                playerPosition.x += playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)){
            if(playerPosition.y < viewport.getWorldHeight() - (playerTexture.getHeight() / 2)) {
                playerPosition.y += playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)){
            if(playerPosition.y > (playerTexture.getHeight() / 2)) {
                playerPosition.y -= playerSpeed * delta;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            playerRotationAngle += playerRotationSpeed * delta;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.E)){
            playerRotationAngle -= playerRotationSpeed * delta;
        }
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public boolean getIsPlayerHit() {
        return isPlayerHit;
    }

    public void setIsPlayerHit(boolean playerHit) {
        isPlayerHit = playerHit;
    }

    public Vector2 getPlayerPosition() {
        return playerPosition;
    }

    public float getPlayerRotationAngle() {
        return playerRotationAngle;
    }
}
