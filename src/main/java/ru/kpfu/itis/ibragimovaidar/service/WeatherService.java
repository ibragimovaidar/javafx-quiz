package ru.kpfu.itis.ibragimovaidar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.ibragimovaidar.net.dto.owm.WeatherInfo;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class WeatherService {

	private final ObjectMapper objectMapper = new ObjectMapper();

	private static final String OWM_API_KEY = "b684cfe1558a37f5cab1c97d60108160";

	public WeatherInfo requestWeatherInfo(String city){
		try {
			URL url = new URL(String.format("http://api.openweathermap.org/data/2.5/weather?appid=%s&q=%s&lang=ru",
					OWM_API_KEY, city));
			return objectMapper.readValue(url, WeatherInfo.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
