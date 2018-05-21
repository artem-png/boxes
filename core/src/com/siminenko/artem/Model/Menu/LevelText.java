package com.siminenko.artem.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class LevelText {
    static BitmapFont font;
    static float xd;
    static float yd;
    int level;

    public LevelText(int level, Color color) {
        this.font.setColor(color);
        this.level = level;
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width - 2;
        font = Tex.generateFont(Color.WHITE, (int) (3 * xd), "smallfont.ttf");
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                "LEVEL: " + level,
                5,
                Tex.y * 455,
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
