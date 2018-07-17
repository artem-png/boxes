package com.siminenko.falldown.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 4/23/18.
 */

public class LevelText {
    static BitmapFont font;
    static BitmapFont font2;
    static float xd;
    static float yd;
    int level;

    public boolean isMenu = false;

    public LevelText(int level, Color color) {
        this.font.setColor(color);
        this.font2.setColor(color);
        this.level = level;
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width - 2;
        font = Tex.smallFont3;
        font2 = Tex.smallFont28;
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        if (isMenu) {
            font.setColor(Color.ORANGE);
            font2.setColor(Color.ORANGE);
            font.draw(
                    MyGdxGame.batchFont,
                    "LEVEL: " + level,
                    5,
                    Tex.y * 463,
                    Gdx.graphics.getWidth(),
                    1,
                    false
            );
            font2.draw(
                    MyGdxGame.batchFont,
                    "BEST SCORE: " + com.siminenko.falldown.Config.Progress.maxScore,
                    5,
                    Tex.y * 435,
                    Gdx.graphics.getWidth(),
                    1,
                    false
            );
        } else {
            font.setColor(Color.DARK_GRAY);
            font2.setColor(Color.DARK_GRAY);
            if (level == 0) {
                font2.draw(
                        MyGdxGame.batchFont,
                        "BEST SCORE: " + com.siminenko.falldown.Config.Progress.maxScore,
                        5,
                        Tex.y * 455,
                        Gdx.graphics.getWidth(),
                        1,
                        false
                );
            } else {
                font.setColor(font.getColor().r, font.getColor().g, font.getColor().b , 1);
                font.draw(
                        MyGdxGame.batchFont,
                        "LEVEL: " + level,
                        5,
                        Tex.y * 455,
                        Gdx.graphics.getWidth(),
                        1,
                        false
                );
            }
        }
        font.setColor(Color.WHITE);
        font2.setColor(Color.WHITE);
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
