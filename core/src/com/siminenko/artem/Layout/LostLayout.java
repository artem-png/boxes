package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Model.Level.LevelGetter;
import com.siminenko.artem.Model.Lost.FailedText;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Lost.RestartText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Menu.PlayButton.PlayButton;
import com.siminenko.artem.ModelGenerator.Background;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class LostLayout implements LayoutInterface {
    ModelPicker modelPicker;
    Background background;
    RestartText restartText;
    FailedText failedText;
    MenuIcon menuIcon;
    int level;

    static Sprite whitebg;
    int timeSetting = 15;
    int timePressed = timeSetting;

    public LostLayout(int level) {
        modelPicker = new ModelPicker();
        background = new Background();
        menuIcon = new MenuIcon();
        restartText = new RestartText(level);
        failedText = new FailedText();
        this.level = level;
    }

    public static void init() {
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
    }

    @Override
    public void act(float delta) {
        if (timeSetting >= 0) {
            timeSetting--;
        }
        modelPicker.act();
        background.act();
        restartText.act();
        menuIcon.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        restartText.render(MyGdxGame.batchDynamic);
        failedText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        if (timeSetting > 0) {
            Color c = MyGdxGame.batchDynamic.getColor();
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, (float) timeSetting / (float) timePressed);
            MyGdxGame.batchDynamic.draw(this.whitebg, 0, 0, MyGdxGame.width, MyGdxGame.height);
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1);
        }
        MyGdxGame.batchDynamic.end();
        batch.begin();
    }

    @Override
    public void dispose() {
        restartText.dispose();
        modelPicker.dispose();
        failedText.dispose();
        menuIcon.dispose();
    }
}
