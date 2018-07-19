package com.lisuart.falldown.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lisuart.falldown.Config.Progress;
import com.lisuart.falldown.Model.Level.LevelGetter;
import com.lisuart.falldown.Model.Level.Levels.LevelLoop;
import com.lisuart.falldown.Model.Menu.DiamondDisplay;
import com.lisuart.falldown.Model.Menu.GameNameText;
import com.lisuart.falldown.Model.Menu.LevelText;
import com.lisuart.falldown.Model.Menu.ModelPickerModels.ModelPicker;
import com.lisuart.falldown.Model.Menu.PlayButton.CustomizeButton;
import com.lisuart.falldown.Model.Menu.PlayButton.InfiniteButton;
import com.lisuart.falldown.Model.Menu.PlayButton.LevelButton;
import com.lisuart.falldown.Model.Menu.PlayButton.SettingButton;
import com.lisuart.falldown.Model.Music.Music;
import com.lisuart.falldown.ModelGenerator.BackgroundCircle;

/**
 * Created by artem on 3/21/18.
 */

public class MenuLayout implements LayoutInterface {
    ModelPicker modelPicker;
    BackgroundCircle background;
    com.lisuart.falldown.Model.Menu.PlayButton.PlayButton playButton;
    LevelText levelText;
    LevelButton levelButton;
    InfiniteButton infiniteButton;
    DiamondDisplay diamondDisplay;
    SettingButton settingButton;
    CustomizeButton customizeButton;
    GameNameText gameNameText;


    public MenuLayout() {
        modelPicker = new ModelPicker();
        background = new BackgroundCircle(1);
        playButton = new com.lisuart.falldown.Model.Menu.PlayButton.PlayButton();
        settingButton = new SettingButton();
        levelText = new LevelText(Progress.getNextLevel().level, Color.ORANGE);
        levelText.isMenu = true;
        levelButton = new LevelButton();
        infiniteButton = new InfiniteButton();
        diamondDisplay = new DiamondDisplay();
        customizeButton = new CustomizeButton();
        gameNameText = new GameNameText();
        Music.music();
        com.lisuart.falldown.MyGdxGame.setUp(15, false);
        com.lisuart.falldown.MyGdxGame.adsController.showBannerAd();
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
            com.lisuart.falldown.MyGdxGame.layoutManager.set(new GameLayout(LevelGetter.getLevel()));
        }
        if (infiniteButton.isReady()) {
            com.lisuart.falldown.MyGdxGame.layoutManager.set(new GameLayout(new LevelLoop()));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        com.lisuart.falldown.MyGdxGame.batchDynamic.begin();
        background.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        modelPicker.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        levelText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        levelButton.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        settingButton.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        playButton.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        infiniteButton.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        diamondDisplay.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        customizeButton.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        gameNameText.render(com.lisuart.falldown.MyGdxGame.batchDynamic);
        com.lisuart.falldown.MyGdxGame.batchDynamic.end();
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
