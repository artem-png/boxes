package com.siminenko.artem.Model.Scenario;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */

public class SimpleObstacleBigPanelScenario extends AScenario {
    public SimpleObstacleBigPanelScenario(World world) {
        Random random = new Random();
        int delta = random.nextInt(5) - 2;
        this.vector.add(new ObstacleConfiguration(new Vector2(MyGdxGame.width/2 - delta, 100), OBSTACLE_BIG_PANEL, world, 150));
    }
}
