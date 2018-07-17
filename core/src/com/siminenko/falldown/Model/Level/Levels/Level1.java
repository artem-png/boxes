package com.siminenko.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.Layout.GameLayout;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.falldown.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level1 extends ALevel {

    public Level1() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new TutorialMove(GameLayout.world, this.player, this, 30));
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
}
