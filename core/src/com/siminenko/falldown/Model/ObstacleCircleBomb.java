package com.siminenko.falldown.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Layout.GameLayout;
import com.siminenko.falldown.Model.Music.Music;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleCircleBomb extends AObject {
    float size;
    Vector2 origin;

    float setting = 40;
    float settingNow = setting;
    float delta = 0.00f;
    float a = 0.00f;
    float color = 1f;

    int count;
    int expTimeSetting;
    float expTime;

    boolean isExplosionComplete = false;

    public ObstacleCircleBomb(World world, Vector2 position, Vector2 velocity, float size, float mass, int count, int expTime) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, mass, 1f, 0.0f);
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size / 2, size / 2);
        this.count = count;
        this.expTime = expTime;
        this.expTimeSetting = expTime;
        this.body.setUserData(this);
    }

    @Override
    public void act() {
        super.act();
        alphaChange();
        explosionTime();
    }

    public void explosionTime() {
        expTime -= 1 * ((float)GameLayout.speedSetting / (float)GameLayout.speed);
        if (expTime <= 0 && !isExplosionComplete) {
            isExplosionComplete = true;
            this.body.setLinearVelocity(0, 0);
            this.body.applyLinearImpulse(new Vector2(1000, 1000), new Vector2(body.getPosition().x, body.getPosition().y), true);
            Random random = new Random();
            for (int i = 1; i < this.count; i++) {
                int xSpeed = random.nextInt(80) - 40;
                int ySpeed = random.nextInt(100) - 50;
                int rotation = random.nextInt(30);
                com.siminenko.falldown.Model.ObstacleTriangle obstacleTriangle = new com.siminenko.falldown.Model.ObstacleTriangle(
                        world,
                        body.getPosition(),
                        2,
                        new Vector2(xSpeed, ySpeed),
                        rotation,
                        rotation,
                        0.2f
                );
                obstacleTriangle.isNeedParticles = false;
                obstacleTriangle.body.setActive(true);
                this.level.aObjectVector2.add(obstacleTriangle);
            }

            Tex.createParticles((int)(count * 1.5f), 1, body.getPosition());
            this.body.setActive(false);
            this.body.setTransform(-100, -300, 0);
            Music.boom();
        }
    }

    public void alphaChange() {
        delta = 0.00f + (float)Math.pow((double)0.7f * (1f - (float)expTime / (float)expTimeSetting), 1.7f);
        a += delta;
        color = Math.abs((float)Math.cos(this.a));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, color);
        batch.draw(
                Tex.circle1,
                this.body.getPosition().x - size / 2,
                this.body.getPosition().y - size / 2,
                origin.x,
                origin.y,
                size,
                size,
                Tex.circle1.getScaleX(),
                Tex.circle1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
        batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, 1f);
    }
}
