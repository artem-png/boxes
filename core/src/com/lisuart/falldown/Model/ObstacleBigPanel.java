package com.lisuart.falldown.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lisuart.falldown.Config.Tex;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleBigPanel extends AObject {
    float sizeX = 50;
    float sizeY = 6;

    public ObstacleBigPanel(World world, Vector2 position) {
        this.world = world;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sizeX/2, sizeY/2);
        this.shape = shape;
        this.createObject(position, shape, world, 0.9f, 1f, 0);
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
