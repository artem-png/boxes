package com.lisuart.falldown.Model.Menu.PlayButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Layout.CustomizeLayout;

/**
 * Created by User on 21.04.2018.
 */

public class CustomizeButton {
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

    Vector2 position = new Vector2(5.6f, com.lisuart.falldown.MyGdxGame.height / 2 - 3.7f - size.y / 2 - 5);

    public CustomizeButton() {
        button = com.lisuart.falldown.Config.Tex.button;
        buttonPressed = com.lisuart.falldown.Config.Tex.buttonPressed;
        icon = new Sprite(new Texture("customize.png"));
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                com.lisuart.falldown.MyGdxGame.layoutManager.push(new CustomizeLayout());
                isPressed = false;
                timePressed = timeSetting;
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x/2 && vector3.x < position.x + size.x/2) {
                    if (vector3.y > position.y - size.y/2 && vector3.y < position.y + size.y/2) {
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
                position.x - size.x/2,
                position.y - size.y/2,
                size.x,
                size.y
        );
        batch.draw(icon, position.x - size.x/2 + 1, position.y - size.y/2 + 1, size.x - 2f, size.y - 2f);
        batch.end();
        batch.begin();
    }

    public boolean isReady() {
        return isReady;
    }

    public void dispose() {
        icon.getTexture().dispose();
    }
}
