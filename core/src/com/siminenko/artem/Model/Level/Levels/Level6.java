package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level6 extends ALevel {

    public Level6() {

    }

    @Override
    public void init() {
        Random r = new Random();

        SimpleBlockCircleBomb o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                50,
                8,
                new Vector2(0, -5),
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 5),
                0.9f,
                30,
                110
        );
        o.gravityScale = 0.5f;
        this.aScenarioVector2.add(o);
////////
        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                60,
                5,
                new Vector2(0, -3),
                new Vector2(MyGdxGame.width / 2 - 5, MyGdxGame.height + 5),
                0.9f,
                15,
                90
        );
        o.gravityScale = 0.3f;
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, -3),
                new Vector2(MyGdxGame.width / 2 + 5, MyGdxGame.height + 5),
                0.9f,
                15,
                90
        );
        o.gravityScale = 0.3f;
        this.aScenarioVector2.add(o);

        /////
        SimpleBlockTriangle t = new SimpleBlockTriangle(
                GameLayout.world,
                player,
                this,
                80,
                0,
                180,
                new Vector2(MyGdxGame.width / 2 + 8, MyGdxGame.height + 5),
                new Vector2(),
                0.9f
        );
        this.aScenarioVector2.add(t);
        t = new SimpleBlockTriangle(
                GameLayout.world,
                player,
                this,
                0,
                0,
                180,
                new Vector2(MyGdxGame.width / 2 - 8, MyGdxGame.height + 5),
                new Vector2(),
                0.9f
        );
        this.aScenarioVector2.add(t);
/////
        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                60,
                3,
                new Vector2(0, -3),
                new Vector2(MyGdxGame.width / 2 + 8, MyGdxGame.height + 5),
                0.9f,
                5,
                90
        );
        o.gravityScale = 0.3f;
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                3,
                new Vector2(0, -3),
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 5),
                0.9f,
                5,
                90
        );
        o.gravityScale = 0.3f;
        this.aScenarioVector2.add(o);

        o = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                3,
                new Vector2(0, -3),
                new Vector2(MyGdxGame.width / 2 - 8, MyGdxGame.height + 5),
                0.9f,
                5,
                90
        );
        o.gravityScale = 0.3f;
        this.aScenarioVector2.add(o);
    }
}
