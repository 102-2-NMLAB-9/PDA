package com.PDA.game;

import com.badlogic.gdx.utils.Json.Serializable;

public abstract class Joueur extends Personnage implements Serializable {

	private String macAddress;
	boolean pret;
	boolean aJoueCeTour;

	public Joueur() {
		super();
		setMacAddress("");
	}

	public abstract byte[] getBytes();

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	public boolean estPret() {
		return this.pret;
	}

	public void setPret(boolean p) {
		this.pret = p;
	}
}
