<<<<<<< HEAD
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

public class TestPROTA02 {
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

	@Test
	public void CreateTasks() throws InterruptedException {
		driver.get("http://localhost:8090/libreplan/");
		assertTrue(driver.findElement(By.xpath("//img[@alt = 'LibrePlan']")).isDisplayed());
		log.info("LIBREPLAN IS OPEN !");
		// instanciation de la pageLogin

		PageLogin page_login = PageFactory.initElements(driver,PageLogin.class);
		page_login.fillInLogin(driver);
		
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

=======
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

public class TestPROTA02 {
	static Logger log = LoggerFactory.getLogger(TestConnect.class);
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

	@Test
	public void CreateTasks() throws InterruptedException {
		driver.get("http://localhost:8090/libreplan/");
		assertTrue(driver.findElement(By.xpath("//img[@alt = 'LibrePlan']")).isDisplayed());
		log.info("LIBREPLAN IS OPEN !");
		// instanciation de la pageLogin

		PageLogin page_login = PageFactory.initElements(driver,PageLogin.class);
		page_login.fillInLogin(driver);
		
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

>>>>>>> 7fea4ae6bef9a6ccf8f65a19dca74526d4346546
