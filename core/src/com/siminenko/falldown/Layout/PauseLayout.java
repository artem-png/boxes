package com.siminenko.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by artem on 3/21/18.
 */

public class PauseLayout implements LayoutInterface {
    com.siminenko.falldown.ModelGenerator.BackgroundCircle backgroundCircle;
    com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker modelPicker;
    com.siminenko.falldown.Model.Lost.MenuIcon menuIcon;
    com.siminenko.falldown.Model.Pause.ContinueButton continueButton;
    com.siminenko.falldown.Model.Pause.PausedText pausedText;
    com.siminenko.falldown.Model.Menu.LevelText levelText;
    com.siminenko.falldown.Model.Menu.DiamondDisplay diamondDisplay;

    int level;

    public PauseLayout(int level) {
        backgroundCircle = new com.siminenko.falldown.ModelGenerator.BackgroundCircle(1);
        modelPicker = new com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker();
        menuIcon = new com.siminenko.falldown.Model.Lost.MenuIcon();
        menuIcon.disposeAll = true;
        pausedText = new com.siminenko.falldown.Model.Pause.PausedText();
        continueButton = new com.siminenko.falldown.Model.Pause.ContinueButton();
        diamondDisplay = new com.siminenko.falldown.Model.Menu.DiamondDisplay();
        this.level = level;
        levelText = new com.siminenko.falldown.Model.Menu.LevelText(level, Color.DARK_GRAY);
        com.siminenko.falldown.MyGdxGame.setUp(15, false);
        com.siminenko.falldown.Model.Music.Music.music();
        com.siminenko.falldown.Model.Music.Music.stopMusicGame();


    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        backgroundCircle.act();
        modelPicker.act();
        menuIcon.act();
        continueButton.act();
        pausedText.act();
        diamondDisplay.act();
        levelText.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        com.siminenko.falldown.MyGdxGame.batchDynamic.begin();
        backgroundCircle.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        modelPicker.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        pausedText.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        levelText.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        menuIcon.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        continueButton.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        diamondDisplay.render(com.siminenko.falldown.MyGdxGame.batchDynamic);
        com.siminenko.falldown.MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        backgroundCircle.dispose();
        modelPicker.dispose();
        pausedText.dispose();
        levelText.dispose();
        menuIcon.dispose();
        continueButton.dispose();
        diamondDisplay.dispose();

        com.siminenko.falldown.Model.Music.Music.stopMusic();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
