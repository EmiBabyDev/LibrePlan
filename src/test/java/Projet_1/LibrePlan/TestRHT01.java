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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRHT01 {
	String JDD_LOGIN = "admin";
	String JDD_PASSWORD = "admin";
	static Logger log = LoggerFactory.getLogger(Connexion.class);
	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp() throws Exception {
		driver = ToolBox.chooseBrowser(log, EBrowser.c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5000);
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
		// log.info("QUIT DRIVER");
	}

	@Test
	public void testDriverConnect() {

		driver.get("http://localhost:8090/libreplan/");
		assertTrue(driver.findElement(By.xpath("//img[@alt = 'LibrePlan']")).isDisplayed());
		log.info("LIBREPLAN IS OPEN !");

		log.info("USER CONNECT");

		// Instanciation PageLogin
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);

		// Appel méthode toLogin() --> instanciation PaeIndex
		PageIndex page_index = page_login.toLogIn(driver, JDD_LOGIN, JDD_PASSWORD);

		// Appel méthode clicFeuilleDeTemps() --> instanciation PageListeFeuillesDeTemps
		PageListeFeuilleDeTemps page_bandeau = page_index.clicFeuilleDeTemps(driver);

		// Vérification affichage page "Liste des feuilles de temps"
		WebElement titre = driver.findElement(By.xpath("//div[contains(.,'Liste des feuilles de temps')]"));

		// un tableau avec 6 colonnes
		// String col1 =
		// driver.findElement(By.xpath("//th[1][contains(@class,'z-column-sort')]/div[contains(@class,'z-column-cnt')]")).getText();
		List<WebElement> liste_colonnes_tri = driver
				.findElements(By.xpath("//th[contains(@class,'z-column-sort')]/div[contains(@class,'z-column-cnt')]"));
		assertFalse(liste_colonnes_tri.isEmpty());
		assertEquals(4, liste_colonnes_tri.size());
		WebElement col5 = driver.findElement(By.xpath("//th[@class='z-column']/div[contains(.,'Code')]"));
		WebElement col6 = driver.findElement(By.xpath("//th[@class='z-column']/div[contains(.,'Actions')]"));
		assertTrue(col5.isDisplayed());
		assertTrue(col6.isDisplayed());
		// des champs permettant de filtrer l'affichage des feuilles de temps situés
		// au-dessus du tableau
		WebElement champ_filtre_Modele = driver
				.findElement(By.xpath("//span[contains(.,'Filtrer la feuille de temps par:')]"));
		WebElement champ_filtre_Modele_2 = driver.findElement(By.xpath("//span[contains(.,'Modèle')]"));
		WebElement champ_filtre_saisie_modele = driver
				.findElement(By.xpath("//tbody/tr[@valign='middle']/td[5]/select/option[@selected='selected']"));
		WebElement etiq_de = driver.findElement(By.xpath("//tbody/tr[@valign='middle']/td[7]"));
		WebElement zone_date_de = driver.findElement(
				By.xpath("//tbody/tr[@valign='middle']/td[9]/i[@class='z-datebox']/input[@class='z-datebox-inp']"));
		assertTrue(zone_date_de.isDisplayed());
		WebElement etiq_a = driver.findElement(By.xpath("//tbody/tr[@valign='middle']/td[11]"));
		WebElement zone_date_a = driver.findElement(
				By.xpath("//tbody/tr[@valign='middle']/td[13]/i[@class='z-datebox']/input[@class='z-datebox-inp']"));
		assertTrue(zone_date_a.isDisplayed());
		WebElement btn_filtre = driver
				.findElement(By.xpath("//tbody/tr[@valign='middle']/td[15]/span[@class='z-button']"));
		assertTrue(btn_filtre.isDisplayed());
		// des champs permettant de créer une nouvelle feuille de temps
		WebElement filtre_choix_canevas_default = driver
				.findElement(By.xpath("//tbody/tr[@valign='middle']/td[3]/select/option[@selected='selected']"));
		WebElement btn_nouv_feuille_temps = driver
				.findElement(By.xpath("//tbody/tr[@valign='middle']/td[5]/span[@class='z-button']"));
		// Ajouter une ligne de feuille de temps
		btn_nouv_feuille_temps.click();
		// Résultat : Affichage de la page "Créer la feuille de temps" contenant
		// 3 blocs composés des éléments
		WebElement bloc_donnees_generales = driver
				.findElement(By.xpath("//tbody/tr[1]/td/fieldset/legend[contains(@class,'z-caption-readonly')]/span"));
		WebElement champ_saisie_code = driver
				.findElement(By.xpath("//tbody/tr/td[1]/input[contains(@class,'z-textbox')]"));
		assertTrue(champ_saisie_code.isEnabled());
		WebElement case_generer_code = driver.findElement(By.xpath("//tbody/tr/td[3]/span[@class='z-checkbox']/input"));
		assertTrue(case_generer_code.isEnabled());
		WebElement bloc_champs_rubrique = driver.findElement(By.xpath("//table/tbody/tr[3]/td/fieldset/legend/span"));
		assertTrue(bloc_champs_rubrique.isDisplayed());
		WebElement bloc_lignes_feuilles_de_temps = driver
				.findElement(By.xpath("//table/tbody/tr[7]/td/fieldset/legend/span"));
		assertTrue(bloc_lignes_feuilles_de_temps.isDisplayed());

		List<WebElement> liste_colonnes_feuilles_temps = driver
				.findElements(By.xpath("//div[contains(@class,'listWorkReportLines')]/div/table/tbody[2]/tr[1]/th"));

		ArrayList<String> liste_col_ft = new ArrayList<String>();
		ArrayList<String> jdd_liste_col_ft = new ArrayList<String>();

		for (WebElement l : liste_colonnes_feuilles_temps) {
			liste_col_ft.add(l.getText());
		}

		jdd_liste_col_ft.add("Date");
		jdd_liste_col_ft.add("Ressource");
		jdd_liste_col_ft.add("Tâche");
		jdd_liste_col_ft.add("Heures");
		jdd_liste_col_ft.add("Type d'heures");
		jdd_liste_col_ft.add("Réalisé");
		jdd_liste_col_ft.add("Code");
		jdd_liste_col_ft.add("Op.");
		assertEquals(jdd_liste_col_ft, liste_col_ft);

		WebElement tableau_feuilles_temps = driver
				.findElement(By.xpath("//tbody/tr[7]/td/fieldset/div/div/div[3]/table/tbody[1]"));
		assertFalse(tableau_feuilles_temps.isDisplayed());

		// les boutons [Enregistrer], [Sauver et continuer], [Sauvegarder & Nouvelle
		// feuille de temps] et [Annuler]
		List<WebElement> liste_btns_crea_feuille_temps = driver
				.findElements(By.xpath("//span[contains(@class,'global-action')]//td[contains(@class,'z-button-cm')]"));
		ArrayList<String> liste_btns_crea_ft = new ArrayList<String>();
		ArrayList<String> jdd_liste_btns_crea_feuille_temps = new ArrayList<String>();
		for (WebElement l : liste_btns_crea_feuille_temps) {
			liste_btns_crea_ft.add(l.getText());
		}
		jdd_liste_btns_crea_feuille_temps.add("Enregistrer");
		jdd_liste_btns_crea_feuille_temps.add("Sauver et continuer");
		jdd_liste_btns_crea_feuille_temps.add("Sauvegarder & Nouvelle feuille de temps");
		jdd_liste_btns_crea_feuille_temps.add("Annuler");
		assertEquals(jdd_liste_btns_crea_feuille_temps, liste_btns_crea_ft);

		WebElement btn_ajout_ligne = driver
				.findElement(By.xpath("//td[(@class='z-button-cm')and(.='Ajouter une ligne')]"));
		btn_ajout_ligne.click();

	}

}
