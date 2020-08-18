package Projet_1.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * BandeauMenu is the class representing the elements common to each page
 * @author formation
 *
 */
public abstract class BandeauMenu {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(@id, 'Q7-b')][contains(.,'Calendrier')]")
	WebElement ongl_calendrier;
	@FindBy(xpath = "//button[@class = 'z-menu-btn' and contains(.,'Ressources')]")
	WebElement ongl_ressources;
	@FindBy(xpath = "//a[contains(@href, '/libreplan/advance/advanceTypes.zul')]")
	WebElement item_advance;
	@FindBy(xpath = "//a[contains(@href,'/criterions')]")
	WebElement item_critere;
	@FindBy(xpath = "//a[contains(@href,'/worker/worker.zul')]")
	WebElement item_participant;
	@FindBy(xpath = "//a[contains(@href,'/machines.zul')]")
	WebElement item_machine;
	@FindBy(xpath = "//button[contains(@class, '')][contains(.,'Coût')]")
	WebElement ongl_cout;
	@FindBy(xpath = "//a[contains(@id, 'r0-a')]")
	WebElement item_feuille_de_temps;
	
	
	/**
	 * clickParticipant() is the access method to the participant item
	 * @param driver
	 * @return instantiating PageParticipant
	 */
	public PageParticipant clickParticipant(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(ongl_ressources).build().perform();
		item_participant.click();
		return PageFactory.initElements(driver, PageParticipant.class);
	}
	
	/**
	 * clickMachine() is the access method to the machine item
	 * @param driver
	 * @return instantiating PageMachine
	 */
	public PageMachine clickMachine(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(ongl_ressources).build().perform();
		item_machine.click();
		return PageFactory.initElements(driver, PageMachine.class);
	}
	
	/**
	 * clickCriterions() is the access method to the machine item
	 * @param driver
	 * @return instantiating PageCriterions
	 */
	public PageCriterions clicCriterions(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(ongl_ressources).build().perform();
		item_critere.click();
		return PageFactory.initElements(driver, PageCriterions.class);
	}
	
	/**
	 * clickAdvance() is the access method to the advance item
	 * @param driver
	 * @return instantiating PageAvancement
	 */
	public PageAvancement clickAdvance(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(ongl_ressources).build().perform();
		item_advance.click();
		return PageFactory.initElements(driver, PageAvancement.class);
	}

	public PageListeFeuilleDeTemps clicFeuilleDeTemps(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(ongl_cout).build().perform();
		item_feuille_de_temps.click();
		return PageFactory.initElements(driver, PageListeFeuilleDeTemps.class);
	}

}
