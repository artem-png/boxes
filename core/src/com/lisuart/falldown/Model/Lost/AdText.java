package com.lisuart.falldown.Model.Lost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Layout.PauseLayout;
import com.lisuart.falldown.Model.Music.Music;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class AdText {
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

    Vector2 position = new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 8, com.lisuart.falldown.MyGdxGame.height / 2 - 25);
    Vector2 size = new Vector2(8, 8);

    float a = 0;
    float da = 0.13f;

    boolean record;

    boolean hasInternet = false;

    public static boolean isViewed = false;
    public int time = 20;

    public AdText(int level, boolean record) {
        this.level = level;
        this.record = record;

        button = com.lisuart.falldown.Config.Tex.button;
        icon = new Sprite(new Texture("menu/cinema.png"));
        play = new Sprite(new Texture("menu/play.png"));

        this.hasInternet = MyGdxGame.adsController.hasInternet();
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / com.lisuart.falldown.MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / com.lisuart.falldown.MyGdxGame.width;
    }

    public void act() {
        if (isViewed) {
            if (time == 20) {
                com.lisuart.falldown.MyGdxGame.setUp(20, true);
            }
            time--;
            if (time < 0) {
                MyGdxGame.layoutManager.pop();
                MyGdxGame.layoutManager.push(new PauseLayout(level));
                GameLayout.restartCount = 1;
                isReady = true;
                isViewed = false;
            }
        }
        if (GameLayout.restartCount == 0 && this.hasInternet) {
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
                isPressed = false;
                com.lisuart.falldown.MyGdxGame.rewardAds.showRewardedVideoAd();
                Music.stopMusic();
                Music.musicGame();
            }
        } else {
            if (Gdx.input.justTouched() && GameLayout.restartCount == 0) {
                Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

                if (vector3.x > position.x - size.x / 2 - 3 && vector3.x < position.x + size.x / 2 + 3) {
                    if (vector3.y < position.y + size.y / 2) {
                        isPressed = true;
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        if (GameLayout.restartCount == 1 || !this.hasInternet) {
            batch.setColor(0.4f, 0.4f, 0.4f, 1f);
        }
        if (record) {
            batch.setColor(Color.CORAL);
        }
        batch.draw(button, position.x - size.x / 2, position.y - size.y / 2, size.x, size.y);
        if (record) {
            batch.setColor(1, 1, 1, 1);
        }
        batch.draw(icon, position.x - size.x * 0.7f / 2, position.y - size.y * 0.7f / 2, size.x * 0.7f, size.y * 0.7f);
        batch.draw(play, position.x - size.x * 0.3f / 2 - (float) Math.cos(a) / 7f + 1f, position.y - size.y * 0.3f / 2, size.x * 0.3f, size.y * 0.3f);
        batch.draw(play, position.x - size.x * 0.3f / 2 - (float) Math.cos(a) / 7f - 1f, position.y - size.y * 0.3f / 2, size.x * 0.3f, size.y * 0.3f);
        if (GameLayout.restartCount == 1 || !this.hasInternet) {
            batch.setColor(1, 1, 1, 1);
        }
    }

    public void dispose() {

    }
}
