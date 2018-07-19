package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Model.Level.ALevel;

/**
 * Created by User on 22.04.2018.
 */

public class Level12 extends ALevel {

    public Level12() {
        this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 700;
        this.clockTime = 650;
    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -4),
                30,
                0,
                5,
                1,
                2,
                2
        ));
        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 5, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -4),
                65,
                0,
                10,
                1,
                2,
                1
        ));
        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 5, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -4),
                0,
                0,
                10,
                1,
                2,
                1
        ));
        this.aScenarioVector2.add(new SimpleBlockCircleDestroyable(
                GameLayout.world,
                this.player,
                this,
                60,
                12,
                new Vector2(0, -6),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                2
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                90,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 20),
                new Vector2(0, 0)
        ));
        for (int i = 1; i < 4; i++) {
            this.aScenarioVector2.add(new SimpleBlockVertical(
                    GameLayout.world,
                    this.player,
                    this,
                    30,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + i * 6, com.lisuart.falldown.MyGdxGame.height + 20),
                    new Vector2(0, 0)
            ));
        }

        for (int i = 3; i >= -4; i--) {
            this.aScenarioVector2.add(new SimpleBlockVertical(
                    GameLayout.world,
                    this.player,
                    this,
                    30,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + i * 6, com.lisuart.falldown.MyGdxGame.height + 20),
                    new Vector2(0, 0)
            ));
        }

        for (int i = -4; i <= 0; i++) {
            this.aScenarioVector2.add(new SimpleBlockVertical(
                    GameLayout.world,
                    this.player,
                    this,
                    30,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + i * 6, com.lisuart.falldown.MyGdxGame.height + 20),
                    new Vector2(0, 0)
            ));
        }
        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                90,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 20),
                new Vector2(0, -15),
                13,
                1
        ));
        for (int i = 0; i <= 10; i++) {
            this.aScenarioVector2.add(new SimpleBlockHorizontal(
                    GameLayout.world,
                    this.player,
                    this,
                    10,
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 20),
                    new Vector2(0, -15),
                    13,
                    1
            ));
        }

        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + -10 * 2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -10),
                60,
                0,
                10,
                1,
                2,
                1
        ));
        for (int i = -9; i <= 10; i++) {
            this.aScenarioVector2.add(new SimpleBlockX(
                    GameLayout.world,
                    this.player,
                    this,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + i * 2, com.lisuart.falldown.MyGdxGame.height + 10),
                    new Vector2(0, -10),
                    20,
                    0,
                    10,
                    1,
                    2,
                    1
            ));
        }
    }
}
