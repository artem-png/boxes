package com.siminenko.artem.Model.Level.Levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Infinite.Score;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.AScenario;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockTriangle;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockX;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBonusBig;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBonusCoin;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;
import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public class LevelLoop extends ALevel {
    Score score;
    Random random;

    int delaySimpleScenario = 0;
    int delayComplexScenario = 0;

    int maxChance = 10000;
    int complexScenarioChance = 1400;
    int coinChance = 4;
    int bigChance = 2;

    public LevelLoop() {
        this.level = 0;
        this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 2800;
        this.clockTime = 2800;
        score = new Score();
        Score.score = 0;
        random = new Random();
    }

    public static void initStatic() {
        Score.init();
    }

    @Override
    public void init() {

    }

    public void act() {
        super.act();
        score.act();

        if (delaySimpleScenario > 0) {
            delaySimpleScenario--;
        }
        if (this.aScenarioVector2.size() == 0) {
            int result = random.nextInt(this.maxChance);
            if (result < this.complexScenarioChance) {
                System.out.println("COMPLEX");
                Vector<AScenario> scenarios = this.getComplexScenario();
                for (int i = 0; i < scenarios.size(); i ++) {
                    this.aScenarioVector2.add(scenarios.get(i));
                }
            } else {
                System.out.println("SIMPLE");
                this.aScenarioVector2.add(this.getSimpleScenario());
            }
        }

        this.setBonuses();
    }

    public void render(SpriteBatch b) {
        super.render(b);
        score.render(b);
    }

    public boolean isComplete() {
        return false;
    }

    public void afterWin() {

    }

    public void dispose() {
        super.dispose();
    }

    public void setBonuses() {
        int r = random.nextInt(maxChance);
        if (r < this.bigChance) {
            this.aScenarioVector2.add(new SimpleBonusBig(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    new Vector2(random.nextInt(MyGdxGame.width - 10) + 5, MyGdxGame.height + 5),
                    random.nextInt(5),
                    300 + random.nextInt(400)
            ));
            System.out.println("BIG");
        }
        if (r > this.bigChance && r < (this.bigChance + this.coinChance)) {
            this.aScenarioVector2.add(new SimpleBonusCoin(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    new Vector2(random.nextInt(MyGdxGame.width - 10) + 5, MyGdxGame.height + 5),
                    random.nextInt(5)
            ));
            System.out.println("COIN");
        }
    }

    public int getComplexScenarioDelay()
    {
        return 120 + delayComplexScenario;
    }

    public Vector<AScenario> getComplexScenario()
    {
        Vector<AScenario> scenarios = new Vector<AScenario>();

        int result = random.nextInt(3);
        if (result == 0) {
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
            for (int j = 0 ; j < 15; j ++) {
                scenarios.add(new SimpleBlockCircle(
                        GameLayout.world,
                        player,
                        this,
                        j == 0 ? this.getComplexScenarioDelay() : 8,
                        2,
                        speed,
                        position
                ));
            }
        } else if (result == 1) {
            scenarios.add(new SimpleBlockBig(GameLayout.world, this.player, this, this.getComplexScenarioDelay(), 0));
            for (int i = 0; i < 25; i ++) {
                scenarios.add(new SimpleBlockCircle(
                        GameLayout.world,
                        this.player,
                        this,
                        i == 0 ? 90 : (i == 19 ? 60 : 3),
                        random.nextInt(4) + 2,
                        new Vector2(0, -5),
                        new Vector2(MyGdxGame.width / 2 + random.nextInt(30) - 15, MyGdxGame.height + 15))
                );
            }
        } else if (result == 2) {
            for (int i = 0; i < 9; i ++) {
                scenarios.add(new SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        i == 0 ? 180 : 30,
                        random.nextInt(10),
                        0,
                        new Vector2(-5, MyGdxGame.height - i * 4),
                        new Vector2(50, 5),
                        1,
                        1
                ));
                scenarios.add(new SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        random.nextInt(10),
                        0,
                        new Vector2(MyGdxGame.width + 5, MyGdxGame.height - i * 4),
                        new Vector2(-50, 5),
                        1,
                        1
                ));
            }
        }

        this.delaySimpleScenario += 60;
        return scenarios;
    }

    public int getSimpleScenarioDelay()
    {
        return 80 + delaySimpleScenario;
    }

    public AScenario getSimpleScenario() {
        int result = random.nextInt(5);
        AScenario aScenario = null;

        if (result == 0) {
            aScenario = new SimpleBlockCircle(
                    GameLayout.world,
                    player,
                    this,
                    this.getSimpleScenarioDelay(),
                    random.nextInt(3) + 2,
                    new Vector2(random.nextInt(10) - 5, -5),
                    new Vector2(random.nextInt(20) - 10 + MyGdxGame.width / 2, MyGdxGame.height + 10)
            );
        } else if (result == 1) {
            aScenario = new SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    this.getSimpleScenarioDelay(),
                    random.nextInt(10),
                    0,
                    new Vector2(random.nextInt(20) - 10 + MyGdxGame.width / 2, MyGdxGame.height + 10),
                    new Vector2(random.nextInt(10) - 5, -5),
                    1,
                    1 + random.nextInt(2)
            );
        } else if (result == 2) {
            aScenario = new SimpleBlockX(
                    GameLayout.world,
                    player,
                    this,
                    new Vector2(random.nextInt(20) - 10 + MyGdxGame.width / 2, MyGdxGame.height + 10),
                    new Vector2(random.nextInt(10) - 5, -5),
                    this.getSimpleScenarioDelay(),
                    random.nextInt(10),
                    random.nextInt(10),
                    1,
                    1,
                    0.5f + random.nextFloat()
            );
        } else if (result == 3) {
            aScenario = new SimpleBlockCircleDestroyable(
                    GameLayout.world,
                    player,
                    this,
                    this.getSimpleScenarioDelay(),
                    8,
                    new Vector2(random.nextInt(10) - 5, -5),
                    new Vector2(random.nextInt(20) - 10 + MyGdxGame.width / 2, MyGdxGame.height + 10),
                    2
            );
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
            aScenario = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    player,
                    this,
                    this.getSimpleScenarioDelay(),
                    random.nextInt(4) + 3,
                    speed,
                    position,
                    1,
                    5 + random.nextInt(8),
                    random.nextInt(50) + 60
            );
        } else if (result == 5) {
            aScenario = new SimpleBlockHorizontal(
                    GameLayout.world,
                    this.player,
                    this,
                    this.getSimpleScenarioDelay(),
                    random.nextInt(5),
                    new Vector2(MyGdxGame.width / 2 + random.nextInt(10) - 5, MyGdxGame.height + 5),
                    new Vector2(0, -20),
                    8,
                    2
            );
        }

        return aScenario;
    }

}
