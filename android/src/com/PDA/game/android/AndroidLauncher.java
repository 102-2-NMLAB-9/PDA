package com.PDA.game.android;

import java.io.IOException;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.PDA.game.MyPDAGame;

public class AndroidLauncher extends AndroidApplication {
    MulticastLock multicastLock = null;
    WifiManager wifi = null;
    MyPDAGame pdagame;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		pdagame = new MyPDAGame(new AndroidHelp(this));
		super.onCreate(savedInstanceState);
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		multicastLock = wifi.createMulticastLock("multicastLock");
		multicastLock.setReferenceCounted(true);
		multicastLock.acquire();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(pdagame, config);
	}
	@Override
    public void onDestroy()
    {
		if (pdagame.mc != null) {
			try {
				this.pdagame.mc.deco();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pdagame.mc = null;
		}
        super.onDestroy();
        multicastLock.release();
    }
}
