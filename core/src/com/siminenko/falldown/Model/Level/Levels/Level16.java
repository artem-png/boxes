package com.siminenko.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.Model.Level.ALevel;
import com.siminenko.falldown.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level16 extends ALevel {

    public Level16() {
        //this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 800;
        //this.clockTime = 1200;
    }

    @Override
    public void init() {
        Random random = new Random();
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(-1, MyGdxGame.height / 2 + 20),
                new Vector2(0, 0),
                2,
                MyGdxGame.height / 2 - 10,
                0.7f
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width, MyGdxGame.height / 2 + 20),
                new Vector2(0, 0),
                2,
                MyGdxGame.height / 2 - 10,
                0.7f
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(30),
                0,
                new Vector2(0.4f, MyGdxGame.height / 2 + 2.5f),
                new Vector2(0, 0),
                2,
                6,
                0.7f
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-30),
                0,
                new Vector2(MyGdxGame.width - 1.4f, MyGdxGame.height / 2 + 2.5f),
                new Vector2(0, 0),
                2,
                6,
                0.7f
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-30),
                0,
                new Vector2(MyGdxGame.width / 2 - 10, MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                10,
                2,
                0.7f
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(30),
                0,
                new Vector2(MyGdxGame.width / 2 + 10, MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                10,
                2,
                0.7f
        ));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width / 2 + 16, MyGdxGame.height / 2 + 28),
                new Vector2(0, 0),
                2,
                2,
                0.7f
        ));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width / 2 - 16, MyGdxGame.height / 2 + 28),
                new Vector2(0, 0),
                2,
                2,
                0.7f
        ));

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height / 2 + 20),
                new Vector2(0, 0),
                8,
                2,
                0.7f
        ));

        for (int i = 0; i <= 40; i++) {
            if (i % 10 == 5) {
                this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                        com.siminenko.falldown.Layout.GameLayout.world,
                        player,
                        this,
                        20,
                        3,
                        new Vector2(random.nextInt(50) - 25, -random.nextInt(20) - 20),
                        new Vector2(MyGdxGame.width / 2 + random.nextInt(20) - 10, MyGdxGame.height + 10),
                        1,
                        3,
                        120
                ));
            } else {
                this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                        com.siminenko.falldown.Layout.GameLayout.world,
                        player,
                        this,
                        20,
                        2,
                        new Vector2(random.nextInt(50) - 25, -random.nextInt(20) - 30),
                        new Vector2(MyGdxGame.width / 2 + random.nextInt(20) - 10, MyGdxGame.height + 10)
                ));
            }
        }
    }
}
