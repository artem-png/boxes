package com.lisuart.falldown.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by artem on 4/19/18.
 */
public class ObstaclePanel extends AObject {
    float sizeX = 15;
    float sizeY = 3;

    public ObstaclePanel(World world, Vector2 position, Vector2 speed, float rotation, int x, int y) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        if (x != 0) {
            sizeX = x;
            sizeY = y;
        }
        shape.setAsBox(sizeX/2, sizeY/2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.7f, 1f, 0);
        this.body.setLinearVelocity(speed);
        this.body.setAngularVelocity(rotation);
        this.body.setUserData(this);
    }

    public ObstaclePanel(World world, Vector2 position, Vector2 speed, float initRotation, float rotation, int x, int y) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        if (x != 0) {
            sizeX = x;
            sizeY = y;
        }
        shape.setAsBox(sizeX/2, sizeY/2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.7f, 1f, 0);
        this.body.setLinearVelocity(speed);
        this.body.setAngularVelocity(rotation);
        this.body.setTransform(body.getPosition().x, body.getPosition().y, initRotation);
        this.body.setUserData(this);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                com.lisuart.falldown.Config.Tex.rectangle1,
                this.body.getPosition().x - sizeX/2f,
                this.body.getPosition().y - sizeY/2f,
                sizeX / 2,
                sizeY / 2,
                sizeX,
                sizeY,
                com.lisuart.falldown.Config.Tex.rectangle1.getScaleX(),
                com.lisuart.falldown.Config.Tex.rectangle1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
