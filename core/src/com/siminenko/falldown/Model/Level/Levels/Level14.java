package com.siminenko.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level14 extends com.siminenko.falldown.Model.Level.ALevel {

    public Level14() {
        //this.hasTimePower = true;
        //this.hasBlockPower = true;
        //this.blockTime = 800;
        //this.clockTime = 800;
    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-19),
                0,
                new Vector2(MyGdxGame.width - 5, MyGdxGame.height / 2 + 5),
                new Vector2(0, 0),
                2,
                MyGdxGame.height + 5,
                0.6f
        ));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-25),
                0,
                new Vector2(MyGdxGame.width - 35, MyGdxGame.height / 2 + 5),
                new Vector2(0, 0),
                2,
                MyGdxGame.height / 4,
                0.5f
        ));

        for (int i = 0; i <= 6; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    35,
                    4,
                    new Vector2(28, -20),
                    new Vector2(MyGdxGame.width - 30, MyGdxGame.height + 5)
            ));
        }

        for (int i = 0; i <= 6; i++) {
            this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                    com.siminenko.falldown.Layout.GameLayout.world,
                    player,
                    this,
                    i == 0 ? 80 : 35,
                    4,
                    new Vector2(0, -10),
                    new Vector2(MyGdxGame.width, MyGdxGame.height + 5)
            ));
        }

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                80,
                5,
                new Vector2(20, 20),
                new Vector2(-10, MyGdxGame.height / 2),
                1,
                10,
                100
        ));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                70,
                10,
                new Vector2(5, -10),
                new Vector2(MyGdxGame.width - 5, MyGdxGame.height + 5),
                2
        ));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                10,
                new Vector2(20, 25),
                new Vector2(-10, MyGdxGame.height/2),
                2
        ));
    }
}
