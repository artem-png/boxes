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
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class PowerClock extends APower {
    int timePowerSetting = 450;
    int timePower = timePowerSetting;

    Sprite sprite = new Sprite(new Texture("clockPower.png"));

    int maxShieldRotate = 40;
    int shieldRotate = -40;

    boolean shieldUp = false;
    boolean shieldDown = false;

    Random random = new Random();

    public PowerClock(int level, World world, int time) {
        levelNumber = level;
        this.world = world;
        delaySetting = time;
    }

    public void act() {
        input();

        if (delay > 0) {
            delay--;

            if (delay == 0) {
                shieldDown = true;
            }
        }

        if (shieldUp) {
            shieldRotate++;
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

        if (isActive && timePower > 0) {
            timePower--;
            Tex.createParticles(1, 0.5f, new Vector2(1, random.nextInt(MyGdxGame.height)));
            Tex.createParticles(1, 0.5f, new Vector2(MyGdxGame.width - 1, random.nextInt(MyGdxGame.height)));
            Tex.createParticles(1, 0.5f, new Vector2(random.nextInt(MyGdxGame.width), MyGdxGame.height - 1));
            Tex.createParticles(1, 0.5f, new Vector2(random.nextInt(MyGdxGame.width), 1));
            if (timePower == 0) {
                GameLayout.borderEffects.setFreezDown();
                isActive = false;
                delay = delaySetting;
                timePower = timePowerSetting;
            }
        }
    }

    public void input() {
        if (delay == 0 && !shieldUp && !shieldDown) {
            for (int i = 0; i <= 1; i++) {
                if (Gdx.input.justTouched() && Gdx.input.isTouched(i)) {
                    Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0));
                    if (vector3.x < 6 && vector3.y > 27 && vector3.y < 39) {
                        isActive = true;
                        GameLayout.borderEffects.setFreezUp();
                        shieldUp = true;
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                sprite,
                -4,
                30,
                0,
                -1,
                6,
                6,
                sprite.getScaleX(),
                sprite.getScaleY(),
                shieldRotate
        );
    }
}
