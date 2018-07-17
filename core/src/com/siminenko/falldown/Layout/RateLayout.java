package com.siminenko.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class RateLayout implements LayoutInterface {
    Sprite sprite = new Sprite(new Texture("menu/bgshadow.png"));
    Sprite rateBg = new Sprite(new Texture("rateBg.png"));
    float yd = (float) Gdx.graphics.getHeight() / (float) MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) MyGdxGame.width;
    static BitmapFont textFont;
    static BitmapFont yesFont;

    public RateLayout() {
        if (textFont == null) {
            textFont = Tex.generateFont(Color.DARK_GRAY, (int) (2.2f * yd), "smallfont.ttf");
        }
        if (yesFont == null) {
            yesFont = Tex.generateFont(new Color(0.05f, 0.468f, 0, 1), (int) (3.5f * yd), "smallfont.ttf");
        }
    }

    public static void init() {
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.justTouched()) {
            Vector3 vector3 = MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > 0 && vector3.x < 15 && vector3.y > 15 && vector3.y < 22) {
                com.siminenko.falldown.Config.Info.saveRateChoise(com.siminenko.falldown.Config.Info.RATE_SHOISE_NEVER);
            }
            if (vector3.x > 15 && vector3.x < 30 && vector3.y > 15 && vector3.y < 22) {
                com.siminenko.falldown.Config.Info.saveRateChoise(com.siminenko.falldown.Config.Info.RATE_SHOISE_LATER);
            }
            if (vector3.x > 30 && vector3.x < MyGdxGame.width && vector3.y > 15 && vector3.y < 22) {
                com.siminenko.falldown.Config.Info.saveRateChoise(com.siminenko.falldown.Config.Info.RATE_SHOISE_OK);
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.lisuart.falldown");
            }
            MyGdxGame.layoutManager.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        MyGdxGame.batchDynamic.draw(sprite, -2, -2, MyGdxGame.width + 4, MyGdxGame.height + 4);
        MyGdxGame.batchDynamic.draw(rateBg, 0, 15, MyGdxGame.width - 1, MyGdxGame.height - 33f);
        MyGdxGame.batchDynamic.end();
        MyGdxGame.batchFont.begin();
        textFont.draw(
                MyGdxGame.batchFont,
                "Enjoying the RiseDown app? Recommend us to others by leaving us a review",
                5 * xd,
                30 * yd,
                (MyGdxGame.width - 10) * xd,
                1,
                true
        );
        yesFont.setColor(new Color(0.05f, 0.468f, 0, 1));
        yesFont.draw(
                MyGdxGame.batchFont,
                "RATE",
                32.5f * xd,
                20 * yd
        );
        yesFont.setColor(Color.BLACK);
        yesFont.draw(
                MyGdxGame.batchFont,
                "LATER",
                17.5f * xd,
                20 * yd
        );
        yesFont.draw(
                MyGdxGame.batchFont,
                "NEVER",
                2.5f * xd,
                20 * yd
        );
        MyGdxGame.batchFont.setColor(1, 1, 1, 1);
        MyGdxGame.batchFont.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
        rateBg.getTexture().dispose();
    }

    @Override
    public boolean getIsParralel() {
        return true;
    }
}
