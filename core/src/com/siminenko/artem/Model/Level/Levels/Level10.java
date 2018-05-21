package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockX;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level10 extends ALevel {

    public Level10() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                new Vector2(0, 0),
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
                new Vector2(MyGdxGame.width / 2 - 5, MyGdxGame.height + 10),
                new Vector2(0, 0),
                50,
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
                new Vector2(MyGdxGame.width / 2 + 5, MyGdxGame.height + 10),
                new Vector2(0, 0),
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
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                2
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                90,
                0,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 20),
                new Vector2(0, 0)
        ));
        for (int i = 1; i < 4; i++) {
            this.aScenarioVector2.add(new SimpleBlockVertical(
                    GameLayout.world,
                    this.player,
                    this,
                    30,
                    0,
                    new Vector2(MyGdxGame.width / 2 + i * 6, MyGdxGame.height + 20),
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
                    new Vector2(MyGdxGame.width / 2 + i * 6, MyGdxGame.height + 20),
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
                    new Vector2(MyGdxGame.width / 2 + i * 6, MyGdxGame.height + 20),
                    new Vector2(0, 0)
            ));
        }
        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                90,
                0,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 20),
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
                    new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 20),
                    new Vector2(0, -15),
                    13,
                    1
            ));
        }

        this.aScenarioVector2.add(new SimpleBlockBig(GameLayout.world, this.player, this, 50, 0));

        this.aScenarioVector2.add(new SimpleBlockX(
                GameLayout.world,
                this.player,
                this,
                new Vector2(MyGdxGame.width / 2 + -10 * 2, MyGdxGame.height + 10),
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
                    new Vector2(MyGdxGame.width / 2 + i * 2, MyGdxGame.height + 10),
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
