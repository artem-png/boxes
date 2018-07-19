package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.ALevel;

/**
 * Created by User on 22.04.2018.
 */

public class Level9 extends ALevel {

    public Level9() {

    }

    @Override
    public void init() {
        SimpleBlockCircleBomb cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                50,
                10,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                6,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                130,
                10,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                6,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                130,
                6,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                10,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                130,
                10,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                0,
                160
        );
        this.aScenarioVector2.add(cb);
        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                6,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                14,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                200,
                6,
                new Vector2(25, 15),
                new Vector2(-5, com.lisuart.falldown.MyGdxGame.height - 25),
                1,
                14,
                80
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                70,
                6,
                new Vector2(-25, 15),
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height - 25),
                1,
                14,
                80
        );
        this.aScenarioVector2.add(cb);
    }
}
