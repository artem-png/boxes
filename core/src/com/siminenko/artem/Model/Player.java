package com.siminenko.artem.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Data.UserData;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/19/18.
 */
public class Player extends AObject {
    int fingerDistance = Gdx.graphics.getHeight() / 7;
    Ballon ballon;

    int touchDelay = 10;

    public Player(World world, Vector2 position) {
        this.world = world;
//        shape = new CircleShape();
//        shape.setRadius(2.5f);         circle
//        this.shape = shape;

        PolygonShape shape = new PolygonShape();
        Vector2[] vector2 = new Vector2[3];
        vector2[0] = new Vector2(0f, 3f);
        vector2[1] = new Vector2(-2.9f, -1.8f);
        vector2[2] = new Vector2(2.9f, -1.8f);
        shape.set(vector2);
        this.shape = shape;


        this.createObject(position, this.shape, world, 0.45f, 0.5f, 0f);
        this.body.setUserData(new UserData(this));
        this.body.setGravityScale(0);
        ballon = new Ballon(world, new Vector2(position.x, 6));
//        Tex.player1.setOrigin(2.5f, 2.5f); // circle
        Tex.player1.setOrigin(2.9f, 1.8f);
        this.body.setActive(true);
    }

    @Override
    public void act() {
        input();
        ballon.act();
        if (body.getAngularVelocity() > 0) {
            body.setAngularVelocity(body.getAngularVelocity() - 0.01f);
            if (body.getAngularVelocity() < 0) {
                body.setAngularVelocity(0);
            }
        }
        if (body.getAngularVelocity() < 0) {
            body.setAngularVelocity(body.getAngularVelocity() + 0.01f);
            if (body.getAngularVelocity() > 0) {
                body.setAngularVelocity(0);
            }
        }

    }

    @Override
    public void render(SpriteBatch batch) {
        ballon.render(batch);
        batch.draw(
                Tex.player1,
                this.body.getPosition().x - 2.9f,
                this.body.getPosition().y - 1.8f,
                Tex.player1.getOriginX(),
                Tex.player1.getOriginY(),
                5.8f,
                6f,
                Tex.player1.getScaleX(),
                Tex.player1.getScaleY(),
                (float) Math.toDegrees(this.body.getAngle())
        );
    }

    public void dispose() {
        ballon.dispose();
        shape.dispose();
        this.world.destroyBody(body);
    }

    public void input() {
        if (this.isDisposed) {
            return;
        }
        touchDelay--;
        if (touchDelay <= 0 && Gdx.input.isTouched()) {
            Vector2 currentPosition1 = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            Vector3 currentPosition = MyGdxGame.camera.unproject(new Vector3(currentPosition1.x, currentPosition1.y - fingerDistance, 0));
            this.body.setLinearVelocity(
                    -(body.getPosition().x - currentPosition.x) * 10,
                    -(body.getPosition().y - currentPosition.y) * 10
            );
        } else {
            this.body.setLinearVelocity(0, 0);
        }
    }
}
