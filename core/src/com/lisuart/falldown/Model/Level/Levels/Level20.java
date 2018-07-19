package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockBig;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level20 extends ALevel {

    public Level20() {
       // this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 1700;
       // this.clockTime = 1700;
    }

    @Override
    public void init() {
        Random random = new Random();

        for (int i = 0; i < 4; i ++) {
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    100,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 4),
                    new Vector2(0, -15),
                    0.5f,
                    3
            ));
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 10, com.lisuart.falldown.MyGdxGame.height + 3.5f),
                    new Vector2(-3.3f, -15),
                    0.5f,
                    3
            ));
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 10, com.lisuart.falldown.MyGdxGame.height + 3.5f),
                    new Vector2(3.3f, -15),
                    0.5f,
                    3
            ));
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 20, com.lisuart.falldown.MyGdxGame.height + 2.7f),
                    new Vector2(6.5f, -15),
                    0.5f,
                    3
            ));
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 20, com.lisuart.falldown.MyGdxGame.height + 2.5f),
                    new Vector2(-6.5f, -15),
                    0.5f,
                    3
            ));
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 30, com.lisuart.falldown.MyGdxGame.height + 2f),
                    new Vector2(10f, -15),
                    0.5f,
                    3
            ));
            this.aScenarioVector2.add(new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    0,
                    180,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 30, com.lisuart.falldown.MyGdxGame.height + 2f),
                    new Vector2(-10f, -15),
                    0.5f,
                    3
            ));
        }

        for (int i = 0; i < 8; i ++) {
            this.aScenarioVector2.add(new SimpleBlockX(
                    GameLayout.world,
                    player,
                    this,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 , com.lisuart.falldown.MyGdxGame.height + 11),
                    new Vector2(0, -15),
                    i == 0 ? 100 : 40 + i * 3,
                    0,
                    random.nextInt(10),
                    1,
                    2,
                    1f + i / 3f
            ));
        }

        for (int i = 0; i < 10; i++) {
            this.aScenarioVector2.add(new SimpleBlockBig(
                    GameLayout.world,
                    player,
                    this,
                    i == 0 ? 180 : 30,
                    0
            ));
        }

        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                80,
                5,
                new Vector2(0, 35),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 10, -5),
                1,
                10,
                100
        ));
        this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                GameLayout.world,
                player,
                this,
                0,
                5,
                new Vector2(0, 35),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 10, -5),
                1,
                10,
                100
        ));

    }
}
