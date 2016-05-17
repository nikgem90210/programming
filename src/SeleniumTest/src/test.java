//package com.example.tests;
//
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Before;
//
//public class Test {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//
//  @Before
//  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//    baseUrl = "http://m.airtellive.com/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void test() throws Exception {
//    driver.get(baseUrl + "/cricket/");
//    try {
//      assertTrue(isElementPresent(By.linkText("Results")));
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if ("".equals(driver.findElement(By.cssSelector("td.categories-td > a > img")).getText())) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }
//
//    try {
//      assertTrue(isElementPresent(By.cssSelector("td.categories-td > a > img")));
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
//  }
//
//  @After
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
