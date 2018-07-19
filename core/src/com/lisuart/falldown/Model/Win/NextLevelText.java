package com.lisuart.falldown.Model.Win;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Config.Progress;

/**
 * Created by User on 22.04.2018.
 */

public class NextLevelText {
    static BitmapFont font;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    Vector2 size = new Vector2(40, 10);
    static float xd;
    static float yd;

    boolean isUpText = false;
    float alpha = 1;
    float alphaDelta = 0.014f;

    int level;

    public NextLevelText(int level) {
        this.level = level;
        if  (font == null) {
            font = com.lisuart.falldown.Config.Tex.smallFont3;
        }
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
    }

    public void act() {
        if (isUpText) {
            alpha += alphaDelta;
            if (alpha >= 1) {
                isUpText = false;
                alpha = 1;
            }
        } else {
            alpha -= alphaDelta;
            if (alpha <= 0) {
                isUpText = true;
                alpha = 0;
            }
        }
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                com.lisuart.falldown.MyGdxGame.layoutManager.set(new com.lisuart.falldown.Layout.GameLayout(Progress.getLevelByInt(this.level)));
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > com.lisuart.falldown.MyGdxGame.width / 2 - size.x / 2 - 10 && vector3.x < com.lisuart.falldown.MyGdxGame.width / 2 + size.x / 2 + 10) {
                    if (vector3.y > com.lisuart.falldown.MyGdxGame.height / 2 - 22 - size.y / 2 - 5 && vector3.y < com.lisuart.falldown.MyGdxGame.height / 2 - 7 + size.y / 2) {
                        isPressed = true;
                        com.lisuart.falldown.MyGdxGame.setUp(20, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        font.setColor(Color.DARK_GRAY);
        font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, alpha);
        font.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "TAP TO CONTINUE",
                0,
                com.lisuart.falldown.Config.Tex.y * 190,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        font.setColor(Color.WHITE);
        font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, 1);
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    public void dispose() {

    }
}
