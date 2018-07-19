package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level15 extends ALevel {

    public Level15() {
        this.hasTimePower = true;
       // this.hasBlockPower = true;
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
                (float) Math.toRadians(-41),
                0,
                new Vector2(0, com.lisuart.falldown.MyGdxGame.height/2 - 9),
                new Vector2(0, 0),
                2,
                com.lisuart.falldown.MyGdxGame.height/2,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(41),
                0,
                new Vector2(0, com.lisuart.falldown.MyGdxGame.height/2 + 20),
                new Vector2(0, 0),
                2,
                com.lisuart.falldown.MyGdxGame.height/2,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-41),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width, com.lisuart.falldown.MyGdxGame.height/2 + 20),
                new Vector2(0, 0),
                2,
                com.lisuart.falldown.MyGdxGame.height/2,
                0.7f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(41),
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width, com.lisuart.falldown.MyGdxGame.height/2 - 9),
                new Vector2(0, 0),
                2,
                com.lisuart.falldown.MyGdxGame.height/2,
                0.7f
        ));

        for (int i = 0; i <= 16; i++) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                    GameLayout.world,
                    player,
                    this,
                    40,
                    3,
                    new Vector2(0, -34),
                    new Vector2(i % 2 == 1 ? 7 : com.lisuart.falldown.MyGdxGame.width - 7, com.lisuart.falldown.MyGdxGame.height + 5)
            ));
        }

        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                200,
                22,
                new Vector2(0, -30),
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                20,
                100
        ));

        for (int i = 0; i <= 3; i++) {
            this.aScenarioVector2.add(new SimpleBlockX(
                    GameLayout.world,
                    player,
                    this,
                    new Vector2(i % 2 == 1 ? -7 : com.lisuart.falldown.MyGdxGame.width + 7, 0),
                    new Vector2(i % 2 == 1 ? 10 : -10, 34),
                    i == 0 ? 400 : 40,
                    0,
                    10,
                    1,
                    2,
                    1
            ));
        }
    }
}
