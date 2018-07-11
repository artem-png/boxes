package com.siminenko.artem.Model.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;
import java.util.Vector;

/**
 * Created by artem on 4/23/18.
 */

public class GameNameText {
    Vector2 positionFirst = new Vector2(-30 / Tex.x, Gdx.graphics.getHeight() / 1.22f);
    Vector2 positionSecond = new Vector2(30 / Tex.x, Gdx.graphics.getHeight() / 1.34f);

    float a = 0;
    float da = 0.07f;

    float b = 0.5f;
    float db = 0.03f;

    Vector<Vector2> lettersPosition = new Vector<Vector2>();
    Vector<Vector2> lettersAlpha = new Vector<Vector2>();
    Vector<Vector2> lettersSize = new Vector<Vector2>();
    Vector<Color> lettersColor = new Vector<Color>();
    Vector<String> letters = new Vector<String>();

    int timeSetting = 40;
    int time = timeSetting;

    Random random = new Random();

    int count = 0;

    String ab = "FALLDOWN";

    public GameNameText() {

    }

    public void act() {
        time--;
        if (time < 0) {
            time = timeSetting;
            lettersPosition.add(new Vector2(random.nextInt((int) (Gdx.graphics.getWidth() * 0.6f)) - Gdx.graphics.getWidth() * 0.6f / 2, Gdx.graphics.getHeight() / 1.2f));
            lettersAlpha.add(new Vector2(0, 0));
            lettersSize.add(new Vector2(1, 1));
            lettersColor.add(Color.BLACK);
            int result = count % 8;
            letters.add(String.valueOf(ab.charAt(result)));
            count++;
        }

        for (int i = lettersPosition.size() - 1; i >= 0; i--) {
            lettersPosition.get(i).add(0, -1f);
            if (lettersAlpha.get(i).y == 0) {
                lettersAlpha.get(i).add(0.01f, 0);
                if (lettersAlpha.get(i).x >= 0.6f) {
                    lettersAlpha.get(i).y = 1;
                }
            } else {
                lettersAlpha.get(i).add(-0.01f, 0);
                if (lettersAlpha.get(i).x < 0) {
                    lettersAlpha.remove(i);
                    lettersPosition.remove(i);
                    lettersSize.remove(i);
                    lettersColor.remove(i);
                    letters.remove(i);
                }
            }
        }

        a += da;
        b += db;
        positionFirst.add((float) Math.cos(a) / 3, (float) Math.cos(b) / 4);
        positionSecond.add(-(float) Math.cos(a) / 3, (float) Math.cos(b) / 4);
    }

    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchFont.begin();
        Tex.loadingFont.setColor(Color.BLACK);
        Tex.loadingFont.getData().setScale(0.8f, 0.8f);
        Tex.loadingFont.draw(MyGdxGame.batchFont, "FALL", positionFirst.x, positionFirst.y, Gdx.graphics.getWidth(), 1, true);
        Tex.loadingFont.draw(MyGdxGame.batchFont, "DOWN", positionSecond.x, positionSecond.y, Gdx.graphics.getWidth(), 1, true);
        Tex.loadingFont.getData().setScale(1, 1);
        Tex.loadingFont.setColor(Color.BLACK);
        for (int i = 0; i < lettersPosition.size(); i++) {
            Tex.smallFont35.setColor(lettersColor.get(i));
            Tex.smallFont35.setColor(Tex.smallFont35.getColor().r, Tex.smallFont35.getColor().g, Tex.smallFont35.getColor().b, lettersAlpha.get(i).x);
            Tex.smallFont35.getData().setScale(lettersSize.get(i).x, lettersSize.get(i).y);
            Tex.smallFont35.draw(MyGdxGame.batchFont, letters.get(i), lettersPosition.get(i).x, lettersPosition.get(i).y, Gdx.graphics.getWidth(), 1, true);
        }
        Tex.smallFont35.setColor(Color.WHITE);
        Tex.smallFont35.getData().setScale(1, 1);
        MyGdxGame.batchFont.end();
        batch.begin();
    }
}
