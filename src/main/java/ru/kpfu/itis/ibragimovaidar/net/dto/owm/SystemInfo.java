package ru.kpfu.itis.ibragimovaidar.net.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemInfo {

	private Long id;
	private Integer type;
	private String country;
}
