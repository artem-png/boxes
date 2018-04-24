package com.siminenko.artem.Model.LevelLayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Layout.MenuLayout;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class TopPanel {
    Vector2 size = new Vector2(MyGdxGame.width + 1, 13);
    Vector2 position = new Vector2(-1, MyGdxGame.height - 12);
    static Sprite panel;

    public static void init() {
        panel = new Sprite(new Texture("menu/topPanel.png"));
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.draw(this.panel, position.x, position.y, size.x, size.y);
    }

    public void dispose() {

    }
}
