package com.PDA.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.TimeUtils;

public abstract class AbstractScreen implements com.badlogic.gdx.Screen {

	protected MyPDAGame game;
	protected Skin skin;
	protected SpriteBatch batch;
	protected OrthographicCamera cameraGUI;
	private static volatile long timePlayed;
	
	public AbstractScreen(MyPDAGame game) {
		this.game = game;
		this.skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		this.skin.getFont("default-font").getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		this.batch = new SpriteBatch();
		this.cameraGUI = new OrthographicCamera(1280, 960);
		this.cameraGUI.position.set(1280 / 2, 960 / 2, 0);
		this.cameraGUI.setToOrtho(false); // flip y-axis
		this.cameraGUI.update();
		AbstractScreen.timePlayed = getTimePlayed();
	}

	@Override
	public void pause() {
	};

	@Override
	public void resume() {
	};

	@Override
	public void dispose() {
		skin.dispose();
		batch.dispose();
	};

	@Override
	public void hide() {
	};

	@Override
	public void show() {
	};
	
	public void destroy() {
	};

	@Override
	public void render(float arg0) {
		GL20 gl = Gdx.gl;
		gl.glClearColor(0, 0, 0, 0);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cameraGUI.combined);

	}

	@Override
	public void resize(int width, int height) {
		batch.setProjectionMatrix(cameraGUI.combined);
		
	}
	
    public final static long getTimePlayed() {
        if (AbstractScreen.timePlayed == 0) {
           synchronized(AbstractScreen.class) {
             if (AbstractScreen.timePlayed == 0) {
            	 AbstractScreen.timePlayed = TimeUtils.millis();
             }
           }
        }
        return AbstractScreen.timePlayed;
    }

}