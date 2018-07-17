package com.siminenko.falldown.Model.Level;

/**
 * Created by User on 22.04.2018.
 */

public class LevelGetter {

    public static ALevel getLevel() {
        return com.siminenko.falldown.Config.Progress.getNextLevel();
    }

    public static ALevel getLevel(int level) {
        return com.siminenko.falldown.Config.Progress.getLevelByInt(level);
    }

}
