package com.siminenko.artem.Model.Lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class RestartText {
    static BitmapFont font;
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    Vector2 size = new Vector2(40, 10);
    static Sprite whitebg;
    static float xd;
    static float yd;

    boolean isUpText = false;
    float alpha = 1;
    float alphaDelta = 0.014f;

    int level;

    public RestartText(int level) {
        this.level = level;
    }

    public static void init() {
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = Tex.generateFont(Color.WHITE, (int) (3 * xd), "smallfont.ttf");
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
                isReady = true;
            }
        } else {
            if (Gdx.input.justTouched()) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > MyGdxGame.width / 2 - size.x / 2 - 10 && vector3.x < MyGdxGame.width / 2 + size.x / 2 + 10) {
                    if (vector3.y > MyGdxGame.height / 2 - 7 - size.y / 2 - 5 && vector3.y < MyGdxGame.height / 2 - 7 + size.y / 2 + 5) {
                        MyGdxGame.layoutManager.set(new GameLayout(Progress.getLevelByInt(this.level)));
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, alpha);
        font.draw(
                MyGdxGame.batchFont,
                "TAP TO RESTART",
                0,
                Tex.y * 200,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        MyGdxGame.batchFont.end();
        batch.begin();

        if (isPressed) {
            Color c = batch.getColor();
            batch.setColor(c.r, c.g, c.b, 1f - (float) timePressed / (float) timeSetting);
            batch.draw(this.whitebg, -10, -10, MyGdxGame.width + 20, MyGdxGame.height + 20);
            batch.setColor(c.r, c.g, c.b, 1);
        }
    }

    public void dispose() {

    }
}
