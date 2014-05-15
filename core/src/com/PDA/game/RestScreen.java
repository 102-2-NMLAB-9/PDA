package com.PDA.game;

import java.util.Timer;
import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class RestScreen implements Screen {
	MyPDAGame game;

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Vector3 touchPoint;
	int runtime = 10;
	String run_time;
	Timer timer = new Timer();
	boolean myb;

	public RestScreen (MyPDAGame game, boolean b) {
		this.game = game;
		myb = b;

		guiCam = new OrthographicCamera(1280, 960);
		guiCam.position.set(1280 / 2, 960 / 2, 0);
		touchPoint = new Vector3();
		batcher = new SpriteBatch();
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
	}

	public void update () {
		if ( runtime <= 0 )
		{
			game.countGame++;
			if (myb)
			{
				game.mc.defence = new Defender(game);
				game.setScreen(game.mc.defence);
			}			
			else
			{
				game.mc.attack = new Attacker(game);
				game.setScreen(game.mc.attack);
			}
		}

	}

	public void draw () {
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
		Assets.font.draw(batcher, "Time", 500, 600);
		Assets.font.draw(batcher, run_time, 700, 600);
		Assets.font.draw(batcher, "Change stage.", 0, 960);
		batcher.end();
	}

	@Override
	public void render (float delta) {
		update();
		draw();
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
}
