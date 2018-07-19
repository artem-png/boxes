package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Infinite.Score;
import com.lisuart.falldown.Model.Level.AScenario;
import com.lisuart.falldown.Model.Level.Scenarious.General.KinematicBlockHorizontalMovable;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockBig;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleDestroyable;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockX;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBonusCoin;

import java.util.Random;
import java.util.Vector;

/**
 * Created by User on 22.04.2018.
 */

public class LevelLoop extends com.lisuart.falldown.Model.Level.ALevel {
    Score score;
    Random random;

    int delaySimpleScenario = 0;
    int delayComplexScenario = 0;

    int maxChance = 10000;
    int complexScenarioChance = 1500;
    int kinematicScenarioChance = 190;
    int coinChance = 6;
    int bigChance = 2;

    int kineticType = 0;

    int time = 0;

    public LevelLoop() {
        this.level = 0;
        this.hasTimePower = true;
        this.hasBlockPower = true;
        this.blockTime = 3000;
        this.clockTime = 3000;
        score = new Score();
        Score.score = 0;
        random = new Random();
    }

    public static void initStatic() {
        Score.init();
    }

    @Override
    public void afterInit() {
        super.afterInit();
        GameLayout.world.setGravity(new Vector2(0, -9f));
    }

    @Override
    public void init() {

    }

    public void act() {
        super.act();
        score.act();

        time += 1;
        if (time % 3600 == 0) {
            System.out.println("GRAVITY DECREASE");
            GameLayout.world.setGravity(new Vector2(0, GameLayout.world.getGravity().y - 1));
        }


        if (delaySimpleScenario > 0) {
            delaySimpleScenario--;
        }

        if (this.kinematicCount() == 0) {
            this.kineticType = 0;
        }

        if (this.aScenarioVector2.size() == 0) {
            int result = random.nextInt(this.maxChance);
            if (this.kinematicCount() == 0 && result <= this.kinematicScenarioChance) {
                System.out.println("KINETIC");
                Vector<AScenario> scenarios = this.getKinematicScenario();
                for (int i = 0; i < scenarios.size(); i++) {
                    this.aScenarioVector2.add(scenarios.get(i));
                }

            } else if (result > this.kinematicScenarioChance && result < this.complexScenarioChance + this.kinematicScenarioChance) {
                System.out.println("COMPLEX");
                Vector<AScenario> scenarios = this.getComplexScenario();
                for (int i = 0; i < scenarios.size(); i++) {
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
        score.render(b);
        super.render(b);
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
            this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBonusBig(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    new Vector2(random.nextInt(com.lisuart.falldown.MyGdxGame.width - 10) + 5, com.lisuart.falldown.MyGdxGame.height + 5),
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
                    new Vector2(random.nextInt(com.lisuart.falldown.MyGdxGame.width - 10) + 5, com.lisuart.falldown.MyGdxGame.height + 5),
                    random.nextInt(5)
            ));
            System.out.println("COIN");
        }
    }

    public int getComplexScenarioDelay() {
        return 120 + delayComplexScenario;
    }


    public Vector<AScenario> getKinematicScenario() {
        Vector<AScenario> scenarios = new Vector<AScenario>();
        int result = random.nextInt(1);
        int time = 200 + random.nextInt(400);
        if (result == 0) {
            scenarios.add(new KinematicBlockHorizontalMovable(
                    GameLayout.world,
                    player,
                    this,
                    30,
                    (float) Math.toRadians(-20),
                    0,
                    new Vector2(-10, 4),
                    new Vector2(8, 4),
                    new Vector2(1, 0),
                    25,
                    2,
                    1f,
                    time
            ));
            scenarios.add(new KinematicBlockHorizontalMovable(
                    GameLayout.world,
                    player,
                    this,
                    0,
                    (float) Math.toRadians(20),
                    0,
                    new Vector2(com.lisuart.falldown.MyGdxGame.width + 10, 4),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width - 7, 4),
                    new Vector2(-1, 0),
                    25,
                    2,
                    1f,
                    time
            ));
            kineticType = 1;
        }
        return scenarios;
    }


    public Vector<AScenario> getComplexScenario() {
        Vector<AScenario> scenarios = new Vector<AScenario>();

        int maxInt = 13;
        int result = random.nextInt(maxInt);

        // kineticType = 1 bottom panels
        if (result == 3 && kineticType == 1) {
            while (result == 3) {
                result = random.nextInt(maxInt);
            }
        }

        if (result == 0) {
            int f = random.nextInt(4);
            Vector2 position = new Vector2();
            Vector2 speed = new Vector2();
            if (f == 0) {
                position.set(-4, com.lisuart.falldown.MyGdxGame.height);
                speed.set(13, -22);
            } else if (f == 1) {
                position.set(-4, com.lisuart.falldown.MyGdxGame.height - 20);
                speed.set(17, -22);
            } else if (f == 2) {
                position.set(com.lisuart.falldown.MyGdxGame.width + 4, com.lisuart.falldown.MyGdxGame.height - 20);
                speed.set(-17, -22);
            } else if (f == 3) {
                position.set(com.lisuart.falldown.MyGdxGame.width + 4, com.lisuart.falldown.MyGdxGame.height);
                speed.set(-13, -22);
            }
            for (int j = 0; j < 15; j++) {
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
            for (int i = 0; i < 25; i++) {
                scenarios.add(new SimpleBlockCircle(
                        GameLayout.world,
                        this.player,
                        this,
                        i == 0 ? 90 : (i == 19 ? 60 : 3),
                        random.nextInt(4) + 2,
                        new Vector2(0, -5),
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + random.nextInt(30) - 15, com.lisuart.falldown.MyGdxGame.height + 15))
                );
            }
        } else if (result == 2) {
            for (int i = 0; i < 9; i++) {
                scenarios.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        i == 0 ? 180 : 30,
                        random.nextInt(10),
                        0,
                        new Vector2(-5, com.lisuart.falldown.MyGdxGame.height - i * 4),
                        new Vector2(50, 5),
                        1,
                        1
                ));
                scenarios.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        random.nextInt(10),
                        0,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height - i * 4),
                        new Vector2(-50, 5),
                        1,
                        1
                ));
            }
        } else if (result == 3) {
            for (int i = 0; i < 20; i++) {
                scenarios.add(new SimpleBlockX(
                        GameLayout.world,
                        player,
                        this,
                        new Vector2(i % 2 == 0 ? -10 : com.lisuart.falldown.MyGdxGame.width + 10, 0),
                        new Vector2(i % 2 == 0 ? 9 : -9, 30),
                        i == 0 ? 120 : 15,
                        0,
                        random.nextInt(15),
                        1,
                        1,
                        0.8f
                ));
            }
        } else if (result == 4) {
            for (int i = 0; i < 10; i++) {
                int f = random.nextInt(5);
                if (f == 0) {
                    scenarios.add(new SimpleBlockCircle(
                            GameLayout.world,
                            player,
                            this,
                            i == 0 ? 140 : 40,
                            4,
                            new Vector2(12, -35),
                            new Vector2(0.5f, 85)
                    ));
                } else if (f == 1) {
                    scenarios.add(new SimpleBlockCircle(
                            GameLayout.world,
                            player,
                            this,
                            i == 0 ? 140 : 40,
                            4,
                            new Vector2(0, -35),
                            new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 2)
                    ));

                } else if (f == 2) {
                    scenarios.add(new SimpleBlockCircle(
                            GameLayout.world,
                            player,
                            this,
                            i == 0 ? 140 : 40,
                            4,
                            new Vector2(-12, -35),
                            new Vector2(com.lisuart.falldown.MyGdxGame.width - 1.5f, 85)
                    ));

                } else if (f == 3) {
                    scenarios.add(new SimpleBlockCircle(
                            GameLayout.world,
                            player,
                            this,
                            i == 0 ? 140 : 50,
                            4,
                            new Vector2(17, -25),
                            new Vector2(-1, 50)
                    ));
                } else if (f == 4) {
                    scenarios.add(new SimpleBlockCircle(
                            GameLayout.world,
                            player,
                            this,
                            i == 0 ? 140 : 50,
                            4,
                            new Vector2(-17, -25),
                            new Vector2(com.lisuart.falldown.MyGdxGame.width, 50)
                    ));
                }
            }
        } else if (result == 5) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    scenarios.add(new SimpleBlockVertical(
                            GameLayout.world,
                            this.player,
                            this,
                            j == 0 ? 90 : 0,
                            0,
                            new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 12 + j * 5, com.lisuart.falldown.MyGdxGame.height + 10),
                            new Vector2(0, -15)
                    ));
                }
            }
        } else if (result == 6) {
            for (int j = 0; j < 2; j++) {
                for (int i = -3; i < 3; i++) {
                    scenarios.add(new SimpleBlockHorizontal(
                            GameLayout.world,
                            this.player,
                            this,
                            i == -3 ? 120 : 5,
                            0,
                            new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + i * 4, com.lisuart.falldown.MyGdxGame.height + 5),
                            new Vector2(0, -10),
                            2,
                            7
                    ));
                }
                for (int i = 3; i >= -3; i--) {
                    scenarios.add(new SimpleBlockHorizontal(
                            GameLayout.world,
                            this.player,
                            this,
                            i == 2 ? 25 : 5,
                            0,
                            new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + i * 4, com.lisuart.falldown.MyGdxGame.height + 5),
                            new Vector2(0, -10),
                            2,
                            7
                    ));
                }
            }
        } else if (result == 7) {
            for (int i = 0; i < 6; i++) {
                scenarios.add(new SimpleBlockVertical(
                        GameLayout.world,
                        this.player,
                        this,
                        i == 0 ? 140 : 60,
                        0,
                        new Vector2(-5, com.lisuart.falldown.MyGdxGame.height / 2 + 12),
                        new Vector2(40, 5),
                        4,
                        30,
                        1
                ));
                scenarios.add(new SimpleBlockVertical(
                        GameLayout.world,
                        this.player,
                        this,
                        0,
                        0,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height / 2 + 12),
                        new Vector2(-40, 5),
                        4,
                        30,
                        1
                ));
            }
        } else if (result == 8) {
            int f = random.nextInt(2);
            Vector2 position = new Vector2();
            Vector2 speed = new Vector2();
            if (f == 0) {
                position.set(-5, random.nextInt(15) + 30);
                speed.set(random.nextInt(10) + 30, 14 + random.nextInt(5));
            } else {
                position.set(com.lisuart.falldown.MyGdxGame.width + 5, random.nextInt(15) + 30);
                speed.set(-(random.nextInt(10) + 30), 14 + random.nextInt(5));
            }
            for (int i = 0; i < 10; i++) {
                scenarios.add(new SimpleBonusCoin(
                        GameLayout.world,
                        player,
                        this,
                        i == 0 ? 120 : 8,
                        position,
                        speed,
                        random.nextInt(5)
                ));
            }
        } else if (result == 9) {
            for (int i = 0; i < 8; i ++) {
                scenarios.add(new SimpleBlockBig(GameLayout.world, this.player, this, i == 0 ? 140 : 30, 0));
            }
        } else if (result == 10) {
            SimpleBlockCircleBomb cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    180,
                    10,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    0,
                    160
            );
            scenarios.add(cb);
            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    0,
                    6,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    14,
                    160
            );
            scenarios.add(cb);

            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    130,
                    10,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    0,
                    160
            );
            scenarios.add(cb);
            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    0,
                    6,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    14,
                    160
            );
            scenarios.add(cb);

            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    130,
                    6,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    0,
                    160
            );
            scenarios.add(cb);
            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    0,
                    10,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    14,
                    160
            );
            scenarios.add(cb);

            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    130,
                    10,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    0,
                    160
            );
            scenarios.add(cb);
            cb = new SimpleBlockCircleBomb(
                    GameLayout.world,
                    this.player,
                    this,
                    0,
                    6,
                    new Vector2(0, -5),
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 11, com.lisuart.falldown.MyGdxGame.height + 10),
                    1,
                    14,
                    160
            );
            scenarios.add(cb);
        } else if (result == 11) {
            for (int i = 0; i < 4; i ++) {
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        i == 0 ? 160 : 100,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 4),
                        new Vector2(0, -15),
                        0.5f,
                        3
                ));
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 10, com.lisuart.falldown.MyGdxGame.height + 3.5f),
                        new Vector2(-3.3f, -15),
                        0.5f,
                        3
                ));
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 10, com.lisuart.falldown.MyGdxGame.height + 3.5f),
                        new Vector2(3.3f, -15),
                        0.5f,
                        3
                ));
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 20, com.lisuart.falldown.MyGdxGame.height + 2.7f),
                        new Vector2(6.5f, -15),
                        0.5f,
                        3
                ));
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 20, com.lisuart.falldown.MyGdxGame.height + 2.5f),
                        new Vector2(-6.5f, -15),
                        0.5f,
                        3
                ));
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 30, com.lisuart.falldown.MyGdxGame.height + 2f),
                        new Vector2(10f, -15),
                        0.5f,
                        3
                ));
                this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                        GameLayout.world,
                        player,
                        this,
                        0,
                        0,
                        180,
                        new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 30, com.lisuart.falldown.MyGdxGame.height + 2f),
                        new Vector2(-10f, -15),
                        0.5f,
                        3
                ));
            }
        } else if (result == 12) {
            for (int i = 0; i < 40; i++) {
                scenarios.add(new SimpleBlockX(
                        GameLayout.world,
                        player,
                        this,
                        new Vector2(-5, com.lisuart.falldown.MyGdxGame.height - 32 - i * 1.4f),
                        new Vector2(23, 3.8f),
                        i == 0 ? 160 : 8,
                        0,
                        random.nextInt(15),
                        1,
                        1,
                        0.4f
                ));
            }
        }

        this.delaySimpleScenario += 60;
        return scenarios;
    }

    public int getSimpleScenarioDelay() {
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
                    new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10)
            );
        } else if (result == 1) {
            aScenario = new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockTriangle(
                    GameLayout.world,
                    player,
                    this,
                    this.getSimpleScenarioDelay(),
                    random.nextInt(10),
                    0,
                    new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                    new Vector2(random.nextInt(10) - 5, -5),
                    1,
                    1 + random.nextInt(2)
            );
        } else if (result == 2) {
            aScenario = new SimpleBlockX(
                    GameLayout.world,
                    player,
                    this,
                    new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
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
                    new Vector2(random.nextInt(20) - 10 + com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                    2
            );
        } else if (result == 4) {
            int f = random.nextInt(4);
            Vector2 position = new Vector2();
            Vector2 speed = new Vector2();
            if (f == 0) {
                position.set(-5, com.lisuart.falldown.MyGdxGame.height - 24);
                speed.set(15, 10);
            } else if (f == 1) {
                position.set(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height - 24);
                speed.set(-15, 10);
            } else if (f == 2) {
                position.set(-5, com.lisuart.falldown.MyGdxGame.height - 35);
                speed.set(15, 10);
            } else if (f == 3) {
                position.set(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height - 35);
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
                    new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + random.nextInt(10) - 5, com.lisuart.falldown.MyGdxGame.height + 5),
                    new Vector2(0, -20),
                    8,
                    2
            );
        }

        return aScenario;
    }

}
