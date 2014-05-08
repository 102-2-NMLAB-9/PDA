package com.PDA.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
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
	
    public static Animation dennis;
    public static Animation freezer;
    public static Animation wind; 
    public static Animation firer;    
    public static Animation bomb;
    public static Animation frozen;    
    public static Animation cannon;    
    public static Texture[] littlefighter;
	public static Animation soldier1;
	public static Animation soldier2;
	public static Animation soldier3;
	public static Animation soldier4;
	public static Animation soldier5;
	public static Animation soldier6;
	public static Animation soldier7;
	public static Animation soldier8;
	public static Animation soldier9;
	public static Animation soldier10;
	public static Animation soldier11;
	public static Animation soldier12;
	public static Animation soldier13;
	public static Animation soldier14;
	public static Animation soldier15;
	public static Animation soldier16;
	public static Texture[] movingsoldier;	
	public static Texture door;
	public static TextureRegion doorRegion;	
	
	public static Texture[] soldiers;
	public static TextureRegion[] soldier_regions;


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
	public static Texture boxes;
	public static TextureRegion boxregion;
	public static Texture longWidth;
	public static TextureRegion longWidthRegion;
	
	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background = loadTexture("data/background.jpg");
		backgroundRegion = new TextureRegion(background);
		
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
		
		littlefighter = new Texture[100];
		littlefighter[0] = loadTexture("data/a-1.png");
		littlefighter[1] = loadTexture("data/a-2.png");
		littlefighter[2] = loadTexture("data/a-3.png");
		littlefighter[3] = loadTexture("data/a-4.png");
		littlefighter[4] = loadTexture("data/a-5.png");		
		littlefighter[5] = loadTexture("data/a-6.png");
		littlefighter[6] = loadTexture("data/a-7.png");
		littlefighter[7] = loadTexture("data/a-8.png");
		littlefighter[8] = loadTexture("data/a-9.png");
		littlefighter[9] = loadTexture("data/a-10.png");			
		dennis = new Animation(0.1f,new TextureRegion(littlefighter[0]),new TextureRegion(littlefighter[1]),
				new TextureRegion(littlefighter[2]),new TextureRegion(littlefighter[3]),
				new TextureRegion(littlefighter[4]),new TextureRegion(littlefighter[5]),
				new TextureRegion(littlefighter[6]),new TextureRegion(littlefighter[7]),
				new TextureRegion(littlefighter[8]),new TextureRegion(littlefighter[9]));
		littlefighter[0] = loadTexture("data/b-1.png");
		littlefighter[1] = loadTexture("data/b-2.png");
		littlefighter[2] = loadTexture("data/b-3.png");
		littlefighter[3] = loadTexture("data/b-4.png");
		littlefighter[4] = loadTexture("data/b-5.png");		
		littlefighter[5] = loadTexture("data/b-6.png");
		littlefighter[6] = loadTexture("data/b-7.png");
		littlefighter[7] = loadTexture("data/b-8.png");
		littlefighter[8] = loadTexture("data/b-9.png");
		littlefighter[9] = loadTexture("data/b-10.png");				
		freezer = new Animation(0.1f,new TextureRegion(littlefighter[0]),new TextureRegion(littlefighter[1]),
				new TextureRegion(littlefighter[2]),new TextureRegion(littlefighter[3]),
				new TextureRegion(littlefighter[4]),new TextureRegion(littlefighter[5]),
				new TextureRegion(littlefighter[6]),new TextureRegion(littlefighter[7]),
				new TextureRegion(littlefighter[8]),new TextureRegion(littlefighter[9]));
		littlefighter[0] = loadTexture("data/wind-1.png");
		littlefighter[1] = loadTexture("data/wind-2.png");
		littlefighter[2] = loadTexture("data/wind-3.png");
		littlefighter[3] = loadTexture("data/wind-4.png");
		littlefighter[4] = loadTexture("data/wind-5.png");		
		littlefighter[5] = loadTexture("data/wind-6.png");
		littlefighter[6] = loadTexture("data/wind-7.png");
		littlefighter[7] = loadTexture("data/wind-8.png");
		littlefighter[8] = loadTexture("data/wind-5.png");		
		littlefighter[9] = loadTexture("data/wind-6.png");
		littlefighter[10] = loadTexture("data/wind-7.png");
		littlefighter[11] = loadTexture("data/wind-8.png");
		littlefighter[12] = loadTexture("data/wind-5.png");		
		littlefighter[13] = loadTexture("data/wind-6.png");
		littlefighter[14] = loadTexture("data/wind-7.png");
		littlefighter[15] = loadTexture("data/wind-8.png");
		littlefighter[16] = loadTexture("data/wind-5.png");		
		littlefighter[17] = loadTexture("data/wind-6.png");
		littlefighter[18] = loadTexture("data/wind-7.png");
		littlefighter[19] = loadTexture("data/wind-8.png");		
		littlefighter[20] = loadTexture("data/wind-9.png");	
		littlefighter[21] = loadTexture("data/wind-10.png");
		wind = new Animation(0.1f,new TextureRegion(littlefighter[0]),new TextureRegion(littlefighter[1]),
				new TextureRegion(littlefighter[2]),new TextureRegion(littlefighter[3]),
				new TextureRegion(littlefighter[4]),new TextureRegion(littlefighter[5]),
				new TextureRegion(littlefighter[6]),new TextureRegion(littlefighter[7]),
				new TextureRegion(littlefighter[8]),new TextureRegion(littlefighter[9]),
				new TextureRegion(littlefighter[10]),new TextureRegion(littlefighter[11]),
				new TextureRegion(littlefighter[12]),new TextureRegion(littlefighter[13]),
				new TextureRegion(littlefighter[14]),new TextureRegion(littlefighter[15]),
				new TextureRegion(littlefighter[16]),new TextureRegion(littlefighter[17]),
				new TextureRegion(littlefighter[18]),new TextureRegion(littlefighter[19]),
				new TextureRegion(littlefighter[20]),new TextureRegion(littlefighter[21]));		
		littlefighter[0] = loadTexture("data/c-1.png");
		littlefighter[1] = loadTexture("data/c-2.png");
		littlefighter[2] = loadTexture("data/c-3.png");
		littlefighter[3] = loadTexture("data/c-4.png");
		littlefighter[4] = loadTexture("data/c-5.png");		
		littlefighter[5] = loadTexture("data/c-6.png");
		firer = new Animation(0.1f,new TextureRegion(littlefighter[0]),new TextureRegion(littlefighter[1]),
				new TextureRegion(littlefighter[2]),new TextureRegion(littlefighter[3]),
				new TextureRegion(littlefighter[4]),new TextureRegion(littlefighter[5]));	
		littlefighter[0] = loadTexture("data/bomb-1.png");
		littlefighter[1] = loadTexture("data/bomb-2.png");
		littlefighter[2] = loadTexture("data/bomb-3.png");
		littlefighter[3] = loadTexture("data/bomb-4.png");
		littlefighter[4] = loadTexture("data/bomb-5.png");		
		littlefighter[5] = loadTexture("data/bomb-6.png");
		littlefighter[6] = loadTexture("data/bomb-7.png");
		littlefighter[7] = loadTexture("data/bomb-8.png");
		littlefighter[8] = loadTexture("data/bomb-9.png");
		littlefighter[9] = loadTexture("data/bomb-10.png");				
		bomb = new Animation(0.1f,new TextureRegion(littlefighter[0]),new TextureRegion(littlefighter[1]),
				new TextureRegion(littlefighter[2]),new TextureRegion(littlefighter[3]),
				new TextureRegion(littlefighter[4]),new TextureRegion(littlefighter[5]),
				new TextureRegion(littlefighter[6]),new TextureRegion(littlefighter[7]),
				new TextureRegion(littlefighter[8]),new TextureRegion(littlefighter[9]));		
		littlefighter[0] = loadTexture("data/d-1.png");
		littlefighter[1] = loadTexture("data/d-2.png");
		littlefighter[2] = loadTexture("data/d-3.png");
		frozen = new Animation(0.1f,new TextureRegion(littlefighter[0]),new TextureRegion(littlefighter[1]),
				new TextureRegion(littlefighter[2]),new TextureRegion(littlefighter[3]));			
		
		movingsoldier = new Texture[8];
		movingsoldier[0] = loadTexture("data/1-1.png");
		movingsoldier[1] = loadTexture("data/1-2.png");
		movingsoldier[2] = loadTexture("data/1-3.png");
		movingsoldier[3] = loadTexture("data/1-4.png");
		movingsoldier[4] = loadTexture("data/1-5.png");
		movingsoldier[5] = loadTexture("data/1-6.png");		
		movingsoldier[6] = loadTexture("data/1-7.png");
		movingsoldier[7] = loadTexture("data/1-8.png");		
		soldier1 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));
		movingsoldier[0] = loadTexture("data/2-1.png");		
		movingsoldier[1] = loadTexture("data/2-2.png");
		movingsoldier[2] = loadTexture("data/2-3.png");
		movingsoldier[3] = loadTexture("data/2-4.png");
		movingsoldier[4] = loadTexture("data/2-5.png");
		movingsoldier[5] = loadTexture("data/2-6.png");		
		movingsoldier[6] = loadTexture("data/2-7.png");
		movingsoldier[7] = loadTexture("data/2-8.png");	
		soldier2 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));
		movingsoldier[0] = loadTexture("data/3-1.png");		
		movingsoldier[1] = loadTexture("data/3-2.png");
		movingsoldier[2] = loadTexture("data/3-3.png");
		movingsoldier[3] = loadTexture("data/3-4.png");
		movingsoldier[4] = loadTexture("data/3-5.png");
		movingsoldier[5] = loadTexture("data/3-6.png");		
		movingsoldier[6] = loadTexture("data/3-7.png");
		movingsoldier[7] = loadTexture("data/3-8.png");	
		soldier3 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));		
		movingsoldier[0] = loadTexture("data/4-1.png");		
		movingsoldier[1] = loadTexture("data/4-2.png");
		movingsoldier[2] = loadTexture("data/4-3.png");
		movingsoldier[3] = loadTexture("data/4-4.png");
		movingsoldier[4] = loadTexture("data/4-5.png");
		movingsoldier[5] = loadTexture("data/4-6.png");		
		movingsoldier[6] = loadTexture("data/4-7.png");
		movingsoldier[7] = loadTexture("data/4-8.png");	
		soldier4 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));		
		movingsoldier[0] = loadTexture("data/5-1.png");		
		movingsoldier[1] = loadTexture("data/5-2.png");
		movingsoldier[2] = loadTexture("data/5-3.png");
		movingsoldier[3] = loadTexture("data/5-4.png");
		movingsoldier[4] = loadTexture("data/5-5.png");
		movingsoldier[5] = loadTexture("data/5-6.png");		
		movingsoldier[6] = loadTexture("data/5-7.png");
		movingsoldier[7] = loadTexture("data/5-8.png");	
		soldier5 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));		
		movingsoldier[0] = loadTexture("data/6-1.png");		
		movingsoldier[1] = loadTexture("data/6-2.png");
		movingsoldier[2] = loadTexture("data/6-3.png");
		movingsoldier[3] = loadTexture("data/6-4.png");
		movingsoldier[4] = loadTexture("data/6-5.png");
		movingsoldier[5] = loadTexture("data/6-6.png");		
		movingsoldier[6] = loadTexture("data/6-7.png");
		movingsoldier[7] = loadTexture("data/6-8.png");	
		soldier6 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));		
		movingsoldier[0] = loadTexture("data/7-1.png");		
		movingsoldier[1] = loadTexture("data/7-2.png");
		movingsoldier[2] = loadTexture("data/7-3.png");
		movingsoldier[3] = loadTexture("data/7-4.png");
		movingsoldier[4] = loadTexture("data/7-5.png");
		movingsoldier[5] = loadTexture("data/7-6.png");		
		movingsoldier[6] = loadTexture("data/7-7.png");
		movingsoldier[7] = loadTexture("data/7-8.png");	
		soldier7 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));			
		movingsoldier[0] = loadTexture("data/8-1.png");		
		movingsoldier[1] = loadTexture("data/8-2.png");
		movingsoldier[2] = loadTexture("data/8-3.png");
		movingsoldier[3] = loadTexture("data/8-4.png");
		movingsoldier[4] = loadTexture("data/8-5.png");
		movingsoldier[5] = loadTexture("data/8-6.png");		
		movingsoldier[6] = loadTexture("data/8-7.png");
		movingsoldier[7] = loadTexture("data/8-8.png");	
		soldier8 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));			
		movingsoldier[0] = loadTexture("data/9-1.png");		
		movingsoldier[1] = loadTexture("data/9-2.png");
		movingsoldier[2] = loadTexture("data/9-3.png");
		movingsoldier[3] = loadTexture("data/9-4.png");
		movingsoldier[4] = loadTexture("data/9-5.png");
		movingsoldier[5] = loadTexture("data/9-6.png");		
		movingsoldier[6] = loadTexture("data/9-7.png");
		movingsoldier[7] = loadTexture("data/9-8.png");	
		soldier9 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));	
		movingsoldier[0] = loadTexture("data/10-1.png");		
		movingsoldier[1] = loadTexture("data/10-2.png");
		movingsoldier[2] = loadTexture("data/10-3.png");
		movingsoldier[3] = loadTexture("data/10-4.png");
		movingsoldier[4] = loadTexture("data/10-5.png");
		movingsoldier[5] = loadTexture("data/10-6.png");		
		movingsoldier[6] = loadTexture("data/10-7.png");
		movingsoldier[7] = loadTexture("data/10-8.png");	
		soldier10 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));	
		movingsoldier[0] = loadTexture("data/11-1.png");		
		movingsoldier[1] = loadTexture("data/11-2.png");
		movingsoldier[2] = loadTexture("data/11-3.png");
		movingsoldier[3] = loadTexture("data/11-4.png");
		movingsoldier[4] = loadTexture("data/11-5.png");
		movingsoldier[5] = loadTexture("data/11-6.png");		
		movingsoldier[6] = loadTexture("data/11-7.png");
		movingsoldier[7] = loadTexture("data/11-8.png");	
		soldier11 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));
		movingsoldier[0] = loadTexture("data/12-1.png");		
		movingsoldier[1] = loadTexture("data/12-2.png");
		movingsoldier[2] = loadTexture("data/12-3.png");
		movingsoldier[3] = loadTexture("data/12-4.png");
		movingsoldier[4] = loadTexture("data/12-5.png");
		movingsoldier[5] = loadTexture("data/12-6.png");		
		movingsoldier[6] = loadTexture("data/12-7.png");
		movingsoldier[7] = loadTexture("data/12-8.png");	
		soldier12 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));			
		movingsoldier[0] = loadTexture("data/13-1.png");		
		movingsoldier[1] = loadTexture("data/13-2.png");
		movingsoldier[2] = loadTexture("data/13-3.png");
		movingsoldier[3] = loadTexture("data/13-4.png");
		movingsoldier[4] = loadTexture("data/13-5.png");
		movingsoldier[5] = loadTexture("data/13-6.png");		
		movingsoldier[6] = loadTexture("data/13-7.png");
		movingsoldier[7] = loadTexture("data/13-8.png");	
		soldier13 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));			
		movingsoldier[0] = loadTexture("data/14-1.png");		
		movingsoldier[1] = loadTexture("data/14-2.png");
		movingsoldier[2] = loadTexture("data/14-3.png");
		movingsoldier[3] = loadTexture("data/14-4.png");
		movingsoldier[4] = loadTexture("data/14-5.png");
		movingsoldier[5] = loadTexture("data/14-6.png");		
		movingsoldier[6] = loadTexture("data/14-7.png");
		movingsoldier[7] = loadTexture("data/14-8.png");	
		soldier14 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));			
		movingsoldier[0] = loadTexture("data/15-1.png");		
		movingsoldier[1] = loadTexture("data/15-2.png");
		movingsoldier[2] = loadTexture("data/15-3.png");
		movingsoldier[3] = loadTexture("data/15-4.png");
		movingsoldier[4] = loadTexture("data/15-5.png");
		movingsoldier[5] = loadTexture("data/15-6.png");		
		movingsoldier[6] = loadTexture("data/15-7.png");
		movingsoldier[7] = loadTexture("data/15-8.png");	
		soldier15 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));		
		movingsoldier[0] = loadTexture("data/16-1.png");		
		movingsoldier[1] = loadTexture("data/16-2.png");
		movingsoldier[2] = loadTexture("data/16-3.png");
		movingsoldier[3] = loadTexture("data/16-4.png");
		movingsoldier[4] = loadTexture("data/16-5.png");
		movingsoldier[5] = loadTexture("data/16-6.png");		
		movingsoldier[6] = loadTexture("data/16-7.png");
		movingsoldier[7] = loadTexture("data/16-8.png");	
		soldier16 = new Animation(0.2f,new TextureRegion(movingsoldier[0]),new TextureRegion(movingsoldier[1]),
				new TextureRegion(movingsoldier[2]),new TextureRegion(movingsoldier[3]),
				new TextureRegion(movingsoldier[4]),new TextureRegion(movingsoldier[5]),
				new TextureRegion(movingsoldier[6]),new TextureRegion(movingsoldier[7]));		
		
		door = loadTexture("data/door.png");
		doorRegion = new TextureRegion(door);		
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
		longWidth = loadTexture("data/1B.jpg");
		longWidthRegion = new TextureRegion(longWidth);
		boxes = loadTexture("data/frame.png");
		boxregion = new TextureRegion(boxes);
		soldiers = new Texture[16];
		soldiers[0] = loadTexture("data/1.png");
		soldiers[1] = loadTexture("data/2.png");
		soldiers[2] = loadTexture("data/3.png");
		soldiers[3] = loadTexture("data/4.png");
		soldiers[4] = loadTexture("data/5.png");
		soldiers[5] = loadTexture("data/6.png");
		soldiers[6] = loadTexture("data/7.png");
		soldiers[7] = loadTexture("data/8.png");
		soldiers[8] = loadTexture("data/9.png");
		soldiers[9] = loadTexture("data/10.png");
		soldiers[10] = loadTexture("data/11.png");
		soldiers[11] = loadTexture("data/12.png");
		soldiers[12] = loadTexture("data/13.png");
		soldiers[13] = loadTexture("data/14.png");
		soldiers[14] = loadTexture("data/15.png");
		soldiers[15] = loadTexture("data/16.png");
		soldier_regions = new TextureRegion[16];
		for(int i=0; i<15; i++) soldier_regions[i] = new TextureRegion(soldiers[i]);
		
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