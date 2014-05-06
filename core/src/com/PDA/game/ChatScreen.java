package com.PDA.game;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

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
	ChatWindow cw;
	UnicastClient uc;

	public ChatScreen(MyPDAGame game) {
		super(game);
		this.batch = new SpriteBatch();
		this.stage = new Stage();
		cw = null;
		uc = null;
	}

	/*
	@Override
	public void resize(int width, int height) {
		Vector2 size = Scaling.fit.apply(1280, 960, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
	}
	*/

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

		final TextButton validation = new TextButton("Connect", skin);
		validation.pad(50, 0, 0, 100);
		final TextButton pret = new TextButton("prepared", skin);
		pret.pad(50, 0, 0, 100);
		pret.setColor(Color.RED);

		// window.debug();
		final Window window = new Window("UDP ChatRoom", skin);
		window.getButtonTable();
		window.setPosition(100, 400);
		window.defaults().pad(80, 80, 80, 80);
		window.row();
		window.add(validation);
		window.row();
		window.pack();

		// stage.addActor(new Button("Behind Window", skin));
		stage.addActor(window);
		validation.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				if ( game.mc == null ) {
					cw = new ChatWindow(game);
					uc = new UnicastClient(game);
					uc.chatWindow = cw;
		
					game.setMC(uc);
					game.cw = cw;
					try {
						uc.lancerClient();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				window.removeActor(validation);
				window.add(pret);

				pret.addListener(new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, Actor actor) {
						pret.setColor(Color.GREEN);
						try {
							game.mc.estPret();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				
				stage.addActor(game.cw.getWindow());
//				
			}
		});
		/*very slow.
    	final List<InetAddress> address = game.client.discoverHosts(54777, 5000);
    	TextButton[] IPList = new TextButton[address.size()];
    	for ( int i = 0; i < address.size(); i++ )
    	{
    		IPList[i]  = new TextButton(address.get(i).toString() + " connect", skin);
    		IPList[i].pad(50, 0, 0, 100);
    		final InetAddress tempIp = address.get(i);
			IPList[i].addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					pret.setColor(Color.GREEN);
					try {
						game.startConnect(tempIp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
    	}
		// window.debug();
		final Window TCPwindow = new Window("TCP Game", skin);
		TCPwindow.getButtonTable();
		TCPwindow.setPosition(800, 0);
		TCPwindow.defaults().pad(100, 80, 80, 80);
		TCPwindow.row();
		TCPwindow.add(IPList);
		TCPwindow.row();
		TCPwindow.pack();
		
		stage.addActor(TCPwindow);
		*/
	}
	/**
	 * 
	 */
	private Image buildBackgroundLayer() {
		Image scrollingImage = new Image(Assets.longWidthRegion);
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