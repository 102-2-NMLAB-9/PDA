package com.PDA.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.String;

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

//Bug: desktop and android have different positionX and positionY. Problem1: rectangle; Problem2: gdx.input.getX() and screenX

public class GameScreen implements Screen,InputProcessor {
	MyPDAGame game;
	GameBody game2048;

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Rectangle backBounds;
//	Rectangle testBounds;

	Vector3 touchPoint;
	float accelX = 0;
	float accelY = 0;
	float posx = 500;
	float posy = 400;
	float length = 300;
	int x1, y1;
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
	List<Soldier> dead_soldier1s;
	List<Soldier> dead_soldier2s;
	List<Soldier> dead_soldier3s;
	List<Soldier> dead_soldier4s;		
	List<Soldier> dead_soldier5s;
	List<Soldier> dead_soldier6s;
	List<Soldier> dead_soldier7s;
	List<Soldier> dead_soldier8s;		
	List<Soldier> dead_soldier9s;
	List<Soldier> dead_soldier10s;
	List<Soldier> dead_soldier11s;
	List<Soldier> dead_soldier12s;		
	List<Soldier> dead_soldier13s;
	List<Soldier> dead_soldier14s;
	List<Soldier> dead_soldier15s;
	List<Soldier> dead_soldier16s;		
	List<Littlefighter> dennis;
	List<Littlefighter> freezer;
	List<Littlefighter> wind;
	List<Littlefighter> firer;
	List<Littlefighter> bomb;		
	List<Littlefighter> frozen;
	List<Littlefighter> cannon;			
	List<Littlefighter> john;
	List<Littlefighter> cut;
	List<Littlefighter> julian;
	List<Littlefighter> magic;
	List<Littlefighter> exp;
	List<Littlefighter> deep;
	List<Littlefighter> henry;		
	List<Littlefighter> louisEX;
	List<Littlefighter> louis;
	List<Littlefighter> rudolf;
	List<Littlefighter> monk;	
	List<Littlefighter> justin;
	List<Littlefighter> knight;
	List<Littlefighter> bat;
	List<Littlefighter> beacon;	
	int exp_times = 7, runtime = 300;
	String run_time;
	Timer timer = new Timer();

	public GameScreen (MyPDAGame game) {
		this.game = game;
		Gdx.input.setInputProcessor(this);
		guiCam = new OrthographicCamera(1280, 960);
		guiCam.position.set(1280 / 2, 960 / 2, 0);
		backBounds = new Rectangle(0, 0, 64, 64);
		
		timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println(runtime--);
                run_time = runtime/60 + ": ";
                if(runtime%60 < 10) run_time += "0"; 
                run_time += runtime%60;
                if (runtime <= 0) {
                    timer.cancel();
                    // new a screen
                }
            }
        }, 0, 1000);

//		testBounds = new Rectangle(500, 400, 300, 300);
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
		this.dead_soldier1s = new ArrayList<Soldier>();
		this.dead_soldier2s = new ArrayList<Soldier>();
		this.dead_soldier3s = new ArrayList<Soldier>();	
		this.dead_soldier4s = new ArrayList<Soldier>();			
		this.dead_soldier5s = new ArrayList<Soldier>();
		this.dead_soldier6s = new ArrayList<Soldier>();
		this.dead_soldier7s = new ArrayList<Soldier>();	
		this.dead_soldier8s = new ArrayList<Soldier>();	
		this.dead_soldier9s = new ArrayList<Soldier>();
		this.dead_soldier10s = new ArrayList<Soldier>();
		this.dead_soldier11s = new ArrayList<Soldier>();	
		this.dead_soldier12s = new ArrayList<Soldier>();	
		this.dead_soldier13s = new ArrayList<Soldier>();
		this.dead_soldier14s = new ArrayList<Soldier>();
		this.dead_soldier15s = new ArrayList<Soldier>();	
		this.dead_soldier16s = new ArrayList<Soldier>();			
		this.dennis = new ArrayList<Littlefighter>();
		this.freezer = new ArrayList<Littlefighter>();	
		this.wind = new ArrayList<Littlefighter>();			
		this.firer = new ArrayList<Littlefighter>();	
		this.bomb = new ArrayList<Littlefighter>();
		this.frozen = new ArrayList<Littlefighter>();	
		this.cannon = new ArrayList<Littlefighter>();		
		this.john = new ArrayList<Littlefighter>();
		this.cut = new ArrayList<Littlefighter>();	
		this.julian = new ArrayList<Littlefighter>();	
		this.magic = new ArrayList<Littlefighter>();
		this.exp = new ArrayList<Littlefighter>();
		this.deep = new ArrayList<Littlefighter>();
		this.henry = new ArrayList<Littlefighter>();
		this.louisEX = new ArrayList<Littlefighter>();
		this.louis = new ArrayList<Littlefighter>();
		this.rudolf = new ArrayList<Littlefighter>();
		this.monk = new ArrayList<Littlefighter>();
		this.justin = new ArrayList<Littlefighter>();
		this.knight = new ArrayList<Littlefighter>();
		this.bat = new ArrayList<Littlefighter>();
		this.beacon = new ArrayList<Littlefighter>();			
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
		
		accelX = 0;
		accelY = 0;
		if (appType == ApplicationType.Android || appType == ApplicationType.iOS) {
			accelX = Gdx.input.getAccelerometerX();
			accelY = Gdx.input.getAccelerometerY();
		} else {
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
		len = freezer.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = freezer.get(i);
			fighter.update(delta);
		}		
		len = wind.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = wind.get(i);
			fighter.update(delta);
		}
		len = firer.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = firer.get(i);
			fighter.update(delta);
		}		
		len = bomb.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = bomb.get(i);
			fighter.update(delta);
		}			
		len = frozen.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = frozen.get(i);
			fighter.update(delta);
		}		
		len = cannon.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = cannon.get(i);
			fighter.update(delta);
		}		
		len = john.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = john.get(i);
			fighter.update(delta);
		}		
		len = cut.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = cut.get(i);
			fighter.update(delta);
		}			
		len = julian.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = julian.get(i);
			fighter.update(delta);
		}		
		len = magic.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = magic.get(i);
			fighter.update(delta);
		}			
		len = exp.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = exp.get(i);
			fighter.update(delta);
		}	
		len = deep.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = deep.get(i);
			fighter.update(delta);
		}		
		len = henry.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = henry.get(i);
			fighter.update(delta);
		}		
		len = louisEX.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = louisEX.get(i);
			fighter.update(delta);
		}			
		len = louis.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = louis.get(i);
			fighter.update(delta);
		}		
		len = rudolf.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = rudolf.get(i);
			fighter.update(delta);
		}			
		len = monk.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = monk.get(i);
			fighter.update(delta);
		}		
		len = justin.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = justin.get(i);
			fighter.update(delta);
		}		
		len = knight.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = knight.get(i);
			fighter.update(delta);
		}		
		len = bat.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = bat.get(i);
			fighter.update(delta);
		}		
		len = beacon.size();
		for (int i = 0; i < len; i++) 
		{
			Littlefighter fighter = beacon.get(i);
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
		len = dead_soldier1s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier1s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier2s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier2s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier3s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier3s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier4s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier4s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier5s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier5s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier6s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier6s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier7s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier7s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier8s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier8s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier9s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier9s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier10s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier10s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier11s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier11s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier12s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier12s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier13s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier13s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier14s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier14s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier15s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier15s.get(i);
			soldier.update(delta);
		}		
		len = dead_soldier16s.size();
		for (int i = 0; i < len; i++) 
		{
			Soldier soldier = dead_soldier16s.get(i);
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
		
		/*
		if (accelX > 5f) Assets.font.draw(batcher, "right", 0, 960);
		else if (accelX < -5f) Assets.font.draw(batcher, "left", 0, 960);
		else if (accelY > 5f) Assets.font.draw(batcher, "down", 0, 960);
		else if (accelY < -5f) Assets.font.draw(batcher, "up", 0, 960);
		*/
		accelX = accelY = 0;
		
		Assets.font.draw(batcher, run_time, 1000, 600);
		
		batcher.draw(Assets.doorRegion,1111,620,150,330);
		renderSoldiers();
		renderLittlefighters(delta);
		//batcher.draw(Assets.testRegion, posx, posy, 300, 300);
		batcher.draw(Assets.boxregion, 70, 70, 585, 585);

		batcher.end();
		
		game2048.draw();
	}
	
	private void renderLittlefighters(float delta)
	{
		for (int i = 0; i < dennis.size(); i++) 
		{
			Littlefighter fighter = dennis.get(i);
			TextureRegion keyFrame = Assets.dennis.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.dennis.isAnimationFinished(fighter.stateTime))
			{dennis.remove(i);}			
		}	
		for (int i = 0; i < freezer.size(); i++) 
		{
			Littlefighter fighter = freezer.get(i);
			TextureRegion keyFrame = Assets.freezer.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.freezer.isAnimationFinished(fighter.stateTime) && !fighter.isfinished())
			{
				fighter.setfinished();
				Littlefighter skill = new Littlefighter(1000,650,-200,0,81);
				wind.add(skill);		
			}			
		}		
		for (int i = 0; i < wind.size(); i++) 
		{
			Littlefighter fighter = wind.get(i);
			TextureRegion keyFrame = Assets.wind.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.wind.isAnimationFinished(fighter.stateTime))
			{
				wind.remove(i);
				freezer.remove(i);
			}			
		}
		for (int i = 0; i < firer.size(); i++) 
		{
			Littlefighter fighter = firer.get(i);
			TextureRegion keyFrame = Assets.firer.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
	        attackSoldiers(fighter.attack,fighter.position.x-75);				
			if(Assets.firer.isAnimationFinished(fighter.stateTime) && !fighter.isfinished())
			{
				fighter.setfinished();
				Littlefighter skill = new Littlefighter(920,650,0,0,1);
				bomb.add(skill);		
			}			
		}		
		for (int i = 0; i < bomb.size(); i++) 
		{
			Littlefighter fighter = bomb.get(i);
			TextureRegion keyFrame = Assets.bomb.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 350, 350);
			if(Assets.bomb.isAnimationFinished(fighter.stateTime))
			{
				bomb.remove(i);
				firer.remove(i);
			}			
		}		
		for (int i = 0; i < frozen.size(); i++) 
		{
			Littlefighter fighter = frozen.get(i);
			TextureRegion keyFrame = Assets.frozen.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.frozen.isAnimationFinished(fighter.stateTime) && !fighter.isfinished())
			{
				fighter.setfinished();
				Littlefighter skill = new Littlefighter(1110,650,-1300,0,40000);
				cannon.add(skill);		
			}			
		}		
		for (int i = 0; i < cannon.size(); i++) 
		{
			Littlefighter fighter = cannon.get(i);
			TextureRegion keyFrame = Assets.cannon.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y,23*(fighter.stateTime/delta),222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.cannon.isAnimationFinished(fighter.stateTime))
			{
				cannon.remove(i);
				frozen.remove(i);
			}			
		}			
		for (int i = 0; i < john.size(); i++) 
		{
			Littlefighter fighter = john.get(i);
			TextureRegion keyFrame = Assets.john.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.john.isAnimationFinished(fighter.stateTime) && !fighter.isfinished())
			{
				fighter.setfinished();
				Littlefighter skill = new Littlefighter(1110,650,-800,-200,1);
				cut.add(skill);		
			}			
		}		
		for (int i = 0; i < cut.size(); i++) 
		{
			Littlefighter fighter = cut.get(i);
			TextureRegion keyFrame = Assets.cut.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y+200,222,50);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.cut.isAnimationFinished(fighter.stateTime))
			{
				cut.remove(i);
				john.remove(i);
			}			
		}		
		for (int i = 0; i < julian.size(); i++) 
		{
			Littlefighter fighter = julian.get(i);
			TextureRegion keyFrame = Assets.julian.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.julian.isAnimationFinished(fighter.stateTime) && !fighter.isfinished())
			{
				fighter.setfinished();
				Littlefighter skill = new Littlefighter(1000,650,-500,0,900);
				magic.add(skill);		
			}			
		}		
		for (int i = 0; i < magic.size(); i++) 
		{
			Littlefighter fighter = magic.get(i);
			TextureRegion keyFrame = Assets.magic.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y,222,222);
	        attackSoldiers(fighter.attack,fighter.position.x);	
			if(Assets.magic.isAnimationFinished(fighter.stateTime))
			{
				magic.remove(i);
				julian.remove(i);
			}			
		}		
		for (int i = 0; i < exp.size(); i++) 
		{
			Littlefighter fighter = exp.get(i);
			TextureRegion keyFrame = Assets.exp.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 333, 333);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.exp.isAnimationFinished(fighter.stateTime) && exp_times>0)
			{			
				exp.remove(fighter);
				exp_times--;
				Littlefighter temp = new Littlefighter(850-150*(7-exp_times),650,0,0,5000);					
				exp.add(temp);
				if(exp_times==0)
				{
					exp.remove(temp);
					exp_times=7;
				}				
			}			
		}		
		for (int i = 0; i < deep.size(); i++) 
		{
			Littlefighter fighter = deep.get(i);
			TextureRegion keyFrame = Assets.deep.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.deep.isAnimationFinished(fighter.stateTime))
			{deep.remove(i);}			
		}			
		for (int i = 0; i < henry.size(); i++) 
		{
			Littlefighter fighter = henry.get(i);
			TextureRegion keyFrame = Assets.henry.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 150, 222);
			if(Assets.henry.isAnimationFinished(fighter.stateTime))
			{henry.remove(i);}			
		}	
		for (int i = 0; i < louisEX.size(); i++) 
		{
			Littlefighter fighter = louisEX.get(i);
			TextureRegion keyFrame = Assets.louisEX.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 222, 222);
			if(Assets.louisEX.isAnimationFinished(fighter.stateTime))
			{louisEX.remove(i);}			
		}	
		for (int i = 0; i < louis.size(); i++) 
		{
			Littlefighter fighter = louis.get(i);
			TextureRegion keyFrame = Assets.louis.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 180, 222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.louis.isAnimationFinished(fighter.stateTime))
			{louis.remove(i);}			
		}			
		for (int i = 0; i < rudolf.size(); i++) 
		{
			Littlefighter fighter = rudolf.get(i);
			TextureRegion keyFrame = Assets.rudolf.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 180, 222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.rudolf.isAnimationFinished(fighter.stateTime))
			{rudolf.remove(i);}			
		}			
		for (int i = 0; i < monk.size(); i++) 
		{
			Littlefighter fighter = monk.get(i);
			TextureRegion keyFrame = Assets.monk.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 180, 222);
			if(Assets.monk.isAnimationFinished(fighter.stateTime))
			{monk.remove(i);}			
		}	
		for (int i = 0; i < justin.size(); i++) 
		{
			Littlefighter fighter = justin.get(i);
			TextureRegion keyFrame = Assets.justin.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 180, 222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.justin.isAnimationFinished(fighter.stateTime))
			{justin.remove(i);}			
		}			
		for (int i = 0; i < knight.size(); i++) 
		{
			Littlefighter fighter = knight.get(i);
			TextureRegion keyFrame = Assets.knight.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 180, 222);
			if(Assets.knight.isAnimationFinished(fighter.stateTime))
			{knight.remove(i);}			
		}
		for (int i = 0; i < bat.size(); i++) 
		{
			Littlefighter fighter = bat.get(i);
			TextureRegion keyFrame = Assets.bat.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y, 180, 222);
			if(Assets.bat.isAnimationFinished(fighter.stateTime) && !fighter.isfinished())
			{
				fighter.setfinished();
				Littlefighter skill = new Littlefighter(1110,650,-1300,0,2500);
				beacon.add(skill);					
			}			
		}		
		for (int i = 0; i < beacon.size(); i++) 
		{
			Littlefighter fighter = beacon.get(i);
			TextureRegion keyFrame = Assets.beacon.getKeyFrame(fighter.stateTime,false);
			batcher.draw(keyFrame, fighter.position.x, fighter.position.y,22*(fighter.stateTime/delta),222);
	        attackSoldiers(fighter.attack,fighter.position.x);				
			if(Assets.beacon.isAnimationFinished(fighter.stateTime))
			{
				bat.remove(i);					
				beacon.remove(i);
			}			
		}			
	}
	
	private void renderSoldiers () 
	{
		for (int i = 0; i < soldier1s.size(); i++) 
		{
			Soldier soldier = soldier1s.get(i);
			TextureRegion keyFrame = Assets.soldier1.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier1s.remove(i);				
				dead_soldier1s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier1s.size(); i++) 
		{
			Soldier soldier = dead_soldier1s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier1.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier1.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier1s.remove(i);
			}
		}		
		for (int i = 0; i < soldier2s.size(); i++) 
		{
			Soldier soldier = soldier2s.get(i);
			TextureRegion keyFrame = Assets.soldier2.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier2s.remove(i);				
				dead_soldier2s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier2s.size(); i++) 
		{
			Soldier soldier = dead_soldier2s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier2.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier2.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier2s.remove(i);
			}
		}	
		for (int i = 0; i < soldier3s.size(); i++) 
		{
			Soldier soldier = soldier3s.get(i);
			TextureRegion keyFrame = Assets.soldier3.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier3s.remove(i);				
				dead_soldier3s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier3s.size(); i++) 
		{
			Soldier soldier = dead_soldier3s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier3.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier3.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier3s.remove(i);
			}
		}			
		for (int i = 0; i < soldier4s.size(); i++) 
		{
			Soldier soldier = soldier4s.get(i);
			TextureRegion keyFrame = Assets.soldier4.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier4s.remove(i);				
				dead_soldier4s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier4s.size(); i++) 
		{
			Soldier soldier = dead_soldier4s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier4.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier4.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier4s.remove(i);
			}
		}	
		for (int i = 0; i < soldier5s.size(); i++) 
		{
			Soldier soldier = soldier5s.get(i);
			TextureRegion keyFrame = Assets.soldier5.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier5s.remove(i);				
				dead_soldier5s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier5s.size(); i++) 
		{
			Soldier soldier = dead_soldier5s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier5.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier5.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier5s.remove(i);
			}
		}			
		for (int i = 0; i < soldier6s.size(); i++) 
		{
			Soldier soldier = soldier6s.get(i);
			TextureRegion keyFrame = Assets.soldier6.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier6s.remove(i);				
				dead_soldier6s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier6s.size(); i++) 
		{
			Soldier soldier = dead_soldier6s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier6.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier6.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier6s.remove(i);
			}
		}			
		for (int i = 0; i < soldier7s.size(); i++) 
		{
			Soldier soldier = soldier7s.get(i);
			TextureRegion keyFrame = Assets.soldier7.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier7s.remove(i);				
				dead_soldier7s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier7s.size(); i++) 
		{
			Soldier soldier = dead_soldier7s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier7.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier7.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier7s.remove(i);
			}
		}			
		for (int i = 0; i < soldier8s.size(); i++) 
		{
			Soldier soldier = soldier8s.get(i);
			TextureRegion keyFrame = Assets.soldier8.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier8s.remove(i);				
				dead_soldier8s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier8s.size(); i++) 
		{
			Soldier soldier = dead_soldier8s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier8.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier8.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier8s.remove(i);
			}
		}			
		for (int i = 0; i < soldier9s.size(); i++) 
		{
			Soldier soldier = soldier9s.get(i);
			TextureRegion keyFrame = Assets.soldier9.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier9s.remove(i);				
				dead_soldier9s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier9s.size(); i++) 
		{
			Soldier soldier = dead_soldier9s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier9.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier9.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier9s.remove(i);
			}
		}			
		for (int i = 0; i < soldier10s.size(); i++) 
		{
			Soldier soldier = soldier10s.get(i);
			TextureRegion keyFrame = Assets.soldier10.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier10s.remove(i);				
				dead_soldier10s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier10s.size(); i++) 
		{
			Soldier soldier = dead_soldier10s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier10.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier10.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier10s.remove(i);
			}
		}			
		for (int i = 0; i < soldier11s.size(); i++) 
		{
			Soldier soldier = soldier11s.get(i);
			TextureRegion keyFrame = Assets.soldier11.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier11s.remove(i);				
				dead_soldier11s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier11s.size(); i++) 
		{
			Soldier soldier = dead_soldier11s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier11.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier11.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier11s.remove(i);
			}
		}			
		for (int i = 0; i < soldier12s.size(); i++) 
		{
			Soldier soldier = soldier12s.get(i);
			TextureRegion keyFrame = Assets.soldier12.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier12s.remove(i);				
				dead_soldier12s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier12s.size(); i++) 
		{
			Soldier soldier = dead_soldier12s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier12.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier12.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier12s.remove(i);
			}
		}			
		for (int i = 0; i < soldier13s.size(); i++) 
		{
			Soldier soldier = soldier13s.get(i);
			TextureRegion keyFrame = Assets.soldier13.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier13s.remove(i);				
				dead_soldier13s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier13s.size(); i++) 
		{
			Soldier soldier = dead_soldier13s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier13.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier13.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier13s.remove(i);
			}
		}			
		for (int i = 0; i < soldier14s.size(); i++) 
		{
			Soldier soldier = soldier14s.get(i);
			TextureRegion keyFrame = Assets.soldier14.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier14s.remove(i);				
				dead_soldier14s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier14s.size(); i++) 
		{
			Soldier soldier = dead_soldier14s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier14.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier14.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier14s.remove(i);
			}
		}	
		for (int i = 0; i < soldier15s.size(); i++) 
		{
			Soldier soldier = soldier15s.get(i);
			TextureRegion keyFrame = Assets.soldier15.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier15s.remove(i);				
				dead_soldier15s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier15s.size(); i++) 
		{
			Soldier soldier = dead_soldier15s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier15.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier15.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier15s.remove(i);
			}
		}			
		for (int i = 0; i < soldier16s.size(); i++) 
		{
			Soldier soldier = soldier16s.get(i);
			TextureRegion keyFrame = Assets.soldier16.getKeyFrame(soldier.stateTime, true);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(soldier.isdead())
			{
				Soldier dead_soldier = new Soldier(soldier.position.x,soldier.position.y,0,0,0,0);
				soldier16s.remove(i);				
				dead_soldier16s.add(dead_soldier);
			}
		}
		for (int i = 0; i < dead_soldier16s.size(); i++) 
		{
			Soldier soldier = dead_soldier16s.get(i);
			TextureRegion keyFrame = Assets.dead_soldier16.getKeyFrame(soldier.stateTime, false);
			batcher.draw(keyFrame, soldier.position.x, soldier.position.y, 222, 222);
			if(Assets.dead_soldier16.isAnimationFinished(soldier.stateTime))
			{
				dead_soldier16s.remove(i);
			}
		}			
	}
	
	private void attackSoldiers(float a,float x)
	{
		for (int i = 0; i < soldier1s.size(); i++) 
		{
			Soldier soldier = soldier1s.get(i);
            soldier.attacked(a,x);
		}
		for (int i = 0; i < soldier2s.size(); i++) 
		{
			Soldier soldier = soldier2s.get(i);
            soldier.attacked(a,x);
		}		
		for (int i = 0; i < soldier3s.size(); i++) 
		{
			Soldier soldier = soldier3s.get(i);
            soldier.attacked(a,x);				
		}		
		for (int i = 0; i < soldier4s.size(); i++) 
		{
			Soldier soldier = soldier4s.get(i);
            soldier.attacked(a,x);				
		}		
		for (int i = 0; i < soldier5s.size(); i++) 
		{
			Soldier soldier = soldier5s.get(i);
            soldier.attacked(a,x);	
			
		}			
		for (int i = 0; i < soldier6s.size(); i++) 
		{
			Soldier soldier = soldier6s.get(i);
            soldier.attacked(a,x);
		}		
		for (int i = 0; i < soldier7s.size(); i++) 
		{
			Soldier soldier = soldier7s.get(i);
            soldier.attacked(a,x);		
		}		
		for (int i = 0; i < soldier8s.size(); i++) 
		{
			Soldier soldier = soldier8s.get(i);
            soldier.attacked(a,x);		
		}		
		for (int i = 0; i < soldier9s.size(); i++) 
		{
			Soldier soldier = soldier9s.get(i);
            soldier.attacked(a,x);		
		}
		for (int i = 0; i < soldier10s.size(); i++) 
		{
			Soldier soldier = soldier10s.get(i);
            soldier.attacked(a,x);	
		}		
		for (int i = 0; i < soldier11s.size(); i++) 
		{
			Soldier soldier = soldier11s.get(i);
            soldier.attacked(a,x);						
		}			
		for (int i = 0; i < soldier12s.size(); i++) 
		{
			Soldier soldier = soldier12s.get(i);
            soldier.attacked(a,x);			
		}		
		for (int i = 0; i <  soldier13s.size(); i++) 
		{
			Soldier soldier = soldier13s.get(i);
            soldier.attacked(a,x);				
		}		
		for (int i = 0; i < soldier14s.size(); i++) 
		{
			Soldier soldier = soldier14s.get(i);
            soldier.attacked(a,x);	
		}		
		for (int i = 0; i < soldier15s.size(); i++) 
		{
			Soldier soldier = soldier15s.get(i);
            soldier.attacked(a,x);
		}		
		for (int i = 0; i < soldier16s.size(); i++) 
		{
			Soldier soldier = soldier16s.get(i);
            soldier.attacked(a,x);	
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
		
/*		if(screenX>=posx && screenX<=posx+length && 900-screenY>=posy && 900-screenY<=posy+length)
		{			
		    return true;
		}
*/
		
//		if(game2048.locate(screenX, screenY) >= 0) {
			x1 = screenX;
			y1 = screenY;
//		}
			
			
        return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			
		//Littlefighter fighter1 = new Littlefighter(1100,650,0,0,1);
		//john.add(fighter1);
		//Littlefighter fighter2 = new Littlefighter(1100,650,-600,0,3);
		//rudolf.add(fighter2);
		//Littlefighter fighter3 = new Littlefighter(1100,650,-350,0,9);
		//louis.add(fighter3);
		//Littlefighter fighter4 = new Littlefighter(1150,650,-300,0,27);
		//deep.add(fighter4);
		//Littlefighter fighter5 = new Littlefighter(1100,650,-50,0,0);
		//freezer.add(fighter5);	
		//Littlefighter fighter6 = new Littlefighter(1100,650,-400,0,400);
		//justin.add(fighter6);
		//Littlefighter fighter7 = new Littlefighter(1000,650,0,0,729);
		//firer.add(fighter7);
		//Littlefighter fighter8 = new Littlefighter(1100,650,0,0,0);
		//julian.add(fighter8);	
		//Littlefighter fighter9 = new Littlefighter(1100,650,0,0,0);
		//bat.add(fighter10);	
		//Littlefighter fighter10 = new Littlefighter(850,650,0,0,7000);
		//exp.add(fighter10);			
		Littlefighter fighter11 = new Littlefighter(1100,650,0,0,0);
		frozen.add(fighter11);	
		//Littlefighter fighter12 = new Littlefighter(1150,650,-250,0,1);
		//dennis.add(fighter12);						
		//Littlefighter fighter13 = new Littlefighter(1100,650,-500,0,1);
		//louisEX.add(fighter13);							
		//Littlefighter fighter14 = new Littlefighter(1100,650,-150,0,1);
		//knight.add(fighter14);			
		//Littlefighter fighter15 = new Littlefighter(1100,650,0,0,1);
		//monk.add(fighter15);	
		//Littlefighter fighter16 = new Littlefighter(1100,650,0,0,1);
		//henry.add(fighter16);		

		
		if(screenX-x1 > 100) accelX = 10;
		else if(screenY-y1 > 100) accelY = 10;
		else if(screenX-x1 < -100) accelX = -10;
		else if(screenY-y1 < -100) accelY = -10;
		game2048.update(accelX, accelY);
		
		int target = game2048.locate(screenX, screenY);
		if(game2048.locate(x1, y1) == target && target >= 0 && game2048.size() > 1) {
			if(game2048.status[target] == 1) 
			{
				Soldier soldier = new Soldier(0,660,90,100,1,1);				
				soldier1s.add(soldier);			
			}
			else if(game2048.status[target] == 2)
			{
				Soldier soldier = new Soldier(0,660,90,400,1,3);				
				soldier2s.add(soldier);
			}			
			else if(game2048.status[target] == 3)
			{
				Soldier soldier = new Soldier(0,660,90,1600,1,9);				
				soldier3s.add(soldier);
			}	
			else if(game2048.status[target] == 4)
			{
				Soldier soldier = new Soldier(0,660,120,6400,1,27);				
				soldier4s.add(soldier);
			}	
			else if(game2048.status[target] == 5)
			{
				Soldier soldier = new Soldier(0,660,150,25600,1,81);				
				soldier5s.add(soldier);
			}			
			else if(game2048.status[target] == 6)
			{
				Soldier soldier = new Soldier(0,660,180,65000,1,400);				
				soldier6s.add(soldier);
			}	
			else if(game2048.status[target] == 7)
			{
				Soldier soldier = new Soldier(0,660,210,140000,1,729);				
				soldier7s.add(soldier);
			}		
			else if(game2048.status[target] == 8)
			{
				Soldier soldier = new Soldier(0,660,240,250000,1,900);				
				soldier8s.add(soldier);
			}			
			else if(game2048.status[target] == 9)
			{
				Soldier soldier = new Soldier(0,660,270,600000,1,2500);				
				soldier9s.add(soldier);
			}	
			else if(game2048.status[target] == 10)
			{
				Soldier soldier = new Soldier(0,660,300,2000000,1,7000);				
				soldier10s.add(soldier);
			}	
			else if(game2048.status[target] == 11)
			{
				Soldier soldier = new Soldier(0,660,330,4200000,1,40000);				
				soldier11s.add(soldier);
			}			
			else if(game2048.status[target] == 12)
			{
				Soldier soldier = new Soldier(0,660,360,3,1,1);				
				soldier12s.add(soldier);
			}	
			else if(game2048.status[target] == 13)
			{
				Soldier soldier = new Soldier(0,660,390,3,1,1);				
				soldier13s.add(soldier);
			}				
			else if(game2048.status[target] == 14)
			{
				Soldier soldier = new Soldier(0,660,420,3,1,1);				
				soldier14s.add(soldier);
			}			
			else if(game2048.status[target] == 15)
			{
				Soldier soldier = new Soldier(0,660,450,3,1,1);				
				soldier15s.add(soldier);
			}	
			else if(game2048.status[target] == 16)
			{
				Soldier soldier = new Soldier(0,660,480,3,1,1);				
				soldier16s.add(soldier);
			}				
			game2048.status[target] = 0;
			game2048.update(0, 0);
			game2048.draw();
		}


		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
//		posx=screenX-150;
//		posy=750-screenY;   
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