package com.lisuart.falldown.Model.Level;

import com.lisuart.falldown.Config.Progress;

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
