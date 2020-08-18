package Projet_1.LibrePlan;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;

/**
 * ToolBox() is the class which groups together all the methods useful for other classes
 * @author formation
 *
 */
public class ToolBox {
	static long chrono = 0;
	
	public static WebDriver chooseBrowser(Logger log, EBrowser browser) {
		switch (browser) {
		case f:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			return new FirefoxDriver();
		case c:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			return new ChromeDriver();
		case e:
			System.setProperty("webdriver.edge.driver", "src/main/resources/driver/msedgedriver.exe");
			return new EdgeDriver();
		case ie:
			System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
			return new InternetExplorerDriver();
		default:
			log.warn("This web browser doesn't exist");
			return null;
		}
	}

	/**
	 * fillInField() is the method of cleaning and filling text fields
	 * @param we s
	 * 
	 */
	public static void fillInField(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
	
	/**
	 * isElementPresent() is the method of verifying the presence of an element
	 * @param we log
	 * @return result web element is displayed
	 * 
	 */
	public static boolean isElementPresent(WebElement we, Logger log) {
		boolean result = we.isDisplayed();
		if (result == false) {
			log.error(we + " is unavailable");
		} else {
			log.info(we + " is present !");
		}
		return result;
	}
	
	/**
	 * goChrono() is the method of starting the timer
	 * 
	 */
	public static void goChrono() {
		chrono = System.currentTimeMillis();
	}
	
	/**
	 * stopChrono() is the method of stopping the timer
	 * @return time timer value
	 * 
	 */
	public static long stopChrono() {
		long chrono2 = System.currentTimeMillis();
		long time = chrono2 - chrono;
		System.out.println("Time elapsed = " + time + " ms");
		return time;
	}
	
	/**
	 * takeSnapShot() is the method of taking snap shot
	 * @param webdriver fileWithPath
	 * @throws java.lang.Exception
	 * 
	 */
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	/**
	 * catchTime() is the method of catching snap shot time
	 * @return text time formatter
	 * 
	 */
	public static String catchTime() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM HH_mm_ss");
		String text = date.format(formatter);
		return text;
	}
	
	/**
	 * clickCreateElement() is the method of creating new element of items
	 * @param driver
	 *  
	 */
	public static void clickCreateElement(WebDriver driver) {
		WebElement btn_create = driver.findElement(By.xpath("//div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div[3]/span/table/tbody/tr[2]/td[2]"));
		btn_create.click();
	}
	
	/**
	 * returnNumberLigne() is the method of return number of line
	 * @param l known_value
	 *  
	 */
	public static int returnNumberLigne(List<WebElement> l, String known_value){ 
		int currentLine = 1;
		for(WebElement line : l){
			List<WebElement> l_cells = line.findElements(By.xpath("td"));
			for(WebElement cell : l_cells){
				if(cell.getText().equals(known_value)) {
					return currentLine;
					}
				}
			currentLine++;
		}
		return -1;
	}
	
	
}
