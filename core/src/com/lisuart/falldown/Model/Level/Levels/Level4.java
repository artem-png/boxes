package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockBig;
import com.lisuart.falldown.Model.Level.ALevel;

import java.util.Random;

/**
 * Created by User on 22.04.2018.
 */

public class Level4 extends ALevel {

    public Level4() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new SimpleBlockBig(GameLayout.world, this.player, this, 30, 0));

        Random r = new Random();

        int offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 6, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 1, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 6, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 6, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 6, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 6, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 3, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 2, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 5, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));
        offset = r.nextInt(30) - 15;
        this.aScenarioVector2.add(new com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle(GameLayout.world, this.player, this, 5, 4, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width / 2 + offset, com.lisuart.falldown.MyGdxGame.height + 15)));

    }
}
