package com.PDA.game;

import java.util.HashMap;
import java.util.Set;

@SuppressWarnings("hiding")
public class MapPerso<String,Personnage> extends HashMap<String, Personnage>{
	
	private static final long serialVersionUID = 1L;
	
	public String getKey(Personnage p){
		Set<String> key = this.keySet();
		for (String it : key) {
			if(p == this.get(it))
				return it;
		}
		return null;
	}
}
