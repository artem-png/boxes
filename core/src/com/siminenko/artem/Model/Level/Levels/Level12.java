package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.Model.Level.Scenarious.Level12.TutorialClock;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level12 extends ALevel {

    public Level12() {
        this.hasTimePower = true;
        this.hasBlockPower = true;
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

        this.aScenarioVector2.add(new TutorialClock(
                GameLayout.world,
                this.player,
                this,
                30
        ));
    }
}
