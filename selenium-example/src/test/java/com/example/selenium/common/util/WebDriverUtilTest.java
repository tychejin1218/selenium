package com.example.selenium.common.util;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("local")
@SpringBootTest(classes = {WebDriverUtil.class})
class WebDriverUtilTest {


  @DisplayName("Selenium으로 크롤링 테스트")
  @Test
  void testWebDriverUtil() {
    WebDriverUtil webDriverUtil = new WebDriverUtil();
    webDriverUtil.useDriver("https://www.youtube.com/c/youtubekorea/videos");
  }
}
