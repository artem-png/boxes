package com.siminenko.artem.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class DiamondDisplay {
    static BitmapFont font;
    static float xd;
    static float yd;

    public DiamondDisplay() {
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width - 2;
        font = Tex.generateFont(Color.BLACK, (int) (2.7f * xd), "smallfont.ttf");
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.draw(Tex.diamond, 38.1f, 70.5f, 3f, 4f);
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                "" + Progress.getDiamonds(),
                651 * Tex.x,
                Tex.y * 463,
                120 * Tex.x,
                1,
                true
        );
        MyGdxGame.batchFont.end();
        batch.begin();
}

    public void dispose() {
    }
}
