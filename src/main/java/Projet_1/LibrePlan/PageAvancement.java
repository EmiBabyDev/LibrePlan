package Projet_1.LibrePlan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * PageAvancement is the class of the "Advance" item
 * @author formation
 *
 */
public class PageAvancement {
	@FindBy(xpath = "//input[@style='width:300px;']")
	private WebElement input_text;
	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div[2]/div/div/div/div[3]/table/tbody[2]/tr[2]/td[2]/div/span/input")
	private WebElement checkbox_actif;
	@FindBy(xpath = "//tr[3]/td/div/input[@class='z-decimalbox']")
	private WebElement input_defaultval;
	@FindBy(xpath = "//tr[4]/td/div/input[@class='z-decimalbox']")
	private WebElement input_precision;
	@FindBy(xpath = "//input[@type = 'checkbox' and contains(@id, 'Qk5')]")
	private WebElement checkbox_pourcent;
	
	/**
	 * createAdvance() is the method of creating new advancements 
	 * @param text_name text_default text_precision
	 */
	public void createAdvance(String text_name, String text_default, String text_precision) {
		input_text.sendKeys(text_name);
		checkbox_actif.click();
		ToolBox.fillInField(input_defaultval, text_default);
	}

}
