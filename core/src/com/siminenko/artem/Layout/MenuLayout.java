package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Config.Tex;
import com.siminenko.artem.Model.Level.LevelGetter;
import com.siminenko.artem.Model.Level.Levels.LevelLoop;
import com.siminenko.artem.Model.Menu.DiamondDisplay;
import com.siminenko.artem.Model.Menu.GameNameText;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Menu.PlayButton.CustomizeButton;
import com.siminenko.artem.Model.Menu.PlayButton.InfiniteButton;
import com.siminenko.artem.Model.Menu.PlayButton.LevelButton;
import com.siminenko.artem.Model.Menu.PlayButton.PlayButton;
import com.siminenko.artem.Model.Menu.PlayButton.SettingButton;
import com.siminenko.artem.Model.Music.Music;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 3/21/18.
 */

public class MenuLayout implements LayoutInterface {
    ModelPicker modelPicker;
    BackgroundCircle background;
    PlayButton playButton;
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
        playButton = new PlayButton();
        settingButton = new SettingButton();
        levelText = new LevelText(Progress.getNextLevel().level, Color.ORANGE);
        levelText.isMenu = true;
        levelButton = new LevelButton();
        infiniteButton = new InfiniteButton();
        diamondDisplay = new DiamondDisplay();
        customizeButton = new CustomizeButton();
        gameNameText = new GameNameText();
        Music.music();
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
            MyGdxGame.layoutManager.set(new GameLayout(LevelGetter.getLevel()));
        }
        if (infiniteButton.isReady()) {
            MyGdxGame.layoutManager.set(new GameLayout(new LevelLoop()));
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
