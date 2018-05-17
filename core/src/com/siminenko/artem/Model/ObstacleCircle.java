package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
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
    Sprite sprite = Tex.circle1;

    public ObstacleCircle(World world, Vector2 position, Vector2 velocity, float size) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size/2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, 0.5f, 1f, 0);
        this.body.setUserData(new CircleData(this));
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size/2, size/2);
    }

    public ObstacleCircle(World world, Vector2 position, Vector2 velocity, float size, float restitution, Sprite sprite) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size/2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, 0.5f, 1f, restitution);
        this.body.setUserData(new CircleData(this));
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size/2, size/2);
        this.sprite = sprite;
    }

    @Override
    public void act() {
        super.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(
                this.sprite,
                this.body.getPosition().x - size/2,
                this.body.getPosition().y - size/2,
                origin.x,
                origin.y,
                size,
                size,
                this.sprite.getScaleX(),
                this.sprite.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }
}
