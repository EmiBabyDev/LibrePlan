/**
 * 
 */
package Projet_1.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageParticipant is the class of the item 'Participant'
 * 
 * @author formation
 *
 */
public class PageParticipant {
	@FindBy(xpath = "//span[text()= 'Données de base']/following::span[text()= 'Code']/following::span[text()= 'Prénom']/following::span[text()= 'Nom']/following::span[text()= 'ID']/following::span[text()= 'Type']/following::span[text()= 'Utilisateur lié']/following::label[text()= 'Non lié']/following::label[text()= 'Utilisateur existant']/following::label[text()= 'Créer un nouvel utilisateur']")
	WebElement donnees_et_utilisateur;
	@FindBy(xpath = "//td[text()='Enregistrer']")
	WebElement btn_enregistrer;
	@FindBy(xpath = "//td[text()='Sauver et continuer']")
	WebElement btn_sauver_et_continuer;
	@FindBy(xpath = "//td[text()='Sauver et continuer']/following::td[text()='Annuler'][1]")
	WebElement btn_annuler;
	@FindBy(xpath = "(//tr/td[1]/input)[1]")
	WebElement code_field;
	@FindBy(xpath = "(//div/input)[1]")
	WebElement prenom_field;
	@FindBy(xpath = "(//div/input)[3]")
	WebElement nom_field;
	@FindBy(xpath = "(//div/input)[4]")
	WebElement id_field;
	@FindBy(xpath = "(//select)[2]")
	WebElement type_field;
	@FindBy(xpath = "(//input[@type='radio'])[3]")
	WebElement radio_create_user;
	@FindBy(xpath = "(//input[@style=\"width:300px;\"])[1]")
	WebElement user_field_name;
	@FindBy(xpath = "(//input[@style=\"width:300px;\"])[2]")
	WebElement user_field_password;
	@FindBy(xpath = "(//input[@style=\"width:300px;\"])[3]")
	WebElement user_field_confirm_pswd;
	@FindBy(xpath = "//input[@style=\"width:200px;\"]")
	WebElement user_details;
	@FindBy(xpath = "//td[text()='Filtre']")
	WebElement btn_filtre;
	@FindBy(xpath = "(//input[@style=\"width:300px;\"])[4]")
	WebElement user_field_email;
	@FindBy(xpath = "//td[contains(text(),'options')]")
	WebElement btn_options;

	public PageParticipant CreateParticipant(WebDriver driver) throws InterruptedException {

		ToolBox.fillInField(prenom_field, "Jean");
		ToolBox.fillInField(nom_field, "DU");
		ToolBox.fillInField(id_field, "jdu");
		radio_create_user.click();
		ToolBox.fillInField(user_field_name, "jdu");
		ToolBox.fillInField(user_field_password, "$jdumdp1");
		ToolBox.fillInField(user_field_confirm_pswd, "$jdumdp1");
		ToolBox.fillInField(user_field_email, "jdu@test.fr");
		ToolBox.fillInField(user_details, "Jean");
		btn_filtre.click();
		btn_options.click();
		return PageFactory.initElements(driver, PageParticipant.class);
	}
}
