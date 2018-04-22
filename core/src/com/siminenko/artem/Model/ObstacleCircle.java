package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Data.CircleData;
import com.siminenko.artem.Model.Data.ObstaclePanelData;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleCircle extends AObject {
    float size;
    Vector2 origin;
    public ObstacleCircle(World world, Vector2 position, Vector2 velocity, float size) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size/2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, 0.5f, 1f, 0.7f);
        this.body.setUserData(new CircleData(this));
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size/2, size/2);
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                Tex.circle1,
                this.body.getPosition().x - size/2,
                this.body.getPosition().y - size/2,
                origin.x,
                origin.y,
                size,
                size,
                Tex.circle1.getScaleX(),
                Tex.circle1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
