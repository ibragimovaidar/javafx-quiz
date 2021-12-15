package ru.kpfu.itis.ibragimovaidar.controller;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.ibragimovaidar.net.dto.owm.WeatherInfo;
import ru.kpfu.itis.ibragimovaidar.service.WeatherService;

public class ApplicationController {

	private final WeatherService weatherService = new WeatherService();

	@FXML
	private TextField city;

	@FXML
	private Label cityNameLabel;

	@FXML
	private Button search;

	@FXML
	private VBox weatherInfoVBox;

	@FXML
	private void initialize() {
		search.setText("Get weather");
		search.setStyle("-fx-background-color: #ff0000");

		search.setOnAction(event -> loadData());

		city.setOnKeyPressed(event -> {
			if (event.getCode().equals(KeyCode.ENTER)) {
				loadData();
			}
		});
	}

	private void loadData() {
		String cityName = city.getText();

		Task<WeatherInfo> task = new Task<WeatherInfo>() {
			@Override
			protected WeatherInfo call() throws Exception {
				return weatherService.requestWeatherInfo(cityName);
			}
		};
		task.setOnSucceeded(event -> {
			renderWeather(task.getValue());
		});

		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}

	@FXML
	private Label cityName;

	@FXML
	private Label temp;

	@FXML
	private Label tempFeelsLike;

	@FXML
	private Label tempDescription;

	@FXML
	private Label windSpeed;

	@FXML
	private Label humidity;

	private void renderWeather(WeatherInfo weatherInfo){
		cityName.setText("Город: " + weatherInfo.getName());
		temp.setText("Температура: " + (weatherInfo.getMain().getTemp() - 273.15F) + "C");
		tempFeelsLike.setText("Ощущается как: " + (weatherInfo.getMain().getTemp() - 273.15F) + "C");
		tempDescription.setText("Погода: " + weatherInfo.getWeather().get(0).getDescription());
		windSpeed.setText("Скорость ветра: " + weatherInfo.getWind().getSpeed());
		humidity.setText("Влажность: " + weatherInfo.getMain().getHumidity());
	}
}
