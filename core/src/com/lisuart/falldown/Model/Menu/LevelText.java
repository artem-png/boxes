package com.lisuart.falldown.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Config.Progress;

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
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width - 2;
        font = com.lisuart.falldown.Config.Tex.smallFont3;
        font2 = com.lisuart.falldown.Config.Tex.smallFont28;
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        if (isMenu) {
            font.setColor(Color.ORANGE);
            font2.setColor(Color.ORANGE);
            font.draw(
                    com.lisuart.falldown.MyGdxGame.batchFont,
                    "LEVEL: " + level,
                    5,
                    com.lisuart.falldown.Config.Tex.y * 463,
                    Gdx.graphics.getWidth(),
                    1,
                    false
            );
            font2.draw(
                    com.lisuart.falldown.MyGdxGame.batchFont,
                    "BEST SCORE: " + Progress.maxScore,
                    5,
                    com.lisuart.falldown.Config.Tex.y * 435,
                    Gdx.graphics.getWidth(),
                    1,
                    false
            );
        } else {
            font.setColor(Color.DARK_GRAY);
            font2.setColor(Color.DARK_GRAY);
            if (level == 0) {
                font2.draw(
                        com.lisuart.falldown.MyGdxGame.batchFont,
                        "BEST SCORE: " + Progress.maxScore,
                        5,
                        com.lisuart.falldown.Config.Tex.y * 455,
                        Gdx.graphics.getWidth(),
                        1,
                        false
                );
            } else {
                font.setColor(font.getColor().r, font.getColor().g, font.getColor().b , 1);
                font.draw(
                        com.lisuart.falldown.MyGdxGame.batchFont,
                        "LEVEL: " + level,
                        5,
                        com.lisuart.falldown.Config.Tex.y * 455,
                        Gdx.graphics.getWidth(),
                        1,
                        false
                );
            }
        }
        font.setColor(Color.WHITE);
        font2.setColor(Color.WHITE);
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
