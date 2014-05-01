package com.PDA.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture background;
	public static TextureRegion backgroundRegion;

	/*
	public static Texture items;
	public static TextureRegion mainMenu;
	public static TextureRegion pauseMenu;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion highScoresRegion;
	public static TextureRegion logo;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion arrow;
	public static TextureRegion pause;
	public static TextureRegion spring;
	public static TextureRegion castle;
	public static Animation coinAnim;
	public static Animation bobJump;
	public static Animation bobFall;
	public static TextureRegion bobHit;
	public static Animation squirrelFly;
	public static TextureRegion platform;
	public static Animation brakingPlatform;
	*/
	public static BitmapFont font;

	public static Music music;
	/*
	public static Sound jumpSound;
	public static Sound highJumpSound;
	public static Sound hitSound;
	public static Sound coinSound;
	*/
	public static Sound clickSound;

	public static Texture play;
	public static TextureRegion playRegion;
	public static Texture war;
	public static TextureRegion warRegion;
	public static Texture sound;
	public static TextureRegion soundRegion;
	public static Texture noSound;
	public static TextureRegion noSoundRegion;
	public static Texture highScore;
	public static TextureRegion highScoreRegion;
	public static Texture back;
	public static TextureRegion backRegion;
	public static Texture help;
	public static TextureRegion helpRegion;
	public static Texture twoplay;
	public static TextureRegion twoplayRegion;
	public static Texture gamescene;
	public static TextureRegion gamesceneRegion;
	public static Texture test;
	public static TextureRegion testRegion;
	public static Texture[] boxes;
	public static TextureRegion[] boxregion; 
	
	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background = loadTexture("data/background.jpg");
		backgroundRegion = new TextureRegion(background, 0, 0, 1280, 960);
		
		/*
		items = loadTexture("data/items.png");
		mainMenu = new TextureRegion(items, 0, 224, 300, 110);
		pauseMenu = new TextureRegion(items, 224, 128, 192, 96);
		ready = new TextureRegion(items, 320, 224, 192, 32);
		gameOver = new TextureRegion(items, 352, 256, 160, 96);
		highScoresRegion = new TextureRegion(Assets.items, 0, 257, 300, 110 / 3);
		logo = new TextureRegion(items, 0, 352, 274, 142);
		soundOff = new TextureRegion(items, 0, 0, 64, 64);
		soundOn = new TextureRegion(items, 64, 0, 64, 64);
		arrow = new TextureRegion(items, 0, 64, 64, 64);
		pause = new TextureRegion(items, 64, 64, 64, 64);

		spring = new TextureRegion(items, 128, 0, 32, 32);
		castle = new TextureRegion(items, 128, 64, 64, 64);
		coinAnim = new Animation(0.2f, new TextureRegion(items, 128, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32),
			new TextureRegion(items, 192, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32));
		bobJump = new Animation(0.2f, new TextureRegion(items, 0, 128, 32, 32), new TextureRegion(items, 32, 128, 32, 32));
		bobFall = new Animation(0.2f, new TextureRegion(items, 64, 128, 32, 32), new TextureRegion(items, 96, 128, 32, 32));
		bobHit = new TextureRegion(items, 128, 128, 32, 32);
		squirrelFly = new Animation(0.2f, new TextureRegion(items, 0, 160, 32, 32), new TextureRegion(items, 32, 160, 32, 32));
		platform = new TextureRegion(items, 64, 160, 64, 16);
		brakingPlatform = new Animation(0.2f, new TextureRegion(items, 64, 160, 64, 16), new TextureRegion(items, 64, 176, 64, 16),
		new TextureRegion(items, 64, 192, 64, 16), new TextureRegion(items, 64, 208, 64, 16));
		 */
		
		play = loadTexture("data/play.png");
		playRegion = new TextureRegion(play);
		war = loadTexture("data/war.png");
		warRegion = new TextureRegion(war);
		sound = loadTexture("data/sound.png");
		soundRegion = new TextureRegion(sound);
		noSound = loadTexture("data/nosound.png");
		noSoundRegion = new TextureRegion(noSound);
		highScore = loadTexture("data/highScore.png");
		highScoreRegion = new TextureRegion(highScore);
		back = loadTexture("data/back.png");
		backRegion = new TextureRegion(back);
		twoplay = loadTexture("data/2play.png");
		twoplayRegion = new TextureRegion(twoplay);
		help = loadTexture("data/helpme.png");
		helpRegion = new TextureRegion(help);
		gamescene = loadTexture("data/scene.png");
		gamesceneRegion = new TextureRegion(gamescene);
		test = loadTexture("data/movetest.png");
		testRegion = new TextureRegion(test);
		boxes = new Texture[16];
		for(int i=0; i<16; ++i ) boxes[i] = loadTexture("data/cell.png");
		boxregion = new TextureRegion[16];
		for(int i=0; i<16; ++i) boxregion[i] = new TextureRegion(boxes[i]);
		
		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);
		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		if (Settings.soundEnabled) music.play();
		/*
		jumpSound = Gdx.audio.newSound(Gdx.files.internal("data/jump.wav"));
		highJumpSound = Gdx.audio.newSound(Gdx.files.internal("data/highjump.wav"));
		hitSound = Gdx.audio.newSound(Gdx.files.internal("data/hit.wav"));
		coinSound = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
		*/
		clickSound = Gdx.audio.newSound(Gdx.files.internal("data/click.wav"));
	}

	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(1);
	}
}