package Projet_1.LibrePlan;

import java.util.ArrayList;
import java.util.List;

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
 * PageCriterions is the class of Criterion Page
 * @author formation
 *
 */
public class PageCriterions {
	WebDriver driver;
	Logger log = LoggerFactory.getLogger(PageLogin.class);

	@FindBy(xpath = "//*[contains(@class,'z-window-embedded-header')][contains(.,'Types de critères Liste')]")
	WebElement title_page_criterions;
	@FindBy(xpath = "//*[@class= 'z-button-cm'][contains(.,'Créer')]")
	WebElement btn_create;
	@FindBy(xpath = "//span[text() = 'Critère - Test bouton [Sauver et continuer] 2']/following::img[@src='/libreplan/common/img/ico_borrar1.png'][1]")
	WebElement btn_icon_trash;
	@FindBy(xpath = "//span[text() = 'Critère - Test bouton [Sauver et continuer]']/following::img[@src='/libreplan/common/img/ico_editar1.png'][1]")
	WebElement btn_icon_edit;
	@FindBy(xpath = "//span[contains(.,'Critère - Test bouton [Sauver et continuer]')]/ancestor::td[@class='z-row-inner']")
	WebElement link_edit;
	@FindBy(xpath = "//*[contains(@class,'z-label')][contains(@title,'Critère - Test bouton [Annuler]')]")
	WebElement text_label_cancel;
	@FindBy(xpath = "//*[contains(@class,'z-label')][contains(@title,'Critère - Test bouton [Enregistrer]')]")
	WebElement text_label_record;
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(.,'OK')]")
	WebElement btn_mbox_trash_ok;
	@FindBy(xpath = "//span[contains(@class,'z-messagebox-btn')]/table/tbody/tr/td[@class='z-button-cm'][contains(.,'Annuler')]")
	WebElement btn_mbox_trash_cancel;
	@FindBy(xpath = "//span[contains(.,'Supprimer Type de critère \"Critère - Test bouton [Sauver et continuer] 2\". Êtes-vous sûr ?')]")
	WebElement msg_suppr;

	/**
	 * isTitleCriterions() is the method of checking the title
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isTitleCriterions(Logger log) {
		return ToolBox.isElementPresent(title_page_criterions, log);
	}

	/**
	 * createCriterion() is the method of creating criterion
	 * @param driver
	 * @return PageCriterionsType
	 */
	public PageCriterionsType createCriterion(WebDriver driver) {
		btn_create.click();
		return PageFactory.initElements(driver, PageCriterionsType.class);
	}

	/**
	 * editSaven() is the method of editing criterion by button
	 * @param driver
	 * @return PageCriterionsType
	 */
	public PageCriterionsType editSave(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(btn_icon_edit));
		btn_icon_edit.click();
		return PageFactory.initElements(driver, PageCriterionsType.class);
	}

	/**
	 * editSaveByLink() is the method of editing criterion by link
	 * @param driver
	 * @return PageCriterionsType
	 */
	public PageCriterionsType editSaveByLink(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(link_edit));
		link_edit.click();
		return PageFactory.initElements(driver, PageCriterionsType.class);
	}

	/**
	 * deleteSave() is the method of delete the element saved
	 * @param driver
	 */
	public void deleteSave(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(btn_icon_trash));
		btn_icon_trash.click();
	}

	/**
	 * deleteCritCancel() is the method to click on the cancel button of the delete box message
	 * @param driver
	 */
	public void deleteCritCancel(WebDriver driver) {
		btn_mbox_trash_cancel.click();
	}

	/**
	 * deleteCritOk() is the method to click on the accept button of the delete box message
	 * @param driver
	 */
	public void deleteCritOk(WebDriver driver) {
		btn_mbox_trash_ok.click();
	}

	/**
	 * isMsgDeletePresent() is the method to control the presence of delete message
	 * @param log
	 * @return boolean ToolBox method
	 * 
	 */
	public boolean isMsgDeletePresent(Logger log) {
		return ToolBox.isElementPresent(msg_suppr, log);
	}

	/**
	 * isMsgDeletePresent() is the method to control the presence of the box message button ok
	 * @param log
	 * @return boolean ToolBox method
	 * 
	 */
	public boolean isDeleteBtnOkPresent(Logger log) {
		return ToolBox.isElementPresent(btn_mbox_trash_ok, log);
	}

	/**
	 * isMsgDeletePresent() is the method to control the presence of the box message button cancel
	 * @param log
	 * @return boolean ToolBox method
	 * 
	 */
	public boolean isDeleteBtnCancelPresent(Logger log) {
		return ToolBox.isElementPresent(btn_mbox_trash_cancel, log);
	}

	/**
	 * isCriterionCancelPresent() is the method to control the presence of the cancel label
	 * @param log
	 * @return boolean 
	 * 
	 */
	public boolean isCriterionCancelPresent(Logger log) {
		try {
			text_label_cancel.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * isCriterionCancelPresent() is the method to control the presence of the record label
	 * @param log
	 * @return boolean
	 * 
	 */
	public boolean isCriterionRecordPresent(Logger log) {
		try {
			text_label_record.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
