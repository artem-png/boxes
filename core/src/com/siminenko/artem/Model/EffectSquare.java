package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 5/18/18.
 */

public class EffectSquare extends AEffect{
    public EffectSquare(Vector2 position, Vector2 size, Vector2 speed, Color color, float alpha, float rotation, int time)
    {
        this.position = position;
        this.size = size;
        this.velocity = speed;
        this.color = color;
        this.alpha = alpha;
        this.rotationSetting = rotation;
        this.time = time;
        this.settingTime = time;
        this.sprite = Tex.rectangle1;
    }

    public void act() {
        super.act();
        if (settingTime / 3 > time) {
            alpha -= 0.03;
            if (alpha <= 0) {
                alpha = 0;
            }
        }
    }
}