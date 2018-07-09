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
    public  static Sound music;

    public  static long id;



    public static void init() {
        touch1 = Gdx.audio.newSound(Gdx.files.internal("music/touch1.wav"));
        touch2 = Gdx.audio.newSound(Gdx.files.internal("music/touch2.wav"));
        touch3 = Gdx.audio.newSound(Gdx.files.internal("music/touch3.wav"));
//        win = Gdx.audio.newSound(Gdx.files.internal("music/win.wav"));
//        lost = Gdx.audio.newSound(Gdx.files.internal("music/lost.wav"));
        music = Gdx.audio.newSound(Gdx.files.internal("music/music.mp3"));
    }

    public static void touch() {
        if (Progress.sound) {
            Random random = new Random();
            int result = random.nextInt(3);
            if (result == 0) {
                touch1.play(0.15f);
            } else if (result == 1) {
                touch2.play(0.15f);
            } else if (result == 2) {
                touch3.play(0.15f);
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
           // id = music.loop(0.3f);
        }
    }
}
