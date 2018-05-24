package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Vector;

/**
 * Created by artem on 3/21/18.
 */

public class LayoutManager {
    public Vector<LayoutInterface> vector;

    public LayoutManager()
    {
        vector = new Vector<LayoutInterface>();
    }

    public void render(SpriteBatch batch) {
        if (vector.size() > 0) {
            if (vector.get(vector.size() - 1).getIsParralel()) {
                if (vector.size() - 2 >= 0) {
                    vector.get(vector.size() - 2).render(batch);
                }
            }
            vector.get(vector.size() - 1).render(batch);
        }
    }

    public void act(float delta) {
        if (vector.size() > 0)
        vector.get(vector.size()-1).act(delta);
    }

    public void dispose() {
        for (int i = 0 ; i < vector.size(); i++) {
            vector.get(i).dispose();

        }
    }

    public void pop() {
        if (vector.size() > 0) {
            vector.get(vector.size() - 1).dispose();
            vector.remove(vector.size() - 1);
        }
    }

    public void set(LayoutInterface layoutInterface) {
        this.pop();
        this.push(layoutInterface);
    }

    public void push(LayoutInterface layoutInterface) {
        vector.add(layoutInterface);
    }
}
