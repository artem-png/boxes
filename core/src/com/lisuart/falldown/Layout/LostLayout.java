package com.lisuart.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Model.Infinite.Score;
import com.lisuart.falldown.Model.Lost.FailedText;
import com.lisuart.falldown.Model.Lost.MenuIcon;
import com.lisuart.falldown.Model.Lost.MoneyText;
import com.lisuart.falldown.Model.Lost.RestartText;
import com.lisuart.falldown.Model.Menu.LevelText;
import com.lisuart.falldown.ModelGenerator.BackgroundCircle;

/**
 * Created by artem on 3/21/18.
 */

public class LostLayout implements LayoutInterface {
    com.lisuart.falldown.Model.Menu.ModelPickerModels.ModelPicker modelPicker;
    BackgroundCircle background;
    RestartText restartText;
    com.lisuart.falldown.Model.Lost.AdText adText;
    MoneyText moneyText;
    FailedText failedText;
    MenuIcon menuIcon;
    LevelText levelText;
    com.lisuart.falldown.Model.Menu.DiamondDisplay diamondDisplay;
    int level;

    public boolean record = false;

    public LostLayout(int level) {
        modelPicker = new com.lisuart.falldown.Model.Menu.ModelPickerModels.ModelPicker();
        if (level == 0 && Progress.saveScore(Score.score)) {
            record = true;
        }
        background = new BackgroundCircle(record ? 3 : 2);
        menuIcon = new MenuIcon();
        restartText = new RestartText(level);
        adText = new com.lisuart.falldown.Model.Lost.AdText(level, record);
        moneyText = new MoneyText(level, record);
        failedText = new FailedText(record);
        levelText = new LevelText(level, Color.DARK_GRAY);
        diamondDisplay = new com.lisuart.falldown.Model.Menu.DiamondDisplay();
        this.level = level;
        com.lisuart.falldown.MyGdxGame.setUp(15, false);
        com.lisuart.falldown.Model.Music.Music.music();
        com.lisuart.falldown.Model.Music.Music.stopMusicGame();
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
        com.lisuart.falldown.MyGdxGame.batchDynamic.begin();
        background.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        modelPicker.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        failedText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        levelText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        menuIcon.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        moneyText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        restartText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        diamondDisplay.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        adText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        com.lisuart.falldown.MyGdxGame.batchDynamic.end();
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
