package com.siminenko.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.Model.Lost.AdText;
import com.siminenko.falldown.Model.Menu.DiamondDisplay;
import com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.falldown.Model.Music.Music;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class LostLayout implements LayoutInterface {
    ModelPicker modelPicker;
    com.siminenko.falldown.ModelGenerator.BackgroundCircle background;
    com.siminenko.falldown.Model.Lost.RestartText restartText;
    AdText adText;
    com.siminenko.falldown.Model.Lost.MoneyText moneyText;
    com.siminenko.falldown.Model.Lost.FailedText failedText;
    com.siminenko.falldown.Model.Lost.MenuIcon menuIcon;
    com.siminenko.falldown.Model.Menu.LevelText levelText;
    DiamondDisplay diamondDisplay;
    int level;

    public boolean record = false;

    public LostLayout(int level) {
        modelPicker = new ModelPicker();
        if (level == 0 && com.siminenko.falldown.Config.Progress.saveScore(com.siminenko.falldown.Model.Infinite.Score.score)) {
            record = true;
        }
        background = new com.siminenko.falldown.ModelGenerator.BackgroundCircle(record ? 3 : 2);
        menuIcon = new com.siminenko.falldown.Model.Lost.MenuIcon();
        restartText = new com.siminenko.falldown.Model.Lost.RestartText(level);
        adText = new AdText(level, record);
        moneyText = new com.siminenko.falldown.Model.Lost.MoneyText(level, record);
        failedText = new com.siminenko.falldown.Model.Lost.FailedText(record);
        levelText = new com.siminenko.falldown.Model.Menu.LevelText(level, Color.DARK_GRAY);
        diamondDisplay = new DiamondDisplay();
        this.level = level;
        MyGdxGame.setUp(15, false);
        Music.music();
        Music.stopMusicGame();
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
        diamondDisplay.act();
        adText.act();
        moneyText.act();
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
        moneyText.render(MyGdxGame.batchDynamic);
        restartText.render(MyGdxGame.batchDynamic);
        diamondDisplay.render(MyGdxGame.batchDynamic);
        adText.render(MyGdxGame.batchDynamic);
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
        diamondDisplay.dispose();
        adText.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
