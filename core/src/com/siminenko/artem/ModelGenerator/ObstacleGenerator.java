package com.siminenko.artem.ModelGenerator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.siminenko.artem.Model.AObject;
import com.siminenko.artem.Model.Scenario.AScenario;
import com.siminenko.artem.Model.Scenario.ObstacleCircleGroupScenario;
import com.siminenko.artem.Model.Scenario.ObstaclePanelGroupScenario;
import com.siminenko.artem.Model.Scenario.ObstaclePanelVerticalGroupScenario;
import com.siminenko.artem.Model.Scenario.ObstacleTriangleGroupScenario;
import com.siminenko.artem.Model.Scenario.SimpleObstacleBigPanelScenario;

import java.util.Random;
import java.util.Vector;

/**
 * Created by artem on 4/19/18.
 */

public class ObstacleGenerator {
    Vector<AObject> objects = new Vector<AObject>();
    World world;
    AScenario scenario;

    public ObstacleGenerator(World world) {
        this.world = world;
    }

    public void act() {
        generate();
        actObjects();
    }

    protected AScenario getRandomScenario() {
        Vector<AScenario> scenarios = new Vector<AScenario>();
        scenarios.add(new SimpleObstacleBigPanelScenario(this.world));
        scenarios.add(new ObstacleCircleGroupScenario(this.world));
        scenarios.add(new ObstaclePanelGroupScenario(this.world));
        scenarios.add(new ObstaclePanelVerticalGroupScenario(this.world));
        scenarios.add(new ObstacleTriangleGroupScenario(this.world));

        Random random = new Random();
        int result = random.nextInt(scenarios.size());

        return scenarios.get(result);
    }

    protected void generate() {
        if (scenario == null) {
            scenario = getRandomScenario();
        }
        scenario.act();
        if (scenario.isReady()) {
            this.objects.add(scenario.getObject());
        }
        if (scenario.isDispose()) {
            scenario = null;
        }
    }

    protected void actObjects() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).act();
        }

        for (int i = objects.size() - 1; i >= 0; i--) {
            if (objects.get(i).getDispose()) {
                objects.get(i).dispose();
                objects.remove(i);
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(batch);
        }
    }

    public void dispose() {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).dispose();
        }
    }
}
