package com.siminenko.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level13 extends com.siminenko.falldown.Model.Level.ALevel {

    public Level13() {
        this.hasTimePower = true;
        //  this.hasBlockPower = true;
        //  this.blockTime = 800;
        this.clockTime = 800;
    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(0, MyGdxGame.height / 2),
                new Vector2(0, 0),
                2,
                MyGdxGame.height + 5
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width - 1, MyGdxGame.height / 2),
                new Vector2(0, 0),
                2,
                MyGdxGame.height + 5
        ));
        for (int i = -5; i <= 0; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    25,
                    4,
                    180,
                    new Vector2(MyGdxGame.width / 2 - i * 2, MyGdxGame.height + 5),
                    new Vector2(0, -10),
                    1,
                    2
            ));
            if (i != 0) {
                this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        com.siminenko.falldown.Layout.GameLayout.world,
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


        for (int i = 0; i <= 6; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    i == 0 ? 180 : 40,
                    4,
                    new Vector2(i % 2 == 1 ? -30 : 30, -8),
                    new Vector2(i % 2 == 1 ? MyGdxGame.width : 0, MyGdxGame.height + 5)
            ));
        }

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                180,
                0,
                new Vector2(MyGdxGame.width/2 + (-4 * 4), MyGdxGame.height + 4),
                new Vector2(0, -4),
                3,
                9
        ));

        for (int i = -3; i <= 4; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    1,
                    0,
                    new Vector2(MyGdxGame.width/2 + i * 4, MyGdxGame.height + 4),
                    new Vector2(0, -4),
                    3,
                    9
            ));
        }

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                180,
                0,
                new Vector2(MyGdxGame.width/2 + (-4 * 4), MyGdxGame.height + 4),
                new Vector2(0, -3),
                3,
                9
        ));

        for (int i = -3; i <= 4; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    1,
                    0,
                    new Vector2(MyGdxGame.width/2 + i * 4, MyGdxGame.height + 4),
                    new Vector2(0, -3),
                    3,
                    9
            ));
        }

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                180,
                0,
                new Vector2(MyGdxGame.width/2 + (-4 * 4), MyGdxGame.height + 4),
                new Vector2(0, -2),
                3,
                9
        ));

        for (int i = -3; i <= 4; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    1,
                    0,
                    new Vector2(MyGdxGame.width/2 + i * 4, MyGdxGame.height + 4),
                    new Vector2(0, -2),
                    3,
                    9
            ));
        }
    }
}
