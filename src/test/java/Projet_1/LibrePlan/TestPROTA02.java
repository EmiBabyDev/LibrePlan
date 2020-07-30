package Projet_1.LibrePlan;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestPROTA01 is the test class for creation task
 * @author formation
 *
 */
public class TestPROTA02 {
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
		/*driver.quit();
		log.info("QUIT DRIVER");*/
	}

	/**
	 * testCreateTasks() is the test method of creation task test
	 * @throws java.lang.InterruptedException
	 */
	@Test
	public void testCreateTasks() throws InterruptedException {
		// PT1 : Connection to the application - Admin Profile
		driver.get("http://localhost:8090/libreplan/");
		log.info("LIBREPLAN IS OPEN !");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.toLogIn(driver, "admin", "admin");
		assertTrue(driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(., 'Calendrier')]")).isDisplayed());
		log.info("CONNECTED : [CALENDAR TAB] IS DISPLAYED");
		
		// PT Suits
		driver.findElement(By.xpath("//*[@name = 'button']")).click();
		PageAccueil.accesListe();
		Thread.sleep(2000);
		PageAccueil.accesProjet();
		
		PageProjet page_projet = PageFactory.initElements(driver,PageProjet.class);

		page_projet.creaTache1(driver);
		page_projet.creaTache234(driver);
		page_projet.moveElements(driver);
		page_projet.fillCodes(driver);
		page_projet.fillDates(driver);	
	}
	
}

