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

    public TutorialSprite(Sprite sprite, Vector2 position, Vector2 maxSize)
    {
        this.sprite = sprite;
        this.position = position;
        this.maxSize = maxSize;
    }

    public void act() {
        size.add(maxSize.x/20, maxSize.y/20);
        if (size.x > maxSize.x) {
            size.x = maxSize.x;
        }
        if (size.y > maxSize.y) {
            size.y = maxSize.y;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(sprite, position.x + (maxSize.x - size.x) / 2, position.y + (maxSize.y - size.y) / 2, size.x, size.y);
    }
}
