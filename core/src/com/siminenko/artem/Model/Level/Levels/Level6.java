package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
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

        this.aScenarioVector2.add(new SimpleBlockTriangle(
                GameLayout.world,
                this.player,
                this,
                50,
                0,
                180,
                new Vector2(MyGdxGame.width/2, MyGdxGame.height + 10),
                new Vector2(),
                0.5f
        ));
    }
}
