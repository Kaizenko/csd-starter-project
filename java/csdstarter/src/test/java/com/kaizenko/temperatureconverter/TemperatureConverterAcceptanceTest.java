package com.kaizenko.temperatureconverter;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@CucumberOptions(strict=true, monochrome = true, 	
				features = "classpath:features",
				plugin = {"pretty", "html:target/cucumber-reports",
		  				  "json:target/cucumber.json"})
//@RunWith(Cucumber.class)
public class TemperatureConverterAcceptanceTest {	
	 
}
