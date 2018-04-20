package com.siminenko.artem.Model.Scenario;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */

public class ObstaclePanelVerticalGroupScenario extends AScenario {

    public ObstaclePanelVerticalGroupScenario(World world) {
        Random random = new Random();
        int delta = random.nextInt(15) - 7;
        this.vector.add(new ObstacleConfiguration(new Vector2(MyGdxGame.width/2 - delta, 100), OBSTACLE_PANEL_VERTICAL, world, 120));

        for (int i = 0; i < 5; i++) {
            delta = random.nextInt(15) - 7;
            this.vector.add(new ObstacleConfiguration(new Vector2(MyGdxGame.width/2 - delta, 100), OBSTACLE_PANEL_VERTICAL, world, 25));
        }
    }
}
