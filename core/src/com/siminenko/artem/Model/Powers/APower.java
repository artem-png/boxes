package com.siminenko.artem.Model.Powers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by artem on 5/22/18.
 */

public abstract class APower {
    int delaySetting = 400;
    int delay = 0;
    World world;
    int levelNumber;

    boolean isActive = false;

    public abstract void act();

    public abstract void render(SpriteBatch batch);

    public void dispose() {

    }
}
