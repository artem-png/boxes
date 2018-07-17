package com.siminenko.falldown.Model.Level.Scenarious.Level6;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class TutorialBomb extends com.siminenko.falldown.Model.Level.AScenario {
    Sprite plus;
    Sprite oclock;
    Sprite equal;
    Sprite explode;
    Sprite shadow;

    com.siminenko.falldown.Model.Level.TutorialSprite tbomb;
    com.siminenko.falldown.Model.Level.TutorialSprite tplus;
    com.siminenko.falldown.Model.Level.TutorialSprite ttime;
    com.siminenko.falldown.Model.Level.TutorialSprite tequal;
    com.siminenko.falldown.Model.Level.TutorialSprite texplode;


    public TutorialBomb(World world, com.siminenko.falldown.Model.Player player, com.siminenko.falldown.Model.Level.ALevel level, int delay) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.doDelay = 180;

        plus = new Sprite(new Texture("tutorial/plus.png"));
        equal = new Sprite(new Texture("tutorial/equal.png"));
        shadow = new Sprite(new Texture("menu/bgshadow.png"));
        oclock = new Sprite(new Texture("oclock.png"));
        explode = new Sprite(new Texture("explosion.png"));

        tbomb = new com.siminenko.falldown.Model.Level.TutorialSprite(com.siminenko.falldown.Config.Tex.circle1, new Vector2(1.5f, 49.5f), new Vector2(8, 8));
        tbomb.isPulse = true;
        tbomb.expTimeSetting = 200;
        tbomb.expTime = 200;
        tbomb.down = true;
        tplus = new com.siminenko.falldown.Model.Level.TutorialSprite(plus, new Vector2(12, 52), new Vector2(3, 3));
        tplus.down = true;
        ttime = new com.siminenko.falldown.Model.Level.TutorialSprite(oclock, new Vector2(18f, 50), new Vector2(7, 7));
        ttime.down = true;
        tequal = new com.siminenko.falldown.Model.Level.TutorialSprite(equal, new Vector2(28f, 52f), new Vector2(3, 3));
        tequal.down = true;
        texplode = new com.siminenko.falldown.Model.Level.TutorialSprite(explode, new Vector2(32.5f, 48.5f), new Vector2(10, 10));
        texplode.down = true;
    }

    @Override
    public void act() {
        super.act();
        tbomb.act();
        ttime.act();
        tequal.act();
        texplode.act();
        tplus.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(shadow, -5, 48, MyGdxGame.width + 10, 11);
        tbomb.render(batch);
        ttime.render(batch);
        tequal.render(batch);
        texplode.render(batch);
        tplus.render(batch);
    }

    @Override
    public void action() {
        isDead = true;
    }

    public void dispose()
    {
        this.tbomb.dispose();
        this.ttime.dispose();
        this.tequal.dispose();
        this.texplode.dispose();
        this.tplus.dispose();
    }
}
