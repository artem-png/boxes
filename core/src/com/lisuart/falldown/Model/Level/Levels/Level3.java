package com.lisuart.falldown.Model.Level.Levels;

import com.badlogic.gdx.math.Vector2;
import com.lisuart.falldown.Layout.GameLayout;
import com.lisuart.falldown.Model.Level.ALevel;
import com.lisuart.falldown.Model.Level.Scenarious.General.SimpleBlockCircle;

/**
 * Created by User on 22.04.2018.
 */

public class Level3 extends ALevel {

    public Level3() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 30, 2, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 2, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 3, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 3, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 4, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 4, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 5, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 5, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 6, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 6, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 7, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 7, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 8, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 8, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 9, new Vector2(7, 0), new Vector2(-5, com.lisuart.falldown.MyGdxGame.height + 5)));
        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 0, 9, new Vector2(-7, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width + 5, com.lisuart.falldown.MyGdxGame.height + 5)));

        this.aScenarioVector2.add(new SimpleBlockCircle(GameLayout.world, this.player, this, 100, 15, new Vector2(0, 0), new Vector2(com.lisuart.falldown.MyGdxGame.width/2, com.lisuart.falldown.MyGdxGame.height + 5)));

    }
}
