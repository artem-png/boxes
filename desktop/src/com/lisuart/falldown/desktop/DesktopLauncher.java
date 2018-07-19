package com.lisuart.falldown.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lisuart.falldown.AdMob.AdsControllerClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = (int)(900f * 1f);
		config.width = (int)(500f * 1f);  // iphone 7 / 2
//		config.height = 700;
//		config.width = 390;
		new LwjglApplication(new com.lisuart.falldown.MyGdxGame(new AdsControllerClass(), new com.lisuart.falldown.AdMob.RewardAdsClass()), config);
	}
}
