package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Data.BallonData;

/**
 * Created by artem on 4/19/18.
 */

public class Ballon extends AObject {
    float rotationNumber = 0.0f;
    float rotationDelta = 0.04f;

    public Ballon(World world, Vector2 position) {
        this.world = world;
        shape = new CircleShape();
        shape.setRadius(3f);
        this.createObject(position, shape, world, 0.0f, 0.4f, 0.5f);
        this.body.setUserData(new BallonData(this));
        this.body.setGravityScale(0);
        Tex.baloon1.setOrigin(6, 6);
        this.body.setActive(true);
    }

    public void act() {
        if (isAway() || this.body.getLinearVelocity().y < 0 || this.body.getLinearVelocity().y > 0) {
            this.setDispose(true);
        }
        rotation();
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
        this.isDisposed = d;
        if (this.isDisposed) {
            GameLayout.isDispose = true;
        }
    }
}
