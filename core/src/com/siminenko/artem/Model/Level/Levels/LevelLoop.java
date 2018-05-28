package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Infinite.Score;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class LevelLoop extends ALevel {
    Score score;

    public LevelLoop() {
        this.level = 0;
        this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 900;
        this.clockTime = 900;
        score = new Score();
        Score.score = 0;
    }

    public static void initStatic() {
        Score.init();
    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(MyGdxGame.width/2, MyGdxGame.height + 4),
                new Vector2(0, 0),
                0,
                0
        ));
    }

    public void act() {
        super.act();
        score.act();
    }

    public void render(SpriteBatch b) {
        super.render(b);
        score.render(b);
    }

    public boolean isComplete() {
        return false;
    }

    public void afterWin() {

    }

    public void dispose() {
        super.dispose();
    }

}
