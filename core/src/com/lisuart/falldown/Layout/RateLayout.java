package com.lisuart.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.lisuart.falldown.Config.Info;

/**
 * Created by artem on 3/21/18.
 */

public class RateLayout implements LayoutInterface {
    Sprite sprite = new Sprite(new Texture("menu/bgshadow.png"));
    Sprite rateBg = new Sprite(new Texture("rateBg.png"));
    float yd = (float) Gdx.graphics.getHeight() / (float) com.lisuart.falldown.MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) com.lisuart.falldown.MyGdxGame.width;
    static BitmapFont textFont;
    static BitmapFont yesFont;

    public RateLayout() {
        if (textFont == null) {
            textFont = com.lisuart.falldown.Config.Tex.generateFont(Color.DARK_GRAY, (int) (2.2f * yd), "smallfont.ttf");
        }
        if (yesFont == null) {
            yesFont = com.lisuart.falldown.Config.Tex.generateFont(new Color(0.05f, 0.468f, 0, 1), (int) (3.5f * yd), "smallfont.ttf");
        }
    }

    public static void init() {
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.justTouched()) {
            Vector3 vector3 = com.lisuart.falldown.MyGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            if (vector3.x > 0 && vector3.x < 15 && vector3.y > 15 && vector3.y < 22) {
                Info.saveRateChoise(Info.RATE_SHOISE_NEVER);
            }
            if (vector3.x > 15 && vector3.x < 30 && vector3.y > 15 && vector3.y < 22) {
                Info.saveRateChoise(Info.RATE_SHOISE_LATER);
            }
            if (vector3.x > 30 && vector3.x < com.lisuart.falldown.MyGdxGame.width && vector3.y > 15 && vector3.y < 22) {
                Info.saveRateChoise(Info.RATE_SHOISE_OK);
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.lisuart.falldown");
            }
            com.lisuart.falldown.MyGdxGame.layoutManager.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchDynamic.begin();
        com.lisuart.falldown.MyGdxGame.batchDynamic.draw(sprite, -2, -2, com.lisuart.falldown.MyGdxGame.width + 2, com.lisuart.falldown.MyGdxGame.height + 4);
        com.lisuart.falldown.MyGdxGame.batchDynamic.draw(rateBg, 1, 15, com.lisuart.falldown.MyGdxGame.width - 3, com.lisuart.falldown.MyGdxGame.height - 37f);
        com.lisuart.falldown.MyGdxGame.batchDynamic.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        textFont.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "Enjoying the FallDown app? Recommend us to others by leaving us a review:)",
                5 * xd,
                30 * yd,
                (com.lisuart.falldown.MyGdxGame.width - 10) * xd,
                1,
                true
        );
        yesFont.setColor(new Color(0.05f, 0.468f, 0, 1));
        yesFont.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "RATE",
                32.5f * xd,
                20 * yd
        );
        yesFont.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "LATER",
                17.5f * xd,
                20 * yd
        );
        yesFont.setColor(Color.BLACK);
        yesFont.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "NEVER",
                2.5f * xd,
                20 * yd
        );
        com.lisuart.falldown.MyGdxGame.batchFont.setColor(1, 1, 1, 1);
        com.lisuart.falldown.MyGdxGame.batchFont.end();
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
