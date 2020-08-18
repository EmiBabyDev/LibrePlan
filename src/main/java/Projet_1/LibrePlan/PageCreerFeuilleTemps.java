package Projet_1.LibrePlan;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCreerFeuilleTemps extends BandeauMenu{

	@FindBy(xpath = "//tbody/tr[1]/td/fieldset/legend[contains(@class,'z-caption-readonly')]/span")
	WebElement bloc_donnees_generales;

	@FindBy(xpath = "//tbody/tr/td[1]/input[contains(@class,'z-textbox')]")
	WebElement champ_saisie_code;

	@FindBy(xpath = "//tbody/tr/td[3]/span[@class='z-checkbox']/input")
	WebElement case_generer_code;

	@FindBy(xpath = "//table/tbody/tr[3]/td/fieldset/legend/span")
	WebElement bloc_champs_rubrique;

	@FindBy(xpath = "//table/tbody/tr[7]/td/fieldset/legend/span")
	WebElement bloc_lignes_feuilles_de_temps;

	@FindBy(xpath = "//div[contains(@class,'listWorkReportLines')]/div/table/tbody[2]/tr[1]/th")
	List<WebElement> liste_colonnes_feuilles_temps;

	@FindBy(xpath = "//span[contains(@class,'global-action')]//td[contains(@class,'z-button-cm')]")
	WebElement tableau_feuilles_temps;

	@FindBy(xpath = "//tbody/tr[7]/td/fieldset/div/div/div[3]/table/tbody[1]")
	List<WebElement> liste_btns_crea_feuille_temps;

	@FindBy(xpath = "//td[(@class='z-button-cm')and(.='Ajouter une ligne)]")
	WebElement btn_ajout_ligne;

	public boolean isListeCreerFtPresent() {
		return bloc_donnees_generales.isDisplayed() && champ_saisie_code.isDisplayed()
				&& case_generer_code.isDisplayed() && bloc_champs_rubrique.isDisplayed()
				&& bloc_lignes_feuilles_de_temps.isDisplayed() && tableau_feuilles_temps.isDisplayed();
	}

	public boolean isListeColonnesFtPresent(ArrayList<String> liste_ref) {
		ArrayList<String> liste_col_ft = new ArrayList<String>();
		for (WebElement l : liste_colonnes_feuilles_temps) {
			liste_col_ft.add(l.getText());
		}
		return liste_ref == liste_col_ft;
	}

	public boolean isListebBtnsCreaFtPresent(ArrayList<String> liste_ref) {
		ArrayList<String> liste_btns_crea_ft = new ArrayList<String>();
		for (WebElement l : liste_btns_crea_feuille_temps) {
			liste_btns_crea_ft.add(l.getText());
		}
		return liste_ref == liste_btns_crea_ft;
	}

	// Ajouter une ligne de feuille de temps
	public void clicAjoutLigneFeuilleTemps() {
		btn_ajout_ligne.click();
	}

}
