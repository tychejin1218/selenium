package com.example.selenium.common.util;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class WebDriverUtil {

  private WebDriver webDriver;

  public WebDriverUtil() {
    chrome();
  }

  private void chrome() {

    System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
    System.setProperty("webdriver.http.factory", "jdk-http-client");

    // webDriver 옵션 설정
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);
    options.addArguments("--lang=ko");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.setCapability("ignoreProtectedModeSettings", true);

    // webDriver 생성
    webDriver = new ChromeDriver(options);
    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  public void useDriver(String url) {
    webDriver.get(url);
    webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);  // 페이지 불러오는 여유시간.
    log.info("++++++++++++++++++++++===================+++++++++++++ selenium : "
        + webDriver.getTitle());

    WebElement searchLabel = webDriver.findElement(By.id("label-text"));
    log.info("++++++++++++++++++++++===================+++++++++++++ searchLabel : "
        + searchLabel.getText());

    quitDriver();
  }

  private void quitDriver() {
    webDriver.quit(); // webDriver 종료
  }
}
