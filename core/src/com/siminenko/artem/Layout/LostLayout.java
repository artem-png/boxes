package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Model.Infinite.Score;
import com.siminenko.artem.Model.Level.LevelGetter;
import com.siminenko.artem.Model.Lost.FailedText;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Lost.RestartText;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Menu.PlayButton.PlayButton;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class LostLayout implements LayoutInterface {
    ModelPicker modelPicker;
    BackgroundCircle background;
    RestartText restartText;
    FailedText failedText;
    MenuIcon menuIcon;
    LevelText levelText;
    int level;

    boolean record = false;

    public LostLayout(int level) {
        modelPicker = new ModelPicker();
        if (level == 0 && Progress.saveScore(Score.score)) {
            record = true;
        }
        background = new BackgroundCircle(record ? 3 : 2);
        menuIcon = new MenuIcon();
        restartText = new RestartText(level);
        failedText = new FailedText(record);
        levelText = new LevelText(level, Color.DARK_GRAY);
        this.level = level;
        MyGdxGame.setUp(15, false);
    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        modelPicker.act();
        background.act();
        restartText.act();
        menuIcon.act();
        levelText.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        failedText.render(MyGdxGame.batchDynamic);
        levelText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        restartText.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        restartText.dispose();
        background.dispose();
        failedText.dispose();
        menuIcon.dispose();
        levelText.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
