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
    chromeOptions.addArguments("headless"); // headless 모드(브라우저 창을 열지 않고 백그라운드에서 실행하는 모드)
    chromeOptions.addArguments("window-size=1920,1080"); // 브라우저 창 크기를 1920x1080로 설정
    chromeOptions.addArguments("disable-cache"); // 캐시 비활성화
    chromeOptions.addArguments("disable-gpu"); // GPU 가속 비활성화
    return new ChromeDriver(chromeOptions);
  }
}
