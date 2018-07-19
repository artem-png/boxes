package com.lisuart.falldown.Model.Infinite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Layout.GameLayout;

/**
 * Created by artem on 5/25/18.
 */

public class Score {
    public static int score = 1;
    int timePauseSetting = 30;
    int timePause = timePauseSetting;
    float yd = (float) Gdx.graphics.getHeight() / (float) com.lisuart.falldown.MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) com.lisuart.falldown.MyGdxGame.width;

    static BitmapFont font;

    boolean isFontDown = false;

    int time = 0;

    public static void init() {
        float yd = (float) Gdx.graphics.getHeight() / (float) com.lisuart.falldown.MyGdxGame.height;
        font = com.lisuart.falldown.Config.Tex.generateFont(Color.DARK_GRAY, (int) (12f * yd), "bigfont.ttf");
        font.setColor(1, 1, 1, 0.3f);
        font.getData().setScale(0.8f, 0.8f);
    }

    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        font.draw(com.lisuart.falldown.MyGdxGame.batchFont, score + "", 0, (com.lisuart.falldown.MyGdxGame.height - 4) * yd, com.lisuart.falldown.MyGdxGame.width * xd, 1, true);
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void act() {
        time ++;
        if (time % 1200 == 0) {
            timePauseSetting--;
            System.out.println("SCORE DECREASE");
        }
        if (isFontDown) {
            float x = font.getScaleX() - 0.005f;
            float y = font.getScaleY() - 0.005f;
            if (x <= 0.8f) {
                isFontDown = false;
            } else {
                font.getData().setScale(x, y);
            }
        }

        if (!GameLayout.isDispose) {
            timePause--;
            if (timePause < 0) {
                timePause = timePauseSetting;
                score++;
                if (score % 10 == 0) {
                    font.getData().setScale(1f, 1f);
                    isFontDown = true;
                }
            }
        }
    }
}
