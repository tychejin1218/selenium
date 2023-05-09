package com.example.selenium.service;

import com.example.selenium.config.WebDriverConfig;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CrawlingService {

  private final WebDriverConfig webDriverConfig;

  /**
   * 문항 HTML 조회
   *
   * @param url       설명
   * @param id        설명
   * @param pw        설명
   * @param problemId 설명
   */
  public String getProblemHtml(String url, String id, String pw, String problemId) {

    WebDriver webDriver = webDriverConfig.chromeDriver();
    webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    // 메인
    webDriver.get(url);
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // 로그인
    webDriver.findElement(By.id("f_id")).sendKeys(id);
    webDriver.findElement(By.id("f_pwd")).sendKeys(pw);
    webDriver.findElement(By.className("loginButton")).click();

    // 바로 열기(문항) iframe 호출
    webDriver.switchTo().frame(webDriver.findElement(By.id("ifrmain1")));
    webDriver.findElement(By.id("txtnumber")).sendKeys(problemId);
    webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/a")).click();

    // 문항 미리 보기 팝업 호출
    String parentWindow = webDriver.getWindowHandle();
    for (String window : webDriver.getWindowHandles()) {
      if (!parentWindow.equals(window)) {
        webDriver.switchTo().window(window);
      }
    }

    // 문항 미리 보기 iframe 호출
    webDriver.switchTo().frame(webDriver.findElement(By.id("mainarea")));

    // 문항 HTML
    String problemHtml = webDriver.findElement(By.id("chobank")).getAttribute("innerHTML");
    return problemHtml;
  }
}
