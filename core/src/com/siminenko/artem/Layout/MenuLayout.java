package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Model.Level.LevelGetter;
import com.siminenko.artem.Model.Level.Levels.LevelLoop;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Menu.PlayButton.InfiniteButton;
import com.siminenko.artem.Model.Menu.PlayButton.LevelButton;
import com.siminenko.artem.Model.Menu.PlayButton.PlayButton;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

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

    public MenuLayout() {
        modelPicker = new ModelPicker();
        background = new BackgroundCircle(1);
        playButton = new PlayButton();
        levelText = new LevelText(Progress.getNextLevel().level, Color.ORANGE);
        levelText.isMenu = true;
        levelButton = new LevelButton();
        infiniteButton = new InfiniteButton();
        MyGdxGame.setUp(15, false);
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
        playButton.render(MyGdxGame.batchDynamic);
        infiniteButton.render(MyGdxGame.batchDynamic);
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
    }

    @Override
    public boolean getIsParralel() {
        return false;
    }
}
