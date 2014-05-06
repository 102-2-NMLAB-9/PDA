package com.PDA.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

	public GameScreen (MyPDAGame game) {
		this.game = game;
		game2048 = new GameBody();
		Gdx.input.setInputProcessor(this);
		guiCam = new OrthographicCamera(1280, 960);
		guiCam.position.set(1280 / 2, 960 / 2, 0);
		backBounds = new Rectangle(0, 0, 64, 64);
		testBounds = new Rectangle(500, 400, 300, 300);
		touchPoint = new Vector3();
		batcher = new SpriteBatch();
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
			game2048.render(accelX, accelY);
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
		batcher.end();
		
		batcher.begin();
		if (accelX > 5f) Assets.font.draw(batcher, "right", 0, 960);
		else if (accelX < -5f) Assets.font.draw(batcher, "left", 0, 960);
		else if (accelY > 5f) Assets.font.draw(batcher, "down", 0, 960);
		else if (accelY < -5f) Assets.font.draw(batcher, "up", 0, 960);
		batcher.end();
		
		batcher.begin();
		batcher.draw(Assets.testRegion, posx, posy, 300, 300);
		batcher.end();
		
		batcher.begin();
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
		{return true;}
		else
	    {return false;}
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		if(touchDown(screenX,screenY,pointer,1))
		{
		   posx=screenX-150;
		   posy=750-screenY;
		}
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