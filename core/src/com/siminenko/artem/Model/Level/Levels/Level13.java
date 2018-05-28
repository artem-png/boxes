package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.KinematicBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level13 extends ALevel {

    public Level13() {
        this.hasTimePower = true;
        this.hasBlockPower = false;
       // this.blockTime = 800;
        this.clockTime = 800;
    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(0, MyGdxGame.height/2),
                new Vector2(0, 0),
                2,
                MyGdxGame.height
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width - 1, MyGdxGame.height/2),
                new Vector2(0, 0),
                2,
                MyGdxGame.height
        ));
        for (int i = -8; i <= 0; i++) {
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    17,
                    4,
                    180,
                    new Vector2(MyGdxGame.width / 2 - i * 2, MyGdxGame.height + 5),
                    new Vector2(0, -10),
                    1,
                    2
            ));
            if (i != 0) {
                this.aScenarioVector2.add(new SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        4,
                        180,
                        new Vector2(MyGdxGame.width / 2 + i * 2, MyGdxGame.height + 5),
                        new Vector2(0, -10),
                        1,
                        2
                ));
            }
        }
    }
}
