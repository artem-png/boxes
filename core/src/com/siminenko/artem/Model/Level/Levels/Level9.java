package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.BonusBig;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBonusBig;
import com.siminenko.artem.MyGdxGame;

/**
 * Created by User on 22.04.2018.
 */

public class Level9 extends ALevel {

    public Level9() {

    }

    @Override
    public void init() {
        SimpleBonusBig cb = new SimpleBonusBig(
                GameLayout.world,
                this.player,
                this,
                50,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                1
        );
        this.aScenarioVector2.add(cb);

        SimpleBlockCircleBomb b = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                100,
                10,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 11, MyGdxGame.height + 10),
                1,
                20,
                160
        );
        this.aScenarioVector2.add(b);
    }
}
