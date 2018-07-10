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
    static Sound coin;
    static Sound big;
    public static Sound music;
    public static Sound gameMusic;

    public static long id = -1;
    public static long gameId = -1;

    public static boolean isPlay = true;
    public static boolean isPlayGame = false;

    static float volume = 0;
    static float volumeGame = 0;
    static float max = 1f;


    public static void init() {
        touch1 = Gdx.audio.newSound(Gdx.files.internal("music/touch1.ogg"));
        touch2 = Gdx.audio.newSound(Gdx.files.internal("music/touch2.ogg"));
        touch3 = Gdx.audio.newSound(Gdx.files.internal("music/touch3.ogg"));
        win = Gdx.audio.newSound(Gdx.files.internal("music/win.ogg"));
        coin = Gdx.audio.newSound(Gdx.files.internal("music/coin.ogg"));
        big = Gdx.audio.newSound(Gdx.files.internal("music/big.ogg"));
        lost = Gdx.audio.newSound(Gdx.files.internal("music/lost.ogg"));
        music = Gdx.audio.newSound(Gdx.files.internal("music/music.ogg"));
        gameMusic = Gdx.audio.newSound(Gdx.files.internal("music/gameMusic.ogg"));
        id = music.loop(0);
        gameId = gameMusic.loop(0);
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

    public static void big() {
        if (Progress.sound) {
            big.play();
        }
    }

    public static void coin() {
        if (Progress.sound) {
            coin.play();
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

    public static void musicGame() {
        System.out.println("START");
        if (Progress.music) {
            isPlayGame = true;
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

        if (isPlayGame) {
            if (volumeGame < 0.3f) {
                volumeGame += 0.01f;
                gameMusic.setVolume(gameId, volumeGame);
            }
        } else {
            if (volumeGame > 0) {
                volumeGame -= 0.01f;
                gameMusic.setVolume(gameId, volumeGame);
            }
        }
    }

    public static void stopMusic() {
        if (Progress.music) {
            isPlay = false;
        }
    }
    public static void stopMusicGame() {
        if (Progress.sound) {
            isPlayGame = false;
        }
    }
}
