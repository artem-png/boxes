package com.lisuart.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Model.Setting.SettingButtonA;

/**
 * Created by artem on 3/21/18.
 */

public class SettingLayout implements LayoutInterface {
    Sprite sprite = new Sprite(new Texture("menu/bgshadow.png"));
    Sprite rateBg = new Sprite(new Texture("menu/settingBg.png"));
    float yd = (float) Gdx.graphics.getHeight() / (float) com.lisuart.falldown.MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) com.lisuart.falldown.MyGdxGame.width;
    static BitmapFont textFont;
    SettingButtonA settingButtonRight;
    com.lisuart.falldown.Model.Setting.SettingButtonB settingButtonLeft;

    public SettingLayout() {
        com.lisuart.falldown.MyGdxGame.setUp(15, false);
        settingButtonLeft = new com.lisuart.falldown.Model.Setting.SettingButtonB();
        settingButtonRight = new SettingButtonA();
    }

    public static void init() {
        textFont = com.lisuart.falldown.Config.Tex.smallFont3;
    }

    @Override
    public void act(float delta) {
        settingButtonLeft.act();
        settingButtonRight.act();
        if (Gdx.input.justTouched() && !settingButtonRight.isPressed && !settingButtonLeft.isPressed) {
            com.lisuart.falldown.MyGdxGame.layoutManager.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchDynamic.begin();
        com.lisuart.falldown.MyGdxGame.batchDynamic.draw(sprite, -2, -2, com.lisuart.falldown.MyGdxGame.width + 4, com.lisuart.falldown.MyGdxGame.height + 4);
        com.lisuart.falldown.MyGdxGame.batchDynamic.draw(rateBg, 0, 15, com.lisuart.falldown.MyGdxGame.width - 1, com.lisuart.falldown.MyGdxGame.height - 33f);
        settingButtonRight.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        settingButtonLeft.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        com.lisuart.falldown.MyGdxGame.batchDynamic.end();
        com.lisuart.falldown.MyGdxGame.batchFont.begin();
        textFont.setColor(Color.DARK_GRAY);
        textFont.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "MUSIC",
                8 * xd,
                30 * yd
        );
        textFont.draw(
                com.lisuart.falldown.MyGdxGame.batchFont,
                "SOUND",
                28 * xd,
                30 * yd
        );
        com.lisuart.falldown.MyGdxGame.batchFont.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
        rateBg.getTexture().dispose();
        settingButtonLeft.dispose();
        settingButtonRight.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return true;
    }
}
