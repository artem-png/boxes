package com.lisuart.falldown.Model.Lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by User on 22.04.2018.
 */

public class MenuIcon {
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    Vector2 size = new Vector2(6, 6);
    Vector2 position = new Vector2(2, com.lisuart.falldown.MyGdxGame.height - 2 - size.y);
    static Sprite button;

    public boolean disposeAll = false;

    public static void init() {
        button = new Sprite(new Texture("menu/buttonHome.png"));
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 0) {
                if (disposeAll) {
                    com.lisuart.falldown.MyGdxGame.layoutManager.pop();
                }
                com.lisuart.falldown.MyGdxGame.layoutManager.set(new com.lisuart.falldown.Layout.MenuLayout());
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x && vector3.x < position.x + size.x) {
                    if (vector3.y > position.y - size.y && vector3.y < position.y + size.y) {
                        isPressed = true;
                        com.lisuart.falldown.MyGdxGame.setUp(20, true);
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
