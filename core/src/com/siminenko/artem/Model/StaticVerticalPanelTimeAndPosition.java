package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;

/**
 * Created by artem on 4/19/18.
 */
public class StaticVerticalPanelTimeAndPosition extends AObject {
    float sizeX;
    float sizeY;

    int time;

    Vector2 finalPosition;

    public StaticVerticalPanelTimeAndPosition(
            World world,
            Vector2 position,
            Vector2 finalPosition,
            Vector2 speed,
            float initRotation,
            float rotation,
            int sizeX,
            int sizeY,
            float restitution,
            int time
    ) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        shape.setAsBox(sizeX/2, sizeY/2);
        this.finalPosition = finalPosition;
        this.time = time;

        this.shape = shape;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(position.x, position.y);
        body = world.createBody(bodyDef);
        body.setTransform(position.x, position.y, initRotation);
        setShapeToFixture(shape, 1, 1, restitution);
        this.body.setLinearVelocity(speed);
        this.body.setTransform(this.body.getPosition().x, this.body.getPosition().y, initRotation);
        this.body.setAngularVelocity(rotation);
        this.body.setUserData(this);
        isKinematic = true;
        isNeedParticles = false;
    }

    @Override
    public void act() {
        super.act();
        time --;
        if (time < 0) {
            this.setDispose(true);
        }
        if (time < 30) {
            this.body.setTransform(this.body.getPosition().x - this.body.getLinearVelocity().x, this.body.getPosition().y - this.body.getLinearVelocity().y, this.body.getAngle());
        } else {
            if (this.body.getPosition().x != this.finalPosition.x) {
                Vector2 newPosition = new Vector2(this.body.getPosition());
                newPosition.x += this.body.getLinearVelocity().x;
                if (this.body.getLinearVelocity().x > 0) {
                    if (newPosition.x > this.finalPosition.x) {
                        newPosition.x = finalPosition.x;
                    }
                } else {
                    if (newPosition.x < this.finalPosition.x) {
                        newPosition.x = finalPosition.x;
                    }
                }
                this.body.setTransform(newPosition, this.body.getAngle());
            }
            if (this.body.getPosition().y != this.finalPosition.y) {
                Vector2 newPosition = new Vector2(this.body.getPosition());
                newPosition.y += this.body.getLinearVelocity().y;
                if (this.body.getLinearVelocity().y > 0) {
                    if (newPosition.y > this.finalPosition.y) {
                        newPosition.y = finalPosition.y;
                    }
                } else {
                    if (newPosition.y < this.finalPosition.y) {
                        newPosition.y = finalPosition.y;
                    }
                }
                this.body.setTransform(newPosition, this.body.getAngle());
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                Tex.rectangleGrey,
                this.body.getPosition().x - sizeX/2f,
                this.body.getPosition().y - sizeY/2f,
                sizeX / 2,
                sizeY / 2,
                sizeX,
                sizeY,
                Tex.rectangleGrey.getScaleX(),
                Tex.rectangleGrey.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
