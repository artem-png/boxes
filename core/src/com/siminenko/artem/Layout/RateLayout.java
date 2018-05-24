package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.siminenko.artem.Config.Info;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Win.CompletedText;
import com.siminenko.artem.Model.Win.NextLevelText;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class RateLayout implements LayoutInterface {
    Sprite sprite = new Sprite(new Texture("menu/bgshadow.png"));
    Sprite rateBg = new Sprite(new Texture("rateBg.png"));
    float yd = (float) Gdx.graphics.getHeight() / (float) MyGdxGame.height;
    float xd = (float) Gdx.graphics.getWidth() / (float) MyGdxGame.width;
    BitmapFont textFont = Tex.generateFont(Color.DARK_GRAY, (int) (2.2f * yd), "smallfont.ttf");
    BitmapFont yesFont = Tex.generateFont(new Color(0.05f, 0.468f, 0, 1), (int) (4f * yd), "smallfont.ttf");
    BitmapFont laterFont = Tex.generateFont(Color.BLACK, (int) (2.7f * yd), "smallfont.ttf");
    BitmapFont neverFont = Tex.generateFont(Color.LIGHT_GRAY, (int) (1.9f * yd), "smallfont.ttf");

    public RateLayout() {

    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        if (Gdx.input.justTouched()) {
            Info.saveRateChoise(Info.RATE_SHOISE_OK);
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
        yesFont.draw(
                MyGdxGame.batchFont,
                "RATE",
                30 * xd,
                20 * yd
        );
        laterFont.draw(
                MyGdxGame.batchFont,
                "LATER",
                14f * xd,
                19.5f * yd
        );
        neverFont.draw(
                MyGdxGame.batchFont,
                "NEVER",
                4f * xd,
                19.2f * yd
        );
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
