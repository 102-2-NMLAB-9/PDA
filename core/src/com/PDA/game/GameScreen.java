package com.PDA.game;


import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;



public class GameScreen implements Screen,InputProcessor {
	MyPDAGame game;
	GameBody game2048;

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Rectangle backBounds;
	Rectangle testBounds;
	Vector3 touchPoint;
	float accelX = 0;
	float accelY = 0;
	float posx = 500;
	float posy = 400;
	float length = 300;
	List<Soldier> soldier1s;
	List<Soldier> soldier2s;
	List<Soldier> soldier3s;
	List<Soldier> soldier4s;
	List<Soldier> soldier5s;
	List<Soldier> soldier6s;
	List<Soldier> soldier7s;
	List<Soldier> soldier8s;		
	List<Soldier> soldier9s;
	List<Soldier> soldier10s;
	List<Soldier> soldier11s;
	List<Soldier> soldier12s;
	List<Soldier> soldier13s;
	List<Soldier> soldier14s;
	List<Soldier> soldier15s;
	List<Soldier> soldier16s;	
	List<Littlefighter> dennis;

	public GameScreen (MyPDAGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(this);
		guiCam = new OrthographicCamera(1280, 960);
		guiCam.position.set(1280 / 2, 960 / 2, 0);
		backBounds = new Rectangle(0, 0, 64, 64);
		testBounds = new Rectangle(500, 400, 300, 300);
		touchPoint = new Vector3();
		batcher = new SpriteBatch();
		game2048 = new GameBody(batcher);
		this.soldier1s = new ArrayList<Soldier>();
		this.soldier2s = new ArrayList<Soldier>();
		this.soldier3s = new ArrayList<Soldier>();
		this.soldier4s = new ArrayList<Soldier>();
		this.soldier5s = new ArrayList<Soldier>();
		this.soldier6s = new ArrayList<Soldier>();
		this.soldier7s = new ArrayList<Soldier>();
		this.soldier8s = new ArrayList<Soldier>();
		this.soldier9s = new ArrayList<Soldier>();
		this.soldier10s = new ArrayList<Soldier>();
		this.soldier11s = new ArrayList<Soldier>();
		this.soldier12s = new ArrayList<Soldier>();
		this.soldier13s = new ArrayList<Soldier>();
		this.soldier14s = new ArrayList<Soldier>();
		this.soldier15s = new ArrayList<Soldier>();
		this.soldier16s = new ArrayList<Soldier>();
		this.dennis = new ArrayList<Littlefighter>();		
	}
	
	public void update (float delta) {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (backBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				game.setScreen(new MainScreen(game));
				return;
			}
		}
		ApplicationType appType = Gdx.app.getType();
		// should work also with Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)
		if (appType == ApplicationType.Android || appType == ApplicationType.iOS) {
			accelX = Gdx.input.getAccelerometerY();
			accelY = Gdx.input.getAccelerometerX();
		} else {
			accelX = 0;
			accelY = 0;
			if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) accelX = 10f;
			if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) accelX = -10f;
			if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) accelY = 10f;
			if (Gdx.input.isKeyPressed(Keys.DPAD_UP)) accelY = -10f;
		}
		game2048.update(accelX, accelY);
		updateLittlefighters(delta);
		updateSoldiers(delta);
	}
	
	public void updateLittlefighters(float delta)
	{
		int len = dennis.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = dennis.get(i);
			fighter.update(delta);
		}		
	}
	
	private void updateSoldiers (float delta) 
	{
		int len = soldier1s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier1s.get(i);
			soldier.update(delta);
		}
		len = soldier2s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier2s.get(i);
			soldier.update(delta);
		}	
		len = soldier3s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier3s.get(i);
			soldier.update(delta);
		}		
		len = soldier4s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier4s.get(i);
			soldier.update(delta);
		}	
		len = soldier5s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier5s.get(i);
			soldier.update(delta);
		}			
		len = soldier6s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier6s.get(i);
			soldier.update(delta);
		}	
		len = soldier7s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier7s.get(i);
			soldier.update(delta);
		}			
		len = soldier8s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier8s.get(i);
			soldier.update(delta);
		}	
		len = soldier9s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier9s.get(i);
			soldier.update(delta);
		}		
		len = soldier10s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier10s.get(i);
			soldier.update(delta);
		}	
		len = soldier11s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier11s.get(i);
			soldier.update(delta);
		}			
		len = soldier12s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier12s.get(i);
			soldier.update(delta);
		}	
		len = soldier13s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier13s.get(i);
			soldier.update(delta);
		}			
		len = soldier14s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier14s.get(i);
			soldier.update(delta);
		}			
		len = soldier15s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier15s.get(i);
			soldier.update(delta);
		}	
		len = soldier16s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier16s.get(i);
			soldier.update(delta);
		}
	}

	public void draw (float delta) {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();

		batcher.setProjectionMatrix(guiCam.combined);
		batcher.disableBlending();
		batcher.begin();
		batcher.draw(Assets.backgroundRegion, 0, 0, 1280, 960);
		batcher.end();

		batcher.enableBlending();
		batcher.begin();
		batcher.draw(Assets.back, 0, 0, 64, 64);
		
		if (accelX > 5f) Assets.font.draw(batcher, "right", 0, 960);
		else if (accelX < -5f) Assets.font.draw(batcher, "left", 0, 960);
		else if (accelY > 5f) Assets.font.draw(batcher, "down", 0, 960);
		else if (accelY < -5f) Assets.font.draw(batcher, "up", 0, 960);

		batcher.draw(Assets.doorRegion,1111,620,150,330);
		renderSoldiers();
		renderLittlefighters();
		batcher.draw(Assets.testRegion, posx, posy, 300, 300);
		batcher.draw(Assets.boxregion[0], 70, 70, 140, 140);
		batcher.draw(Assets.boxregion[1], 215, 70, 140, 140);
		batcher.draw(Assets.boxregion[2], 360, 70, 140, 140);
		batcher.draw(Assets.boxregion[3], 505, 70, 140, 140);
		batcher.draw(Assets.boxregion[4], 70, 215, 140, 140);
		batcher.draw(Assets.boxregion[5], 215, 215, 140, 140);
		batcher.draw(Assets.boxregion[6], 360, 215, 140, 140);
		batcher.draw(Assets.boxregion[7], 505, 215, 140, 140);
		batcher.draw(Assets.boxregion[8], 70, 360, 140, 140);
		batcher.draw(Assets.boxregion[9], 215, 360, 140, 140);
		batcher.draw(Assets.boxregion[10], 360, 360, 140, 140);
		batcher.draw(Assets.boxregion[11], 505, 360, 140, 140);
		batcher.draw(Assets.boxregion[12], 70, 505, 140, 140);
		batcher.draw(Assets.boxregion[13], 215, 505, 140, 140);
		batcher.draw(Assets.boxregion[14], 360, 505, 140, 140);
		batcher.draw(Assets.boxregion[15], 505, 505, 140, 140);
		batcher.end();
		
		game2048.draw();
	}
	
	private void renderLittlefighters()
	{
		for (int i = 0; i < dennis.size(); i++) 
		{
			Littlefighter fighter = dennis.get(i);
			TextureRegion keyFrame = Assets.dennis.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.dennis.isAnimationFinished(fighter.stateTime))
			{dennis.remove(fighter);}			
		}	
	}
	
	private void renderSoldiers () 
	{
		int len = soldier1s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier1s.get(i);
			TextureRegion keyFrame = Assets.soldier1.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}
		len = soldier2s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier2s.get(i);
			TextureRegion keyFrame = Assets.soldier2.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier3s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier3s.get(i);
			TextureRegion keyFrame = Assets.soldier3.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier4s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier4s.get(i);
			TextureRegion keyFrame = Assets.soldier4.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier5s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier5s.get(i);
			TextureRegion keyFrame = Assets.soldier5.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			
		}			
		len = soldier6s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier6s.get(i);
			TextureRegion keyFrame = Assets.soldier6.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier7s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier7s.get(i);
			TextureRegion keyFrame = Assets.soldier7.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier8s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier8s.get(i);
			TextureRegion keyFrame = Assets.soldier8.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier9s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier9s.get(i);
			TextureRegion keyFrame = Assets.soldier9.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}
		len = soldier10s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier10s.get(i);
			TextureRegion keyFrame = Assets.soldier10.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier11s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier11s.get(i);
			TextureRegion keyFrame = Assets.soldier11.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			
		}			
		len = soldier12s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier12s.get(i);
			TextureRegion keyFrame = Assets.soldier12.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier13s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier13s.get(i);
			TextureRegion keyFrame = Assets.soldier13.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier14s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier14s.get(i);
			TextureRegion keyFrame = Assets.soldier14.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier15s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier15s.get(i);
			TextureRegion keyFrame = Assets.soldier15.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}		
		len = soldier16s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = soldier16s.get(i);
			TextureRegion keyFrame = Assets.soldier16.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
		}			
	}

	@Override
	public void render (float delta) {
		update(delta);
		draw(delta);
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void show () {
	}

	@Override
	public void hide () {
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		if(screenX>=posx && screenX<=posx+length && 900-screenY>=posy && 900-screenY<=posy+length)
		{
			Littlefighter fighter = new Littlefighter(1150,650,-250,1);
			dennis.add(fighter);	
		    return true;
		}
		Soldier soldier = new Soldier(0,660,40,2,2);
		soldier2s.add(soldier);
        return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Soldier soldier = new Soldier(0,660,30,1,1);
		soldier1s.add(soldier);				
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		posx=screenX-150;
		posy=750-screenY;   
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub			
		return false;
	}
}