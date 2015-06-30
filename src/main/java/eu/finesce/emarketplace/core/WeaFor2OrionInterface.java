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

import java.io.IOException;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import eu.finesce.emarketplace.domain.WeatherForecast;

/**
 * The Interface WeaFor2OrionInterface.
 *
 * @author LL
 */
public interface WeaFor2OrionInterface {
	
	/**
	 * Exec.
	 *
	 * @param mappingFileName the mapping file name
	 * @param currentTime the current time
	 */
	public void exec(String mappingFileName, String currentTime);

	/**
	 * Method to retrieve properties data from NAME.properties
	 *
	 * @param mappingFileName the mapping file name
	 * @return the properties data
	 */
	public String getPropertiesData(String mappingFileName);

	/**
	 * Gets the forecast data by service.
	 *
	 * @param weatherServiceUrl the weather service url
	 * @param serviceKey the service key
	 * @param inputUrlParam the input url param
	 * @param currentTime the current time
	 * @return JSONObject
	 */
	public JSONObject getForecastDataByService(String weatherServiceUrl,String serviceKey,
			String inputUrlParam, String currentTime) ;
	
	/**
	 * Gets the json object by url.
	 *
	 * @param forecastUrl the forecast url
	 * @return the json object by url
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	public JSONObject getJsonObjectByUrl(String forecastUrl)
			throws IOException, JSONException;
	/**
	 * Url builder.
	 *
	 * @param weatherServiceUrl the weather service url
	 * @param serviceKey the service key
	 * @param inputUrlParam the input url param
	 * @param currentTime the current time
	 * @return the string
	 */
	public String urlBuilder(String weatherServiceUrl,String serviceKey,
			String inputUrlParam, String currentTime) ;

	/**
	 * Send weather ctx ev data to orion.
	 *
	 * @param weather the weather
	 * @return the response
	 */
	public Response sendWeatherCtxEvDataToOrion(WeatherForecast weather) ;
	/**
	 * Parses the data from forecast service response.
	 */
	public void parseDataFromForecastServiceResponse();

	/**
	 * Gets the forecast data.
	 *
	 * @return the forecastData
	 */
	public JSONObject getForecastData() ;

	/**
	 * Sets the forecast data.
	 *
	 * @param forecastData the forecastData to set
	 */
	public void setForecastData(JSONObject forecastData);

	/**
	 * Send weather data.
	 *
	 * @param weather the weather
	 * @return the response
	 */
	public Response sendWeatherData(WeatherForecast weather) ;
	
}

