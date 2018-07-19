package com.lisuart.falldown.Model.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Vector;

/**
 * Created by artem on 5/18/18.
 */

public class Effects {
    public Vector<com.lisuart.falldown.Model.AEffect> effects = new Vector<com.lisuart.falldown.Model.AEffect>();

    public Effects()
    {

    }

    public void render(SpriteBatch batch) {
        for (int i = effects.size() - 1; i >= 0; i--) {
            effects.get(i).render(batch);
        }
    }

    public void act() {
        for (int i = effects.size() - 1; i >= 0; i--) {
            effects.get(i).act();
            if (effects.get(i).isDisposed) {
                effects.get(i).dispose();
                effects.remove(i);
            }
        }
    }

    public void dispose()
    {
        for (int i = effects.size() - 1; i >= 0; i--) {
            effects.get(i).dispose();
            effects.remove(i);
        }
    }
}
