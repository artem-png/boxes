package com.siminenko.artem.Model.Win;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class PlusDiamondText {
    static BitmapFont font;

    public PlusDiamondText() {

    }

    public static void init() {
        font = Tex.smallFont3;
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.draw(Tex.diamond, 22.3f, 54.8f, 3, 4);
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                "+5",
                -30 * Tex.x,
                Tex.y * 347,
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
