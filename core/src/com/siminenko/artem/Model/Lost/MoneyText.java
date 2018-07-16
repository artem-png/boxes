package com.siminenko.artem.Model.Lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Music.Music;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class MoneyText {
    boolean isReady = false;
    boolean isPressed = false;
    int timeSetting = 20;
    int timePressed = timeSetting;
    static float xd;
    static float yd;

    boolean isUpText = false;
    float alpha = 1;
    float alphaDelta = 0.014f;

    Sprite button;
    Sprite icon;
    Sprite play;

    int level;

    Vector2 position = new Vector2(MyGdxGame.width / 2 + 8, MyGdxGame.height / 2 - 25);
    Vector2 size = new Vector2(8, 8);

    float a = 0;
    float da = 0.13f;

    boolean record;

    int needDiamonds = 1;

    public MoneyText(int level, boolean record) {
        this.level = level;
        this.record = record;

        button = Tex.button;
        icon = new Sprite(new Texture("menu/cinema.png"));
        play = new Sprite(new Texture("menu/play.png"));
        needDiamonds *= GameLayout.restartMoneyCount + 1;
        init();
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
    }

    public void act() {
        if (Progress.diamonds >= this.needDiamonds) {
            a += da;
            size.add((float) Math.cos(a) / 10f, (float) Math.cos(a) / 10f);
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
        }
        if (isPressed) {
            timePressed--;
            if (timePressed <= 1) {
                MyGdxGame.layoutManager.pop();
                GameLayout.restartMoneyCount += 1;
                isReady = true;
                Music.stopMusic();
                Music.musicGame();
            }
        } else {
            if (Gdx.input.justTouched() && GameLayout.restartCount == 0) {
                Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x / 2 - 3 && vector3.x < position.x + size.x / 2 + 3) {
                    if (vector3.y < position.y + size.y / 2) {
                        if (Progress.diamonds >= this.needDiamonds) {
                            Progress.minusDiamond(this.needDiamonds);
                        } else {
                            return;
                        }
                        isPressed = true;
                        MyGdxGame.setUp(20, true);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (Progress.diamonds < this.needDiamonds) {
            batch.setColor(0.4f, 0.4f, 0.4f, 1f);
            Tex.smallFont3.setColor(0.4f, 0.4f, 0.4f, 1f);
        }
        if (record) {
            batch.setColor(Color.CORAL);
        }
        batch.draw(button, position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
        if (record) {
            batch.setColor(1, 1, 1, 1);
        }
        batch.end();
        MyGdxGame.batchFont.begin();
        Tex.smallFont3.draw(MyGdxGame.batchFont, "" + needDiamonds, 500 * Tex.x, (position.y - 5f) * yd, 80 * Tex.x, 1, true);
        MyGdxGame.batchFont.end();
        batch.begin();
        batch.draw(play, position.x - size.x * 0.3f / 2 - (float) Math.cos(a) / 7f + 2.3f, position.y - size.y * 0.3f / 2, size.x * 0.3f, size.y * 0.3f);
        batch.draw(play, position.x - size.x * 0.3f / 2 - (float) Math.cos(a) / 7f - 2.3f, position.y - size.y * 0.3f / 2, size.x * 0.3f, size.y * 0.3f);
        batch.draw(Tex.diamond, position.x - 1f, position.y - 2.8f, 2, 3);
        if (Progress.diamonds < this.needDiamonds) {
            batch.setColor(1, 1, 1, 1);
            Tex.smallFont3.setColor(1, 1, 1, 1);
        }
    }

    public void dispose() {

    }
}
