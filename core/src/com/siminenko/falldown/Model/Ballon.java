package com.siminenko.falldown.Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Layout.GameLayout;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.Model.Music.Music;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */

public class Ballon extends AObject {
    float rotationNumber = 0.0f;
    float rotationDelta = 0.04f;

    float count = 30;

    Sprite sprite;

    public Ballon(World world, Vector2 position, ALevel level) {
        this.world = world;
        shape = new CircleShape();
        shape.setRadius(3f);
        this.createObject(position, shape, world, 0.0f, 0.4f, 0.5f);
        this.body.setUserData(new com.siminenko.falldown.Model.Data.BallonData(this));
        this.body.setGravityScale(0);
        Tex.baloon1.setOrigin(6, 6);
        this.body.setActive(true);
        this.level = level;

        if (com.siminenko.falldown.Config.Progress.theme == 0) {
            sprite = Tex.baloon1;
        } else if (com.siminenko.falldown.Config.Progress.theme == 1) {
            sprite = Tex.baloon2;
        } else if (com.siminenko.falldown.Config.Progress.theme == 2) {
            sprite = Tex.baloon3;
        }
    }

    public void act() {
        if (!isDisposed && (isAway() || this.body.getLinearVelocity().y < 0 || this.body.getLinearVelocity().y > 0)) {
            this.setDispose(true);
        }
        rotation();
        if (GameLayout.isWin) {
            Tex.createParticles(5, 1f, this.body.getPosition());
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!this.body.isActive()) {
            batch.setColor(1, 1, 1, 0.5f);
        }
        if (com.siminenko.falldown.Config.Progress.theme == 0) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x - 6f,
                    this.body.getPosition().y - 6f,
                    6,
                    6,
                    12,
                    12,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        } else if (com.siminenko.falldown.Config.Progress.theme == 1) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x - 3.5f,
                    this.body.getPosition().y - 8f,
                    3.5f,
                    6,
                    7,
                    12,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        } else if (com.siminenko.falldown.Config.Progress.theme == 2) {
            batch.draw(
                    sprite,
                    this.body.getPosition().x - 4f,
                    this.body.getPosition().y - 4.5f,
                    4f,
                    5,
                    8,
                    10,
                    sprite.getScaleX(),
                    sprite.getScaleY(),
                    (float) Math.toDegrees(this.body.getAngle())
            );
        }
        if (!this.body.isActive()) {
            batch.setColor(1, 1, 1, 1);
        }
    }

    public void rotation() {
        body.setTransform(body.getPosition(), (float) Math.sin(rotationNumber) / 3);
        rotationNumber += rotationDelta;
    }

    public void setDispose(boolean d) {
        Music.lost();
        this.body.applyLinearImpulse(new Vector2(1000, 1000), new Vector2(body.getPosition().x, body.getPosition().y), true);
        Random random = new Random();
        for (int i = 1; i < this.count; i++) {
            ObstacleCircle obstacleTriangle = new ObstacleCircle(
                    world,
                    new Vector2(body.getPosition().x, body.getPosition().y - 0.5f),
                    new Vector2(random.nextInt(60) - 30, random.nextInt(60) - 30),
                    1.5f,
                    0.5f,
                    Tex.circle2,
                    true
            );
            obstacleTriangle.isNeedParticles = false;
            obstacleTriangle.body.setActive(true);

            this.level.aObjectVector2.add(obstacleTriangle);
        }
        this.body.setActive(false);
        this.body.setTransform(-100, -300, 0);
        this.isDisposed = d;
        if (this.isDisposed) {
            GameLayout.isDispose = true;
        }
    }
}
