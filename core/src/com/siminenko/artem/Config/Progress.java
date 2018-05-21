package com.siminenko.artem.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Levels.Level1;
import com.siminenko.artem.Model.Level.Levels.Level10;
import com.siminenko.artem.Model.Level.Levels.Level2;
import com.siminenko.artem.Model.Level.Levels.Level3;
import com.siminenko.artem.Model.Level.Levels.Level4;
import com.siminenko.artem.Model.Level.Levels.Level5;
import com.siminenko.artem.Model.Level.Levels.Level6;
import com.siminenko.artem.Model.Level.Levels.Level7;
import com.siminenko.artem.Model.Level.Levels.Level8;
import com.siminenko.artem.Model.Level.Levels.Level9;

/**
 * Created by User on 22.04.2018.
 */

public class Progress {
    public static final String progress = "progressLevel4";
    public static int[] levels = new int[10];

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

    public static int getNextLevelInt() {
        int index = 1;
        for (int i = 0; i < levels.length; i ++) {
            if (levels[i] == 1) {
                index = i + 2;
            }
        }

        return index;
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
        } else if (index == 3) {
            level = new Level3();
        } else if (index == 4) {
            level = new Level4();
        } else if (index == 5) {
            level = new Level5();
        } else if (index == 6) {
            level = new Level6();
        } else if (index == 7) {
            level = new Level7();
        } else if (index == 8) {
            level = new Level8();
        } else if (index == 9) {
            level = new Level9();
        } else if (index == 10) {
            level = new Level10();
        }

        level.setNumber(index);

        return level;
    }
}
