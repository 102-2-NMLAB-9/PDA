package com.PDA.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public abstract class Personnage extends Actor {

	// class
	public static final int CHAMANE = 0;
	public static final int NECROMANCIEN = 1;
	public static final int PYROMANCIEN = 2;
	public static final int AQUAMANCIEN = 3;
	public static final int MONSTRE = 4;
	public static final int BOSS = 5;
	public static final int COMPLETE = 0;
	public static final int MORT = 1;
	public static final int WAIT = 2;
	protected int hp;
	protected int hpMax;
	protected int mana;
	protected int manaMax;
	protected int strength;
	protected int speed;
	protected int intel;
	protected String nom;
	protected int element;
	protected ArrayList<Integer> effet;
	protected boolean token;
	protected int state;
	protected TextureRegion currentFrame;
	protected float stateTime;

	public Personnage() {
		this.effet = new ArrayList<Integer>();
		this.state = WAIT;
		this.stateTime = 0;
		this.currentFrame = null;
		setTouchable(Touchable.enabled);
		this.token = false;
		this.setOrigin(50, 50);
	}

	public void draw(SpriteBatch batch, float parentAlpha) {
		stateTime += Gdx.graphics.getDeltaTime();

		switch (state) {
		case COMPLETE:
			currentFrame = animate().getKeyFrame(stateTime, true);
			batch.draw(currentFrame, getOriginX(), getOriginY(), getWidth(), getHeight());
			break;
		case MORT:
			currentFrame = animate().getKeyFrame(animate().getKeyFrameIndex(8));
			batch.draw(currentFrame, getOriginX(), getOriginY(), getWidth(), getHeight());
			break;
		case WAIT:
			currentFrame = animate().getKeyFrame(0, true);
			batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());
			break;
		default:
			break;
		}

		if(nom.equals("Abyss")){
			if(getWidth()==0)
				this.setWidth(currentFrame.getRegionWidth());
			if(getHeight()==0)
				this.setHeight(currentFrame.getRegionHeight());
		}
		else{
			if(getWidth()==0)
				this.setWidth(currentFrame.getRegionWidth()*2);
			if(getHeight()==0)
				this.setHeight(currentFrame.getRegionHeight()*2);
		}
		//		this.setSize(currentFrame.getRegionWidth(),currentFrame.getRegionHeight());
		//		this.setBounds(getX(), getY(), getWidth(),getHeight());
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		if (touchable && getTouchable() != Touchable.enabled)
			return null;
		return x >= 0 && x < this.getWidth() && y >= 0 && y < this.getHeight() ? this
				: null;
	}

	@Override
	public String toString() {
		return "Personnage [hp=" + hp + ", mana=" + mana + ", strength="
				+ strength + ", speed=" + speed + ", intel=" + intel
				+ ", name=" + nom + ", listSkills=" + " " + ", state="
				+ state + ", currentFrame=" + currentFrame + ", stateTime="
				+ stateTime + "]";
	}

	public abstract String getDesc();

	public abstract Animation animate();

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hp_max) {
		this.hpMax = hp_max;
	}

	public int getManaMax() {
		return manaMax;
	}

	public void setManaMax(int mana_max) {
		this.manaMax = mana_max;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean isToken() {
		return token;
	}

	public void setToken(boolean t) {
		this.token = t;
	}

}
