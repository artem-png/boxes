package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.lisuart.falldown.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level17 extends ALevel {

    public Level17() {
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
                0,
                0,
                new Vector2(0, MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                2,
                MyGdxGame.height / 2 - 20,
                0.71f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                0,
                new Vector2(MyGdxGame.width - 1f, MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                2,
                MyGdxGame.height / 2 - 20,
                0.71f
        ));
        this.aScenarioVector2.add(new KinematicBlockHorizontal(
                GameLayout.world,
                player,
                this,
                0,
                0,
                5,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height / 2 + 10),
                new Vector2(0, 0),
                2,
                12,
                0.1f
        ));
        for (int i = 0; i < 4; i++) {
            this.aScenarioVector2.add(new SimpleBlockCircle(
                    GameLayout.world,
                    player,
                    this,
                    30,
                    2,
                    new Vector2(21, -10),
                    new Vector2(0, MyGdxGame.height + 5)
            ));
        }
        for (int i = 0; i < 4; i++) {
            this.aScenarioVector2.add(new SimpleBlockCircle(
                    GameLayout.world,
                    player,
                    this,
                    i == 0 ? 120 : 30,
                    2,
                    new Vector2(-21, -10),
                    new Vector2(MyGdxGame.width, MyGdxGame.height + 5)
            ));
        }
        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                100 + random.nextInt(10),
                8,
                new Vector2(0, -10),
                new Vector2(MyGdxGame.width / 2 - 8, MyGdxGame.height + 5),
                1,
                10,
                120 + random.nextInt(10)
        ));
        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                0,
                8,
                new Vector2(0, -10),
                new Vector2(MyGdxGame.width / 2 + 8, MyGdxGame.height + 5),
                1,
                10,
                120 + random.nextInt(10)
        ));
        for (int i = 0; i < 20; i++) {
            this.aScenarioVector2.add(new SimpleBlockX(
                    GameLayout.world,
                    player,
                    this,
                    new Vector2(i % 2 == 0 ? -10 : MyGdxGame.width + 10, 0),
                    new Vector2(i % 2 == 0 ? 37 : -37, 45),
                    i == 0 ? 400 : 20,
                    0,
                    5,
                    1,
                    1,
                    0.6f
            ));
        }
        for (int i = 0; i < 8; i++) {
            this.aScenarioVector2.add(new SimpleBlockCircleDestroyable(
                    GameLayout.world,
                    player,
                    this,
                    i == 0 ? 400 : 15,
                    4,
                    new Vector2(i % 2 == 0 ? 6 : - 6, -10),
                    new Vector2(i % 2 == 0 ? 0 : MyGdxGame.width, MyGdxGame.height + 5),
                    1
            ));
        }
    }
}
