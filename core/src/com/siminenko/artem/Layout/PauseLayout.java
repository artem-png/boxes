package com.siminenko.artem.Layout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Model.LevelLayout.BackIcon;
import com.siminenko.artem.Model.LevelLayout.LevelGenerator;
import com.siminenko.artem.Model.LevelLayout.TopPanel;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Menu.LevelText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Pause.ContinueButton;
import com.siminenko.artem.Model.Pause.PausedText;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class PauseLayout implements LayoutInterface {
    static Sprite whitebg;
    BackgroundCircle backgroundCircle;
    ModelPicker modelPicker;
    MenuIcon menuIcon;
    ContinueButton continueButton;
    PausedText pausedText;
    LevelText levelText;
    int timeSetting = 15;
    int timePressed = timeSetting;

    int levelsCount;

    int level;

    public PauseLayout(int level) {
        backgroundCircle = new BackgroundCircle(1);
        modelPicker = new ModelPicker();
        menuIcon = new MenuIcon();
        menuIcon.disposeAll = true;
        pausedText = new PausedText();
        continueButton = new ContinueButton();
        this.level = level;
        levelText = new LevelText(level, Color.DARK_GRAY);
    }

    public static void init() {
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
    }

    @Override
    public void act(float delta) {
        if (timeSetting >= 0) {
            timeSetting--;
        }
        backgroundCircle.act();
        modelPicker.act();
        menuIcon.act();
        continueButton.act();
        pausedText.act();
        levelText.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        backgroundCircle.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        pausedText.render(MyGdxGame.batchDynamic);
        levelText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        continueButton.render(MyGdxGame.batchDynamic);
        if (timeSetting > 0) {
            Color c = MyGdxGame.batchDynamic.getColor();
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, (float) timeSetting / (float) timePressed);
            MyGdxGame.batchDynamic.draw(this.whitebg, -10, -10, MyGdxGame.width + 20, MyGdxGame.height + 20);
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1);
        }
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {

    }
}
