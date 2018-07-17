package com.siminenko.falldown.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.Config.Tex;
import com.siminenko.falldown.Model.Setting.SettingButtonB;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class SettingLayout implements LayoutInterface {
    Sprite sprite = new Sprite(new Texture("menu/bgshadow.png"));
    Sprite rateBg = new Sprite(new Texture("menu/settingBg.png"));
    float yd = (float) Gdx.graphics.getHeight() / (float) MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) MyGdxGame.width;
    static BitmapFont textFont;
    com.siminenko.falldown.Model.Setting.SettingButtonA settingButtonRight;
    SettingButtonB settingButtonLeft;

    public SettingLayout() {
        MyGdxGame.setUp(15, false);
        settingButtonLeft = new SettingButtonB();
        settingButtonRight = new com.siminenko.falldown.Model.Setting.SettingButtonA();
    }

    public static void init() {
        textFont = Tex.smallFont3;
    }

    @Override
    public void act(float delta) {
        settingButtonLeft.act();
        settingButtonRight.act();
        if (Gdx.input.justTouched() && !settingButtonRight.isPressed && !settingButtonLeft.isPressed) {
            MyGdxGame.layoutManager.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        MyGdxGame.batchDynamic.draw(sprite, -2, -2, MyGdxGame.width + 4, MyGdxGame.height + 4);
        MyGdxGame.batchDynamic.draw(rateBg, 0, 15, MyGdxGame.width - 1, MyGdxGame.height - 33f);
        settingButtonRight.render(MyGdxGame.batchDynamic);
        settingButtonLeft.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        MyGdxGame.batchFont.begin();
        textFont.setColor(Color.DARK_GRAY);
        textFont.draw(
                MyGdxGame.batchFont,
                "MUSIC",
                8 * xd,
                30 * yd
        );
        textFont.draw(
                MyGdxGame.batchFont,
                "SOUND",
                28 * xd,
                30 * yd
        );
        MyGdxGame.batchFont.end();
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
