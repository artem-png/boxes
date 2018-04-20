package com.siminenko.artem.Model.Scenario;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */

public class ObstacleTriangleGroupScenario extends AScenario {
    public ObstacleTriangleGroupScenario(World world) {
        Random random = new Random();
        int delta = random.nextInt(10) - 5;
        ObstacleConfiguration o = new ObstacleConfiguration(new Vector2(MyGdxGame.width/2 - delta, 130), OBSTACLE_TRIANGLE, world, 150);
        o.gravityScale = 0.9f;
        this.vector.add(o);

        for (int i = 0; i < 5; i++) {
            delta = random.nextInt(10) - 5;
            o = new ObstacleConfiguration(new Vector2(MyGdxGame.width/2 - delta, 130), OBSTACLE_TRIANGLE, world, 50);
            o.gravityScale = 0.9f;
            this.vector.add(o);
        }
    }
}
