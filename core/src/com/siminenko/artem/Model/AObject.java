package com.siminenko.artem.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/19/18.
 */

public abstract class AObject {
    BodyDef bodyDef;
    Body body;
    Shape shape;
    FixtureDef fixtureDef;
    Fixture fixture;
    World world;
    ALevel level;

    public boolean isNeedParticles = true;

    boolean isDestroyed = false;

    boolean isDisposed = false;

    public void createObject(Vector2 position, Shape shape, World world, float density, float friction, float restitution) {
        float rotate = 0;
        if (body != null) {
            rotate = body.getAngle();
            GameLayout.world.destroyBody(body);
        }
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(position.x, position.y);
        body = world.createBody(bodyDef);
        body.setTransform(position.x, position.y, rotate);
        setShapeToFixture(shape, density, friction, restitution);
        this.body.setActive(false);
    }

    protected void setShapeToFixture(Shape shape, float density, float friction, float restitution) {
        fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;
        fixture = body.createFixture(fixtureDef);
        body.resetMassData();
    }

    public void setLevel(ALevel level) {
        this.level = level;
    }

    public void setVelocity(Vector2 vector2) {
        this.body.setLinearVelocity(vector2);
    }

    public void setGravityScale(float scale) {
        this.body.setGravityScale(scale);
    }

    public void setAngularVelocity(float scale) {
        this.body.setAngularVelocity(scale);
    }

    public boolean isAway() {
        return body.getPosition().y < -30
                || body.getPosition().x > MyGdxGame.width + 30
                || body.getPosition().x < -30
                || (body.getPosition().y > MyGdxGame.height + 30 && body.getLinearVelocity().y > 5);
    }

    public void act() {
        if (isAway()) {
            this.setDispose(true);
        }
    }

    public Body getBody() {
        return this.body;
    }

    public abstract void render(SpriteBatch batch);

    public void dispose() {
        shape.dispose();
        world.destroyBody(this.body);
    }
    public void setDispose(boolean d) {
        this.isDisposed = d;
    }

    public boolean getDispose() {
        return isDisposed;
    }
}
