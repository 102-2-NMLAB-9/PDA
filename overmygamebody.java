package com.PDA.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;
import java.util.ArrayList;


public class GameBody {
	Rectangle[] characters;
	int[] status;
	SpriteBatch batcher;
	ArrayList<pair> track = new ArrayList<pair>();
	boolean[] merged;
	
	public GameBody(SpriteBatch batch) {
		characters = new Rectangle[16];
		status = new int[16];
		batcher = batch;
		merged = new boolean[16];
		
		int edge = 700;
		Random rnd = new Random();
		status[rnd.nextInt(16)] = 1;
		
		characters[0] = new Rectangle(70, edge-70, 140, 140);
		characters[1] = new Rectangle(215, edge-70, 140, 140);
		characters[2] = new Rectangle(360, edge-70, 140, 140);
		characters[3] = new Rectangle(505, edge-70, 140, 140);
		characters[4] = new Rectangle(70, edge-215, 140, 140);
		characters[5] = new Rectangle(215, edge-215, 140, 140);
		characters[6] = new Rectangle(360, edge-215, 140, 140);
		characters[7] = new Rectangle(505, edge-215, 140, 140);
		characters[8] = new Rectangle(70, edge-360, 140, 140);
		characters[9] = new Rectangle(215, edge-360, 140, 140);
		characters[10] = new Rectangle(360, edge-360, 140, 140);
		characters[11] = new Rectangle(505, edge-360, 140, 140);
		characters[12] = new Rectangle(70, edge-505, 140, 140);
		characters[13] = new Rectangle(215, edge-505, 140, 140);
		characters[14] = new Rectangle(360, edge-505, 140, 140);
		characters[15] = new Rectangle(505, edge-505, 140, 140);
	}
	
	public void update(float accelX, float accelY) {
		boolean moved = false;
		int[] newblock;
		int length =0, nextone = 0;
		
		Random rnd = new Random();
		newblock = new int[16];
		
		if(accelX < -5f) {     //Left
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					int idx = 4*j+i;
					int x = idx, y = -1;
					if(status[idx] != 0) {
						//Move
						for(; idx > 4*j && status[idx-1] == 0; idx--) {
							status[idx-1] = status[idx];
							status[idx] = 0;
							y = idx-1;
							moved = true;
						}
						//Merge
						if( idx > 4*j && status[idx] == status[idx-1] ) {
							if(!merged[idx-1]) {
								status[idx-1]++;
								status[idx] = 0;
								y = idx-1;
								merged[idx-1] = true;
								moved = true;
							}
						}
					}
					if(moved) track.add(new pair(x, y));
				}
			}
		}else if(accelX > 5f) {     //Right
			for(int i=3; i>=0; i--) {
				for(int j=0; j<4; j++) {
					int idx = 4*j+i;
					int x = idx, y = -1;
					if(status[idx] != 0) {
						//Move
						for(; idx < 4*j+3 && status[idx+1] == 0; idx++) {
							status[idx+1] = status[idx];
							status[idx] = 0;
							y = idx-1;
							moved = true;
						}
						//Merge
						if(idx < 4*j+3 && status[idx] == status[idx+1]) {
							if(!merged[idx+1]) {
								status[idx+1]++;
								status[idx] = 0;
								y = idx-1;
								merged[idx+1] = true;
								moved = true;
							}
						}
					}
					if(moved) track.add(new pair(x, y));
				}
			}
		}else if(accelY > 5f) {      //Down
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					int idx = 4*i+j;
					int x = idx, y = -1;
					if(status[idx] != 0) {
						//Move
						for(int k=i-1; k>=0; k--) {
							idx -= 4;
							if(status[idx] == 0) {
								status[idx] = status[idx+4];
								status[idx+4] = 0;
								moved = true;
								y = idx-1;
							}else break;
						}
						//Merge
						if(idx >= 0 && status[idx] == status[idx+4]) {
							if(!merged[idx]) {
								status[idx]++;
								status[idx+4] = 0;
								y = idx-1;
								merged[idx] = true;
								moved = true;
							}
						}
					}
					if(moved) track.add(new pair(x, y));
				}
			}
		}else if(accelY < -5f) {      //Up
			for(int i=3; i>=0; i--) {
				for(int j=0; j<4; j++) {
					int idx = 4*i+j;
					int x = idx, y = -1;
					if(status[idx] != 0) {
						//Move
						for(int k=i+1; k<4; k++) {
							idx += 4;
							if(status[idx] == 0) {
								status[idx] = status[idx-4];
								status[idx-4] = 0;
								moved = true;
								y = idx-1;
							}else break;
						}
						//Merge
						if(i < 16 && status[idx] == status[idx-4]) {
							if(!merged[idx]) {
								status[idx]++;
								status[idx-4] = 0;
								y = idx-1;
								merged[idx] = true;
								moved = true;
							}
						}
					}
					if(moved) track.add(new pair(x, y));
				}
			}
		}
		// Create A New Block
		if( moved ) {
			for(int i=0; i<16; ++i) {
				if(status[i] == 0) {
					newblock[length++] = i;
				}
			}
			if(length != 0) {
				nextone = rnd.nextInt(length);
				status[newblock[nextone]] = 1;
			}else {
				;
			}
		}
		return ;
	}
	
	public void draw() {
		int[] arr = {70, 215, 360, 505};
		int[] movex = new int[16];
		int[] movey = new int[16];
		boolean[] to_move = new boolean [16];
		
		for(int i=0; i<track.size(); i++) {
			int from = track.get(i).a;
			int to = track.get(i).b;
			int x, y, a, b;
			to_move[from] = true;
			x = arr[ from/4];
			y = arr[ from%4];
			a = arr[ to/4];
			b = arr[ to%4];
			movex[from] = (a-x)/4;
			movey[from] = (b-y)/4;
		}
		
		batcher.begin();
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				int index = 4*i+j;
				if( to_move[index] ) {
					batcher.draw(Assets.soldier_regions[ status[index]-1 ], , , 140, 140);
				}
				if( status[index] != 0) {
					batcher.draw(Assets.soldier_regions[status[index]-1], arr[j], arr[i], 140, 140);
				}
			}
		}
		batcher.end();
		
		track.clear();
		for(int i=0; i<16; i++) merged[i] = false;
	}
	
	public void render(float accelX, float accelY) {
		update(accelX, accelY);
		draw();
	}
	
	public int size() {
		int number = 0;
		for(int i=0; i<16; i++)
			if(status[i] != 0) number++;
		return number;
	}
	
	public int locate(int x, int y) {
		for(int i=0; i<16; i++) {
			if(characters[i].contains((float)x, (float)y)) {
				return i;
			}
		}
		return -1;
	}
}
