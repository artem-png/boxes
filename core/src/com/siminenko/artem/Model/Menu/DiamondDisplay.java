package com.siminenko.artem.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class DiamondDisplay {
    static BitmapFont font;
    static float xd;
    static float yd;

    public static float alpha = 1;

    public DiamondDisplay() {
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width - 2;
        font = Tex.smallFont28;
    }

    public void act() {
        if (MyGdxGame.layoutManager.vector.lastElement() instanceof GameLayout) {
            if (alpha != 0) {
                alpha -= 0.01;
                if (alpha < 0) {
                    alpha = 0;
                }
            }
        } else {
            alpha = 1;
        }
    }

    public void render(SpriteBatch batch) {
        batch.setColor(1, 1, 1, alpha);
        batch.draw(Tex.diamond, 38.1f, 70.5f, 3f, 4f);
        batch.setColor(1, 1, 1, 1);
        batch.end();
        MyGdxGame.batchFont.begin();
        font.setColor(Color.BLACK);
        font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, alpha);
        font.draw(
                MyGdxGame.batchFont,
                "" + Progress.getDiamonds(),
                651 * Tex.x,
                Tex.y * 463,
                120 * Tex.x,
                1,
                true
        );
        font.setColor(Color.WHITE);
        MyGdxGame.batchFont.end();
        batch.begin();
}

    public void dispose() {
    }
}
