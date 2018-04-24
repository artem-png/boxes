package com.siminenko.artem.Model.LevelLayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 4/24/18.
 */

public class LevelGenerator {
    int firstLevel;
    int levelCount;
    static Sprite level;
    static BitmapFont font;
    static float xd;
    static float yd;

    static Sprite whitebg;
    int timeSetting = 15;
    int timePressed = timeSetting;

    boolean isPressed = false;

    int chosenlevel;

    public LevelGenerator(int beginLevel) {
        firstLevel = beginLevel;
        levelCount = Progress.levels.length;
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
    }

    public static void init() {
        level = new Sprite(new Texture("levels/levelPreview.png"));
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = Tex.generateFont(Color.BLACK, (int)(2.6 * xd), "smallfont.ttf");
    }

    public void setLevel(int beginLevel) {
        this.firstLevel = beginLevel;
    }

    public void render(SpriteBatch batch) {
        int a = firstLevel;
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (a <= levelCount) {
                    batch.draw(
                            level,
                            j * 13 + 5.5f,
                            i * 11 + 13,
                            8,
                            8
                    );
                    batch.end();
                    MyGdxGame.batchFont.begin();
                    font.draw(
                            MyGdxGame.batchFont,
                            a + "",
                            (j * 13 + 5.5f) * xd,
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
        if (timePressed > 0 && isPressed) {
            Color c = MyGdxGame.batchDynamic.getColor();
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1 - (float) timePressed / (float) timeSetting);
            MyGdxGame.batchDynamic.draw(this.whitebg, -10, -10, MyGdxGame.width + 20, MyGdxGame.height + 20);
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1);
        }
    }

    public void act() {
        if (isPressed) {
            timePressed --;
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
