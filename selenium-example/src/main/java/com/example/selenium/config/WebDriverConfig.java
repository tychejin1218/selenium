package com.example.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class WebDriverConfig {

  @Primary
  @Bean
  public WebDriver chromeDriver() {

    System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
    System.setProperty("webdriver.http.factory", "jdk-http-client");

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability("ignoreProtectedModeSettings", true);
    return new ChromeDriver(chromeOptions);
  }
}
