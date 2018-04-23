package com.siminenko.artem.Layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.artem.Model.Level.LevelGetter;
import com.siminenko.artem.Model.Menu.ModelPickerModels.ModelPicker;
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

    static Sprite whitebg;
    int timeSetting = 15;
    int timePressed = timeSetting;

    public MenuLayout() {
        modelPicker = new ModelPicker();
        background = new BackgroundCircle(1);
        playButton = new PlayButton();
    }

    public static void init() {
        whitebg = new Sprite(new Texture("menu/whitebg.png"));
    }

    @Override
    public void act(float delta) {
        modelPicker.act();
        background.act();
        playButton.act();
        if (timeSetting >= 0) {
            timeSetting--;
        }
        if (playButton.isReady()) {
            MyGdxGame.layoutManager.set(new GameLayout(LevelGetter.getLevel()));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.end();
        MyGdxGame.batchDynamic.begin();
        background.render(MyGdxGame.batchDynamic);
        modelPicker.render(MyGdxGame.batchDynamic);
        playButton.render(MyGdxGame.batchDynamic);
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
        playButton.dispose();
        modelPicker.dispose();
    }
}
