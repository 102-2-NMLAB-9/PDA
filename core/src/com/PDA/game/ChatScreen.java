package com.PDA.game;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import java.io.IOException;

import com.PDA.network.UnicastClient;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;

public class ChatScreen extends AbstractScreen {

	private Stage stage;

	public ChatScreen(MyPDAGame game) {
		super(game);
		this.batch = new SpriteBatch();
		this.stage = new Stage();
	}

	@Override
	public void resize(int width, int height) {
		Vector2 size = Scaling.fit.apply(1280, 960, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
		batch.dispose();
		
	}

	@Override
	public void render(float delta) {
        super.render( delta );

		stage.act(delta);
		stage.draw();
//		Table.drawDebug(stage);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		stage.addActor(buildBackgroundLayer());

		final TextButton validation = new TextButton("Set Connection", skin);
		validation.pad(50, 0, 0, 100);
		final TextButton pret = new TextButton("Back", skin);
		pret.pad(50, 0, 0, 100);
		pret.setColor(Color.BLUE);

		// window.debug();
		final Window window = new Window("Connection", skin);
		window.getButtonTable().pad(400);
		window.setPosition(400, 200);
		window.defaults().pad(20, 20, 20, 20);
		window.row();
		window.add(validation);
		window.row();
		window.pack();

		// stage.addActor(new Button("Behind Window", skin));
		stage.addActor(window);
		validation.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				ChatWindow cw = new ChatWindow(game);
				final UnicastClient uc = new UnicastClient(game);
				uc.chatWindow = cw;
		
				game.setMC(uc);
				try {
					uc.lancerClient();
				} catch (IOException e) {
					e.printStackTrace();
				}
				window.removeActor(validation);
				window.add(pret);
				window.row();

				pret.addListener(new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, Actor actor) {
						pret.setColor(Color.GREEN);
						try {
							uc.estPret();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				
				stage.addActor(cw.getWindow());
//				
			}
		});


	}
	/**
	 * 
	 */
	private Image buildBackgroundLayer() {
		Image scrollingImage = new Image(Assets.backgroundRegion);
		scrollingImage.setPosition(0, 0);
		scrollingImage.setHeight(960);
		RepeatAction ra = new RepeatAction();
		ra.setAction(sequence(moveTo(0, 0), moveBy((int)(-scrollingImage.getWidth()*.6), 0, 20.0f, Interpolation.linear),
				moveBy((int)(scrollingImage.getWidth()*.6), 0, 20.0f, Interpolation.linear)));
		ra.setCount(RepeatAction.FOREVER);
		scrollingImage.addAction(ra);
		return scrollingImage;
	}
	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

}