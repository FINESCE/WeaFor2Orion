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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimerTask;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eu.finesce.emarketplace.context.WeatherContextElement;
import eu.finesce.emarketplace.domain.WeatherForecast;
import eu.fiware.ngsi.official.ContextElement;
import eu.fiware.ngsi.official.ContextElementList;
import eu.fiware.ngsi.official.UpdateActionType;
import eu.fiware.ngsi.official.UpdateContextRequest;

/**
 * The Class WeaFor2Orion.
 *
 * @author LL
 */
public class WeaFor2Orion extends TimerTask implements WeaFor2OrionInterface{
	
	/** The Constant logger. */
	private static final Log logger = LogFactory.getLog(WeaFor2Orion.class);
	
	/** The prop. */
	Properties prop;
	
	/** The weather service url. */
	private String weatherServiceUrl = "";
	
	/** The service key. */
	private String serviceKey;
	
	/** The input url param. */
	private String inputUrlParam;
	
	/** The units. */
	private String units;
	
	/** The exclude. */
	private String exclude;
	
	/** The entity id. */
	private String entityId;
	
	/** The current weather condition. */
	private String currentWeatherCondition;
	
	/** The current temperature. */
	private String currentTemperature;
	
	/** The current cloud cover. */
	private String currentCloudCover;
	
	/** The current wind speed. */
	private String currentWindSpeed;
	
	/** The current time. */
	private String currentTime;
	
	/** The hourly temperature. */
	private String hourlyTemperature;
	
	/** The hourly cloud cover. */
	private String hourlyCloudCover;
	
	/** The hourly wind speed. */
	private String hourlyWindSpeed;
	
	/** The hourly time. */
	private String hourlyTime;
	
	/** The sunrise time. */
	private String sunriseTime;
	
	/** The sunset time. */
	private String sunsetTime;
	
	/** The hourly forecast data. */
	private String hourlyForecastData;
	
	/** The daily forecast data. */
	private String dailyForecastData;
	
	/** The currently forecast data. */
	private String currentlyForecastData;
	
	/** The hourly detail data. */
	private String hourlyDetailData;
	
	/** The daily detail data. */
	private String dailyDetailData;
	
	/** The temperature min. */
	private String temperatureMin;
	
	/** The temperature max. */
	private String temperatureMax;
	
	/** The precip intensity. */
	private String precipIntensity;
	
	/** The precip probability. */
	private String precipProbability;
	
	/** The forecast data. */
	private JSONObject forecastData = new JSONObject();
	
	/** The register context path. */
	private String REGISTER_CONTEXT_PATH;
	
	/** The orion server url. */
	private String ORION_SERVER_URL;
	
	/** The weather server url. */
	private String weatherServerUrl;
	
	/** The weather path. */
	private String weatherPath;
	
	/** The weather. */
	WeatherForecast weather = null;
	
	/** The mapping file name. */
	private String mappingFileName;
	
	/** The current time costructor. */
	private String currentTimeCostructor;

	/** The temperature map. */
	private Map<String, Double> temperatureMap = new HashMap<String, Double>();
	
	/** The wind speed map. */
	private Map<String, Double> windSpeedMap = new HashMap<String, Double>();
	
	/** The cloud cover map. */
	private Map<String, Double> cloudCoverMap = new HashMap<String, Double>();
	
	/** The time map. */
	private Map<String, Long> timeMap = new HashMap<String, Long>();
	
	/** The precip intensity map. */
	private Map<String, Double> precipIntensityMap = new HashMap<String, Double>();
	
	/** The precip probability map. */
	private Map<String, Double> precipProbabilityMap = new HashMap<String, Double>();


	/**
	 * Instantiates a new weafor2orion.
	 *
	 * @param mappingFileName the mapping file name
	 * @param currentTime the current time
	 */
	public WeaFor2Orion(String mappingFileName, String currentTime) {
		this.mappingFileName = mappingFileName;
		this.currentTimeCostructor = currentTime;

	}
	
	@Override
	public void run() {
		exec(mappingFileName,currentTimeCostructor);
	}
	
	/**
	 * Exec.
	 *
	 * @param mappingFileName the mapping file name
	 * @param currentTime the current time
	 */
	public void exec(String mappingFileName, String currentTime){

		getPropertiesData(mappingFileName);
		
		this.setForecastData(getForecastDataByService(weatherServiceUrl,serviceKey,
				inputUrlParam, currentTime));

		if (this.getForecastData() != null) { 
			this.parseDataFromForecastServiceResponse();

			try {
				//Response sendResponse = this.sendWeatherCtxEvDataToOrion(weather);
				Response sendResponse = this.sendWeatherData(weather);
				logger.info(sendResponse.readEntity(String.class));
			} catch (Exception e) {
				logger.info("Oopssss!!!!!!!No Response by Orion! May be a connection problem! Data will be send next time!!!");
			}
		}else{
			logger.info("Oopssss!!!!!!!No weather data by forecast io! May be a connection problem! Data will be retreieved next time!!!");
		}		

	}

	/**
	 * Method to retrieve properties data from NAME.properties
	 *
	 * @param mappingFileName the mapping file name
	 * @return the properties data
	 */
	public final String getPropertiesData(String mappingFileName) {
		prop = new Properties();

		try {
			//logger.info("Path : " +this.getClass().getResource("/"));
			logger.info("File propertiese: " + mappingFileName);
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream(mappingFileName));
			weatherServiceUrl = prop.getProperty("weafor2oriontimer.weatherServiceUrl");
			serviceKey = prop.getProperty("weafor2oriontimer.serviceKey"); 
			inputUrlParam = prop.getProperty("weafor2oriontimer.inputUrlParam");
			REGISTER_CONTEXT_PATH = prop.getProperty("weafor2oriontimer.registerContexPath");
			ORION_SERVER_URL = prop.getProperty("weafor2oriontimer.orionServerUrl");
			
			weatherServerUrl = prop.getProperty("weafor2oriontimer.weatherServerUrl");
			weatherPath = prop.getProperty("weafor2oriontimer.weatherPath");
			
			units = prop.getProperty("units");
			exclude = prop.getProperty("exclude");
			entityId = prop.getProperty("entityId");			
			currentWeatherCondition = prop.getProperty("weatherCondition");
			currentCloudCover = prop.getProperty("currentCloudCover");
			currentTemperature = prop.getProperty("currentTemperature");
			currentTime = prop.getProperty("currentTime");
			currentWindSpeed = prop.getProperty("currentWindSpeed");
			hourlyCloudCover = prop.getProperty("hourlyCloudCover");
			hourlyTemperature = prop.getProperty("hourlyTemperature");
			hourlyTime = prop.getProperty("hourlyTime");
			hourlyWindSpeed = prop.getProperty("hourlyWindSpeed");
			sunriseTime = prop.getProperty("sunriseTime");
			sunsetTime = prop.getProperty("sunsetTime");
			hourlyForecastData = prop.getProperty("hourlyForecastData");
			dailyForecastData = prop.getProperty("dailyForecastData");
			currentlyForecastData = prop.getProperty("currentlyForecastData");
			hourlyDetailData = prop.getProperty("hourlyDetailData");
			dailyDetailData  = prop.getProperty("dailyDetailData");
			temperatureMin   = prop.getProperty("temperatureMin");
			temperatureMax   = prop.getProperty("temperatureMax");
			precipIntensity  = prop.getProperty("precipIntensity");
			precipProbability = prop.getProperty("precipProbability");
			
		} catch (IOException e) {
			logger.error("Error during get properties data by:"
					+ mappingFileName, e);
		}
		return null;
	}

	/**
	 * Gets the forecast data by service.
	 *
	 * @param weatherServiceUrl the weather service url
	 * @param serviceKey the service key
	 * @param inputUrlParam the input url param
	 * @param currentTime the current time
	 * @return JSONObject
	 */
	public final JSONObject getForecastDataByService(String weatherServiceUrl,String serviceKey,
			String inputUrlParam, String currentTime) {

		String url = urlBuilder(weatherServiceUrl,serviceKey, inputUrlParam, currentTime);
		JSONObject wheatherData = null;
		try {
			wheatherData = getJsonObjectByUrl(url);

		} catch (IOException e) {
			logger.error("Error during retrieve data from a service by url", e);
		} catch (JSONException e) {
			logger.error("JsonException in getForecastDataByService", e);
		}
		return wheatherData;
	}

	/**
	 * Gets the json object by url.
	 *
	 * @param forecastUrl the forecast url
	 * @return the json object by url
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	public  JSONObject getJsonObjectByUrl(String forecastUrl)
			throws IOException, JSONException {

		JSONObject jsonObject = null;
		BufferedReader reader = null;

		URL url = new URL(forecastUrl);
		
		//**
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.eng.it", 3128));
//		Authenticator authenticator = new Authenticator() {
//
//	        public PasswordAuthentication getPasswordAuthentication() {
//	            return (new PasswordAuthentication("lombardl",
//	                    "pwd".toCharArray()));
//	        }
//	    };
//	    Authenticator.setDefault(authenticator);
//		URLConnection yc = url.openConnection(proxy);
		URLConnection yc = url.openConnection();
		reader =  new BufferedReader(new InputStreamReader(yc.getInputStream()));

		jsonObject = new JSONObject(reader.readLine());
		if (reader != null) {
			reader.close();
			reader = null;
		}
		return jsonObject;
	}

	/**
	 * Url builder.
	 *
	 * @param weatherServiceUrl the weather service url
	 * @param serviceKey the service key
	 * @param inputUrlParam the input url param
	 * @param currentTime the current time
	 * @return the string
	 */
	public final String urlBuilder(String weatherServiceUrl,String serviceKey,
			String inputUrlParam, String currentTime) {
		StringBuilder url = new StringBuilder("");
		url.append(weatherServiceUrl);

		if (serviceKey != null){
			url.append(serviceKey);
		}

		if (weatherServiceUrl != null && !weatherServiceUrl.endsWith("/")) {
			url.append("/");
		}
		url.append(inputUrlParam);
		if (currentTime != null){
			url.append("," + currentTime);
		}
		if (units != null || exclude != null) {
			url.append("?");
		}

		if (units != null) {
			url.append("units=" + units);
		}

		if (exclude != null) {
			if (url.toString().endsWith("?")) {
				url.append("exclude=" + exclude);
			} else {
				url.append("&exclude=" + exclude);
			}
		}

		return url.toString();
	}

	/**
	 * Send weather ctx ev data to orion.
	 *
	 * @param weather the weather
	 * @return the response
	 */
	public final Response sendWeatherCtxEvDataToOrion(WeatherForecast weather) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(ORION_SERVER_URL);
		WebTarget resourceWebTarget = webTarget.path(REGISTER_CONTEXT_PATH);

		UpdateContextRequest updContextRequest = new UpdateContextRequest();
		updContextRequest.setUpdateAction(UpdateActionType.APPEND);
		ContextElement element = new WeatherContextElement(weather);
		ContextElementList elementList = new ContextElementList();
		elementList.getContextElements().add(element);
		updContextRequest.setContextElementList(elementList);

		Entity<UpdateContextRequest> sendXml = Entity.xml(updContextRequest);

		Response responseEntity = resourceWebTarget.request(
				MediaType.APPLICATION_XML).post(sendXml);

		return responseEntity;
	}

	/**
	 * Parses the data from forecast service response.
	 */
	public final void parseDataFromForecastServiceResponse() {

		weather = new WeatherForecast();
		JSONObject currentlyDetails;
		JSONObject hourlyDetails;
		JSONObject dailyDetails;

		//Read data of actual weather condition by forecast services
		try {
			currentlyDetails = this.getForecastData().getJSONObject(currentlyForecastData);
			weather.setWeatherID(entityId);
			weather.setCurrentTemperature(RoundTo2Decimals(currentlyDetails.getDouble(currentTemperature)));
			try {
				weather.setCurrentWeatherCondition(currentlyDetails.getString(currentWeatherCondition));
			} catch (Exception e1) {
				weather.setCurrentWeatherCondition("No information");
			}
			weather.setCurrentTime(currentlyDetails.getLong(currentTime));
			weather.setCurrentWindSpeed(RoundTo2Decimals(currentlyDetails.getDouble(currentWindSpeed)));
			
			try {
				weather.setCurrentCloudCover(RoundTo2Decimals(currentlyDetails.getDouble(currentCloudCover)));
			} catch (Exception e) {
				logger.info("CurrentCloudCover not present, set to zero value", e);
				weather.setCurrentCloudCover(new Double(0.00));
			}
		} catch (JSONException e) {
			logger.info("Error during jasonParser of currently block", e);
		}

		//Read data of some attribute of weather forecast for the next 24h (actual weather data +1h,+3h,+6h,+12h,+24h)
		try {
			//get the master data detail block of forecast for the next 24 or 48h (depend if forecast are by date or not)
			hourlyDetails = this.getForecastData().getJSONObject(hourlyForecastData);

			//get the sub data detail block of forecast for the next 48h
			if (hourlyDetails.getJSONArray(hourlyDetailData) != null) {
				JSONArray hourlyJsonArray;
				hourlyJsonArray = hourlyDetails.getJSONArray(hourlyDetailData);
				
				int startHour = 0;
				Date date = null;
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
				
				if (currentTimeCostructor == null){
					Calendar time = new GregorianCalendar(Locale.ITALY);
					startHour = time.get(Calendar.HOUR_OF_DAY);
				}else{
					try {
						date = dateFormat.parse(currentTimeCostructor);
					} catch (ParseException e1) {
						logger.error("Errore nel parsare la data passata al costruttore", e1);
					}
					Calendar time = new GregorianCalendar(Locale.ITALY);
					time.setTime(date);
                    startHour = time.get(Calendar.HOUR_OF_DAY);;
				}

				for (int i = 0; i < hourlyJsonArray.length(); i++) {
					JSONObject childJSONObject = hourlyJsonArray
							.getJSONObject(i);
					try {
						temperatureMap.put("temperature_" + (startHour + i),RoundTo2Decimals(childJSONObject.getDouble(hourlyTemperature)));
					} catch (Exception e) {
						logger.info("temperature_" + (startHour + i) + " not present, set to zero value", e);
						temperatureMap.put("temperature_" + (startHour + i),new Double(0.00));
					}
					try {
						windSpeedMap.put("windSpeed_" + (startHour + i),RoundTo2Decimals(childJSONObject.getDouble(hourlyWindSpeed)));
					} catch (Exception e) {
						logger.info("windSpeed_" + (startHour + i) + " not present, set to zero value", e);
						windSpeedMap.put("windSpeed_" + (startHour + i),new Double(0.00));
					}
					try {
						timeMap.put("time_"+ (startHour + i),childJSONObject.getLong(hourlyTime));
					} catch (Exception e) {
						logger.info("time_" + (startHour + i) + " not present, set to zero value", e);
						timeMap.put("time_"+ (startHour + i), Long.valueOf(0));
					}
				  
				    //this block is not present when are retrieved forecast by Date.
					try {
						cloudCoverMap.put("cloudCover_" + (startHour + i),RoundTo2Decimals(childJSONObject.getDouble(hourlyCloudCover)));
					} catch (Exception e) {
						logger.info("cloudCover_" + (startHour + i) + " not present, set to zero value", e);
						cloudCoverMap.put("cloudCover_" + (startHour + i),new Double(0));
					}
					try {
						precipIntensityMap.put("precipIntensity_" + (startHour + i),RoundTo2Decimals(childJSONObject.getDouble(precipIntensity)));
					} catch (Exception e) {
						logger.info("precipIntensity_" + (startHour + i) + " not present, set to zero value", e);
						precipIntensityMap.put("precipIntensity_" + (startHour + i),new Double(0));
					}
					try {
						precipProbabilityMap.put("precipProbability_" + (startHour + i),RoundTo2Decimals(childJSONObject.getDouble(precipProbability)));
					} catch (Exception e) {
						logger.info("precipProbability_" + (startHour + i) + " not present, set to zero value", e);
						precipProbabilityMap.put("precipProbability_" + (startHour + i),new Double(0));
					}
				    	
				}

				weather.setAfter1hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 1)));
				weather.setAfter2hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 2)));
				weather.setAfter3hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 3)));
				weather.setAfter4hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 4)));
				weather.setAfter5hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 5)));
				weather.setAfter6hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 6)));
				weather.setAfter7hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 7)));
				weather.setAfter8hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 8)));
				weather.setAfter9hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 9)));
				weather.setAfter10hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 10)));
				weather.setAfter11hTemperature(temperatureMap.get("temperature_"+ Integer.toString(startHour + 11)));
				weather.setAfter12hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 12)));
				weather.setAfter13hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 13)));
				weather.setAfter14hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 14)));
				weather.setAfter15hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 15)));
				weather.setAfter16hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 16)));
				weather.setAfter17hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 17)));
				weather.setAfter18hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 18)));
				weather.setAfter19hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 19)));
				weather.setAfter20hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 20)));
				weather.setAfter21hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 21)));
				weather.setAfter22hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 22)));
				weather.setAfter23hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 23)));
				try {
					weather.setAfter24hTemperature(temperatureMap.get("temperature_" + Integer.toString(startHour + 24)));
				} catch (Exception e) {
					logger.info("temperature_24 not present, set to zero value", e);
					weather.setAfter24hTemperature(new Double(0));				
				}

				weather.setAfter1hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 1)));
				weather.setAfter2hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 2)));				
				weather.setAfter3hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 3)));
				weather.setAfter4hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 4)));
				weather.setAfter5hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 5)));
				weather.setAfter6hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 6)));
				weather.setAfter7hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 7)));
				weather.setAfter8hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 8)));
				weather.setAfter9hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 9)));
				weather.setAfter10hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 10)));
				weather.setAfter11hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 11)));
				weather.setAfter12hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 12)));
				weather.setAfter13hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 13)));
				weather.setAfter14hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 14)));
				weather.setAfter15hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 15)));
				weather.setAfter16hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 16)));
				weather.setAfter17hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 17)));
				weather.setAfter18hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 18)));
				weather.setAfter19hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 19)));
				weather.setAfter20hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 20)));
				weather.setAfter21hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 21)));
				weather.setAfter22hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 22)));
				weather.setAfter23hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 23)));				
				try {
					weather.setAfter24hWindSpeed(windSpeedMap.get("windSpeed_" + Integer.toString(startHour + 24)));
				} catch (Exception e) {
					logger.info("windSpeed_24 not present, set to zero value", e);
					weather.setAfter24hWindSpeed(new Double(0));
				}

				weather.setAfter1hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 1)));
				weather.setAfter2hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 2)));
				weather.setAfter3hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 3)));
				weather.setAfter4hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 4)));
				weather.setAfter5hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 5)));
				weather.setAfter6hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 6)));
				weather.setAfter7hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 7)));
				weather.setAfter8hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 8)));
				weather.setAfter9hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 9)));
				weather.setAfter10hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 10)));
				weather.setAfter11hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 11)));
				weather.setAfter12hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 12)));
				weather.setAfter13hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 13)));
				weather.setAfter14hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 14)));
				weather.setAfter15hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 15)));
				weather.setAfter16hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 16)));
				weather.setAfter17hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 17)));
				weather.setAfter18hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 18)));
				weather.setAfter19hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 19)));
				weather.setAfter20hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 20)));
				weather.setAfter21hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 21)));
				weather.setAfter22hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 22)));
				weather.setAfter23hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 23)));
				try {
					weather.setAfter24hCloudCover(cloudCoverMap.get("cloudCover_" + Integer.toString(startHour + 24)));
				} catch (Exception e) {
					logger.info("cloudCover_24 not present, set to zero value", e);
					weather.setAfter24hCloudCover(new Double(0));
				}

				weather.setAfter1hTime(timeMap.get("time_" + Integer.toString(startHour + 1)));
				weather.setAfter2hTime(timeMap.get("time_" + Integer.toString(startHour + 2)));
				weather.setAfter3hTime(timeMap.get("time_" + Integer.toString(startHour + 3)));
				weather.setAfter4hTime(timeMap.get("time_" + Integer.toString(startHour + 4)));
				weather.setAfter5hTime(timeMap.get("time_" + Integer.toString(startHour + 5)));				
				weather.setAfter6hTime(timeMap.get("time_" + Integer.toString(startHour + 6)));
				weather.setAfter7hTime(timeMap.get("time_" + Integer.toString(startHour + 7)));
				weather.setAfter8hTime(timeMap.get("time_" + Integer.toString(startHour + 8)));
				weather.setAfter9hTime(timeMap.get("time_" + Integer.toString(startHour + 9)));
				weather.setAfter10hTime(timeMap.get("time_" + Integer.toString(startHour + 10)));
				weather.setAfter11hTime(timeMap.get("time_" + Integer.toString(startHour + 11)));
				weather.setAfter12hTime(timeMap.get("time_" + Integer.toString(startHour + 12)));
				weather.setAfter13hTime(timeMap.get("time_" + Integer.toString(startHour + 13)));
				weather.setAfter14hTime(timeMap.get("time_" + Integer.toString(startHour + 14)));
				weather.setAfter15hTime(timeMap.get("time_" + Integer.toString(startHour + 15)));
				weather.setAfter16hTime(timeMap.get("time_" + Integer.toString(startHour + 16)));
				weather.setAfter17hTime(timeMap.get("time_" + Integer.toString(startHour + 17)));
				weather.setAfter18hTime(timeMap.get("time_" + Integer.toString(startHour + 18)));
				weather.setAfter19hTime(timeMap.get("time_" + Integer.toString(startHour + 19)));
				weather.setAfter20hTime(timeMap.get("time_" + Integer.toString(startHour + 20)));
				weather.setAfter21hTime(timeMap.get("time_" + Integer.toString(startHour + 21)));
				weather.setAfter22hTime(timeMap.get("time_" + Integer.toString(startHour + 22)));
				weather.setAfter23hTime(timeMap.get("time_" + Integer.toString(startHour + 23)));
				try {
					weather.setAfter24hTime(timeMap.get("time_" + Integer.toString(startHour + 24)));
				} catch (Exception e) {
					logger.info("time_24 not present, set to zero value", e);
					weather.setAfter24hTime(0);
				}
				
				weather.setAfter1hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 1)));
				weather.setAfter2hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 2)));
				weather.setAfter3hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 3)));
				weather.setAfter4hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 4)));
				weather.setAfter5hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 5)));
				weather.setAfter6hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 6)));
				weather.setAfter7hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 7)));
				weather.setAfter8hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 8)));
				weather.setAfter9hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 9)));
				weather.setAfter10hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 10)));
				weather.setAfter11hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 11)));
				weather.setAfter12hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 12)));
				weather.setAfter13hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 13)));
				weather.setAfter14hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 14)));
				weather.setAfter15hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 15)));
				weather.setAfter16hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 16)));
				weather.setAfter17hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 17)));
				weather.setAfter18hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 18)));
				weather.setAfter19hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 19)));
				weather.setAfter20hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 20)));
				weather.setAfter21hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 21)));
				weather.setAfter22hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 22)));
				weather.setAfter23hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 23)));
				try {
					weather.setAfter24hPrecipIntensity(precipIntensityMap.get("precipIntensity_"+ Integer.toString(startHour + 24)));
				} catch (Exception e) {
					logger.info("precipIntensity_24 not present, set to zero value", e);
					weather.setAfter24hPrecipIntensity(new Double(0));
				}
				
				weather.setAfter1hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 1)));
				weather.setAfter2hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 2)));
				weather.setAfter3hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 3)));
				weather.setAfter4hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 4)));
				weather.setAfter5hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 5)));
				weather.setAfter6hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 6)));
				weather.setAfter7hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 7)));
				weather.setAfter8hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 8)));
				weather.setAfter9hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 9)));
				weather.setAfter10hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 10)));
				weather.setAfter11hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 11)));
				weather.setAfter12hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 12)));
				weather.setAfter13hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 13)));
				weather.setAfter14hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 14)));
				weather.setAfter15hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 15)));
				weather.setAfter16hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 16)));
				weather.setAfter17hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 17)));
				weather.setAfter18hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 18)));
				weather.setAfter19hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 19)));
				weather.setAfter20hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 20)));
				weather.setAfter21hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 21)));
				weather.setAfter22hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 22)));
				weather.setAfter23hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 23)));
				try {
					weather.setAfter24hPrecipProbability(precipProbabilityMap.get("precipProbability_"+ Integer.toString(startHour + 24)));
				} catch (Exception e) {
					logger.info("precipProbability_24 not present, set to zero value", e);
					weather.setAfter24hPrecipProbability(new Double(0));
				}
			}

		} catch (JSONException e) {
			logger.info("Error during jasonParser of hourly block", e);
		}finally{
			temperatureMap.clear();
			windSpeedMap.clear();
			cloudCoverMap.clear();
			timeMap.clear();
			precipProbabilityMap.clear();
			precipIntensityMap.clear();
		}
		//get the master data detail block of forecast for the next 7 days
		try {
			dailyDetails = this.getForecastData().getJSONObject(dailyForecastData);
			//get the sub data detail block of forecast for the next 7 days
			if (dailyDetails.getJSONArray(dailyDetailData) != null) {
				JSONArray dailyJsonArray;
				dailyJsonArray = dailyDetails.getJSONArray(dailyDetailData);
				//read only the first block that is the block of current day
				//for (int i = 0; i < 1; i++) {
					JSONObject childJSONObject = dailyJsonArray
							.getJSONObject(0);

					weather.setDailySunriseTime(childJSONObject.getLong(sunriseTime));
					weather.setDailySunsetTime(childJSONObject.getLong(sunsetTime));
					weather.setTemperatureMin(RoundTo2Decimals(childJSONObject.getDouble(temperatureMin)));
					weather.setTemperatureMax(RoundTo2Decimals(childJSONObject.getDouble(temperatureMax)));
				//}
			}
		} catch (JSONException e) {
			logger.info("Error during jasonParser of hourly block", e);
		}
	}

	/**
	 * Gets the forecast data.
	 *
	 * @return the forecastData
	 */
	public JSONObject getForecastData() {
		return forecastData;
	}

	/**
	 * Sets the forecast data.
	 *
	 * @param forecastData            the forecastData to set
	 */
	public final void setForecastData(JSONObject forecastData) {
		this.forecastData = forecastData;
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

	/**
	 * Send weather data.
	 *
	 * @param weather the weather
	 * @return the response
	 */
	public Response sendWeatherData(WeatherForecast weather) {
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(weatherServerUrl);
		WebTarget resourceWebTarget = webTarget.path(weatherPath);
		Response responseEntity = resourceWebTarget.request(
				MediaType.APPLICATION_XML).post(Entity.xml(weather));
		return responseEntity;
	}
	
}

