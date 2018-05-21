package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.Model.Menu.ModelPickerModels.Scenarious;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */
public class ObstacleX extends AObject implements Destroyable {
    public static final int TYPE_SIMPLE = 1;
    public static final int TYPE_DESTROYABLE = 2;

    protected int type = TYPE_SIMPLE;

    float sizeMultiplier = 1;

    public ObstacleX(World world, Vector2 position, Vector2 speed, float initRotation, float rotation, float mass, int type, float sizeMultiplier) {
        this.world = world;
        this.type = type;
        this.sizeMultiplier = sizeMultiplier;
        PolygonShape shape = new PolygonShape();
        Vector2[] vector2 = new Vector2[4];
        vector2[0] = new Vector2(-3f * sizeMultiplier, 0.5f * sizeMultiplier);
        vector2[1] = new Vector2(3f * sizeMultiplier, 0.5f * sizeMultiplier);
        vector2[2] = new Vector2(3f * sizeMultiplier, -0.5f * sizeMultiplier);
        vector2[3] = new Vector2(-3f * sizeMultiplier, -0.5f * sizeMultiplier);
        shape.set(vector2);
        this.shape = shape;
        this.createObject(position, shape, world, mass, 1f, 0);

        shape = new PolygonShape();
        vector2 = new Vector2[4];
        vector2[0] = new Vector2(-0.5f * sizeMultiplier, -3f * sizeMultiplier);
        vector2[1] = new Vector2(-0.5f * sizeMultiplier, 3f * sizeMultiplier);
        vector2[2] = new Vector2(0.5f * sizeMultiplier, 3f * sizeMultiplier);
        vector2[3] = new Vector2(0.5f * sizeMultiplier, -3f * sizeMultiplier);
        shape.set(vector2);
        this.setShapeToFixture(shape, mass, 1f, 0);

        this.body.setLinearVelocity(speed);
        this.body.setAngularVelocity(rotation);
        this.body.setTransform(this.body.getPosition(), (float) Math.toRadians(initRotation));
        this.body.setUserData(this);
    }

    @Override
    public void act() {
        super.act();
        if (isDestroyed && ! isDisposed) {
            isDisposed = true;
            Random random = new Random();
            ObstaclePanel obstaclePanel = new ObstaclePanel(
                    this.world,
                    new Vector2(this.body.getPosition()),
                    new Vector2(this.body.getLinearVelocity()),
                    this.body.getAngle(),
                    this.body.getAngularVelocity(),
                    (int)(6 * sizeMultiplier),
                    (int)(1 * sizeMultiplier)
            );
            obstaclePanel.body.setActive(true);
            GameLayout.level.aObjectVector2.add(obstaclePanel);
            obstaclePanel = new ObstaclePanel(
                    this.world,
                    new Vector2(this.body.getPosition()),
                    new Vector2(this.body.getLinearVelocity()),
                    this.body.getAngle(),
                    this.body.getAngularVelocity(),
                    (int)(1 * sizeMultiplier),
                    (int)(6 * sizeMultiplier)
            );
            obstaclePanel.body.setActive(true);
            GameLayout.level.aObjectVector2.add(obstaclePanel);
            Tex.createParticles(8, 1, this.body.getPosition());
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        Sprite s;
        if (type == ObstacleX.TYPE_DESTROYABLE) {
            s = Tex.crestDestroyable;
        } else {
            s = Tex.crest1;
        }
        batch.draw(
                s,
                this.body.getPosition().x - 3f * sizeMultiplier,
                this.body.getPosition().y - 3f * sizeMultiplier,
                3f * sizeMultiplier,
                3 * sizeMultiplier,
                6f * sizeMultiplier,
                6 * sizeMultiplier,
                Tex.crest1.getScaleX(),
                Tex.crest1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }

    @Override
    public void doDestroy() {
        if (this.type == ObstacleX.TYPE_SIMPLE) {
            return;
        }
        isDestroyed = true;
    }
}
