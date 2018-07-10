package com.siminenko.artem.Model.Music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.siminenko.artem.Config.Progress;

import java.util.Random;

/**
 * Created by artem on 7/9/18.
 */

public class Music {
    static Sound touch1;
    static Sound touch2;
    static Sound touch3;
    static Sound win;
    static Sound lost;
    public static Sound music;

    public static long id = -1;

    public static boolean isStop = false;
    public static boolean isPlay = true;

    static float volume = 0;
    static float max = 0.8f;


    public static void init() {
        touch1 = Gdx.audio.newSound(Gdx.files.internal("music/touch1.ogg"));
        touch2 = Gdx.audio.newSound(Gdx.files.internal("music/touch2.ogg"));
        touch3 = Gdx.audio.newSound(Gdx.files.internal("music/touch3.ogg"));
        win = Gdx.audio.newSound(Gdx.files.internal("music/win.ogg"));
        lost = Gdx.audio.newSound(Gdx.files.internal("music/lost.ogg"));
        music = Gdx.audio.newSound(Gdx.files.internal("music/music.ogg"));
        id = music.loop(0);
    }

    public static void touch() {
        if (Progress.sound) {
            Random random = new Random();
            int result = random.nextInt(3);
            if (result == 0) {
                touch1.play(0.6f);
            } else if (result == 1) {
                touch2.play(0.6f);
            } else if (result == 2) {
                touch3.play(0.6f);
            }
        }
    }

    public static void win() {
        if (Progress.sound) {
            win.play();
        }
    }

    public static void lost() {
        if (Progress.sound) {
            lost.play();
        }
    }

    public static void music() {
        if (Progress.music) {
            isPlay = true;
        }
    }

    public static void act() {
        if (isPlay) {
            if (volume < max) {
                volume += 0.01f;
                music.setVolume(id, volume);
            }
        } else {
            if (volume > 0) {
                volume -= 0.01f;
                music.setVolume(id, volume);
            }
        }
    }

    public static void stopMusic() {
        if (Progress.music) {
            isPlay = false;
        }
    }
}
