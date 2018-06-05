package com.siminenko.artem.Model.Powers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class PowerShield extends APower {
    Vector2 size = new Vector2(MyGdxGame.width * 0.75f, 1.4f);
    Vector2 position = new Vector2(MyGdxGame.width + size.x, 18);

    Vector2 velocity = new Vector2(-40, 0);
    Body body;

    Random random = new Random();

    Sprite sprite = new Sprite(new Texture("shieldButton.png"));

    int maxShieldRotate = 40;
    int shieldRotate = 40;

    boolean shieldUp = false;
    boolean shieldDown = false;

    public PowerShield(int level, World world, int time) {
        levelNumber = level;
        this.world = world;
        delaySetting = time;

        // shape
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);
        // body def
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(position.x, position.y);
        body = world.createBody(bodyDef);
        body.setTransform(position.x, position.y, 0);
        // set shape
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;
        fixtureDef.friction = 1;
        fixtureDef.restitution = 0.19f;
        Fixture fixture = body.createFixture(fixtureDef);
        body.resetMassData();
        body.setActive(false);
    }

    public void act() {
        input();

        if (delay > 0) {
            delay--;

            if (delay == 0) {
                shieldUp = true;
            }
        }

        if (shieldUp) {
            shieldRotate ++;
            if (shieldRotate > maxShieldRotate) {
                shieldRotate = maxShieldRotate;
                shieldUp = false;
            }
        }

        if (shieldDown) {
            shieldRotate--;
            if (shieldRotate < -maxShieldRotate) {
                shieldRotate = -maxShieldRotate;
                shieldDown = false;
            }
        }

        if (isActive && body.getPosition().x + size.x < 0) {
            this.body.setLinearVelocity(0, 0);
            this.body.setTransform(position, 0);
            isActive = false;
            delay = delaySetting;
            body.setActive(false);
        }
    }

    public void input() {
        if (delay == 0 && !shieldUp && !shieldDown) {
            for (int i = 0; i <= 1; i++) {
                if (Gdx.input.justTouched() && Gdx.input.isTouched(i)) {
                    Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                    if (vector3.x > MyGdxGame.width - 6 && vector3.y > 28 && vector3.y < 38) {
                        isActive = true;
                        body.setActive(true);
                        shieldDown = true;
                    }
                }
            }
        }
        if (isActive) {
            Tex.createParticles(1, 0.4f, new Vector2(random.nextInt(MyGdxGame.width), body.getPosition().y - size.y/2));

            Tex.createParticles(6, 0.5f, new Vector2(body.getPosition().x + size.x, body.getPosition().y - size.y/3));
            body.setLinearVelocity(velocity.x, velocity.y);
        }
    }

    public void render(SpriteBatch batch) {
          batch.draw(
                  sprite,
                  MyGdxGame.width - 1,
                  30,
                  5,
                  -2,
                  6,
                  7,
                  sprite.getScaleX(),
                  sprite.getScaleY(),
                  shieldRotate
          );
        batch.draw(
                Tex.shield,
                body.getPosition().x - size.x,
                body.getPosition().y - size.y,
                size.x,
                size.y,
                size.x * 2,
                size.y * 2,
                Tex.shield.getScaleX(),
                Tex.shield.getScaleY(),
                0
        );
    }
}
