package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircleBomb;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockHorizontal;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBonusBig;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level8 extends ALevel {

    public Level8() {

    }

    @Override
    public void init() {
        com.lisuart.falldown.Model.Level.Scenarious.Level9.TutorialBonusBig tutorialBonusBig = new com.lisuart.falldown.Model.Level.Scenarious.Level9.TutorialBonusBig(GameLayout.world, this.player, this, 0);
        this.aScenarioVector2.add(tutorialBonusBig);
        SimpleBonusBig cb = new SimpleBonusBig(
                GameLayout.world,
                this.player,
                this,
                10,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 10),
                1
        );
        this.aScenarioVector2.add(cb);

        SimpleBlockCircleBomb b = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                60,
                5,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 15, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);

        b = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - 5, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);

        b = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 5, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);

        b = new SimpleBlockCircleBomb(
                GameLayout.world,
                this.player,
                this,
                0,
                5,
                new Vector2(0, 0),
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + 15, com.lisuart.falldown.MyGdxGame.height + 10),
                1,
                5,
                160
        );
        this.aScenarioVector2.add(b);
///////////////////
        Random random = new Random();
        SimpleBlockVertical z = new SimpleBlockVertical(
                GameLayout.world,
                player,
                this,
                120,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - (random.nextInt(20)  - 10), com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new SimpleBlockVertical(
                GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - (random.nextInt(20)  - 10), com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new SimpleBlockVertical(
                GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - (random.nextInt(20)  - 10), com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new SimpleBlockVertical(
                GameLayout.world,
                player,
                this,
                25,
                5,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - (random.nextInt(20)  - 10), com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new SimpleBlockVertical(
                GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - (random.nextInt(20)  - 10), com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        z = new SimpleBlockVertical(
                GameLayout.world,
                player,
                this,
                25,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 - (random.nextInt(20)  - 10), com.lisuart.falldown.MyGdxGame.height + 10),
                new Vector2(0, -5)
        );
        this.aScenarioVector2.add(z);

        SimpleBlockHorizontal xz = new SimpleBlockHorizontal(
                GameLayout.world,
                player,
                this,
                120,
                0,
                new Vector2(com.lisuart.falldown.MyGdxGame.width / 2, com.lisuart.falldown.MyGdxGame.height + 40),
                new Vector2(0, -10),
                30,
                30
        );
        this.aScenarioVector2.add(xz);

        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                250,
                30 + random.nextInt(3),
                new Vector2(-10, com.lisuart.falldown.MyGdxGame.height - 25),
                new Vector2(19, 0)
        ));
        this.aScenarioVector2.add(new SimpleBlockVertical(
                GameLayout.world,
                this.player,
                this,
                0,
                30 + random.nextInt(3),
                new Vector2(com.lisuart.falldown.MyGdxGame.width + 10, com.lisuart.falldown.MyGdxGame.height - 25),
                new Vector2(-19, 0)
        ));
    }
}
