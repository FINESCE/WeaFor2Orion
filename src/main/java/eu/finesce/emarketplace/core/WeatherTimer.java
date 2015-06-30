/*
 * (C) Copyright 2014 FINESCE-WP4.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package eu.finesce.emarketplace.core;

import java.util.Timer;



/**
 * The Class WeatherTimer.
 */
public class WeatherTimer {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
		String currentTime = null;
		WeaFor2Orion weather2Orion = new WeaFor2Orion("weafor.properties", currentTime);
		Timer timer = new Timer();
		timer.schedule(weather2Orion, 0, 300000); //every 5 min
	}

	/**
	 * Instantiates a new weather timer.
	 */
	private WeatherTimer() {
		super();
	}


	
}
