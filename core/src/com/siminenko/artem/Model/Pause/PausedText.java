package com.siminenko.artem.Model.Pause;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

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
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        if (font == null) {
            font = Tex.failedWinFont;
        }
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        font.setColor(Color.DARK_GRAY);
        font.draw(
                MyGdxGame.batchFont,
                "PAUSED",
                0,
                Tex.y * 410,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        font.setColor(Color.WHITE);
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
