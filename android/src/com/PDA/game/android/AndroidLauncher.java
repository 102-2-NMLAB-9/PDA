package com.PDA.game.android;

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
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		multicastLock = wifi.createMulticastLock("multicastLock");
		multicastLock.setReferenceCounted(true);
		multicastLock.acquire();
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyPDAGame(new AndroidHelp(this)), config);
	}
	@Override
    public void onDestroy()
    {
        super.onDestroy();
        multicastLock.release();
    }
}
