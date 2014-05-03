package com.PDA.game;

import java.io.IOException;

import com.PDA.game.MyPDAGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.SplitPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;

public  class ChatWindow{
	private Window window;
	private Skin skin;
	private List<String> messageList;
	private List<String> nameList;
	private TextButton envoyer;
	private TextField tfMessage;

	public ChatWindow(final MyPDAGame game){

		skin = new Skin(Gdx.files.internal("data/uiskin.json"));

		tfMessage = new TextField("", skin);
		tfMessage.setMessageText("send your message");
		envoyer = new TextButton("send",skin);
		envoyer.pad(50, 0, 0, 100);
		envoyer.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				if (getSendText().length() == 0) return;
				try {
					game.mc.envoieMessage(getSendText());
				} catch (IOException e) {
					e.printStackTrace();
				}
				tfMessage.setText("");
			}
		});
		
		messageList = new List<String>(skin);
		nameList = new List<String>(skin);

		ScrollPane scrollPaneMessage = new ScrollPane(messageList,skin);
		scrollPaneMessage.setFlickScroll(true);

		ScrollPane scrollPaneUser = new ScrollPane(nameList, skin);
		scrollPaneUser.setFlickScroll(true);
		
		SplitPane splitPane = new SplitPane(scrollPaneMessage, scrollPaneUser, false, skin, "default-horizontal");

		float width = 1280f;
		float height = 960f;

		window = new Window("Chat", skin);
		window.setPosition(width*5, 100);
		window.defaults().spaceBottom(10);
		window.row().fill().expandX();
		window.row();
		window.add(splitPane).minWidth((float) (width*.5)).expandX().fillX().minHeight((float) (height*.3));
		window.row();
		window.add(tfMessage).minWidth((float) (width*.5)).expandX().fillX().colspan(10);
		window.row();
		window.add(envoyer);
		window.row();
		window.pack();



	}

	public Window getWindow(){
		return window;
	}

	public void setSendListener (final Runnable listener) {
		envoyer.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				if (getSendText().length() == 0) return;
				listener.run();
				tfMessage.setText("");
			}
		});
	}


	public String getSendText () {
		return tfMessage.getText().trim();
	}

	public void setNames (final Array<String> names) {
		// This listener is run on the client's update thread, which was started by client.start().
		// We must be careful to only interact with Swing components on the Swing event thread.
		//		EventQueue.invokeLater(new Runnable() {
		//			public void run () {
		nameList.setItems(names);
		//			}
		//		});
	}
	
	public void addMessage (final String message) {
		Array<String> listMessage= new Array<String>();
		for(String it: messageList.getItems()){
			listMessage.add(it);
		}
		listMessage.add(message);
		messageList.setItems(listMessage);
	}

	public void addName(String name) {
		Array<String> tmp = this.nameList.getItems();
		Array<String> names = new Array<String>();
		for(int i = 0; i < tmp.size; i ++)
			names.add(name);
		names.add(name);
		this.setNames(names);
	}

	public void removeName(String name) {
		Array<String> tmp = this.nameList.getItems();
		Array<String> names = new Array<String>();
		int i = 0;
		int j = 0;
		boolean trouve = false;
		while(j < tmp.size - 1){
			if(tmp.get(i).equals(name)){
				i++;
				trouve = true;
			}
			else{
				names.add(tmp.get(i));
				i++;
				j++;
			}
		}
		
		if(trouve)
			this.setNames(names);
	}
}