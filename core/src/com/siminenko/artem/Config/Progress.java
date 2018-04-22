package com.siminenko.artem.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Levels.Level1;
import com.siminenko.artem.Model.Level.Levels.Level2;

/**
 * Created by User on 22.04.2018.
 */

public class Progress {
    public static final String progress = "progress";
    public static final String levelProgress = "levelProgress";
    public static int[] levels = new int[2];

    public void init() {
        Preferences prefs = Gdx.app.getPreferences(progress);
        for (int i = 0; i < levels.length; i ++) {
            levels[i] = prefs.getInteger("level" + (i + 1), 0);
        }
    }

    public static void saveLevelProgress(int level) {
        Preferences prefs = Gdx.app.getPreferences(progress);
        prefs.putInteger("level" + level, 1);
        levels[level - 1] = 1;
        prefs.flush();
    }

    public static ALevel getNextLevel() {
        int index = 1;
        for (int i = 0; i < levels.length; i ++) {
            if (levels[i] == 1) {
                index = i + 2;
            }
        }

        return getLevelByInt(index);
    }

    public static ALevel getLevelByInt(int index) {
        ALevel level = null;

        if (index > levels.length) {
            index = levels.length;
        }

        if (index == 1) {
            level = new Level1();
        } else if (index == 2) {
            level = new Level2();
        }
        level.setNumber(index);

        return level;
    }
}
