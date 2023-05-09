package com.example.selenium.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
class CrawlingServiceTest {

  @Autowired
  private CrawlingService crawlingService;

  @DisplayName("문항 HTML 조회")
  @Test
  void testGetProblemHtml() {

    // Given
    String url = "https://d-qbank2.daekyo.co.kr/";
    String id = "DD0001";
    String pw = "1234";
    String problemId = "445799";

    // When
    String problemHtml = crawlingService.getProblemHtml(url, id, pw, problemId);
    log.info("problemHtml : {}", problemHtml);

    // Then
    assertTrue(ObjectUtils.isNotEmpty(problemHtml));
  }
}
