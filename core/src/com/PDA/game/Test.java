package com.PDA.game;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class Test extends Joueur {

	public Test() {
		super();
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

}
