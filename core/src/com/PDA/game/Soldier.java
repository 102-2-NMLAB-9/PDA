/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.PDA.game;

public class Soldier extends DynamicGameObject {
	public static final float SOLDIER_WIDTH = 1;
	public static final float SOLDIER_HEIGHT = 0.6f;
	public static final float SOLDIER_VELOCITY = 30f;

	float stateTime = 0;

	public Soldier (float x, float y) {
		super(x, y, SOLDIER_WIDTH, SOLDIER_HEIGHT);
		velocity.set(SOLDIER_VELOCITY, 0);
	}

	public void update (float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
		bounds.x = position.x - SOLDIER_WIDTH / 2;
		bounds.y = position.y - SOLDIER_HEIGHT / 2;
		if (position.x > 960 - SOLDIER_WIDTH / 2) 
		{
			position.x = 960 - SOLDIER_WIDTH / 2;
			velocity.x = 0;
		}
		/*if(velocity.x != 0)
		{stateTime += delta;}*/
		stateTime += delta;
	}
}
