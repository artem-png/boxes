package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Data.CircleData;
import com.siminenko.artem.Model.Data.ObstaclePanelData;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleCircle extends AObject implements Destroyable {
    float size;
    Vector2 origin;
    Sprite sprite = Tex.circle1;

    public int iterations = 0;

    boolean isDestroyable = false;

    public ObstacleCircle(World world, Vector2 position, Vector2 velocity, float size) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, 0.5f, 1f, 0);
        this.body.setUserData(this);
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size / 2, size / 2);
    }

    public ObstacleCircle(World world, Vector2 position, Vector2 velocity, float size, float restitution, Sprite sprite) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, 0.5f, 1f, restitution);
        this.body.setUserData(new CircleData(this));
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size / 2, size / 2);
        this.sprite = sprite;
    }

    public ObstacleCircle(World world, Vector2 position, Vector2 velocity, float size, float restitution, Sprite sprite, boolean ignoreCollision) {
        this.world = world;
        CircleShape shape = new CircleShape();
        shape.setRadius(size / 2);
        this.shape = shape;
        this.size = size;
        this.createObject(position, shape, world, 0.5f, 1f, restitution, ignoreCollision);

        this.body.setUserData(new CircleData(this));
        this.body.setLinearVelocity(velocity.x, velocity.y);
        origin = new Vector2(size / 2, size / 2);
        this.sprite = sprite;
    }

    @Override
    public void act() {
        super.act();
        if (isDestroyed && !isDisposed) {
            isDisposed = true;
            ObstacleCircle obstacleCircle = new ObstacleCircle(
                    this.world,
                    new Vector2(this.body.getPosition().x + 2, this.body.getPosition().y),
                    new Vector2(4, 20),
                    (int) (size / 2) >= 3 ? size / 2 : 3
            );
            obstacleCircle.iterations = this.iterations - 1;
            obstacleCircle.body.setActive(true);
            GameLayout.level.aObjectVector2.add(obstacleCircle);

            obstacleCircle = new ObstacleCircle(
                    this.world,
                    new Vector2(this.body.getPosition().x - 2, this.body.getPosition().y),
                    new Vector2(-4, 20),
                    (int) (size / 2) >= 3 ? size / 2 : 3
            );
            obstacleCircle.iterations = this.iterations - 1;
            obstacleCircle.body.setActive(true);
            GameLayout.level.aObjectVector2.add(obstacleCircle);
            Tex.createParticles(8, 1, this.body.getPosition());
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        Sprite s;
        if (iterations > 0) {
            s = Tex.circleDestroyable;
        } else {
            s = Tex.circle1;
        }
        batch.draw(
                s,
                this.body.getPosition().x - size / 2,
                this.body.getPosition().y - size / 2,
                origin.x,
                origin.y,
                size,
                size,
                this.sprite.getScaleX(),
                this.sprite.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }

    @Override
    public void doDestroy() {
        if (this.iterations > 0) {
            isDestroyed = true;
        }
    }
}
