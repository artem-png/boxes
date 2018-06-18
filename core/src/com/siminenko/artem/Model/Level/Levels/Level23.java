package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.KinematicBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level23 extends ALevel {

    public Level23() {
        // this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 1700;
        // this.clockTime = 1700;
    }

    @Override
    public void init() {
        Random random = new Random();

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(15),
                0,
                new Vector2(8, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(15),
                0,
                new Vector2(0, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(0),
                0,
                new Vector2(MyGdxGame.width/2 - 3.5f, 73),
                new Vector2(0, 0),
                2,
                18,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(0),
                0,
                new Vector2(MyGdxGame.width/2 + 3.5f, 73),
                new Vector2(0, 0),
                2,
                18,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-15),
                0,
                new Vector2(MyGdxGame.width - 8, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-15),
                0,
                new Vector2(MyGdxGame.width, 73),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(25),
                0,
                new Vector2(3, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(25),
                0,
                new Vector2(-5, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-25),
                0,
                new Vector2(MyGdxGame.width - 4, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                (float) Math.toRadians(-25),
                0,
                new Vector2(MyGdxGame.width + 4, 50),
                new Vector2(0, 0),
                2,
                20,
                0.5f
        ));

///////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < 25; i ++) {
            int f = random.nextInt(5);
            if (f == 0) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        40,
                        4,
                        new Vector2(14, -45),
                        new Vector2(0.5f, 85)
                ));
            } else if (f == 1) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        40,
                        4,
                        new Vector2(0, -45),
                        new Vector2(MyGdxGame.width/2, MyGdxGame.height + 2)
                ));

            } else if (f == 2) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        40,
                        4,
                        new Vector2(-15, -45),
                        new Vector2(MyGdxGame.width - 1.5f, 85)
                ));

            } else if (f == 3) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        50,
                        4,
                        new Vector2(24, -45),
                        new Vector2(-1, 50)
                ));
            } else if (f == 4) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        50,
                        4,
                        new Vector2(-24, -45),
                        new Vector2(MyGdxGame.width , 50)
                ));
            }
        }



        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                player,
                this,
                6757656,
                random.nextInt(3) + 2,
                new Vector2(random.nextInt(10) - 5, -5),
                new Vector2(random.nextInt(20) - 10 + MyGdxGame.width/2, MyGdxGame.height + 10)
        ));
    }
}
