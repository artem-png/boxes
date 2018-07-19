package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.Level1.TutorialMove;

/**
 * Created by User on 22.04.2018.
 */

public class Level1 extends ALevel {

    public Level1() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new TutorialMove(com.lisuart.falldown.Layout.GameLayout.world, this.player, this, 30));
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 4),
                new Vector2(0, 0),
                0,
                0
        ));
    }
}
