package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Data.ObstaclePanelData;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleVerticalPanel extends AObject {
    float sizeX = 3;
    float sizeY = 12;

    public ObstacleVerticalPanel(World world, Vector2 position, float sizeX, float sizeY, float mass) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        if (sizeX != 0) {
            shape.setAsBox(sizeX/2, sizeY/2);
        } else {
            shape.setAsBox(this.sizeX/2, this.sizeY/2);
        }
        this.shape = shape;
        this.createObject(position, shape, world, mass, 1f, 0);
        this.body.setLinearVelocity(0, 0);
        this.body.setUserData(this);
    }

    public ObstacleVerticalPanel(World world, Vector2 position, Vector2 speed, float initRotation, float rotation, int sizeX, int sizeY, float mass) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        if (sizeX != 0) {
            shape.setAsBox(sizeX/2, sizeY/2);
        } else {
            shape.setAsBox(this.sizeX/2, this.sizeY/2);
        }
        this.shape = shape;
        this.createObject(position, shape, world, mass, 1f, 0);
        this.body.setLinearVelocity(speed);
        this.body.setTransform(this.body.getPosition().x, this.body.getPosition().y, initRotation);
        this.body.setAngularVelocity(rotation);
        this.body.setUserData(this);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                Tex.rectangle1,
                this.body.getPosition().x - sizeX/2f,
                this.body.getPosition().y - sizeY/2f,
                sizeX / 2,
                sizeY / 2,
                sizeX,
                sizeY,
                Tex.rectangle1.getScaleX(),
                Tex.rectangle1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
