package Projet_1.LibrePlan;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestCRI01 is the test class for criteria administration
 * @author formation
 *
 */
public class TestCRI01 {
	static Logger log = LoggerFactory.getLogger(TestConnect.class);
	WebDriver driver;
	WebDriverWait wait;
	
	// Data sets Login
	String jdd_username = "admin";
	String jdd_passeword = "admin";
	
	// Data sets remove
	String jdd_name_c = "Critère - Test bouton [Annuler]";
	String jdd_description_c = "Critère - Test bouton [Annuler]";
	// Data sets records
	String jdd_name_e = "Critère - Test bouton [Enregistrer]";
	String jdd_description_e = "Critère - Test bouton [Enregistrer]";
	// Data sets save
	String jdd_name_s = "Critère - Test bouton [Sauver et continuer]";
	String jdd_description_s = "Critère - Test bouton [Sauver et continuer]";
	
	String jdd_type = "PARTICIPANT";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5000);
		//ToolBdd.deleteAllData(".\\src\\main\\resources\\xml\\suppr_resachambres.xml");
		
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
	 * testCriteriaAdministration() is the method for criteria administration
	 * @throws java.lang.InteruptedException
	 */
	@Test
	public void testCriteriaAdministration() throws InterruptedException {
		// PT1 : Connection to the application - Admin Profile
		driver.get("http://localhost:8090/libreplan/");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.toLogIn(driver, jdd_username, jdd_passeword);
		assertTrue(page_index.isCalendarPresent(log));
		
		// PT2 : Access the criteria administration page
		PageCriterions page_criterions = page_index.clicCriterions(driver);
		//Vérification de la presence du titre
		assertTrue(page_criterions.isTitleCriterions(log));
		//Vérification de la présence d'un tableau contenant Nom Code Type Activé Opérations
		List<WebElement> liste = driver.findElements(By.xpath("//div[1]/div[3]/div/div[1]/table/tbody[2]/tr/th"));

		ArrayList<String> listCritere = new ArrayList<String>() ;
		ArrayList<String> listCritereJDD = new ArrayList<String>() ;
		
		for(WebElement l : liste) {
			listCritere.add(l.getText());
		}
		
		listCritereJDD.add("Nom");
		listCritereJDD.add("Code"); 
		listCritereJDD.add("Type");
		listCritereJDD.add("Activé");
		listCritereJDD.add("Opérations");	
		
		assertEquals(listCritereJDD, listCritere); 
		log.info(listCritereJDD +"is present");
		
		
		// PT3 : Create a criterion - Access to the creation form
		PageCriterionsType page_criterionsType = page_criterions.createCriterion(driver);
		
		//Vérification de la presence du titre "Créer Type de critère"
		assertTrue(page_criterionsType.isTitleCreateCriterions(log));
		//Vérification de la presence du bouton annuler
		assertTrue(page_criterionsType.isBtnCancel(log));
		//Vérification de la presence du bouton enregistrer
		assertTrue(page_criterionsType.isBtnRecord(log));
		//Vérification de la presence du bouton sauver et continuer
		assertTrue(page_criterionsType.isBtnSave(log));
		//Vérification de la presence de l'onglet modifier
		assertTrue(page_criterionsType.isEditTab(log));
		
		
		// PT4 : Create a criterion - [Annuler] button
		page_criterionsType.fillTheForm(jdd_name_c, jdd_type, jdd_description_c);
		page_criterionsType.toCancel(driver);
		//Vérification que le critère n'a pas été créer
		assertFalse(page_criterions.isCriterionCancelPresent(log));
		log.error( "Critère - Test bouton [Annuler] is unavailable");
		
		// PT5 : Create a criterion - [Enregistrer] button
		page_criterions.createCriterion(driver);
		// Appel méthode pour remplir le formulaire
		page_criterionsType.fillTheForm(jdd_name_e, jdd_type, jdd_description_e);
		// Appel méthode pour enregistrer le formulaire
		page_criterionsType.toRecord(driver);
		//Vérification que le critère a été créer
		assertTrue(page_criterions.isCriterionRecordPresent(log));
		log.info( "Critère - Test bouton [Enregistrer] is present");
		
		// PT6 : Créer un critère - Accès au formulaire de création
		page_criterions.createCriterion(driver);
		
		// PT7 : Create a criterion - button [Sauver and continuer]
		page_criterionsType.fillTheForm(jdd_name_s, jdd_type, jdd_description_s);
		// Appel méthode pour sauver et continuer
		page_criterionsType.toSaveAndNext();
		
		// PT8 : Return to the criteria administration page
		page_criterionsType.toCancel(driver);	
		// Appel méthode editSave pour modifier le critere [Sauver et enregistrer]
		
		page_criterions.editSave(driver);
		// PT9 : Modify a criterion - access modification form - "Operation" column
		page_criterionsType.editTheName(jdd_name_s+" 2");
		
		// PT10 : Modify a criterion - [Annuler] button
		page_criterionsType.toCancel(driver); 
		
		// PT11 : Modify a criterion - access modification form - "Name" column
		page_criterions.editSave(driver);
		
		// PT12 : Modifier un critère - modification du nom
		page_criterionsType.editTheName(jdd_name_s+" 2");
		
		// PT13 : Modify a criterion - [Sauver et continuer] button
		page_criterionsType.toSaveAndNext();
		
		// PT14 : Return to the criteria administration page
		page_criterionsType.toCancel(driver);
		  

		// PT15 : Delete a criterion - Confirmation pop-up
		page_criterions.deleteSave(driver);
		// Vérification que la presence du message
		assertTrue(page_criterions.isMsgDeletePresent(log));
		// Vérification que la presence du bouton Ok
		assertTrue(page_criterions.isDeleteBtnOkPresent(log)); 
		// Vérification que la presence du bouton annuler
		assertTrue(page_criterions.isDeleteBtnCancelPresent(log));
		
		// PT16 : Delete a criterion - [Annuler] button
		page_criterions.deleteCritCancel(driver);
		
		// PT17 : Delete a criterion - Confirmation pop-up
		page_criterions.deleteSave(driver);
		// Vérification que la presence du message
		assertTrue(page_criterions.isMsgDeletePresent(log));
		
		// PT18 : Delete a criterion - [OK] button
		page_criterions.deleteCritOk(driver);
	}
	
}
