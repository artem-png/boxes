package com.siminenko.artem.Model.Level.Scenarious.Level11;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.AScenario;
import com.siminenko.artem.Model.Level.TutorialSprite;
import com.siminenko.artem.Model.Player;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class TutorialPower extends AScenario {
    Sprite clicker;
    Sprite activeClicker;
    Sprite powerBG;

    Vector2 size = new Vector2(7, 7);
    Vector2 sizeClicked = new Vector2(6f, 6f);

    Vector2 position = new Vector2(MyGdxGame.width - 6, 25);

    boolean isClicked = false;

    int clickTimeSetting = 10;
    int clickTime = clickTimeSetting;

    int phase = 1;
    int phasePause = 10;
    int phase2Pause = 50;


    public TutorialPower(World world, Player player, ALevel level, int delay) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.doDelay = 100000;

        clicker = new Sprite(new Texture("tutorial/pointer.png"));
        activeClicker = new Sprite(new Texture("tutorial/pointerClicker.png"));
        powerBG = new Sprite(new Texture("powerBG.png"));
    }

    @Override
    public void act() {
        super.act();

        if (Gdx.input.justTouched()) {
            Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > MyGdxGame.width - 6 && vector3.y > 14 && vector3.y < 24) {
                isDead = true;
                this.doDelay = 0;
            }
        }

        if (isClicked) {
            clickTime--;
            if (clickTime <= 0) {
                clickTime = clickTimeSetting;
                if (phase == 1) {
                    phase = 2;
                } else {
                    phase = 1;
                }
                isClicked = false;
            }
        } else {
            if (phase == 1) {
                phasePause--;
                if (phasePause <= 0) {
                    phasePause = 10;
                    isClicked = true;
                }
            } else if (phase == 2) {
                phase2Pause--;
                if (phase2Pause <= 0) {
                    phase2Pause = 50;
                    isClicked = true;
                }
            }
        }

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(powerBG, -2, 0, MyGdxGame.width + 2, MyGdxGame.height);
        if (isClicked) {
            batch.draw(
                    activeClicker,
                    position.x - sizeClicked.x / 2,
                    position.y - sizeClicked.y / 2,
                    sizeClicked.x / 2,
                    sizeClicked.y / 2,
                    sizeClicked.x,
                    sizeClicked.y,
                    activeClicker.getScaleX(),
                    activeClicker.getScaleY(),
                    -130
            );
        } else {
            batch.draw(
                    clicker,
                    position.x - size.x / 2,
                    position.y - size.y / 2,
                    size.x / 2,
                    size.y / 2,
                    size.x,
                    size.y,
                    clicker.getScaleX(),
                    clicker.getScaleY(),
                    -130
            );
        }
    }

    @Override
    public void action() {
        isDead = true;
        clicker.getTexture().dispose();
        activeClicker.getTexture().dispose();
    }
}
