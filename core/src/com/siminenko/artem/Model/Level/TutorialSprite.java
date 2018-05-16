package com.siminenko.artem.Model.Level;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by artem on 4/26/18.
 */

public class TutorialSprite {
    Vector2 position;
    Vector2 maxSize;
    Vector2 size = new Vector2();
    Sprite sprite;
    int time = 170;
    public boolean isPulse;
    public boolean down = false;

    int count;
    public int expTimeSetting;
    public int expTime;

    float delta = 0.00f;
    float a = 0.00f;
    float color = 1f;

    public TutorialSprite(Sprite sprite, Vector2 position, Vector2 maxSize)
    {
        this.sprite = sprite;
        this.position = position;
        this.maxSize = maxSize;
    }

    public void act() {
        if (isPulse) {
            expTime--;
            alphaChange();
        }
        time--;
        if (time > 0) {
            size.add(maxSize.x / 20, maxSize.y / 20);
            if (size.x > maxSize.x) {
                size.x = maxSize.x;
            }
            if (size.y > maxSize.y) {
                size.y = maxSize.y;
            }
        } else if (down){
            size.add(- maxSize.x / 10, - maxSize.y / 10);
            if (size.x <= 0) {
                size.x = 0;
            }
            if (size.y <= 0) {
                size.y = 0;
            }
        }
    }

    public void alphaChange() {
        delta = 0.00f + (float)Math.pow((double)0.7f * (1f - (float)expTime / (float)expTimeSetting), 1.7f);
        a += delta;
        color = Math.abs((float)Math.cos(this.a));
    }

    public void render(SpriteBatch batch) {
        batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, color);
        batch.draw(sprite, position.x + (maxSize.x - size.x) / 2, position.y + (maxSize.y - size.y) / 2, size.x, size.y);
        batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, 1f);
    }

    public void dispose()
    {
        this.sprite.getTexture().dispose();
    }
}
