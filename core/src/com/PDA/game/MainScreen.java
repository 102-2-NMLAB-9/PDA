package com.PDA.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

public class MainScreen implements Screen {
	Game game;
	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Rectangle soundBounds;
	Rectangle playBounds;
	Rectangle highscoresBounds;
	Rectangle helpBounds;
	Vector3 touchPoint;
	
	public MainScreen(Game game)
	{
		this.game = game;
		
		guiCam = new OrthographicCamera(1280, 960);
		guiCam.position.set(1280 / 2, 960 / 2, 0);
		batcher = new SpriteBatch();
		soundBounds = new Rectangle(0, 0, 64, 64);
		playBounds = new Rectangle(500, 600, 300, 100);
		highscoresBounds = new Rectangle(500, 450, 300, 100);
		helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
		touchPoint = new Vector3();
		
	}
	
	long last = TimeUtils.nanoTime();

	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				//game.setScreen(new GameScreen(game));
				return;
			}
			if (highscoresBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				game.setScreen(new HighscoresScreen(game));
				return;
			}
			if (helpBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				//game.setScreen(new HelpScreen(game));
				return;
			}
			if (soundBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				Settings.soundEnabled = !Settings.soundEnabled;
				if (Settings.soundEnabled)
					Assets.music.play();
				else
					Assets.music.pause();
			}
		}
	}
	
	public void draw () {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		batcher.setProjectionMatrix(guiCam.combined);

		batcher.disableBlending();
		batcher.begin();
		batcher.draw(Assets.backgroundRegion, 0, 0, 1280, 960);
		batcher.end();

		batcher.enableBlending();
		batcher.begin();
		batcher.draw(Assets.warRegion, 100, 750, 1080, 200);
		batcher.draw(Assets.playRegion, 500, 600, 300, 100);
		batcher.draw(Assets.highScoreRegion, 500, 450, 300, 100);
		//batcher.draw(Assets.logo, 160 - 274 / 2, 480 - 10 - 142, 274, 142);
		//batcher.draw(Assets.mainMenu, 10, 200 - 110 / 2, 300, 110);
		batcher.draw(Settings.soundEnabled ? Assets.soundRegion : Assets.noSoundRegion, 0, 0, 64, 64);
		
		batcher.end();

		if (TimeUtils.nanoTime() - last > 2000000000) {
			Gdx.app.log("PDA",
				"version: " + Gdx.app.getVersion() + ", memory: " + Gdx.app.getJavaHeap() + ", " + Gdx.app.getNativeHeap()
					+ ", native orientation:" + Gdx.input.getNativeOrientation() + ", orientation: " + Gdx.input.getRotation()
					+ ", accel: " + (int)Gdx.input.getAccelerometerX() + ", " + (int)Gdx.input.getAccelerometerY() + ", "
					+ (int)Gdx.input.getAccelerometerZ() + ", apr: " + (int)Gdx.input.getAzimuth() + ", " + (int)Gdx.input.getPitch()
					+ ", " + (int)Gdx.input.getRoll());
			last = TimeUtils.nanoTime();
		}
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		update();
		draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Settings.save();
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
