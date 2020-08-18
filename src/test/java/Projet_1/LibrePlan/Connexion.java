package Projet_1.LibrePlan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestConnect is the test class for the connection to the server and to the DB
 * @author formation
 *
 */
public class Connexion {
	static Logger log = LoggerFactory.getLogger(Connexion.class);
	WebDriver driver;
	WebDriverWait wait;


	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 7000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		log.info("QUIT DRIVER");
	}
	
	/**
	 * testADriverConnect() is the test method of the driver connect
	 * 
	 */
	@Test
	public void testDriverConnect() {
		
		driver.get("http://localhost:8090/libreplan/");
		assertTrue(driver.findElement(By.xpath("//img[@alt = 'LibrePlan']")).isDisplayed());
		log.info("LIBREPLAN IS OPEN !");
		
		driver.findElement(By.xpath("//*[@name = 'button']")).click();
		assertTrue(driver.findElement(By.xpath("//a[contains(@class, 'cerrar_sesion') and contains(., '[Déconnexion]')]")).isDisplayed());
		log.info("USER CONNECT");
	
	}

}