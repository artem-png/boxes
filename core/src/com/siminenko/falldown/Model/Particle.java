package com.siminenko.falldown.Model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 5/16/18.
 */

public class Particle {
    Sprite sprite;
    Vector2 position;
    float alpha;
    float rotation;
    float rotationSpeed;
    Vector2 speed;
    Vector2 size;

    int duration;

    Color color;

    int appearTime = 40;

    public Particle(Sprite sprite) {
        Random random = new Random();
        this.sprite = sprite;
        float sizeF = (random.nextInt(10) + 4) / 10f;
        size = new Vector2(sizeF, sizeF);
        position = new Vector2(random.nextInt(MyGdxGame.width), random.nextInt(MyGdxGame.height));
        alpha = 0.0f;
        rotation = 0;
        rotationSpeed = random.nextInt(100) / 50f;
        speed = new Vector2(random.nextFloat() / 8f * negativeOrPositive(), random.nextFloat() / 8f * negativeOrPositive());
        duration = 170 + random.nextInt(100);
        color = new Color();
        color.set(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1);
    }

    public void act() {
        duration--;
        position.add(speed.x, speed.y);
        rotation += rotationSpeed;

        if (appearTime > 0) {
            appearTime--;
            alpha += 0.003;
        }

        if (duration < 20) {
            alpha -= 0.006;
            if (alpha <= 0) {
                alpha = 0;
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.setColor(color.r, color.g, color.b, alpha);
        batch.draw(this.sprite, position.x, position.y, size.x / 2, size.y / 2, size.x, size.y, sprite.getScaleX(), sprite.getScaleY(), rotation);
        batch.setColor(1, 1, 1, 1);
    }

    public boolean isDead() {
        if (position.x > MyGdxGame.width + 5 || position.x < -5 || position.y > MyGdxGame.height + 5 || position.y < -5) {
            return true;
        }
        return duration < 0;
    }

    public int negativeOrPositive() {
        Random random = new Random();
        int result = random.nextInt(2);
        if (result == 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
