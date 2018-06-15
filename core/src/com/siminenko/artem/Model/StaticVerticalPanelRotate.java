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
public class StaticVerticalPanelRotate extends AObject {
    float sizeX = 3;
    float sizeY = 12;

    int pauseSetting;
    int pause;

    float rotationSpeed;
    float initRotation;
    float finishRotation;

    boolean isMoving = true;
    int time = 10;

    public StaticVerticalPanelRotate(
            World world,
            Vector2 position,
            Vector2 speed,
            float initRotation,
            float finishRotation,
            float rotationSpeed,
            int pause,
            int sizeX,
            int sizeY,
            float restitution
    ) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Vector2[] vector2 = new Vector2[4];
        vector2[0] = new Vector2(- sizeX / 2, sizeY);
        vector2[1] = new Vector2(sizeX / 2, sizeY);
        vector2[2] = new Vector2(sizeX / 2, 0);
        vector2[3] = new Vector2(-sizeX / 2, 0);
        shape.set(vector2);

        this.pauseSetting = pause;
        this.pause = pause;
        this.rotationSpeed = rotationSpeed;
        this.initRotation = initRotation;
        this.finishRotation = finishRotation;

        this.shape = shape;
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(position.x, position.y);
        body = world.createBody(bodyDef);
        body.setTransform(position.x, position.y, initRotation);
        setShapeToFixture(shape, 1, 1, restitution);
        this.body.setLinearVelocity(speed);
        this.body.setTransform(this.body.getPosition().x, this.body.getPosition().y, initRotation);
        this.body.setUserData(this);
        isKinematic = true;
        isNeedParticles = false;
    }

    @Override
    public void act() {
        super.act();
        float a = (float)Math.toDegrees(this.body.getAngle()) % 360;
        if (isMoving) {
            this.body.setAngularVelocity(rotationSpeed);
            time--;
//            System.out.println("a " + Math.abs(a));
//            System.out.println("b " + (Math.abs(Math.toDegrees(this.finishRotation)) - 10));
//            System.out.println("c " + (Math.abs(Math.toDegrees(this.finishRotation)) + 10));
            if (time < 0 && Math.abs(a) > Math.abs(Math.toDegrees(this.finishRotation)) - 6 && Math.abs(a) < Math.abs(Math.toDegrees(this.finishRotation)) + 6) {
                isMoving = false;
                time = 10;
                if (rotationSpeed < 0) {
                    this.body.setTransform(this.body.getPosition(), -this.finishRotation);
                    this.body.setAngularVelocity(0);
                } else {
                    this.body.setTransform(this.body.getPosition(), this.finishRotation);
                    this.body.setAngularVelocity(0);
                }
            }
        } else {
            this.body.setAngularVelocity(0);
            pause--;
            if (pause < 0) {
                isMoving = true;
                pause = pauseSetting;
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                Tex.rectangleGrey,
                this.body.getPosition().x - sizeX / 2,
                this.body.getPosition().y ,
                sizeX/2,
                0,
                sizeX,
                sizeY,
                Tex.rectangleGrey.getScaleX(),
                Tex.rectangleGrey.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
