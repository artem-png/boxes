package com.lisuart.falldown.Model.Pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Model.Music.Music;

/**
 * Created by User on 21.04.2018.
 */

public class ContinueButton {
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    static Sprite button;
    static Sprite buttonPressed;
    Vector2 size;
    static BitmapFont font;

    static float xd;
    static float yd;

    public ContinueButton() {
        size = new Vector2(22, 6.5f);
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
        font = com.lisuart.falldown.Config.Tex.smallFont28;
        if (button == null) {
            button = new Sprite(new Texture("menu/playButton.png"));
        }

        if (buttonPressed == null) {
            buttonPressed = new Sprite(new Texture("menu/playButtonPressed.png"));
        }
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                Music.musicGame();
                com.lisuart.falldown.MyGdxGame.layoutManager.pop();
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > com.lisuart.falldown.MyGdxGame.width / 2 - size.x / 2 && vector3.x < com.lisuart.falldown.MyGdxGame.width / 2 + size.x / 2) {
                    if (vector3.y > com.lisuart.falldown.MyGdxGame.height / 2 - 10 - size.y / 2 && vector3.y < com.lisuart.falldown.MyGdxGame.height / 2 - 7 + size.y / 2) {
                        isPressed = true;
                        com.lisuart.falldown.MyGdxGame.setUp(20, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                !isPressed ? button : buttonPressed,
                com.lisuart.falldown.MyGdxGame.width / 2 - size.x / 2,
                com.lisuart.falldown.MyGdxGame.height / 2 - 7 - size.y / 2 - 4,
                size.x,
                size.y
        );
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        font.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "CONTINUE",
                com.lisuart.falldown.Config.Tex.x * 330,
                com.lisuart.falldown.Config.Tex.y * 179
        );
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public boolean isReady() {
        return isReady;
    }

    public void dispose() {

    }
}
