package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockBig;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBonusBig;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level18 extends ALevel {

    public Level18() {
        this.hasTimePower = true;
        //this.hasBlockPower = true;
        // this.blockTime = 800;
        this.clockTime = 1200;
    }

    @Override
    public void init() {
        Random random = new Random();
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(60),
                0,
                new Vector2(8, 10),
                new Vector2(0, 0),
                2,
                25,
                0.71f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(120),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width - 9, 10),
                new Vector2(0, 0),
                2,
                25,
                0.71f
        ));
        this.aScenarioVector2.add(new SimpleBlockBig(
                GameLayout.world,
                player,
                this,
                60,
                0
        ));
        this.aScenarioVector2.add(new SimpleBonusBig(
                GameLayout.world,
                player,
                this,
                75,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 7),
                4,
                1000
        ));

        for (int i = 0; i < 24; i ++) {
            int result = random.nextInt(3);
            if (result == 0) {
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        i == 0 ? 140 : random.nextInt(50),
                        random.nextInt(3) + 2,
                        new Vector2(random.nextInt(10) - 5, -5),
                        new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10)
                ));
            } else if (result == 1) {
                this.aScenarioVector2.add(new SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        i == 0 ? 140 : random.nextInt(50),
                        random.nextInt(10),
                        0,
                        new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                        new Vector2(random.nextInt(10) - 5, -5),
                        1,
                        1 + random.nextInt(2)
                ));
            } else if (result == 2) {
                this.aScenarioVector2.add(new SimpleBlockX(
                        GameLayout.world,
                        player,
                        this,
                        new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                        new Vector2(random.nextInt(10) - 5, -5),
                        i == 0 ? 140 : random.nextInt(50),
                        random.nextInt(10),
                        random.nextInt(10),
                        1,
                        1,
                        0.5f + random.nextFloat()
                ));
            }
        }
        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                140,
                5,
                new Vector2(random.nextInt(10) - 5, -5),
                new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                11,
                100
        ));

        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                200,
                5,
                new Vector2(random.nextInt(10) - 5, -5),
                new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                11,
                100
        ));

        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                200,
                5,
                new Vector2(20, 15),
                new Vector2(-5, com.lisuart.falldown.MyGdxGame.height/2),
                1,
                10,
                80
        ));
        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                0,
                5,
                new Vector2(-20, 15),
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height/2),
                1,
                10,
                100
        ));
    }
}
