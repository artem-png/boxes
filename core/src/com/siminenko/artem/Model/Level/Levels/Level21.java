package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
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

public class Level21 extends ALevel {

    int delay = 30;

    public Level21() {
        // this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 1700;
        // this.clockTime = 1700;
    }

    @Override
    public void init() {
        Random random = new Random();

        for (int i = 0; i < 80; i++) {
            if (i % 10 == 0) {
                this.aScenarioVector2.add(new SimpleBonusBig(
                                GameLayout.world,
                                player,
                                this,
                                20,
                                new Vector2(random.nextInt(MyGdxGame.width - 10) + 5, MyGdxGame.height + 5),
                                random.nextInt(5),
                                200
                        )
                );
            }

            int result = random.nextInt(6);
            if (result == 0) {
                this.aScenarioVector2.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        delay,
                        random.nextInt(3) + 2,
                        new Vector2(random.nextInt(10) - 5, -5),
                        new Vector2(random.nextInt(20) - 10 + MyGdxGame.width/2, MyGdxGame.height + 10)
                ));
            } else if (result == 1) {
                this.aScenarioVector2.add(new SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        delay,
                        random.nextInt(10),
                        0,
                        new Vector2(random.nextInt(20) - 10 + MyGdxGame.width/2, MyGdxGame.height + 10),
                        new Vector2(random.nextInt(10) - 5, -5),
                        1,
                        1 + random.nextInt(2)
                ));
            } else if (result == 2) {
                this.aScenarioVector2.add(new SimpleBlockX(
                        GameLayout.world,
                        player,
                        this,
                        new Vector2(random.nextInt(20) - 10 + MyGdxGame.width/2, MyGdxGame.height + 10),
                        new Vector2(random.nextInt(10) - 5, -5),
                        delay,
                        random.nextInt(10),
                        random.nextInt(10),
                        1,
                        1,
                        0.5f + random.nextFloat()
                ));
            } else if (result == 3) {
                this.aScenarioVector2.add(new SimpleBlockCircleDestroyable(
                        GameLayout.world,
                        player,
                        this,
                        delay,
                        8,
                        new Vector2(random.nextInt(10) - 5, -5),
                        new Vector2(random.nextInt(20) - 10 + MyGdxGame.width/2, MyGdxGame.height + 10),
                        2
                ));
            } else if (result == 4) {
                int f = random.nextInt(4);
                Vector2 position = new Vector2();
                Vector2 speed = new Vector2();
                if (f == 0) {
                    position.set(-5, MyGdxGame.height - 24);
                    speed.set(15, 10);
                } else if (f == 1) {
                    position.set(MyGdxGame.width + 5, MyGdxGame.height - 24);
                    speed.set(-15, 10);
                } else if (f == 2) {
                    position.set(-5, MyGdxGame.height - 35);
                    speed.set(15, 10);
                } else if (f == 3) {
                    position.set(MyGdxGame.width + 5, MyGdxGame.height - 35);
                    speed.set(-15, 10);
                }
                this.aScenarioVector2.add(new SimpleBlockCircleBomb(
                        GameLayout.world,
                        player,
                        this,
                        delay,
                        random.nextInt(4) + 3,
                        speed,
                        position,
                        1,
                        5 + random.nextInt(8),
                        random.nextInt(50) + 60
                ));
            } else if (result == 5) {
                this.aScenarioVector2.add(new SimpleBlockHorizontal(
                        GameLayout.world,
                        this.player,
                        this,
                        delay,
                        random.nextInt(5),
                        new Vector2(MyGdxGame.width/2 + random.nextInt(10) - 5, MyGdxGame.height + 5),
                        new Vector2(0, -20),
                        8,
                        2
                ));
            }
        }
    }
}
