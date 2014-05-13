package com.PDA.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Test extends Actor implements Serializable {
	
	private String macAddress;
	boolean pret;
	boolean aJoueCeTour;
	private String nom;
	boolean token;

	public Test() {
		super();
		setMacAddress("");
		setTouchable(Touchable.enabled);
		this.setOrigin(50, 50);
	}

	public byte[] getBytes(){
		byte data[] = new byte[3+this.nom.length()];
		data[0] = Constants.CONNEXION;
		data[1] = 3;
		data[2] = (byte) this.nom.length();
		byte[] pseudo = this.nom.getBytes();
		for(int i = 3; i < pseudo.length+3;i++){
			data[i] = pseudo[i-3];
		}
		return data;
	}

	@Override
	public void write(Json json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		// TODO Auto-generated method stub
		
	}
	
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
	
	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

}
