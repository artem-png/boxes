package com.siminenko.artem.Config;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.siminenko.artem.Model.Level.ALevel;
import com.siminenko.artem.Model.Level.Levels.Level1;
import com.siminenko.artem.Model.Level.Levels.Level10;
import com.siminenko.artem.Model.Level.Levels.Level11;
import com.siminenko.artem.Model.Level.Levels.Level12;
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

public class Info {
    public static final String info = "infoGame";

    public static final String RUN_NUMBER = "runNumber";
    public static final String RATE_CHOISE = "rateChoise";
    public static final String RATE_CHOISE_RUN_LAST = "rateChoiseRunLast";
    public static final int RATE_SHOISE_NOT_YET = 0;
    public static final int RATE_SHOISE_NEVER = 1;
    public static final int RATE_SHOISE_LATER = 2;
    public static final int RATE_SHOISE_OK = 2;

    public static int runNumber = 0;
    public static int rateChoise = 0;
    public static int rateChoiseRunLast = 0;

    public static void init() {
        Preferences prefs = Gdx.app.getPreferences(info);
        runNumber = prefs.getInteger(RUN_NUMBER, 0);
        rateChoise = prefs.getInteger(RATE_CHOISE, 0);
        rateChoiseRunLast = prefs.getInteger(RATE_CHOISE_RUN_LAST, 0);
    }

    public static void addRunNumber() {
        Preferences prefs = Gdx.app.getPreferences(info);
        prefs.putInteger(RUN_NUMBER, runNumber + 1);
        prefs.flush();
        init();
        System.out.println(runNumber);
    }

    public static void saveRateChoise(int value) {
        Preferences prefs = Gdx.app.getPreferences(info);
        prefs.putInteger(RATE_CHOISE, value);

        prefs.putInteger(RATE_CHOISE_RUN_LAST, runNumber);
        prefs.flush();
        init();
    }
}
