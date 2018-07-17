package com.siminenko.falldown.Model.Win;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class CompletedText {
    static BitmapFont font;
    static float xd;
    static float yd;


    public CompletedText() {

    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = com.siminenko.falldown.Config.Tex.failedWinFont;
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                "COMPLETED",
                0,
                com.siminenko.falldown.Config.Tex.y * 400,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
