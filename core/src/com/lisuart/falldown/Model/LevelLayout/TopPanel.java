package com.lisuart.falldown.Model.LevelLayout;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by User on 22.04.2018.
 */

public class TopPanel {
    Vector2 size = new Vector2(com.lisuart.falldown.MyGdxGame.width + 1, 13);
    Vector2 position = new Vector2(-1, com.lisuart.falldown.MyGdxGame.height - 12);
    static Sprite panel;

    public TopPanel() {
        if (panel == null) {
            panel = new Sprite(new Texture("menu/topPanel.png"));
        }
    }

    public static void init() {
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.draw(this.panel, position.x, position.y, size.x, size.y);
    }

    public void dispose() {

    }
}
