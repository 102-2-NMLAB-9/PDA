package com.PDA.network;

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
import com.badlogic.gdx.Gdx;
import com.PDA.game.Joueur;
import com.PDA.game.Constants;
import com.PDA.game.MapPerso;
import com.PDA.game.Test;

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
	private MapPerso<String, Joueur> joueurs;

	public UnicastClient(MyPDAGame g) {
		// initialization
		this.game = g;
		joueurs = new MapPerso<String, Joueur>();

		monIp = this.getLocalIpAddress();
		joueurs.put(monIp, game.player);
		game.playersConnected.add(game.player);
		receive();

	}

	public void lancerClient() throws IOException {
		sendConnection(null, false);
		chatWindow.addName(game.player.getNom() + " : "
				+ game.player.getNameClass());
	}

	public void sendConnection(String ipNouveau, boolean nouveau)
			throws IOException {
		byte[] data;

		data = ((Joueur) this.game.player).getBytes();

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
		case Constants.LANCERSKILL:
			actionTraiterLancerSkill(data);
			break;
		case Constants.ATTAQUEMONSTRE:
			actionTraiterAttaqueMonstre(data);
			break;
		case Constants.TOKEN:
		case Constants.TOKENTOUR:
			actionToken(data, action);
			break;
		case Constants.MESSAGE:
			actionRecoit(data);
			break;
		case Constants.PRET:
			actionPret();
			break;
		case Constants.LANCERSOIN:
			actionLancerSoin(data);
			break;
		case Constants.DECO:
			actionDeco();
			break;
		default:
			System.err.println("[UNICASTClient-DEFAULT]:Action non reconnue : "
					+ action);
			break;
		}
	}

	private void actionLancerSoin(byte[] data) {
		ip = dpr.getAddress().toString().replace('/', '\0').trim();
		String ipCible = new String(data, 2, data.length - 2).trim();
		if (joueurs.get(ipCible).getHp() <= 0)
			joueurs.get(ipCible).setaJoueCeTour(true);
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
		String pseudo;
		pseudo = new String(data, 3, data[2]);
		Joueur p = null;
		p = new Test();
		ip = dpr.getAddress().toString().replace('/', '\0').trim();
		if (ip.length() > 0 && !joueurs.containsKey(ip)
				&& !ip.equals("127.0.0.1")) {

			game.playersConnected.add(p);
			joueurs.put(ip, p);
			this.chatWindow.addName(p.getNom() + " : " + p.getNameClass());
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

	private void actionTraiterLancerSkill(byte[] data) {
		ip = dpr.getAddress().toString().replace('/', '\0').trim();

	}

	private void actionTraiterAttaqueMonstre(byte[] data) {

		ip = new String(data, 2, data.length - 2).trim();

		boolean joueursMort = true;
		for (Joueur j : joueurs.values()) {
			if (j.getHp() > 0) {
				joueursMort = false;
			} else {
				j.setaJoueCeTour(true);
			}
		}
	}

	private void actionToken(byte[] data, int action) {
		System.out.println("la");
		for (Joueur it : joueurs.values()) {
			it.setToken(false);
			if (action == Constants.TOKENTOUR) {
				it.setaJoueCeTour(false);
			}
		}

		ip = new String(data, 1, data.length - 1).trim();
		System.err.println("IP TOKEN :" + ip);

		joueurs.get(ip).setToken(true);

		joueurs.get(ip).setaJoueCeTour(true);

		Gdx.app.postRunnable(new Runnable() {
			public void run() {
			}
		});

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

	public void pretPourVagueSuivante(final String ip) {
		boolean pret = true;
		for (Joueur j : joueurs.values()) {
			if (!j.estPret()) {
				pret = false;
				break;
			}
		}
		if (pret) {
			
			for (Joueur j : joueurs.values()) {
				j.setPret(false);
			}
			
			regen();
			
			joueurs.get(ip).setToken(true);
			
			
			
			joueurs.get(ip).setaJoueCeTour(true);
			System.out.println("A JOUE CE TOUR : " + ip);

			return;
		}

	}

	public void estPret() throws IOException {
		byte data[] = new byte[1];
		data[0] = (byte) Constants.PRET;
		sendToAll(data);
	}

	public void actionPret() {
		String ip = dpr.getAddress().toString().replace('/', '\0').trim();
		joueurs.get(ip).setPret(true);
		pretPourVagueSuivante(ip);
	}
	
	public void actionDeco(){
		String ip = dpr.getAddress().toString().replace('/', '\0').trim();
		this.chatWindow.removeName(joueurs.get(ip).getName());
		game.playersConnected.remove(joueurs.get(ip));
		this.joueurs.remove(ip);
	}

	public void passerToken() throws IOException {

		String ipChoisi = "";

		for (Joueur j : joueurs.values()) {

			if (!j.aJoueCeTour()) {
				System.out.println(j.getNom() + " a joue ce tour : "
						+ j.aJoueCeTour());
				ipChoisi = joueurs.getKey(j);
				break;
			}

		}

		byte data[];

		if (ipChoisi.length() < 1) {
			ipChoisi = joueurs.getKey((Joueur) game.playersConnected
					.get(game.playersConnected.size() - 1));
			data = new byte[ipChoisi.length() + 1];
			data[0] = Constants.TOKENTOUR;

		} else {
			data = new byte[ipChoisi.length() + 1];
			data[0] = Constants.TOKEN;
		}
		for (int i = 1; i < data.length; i++) {
			data[i] = (byte) ipChoisi.charAt(i - 1);
		}

		sendToAll(data);
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

	private void regen() {
		for (Joueur j : joueurs.values()) {
			if (j.getHp() > 0)
				j.setHp(j.getHpMax());
			j.setMana(j.getManaMax());
		}
	}
	
	
	public MapPerso<String, Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(MapPerso<String, Joueur> joueurs) {
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
}
