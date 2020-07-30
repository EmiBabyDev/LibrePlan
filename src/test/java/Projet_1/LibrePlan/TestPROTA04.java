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

public class TestPROTA04 {
	static Logger log = LoggerFactory.getLogger(TestConnect.class);
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
	 * 
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
		assertTrue(driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(., 'Calendrier')]"))
				.isDisplayed());
		log.info("CONNECTED : [CALENDAR TAB] IS DISPLAYED");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//td[text()='Liste des projets']")).click();
		assertTrue(driver.findElement(By.xpath("//td[text()='Liste des projets']")).isDisplayed());
		driver.findElement(By.xpath("(//td/div/span)[1]")).click();
		driver.findElement(By.xpath("//td[text()='Planification de projet']")).click();
		driver.findElement(By.xpath("(//select)[1]")).click();
		driver.findElement(By.xpath("//option[text()='Année']")).click();
		// check H1 and H2 are present
		assertTrue(driver.findElement(By.xpath("(//td[contains(text(),'H1')]/following::td[contains(text(),'H2')])[1]"))
				.isDisplayed());
		driver.findElement(By.xpath("(//select)[1]")).click();
		driver.findElement(By.xpath("//option[text()='Trimestre']")).click();
		// check Q1 Q2 Q3 Q4 are present

		assertTrue(driver.findElement(By.xpath(
				"(//td[contains(text(),'Q1')]/following::td[contains(text(),'Q2')]/following::td[contains(text(),'Q3')]/following::td[contains(text(),'Q4')])[1]"))
				.isDisplayed());
		driver.findElement(By.xpath("(//select)[1]")).click();
		driver.findElement(By.xpath("//option[text()='Mois']")).click();
		assertTrue(
				driver.findElement(By.xpath("(//div[contains(text(),'H1')]/following::div[contains(text(),'H2')])[1]"))
						.isDisplayed());

	}

}
