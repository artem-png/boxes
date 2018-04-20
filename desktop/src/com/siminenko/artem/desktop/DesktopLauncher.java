package com.siminenko.artem.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.siminenko.artem.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.height = 960;
//		config.width = 540;  // iphone 7 / 2

		config.height = 800;
		config.width = 450;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
