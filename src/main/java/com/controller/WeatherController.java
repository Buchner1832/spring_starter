package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WeatherController {

	@GetMapping("/weather/{city}")
	public String index(Model model, @PathVariable("city") String city) {
		double temp;
		String err = "";
		try {
			temp = getCurrentTemp(city);
			model.addAttribute("current_temp", temp);
		} catch (RestClientException e) {
			err = "Konnte nicht mit der API verbinden.";
		} catch (JsonMappingException e) {
			err = "Fehler beim Verarbeiten des Rückgabewertes.";
		}
		catch (JsonProcessingException e) {
			err = "Fehler beim Verarbeiten des Rückgabewertes.";
		}
		
		model.addAttribute("err", err);
		model.addAttribute("title", "Wetter in " + city);
		model.addAttribute("city", city);
		return "weather.html";
	}

	/*
	 * Gibt die geographische Position (Länge und Breite) zurück
	 * Achtung: Diese Methode ist noch nicht korrekt implementiert.
	 * Aktuell wird immer die geographische Position von Bamberg zurückgegeben.
	 * TODO: Ergänze die Methode, dass zu jeder deutschen Stadt die geographische Position ermittelt wird.
	 * Was passiert, wenn der Parameter city keiner deutschen Stadt entspricht oder es mehrere Städte mit diesem Namen gibt?
	*/ 
	private double[] getGeoPos(String city) {
		double[] res = { 49.89873, 10.90067};
		return res;
	}

	/*
	 * Verwendet ein API um die aktuelle Temperatur zu ermitteln.
	 * Dieser Prozess kann fehlschlagen.
	 */
	private double getCurrentTemp(String city) throws JsonProcessingException, JsonMappingException, RestClientException{
		double[] latLong = getGeoPos(city);
		String uri = "https://api.open-meteo.com/v1/forecast?latitude=" + latLong[0] + "&longitude=" + latLong[1]
				+ "&current_weather=true";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		// You would need to parse the json using a library like Jackson or GSON
		JsonNode root = new ObjectMapper().readTree(result);
		return root.path("current_weather").path("temperature").asDouble();
	}

}
