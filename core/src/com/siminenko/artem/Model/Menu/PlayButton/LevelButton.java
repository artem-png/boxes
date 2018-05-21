package com.siminenko.artem.Model.Menu.PlayButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.LevelsLayout;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 21.04.2018.
 */

public class LevelButton {
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    Sprite button;
    Sprite buttonPressed;
    Sprite icon;
    Vector2 size = new Vector2(6.5f, 6.5f);
    float xd;
    float yd;

    Vector2 position = new Vector2(38.4f, MyGdxGame.height / 2 - 3.7f - size.y / 2 - 5);

    public LevelButton() {
        button = new Sprite(new Texture("menu/circleOrangeLight.png"));
        buttonPressed = new Sprite(new Texture("menu/circleOrangeDark.png"));
        icon = new Sprite(new Texture("menu/levels.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                MyGdxGame.layoutManager.set(new LevelsLayout());
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x/2 && vector3.x < position.x + size.x/2) {
                    if (vector3.y > position.y - size.y/2 && vector3.y < position.y + size.y/2) {
                        isPressed = true;
                        MyGdxGame.setUp(20, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                !isPressed ? button : buttonPressed,
                position.x - size.x/2,
                position.y - size.y/2,
                size.x,
                size.y
        );
        batch.draw(icon, position.x - 3.25f, position.y - 3.25f, size.x, size.y);
        batch.end();
        batch.begin();
    }

    public boolean isReady() {
        return isReady;
    }

    public void dispose() {
        button.getTexture().dispose();
        buttonPressed.getTexture().dispose();
        icon.getTexture().dispose();
    }
}
