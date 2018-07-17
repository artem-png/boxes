package com.siminenko.falldown.Model.LevelLayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.falldown.Config.Progress;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Layout.GameLayout;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 4/24/18.
 */

public class LevelGenerator {
    int firstLevel;
    int levelCount;
    static Sprite level;
    static Sprite crown;
    static BitmapFont font;
    static float xd;
    static float yd;

    int timeSetting = 15;
    int timePressed = timeSetting;

    boolean isPressed = false;

    int chosenlevel;

    public LevelGenerator(int beginLevel) {
        firstLevel = beginLevel;
        levelCount = Progress.levels.length;

        if (font == null) {
            font = Tex.smallFont28;
        }
    }

    public static void init() {
        level = new Sprite(new Texture("levels/levelPreview.png"));
        crown = new Sprite(new Texture("crown.png"));
        xd = (float) Gdx.graphics.getWidth() / (float) MyGdxGame.width;
        yd = (float) Gdx.graphics.getHeight() / (float) MyGdxGame.width;
    }

    public void setLevel(int beginLevel) {
        this.firstLevel = beginLevel;
    }

    public void render(SpriteBatch batch) {
        int a = firstLevel;
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < 3; j++) {
                Color c = batch.getColor();
                if (i == 4) {
                    batch.setColor(0.98f, 0.79f, 0.35f, 1);
                } else if (i == 3) {
                    batch.setColor(0.8f, 0.789f, 0.628f, 1);
                } else if (i == 2) {
                    batch.setColor(0.589f, 0.88f, 0.55f, 1);
                } else if (i == 1) {
                    batch.setColor(0.47f, 0.83f, 0.81f, 1);
                }
                if (a <= levelCount) {
                    batch.draw(
                            level,
                            j * 13 + 5.5f,
                            i * 11 + 13,
                            8,
                            8
                    );
                    batch.setColor(c);
                    if (Progress.levels[a - 1] == 1) {
                        batch.draw(
                                crown,
                                j * 13 + 9.5f,
                                i * 11 + 17.5f,
                                3f,
                                3f,
                                6,
                                6,
                                crown.getScaleX(),
                                crown.getScaleY(),
                                -37
                        );
                    }
                    batch.end();
                    MyGdxGame.batchFont.begin();
                    font.setColor(Color.WHITE);
                    font.draw(
                            MyGdxGame.batchFont,
                            a + "",
                            (j * 13 + 5.4f) * xd,
                            (i * 6.17f + 10.2f) * yd,
                            9.4f * xd,
                            1,
                            false
                    );
                    MyGdxGame.batchFont.end();
                    batch.begin();
                    a++;
                }
            }
        }
    }

    public void act() {
        if (isPressed) {
            timePressed--;
            if (timePressed <= 0) {
                MyGdxGame.layoutManager.set(new GameLayout(Progress.getLevelByInt(chosenlevel)));
            }
        }
        int a = firstLevel;
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (a <= levelCount) {
                    if (Gdx.input.justTouched()) {
                        Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                        if (vector3.x > j * 13 + 5.5f && vector3.x < j * 13 + 5.5f + 8) {
                            if (vector3.y > i * 11 + 13 && vector3.y < i * 11 + 13 + 8) {
                                chosenlevel = a;
                                isPressed = true;
                                MyGdxGame.setUp(15, true);
                            }
                        }
                    }
                    a++;
                }
            }
        }
    }

    public void dispose() {

    }
}
