package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Model.Lost.FailedText;
import com.siminenko.artem.Model.Lost.MenuIcon;
import com.siminenko.artem.Model.Lost.RestartText;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
import com.siminenko.artem.Model.Win.CompletedText;
import com.siminenko.artem.Model.Win.NextLevelText;
import com.siminenko.artem.ModelGenerator.BackgroundCircle;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by artem on 3/21/18.
 */

public class WinLayout implements LayoutInterface {
    ModelPicker modelPicker;
    BackgroundCircle background;
    NextLevelText continueText;
    CompletedText successText;
    MenuIcon menuIcon;
    int level;

    static Sprite whitebg;
    int timeSetting = 15;
    int timePressed = timeSetting;

    public WinLayout(int level) {
        modelPicker = new ModelPicker();
        background = new BackgroundCircle(3);
        menuIcon = new MenuIcon();
        continueText = new NextLevelText(level);
        successText = new CompletedText();
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
        continueText.act();
        menuIcon.act();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        successText.render(MyGdxGame.batchDynamic);
        menuIcon.render(MyGdxGame.batchDynamic);
        continueText.render(MyGdxGame.batchDynamic);
        if (timeSetting > 0) {
            Color c = MyGdxGame.batchDynamic.getColor();
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, (float) timeSetting / (float) timePressed);
            MyGdxGame.batchDynamic.draw(this.whitebg, - 10, - 10, MyGdxGame.width + 20, MyGdxGame.height + 20);
            MyGdxGame.batchDynamic.setColor(c.r, c.g, c.b, 1);
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
    }
}
