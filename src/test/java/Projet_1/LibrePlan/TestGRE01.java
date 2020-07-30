package Projet_1.LibrePlan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestGRE01 is the test class for creating a participant (new user)
 * @author formation
 *
 */
public class TestGRE01 {
	static Logger log = LoggerFactory.getLogger(TestConnect.class);
	WebDriver driver;
	WebDriverWait wait;

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
	 * testCreateNewUser() is the test method of the new user
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testCreateNewUser() throws InterruptedException {
		// PT1 : Connection to the application - Admin Profile
		driver.get("http://localhost:8090/libreplan/");
		log.info("LIBREPLAN IS OPEN !");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.toLogIn(driver, "admin", "admin");
		assertTrue(driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(., 'Calendrier')]")).isDisplayed());
		log.info("CONNECTED : [CALENDAR TAB] IS DISPLAYED");
		
		// PT2 : Access the participant management page
		PageParticipant page_participant = page_index.clickParticipant(driver);
		assertTrue(driver.findElement(By.xpath("//div[contains(.,'Liste des participants') and contains(@class, 'embedded-header')]")).isDisplayed());
		log.info("[LIST PARTICIPANTS PAGE] IS DISPLAYED");
		
		// PT3 : Create a participant - Access to the creation form
		ToolBox.clickCreateElement(driver);
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr/td[1]")).isDisplayed());
		log.info("[CREATE PARTICIPANT PAGE] IS DISPLAYED");
		page_participant.CreateParticipant(driver);
	
	
	}

}
