package com.siminenko.artem.Model.Level;

import com.siminenko.artem.Config.Progress;
import com.siminenko.artem.Model.Level.Levels.Level1;

/**
 * Created by User on 22.04.2018.
 */

public class LevelGetter {

    public static ALevel getLevel() {
        return Progress.getNextLevel();
    }

    public static ALevel getLevel(int level) {
        return Progress.getLevelByInt(level);
    }

}
