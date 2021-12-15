package ru.kpfu.itis.ibragimovaidar.net.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

	private Float temp;

	@JsonProperty("feels_like")
	private Float feelsLike;

	@JsonProperty("temp_min")
	private Float tempMin;

	@JsonProperty("temp_max")
	private Float tempMax;

	private Integer pressure;

	private Integer humidity;

}
