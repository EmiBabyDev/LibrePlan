package Projet_1.LibrePlan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PageCriterions is the class of Criterion type
 * @author formation
 *
 */
public class PageCriterionsType {
	WebDriver driver;
	Logger log = LoggerFactory.getLogger(PageLogin.class);

	@FindBy(xpath = "//input[@style='width:390px;']")
	WebElement field_name;
	@FindBy(xpath = "//textarea[@class='z-textbox']")
	WebElement field_description;
	@FindBy(xpath = "//*[contains(@class,'z-combobox-btn')]")
	WebElement menu_type;
	@FindBy(xpath = "//td[contains(text(),'PARTICIPANT')]")
	WebElement type_participant;
	@FindBy(xpath = "//td[contains(text(),'MACHINE')]")
	WebElement type_machine;
	@FindBy(xpath = "//*[@type='checkbox'][contains(@id, 'k5-real')]")
	WebElement check_value;
	@FindBy(xpath = "//*[@type='checkbox'][contains(@id, 'n5-real')]")
	WebElement check_hierarchy;
	@FindBy(xpath = "//*[@type='checkbox'][contains(@id, 'q5-real')]")
	WebElement check_activ;
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(.,'Annuler')]")
	WebElement btn_cancel;
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(text(),'Enregistrer')]")
	WebElement btn_record;
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(text(),'Sauver et continuer')]")
	WebElement btn_save;
	@FindBy(xpath = "//*[contains(@class,'z-caption-l')][contains(.,'Créer Type de critère')]")
	WebElement title_create_crit;
	@FindBy(xpath = "//*[contains(@class,'z-tab-text')][contains(.,'Modifier')]")
	WebElement edit_tab;

	/**
	 * isTitleCreateCriterions() is the method of checking the title
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isTitleCreateCriterions(Logger log){	
		return ToolBox.isElementPresent(title_create_crit, log);	
	}
	
	/**
	 * isBtnCancel() is the method of checking the cancel button
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isBtnCancel(Logger log){	
		return ToolBox.isElementPresent(btn_cancel, log);	
	}
	
	/**
	 * isBtnSave() is the method of checking the save button
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isBtnSave(Logger log){	
		return ToolBox.isElementPresent(btn_save, log);	
	}
	
	/**
	 * isBtnRecord() is the method of checking the record button
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isBtnRecord(Logger log){	
		return ToolBox.isElementPresent(btn_record, log);	
	}
	
	/**
	 * isEditTab() is the method of checking the title
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isEditTab(Logger log){	
		return ToolBox.isElementPresent(edit_tab, log);	
	}
	
	/**
	 * editTheName() is the method of editing the name field
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public void editTheName(String n) {
		ToolBox.fillInField(field_name, n);
	}

	/**
	 * fillTheForm() is the method of filling in the criterion form
	 * @param n type d
	 */
	public void fillTheForm(String n, String type, String d) {
		ToolBox.fillInField(field_name, n);
		ToolBox.fillInField(field_description, d);
		// Select participant in the type drop-down menu
		menu_type.click();
		type_participant.click();
		// Condition on the value check box 
		if (!check_value.isSelected()) {
			check_value.click();
		} 
		// Condition on the hierarchy checkbox
		if (!check_hierarchy.isSelected()) {
			check_hierarchy.click();
		}
		// Condition on the activ check box
		if (!check_activ.isSelected()) {
			check_activ.click();
		}
	
	}
	
	/**
	 * toCancel() is the method of playing button cancel
	 * @param driver
	 * @return instantiating PageCriterions
	 */
	public PageCriterions toCancel(WebDriver driver) {
		btn_cancel.click();
		return PageFactory.initElements(driver, PageCriterions.class);
		}
	
	/**
	 * toSaveAndNext() is the method of playing button save
	 * 
	 */
	public void toSaveAndNext() {
		btn_save.click();	
		}
	
	/**
	 * toRecord() is the method of playing button record
	 * @param driver
	 * @return instantiating PageCriterions
	 */
	public PageCriterions toRecord(WebDriver driver) {
		btn_record.click();
		return PageFactory.initElements(driver, PageCriterions.class);
			
		}
}
