package com.PDA.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public abstract class Personnage extends Actor {

	// class
	protected String nom;
	boolean token;

	public Personnage() {
		setTouchable(Touchable.enabled);
		this.setOrigin(50, 50);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}
}
