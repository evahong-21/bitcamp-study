// log4j 2 사용법
// 프로그램의 실행 과정을 기록하고 싶을때 사용하는 라이브러리
package com.eomcs.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Exam01 {
  private static final Logger logger = LogManager.getLogger(Exam01.class);

  public static void main(String[] args) {
    logger.fatal("내용 ==> FATAL");
    logger.error("내용 ==> ERROR");
    logger.warn("내용 ==> WARN");
    logger.info("내용 ==> INFO");
    logger.debug("내용 ==> DEBUG");
    logger.trace("내용 ==> TRACE");

  }

}
