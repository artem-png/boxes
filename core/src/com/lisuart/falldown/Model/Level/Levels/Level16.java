package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.ALevel;

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
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(-1, com.lisuart.falldown.MyGdxGame.height / 2 + 20),
                new Vector2(0, 0),
                2,
                com.lisuart.falldown.MyGdxGame.height / 2 - 10,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width, com.lisuart.falldown.MyGdxGame.height / 2 + 20),
                new Vector2(0, 0),
                2,
                com.lisuart.falldown.MyGdxGame.height / 2 - 10,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(30),
                0,
                new Vector2(0.4f, com.lisuart.falldown.MyGdxGame.height / 2 + 2.5f),
                new Vector2(0, 0),
                2,
                6,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-30),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width - 1.4f, com.lisuart.falldown.MyGdxGame.height / 2 + 2.5f),
                new Vector2(0, 0),
                2,
                6,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-30),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 10, com.lisuart.falldown.MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                10,
                2,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(30),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 10, com.lisuart.falldown.MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                10,
                2,
                0.7f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 16, com.lisuart.falldown.MyGdxGame.height / 2 + 28),
                new Vector2(0, 0),
                2,
                2,
                0.7f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 16, com.lisuart.falldown.MyGdxGame.height / 2 + 28),
                new Vector2(0, 0),
                2,
                2,
                0.7f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height / 2 + 20),
                new Vector2(0, 0),
                8,
                2,
                0.7f
        ));

        for (int i = 0; i <= 40; i++) {
            if (i % 10 == 5) {
                this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                        GameLayout.world,
                        player,
                        this,
                        20,
                        3,
                        new Vector2(random.nextInt(50) - 25, -random.nextInt(20) - 20),
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + random.nextInt(20) - 10, com.lisuart.falldown.MyGdxGame.height + 10),
                        1,
                        3,
                        120
                ));
            } else {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        20,
                        2,
                        new Vector2(random.nextInt(50) - 25, -random.nextInt(20) - 30),
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + random.nextInt(20) - 10, com.lisuart.falldown.MyGdxGame.height + 10)
                ));
            }
        }
    }
}
