package Projet_1.LibrePlan;
import static org.junit.Assert.*;

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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * PageAccueil is the class of the home page
 * @author formation
 *
 */
public class PageAccueil {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
    static Logger log = LoggerFactory.getLogger(Connexion.class);
	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_add.png']")
    WebElement nouveau_projet;	
	@FindBy(xpath = "//td[text()='Liste des projets']")
	static
    WebElement liste_projet;
	@FindBy(xpath = "//input[@style = 'width:500px;']")
    WebElement nom_projet;
	@FindBy(xpath = "//input[@style = 'width: 377px;']")
    WebElement modèle_projet;
	@FindBy(xpath = "//input[@style = 'width:250px;']")
    WebElement code_projet;	
	@FindBy(xpath = "//tr[4]/td[2]/div/i/input")
    WebElement date_debut_projet;	
	@FindBy(xpath = "//tr[5]/td[2]/div/i/input")
    WebElement date_echéance_projet;	
	@FindBy(xpath = "//input[@style = 'width: 462px;']")
    WebElement client_projet;
	@FindBy(xpath = "//input[@style = 'width: 177px;']")
    WebElement calendrier_projet;
	@FindBy(xpath = "//td[3]/span/input[@type='checkbox']")
    WebElement gen_code_projet;	
	@FindBy(xpath = "//td[text()='Accepter']")
    WebElement btn_accepter_projet;
	@FindBy(xpath = "//td[text()='Annuler']")
    WebElement btn_annuler_projet;
	@FindBy(xpath = "//span[text()='PROJET_TEST1']")
	static WebElement projet1;
	@FindBy(xpath = "//*[contains(@href,'/libreplan/planner/index.zul;orders_list')]")
    WebElement projet_déroulant;
	@FindBy(xpath = "//button[contains(text(), 'Calendrier')]")
    WebElement calendrier_déroulant;
	
	/**
	 * accesListe() is the static method of access list
	 * 
	 */
	public static void accesListe() {
		liste_projet.click();
	}
	
	/**
	 * accesProjet() is the static method of access project
	 * 
	 */
	public static void accesProjet() {
		projet1.click();
	}

	/**
	 * accesCalendrierProjet() is the method of access calendar
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the home page
	 */
	public  PageAccueil accesCalendrierProjet(WebDriver driver) throws InterruptedException {
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(calendrier_déroulant).moveToElement(projet_déroulant).click().build().perform();
		assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'PROJET_TEST1')]")).isDisplayed());
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	/**
	 * verifChamps() is the method of checking fields
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the home page
	 */
	public PageAccueil verifChamps(WebDriver driver) throws InterruptedException {
	
		ToolBox.isElementPresent(nom_projet, log);
		assertTrue(nom_projet.isDisplayed());
		assertTrue(gen_code_projet.isDisplayed());
		assertTrue(code_projet.isDisplayed());
		assertTrue(date_debut_projet.isDisplayed());
		assertTrue(date_echéance_projet.isDisplayed());
		assertTrue(calendrier_projet.isDisplayed());
		assertTrue(btn_annuler_projet.isDisplayed());
		assertTrue(client_projet.isDisplayed());
		assertTrue(btn_accepter_projet.isDisplayed());
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	/**
	 * creerProjet() is the method of creation project
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the home page
	 */
	public PageAccueil creerProjet(WebDriver driver) throws InterruptedException {
		nouveau_projet.click();
		//driver.switchTo().frame(0); 
		ToolBox.fillInField(nom_projet, "PROJET_TEST1");
		gen_code_projet.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(code_projet));
		verifChamps(driver);
		ToolBox.fillInField(code_projet, "PRJTEST001");
		wait.until(ExpectedConditions.elementToBeClickable(date_debut_projet));
	    Date currentDate = new Date();
		LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime localDateTime15 = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusYears(0).plusMonths(0).plusDays(5);
		localDateTime15 = localDateTime15.plusYears(0).plusMonths(0).plusDays(15);
		Date currentDatePlusFiveDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		Date currentDatePlusFifteenDay = Date.from(localDateTime15.atZone(ZoneId.systemDefault()).toInstant());
		ToolBox.fillInField(date_debut_projet, dateFormat.format(currentDatePlusFiveDay));
		ToolBox.fillInField(date_echéance_projet, dateFormat.format(currentDatePlusFifteenDay));
		wait.until(ExpectedConditions.elementToBeClickable(btn_accepter_projet));
		btn_accepter_projet.click();
		
		return PageFactory.initElements(driver, PageAccueil.class);
	}

	
	
	
	
	
	
}
