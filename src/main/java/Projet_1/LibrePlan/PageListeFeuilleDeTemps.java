package Projet_1.LibrePlan;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageListeFeuilleDeTemps extends BandeauMenu {

	// Vérification affichage page "Liste des feuilles de temps"
	@FindBy(xpath = "//div[contains(.,'Liste des feuilles de temps')]")
	WebElement titre;

	@FindBy(xpath = "//th[contains(@class,'z-column-sort')]/div[contains(@class,'z-column-cnt')]")
	List<WebElement> liste_colonnes_tri;

	// assertFalse(liste_colonnes_tri.isEmpty());
	// assertEquals(4, liste_colonnes_tri.size());
	@FindBy(xpath = "//th[@class='z-column']/div[contains(.,'Code')]")
	WebElement col5;
	@FindBy(xpath = "//th[@class='z-column']/div[contains(.,'Actions')]")
	WebElement col6;

	// des champs permettant de filtrer l'affichage des feuilles de temps situés
	// au-dessus du tableau

	@FindBy(xpath = "//span[contains(.,'Filtrer la feuille de temps par:')]")
	WebElement champ_filtre_Modele;

	@FindBy(xpath = "//span[contains(.,'Modèle')]")
	WebElement champ_filtre_Modele_2;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[5]/select/option[@selected='selected']")
	WebElement champ_filtre_saisie_modele;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[7]")
	WebElement etiq_de;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[9]/i[@class='z-datebox']/input[@class='z-datebox-inp']")
	WebElement zone_date_de;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[11]")
	WebElement etiq_a;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[13]/i[@class='z-datebox']/input[@class='z-datebox-inp']")
	WebElement zone_date_a;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[15]/span[@class='z-button']")
	WebElement btn_filtre;

	// Des champs permettant de créer une nouvelle feuille de temps
	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[3]/select/option[@selected='selected']")
	WebElement filtre_choix_canevas_default;

	@FindBy(xpath = "//tbody/tr[@valign='middle']/td[5]/span[@class='z-button']")
	WebElement btn_nouv_feuille_temps;

	// Ajouter une ligne de feuille de temps
	public PageCreerFeuilleTemps clicCreerFeuilleTemps() {
		btn_nouv_feuille_temps.click();
		return PageFactory.initElements(driver, PageCreerFeuilleTemps.class);
	}
	
	public boolean isPageListeFeuilleTempsAffichee() {
		return titre.isDisplayed()&&
				col5.isDisplayed()&&
				col6.isDisplayed()&&
				champ_filtre_Modele.isDisplayed()&&
				champ_filtre_Modele_2.isDisplayed()&&
				champ_filtre_saisie_modele.isDisplayed()&&
				etiq_de.isDisplayed()&&
				zone_date_de.isDisplayed()&&
				etiq_a.isDisplayed()&&
				zone_date_a.isDisplayed()&&
				btn_filtre.isDisplayed()&&
				filtre_choix_canevas_default.isDisplayed();
	}

}
