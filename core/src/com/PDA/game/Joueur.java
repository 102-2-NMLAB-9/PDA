package com.PDA.game;

import com.PDA.game.Personnage;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class Joueur extends Personnage implements Serializable {

	private boolean pret;
	private boolean aJoueCeTour;
	private String macAddress;

	public Joueur() {
		super();
		pret = false;
		setMacAddress("");
	}

	// UNIQUEMENT POUR LES ATTAQUES D'UN JOUEUR VERS UN NPC OU UN SOIN

	@Override
	public void write(Json json) {
		json.writeValue("name", nom, String.class);
		json.writeValue("hp", hp, Integer.class);
		json.writeValue("hpMax", hpMax, Integer.class);
		json.writeValue("mana", mana, Integer.class);
		json.writeValue("manaMax", manaMax, Integer.class);
		json.writeValue("strength", strength, Integer.class);
		json.writeValue("speed", speed, Integer.class);
		json.writeValue("intel", intel, Integer.class);

	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		this.nom = json.readValue(String.class, jsonData);
		this.hp = json.readValue("hp", Integer.class, jsonData);
		this.hpMax = json.readValue("hpMax", Integer.class, jsonData);
		this.mana = json.readValue("mana", Integer.class, jsonData);
		this.manaMax = json.readValue("manaMax", Integer.class, jsonData);
		this.strength = json.readValue("strength", Integer.class, jsonData);
		this.speed = json.readValue("speed", Integer.class, jsonData);
		this.intel = json.readValue("intel", Integer.class, jsonData);

	}

	@Override
	public abstract String getDesc();

	@Override
	public abstract Animation animate();

	public abstract byte[] getBytes();

	public abstract String getNameClass();

	public boolean estPret() {
		return this.pret;
	}

	public void setPret(boolean p) {
		this.pret = p;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public boolean aJoueCeTour() {
		return aJoueCeTour;
	}

	public void setaJoueCeTour(boolean aJoueCeTour) {
		this.aJoueCeTour = aJoueCeTour;
	}

}
