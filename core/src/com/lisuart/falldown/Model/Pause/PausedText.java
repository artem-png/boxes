package com.lisuart.falldown.Model.Pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Config.Tex;

/**
 * Created by User on 22.04.2018.
 */

public class PausedText {
    static BitmapFont font;
    static float xd;
    static float yd;


    public PausedText() {
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
        if (font == null) {
            font = Tex.failedWinFont;
        }
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        font.setColor(Color.DARK_GRAY);
        font.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "PAUSED",
                0,
                Tex.y * 410,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        font.setColor(Color.WHITE);
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
