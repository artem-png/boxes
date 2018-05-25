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
import com.siminenko.artem.Model.Infinite.Score;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class FailedText {
    static BitmapFont font;
    static float xd;
    static float yd;
    public boolean record = false;

    String string;


    public FailedText(boolean record) {
        this.record = record;
        string = getText();
    }

    public static void init() {
        xd = Gdx.graphics.getWidth() / MyGdxGame.width;
        yd = Gdx.graphics.getHeight() / MyGdxGame.width;
        font = Tex.generateFont(Color.WHITE, (int) (7 * xd), "bigfont.ttf");
    }

    public void act() {

    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        font.draw(
                MyGdxGame.batchFont,
                string,
                0,
                Tex.y * 400,
                Gdx.graphics.getWidth(),
                1,
                false
        );
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    public String getText() {
        if (record) {
            return "new result!";
        }
        Random random = new Random();
        int result = random.nextInt(4);
        if (result == 0) {
            return "FAILED";
        } else if (result == 1) {
            return "OOPS..";
        } else if (result == 2) {
            return "YOU LOST";
        } else {
            return "TRY AGAIN";
        }
    }

    public void dispose() {
    }
}
