package Projet_1.LibrePlan;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

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
 * PageProjet is the class of the page project
 * @author formation
 *
 */
public class PageProjet {
	static Logger log = LoggerFactory.getLogger(Connexion.class);
	
	@FindBy(xpath = "//*[contains(text(), 'PROJET_TEST1')]") 
    WebElement données_nom_projet;	
	@FindBy(xpath = "//*[contains(text(), 'PRJTEST001')]") 
    WebElement données_code_projet;
	@FindBy(xpath = "//*[contains(text(),'08')]") 
    WebElement données_début_projet;
	@FindBy(xpath = "//*[contains(text(), '08')]") 
    WebElement données_fin_projet;	
	@FindBy(xpath = "//*[contains(text(), '')]") 
    WebElement données_client_projet;	
	@FindBy(xpath = "//*[contains(text(), '0 €')]") 
    WebElement données_budget_projet;
	@FindBy(xpath = "//*[contains(text(), '0')]") 
    WebElement données_heures_projet;	
	@FindBy(xpath = "//*[contains(text(), 'PRE-VENTES')]") 
    WebElement données_etat_projet;	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_editar1.png']") 
    WebElement données_modifier_projet;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_borrar1.png']") 
    WebElement données_supprimer_projet;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_planificador1.png']") 
    WebElement données_voir_prevision_projet;	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_derived1.png']") 
    WebElement données_creer_modele_projet;	
	@FindBy(xpath = "//td[text()= 'Détail du projet']")
    WebElement détail_projet;
	@FindBy(xpath = "//span[text()= 'Nouvelle tâche']")
    WebElement wbs_projet1;
	@FindBy(xpath = "//td[text()= 'Planification de projet']")
    WebElement plan_projet;
	@FindBy(xpath = "//td[text()= 'Chargement des ressources']")
    WebElement chargement_projet;
	@FindBy(xpath = "//td[text()= 'Allocation avancée']")
    WebElement allocation_projet;
	@FindBy(xpath = "//td[text()= 'Tableau de bord']")
    WebElement tableau_projet;
	@FindBy(xpath = "//span[contains(text(),'WBS (tâches)')]")
    WebElement wbs_projet;
	@FindBy(xpath = "//span[contains(text(),'Données générales')]")
    WebElement donnees_projet;
	@FindBy(xpath = "//span[contains(text(),'Coût')]")
    WebElement cout_projet;
	@FindBy(xpath = "//span[contains(text(),'Avancement')]")
    WebElement avancement_projet;
	@FindBy(xpath = "//span[contains(text(),'Libellés')]")
    WebElement libelles_projet;
	@FindBy(xpath = "//span[contains(text(),'Exigence de critère')]")
    WebElement exigence_projet;
	@FindBy(xpath = "//span[text()= 'Matériels']")
    WebElement mat_projet;
	@FindBy(xpath = "//span[contains(text(),'Formulaires qualité des tâches')]")
    WebElement form_projet;
	@FindBy(xpath = "//span[contains(text(),'Autorisation')]")
    WebElement aut_projet;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_save.png']")
    WebElement enregistrer_projet;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_back.png']")
    WebElement annuler_projet;
	@FindBy(xpath = "//td[text()= 'OK']")
    WebElement ok_pop_annuler_projet;
	@FindBy(xpath = "//*[text()= 'OK']/following::td[text()= 'Annuler']")
    WebElement annuler_pop_annuler_projet;
	@FindBy(xpath = "//*[text()= 'Calendrier']/preceding::*[text()= 'DEBUT']")
    WebElement debut_ariane;
	@FindBy(xpath = "//*[text()= 'Détail du projet']/preceding::span[text()= 'Calendrier']")
    WebElement calendrier_ariane;
	@FindBy(xpath = "//*[text()= 'PROJET_TEST1']/preceding::span[text()= 'Détail du projet']")
    WebElement detail_ariane;
	@FindBy(xpath = "//*[text()= 'Détail du projet']/following::span[text()= 'PROJET_TEST1']")
    WebElement nom_ariane;
	@FindBy(xpath = "//input[@style = 'width:150px;']")
    WebElement nouvelle_tache;
	@FindBy(xpath = "//input[@style = 'width:40px;']")
    WebElement champ_heures;
	@FindBy(xpath = "//input[@style = 'width:40px;']/following::table[1]")
    WebElement btn_ajouter;
	@FindBy(xpath = "(//span[@class='scheduling-state z-label'])[1]")
    WebElement drag1;
	@FindBy(xpath = "(//span[@class='scheduling-state z-label'])[2]")
    WebElement drag2;
	@FindBy(xpath = "(//span[@class='scheduling-state z-label'])[3]")
    WebElement drag3;
	@FindBy(xpath = "(//span[@class='scheduling-state z-label'])[4]")
    WebElement drag4;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_bajar1.png']")
    WebElement fleche_bas;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_subir1.png']")
    WebElement fleche_haut;
	@FindBy(xpath = "//*[contains(@title, 'Tache1-P1')]")
    WebElement select1;
	@FindBy(xpath = "//*[contains(@title, 'Tache2-P1')]")
    WebElement select2;
	@FindBy(xpath = "//*[contains(@title, 'Tache3-P1')]")
    WebElement select3;
	@FindBy(xpath = "//*[contains(@title, 'Tache4-P1')]")
    WebElement select4;
	@FindBy(xpath = "//*[contains(@title, 'Tache1-P1')]/descendant::input[1]")
    WebElement code1;
	@FindBy(xpath = "//*[contains(@title, 'Tache2-P1')]/descendant::input[1]")
    WebElement code2;
	@FindBy(xpath = "//*[contains(@title, 'Tache3-P1')]/descendant::input[1]")
    WebElement code3;
	@FindBy(xpath = "//*[contains(@title, 'Tache4-P1')]/descendant::input[1]")
    WebElement code4;
	@FindBy(xpath = "//tr[contains(@title, 'Tache1-P1')]/descendant::input[@style = 'width:110px;'][1]")
    WebElement date_début1;
	@FindBy(xpath = "//tr[contains(@title, 'Tache2-P1')]/descendant::input[@style = 'width:110px;'][1]")
    WebElement date_début2;
	@FindBy(xpath = "//*[contains(@title, 'Tache3-P1')]/descendant::input[@style = 'width:110px;'][1]")
    WebElement date_début3;
	@FindBy(xpath = "//*[contains(@title, 'Tache4-P1')]/descendant::input[@style = 'width:110px;'][1]")
    WebElement date_début4;
	@FindBy(xpath = "//tr[contains(@title, 'Tache1-P1')]/descendant::input[@style = 'width:110px;'][2]")
    WebElement date_fin1;
	@FindBy(xpath = "//tr[contains(@title, 'Tache2-P1')]/descendant::input[@style = 'width:110px;'][2]")
    WebElement date_fin2;
	@FindBy(xpath = "//*[contains(@title, 'Tache3-P1')]/descendant::input[@style = 'width:110px;'][2]")
    WebElement date_fin3;
	@FindBy(xpath = "//*[contains(@title, 'Tache4-P1')]/descendant::input[@style = 'width:110px;'][2]")
    WebElement date_fin4;
	@FindBy(xpath = "//ul/descendant::span[contains(text(),'WBS (tâches)')]/following::span[contains(text(),'Données générales')]/following::span[text() ='Coût']/following::span[contains(text(),'Avancement')]/following::span[contains(text(),'Libellés')]/following::span[contains(text(),'Exigence de critère')]//following::span[contains(text(),'Matériels')]/following::span[contains(text(),'Formulaires qualité des tâches')]/following::span[contains(text(),'Autorisation')]")
    WebElement ordre_chrono_horizontal;
	@FindBy(xpath = "//table/following::td[text()= 'Planification de projet']/following::td[text()= 'Détail du projet']/following::td[text()= 'Chargement des ressources']/following::td[text()= 'Allocation avancée']/following::td[text()= 'Tableau de bord']")
    WebElement ordre_chrono_vertical;
	
	/**
	 * fillCodes() is the method of filling code fields
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet fillCodes(WebDriver driver) throws InterruptedException {
		try {
		ToolBox.fillInField(code1, "T1");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex){
			ToolBox.fillInField(code1, "T1");
		}
		try {
		ToolBox.fillInField(code2, "T2");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex){
			ToolBox.fillInField(code2, "T2");
		}
		try {
		ToolBox.fillInField(code3, "T3");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex){
			ToolBox.fillInField(code3, "T3");
		}
		try {
		ToolBox.fillInField(code4, "T4");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex){
			ToolBox.fillInField(code4, "T4");
		}
		/*
		ToolBox.fillInField(code3, "T3");
		ToolBox.fillInField(code4, "T4");*/
		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * fillDates() is the method of filling deta fields
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
public PageProjet fillDates(WebDriver driver) throws InterruptedException {
		
		Calendar c = Calendar.getInstance();
		Integer month=c.get(Calendar.MONTH)+1;
		Integer year=c.get(Calendar.YEAR);
		
		String stmonth= month.toString();
		String styear= year.toString();

		ToolBox.fillInField(date_début1, "05/"+stmonth+"/"+styear);
		ToolBox.fillInField(date_début2, "08/"+stmonth+"/"+styear);
		/*ToolBox.fillInField(dateDébut3, "");
		ToolBox.fillInField(dateDébut4, "");
		ToolBox.fillInField(dateFin1, "T1");
		ToolBox.fillInField(dateFin2, "T2");*/
		ToolBox.fillInField(date_fin3, "03/"+stmonth+"/"+styear);
		ToolBox.fillInField(date_fin4, "08/"+stmonth+"/"+styear);
		enregistrer_projet.click();
		driver.findElement(By.xpath("//td[contains(text(),'OK')]")).click();
		plan_projet.click();
		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * moveElements() is the method of moving elements
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
public PageProjet moveElements(WebDriver driver) throws InterruptedException {
	
	select1.click();
	select1.click();
	Thread.sleep(2000);
	fleche_bas.click();
	/*assertEquals(select1, drag2);
	log.info("1=2");*/
	Thread.sleep(2000);
	select3.click();
	Thread.sleep(2000);
	fleche_haut.click();
	//assertEquals(select3, drag2);
	return PageFactory.initElements(driver, PageProjet.class);
}
	
	/**
	 * creaTache1() is the method of creating task 1
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
public PageProjet creaTache1(WebDriver driver) throws InterruptedException {
	
	ToolBox.fillInField(nouvelle_tache, "Tache1-P1");
	ToolBox.fillInField(champ_heures, "5");
	btn_ajouter.click();
	log.info("tache 1 créée");
	return PageFactory.initElements(driver, PageProjet.class);
}
	
	/**
	 * creaTache234() is the method of creating task 2, 3 and 4
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
public PageProjet creaTache234(WebDriver driver) throws InterruptedException {
	
	ToolBox.fillInField(nouvelle_tache, "Tache2-P1");
	ToolBox.fillInField(champ_heures, "10");
	btn_ajouter.click();
	Thread.sleep(2000);
	ToolBox.fillInField(nouvelle_tache, "Tache3-P1");
	ToolBox.fillInField(champ_heures, "20");
	btn_ajouter.click();
	Thread.sleep(2000);
	ToolBox.fillInField(nouvelle_tache, "Tache4-P1");
	ToolBox.fillInField(champ_heures, "8");
	btn_ajouter.click();
	log.info("taches 2,3,4 créées");
	return PageFactory.initElements(driver, PageProjet.class);
}

	
	/**
	 * ordreChrono() is the method of checking sorting in chronological order
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
public PageProjet ordreChrono(WebDriver driver) throws InterruptedException {
	
	assertTrue(driver.findElement(By.xpath("//input[@value='5']/following::input[@value='10']/following::input[@value='20']/following::input[@value='8']")).isDisplayed());
	log.info("Elements présents en ordre chrono");

	return PageFactory.initElements(driver, PageProjet.class);
}
	
	/**
	 * verifCrea() is the method of checking the creation of tasks
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet verifCrea(WebDriver driver) throws InterruptedException {
		
		assertTrue(détail_projet.isDisplayed());
		assertTrue(wbs_projet1.isDisplayed());

		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * verifMenuVertical() is the vertical menu verification method
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet verifMenuVertical(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ordre_chrono_vertical));
		//Chemin xPath choisi ne peut retourner true que si l'ordre est respecté
		assertTrue(ordre_chrono_vertical.isDisplayed());
//		assertTrue(DétailProjet.isDisplayed());
//		assertTrue(PlanProjet.isDisplayed());
//		assertTrue(ChargementProjet.isDisplayed());
//		assertTrue(AllocationProjet.isDisplayed());
//		assertTrue(TableauProjet.isDisplayed());

		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * verifMenuHorizontal() is the horizontal menu verification method
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet verifMenuHorizontal(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(donnees_projet));
		//Chemin xPath choisi ne peut retourner true que si l'ordre est respecté
		assertTrue(ordre_chrono_horizontal.isDisplayed());
//		assertTrue(WBSProjet.isDisplayed());
//		assertTrue(DonneesProjet.isDisplayed());
//		assertTrue(CoutProjet.isDisplayed());
//		assertTrue(AvancementProjet.isDisplayed());
//		assertTrue(LibellesProjet.isDisplayed());
//		assertTrue(ExigenceProjet.isDisplayed());
//		assertTrue(MatProjet.isDisplayed());
//		assertTrue(FormProjet.isDisplayed());
//		assertTrue(AutProjet.isDisplayed());

		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * verifMenuHorizontalAbsent() is the horizontal menu absence check method
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet verifMenuHorizontalAbsent(WebDriver driver) throws InterruptedException {	
		assertFalse(wbs_projet.isDisplayed());
		assertFalse(donnees_projet.isDisplayed());
		assertFalse(cout_projet.isDisplayed());
		assertFalse(avancement_projet.isDisplayed());
		assertFalse(libelles_projet.isDisplayed());
		assertFalse(exigence_projet.isDisplayed());
		assertFalse(mat_projet.isDisplayed());
		assertFalse(form_projet.isDisplayed());
		assertFalse(aut_projet.isDisplayed());
		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * verifBoutonProjet() is the method of checking the visibility of project buttons
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet verifBoutonsProjet(WebDriver driver) throws InterruptedException {
		assertTrue(enregistrer_projet.isDisplayed());
		assertTrue(annuler_projet.isDisplayed());
		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	/**
	 * utiliserBoutonProjet() is the method of playing the project buttons
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageAccueil utiliserBoutonsProjet(WebDriver driver) throws InterruptedException {
		
		annuler_projet.click();
		assertTrue(annuler_pop_annuler_projet.isDisplayed());
		assertTrue(ok_pop_annuler_projet.isDisplayed());
		annuler_pop_annuler_projet.click();
		assertTrue(annuler_projet.isDisplayed());
		assertTrue(enregistrer_projet.isDisplayed());
		annuler_projet.click();
		assertTrue(annuler_pop_annuler_projet.isDisplayed());
		assertTrue(ok_pop_annuler_projet.isDisplayed());
		ok_pop_annuler_projet.click();

		return PageFactory.initElements(driver, PageAccueil.class);
	}

	/**
	 * verifDonneesProjets() is the method of checking data visibility
	 * @param driver
	 * @throws java.lang.InterruptedException
	 * @return instantiating the project page
	 */
	public PageProjet verifDonneesProjets(WebDriver driver) throws InterruptedException {
		
		assertTrue(données_nom_projet.isDisplayed());
		assertTrue(données_code_projet.isDisplayed());
		assertTrue(données_début_projet.isDisplayed());
		assertTrue(données_fin_projet.isDisplayed());
		assertTrue(données_client_projet.isDisplayed());
		assertTrue(données_budget_projet.isDisplayed());
		assertTrue(données_heures_projet.isDisplayed());
		assertTrue(données_etat_projet.isDisplayed());
		assertTrue(données_modifier_projet.isDisplayed());
		assertTrue(données_supprimer_projet.isDisplayed());
		assertTrue(données_voir_prevision_projet.isDisplayed());
		assertTrue(données_creer_modele_projet.isDisplayed());

		return PageFactory.initElements(driver, PageProjet.class);
	}
	
	//*[contains(text(), 'PROJET_TEST1' and 'PRJTEST001' and '' and'' and'' and'0€' and'0' and 'PRE-VENTES')]

}
