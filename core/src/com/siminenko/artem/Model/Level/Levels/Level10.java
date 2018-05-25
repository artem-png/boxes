package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockX;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.Model.Level.Scenarious.Level12.TutorialClock;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level10 extends ALevel {

    public Level10() {
        this.hasTimePower = true;
        this.clockTime = 450;
    }

    @Override
    public void init() {
        for (int i = -2; i < 2; i++) {
            this.aScenarioVector2.add(new SimpleBlockHorizontal(
                    GameLayout.world,
                    this.player,
                    this,
                    8,
                    0,
                    new Vector2(MyGdxGame.width/2 + i * 4, MyGdxGame.height + 4),
                    new Vector2(0, 0),
                    2,
                    5
            ));
        }
        for (int i = 2; i >= -2; i--) {
            this.aScenarioVector2.add(new SimpleBlockHorizontal(
                    GameLayout.world,
                    this.player,
                    this,
                    8,
                    0,
                    new Vector2(MyGdxGame.width/2 + i * 4, MyGdxGame.height + 4),
                    new Vector2(0, 0),
                    2,
                    5
            ));
        }

        SimpleBlockCircleBomb o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                4,
                new Vector2(13, -5),
                new Vector2(-5, 50),
                0.9f,
                5,
                110
        );
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                4,
                new Vector2(-13, -5),
                new Vector2(MyGdxGame.width + 5, 50),
                0.9f,
                11,
                100
        );
        this.aScenarioVector2.add(o);

        this.aScenarioVector2.add(new TutorialClock(
                GameLayout.world,
                this.player,
                this,
                10
        ));

        for (int i = -2; i < 5; i++) {
            this.aScenarioVector2.add(new SimpleBlockHorizontal(
                    GameLayout.world,
                    this.player,
                    this,
                    8,
                    0,
                    new Vector2(MyGdxGame.width/2 + i * 4, MyGdxGame.height + 2),
                    new Vector2(0, -20),
                    2,
                    6
            ));
        }

        for (int i = -2; i <= 2; i++) {
            this.aScenarioVector2.add(new SimpleBlockX(
                    GameLayout.world,
                    this.player,
                    this,
                    new Vector2(MyGdxGame.width/2 + i * 7 , MyGdxGame.height + 5),
                    new Vector2(0, -15),
                    2,
                    0,
                    10,
                    0.4f,
                    2,
                    1
            ));
        }
    }
}
