package com.siminenko.falldown.Model.Level.Scenarious.Level9;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by artem on 4/23/18.
 */

public class TutorialBonusBig extends com.siminenko.falldown.Model.Level.AScenario {
    Sprite plus;
    Sprite present;
    Sprite equal;
    Sprite shadow;

    com.siminenko.falldown.Model.Level.TutorialSprite tmini;
    com.siminenko.falldown.Model.Level.TutorialSprite tplus;
    com.siminenko.falldown.Model.Level.TutorialSprite tpresent;
    com.siminenko.falldown.Model.Level.TutorialSprite tequal;
    com.siminenko.falldown.Model.Level.TutorialSprite tbig;


    public TutorialBonusBig(World world, com.siminenko.falldown.Model.Player player, com.siminenko.falldown.Model.Level.ALevel level, int delay) {
        this.level = level;
        this.world = world;
        this.player = player;
        this.doDelay = 180;

        plus = new Sprite(new Texture("tutorial/plus.png"));
        equal = new Sprite(new Texture("tutorial/equal.png"));
        shadow = new Sprite(new Texture("menu/bgshadow.png"));
        present = new Sprite(new Texture("present.png"));

        tmini = new com.siminenko.falldown.Model.Level.TutorialSprite(com.siminenko.falldown.Config.Tex.player1, new Vector2(2.5f, 50.5f), new Vector2(6, 6));
        tmini.down = true;
        tplus = new com.siminenko.falldown.Model.Level.TutorialSprite(plus, new Vector2(12, 52), new Vector2(3, 3));
        tplus.down = true;
        tpresent = new com.siminenko.falldown.Model.Level.TutorialSprite(present, new Vector2(18f, 50), new Vector2(7, 7));
        tpresent.down = true;
        tequal = new com.siminenko.falldown.Model.Level.TutorialSprite(equal, new Vector2(28f, 52f), new Vector2(3, 3));
        tequal.down = true;
        tbig = new com.siminenko.falldown.Model.Level.TutorialSprite(com.siminenko.falldown.Config.Tex.player1, new Vector2(32.5f, 48.5f), new Vector2(10, 10));
        tbig.down = true;
    }

    @Override
    public void act() {
        super.act();
        tmini.act();
        tpresent.act();
        tequal.act();
        tbig.act();
        tplus.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(shadow, -5, 48, com.siminenko.falldown.MyGdxGame.width + 10, 11);
        tmini.render(batch);
        tpresent.render(batch);
        tequal.render(batch);
        tbig.render(batch);
        tplus.render(batch);
    }

    @Override
    public void action() {
        isDead = true;
    }

    public void dispose()
    {
        this.tmini.dispose();
        this.tpresent.dispose();
        this.tequal.dispose();
        this.tbig.dispose();
        this.tplus.dispose();
    }
}
