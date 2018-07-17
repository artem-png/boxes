package com.siminenko.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBonusBig;
import com.siminenko.falldown.Model.Level.Scenarious.Level9.TutorialBonusBig;
import com.siminenko.falldown.MyGdxGame;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level8 extends com.siminenko.falldown.Model.Level.ALevel {

    public Level8() {

    }

    @Override
    public void init() {
        TutorialBonusBig tutorialBonusBig = new TutorialBonusBig(com.siminenko.falldown.Layout.GameLayout.world, this.player, this, 0);
        this.aScenarioVector2.add(tutorialBonusBig);
        SimpleBonusBig cb = new SimpleBonusBig(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                10,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 10),
                1
        );
        this.aScenarioVector2.add(cb);

        com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb b = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                60,
                5,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 15, MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);

        b = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 - 5, MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);

        b = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 5, MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);

        b = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, 0),
                new Vector2(MyGdxGame.width / 2 + 15, MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);
///////////////////
        Random random = new Random();
        com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical z = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                120,
                0,
                new Vector2(MyGdxGame.width / 2 - (random.nextInt(20)  - 10), MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(MyGdxGame.width / 2 - (random.nextInt(20)  - 10), MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(MyGdxGame.width / 2 - (random.nextInt(20)  - 10), MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                25,
                5,
                new Vector2(MyGdxGame.width / 2 - (random.nextInt(20)  - 10), MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(MyGdxGame.width / 2 - (random.nextInt(20)  - 10), MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(MyGdxGame.width / 2 - (random.nextInt(20)  - 10), MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal xz = new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal(
                com.siminenko.falldown.Layout.GameLayout.world,
                player,
                this,
                120,
                0,
                new Vector2(MyGdxGame.width / 2, MyGdxGame.height + 40),
                new Vector2(0, -10),
                30,
                30
        );
        this.aScenarioVector2.add(xz);

        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                250,
                30 + random.nextInt(3),
                new Vector2(-10, MyGdxGame.height - 25),
                new Vector2(19, 0)
        ));
        this.aScenarioVector2.add(new com.siminenko.falldown.Model.Level.Scenarious.General.SimpleBlockVertical(
                com.siminenko.falldown.Layout.GameLayout.world,
                this.player,
                this,
                0,
                30 + random.nextInt(3),
                new Vector2(MyGdxGame.width + 10, MyGdxGame.height - 25),
                new Vector2(-19, 0)
        ));
    }
}
