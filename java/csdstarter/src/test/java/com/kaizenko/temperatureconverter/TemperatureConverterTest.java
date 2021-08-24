package com.kaizenko.temperatureconverter;
 
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TemperatureConverterTest {		
	@Test
	void convertCtoF_When0C_Expect32F() {
		TemperatureConverter temperatureConverter = new TemperatureConverter();	
		int tempInF = temperatureConverter.convertCtoF(0);
		assertThat(tempInF).isEqualTo(32);
	}
	
	@Test
	void convertCtoF_When100C_Expect212F() {
		TemperatureConverter temperatureConverter = new TemperatureConverter();	
		int tempInF = temperatureConverter.convertCtoF(100);
		assertThat(tempInF).isEqualTo(212);
	}
	
	@Test
	void convertCtoF_WhenNegative40C_ExpectNegative40F() {
		TemperatureConverter temperatureConverter = new TemperatureConverter();	
		int tempInF = temperatureConverter.convertCtoF(-40);
		assertThat(tempInF).isEqualTo(-40);
	}
	
	@Test
	void convertCtoF_When25C_Expect77F() {
		TemperatureConverter temperatureConverter = new TemperatureConverter();	
		int tempInF = temperatureConverter.convertCtoF(25);
		assertThat(tempInF).isEqualTo(77);
	}
	
	@Test
	void convertCtoF_When10C_Expect55F() {
		TemperatureConverter temperatureConverter = new TemperatureConverter();	
		int tempInF = temperatureConverter.convertCtoF(10);
		assertThat(tempInF).isEqualTo(50);
	}
}
