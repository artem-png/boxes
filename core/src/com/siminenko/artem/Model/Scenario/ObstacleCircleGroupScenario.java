package com.siminenko.artem.Model.Scenario;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.MyGdxGame;

import java.util.Random;

/**
 * Created by artem on 4/19/18.
 */

public class ObstacleCircleGroupScenario extends AScenario {

    public ObstacleCircleGroupScenario(World world) {
        Random random = new Random();
        int delta = random.nextInt(2);
        int positionX;
        if (delta == 0) {
            positionX = - 5;
        } else {
            positionX = MyGdxGame.width + 5;
        }
        int size = random.nextInt(3) + 3;
        int velocityX = random.nextInt(4) + 10;
        if (delta == 1) {
            velocityX *= - 1;
        }
        ObstacleConfiguration obstacleConfiguration = new ObstacleConfiguration(new Vector2(positionX, MyGdxGame.height + 5), OBSTACLE_CIRCLE, world, 200);
        obstacleConfiguration.setSize(size);
        obstacleConfiguration.setVelocity(new Vector2(velocityX, 0));
        this.vector.add(obstacleConfiguration);

        for (int i = 0; i < 10; i++) {
            delta = random.nextInt(2);
            if (delta == 0) {
                positionX = - 5;
            } else {
                positionX = MyGdxGame.width + 5;
            }
            size = random.nextInt(2) + 3;
            velocityX = random.nextInt(4) + 10;
            if (delta == 1) {
                velocityX *= - 1;
            }
            obstacleConfiguration = new ObstacleConfiguration(new Vector2(positionX, MyGdxGame.height + 5), OBSTACLE_CIRCLE, world, 35);
            obstacleConfiguration.setSize(size);
            obstacleConfiguration.setVelocity(new Vector2(velocityX, 0));
            this.vector.add(obstacleConfiguration);
        }
    }
}
