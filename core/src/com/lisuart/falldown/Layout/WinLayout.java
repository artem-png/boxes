package com.lisuart.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Model.Lost.MenuIcon;
import com.lisuart.falldown.Model.Menu.DiamondDisplay;
import com.lisuart.falldown.Model.Menu.LevelText;
import com.lisuart.falldown.Model.Menu.ModelPickerModels.ModelPicker;
import com.lisuart.falldown.Model.Music.Music;
import com.lisuart.falldown.Model.Win.CompletedText;
import com.lisuart.falldown.Model.Win.NextLevelText;
import com.lisuart.falldown.Model.Win.PlusDiamondText;
import com.lisuart.falldown.ModelGenerator.BackgroundCircle;
import com.lisuart.falldown.MyGdxGame;

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
    DiamondDisplay diamondDisplay;
    PlusDiamondText plusDiamondText;
    int level;

    boolean newVictory;

    public WinLayout(int level, boolean newVictory) {
        modelPicker = new ModelPicker();
        background = new BackgroundCircle(3);
        menuIcon = new MenuIcon();
        continueText = new NextLevelText(level);
        successText = new CompletedText();
        diamondDisplay = new DiamondDisplay();
        levelText = new LevelText(level - 1, Color.DARK_GRAY);
        plusDiamondText = new PlusDiamondText();
        this.level = level;
        MyGdxGame.setUp(15, false);
        this.newVictory = newVictory;
        Music.music();
        Music.stopMusicGame();
        MyGdxGame.adsController.showBannerAd();
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
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        successText.render(MyGdxGame.batchDynamic);
        levelText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        continueText.render(MyGdxGame.batchDynamic);
        diamondDisplay.render(MyGdxGame.batchDynamic);
        if (newVictory) {
            plusDiamondText.render(MyGdxGame.batchDynamic);
        }
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
        diamondDisplay.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
