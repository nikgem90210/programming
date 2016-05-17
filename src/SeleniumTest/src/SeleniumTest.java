//package SeleniumTest.src;
//
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Before;
//
//public class SeleniumTest {
//	protected WebDriver driver;
//	public String baseUrl;
//	protected boolean acceptNextAlert = true;
//	protected StringBuffer verificationErrors = new StringBuffer();
//
//	@Before
//	public void setUp() throws Exception {
//		driver = new FirefoxDriver();
//		baseUrl = "http://m.airtellive.com/";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
//
//	@Test
//	public void testSelenium() throws Exception {
//		driver.get(baseUrl + "/?dg=5");
//		driver.findElement(By.cssSelector("span")).click();
//		try {
//			assertEquals("Top Stories - airtel>", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("top stories", driver.findElement(By.cssSelector("div.subttl > div")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		driver.findElement(By.xpath("//div[@id='wrap']/div[4]/div/table/tbody/tr/td[2]/a/span")).click();
//		try {
//			assertEquals("Re 1 Store | Music", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		driver.findElement(By.xpath("//div[@id='wrap']/div[4]/div/table/tbody/tr/td[3]/a/span")).click();
//		driver.findElement(By.linkText("games")).click();
//		try {
//			assertEquals("Re 1 Store | Game", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		driver.findElement(By.xpath("//div[@id='wrap']/div[4]/div/table/tbody/tr[2]/td/a/span")).click();
//		try {
//			assertEquals("photos", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		driver.findElement(By.xpath("//div[@id='wrap']/div[4]/div/table/tbody/tr[2]/td[2]/a/span")).click();
//		try {
//			assertEquals("Movies", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		driver.findElement(By.xpath("//div[@id='wrap']/div[4]/div/table/tbody/tr[2]/td[3]/a/span")).click();
//		try {
//			assertEquals("Airtel | Elections", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("Constituency Watch", driver.findElement(By.xpath("//div[7]")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		driver.findElement(By.xpath("//div[@id='wrap']/div[4]/div/table/tbody/tr[2]/td[4]/a/span")).click();
//		try {
//			assertEquals("Match Schedule", driver.findElement(By.xpath("//div[19]")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("photos", driver.findElement(By.cssSelector("h2.ttl.mt10 > div > a")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("news", driver.findElement(By.cssSelector("div.divide.mt10 > h2.ttl > div > a")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertTrue(isElementPresent(By.linkText("view all")));
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertTrue(isElementPresent(By.linkText("videos")));
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("videos", driver.findElement(By.linkText("videos")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertTrue(isElementPresent(By.xpath("(//a[contains(text(),'cricket')])[2]")));
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertTrue(isElementPresent(By.linkText("entertainment")));
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("entertainment", driver.findElement(By.linkText("entertainment")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertEquals("popular links", driver.findElement(By.linkText("popular links")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//		try {
//			assertTrue(isElementPresent(By.linkText("popular links")));
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
//	}
//
//	private boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
//
//	private boolean isAlertPresent() {
//		try {
//			driver.switchTo().alert();
//			return true;
//		} catch (NoAlertPresentException e) {
//			return false;
//		}
//	}
//
//	private String closeAlertAndGetItsText() {
//		try {
//			Alert alert = driver.switchTo().alert();
//			String alertText = alert.getText();
//			if (acceptNextAlert) {
//				alert.accept();
//			} else {
//				alert.dismiss();
//			}
//			return alertText;
//		} finally {
//			acceptNextAlert = true;
//		}
//	}
//}
