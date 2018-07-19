package com.lisuart.falldown.Layout;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by artem on 3/21/18.
 */

public interface LayoutInterface {
    public void act(float delta);
    public void render(SpriteBatch batch);
    public void dispose();

    public boolean getIsParralel();
}
