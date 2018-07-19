package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.Level11.TutorialPower;
import com.lisuart.falldown.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level11 extends ALevel {

    public Level11() {
        this.hasBlockPower = true;
        this.blockTime = 700;
    }

    @Override
    public void init() {
        for (int i = 6; i >= -6; i--) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                    GameLayout.world,
                    this.player,
                    this,
                    3,
                    4,
                    new Vector2(0, -1),
                    new Vector2(MyGdxGame.width / 2 + i * 4, MyGdxGame.height + 5)
            ));
        }
        for (int i = 6; i >= -6; i--) {
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(
                    GameLayout.world,
                    this.player,
                    this,
                    3,
                    4,
                    new Vector2(0, -3),
                    new Vector2(MyGdxGame.width / 2 + i * 4, MyGdxGame.height + 4)
            ));
        }
        this.aScenarioVector2.add(new TutorialPower(GameLayout.world, this.player, this, 0));

        SimpleBlockCircleBomb o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                180,
                8,
                new Vector2(0, -5),
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 5),
                0.9f,
                9,
                140
        );
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                170,
                8,
                new Vector2(23, 20),
                new Vector2(-5, 35),
                0.9f,
                9,
                130
        );
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                170,
                8,
                new Vector2(-23, 20),
                new Vector2(MyGdxGame.width + 5, 45),
                0.9f,
                9,
                130
        );
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                140,
                4,
                new Vector2(-10, 50),
                new Vector2(MyGdxGame.width + 5, 0),
                0.9f,
                9,
                110
        );
        this.aScenarioVector2.add(o);
        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                4,
                new Vector2(10, 50),
                new Vector2(-5, 0),
                0.9f,
                9,
                110
        );
        this.aScenarioVector2.add(o);

        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(-5, MyGdxGame.height -5),
                new Vector2(10, -5),
                260,
                0,
                4,
                1,
                2,
                1
        ));
        for (int i = 0; i <= 7; i++) {
            this.aScenarioVector2.add(new SimpleBlockX(
                    GameLayout.world,
                    this.player,
                    this,
                    new Vector2((i % 2 == 1) ? -5 : MyGdxGame.width + 5, MyGdxGame.height -5),
                    new Vector2((i % 2 == 1) ? 10 : -10, -5),
                    60,
                    0,
                    4,
                    1,
                    2,
                    1
            ));
        }

        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                150,
                0,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 5),
                new Vector2(0, -40)
        ));
        for (int i = 0; i <= 7; i++) {
            this.aScenarioVector2.add(new SimpleBlockVertical(
                    GameLayout.world,
                    this.player,
                    this,
                    30,
                    0,
                    new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 5),
                    new Vector2(0, -40)
            ));
        }

        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 15),
                new Vector2(0, -25),
                140,
                0,
                5,
                1,
                2,
                3
        ));

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                10,
                4,
                new Vector2(25, 30),
                new Vector2(-5, 40),
                0.9f,
                4,
                100
        );
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                4,
                new Vector2(-25, 30),
                new Vector2(MyGdxGame.width + 5, 40),
                0.9f,
                4,
                100
        );
        this.aScenarioVector2.add(o);
    }
}
