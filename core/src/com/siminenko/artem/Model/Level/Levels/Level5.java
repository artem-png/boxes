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
                new Vector2(MyGdxGame.width/2 - 10, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width/2 - 5, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width/2, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width/2 + 5, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                0,
                new Vector2(MyGdxGame.width/2 + 10, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                140,
                15,
                new Vector2(MyGdxGame.width/2 - 8, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                15,
                new Vector2(MyGdxGame.width/2 + 8, MyGdxGame.height + 10)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                70,
                15,
                new Vector2(MyGdxGame.width/2, MyGdxGame.height + 10)
        ));
    }
}
