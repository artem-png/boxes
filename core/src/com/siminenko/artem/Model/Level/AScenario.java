package com.siminenko.artem.Model.Level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.Player;
import com.siminenko.artem.MyGdxGame;

import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public abstract class AScenario {
    protected Player player;
    protected World world;
    protected ALevel level;
    public boolean isDead = false;
    public int doDelay;
    public Vector<AObject> objects = new Vector<AObject>();

    public void act() {
        doDelay--;
    }

    public abstract void render(SpriteBatch batch);

    public abstract void action();

    public void dispose() {

    }

    protected Vector2 getStandartPosition() {
        return new Vector2(MyGdxGame.width/2, MyGdxGame.height + 10);
    }
}
