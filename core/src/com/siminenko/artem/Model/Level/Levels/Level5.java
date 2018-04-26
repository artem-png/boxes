package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level5 extends ALevel {

    public Level5() {

    }

    @Override
    public void init() {
        Random r = new Random();

        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(MyGdxGame.width / 2 - 10, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width / 2 - 5, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width / 2 + 5, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width / 2 + 10, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                140,
                20,
                new Vector2(MyGdxGame.width / 2 - 8, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                20,
                new Vector2(MyGdxGame.width / 2 + 8, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                90,
                20,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                90,
                20,
                new Vector2(MyGdxGame.width / 2 - 8, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                20,
                new Vector2(MyGdxGame.width / 2 + 8, MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));

        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                150,
                30 + r.nextInt(3),
                new Vector2(-10, MyGdxGame.height),
                new Vector2(17, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                30 + r.nextInt(3),
                new Vector2(MyGdxGame.width + 10, MyGdxGame.height),
                new Vector2(-17, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockBig(
                GameLayout.world,
                this.player,
                this,
                50,
                0
        ));
    }
}
