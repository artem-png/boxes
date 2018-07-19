package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal;

/**
 * Created by User on 22.04.2018.
 */

public class Level2 extends ALevel {

    public Level2() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                180,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));
        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));

        this.aScenarioVector2.add(new SimpleBlockHorizontal(
                GameLayout.world,
                this.player,
                this,
                30,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0
        ));



    }
}
