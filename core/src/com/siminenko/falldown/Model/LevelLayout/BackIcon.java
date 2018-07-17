package com.siminenko.falldown.Model.LevelLayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.falldown.Layout.MenuLayout;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class BackIcon {
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    Vector2 size = new Vector2(6, 6);
    Vector2 position = new Vector2(1, MyGdxGame.height - 1 - size.y);
    static Sprite button;

    public static void init() {
        button = new Sprite(new Texture("menu/backIcon.png"));
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 0) {
                MyGdxGame.layoutManager.set(new MenuLayout());
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x && vector3.x < position.x + size.x) {
                    if (vector3.y > position.y - size.y && vector3.y < position.y + size.y) {
                        isPressed = true;
                        MyGdxGame.setUp(20, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.button, position.x, position.y, size.x, size.y);
    }

    public void dispose() {

    }
}
