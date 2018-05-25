package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level7 extends ALevel {

    public Level7() {

    }

    @Override
    public void init() {
        SimpleBlockBig b = new SimpleBlockBig(GameLayout.world, this.player, this, 0, 10);
        b.gravityScale = 1;
        this.aScenarioVector2.add(b);

        SimpleBlockCircleBomb cb = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                20,
                16,
                new Vector2(0, -1),
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                1,
                30,
                140
        );
        this.aScenarioVector2.add(cb);
////////////
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                270,
                0,
                new Vector2(MyGdxGame.width / 2 - 10, MyGdxGame.height + 10),
                new Vector2()
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                10,
                0,
                new Vector2(MyGdxGame.width / 2 - 6, MyGdxGame.height + 10),
                new Vector2()
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                10,
                0,
                new Vector2(MyGdxGame.width / 2 - 2, MyGdxGame.height + 10),
                new Vector2()
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                10,
                0,
                new Vector2(MyGdxGame.width / 2 + 2, MyGdxGame.height + 10),
                new Vector2()
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                10,
                0,
                new Vector2(MyGdxGame.width / 2 + 6, MyGdxGame.height + 10),
                new Vector2()
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                10,
                0,
                new Vector2(MyGdxGame.width / 2 + 10, MyGdxGame.height + 10),
                new Vector2()
        ));
        //////
        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                this.player,
                this,
                120,
                5,
                new Vector2(15, 0),
                new Vector2(-10, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(-15, 0),
                new Vector2(MyGdxGame.width + 10, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                this.player,
                this,
                60,
                5,
                new Vector2(15, 0),
                new Vector2(-10, MyGdxGame.height)
        ));
        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(-15, 0),
                new Vector2(MyGdxGame.width + 10, MyGdxGame.height)
        ));
        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                this.player,
                this,
                60,
                5,
                new Vector2(15, 0),
                new Vector2(-10, MyGdxGame.height - 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockCircle(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(-15, 0),
                new Vector2(MyGdxGame.width + 10, MyGdxGame.height - 10)
        ));
        ///////
        this.aScenarioVector2.add(new SimpleBlockTriangle(
                GameLayout.world,
                this.player,
                this,
                70,
                0,
                180,
                new Vector2(MyGdxGame.width/2, MyGdxGame.height + 10),
                new Vector2(0, - 40),
                1
        ));
    }
}
