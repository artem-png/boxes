package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
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
                new Vector2(MyGdxGame.width/2, MyGdxGame.height + 10),
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
                new Vector2(MyGdxGame.width/2 - 5, MyGdxGame.height + 10),
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
                new Vector2(MyGdxGame.width/2 + 5, MyGdxGame.height + 10),
                new Vector2(0, 0),
                0,
                0,
                15,
                1,
                2,
                1
        ));
    }
}
