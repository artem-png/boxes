package com.siminenko.artem.Model.Menu.ModelPickerModels;

import com.badlogic.gdx.math.Vector2;
import com.siminenko.artem.Config.Progress;

import java.util.Random;

/**
 * Created by User on 21.04.2018.
 */

public class Scenarious {
    int sizePause;
    Random random = new Random();

    Vector2 sizeOriginal;
    float rotationOriginal;
    float rotationAmount = 0;

    float a = 0;
    float ad = 0.05f;

    float s = 0.1f;
    float sc = 0.1f;

    boolean isBigger = true;

    float bigAmountSetting = 0.12f;
    float bigAmount = bigAmountSetting;

    public Scenarious(Vector2 s, float r) {
        sizeOriginal = s;
        rotationOriginal = r;
        sizePause = random.nextInt(150) + 30;
    }


    public void act() {
        int a = random.nextInt(500);
        if (a == 1) {
            rotationAmount += random.nextInt(100) + 1000;
        }
    }

    public float modifyRotation(float rotation) {
        float r;
        if (rotationAmount > 0) {
            r = rotation + rotationAmount / 120;
            rotationAmount = rotationAmount - rotationAmount / 120;
            if (rotationAmount <= 60) {
                rotationAmount = 0;
            }
        } else {
            a += ad;
            r = (float)(rotation + Math.cos(a) * 1.1f);
        }
        return r;
    }

    public Vector2 modifySize(Vector2 size) {
        this.s = s + sc;
        float v = (float) Math.cos(s);
        if (v < 0 && isBigger) {
            isBigger = false;
        }
        if (v > 0 && !isBigger) {
            isBigger = true;
        }
        if (v > 0 && isBigger) {
            if (Progress.theme == 2) {
                size.add(bigAmount, bigAmount / 3);
            } else {
                size.add(bigAmount, bigAmount);
            }
        }
        if (v < 0 && !isBigger) {
            if (Progress.theme == 2) {
                size.add(-bigAmount, -bigAmount / 3);
            } else {
                size.add(-bigAmount, -bigAmount);
            }
        }
        return size;
    }
}
