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
package eu.finesce.emarketplace.context;

import java.math.BigDecimal;

import eu.finesce.emarketplace.domain.WeatherForecast;
import eu.fiware.ngsi.official.ContextAttribute;
import eu.fiware.ngsi.official.ContextAttributeList;
import eu.fiware.ngsi.official.ContextElement;
import eu.fiware.ngsi.official.EntityId;

/**
 * The Class WeatherContextElement.
 * 
 * 
 */
public class WeatherContextElement extends ContextElement {

	/** The Constant WEATHER. */


	private static final String WEATHER = "Weather";
	
	/** The Constant CURRENT_TEMPERATURE. */
	private static final String CURRENT_TEMPERATURE = "currentTemperature";
	
	/** The Constant CURRENT_WEATHER_CONDITION. */
	private static final String CURRENT_WEATHER_CONDITION = "currentWeatherCondition";
	
	/** The Constant CURRENT_TIME. */
	private static final String CURRENT_TIME = "currentTime";
	
	/** The Constant CURRENT_CLOUD_COVER. */
	private static final String CURRENT_CLOUD_COVER = "currentCloudCover";
	
	/** The Constant CURRENT_WIND_SPEED. */
	private static final String CURRENT_WIND_SPEED = "currentWindSpeed";
	
	/** The Constant DAILY_SUNRISE_TIME. */
	private static final String DAILY_SUNRISE_TIME = "dailySunriseTime";
	
	/** The Constant DAILY_SUNSET_TIME. */
	private static final String DAILY_SUNSET_TIME = "dailySunsetTime";
	
	/** The Constant TEMPERATURE_MIN. */
	private static final String TEMPERATURE_MIN = "temperatureMin";
	
	/** The Constant TEMPERATURE_MAX. */
	private static final String TEMPERATURE_MAX = "temperatureMax";

	/** The Constant AFTER_1H_TIME. */
	private static final String AFTER_1H_TIME = "after1hTime";
	
	/** The Constant AFTER_1H_TEMPERATURE. */
	private static final String AFTER_1H_TEMPERATURE = "after1hTemperature";
	
	/** The Constant AFTER_1H_CLOUD_COVER. */
	private static final String AFTER_1H_CLOUD_COVER = "after1hCloudCover";
	
	/** The Constant AFTER_1H_WIND_SPEED. */
	private static final String AFTER_1H_WIND_SPEED = "after1hWindSpeed";
	
	/** The Constant AFTER_1H_PRECIP_INTENSITY. */
	private static final String AFTER_1H_PRECIP_INTENSITY = "after1hPrecipIntensity";
	
	/** The Constant AFTER_1H_PRECIP_PROBABILITY. */
	private static final String AFTER_1H_PRECIP_PROBABILITY = "after1hPrecipProbability";
	
	
	/** The Constant AFTER_2H_TIME. */
	private static final String AFTER_2H_TIME = "after2hTime";
	
	/** The Constant AFTER_2H_TEMPERATURE. */
	private static final String AFTER_2H_TEMPERATURE = "after2hTemperature";
	
	/** The Constant AFTER_2H_CLOUD_COVER. */
	private static final String AFTER_2H_CLOUD_COVER = "after2hCloudCover";

	/** The Constant AFTER_2H_WIND_SPEED. */
	private static final String AFTER_2H_WIND_SPEED = "after2hWindSpeed";
	
	/** The Constant AFTER_2H_PRECIP_INTENSITY. */
	private static final String AFTER_2H_PRECIP_INTENSITY = "after2hPrecipIntensity";
	
	/** The Constant AFTER_2H_PRECIP_PROBABILITY. */
	private static final String AFTER_2H_PRECIP_PROBABILITY = "after2hPrecipProbability";
	

	/** The Constant AFTER_3H_TIME. */
	private static final String AFTER_3H_TIME = "after3hTime";
	
	/** The Constant AFTER_3H_TEMPERATURE. */
	private static final String AFTER_3H_TEMPERATURE = "after3hTemperature";
	
	/** The Constant AFTER_3H_CLOUD_COVER. */
	private static final String AFTER_3H_CLOUD_COVER = "after3hCloudCover";
	
	/** The Constant AFTER_3H_WIND_SPEED. */
	private static final String AFTER_3H_WIND_SPEED = "after3hWindSpeed";
	
	/** The Constant AFTER_3H_PRECIP_INTENSITY. */
	private static final String AFTER_3H_PRECIP_INTENSITY = "after3hPrecipIntensity";
	
	/** The Constant AFTER_3H_PRECIP_PROBABILITY. */
	private static final String AFTER_3H_PRECIP_PROBABILITY = "after3hPrecipProbability";

	/** The Constant AFTER_4H_TIME. */
	private static final String AFTER_4H_TIME = "after4hTime";
	
	/** The Constant AFTER_4H_TEMPERATURE. */
	private static final String AFTER_4H_TEMPERATURE = "after4hTemperature";
	
	/** The Constant AFTER_4H_CLOUD_COVER. */
	private static final String AFTER_4H_CLOUD_COVER = "after4hCloudCover";

	/** The Constant AFTER_4H_WIND_SPEED. */
	private static final String AFTER_4H_WIND_SPEED = "after4hWindSpeed";
		
	/** The Constant AFTER_4H_PRECIP_INTENSITY. */
	private static final String AFTER_4H_PRECIP_INTENSITY = "after4hPrecipIntensity";
		
	/** The Constant AFTER_4H_PRECIP_PROBABILITY. */
	private static final String AFTER_4H_PRECIP_PROBABILITY = "after4hPrecipProbability";

	/** The Constant AFTER_5H_TIME. */
	private static final String AFTER_5H_TIME = "after5hTime";
	
	/** The Constant AFTER_5H_TEMPERATURE. */
	private static final String AFTER_5H_TEMPERATURE = "after5hTemperature";
	
	/** The Constant AFTER_5H_CLOUD_COVER. */
	private static final String AFTER_5H_CLOUD_COVER = "after5hCloudCover";

	/** The Constant AFTER_5H_WIND_SPEED. */
	private static final String AFTER_5H_WIND_SPEED = "after5hWindSpeed";
		
	/** The Constant AFTER_5H_PRECIP_INTENSITY. */
	private static final String AFTER_5H_PRECIP_INTENSITY = "after5hPrecipIntensity";
		
	/** The Constant AFTER_5H_PRECIP_PROBABILITY. */
	private static final String AFTER_5H_PRECIP_PROBABILITY = "after5hPrecipProbability";
	
	/** The Constant AFTER_6H_TIME. */
	private static final String AFTER_6H_TIME = "after6hTime";
	
	/** The Constant AFTER_6H_TEMPERATURE. */
	private static final String AFTER_6H_TEMPERATURE = "after6hTemperature";
	
	/** The Constant AFTER_6H_CLOUD_COVER. */
	private static final String AFTER_6H_CLOUD_COVER = "after6hCloudCover";
	
	/** The Constant AFTER_6H_WIND_SPEED. */
	private static final String AFTER_6H_WIND_SPEED = "after6hWindSpeed";
	
	/** The Constant AFTER_6H_PRECIP_INTENSITY. */
	private static final String AFTER_6H_PRECIP_INTENSITY = "after6hPrecipIntensity";
	
	/** The Constant AFTER_6H_PRECIP_PROBABILITY. */
	private static final String AFTER_6H_PRECIP_PROBABILITY = "after6hPrecipProbability";

	/** The Constant AFTER_7H_TIME. */
	private static final String AFTER_7H_TIME = "after7hTime";
	
	/** The Constant AFTER_7H_TEMPERATURE. */
	private static final String AFTER_7H_TEMPERATURE = "after7hTemperature";
	
	/** The Constant AFTER_7H_CLOUD_COVER. */
	private static final String AFTER_7H_CLOUD_COVER = "after7hCloudCover";

	/** The Constant AFTER_7H_WIND_SPEED. */
	private static final String AFTER_7H_WIND_SPEED = "after7hWindSpeed";
		
	/** The Constant AFTER_7H_PRECIP_INTENSITY. */
	private static final String AFTER_7H_PRECIP_INTENSITY = "after7hPrecipIntensity";
		
	/** The Constant AFTER_7H_PRECIP_PROBABILITY. */
	private static final String AFTER_7H_PRECIP_PROBABILITY = "after7hPrecipProbability";

	/** The Constant AFTER_8H_TIME. */
	private static final String AFTER_8H_TIME = "after8hTime";
	
	/** The Constant AFTER_8H_TEMPERATURE. */
	private static final String AFTER_8H_TEMPERATURE = "after8hTemperature";
	
	/** The Constant AFTER_8H_CLOUD_COVER. */
	private static final String AFTER_8H_CLOUD_COVER = "after8hCloudCover";

	/** The Constant AFTER_8H_WIND_SPEED. */
	private static final String AFTER_8H_WIND_SPEED = "after8hWindSpeed";
		
	/** The Constant AFTER_8H_PRECIP_INTENSITY. */
	private static final String AFTER_8H_PRECIP_INTENSITY = "after8hPrecipIntensity";
		
	/** The Constant AFTER_8H_PRECIP_PROBABILITY. */
	private static final String AFTER_8H_PRECIP_PROBABILITY = "after8hPrecipProbability";
	
	/** The Constant AFTER_9H_TIME. */
	private static final String AFTER_9H_TIME = "after9hTime";
	
	/** The Constant AFTER_9H_TEMPERATURE. */
	private static final String AFTER_9H_TEMPERATURE = "after9hTemperature";
	
	/** The Constant AFTER_9H_CLOUD_COVER. */
	private static final String AFTER_9H_CLOUD_COVER = "after9hCloudCover";

	/** The Constant AFTER_9H_WIND_SPEED. */
	private static final String AFTER_9H_WIND_SPEED = "after9hWindSpeed";
		
	/** The Constant AFTER_9H_PRECIP_INTENSITY. */
	private static final String AFTER_9H_PRECIP_INTENSITY = "after9hPrecipIntensity";
		
	/** The Constant AFTER_9H_PRECIP_PROBABILITY. */
	private static final String AFTER_9H_PRECIP_PROBABILITY = "after9hPrecipProbability";
	
	/** The Constant AFTER_10H_TIME. */
	private static final String AFTER_10H_TIME = "after10hTime";
	
	/** The Constant AFTER_10H_TEMPERATURE. */
	private static final String AFTER_10H_TEMPERATURE = "after10hTemperature";
	
	/** The Constant AFTER_10H_CLOUD_COVER. */
	private static final String AFTER_10H_CLOUD_COVER = "after10hCloudCover";

	/** The Constant AFTER_10H_WIND_SPEED. */
	private static final String AFTER_10H_WIND_SPEED = "after10hWindSpeed";
		
	/** The Constant AFTER_10H_PRECIP_INTENSITY. */
	private static final String AFTER_10H_PRECIP_INTENSITY = "after10hPrecipIntensity";
		
	/** The Constant AFTER_10H_PRECIP_PROBABILITY. */
	private static final String AFTER_10H_PRECIP_PROBABILITY = "after10hPrecipProbability";

	/** The Constant AFTER_11H_TIME. */
	private static final String AFTER_11H_TIME = "after11hTime";
	
	/** The Constant AFTER_11H_TEMPERATURE. */
	private static final String AFTER_11H_TEMPERATURE = "after11hTemperature";
	
	/** The Constant AFTER_11H_CLOUD_COVER. */
	private static final String AFTER_11H_CLOUD_COVER = "after11hCloudCover";

	/** The Constant AFTER_11H_WIND_SPEED. */
	private static final String AFTER_11H_WIND_SPEED = "after11hWindSpeed";
		
	/** The Constant AFTER_11H_PRECIP_INTENSITY. */
	private static final String AFTER_11H_PRECIP_INTENSITY = "after11hPrecipIntensity";
		
	/** The Constant AFTER_11H_PRECIP_PROBABILITY. */
	private static final String AFTER_11H_PRECIP_PROBABILITY = "after11hPrecipProbability";
	
	/** The Constant AFTER_12H_TIME. */
	private static final String AFTER_12H_TIME = "after12hTime";
	
	/** The Constant AFTER_12H_TEMPERATURE. */
	private static final String AFTER_12H_TEMPERATURE = "after12hTemperature";
	
	/** The Constant AFTER_12H_CLOUD_COVER. */
	private static final String AFTER_12H_CLOUD_COVER = "after12hCloudCover";
	
	/** The Constant AFTER_12H_WIND_SPEED. */
	private static final String AFTER_12H_WIND_SPEED = "after12hWindSpeed";
	
	/** The Constant AFTER_12H_PRECIP_INTENSITY. */
	private static final String AFTER_12H_PRECIP_INTENSITY = "after12hPrecipIntensity";
	
	/** The Constant AFTER_12H_PRECIP_PROBABILITY. */
	private static final String AFTER_12H_PRECIP_PROBABILITY = "after12hPrecipProbability";

	/** The Constant AFTER_13H_TIME. */
	private static final String AFTER_13H_TIME = "after13hTime";
	
	/** The Constant AFTER_13H_TEMPERATURE. */
	private static final String AFTER_13H_TEMPERATURE = "after13hTemperature";
	
	/** The Constant AFTER_13H_CLOUD_COVER. */
	private static final String AFTER_13H_CLOUD_COVER = "after13hCloudCover";

	/** The Constant AFTER_13H_WIND_SPEED. */
	private static final String AFTER_13H_WIND_SPEED = "after13hWindSpeed";
		
	/** The Constant AFTER_13H_PRECIP_INTENSITY. */
	private static final String AFTER_13H_PRECIP_INTENSITY = "after13hPrecipIntensity";
		
	/** The Constant AFTER_13H_PRECIP_PROBABILITY. */
	private static final String AFTER_13H_PRECIP_PROBABILITY = "after13hPrecipProbability";

	/** The Constant AFTER_14H_TIME. */
	private static final String AFTER_14H_TIME = "after14hTime";
	
	/** The Constant AFTER_14H_TEMPERATURE. */
	private static final String AFTER_14H_TEMPERATURE = "after14hTemperature";
	
	/** The Constant AFTER_14H_CLOUD_COVER. */
	private static final String AFTER_14H_CLOUD_COVER = "after14hCloudCover";

	/** The Constant AFTER_14H_WIND_SPEED. */
	private static final String AFTER_14H_WIND_SPEED = "after14hWindSpeed";
		
	/** The Constant AFTER_14H_PRECIP_INTENSITY. */
	private static final String AFTER_14H_PRECIP_INTENSITY = "after14hPrecipIntensity";
		
	/** The Constant AFTER_14H_PRECIP_PROBABILITY. */
	private static final String AFTER_14H_PRECIP_PROBABILITY = "after14hPrecipProbability";

	/** The Constant AFTER_15H_TIME. */
	private static final String AFTER_15H_TIME = "after15hTime";
	
	/** The Constant AFTER_15H_TEMPERATURE. */
	private static final String AFTER_15H_TEMPERATURE = "after15hTemperature";
	
	/** The Constant AFTER_15H_CLOUD_COVER. */
	private static final String AFTER_15H_CLOUD_COVER = "after15hCloudCover";

	/** The Constant AFTER_15H_WIND_SPEED. */
	private static final String AFTER_15H_WIND_SPEED = "after15hWindSpeed";
		
	/** The Constant AFTER_15H_PRECIP_INTENSITY. */
	private static final String AFTER_15H_PRECIP_INTENSITY = "after15hPrecipIntensity";
		
	/** The Constant AFTER_15H_PRECIP_PROBABILITY. */
	private static final String AFTER_15H_PRECIP_PROBABILITY = "after15hPrecipProbability";

	/** The Constant AFTER_16H_TIME. */
	private static final String AFTER_16H_TIME = "after16hTime";
	
	/** The Constant AFTER_16H_TEMPERATURE. */
	private static final String AFTER_16H_TEMPERATURE = "after16hTemperature";
	
	/** The Constant AFTER_16H_CLOUD_COVER. */
	private static final String AFTER_16H_CLOUD_COVER = "after16hCloudCover";

	/** The Constant AFTER_16H_WIND_SPEED. */
	private static final String AFTER_16H_WIND_SPEED = "after16hWindSpeed";
		
	/** The Constant AFTER_16H_PRECIP_INTENSITY. */
	private static final String AFTER_16H_PRECIP_INTENSITY = "after16hPrecipIntensity";
		
	/** The Constant AFTER_16H_PRECIP_PROBABILITY. */
	private static final String AFTER_16H_PRECIP_PROBABILITY = "after16hPrecipProbability";

	/** The Constant AFTER_17H_TIME. */
	private static final String AFTER_17H_TIME = "after17hTime";
	
	/** The Constant AFTER_17H_TEMPERATURE. */
	private static final String AFTER_17H_TEMPERATURE = "after17hTemperature";
	
	/** The Constant AFTER_17H_CLOUD_COVER. */
	private static final String AFTER_17H_CLOUD_COVER = "after17hCloudCover";

	/** The Constant AFTER_17H_WIND_SPEED. */
	private static final String AFTER_17H_WIND_SPEED = "after17hWindSpeed";
		
	/** The Constant AFTER_17H_PRECIP_INTENSITY. */
	private static final String AFTER_17H_PRECIP_INTENSITY = "after17hPrecipIntensity";
		
	/** The Constant AFTER_17H_PRECIP_PROBABILITY. */
	private static final String AFTER_17H_PRECIP_PROBABILITY = "after17hPrecipProbability";

	/** The Constant AFTER_18H_TIME. */
	private static final String AFTER_18H_TIME = "after18hTime";
	
	/** The Constant AFTER_18H_TEMPERATURE. */
	private static final String AFTER_18H_TEMPERATURE = "after18hTemperature";
	
	/** The Constant AFTER_18H_CLOUD_COVER. */
	private static final String AFTER_18H_CLOUD_COVER = "after18hCloudCover";

	/** The Constant AFTER_18H_WIND_SPEED. */
	private static final String AFTER_18H_WIND_SPEED = "after18hWindSpeed";
		
	/** The Constant AFTER_18H_PRECIP_INTENSITY. */
	private static final String AFTER_18H_PRECIP_INTENSITY = "after18hPrecipIntensity";
		
	/** The Constant AFTER_18H_PRECIP_PROBABILITY. */
	private static final String AFTER_18H_PRECIP_PROBABILITY = "after18hPrecipProbability";

	/** The Constant AFTER_19H_TIME. */
	private static final String AFTER_19H_TIME = "after19hTime";
	
	/** The Constant AFTER_19H_TEMPERATURE. */
	private static final String AFTER_19H_TEMPERATURE = "after19hTemperature";
	
	/** The Constant AFTER_19H_CLOUD_COVER. */
	private static final String AFTER_19H_CLOUD_COVER = "after19hCloudCover";

	/** The Constant AFTER_19H_WIND_SPEED. */
	private static final String AFTER_19H_WIND_SPEED = "after19hWindSpeed";
		
	/** The Constant AFTER_19H_PRECIP_INTENSITY. */
	private static final String AFTER_19H_PRECIP_INTENSITY = "after19hPrecipIntensity";
		
	/** The Constant AFTER_19H_PRECIP_PROBABILITY. */
	private static final String AFTER_19H_PRECIP_PROBABILITY = "after19hPrecipProbability";

	/** The Constant AFTER_20H_TIME. */
	private static final String AFTER_20H_TIME = "after20hTime";
	
	/** The Constant AFTER_20H_TEMPERATURE. */
	private static final String AFTER_20H_TEMPERATURE = "after20hTemperature";
	
	/** The Constant AFTER_20H_CLOUD_COVER. */
	private static final String AFTER_20H_CLOUD_COVER = "after20hCloudCover";

	/** The Constant AFTER_20H_WIND_SPEED. */
	private static final String AFTER_20H_WIND_SPEED = "after20hWindSpeed";
		
	/** The Constant AFTER_20H_PRECIP_INTENSITY. */
	private static final String AFTER_20H_PRECIP_INTENSITY = "after20hPrecipIntensity";
		
	/** The Constant AFTER_20H_PRECIP_PROBABILITY. */
	private static final String AFTER_20H_PRECIP_PROBABILITY = "after20hPrecipProbability";
	
	/** The Constant AFTER_21H_TIME. */
	private static final String AFTER_21H_TIME = "after21hTime";

	/** The Constant AFTER_21H_TEMPERATURE. */
	private static final String AFTER_21H_TEMPERATURE = "after21hTemperature";
	
	/** The Constant AFTER_21H_CLOUD_COVER. */
	private static final String AFTER_21H_CLOUD_COVER = "after21hCloudCover";

	/** The Constant AFTER_21H_WIND_SPEED. */
	private static final String AFTER_21H_WIND_SPEED = "after21hWindSpeed";
		
	/** The Constant AFTER_21H_PRECIP_INTENSITY. */
	private static final String AFTER_21H_PRECIP_INTENSITY = "after21hPrecipIntensity";
		
	/** The Constant AFTER_21H_PRECIP_PROBABILITY. */
	private static final String AFTER_21H_PRECIP_PROBABILITY = "after21hPrecipProbability";

	/** The Constant AFTER_22H_TIME. */
	private static final String AFTER_22H_TIME = "after22hTime";
	
	/** The Constant AFTER_22H_TEMPERATURE. */
	private static final String AFTER_22H_TEMPERATURE = "after22hTemperature";
	
	/** The Constant AFTER_22H_CLOUD_COVER. */
	private static final String AFTER_22H_CLOUD_COVER = "after22hCloudCover";

	/** The Constant AFTER_22H_WIND_SPEED. */
	private static final String AFTER_22H_WIND_SPEED = "after22hWindSpeed";
		
	/** The Constant AFTER_22H_PRECIP_INTENSITY. */
	private static final String AFTER_22H_PRECIP_INTENSITY = "after22hPrecipIntensity";
		
	/** The Constant AFTER_22H_PRECIP_PROBABILITY. */
	private static final String AFTER_22H_PRECIP_PROBABILITY = "after22hPrecipProbability";

	/** The Constant AFTER_23H_TIME. */
	private static final String AFTER_23H_TIME = "after23hTime";
	
	/** The Constant AFTER_23H_TEMPERATURE. */
	private static final String AFTER_23H_TEMPERATURE = "after23hTemperature";
	
	/** The Constant AFTER_23H_CLOUD_COVER. */
	private static final String AFTER_23H_CLOUD_COVER = "after23hCloudCover";

	/** The Constant AFTER_23H_WIND_SPEED. */
	private static final String AFTER_23H_WIND_SPEED = "after23hWindSpeed";
		
	/** The Constant AFTER_23H_PRECIP_INTENSITY. */
	private static final String AFTER_23H_PRECIP_INTENSITY = "after23hPrecipIntensity";
		
	/** The Constant AFTER_23H_PRECIP_PROBABILITY. */
	private static final String AFTER_23H_PRECIP_PROBABILITY = "after23hPrecipProbability";

	/** The Constant AFTER_24H_TIME. */
	private static final String AFTER_24H_TIME = "after24hTime";
	
	/** The Constant AFTER_24H_TEMPERATURE. */
	private static final String AFTER_24H_TEMPERATURE = "after24hTemperature";
	
	/** The Constant AFTER_24H_CLOUD_COVER. */
	private static final String AFTER_24H_CLOUD_COVER = "after24hCloudCover";
	
	/** The Constant AFTER_24H_WIND_SPEED. */
	private static final String AFTER_24H_WIND_SPEED = "after24hWindSpeed";
	
	/** The Constant AFTER_24H_PRECIP_INTENSITY. */
	private static final String AFTER_24H_PRECIP_INTENSITY = "after24hPrecipIntensity";
	
	/** The Constant AFTER_24H_PRECIP_PROBABILITY. */
	private static final String AFTER_24H_PRECIP_PROBABILITY = "after24hPrecipProbability";



	/**
	 * Instantiates a new weather context element.
	 *
	 * @param weather the weather
	 */
	public WeatherContextElement(WeatherForecast weather) {
		this.contextAttributeList = new ContextAttributeList();

		EntityId id = new EntityId();
		id.setId(weather.getWeatherID());
		id.setType(WEATHER);
		id.setIsPattern(false);
		this.setEntityId(id);
		ContextAttribute attribute = new ContextAttribute();

		// attributes
		attribute = new ContextAttribute();
		attribute.setName(CURRENT_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getCurrentTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(CURRENT_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getCurrentTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(CURRENT_WEATHER_CONDITION);
		attribute.setType("text");
		attribute.setContextValue(weather.getCurrentWeatherCondition());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(CURRENT_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getCurrentCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(CURRENT_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getCurrentWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_1H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter1hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_1H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter1hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_1H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter1hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_1H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter1hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_1H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter1hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_1H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter1hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_3H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter3hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_3H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter3hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_3H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter3hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_3H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter3hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_3H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter3hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_3H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter3hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_6H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter6hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_6H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter6hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_6H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter6hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_6H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter6hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_6H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter6hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_6H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter6hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_12H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter12hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_12H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter12hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_12H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(RoundTo2Decimals(weather.getAfter12hCloudCover()));
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_12H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter12hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_12H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter12hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_12H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter12hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_24H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter24hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_24H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter24hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_24H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter24hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_24H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter24hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_24H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter24hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_24H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter24hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(DAILY_SUNSET_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getDailySunsetTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(DAILY_SUNRISE_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getDailySunriseTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(TEMPERATURE_MIN);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getTemperatureMin());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(TEMPERATURE_MAX);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getTemperatureMax());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		//new properties for predictions
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_2H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter2hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_2H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter2hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_2H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter2hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_2H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter2hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_2H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter2hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_2H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter2hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_4H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter4hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_4H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter4hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_4H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter4hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_4H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter4hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_4H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter4hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_4H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter4hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_5H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter5hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_5H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter5hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_5H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter5hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_5H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter5hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_5H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter5hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_5H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter5hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_7H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter7hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_7H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter7hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_7H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter7hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_7H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter7hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_7H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter7hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_7H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter7hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_8H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter8hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_8H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter8hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_8H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter8hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_8H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter8hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_8H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter8hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_8H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter8hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_9H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter9hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_9H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter9hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_9H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter9hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_9H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter9hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_9H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter9hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_9H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter9hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_10H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter10hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_10H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter10hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_10H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter10hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_10H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter10hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_10H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter10hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_10H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter10hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_11H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter11hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_11H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter11hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_11H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter11hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_11H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter11hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_11H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter11hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_11H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter11hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_13H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter13hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_13H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter13hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_13H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter13hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_13H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter13hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_13H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter13hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_13H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter13hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_14H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter14hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_14H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter14hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_14H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter14hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_14H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter14hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_14H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter14hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_14H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter14hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_15H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter15hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_15H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter15hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_15H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter15hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_15H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter15hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_15H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter15hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_15H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter15hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_16H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter16hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_16H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter16hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_16H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter16hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_16H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter16hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_16H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter16hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_16H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter16hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_17H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter17hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_17H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter17hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_17H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter17hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_17H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter17hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_17H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter17hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_17H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter17hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_18H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter18hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_18H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter18hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_18H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter18hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_18H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter18hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_18H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter18hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_18H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter18hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_19H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter19hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_19H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter19hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_19H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter19hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_19H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter19hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_19H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter19hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_19H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter19hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_20H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter20hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_20H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter20hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_20H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter20hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_20H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter20hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_20H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter20hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_20H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter20hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_21H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter21hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_21H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter21hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_21H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter21hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_21H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter21hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_21H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter21hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_21H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter21hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_22H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter22hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_22H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter22hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_22H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter22hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_22H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter22hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_22H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter22hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_22H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter22hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
		attribute = new ContextAttribute();
		attribute.setName(AFTER_23H_TIME);
		attribute.setType("sec");
		attribute.setContextValue(weather.getAfter23hTime());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_23H_TEMPERATURE);
		attribute.setType("centigrade");
		attribute.setContextValue(weather.getAfter23hTemperature());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_23H_CLOUD_COVER);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter23hCloudCover());
		this.getContextAttributeList().getContextAttributes().add(attribute);

		attribute = new ContextAttribute();
		attribute.setName(AFTER_23H_WIND_SPEED);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter23hWindSpeed());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_23H_PRECIP_INTENSITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter23hPrecipIntensity());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		
		attribute = new ContextAttribute();
		attribute.setName(AFTER_23H_PRECIP_PROBABILITY);
		attribute.setType("double");
		attribute.setContextValue(weather.getAfter23hPrecipProbability());
		this.getContextAttributeList().getContextAttributes().add(attribute);
		//
	}
	
	/**
	 * Round to2 decimals.
	 *
	 * @param val the val
	 * @return the double
	 */
	double RoundTo2Decimals(double val) {
		BigDecimal bdTest = new BigDecimal(val);

		bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);

		return bdTest.doubleValue();
	}

}
