package com.siminenko.artem.Model.Win;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class CompletedText {
    static BitmapFont font;
    static float xd;
    static float yd;


    public CompletedText() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = Tex.generateFont(Color.BLUE, (int) (5 * xd), "menufont.ttf");
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = Tex.generateFont(Color.BLUE, (int) (5 * xd), "menufont.ttf");
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                "COMPLETED",
                Tex.x * 100,
                Tex.y * 423
        );
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
