package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.lisuart.falldown.Model.Level.ALevel;

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
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 10, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 5, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 5, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 10, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                140,
                20,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 8, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                20,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 8, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                100,
                20,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                100,
                20,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 8, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                20,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 8, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0)
        ));

        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                150,
                30 + r.nextInt(3),
                new Vector2(-10, com.lisuart.falldown.MyGdxGame.height),
                new Vector2(17, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                30 + r.nextInt(3),
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 10, com.lisuart.falldown.MyGdxGame.height),
                new Vector2(-17, 0)
        ));
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockBig(
                com.lisuart.falldown.Layout.GameLayout.world,
                this.player,
                this,
                50,
                0
        ));
    }
}
