package com.siminenko.artem.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Info;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

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
        font2 = Tex.generateFont(Color.WHITE, (int) (2.5f * xd), "smallfont.ttf");
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        if (isMenu) {
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
                    "BEST SCORE: " + Progress.maxScore,
                    5,
                    Tex.y * 435,
                    Gdx.graphics.getWidth(),
                    1,
                    false
            );
        } else {
            if (level == 0) {
                font2.draw(
                        MyGdxGame.batchFont,
                        "BEST SCORE: " + Progress.maxScore,
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
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {
    }
}
