package com.PDA.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class LoseScreen implements Screen{
	MyPDAGame game;
	
	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Rectangle backBounds;
	Vector3 touchPoint;
	
	public LoseScreen(MyPDAGame game) {
		guiCam = new OrthographicCamera(1280, 960);
		guiCam.position.set(1280 / 2, 960 / 2, 0);
		touchPoint = new Vector3();
		batcher = new SpriteBatch();
		backBounds = new Rectangle(0, 0, 64, 64);
	}
	
	public void update(float delta) {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (backBounds.contains(touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				game.setScreen(new MainScreen(game));
				return;
			}
		}
	}
	
	public void draw(float delta) {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();

		batcher.setProjectionMatrix(guiCam.combined);
		batcher.disableBlending();
		
		batcher.begin();
		batcher.draw(Assets.backgroundRegion, 0, 0, 1280, 960);
		batcher.draw(Assets.losebackregion, 140, 80, 1000, 800);
		batcher.draw(Assets.back, 0, 0, 64, 64);
		batcher.end();
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		update(delta);
		draw(delta);
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
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	;
}
