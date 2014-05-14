package com.PDA.game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Set;

import com.PDA.game.ChatWindow;
import com.PDA.game.MyPDAGame;
import com.PDA.game.Constants;
import com.PDA.game.MapPerso;
import com.PDA.game.Test;
import com.badlogic.gdx.Gdx;

public class UnicastClient {

	private DatagramSocket ds;
	private DatagramSocket dsR;
	public final static int PORT = 12345;
	public MyPDAGame game;
	private DatagramPacket dp;
	private DatagramPacket dpr;
	private String ip;
	public String monIp;
	public ChatWindow chatWindow;
	private MapPerso<String, Test> joueurs;
	private Attacker attack;
	private Defencer defence;
	boolean selection = false;
	boolean type = false;

	public UnicastClient(MyPDAGame g) {
		// initialization
		this.game = g;
		chatWindow = g.cw;
		joueurs = new MapPerso<String, Test>();

		monIp = this.getLocalIpAddress();
		joueurs.put(monIp, game.player);
		game.playersConnected.add(game.player);
		receive();

	}

	public void lancerClient() throws IOException {
		sendConnection(null, false);
		chatWindow.addName("test" + " : "
				+ game.count);
		game.player.setName("test" + " : "
				+ game.count);
		game.player.setNom("test" + "_"
				+ game.count);
		game.count++ ;
	}

	public void sendConnection(String ipNouveau, boolean nouveau)
			throws IOException {
		byte[] data;

		data = (this.game.player).getBytes();

		if (nouveau) {

			data[0] = Constants.NOUVEAU;
			if (ipNouveau.replace('/', '\0').trim().equals(monIp)
					|| ipNouveau.replace('/', '\0').trim().equals("127.0.0.1")) {

				return;
			}

			dp = new DatagramPacket(data, data.length);
			dp.setAddress(InetAddress.getByName(ipNouveau));
			dp.setPort(PORT);
			ds.send(dp);

		} else {

			data[0] = Constants.CONNEXION;
			String[] broadcastTab = this.monIp.split("\\.");
			String broadcast = broadcastTab[0] + "." + broadcastTab[1] + "."
					+ broadcastTab[2] + ".255";
			dp = new DatagramPacket(data, data.length,
					InetAddress.getByName(broadcast), PORT);
			if ( ds == null )
				ds = new DatagramSocket();
			ds.send(dp);

			dp = new DatagramPacket(data, data.length,
					InetAddress.getByName("255.255.255.255"), PORT);
			ds.send(dp);

		}
	}

	private void receive() {
		try {
			dsR = new DatagramSocket(PORT);
			ds = new DatagramSocket();
			ds.setBroadcast(true);
		} catch (SocketException e1) {
			game.androidUI.showAlertBox("Disconnect",
					"lalala", "ok", null);
			return;
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					byte[] data = new byte[128];
					dpr = new DatagramPacket(data, data.length);

					try {
						// reception
						dsR.receive(dpr);
						// System.out.println("RECU");
						data = dpr.getData();
						traiterData(data);

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}).start();
	}

	private void traiterData(byte[] data) throws IOException {
		int action = (int) data[0];
		System.out.println("[UNICASTClient-TraiterData]:Donnees recu  : "
				+ action);
		switch (action) {
		case Constants.CONNEXION:
		case Constants.NOUVEAU:
			actionTraiterNouveau(action, data);
			break;
		case Constants.MESSAGE:
			actionRecoit(data);
			break;
		case Constants.DECO:
			actionDeco();
			break;
		case Constants.PRET:
			actionPret();
			break;
		case Constants.ATTACK:
			if (type)
				attack.drawAttack((int)data[1]);
			else
				defence.drawAttack((int)data[1]);
			break;
		case Constants.DEFENCE:
			if (type)
				attack.drawDefence((int)data[1]);
			else
				defence.drawDefence((int)data[1]);
			break;
		default:
			System.err.println("[UNICASTClient-DEFAULT]:Action non reconnue : "
					+ action);
			break;
		}
	}

	private void actionRecoit(byte[] data) {

		String pseudoMsg = new String(data, 2, data[1]);
		String msg = new String(data, 2 + data[1], data.length - data[1] - 2)
				.trim();
		this.chatWindow.addMessage(pseudoMsg + " : " + msg);

	}

	private void actionTraiterNouveau(int action, byte[] data)
			throws IOException {
		System.out.println("NOUVEAU JOUEUR");
		Test p = new Test();
		String pseudo;
		pseudo = new String(data, 3, data[2]);
		p.setNom(pseudo);
		p.setName("test" + " : "
				+ game.count);
		p.setNom("test" + "_"
				+ game.count);
		ip = dpr.getAddress().toString().replace('/', '\0').trim();
		if (ip.length() > 0 && !joueurs.containsKey(ip)
				&& !ip.equals("127.0.0.1")) {

			game.playersConnected.add(p);
			joueurs.put(ip, p);
			//game.IP.add(ip);
			this.chatWindow.addName("test" + " : " + game.count);
			game.count++;
		}
		if (action == Constants.CONNEXION)
			sendConnection(ip, true);

		System.out.println("[UNICAST]\n-- Affichage de(s) " + joueurs.size()
				+ " joueur(s) --");
		Set<String> key = joueurs.keySet();
		for (String it : key) {
			System.out.println("ip : " + it + " Pseudo : "
					+ joueurs.get(it).getNom());
		}

	}

	public void envoieMessage(String m) throws IOException {
		String pseudo = game.player.getNom();
		byte[] data = new byte[2 + pseudo.length() + m.length()];
		data[0] = Constants.MESSAGE;
		data[1] = (byte) pseudo.length();

		for (int i = 2; i < pseudo.length() + 2; i++)
			data[i] = (byte) pseudo.charAt(i - 2);

		for (int i = 2 + pseudo.length(); i < data.length; i++)
			data[i] = (byte) m.charAt(i - 2 - pseudo.length());
		sendToAll(data);
	}

	public void actionDeco(){
		String ip = dpr.getAddress().toString().replace('/', '\0').trim();
		this.chatWindow.removeName(joueurs.get(ip).getName());
		game.playersConnected.remove(joueurs.get(ip));
		this.joueurs.remove(ip);
	}

	private void sendToAll(byte[] data) throws IOException {
		dp = new DatagramPacket(data, data.length);
		for (String ips : joueurs.keySet()) {

			dp.setAddress(InetAddress.getByName(ips));
			dp.setPort(PORT);
			ds.send(dp);
		}
	}
	
	public void deco() throws IOException{
		byte data[] = new byte[1];
		data[0] = Constants.DECO;
		sendToAll(data);
	}	
	
	public MapPerso<String, Test> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(MapPerso<String, Test> joueurs) {
		this.joueurs = joueurs;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocalIpAddress() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()
							&& inetAddress.getHostAddress().length() <= 15) {
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public void estPret() throws IOException {
		byte data[] = new byte[1];
		data[0] = (byte) Constants.PRET;
		sendToAll(data);
	}
	
	public void actionPret() {
		String ip = dpr.getAddress().toString().replace('/', '\0').trim();
		joueurs.get(ip).setPret(true);
		if ( ip.equals(monIp) )
		{
			selection = true;
		}
		pretPourVagueSuivante(ip);
	}
	
	public void pretPourVagueSuivante(final String ip) {
		boolean pret = true;
		int count = 0;
		for (Test j : joueurs.values()) {
			if (!j.estPret()) {
				pret = false;
			}
			else
				count++;
		}
		if (selection)
		{
			if( count % 2 == 0 )
				type = false;
			else
				type = true;
		}
		selection = false;
		if (pret) {
			game.currentVagueIndex = true;
			for (Test j : joueurs.values()) {
				j.setPret(false);
			}

			Gdx.app.postRunnable(new Runnable() {
				public void run() {
					if(game.currentVagueIndex == true){
						game.currentVagueIndex = false;
						if (type)
						{
							attack = new Attacker(game);
							game.setScreen(attack);
							System.out.println(type);
						}
						else
						{
							defence = new Defencer(game);
							game.setScreen(defence);
							System.out.println(type);
						}
					}			
				}
			});
			return;
		}

	}
	
	public void sendAttack( int number ) throws IOException {
		byte data[] = new byte[2];
		data[0] = (byte) Constants.ATTACK;
		data[1] = (byte) number;
		sendToAll(data);
	}
	
	public void sendDefence( int number ) throws IOException {
		byte data[] = new byte[2];
		data[0] = (byte) Constants.DEFENCE;
		data[1] = (byte) number;
		sendToAll(data);
	}
}
