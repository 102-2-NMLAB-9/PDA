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

	float stateTime = 0;
	float blood;
	float attack;

	public Soldier (float x, float y,float v,float b,float a) {
		super(x, y, 222, 222);
		velocity.set(v, 0);
		blood=b;
		attack=a;
	}

	public void update (float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
		bounds.x = position.x;
		bounds.y = position.y;
		if (position.x > 960) 
		{
			position.x = 960;
			velocity.x = 0;
		}
		/*if(velocity.x != 0)
		{stateTime += delta;}*/
		stateTime += delta;
	}
}