package com.siminenko.artem.Model.Lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Layout.MenuLayout;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class MenuIcon {
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    Vector2 size = new Vector2(7, 7);
    Vector2 position = new Vector2(1, MyGdxGame.height - 1 - size.y);
    Sprite button;
    Sprite icon;
    Sprite whitebg;

    public MenuIcon() {
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
        button = new Sprite(new Texture("menu/buttonCircle.png"));
        icon = new Sprite(new Texture("menu/menuList.png"));
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                MyGdxGame.layoutManager.set(new MenuLayout());
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x && vector3.x < position.x + size.x) {
                    if (vector3.y > position.y - size.y && vector3.y < position.y + size.y) {
                        isPressed = true;
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.button, position.x, position.y, size.x, size.y);
        batch.draw(this.icon, position.x + 1, position.y + 1, size.x - 2, size.y -2);

        if (isPressed) {
            Color c = batch.getColor();
            batch.setColor(c.r, c.g, c.b, 1f - (float) timePressed / (float) timeSetting);
            batch.draw(this.whitebg, 0, 0, MyGdxGame.width, MyGdxGame.height);
            batch.setColor(c.r, c.g, c.b, 1);
        }
    }

    public void dispose() {
        whitebg.getTexture().dispose();
        button.getTexture().dispose();
        icon.getTexture().dispose();
    }
}
