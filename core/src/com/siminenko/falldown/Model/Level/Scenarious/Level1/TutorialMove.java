package com.siminenko.falldown.Model.Level.Scenarious.Level1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class TutorialMove extends com.siminenko.falldown.Model.Level.AScenario {
    int touchCounter = 0;
    int touchCounterNeed = 60;
    Sprite clicker;
    Sprite activeClicker;
    Sprite plus;
    Sprite death;
    Sprite equal;
    Sprite shadow;

    Vector2 firstPositionSetting = new Vector2(MyGdxGame.width / 2, 20);
    Vector2 firstPosition = new Vector2(MyGdxGame.width / 2, 20);
    Vector2 size = new Vector2(7, 7);
    Vector2 sizeClicked = new Vector2(6.5f, 6.5f);

    boolean isClicked = false;
    int clickDuration = 30;

    int goDuration = 60;
    boolean goLeft = true;

    int reading = 100;

    com.siminenko.falldown.Model.Level.TutorialSprite tplayer;
    com.siminenko.falldown.Model.Level.TutorialSprite tplus;
    com.siminenko.falldown.Model.Level.TutorialSprite tblock;
    com.siminenko.falldown.Model.Level.TutorialSprite tequal;
    com.siminenko.falldown.Model.Level.TutorialSprite tdeath;


    public TutorialMove(World world, com.siminenko.falldown.Model.Player player, ALevel level, int delay) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.doDelay = 100000;

        clicker = new Sprite(new Texture("tutorial/pointer.png"));
        activeClicker = new Sprite(new Texture("tutorial/pointerClicker.png"));
        plus = new Sprite(new Texture("tutorial/plus.png"));
        death = new Sprite(new Texture("tutorial/sad.png"));
        equal = new Sprite(new Texture("tutorial/equal.png"));
        shadow = new Sprite(new Texture("menu/bgshadow.png"));

        tplayer = new com.siminenko.falldown.Model.Level.TutorialSprite(Tex.player1, new Vector2(1, 49), new Vector2(9, 9));
        tplus = new com.siminenko.falldown.Model.Level.TutorialSprite(plus, new Vector2(12, 52), new Vector2(3, 3));
        tblock = new com.siminenko.falldown.Model.Level.TutorialSprite(Tex.rectangle1, new Vector2(20.5f, 50), new Vector2(2, 7));
        tequal = new com.siminenko.falldown.Model.Level.TutorialSprite(equal, new Vector2(28f, 52f), new Vector2(3, 3));
        tdeath = new com.siminenko.falldown.Model.Level.TutorialSprite(death, new Vector2(36, 50f), new Vector2(7, 7));
    }

    @Override
    public void act() {
        super.act();
        reading--;
        if (Gdx.input.isTouched() && reading <= 0) {
            touchCounter++;
        } else {
            touchCounter--;
            if (touchCounter < 0) {
                touchCounter = 0;
            }
        }
        if (touchCounter > touchCounterNeed) {
            doDelay = 0;
        }

        if (!isClicked) {
            clickDuration--;
            if (clickDuration <= 0) {
                isClicked = true;
            }
        } else {
            firstPosition.x -= goLeft ? 0.5f : -0.5f;
            if (firstPosition.x < 10) {
                goLeft = false;
            }
            if (firstPosition.x > MyGdxGame.width - 10) {
                goLeft = true;
            }
            goDuration--;
            if (goDuration <= 0) {
                isClicked = false;
                firstPosition.set(firstPositionSetting);
                goDuration = 120;
                clickDuration = 30;
                goLeft = true;
            }
        }
        tplayer.act();
        tblock.act();
        tequal.act();
        tdeath.act();
        tplus.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!Gdx.input.isTouched() || reading > 0) {
            Color color = batch.getColor();
            batch.setColor(color.r, color.g, color.b, (float) Math.pow(goDuration / 120f, 2));
            if (isClicked) {
                batch.draw(activeClicker, firstPosition.x - sizeClicked.x / 2, firstPosition.y - sizeClicked.y / 2, sizeClicked.x, sizeClicked.y);
            } else {
                batch.draw(clicker, firstPosition.x - size.x / 2, firstPosition.y - size.y / 2, size.x, size.y);
            }
            batch.setColor(color.r, color.g, color.b, 1);

            batch.draw(shadow, -5, 48, MyGdxGame.width + 10, 11);
            tplayer.render(batch);
            tblock.render(batch);
            tequal.render(batch);
            tdeath.render(batch);
            tplus.render(batch);
        }
    }

    @Override
    public void action() {
        isDead = true;
        clicker.getTexture().dispose();
        activeClicker.getTexture().dispose();
        death.getTexture().dispose();
        plus.getTexture().dispose();
        equal.getTexture().dispose();
    }
}
