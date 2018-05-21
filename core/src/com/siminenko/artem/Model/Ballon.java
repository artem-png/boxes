package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Data.BallonData;
import com.siminenko.artem.Model.Level.ALevel;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */

public class Ballon extends AObject {
    float rotationNumber = 0.0f;
    float rotationDelta = 0.04f;

    float count = 100;

    public Ballon(World world, Vector2 position, ALevel level) {
        this.world = world;
        shape = new CircleShape();
        shape.setRadius(3f);
        this.createObject(position, shape, world, 0.0f, 0.4f, 0.5f);
        this.body.setUserData(new BallonData(this));
        this.body.setGravityScale(0);
        Tex.baloon1.setOrigin(6, 6);
        this.body.setActive(true);
        this.level = level;
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
        batch.draw(
                Tex.baloon1,
                this.body.getPosition().x - 6f,
                this.body.getPosition().y - 6f,
                Tex.baloon1.getOriginX(),
                Tex.baloon1.getOriginY(),
                12,
                12,
                Tex.baloon1.getScaleX(),
                Tex.baloon1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }

    public void rotation() {
        body.setTransform(body.getPosition(), (float) Math.sin(rotationNumber) / 3);
        rotationNumber += rotationDelta;
    }

    public void setDispose(boolean d) {
        this.body.applyLinearImpulse(new Vector2(1000, 1000), new Vector2(body.getPosition().x, body.getPosition().y), true);
        Random random = new Random();
        for (int i = 1; i < this.count; i++) {
            ObstacleCircle obstacleTriangle = new ObstacleCircle(
                    world,
                    new Vector2(body.getPosition().x, body.getPosition().y - 0.5f),
                    new Vector2(random.nextInt(60) - 30, random.nextInt(60) - 30),
                    1f,
                    1f,
                    Tex.circle2
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
