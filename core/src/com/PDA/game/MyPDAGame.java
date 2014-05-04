package com.PDA.game;

import java.io.IOException;
import java.util.ArrayList;

import com.PDA.game.Personnage;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;

public class MyPDAGame extends Game {
	public UITrick androidUI;
	boolean firstTimeCreate = true;
	public FPSLogger fps;
	public UnicastClient mc;
	public ChatWindow cw;
	public Joueur player;
	public ArrayList<Personnage> playersConnected;
	public ArrayList<String> listHost;
	public boolean currentVagueIndex = false;
	public int count = 0;
	
	public MyPDAGame(UITrick actionResolver) {
		super();
		this.androidUI = actionResolver;
		playersConnected = new ArrayList<Personnage>();
		listHost = new ArrayList<String>();
		player = new Test();
		player.setNom("test");
		player.setName("alsotest");
		mc = null;
		cw = null;
		
	}
	
	public MyPDAGame() {
		super();
	}
	
	public void setMC(UnicastClient m){
		this.mc = m;
	}
	
	@Override
	public void create () {
		Settings.load();
		Assets.load();
		setScreen(new MainScreen(this));
		fps = new FPSLogger();
	}

	@Override
	public void render () {
		super.render();
	}
	
	/** {@link Game#dispose()} only calls {@link Screen#hide()} so you need to override {@link Game#dispose()} in order to call
	 * {@link Screen#dispose()} on each of your screens which still need to dispose of their resources. SuperJumper doesn't
	 * actually have such resources so this is only to complete the example. */
	@Override
	public void dispose () {
		if (mc != null) {
			try {
				this.mc.deco();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mc = null;
		}
		super.dispose();

		getScreen().dispose();
	}
}