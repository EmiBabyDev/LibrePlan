package Projet_1.LibrePlan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestAVA01 is the test class for creating an advancement type
 * @author formation
 *
 */
public class TestAVA01 {
	static Logger log = LoggerFactory.getLogger(TestConnect.class);
	WebDriver driver;
	WebDriverWait wait;
	String jdd_namead = "Test 1";
	String jdd_default = "10,00";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 7000);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
		log.info("QUIT DRIVER");
	}

	/**
	 * testAdvance() is the test method of the advance item
	 * 
	 */
	@Test
	public void testAdvance() {
		// PT1 : Connection to the application - Admin Profile
		driver.get("http://localhost:8090/libreplan/");
		log.info("LIBREPLAN IS OPEN !");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.toLogIn(driver, "admin", "admin");
		assertTrue(driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(., 'Calendrier')]")).isDisplayed());
		log.info("CONNECTED : [CALENDAR TAB] IS DISPLAYED");
		
		// PT2 : Access the progress types management page
		PageAvancement page_advance = page_index.clickAdvance(driver);
		assertTrue(driver.findElement(By.xpath("//div[@class='z-window-embedded-header' and contains(., 'avancement Liste')]")).isDisplayed());
		log.info("[LIST PROGRESS TYPES PAGE] IS DISPLAYED");
		
		// PT3 : Create a progress type - Access to the creation form
		ToolBox.clickCreateElement(driver);
		assertTrue(driver.findElement(By.xpath("//td[@class='z-caption-l' and contains(.,'Créer Type')]")).isDisplayed());
		log.info("[CREATE PROGRESS TYPE PAGE] IS DISPLAYED");
		
		// PT4 : Create a progress type - without percentage
		page_advance.createAdvance(jdd_namead, jdd_default, null);
		
//		assertTrue(driver.findElement(By.xpath("//input[@style='width:300px;']")).isDisplayed());
		
		// PT5 : Create a progress type - Access to the creation form
		ToolBox.clickCreateElement(driver);
		assertTrue(driver.findElement(By.xpath("//td[@class='z-caption-l' and contains(.,'Créer Type')]")).isDisplayed());
		log.info("[CREATE PROGRESS TYPE PAGE] IS DISPLAYED");
		
		// PT6 : Create a progress type - percentage checked (1/2)
		
		
		// PT7 : Create a progress type - percentage checked (2/2)
		
		
		// PT8 : Return to the types of advancement management page
		
		
		
		// PT9 : Compliance of the type of advancement added
		
	
	}
	


}
