package com.siminenko.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.Model.Menu.PlayButton.PlayButton;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class MenuLayout implements LayoutInterface {
    com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker modelPicker;
    com.siminenko.falldown.ModelGenerator.BackgroundCircle background;
    PlayButton playButton;
    com.siminenko.falldown.Model.Menu.LevelText levelText;
    com.siminenko.falldown.Model.Menu.PlayButton.LevelButton levelButton;
    com.siminenko.falldown.Model.Menu.PlayButton.InfiniteButton infiniteButton;
    com.siminenko.falldown.Model.Menu.DiamondDisplay diamondDisplay;
    com.siminenko.falldown.Model.Menu.PlayButton.SettingButton settingButton;
    com.siminenko.falldown.Model.Menu.PlayButton.CustomizeButton customizeButton;
    com.siminenko.falldown.Model.Menu.GameNameText gameNameText;


    public MenuLayout() {
        modelPicker = new com.siminenko.falldown.Model.Menu.ModelPickerModels.ModelPicker();
        background = new com.siminenko.falldown.ModelGenerator.BackgroundCircle(1);
        playButton = new PlayButton();
        settingButton = new com.siminenko.falldown.Model.Menu.PlayButton.SettingButton();
        levelText = new com.siminenko.falldown.Model.Menu.LevelText(com.siminenko.falldown.Config.Progress.getNextLevel().level, Color.ORANGE);
        levelText.isMenu = true;
        levelButton = new com.siminenko.falldown.Model.Menu.PlayButton.LevelButton();
        infiniteButton = new com.siminenko.falldown.Model.Menu.PlayButton.InfiniteButton();
        diamondDisplay = new com.siminenko.falldown.Model.Menu.DiamondDisplay();
        customizeButton = new com.siminenko.falldown.Model.Menu.PlayButton.CustomizeButton();
        gameNameText = new com.siminenko.falldown.Model.Menu.GameNameText();
        com.siminenko.falldown.Model.Music.Music.music();
        MyGdxGame.setUp(15, false);
        MyGdxGame.adsController.showBannerAd();
    }

    public static void init() {

    }

    @Override
    public void act(float delta) {
        modelPicker.act();
        background.act();
        playButton.act();
        levelText.act();
        levelButton.act();
        infiniteButton.act();
        diamondDisplay.act();
        settingButton.act();
        customizeButton.act();
        gameNameText.act();
        if (playButton.isReady()) {
            MyGdxGame.layoutManager.set(new GameLayout(com.siminenko.falldown.Model.Level.LevelGetter.getLevel()));
        }
        if (infiniteButton.isReady()) {
            MyGdxGame.layoutManager.set(new GameLayout(new com.siminenko.falldown.Model.Level.Levels.LevelLoop()));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        levelText.render(MyGdxGame.batchDynamic);
        levelButton.render(MyGdxGame.batchDynamic);
        settingButton.render(MyGdxGame.batchDynamic);
        playButton.render(MyGdxGame.batchDynamic);
        infiniteButton.render(MyGdxGame.batchDynamic);
        diamondDisplay.render(MyGdxGame.batchDynamic);
        customizeButton.render(MyGdxGame.batchDynamic);
        gameNameText.render(MyGdxGame.batchDynamic);
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        playButton.dispose();
        modelPicker.dispose();
        levelText.dispose();
        levelButton.dispose();
        infiniteButton.dispose();
        background.dispose();
        diamondDisplay.dispose();
        settingButton.dispose();
        customizeButton.dispose();
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
