package com.siminenko.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by artem on 3/21/18.
 */

public class WinLayout implements LayoutInterface {
    com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker modelPicker;
    com.siminenko.falldown.ModelGenerator.BackgroundCircle background;
    com.siminenko.falldown.Model.Win.NextLevelText continueText;
    com.siminenko.falldown.Model.Win.CompletedText successText;
    com.siminenko.falldown.Model.Lost.MenuIcon menuIcon;
    com.siminenko.falldown.Model.Menu.LevelText levelText;
    com.siminenko.falldown.Model.Menu.DiamondDisplay diamondDisplay;
    com.siminenko.falldown.Model.Win.PlusDiamondText plusDiamondText;
    int level;

    boolean newVictory;

    public WinLayout(int level, boolean newVictory) {
        modelPicker = new com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker();
        background = new com.siminenko.falldown.ModelGenerator.BackgroundCircle(3);
        menuIcon = new com.siminenko.falldown.Model.Lost.MenuIcon();
        continueText = new com.siminenko.falldown.Model.Win.NextLevelText(level);
        successText = new com.siminenko.falldown.Model.Win.CompletedText();
        diamondDisplay = new com.siminenko.falldown.Model.Menu.DiamondDisplay();
        levelText = new com.siminenko.falldown.Model.Menu.LevelText(level - 1, Color.DARK_GRAY);
        plusDiamondText = new com.siminenko.falldown.Model.Win.PlusDiamondText();
        this.level = level;
        com.siminenko.falldown.MyGdxGame.setUp(15, false);
        this.newVictory = newVictory;
        com.siminenko.falldown.Model.Music.Music.music();
        com.siminenko.falldown.Model.Music.Music.stopMusicGame();
        com.siminenko.falldown.MyGdxGame.adsController.showBannerAd();
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
        diamondDisplay.act();
        plusDiamondText.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        com.siminenko.falldown.MyGdxGame.batchDynamic.begin();
        background.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        modelPicker.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        successText.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        levelText.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        menuIcon.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        continueText.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        diamondDisplay.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        if (newVictory) {
            plusDiamondText.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        }
        com.siminenko.falldown.MyGdxGame.batchDynamic.end();
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
        diamondDisplay.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
