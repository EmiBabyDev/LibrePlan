
package Projet_1.LibrePlan;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestPROTA01 is the test class for creating a project
 * @author formation
 *
 */
public class TestPROTA01 {

	static Logger log = LoggerFactory.getLogger(Connexion.class);
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
		wait = new WebDriverWait(driver, 5000);
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
	 * testCreateProject() is the test method of creation project test
	 * @throws java.lang.InterruptedException
	 */
	@Test
	public void testCreateProject() throws InterruptedException {
		// PT1 : Connection to the application - Admin Profile
		driver.get("http://localhost:8090/libreplan/");
		log.info("LIBREPLAN IS OPEN !");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.toLogIn(driver, "admin", "admin");
		assertTrue(driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(., 'Calendrier')]")).isDisplayed());
		log.info("CONNECTED : [CALENDAR TAB] IS DISPLAYED");
		
		// PT Suits
		PageAccueil nom_projet  = PageFactory.initElements(driver,PageAccueil.class);
		nom_projet.creerProjet(driver);
		log.info("PROJET 1 est créé !");
		PageProjet verif_menu  = PageFactory.initElements(driver,PageProjet.class);
		verif_menu.verifMenuHorizontal(driver);
		log.info("MENU HORIZONTAL DANS L'ORDRE !");
		verif_menu.verifMenuVertical(driver);
		log.info("MENU VERTICAL DANS L'ORDRE !");
		verif_menu.verifBoutonsProjet(driver);
		verif_menu.utiliserBoutonsProjet(driver);
		nom_projet.accesCalendrierProjet(driver);

		log.info("PROJET 1 est dans la liste projets avec les caractéristiques choisies !");

	}
	
}