package com.PDA.game;

import com.badlogic.gdx.graphics.g2d.Animation;

public class Test extends Joueur {

	private final static String DESCRIPTION = "L'aquamancien ne paye peut 皻re pas de mine, mais son pouvoir de destruction, combin��celui d'un pyromancien, en font un adversaire redoutable.";
	protected static volatile Animation animation;

	public Test() {
		super();
		super.hp=90;
		super.hpMax = 90;
		super.mana=110;
		super.manaMax = 110;
		super.strength=8;
		super.speed=11;
		super.intel=12;

	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return DESCRIPTION;
	}

	public Animation animate() {

		if (Test.animation == null) {
			synchronized(Test.class) {
				if (Test.animation == null) {

				}
			}
		}
		return Test.animation;
	}

	public byte[] getBytes(){
		byte data[] = new byte[3+this.nom.length()];
		data[0] = Constants.CONNEXION;
		data[1] = Personnage.AQUAMANCIEN;
		data[2] = (byte) this.nom.length();
		byte[] pseudo = this.nom.getBytes();
		for(int i = 3; i < pseudo.length+3;i++){
			data[i] = pseudo[i-3];
		}
		return data;
	}

	@Override
	public String getNameClass() {
		return "Aquamancien";
	}

	@Override
	public String toString() {
		return "Aquamancien [hp=" + hp + ", hpMax=" + hpMax + ", mana=" + mana
				+ ", manaMax=" + manaMax + ", strength=" + strength
				+ ", speed=" + speed + ", intel=" + intel + ", name=" + nom
				+ ", element=" + element + ", listSkills=" + " "
				+ ", token=" + token + ", state=" + state + ", currentFrame="
				+ currentFrame + ", stateTime=" + stateTime + ", x=" + getX()
				+ ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight()
				+ ", originX=" + getOriginX() + ", originY=" + getOriginY() + ", scaleX="
				+ getScaleX() + ", scaleY=" + getScaleY() + ", rotation=" + getRotation()
				+ ", color=" + getColor() + "]";
	}

}
