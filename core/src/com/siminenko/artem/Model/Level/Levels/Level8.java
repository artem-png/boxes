package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level8 extends ALevel {

    public Level8() {

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
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
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
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
                1,
                20,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                110,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
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
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                20,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                110,
                6,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
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
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                20,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                110,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 11, MyGdxGame.height + 10),
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
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                20,
                160
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                170,
                6,
                new Vector2(25, 15),
                new Vector2(-5, MyGdxGame.height - 25),
                1,
                20,
                80
        );
        this.aScenarioVector2.add(cb);

        cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                40,
                6,
                new Vector2(-25, 15),
                new Vector2(MyGdxGame.width + 5, MyGdxGame.height - 25),
                1,
                20,
                80
        );
        this.aScenarioVector2.add(cb);
    }
}
