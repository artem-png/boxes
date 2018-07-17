package com.siminenko.falldown.Model.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class ProgressBar {
    com.siminenko.falldown.Model.Level.ALevel level;
    Sprite bar;
    int scenarioCount = 1;
    int currentScenario = 0;

    float xPerScenario;

    public ProgressBar(com.siminenko.falldown.Model.Level.ALevel level) {
        this.level = level;
        bar = new Sprite(new Texture("progressbar.png"));
        this.scenarioCount = this.level.aScenarioVector2.size();
        xPerScenario = (float) MyGdxGame.width / (float) this.scenarioCount;
    }

    public void render(SpriteBatch batch) {
        if (level.level != 0) {
            currentScenario = scenarioCount - level.aScenarioVector2.size();
            batch.draw(this.bar, -1, 0, xPerScenario * currentScenario + 1, 0.7f);
        }
    }

}
