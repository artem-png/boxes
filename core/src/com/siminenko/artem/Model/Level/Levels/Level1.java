package com.siminenko.artem.Model.Level.Levels;

import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Layout.GameLayout;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Scenarious.General.SimpleBlockVertical;
import com.siminenko.artem.Model.Level.Scenarious.Level1.TutorialMove;

/**
 * Created by User on 22.04.2018.
 */

public class Level1 extends ALevel {

    public Level1() {

    }

    @Override
    public void init() {
        this.aScenarioVector2.add(new TutorialMove(GameLayout.world, this.player, this, 30));
        this.aScenarioVector2.add(new SimpleBlockVertical(GameLayout.world, this.player, this, 30));
    }
}
