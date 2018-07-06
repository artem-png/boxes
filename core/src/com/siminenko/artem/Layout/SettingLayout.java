package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Info;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Setting.SettingButtonA;
import com.siminenko.artem.Model.Setting.SettingButtonB;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class SettingLayout implements LayoutInterface {
    Sprite sprite = new Sprite(new Texture("menu/bgshadow.png"));
    Sprite rateBg = new Sprite(new Texture("menu/settingBg.png"));
    float yd = (float) Gdx.graphics.getHeight() / (float) MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) MyGdxGame.width;
    static BitmapFont textFont;
    SettingButtonA settingButtonRight;
    SettingButtonB settingButtonLeft;

    public SettingLayout() {
        MyGdxGame.setUp(15, false);
        settingButtonLeft = new SettingButtonB();
        settingButtonRight = new SettingButtonA();
        Progress.setTheme(Progress.theme + 1 > 2 ? 0 : Progress.theme + 1);

        if (textFont == null) {
            textFont = Tex.generateFont(Color.DARK_GRAY, (int) (3f * yd), "smallfont.ttf");
        }
    }

    public static void init() {
        float yd = (float) Gdx.graphics.getHeight() / (float) MyGdxGame.height;
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
