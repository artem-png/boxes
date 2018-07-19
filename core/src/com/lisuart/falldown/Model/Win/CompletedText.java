package com.lisuart.falldown.Model.Win;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Config.Tex;

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
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
        font = Tex.failedWinFont;
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        font.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "COMPLETED",
                0,
                Tex.y * 400,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
