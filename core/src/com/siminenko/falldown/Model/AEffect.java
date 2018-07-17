package com.siminenko.falldown.Model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by artem on 5/18/18.
 */

public abstract class AEffect {
    Vector2 position = new Vector2();
    Vector2 velocity = new Vector2();
    Vector2 size = new Vector2();
    float rotationSetting = 0;
    float currentRotation = 0;
    Sprite sprite;
    public boolean isDisposed = false;
    int settingTime = 0;
    int time = 0;
    Color color;
    float alpha;

    public void render(SpriteBatch batch) {
        batch.setColor(color.r, color.g, color.b, alpha);
        batch.draw(
                sprite,
                position.x,
                position.y,
                size.x / 2,
                size.y / 2,
                size.x,
                size.y,
                sprite.getScaleX(),
                sprite.getScaleY(),
                currentRotation
        );
        batch.setColor(1, 1, 1, 1);
    }

    public void dispose() {

    }

    public void act() {
        position.add(velocity.x, velocity.y);
        currentRotation += rotationSetting;
        time--;
        if (time < 0) {
            isDisposed = true;
        }
    }


}
