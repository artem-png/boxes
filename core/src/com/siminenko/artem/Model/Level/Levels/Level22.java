package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockX;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBonusBig;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level22 extends ALevel {

    public Level22() {
        // this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 1700;
        // this.clockTime = 1700;
    }

    @Override
    public void init() {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            this.aScenarioVector2.add(new SimpleBlockCircle(
                    GameLayout.world,
                    player,
                    this,
                    7,
                    2,
                    new Vector2(0, -25),
                    new Vector2(MyGdxGame.width / 2 + (float) Math.sin(i / 4f) * 1.7f, MyGdxGame.height + 10)
            ));
        }

        for (int i = 0; i < 4; i++) {
            int f = random.nextInt(4);
            Vector2 position = new Vector2();
            Vector2 speed = new Vector2();
            if (f == 0) {
                position.set(-4, MyGdxGame.height);
                speed.set(13, -22);
            } else if (f == 1) {
                position.set(-4, MyGdxGame.height - 20);
                speed.set(17, -22);
            } else if (f == 2) {
                position.set(MyGdxGame.width + 4, MyGdxGame.height - 20);
                speed.set(-17, -22);
            } else if (f == 3) {
                position.set(MyGdxGame.width + 4, MyGdxGame.height);
                speed.set(-13, -22);
            }
            for (int j = 0 ; j < 24; j ++) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        j == 0 ? 80 : 8,
                        2,
                        speed,
                        position
                ));
            }

        }
    }
}
