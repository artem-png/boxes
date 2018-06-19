package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Model.Lost.FailedText;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Lost.RestartText;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Win.CompletedText;
import com.siminenko.artem.Model.Win.NextLevelText;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class WinLayout implements LayoutInterface {
    ModelPicker modelPicker;
    BackgroundCircle background;
    NextLevelText continueText;
    CompletedText successText;
    MenuIcon menuIcon;
    LevelText levelText;
    int level;

    public WinLayout(int level) {
        modelPicker = new ModelPicker();
        background = new BackgroundCircle(3);
        menuIcon = new MenuIcon();
        continueText = new NextLevelText(level);
        successText = new CompletedText();
        levelText = new LevelText(level - 1, Color.DARK_GRAY);
        this.level = level;
        MyGdxGame.setUp(15, false);
    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        modelPicker.act();
        background.act();
        continueText.act();
        menuIcon.act();
        levelText.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        successText.render(MyGdxGame.batchDynamic);
        levelText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        continueText.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        continueText.dispose();
        modelPicker.dispose();
        successText.dispose();
        menuIcon.dispose();
        background.dispose();
        levelText.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
