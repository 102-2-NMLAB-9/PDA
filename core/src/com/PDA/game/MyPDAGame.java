package com.PDA.game;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import com.PDA.game.Personnage;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class MyPDAGame extends Game {
	public UITrick androidUI;
	boolean firstTimeCreate = true;
	public FPSLogger fps;
	public UnicastClient mc;
	public ChatWindow cw;
	public Joueur player;
	public ArrayList<Personnage> playersConnected;
	public ArrayList<String> listHost;
	public boolean currentVagueIndex = false;
	public int count = 0;
	public Array<String> IP;
	Server server;
	Client client;
	Kryo kryo;
	Kryo kryo1;
	Thread thread1;
	Thread thread2;
	
	public MyPDAGame(UITrick actionResolver) {
		super();
		this.androidUI = actionResolver;
		playersConnected = new ArrayList<Personnage>();
		listHost = new ArrayList<String>();
		player = new Test();
		player.setNom("test");
		mc = null;
		cw = null;
		IP = new Array<String>();
		server = new Server();
		client = new Client();
		thread1 = new Thread(server);
    	thread2 = new Thread(client);
    	server.start();
    	client.start();
    	thread1.start();
    	thread2.start();
		try
		{
			server.bind(54555, 54777);
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	    server.addListener(new Listener() {
	        public void received (Connection connection, Object object) {
	           if (object instanceof SomeRequest) {
	              SomeRequest request = (SomeRequest)object;
	              System.out.println(request.text);

	              SomeResponse response = new SomeResponse();
	              response.text = "Thanks";
	              connection.sendTCP(response);
	           }
	        }
	     });
	     client.addListener(new Listener() {
	        public void received (Connection connection, Object object) {
	           if (object instanceof SomeResponse) {
	              SomeResponse response = (SomeResponse)object;
	              System.out.println(response.text);
	           }
	        }
	     });
	     kryo = server.getKryo();
	     kryo.register(SomeRequest.class);
	     kryo.register(SomeResponse.class);
	     kryo1 = client.getKryo();
	     kryo1.register(SomeRequest.class);
	     kryo1.register(SomeResponse.class);
	}
	
	public MyPDAGame() {
		super();
	}
	
	public void setMC(UnicastClient m){
		this.mc = m;
	}
	
    public class SomeRequest {
        public String text;
    }
    
    public class SomeResponse {
        public String text;
    }
	
    public void startConnect(InetAddress address)
    {
    	System.out.println(address);
    	/*Very slow and it doesn't work.
    	try
    	{
    		client.connect(5000, address, 54555, 54777);
    	}
    	catch( Exception e )
    	{
    		e.printStackTrace();
    	}

    	SomeRequest request = new SomeRequest();
    	request.text = "Here is the request";
    	client.sendTCP(request);
    	*/
    }
	@Override
	public void create () {
		Settings.load();
		Assets.load();
		setScreen(new MainScreen(this));
		fps = new FPSLogger();
	}

	@Override
	public void render () {
		super.render();
	}
	
	/** {@link Game#dispose()} only calls {@link Screen#hide()} so you need to override {@link Game#dispose()} in order to call
	 * {@link Screen#dispose()} on each of your screens which still need to dispose of their resources. SuperJumper doesn't
	 * actually have such resources so this is only to complete the example. */
	@Override
	public void dispose () {
		if (mc != null) {
			try {
				this.mc.deco();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mc = null;
		}
		super.dispose();

		getScreen().dispose();
	}
}