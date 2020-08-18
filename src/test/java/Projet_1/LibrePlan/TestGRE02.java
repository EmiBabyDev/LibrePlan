package Projet_1.LibrePlan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestGRE02 is the test class for creating a machine
 * @author formation
 *
 */
public class TestGRE02 {
	static Logger log = LoggerFactory.getLogger(Connexion.class);
	WebDriver driver;
	WebDriverWait wait;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.f);
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
	 * testCreateMachine() is the test method of the new machine
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void testCreateMachine() throws InterruptedException {
		// PT1 : Connection to the application - Admin Profile
		driver.get("http://localhost:8090/libreplan/");
		log.info("LIBREPLAN IS OPEN !");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.toLogIn(driver, "admin", "admin");
		assertTrue(driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(., 'Calendrier')]")).isDisplayed());
		log.info("CONNECTED : [CALENDAR TAB] IS DISPLAYED");
		
		// PT2 : Access the machine management page
		PageMachine page_machine = page_index.clickMachine(driver);
		assertTrue(driver.findElement(By.xpath("//div[@class='z-window-embedded-header' and contains(.,'Machines Liste')]")).isDisplayed());
		log.info("[LIST MACHINES PAGE] IS DISPLAYED");
		
		// PT3 : Create a machine - Access to the creation form
		ToolBox.clickCreateElement(driver);
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.xpath("//table[contains(@class,'caption-title z-caption' )]/tbody/tr/td[1][contains(@class,'caption') and contains(.,'Machine')]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//li[contains(@class,'z-tab-seld')]/div/div/div/span[contains(.,'Donnée de la machine')]")).isDisplayed());
		log.info("[CREATE MACHINE PAGE] IS DISPLAYED");
		log.info("[MACHINE DATA] TAB SELECTED BY DEFAULT");
		
		// PT4 : Create a machine - Compliance of the "Machine data" tab
		PageMachine page_machine1 = PageFactory.initElements(driver,PageMachine.class);
		page_machine1.fillInMachine(driver);
		
	}

}
