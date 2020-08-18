/**
 * 
 */
package Projet_1.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * PageMachine is the class of the "Machine" item
 * 
 * @author formation
 *
 */
public class PageMachine {
	@FindBy(xpath = "//div[text()= 'Nom']/following::div[text()= 'Description']/following::div[text()= 'Code']/following::div[text() = 'En file']/following::div[text()='Opérations'][1]']")
	WebElement ordre_fields;
	@FindBy(xpath = "(//tr/td[1]/input)[1]")
	WebElement code_field;
	@FindBy(xpath = "(//td/div/input)[1]")
	WebElement name_field;
	@FindBy(xpath = "(//td/div/input)[2]")
	WebElement description_field;
	@FindBy(xpath = "//input[@style='width:200px;']")
	WebElement type_list;
	@FindBy(xpath = "//td[text()='Enregistrer']")
	WebElement btn_enregistrer;
	@FindBy(xpath = "//td[text()='Sauver et continuer']")
	WebElement btn_sauver_et_continuer;
	@FindBy(xpath = "//td[text()='Sauver et continuer']/following::td[text()='Annuler'][1]")
	WebElement btn_annuler;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox_click;

	public PageMachine fillInMachine(WebDriver driver) throws InterruptedException {
		checkbox_click.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(code_field));
		ToolBox.fillInField(code_field, "MACHINETEST1");
		ToolBox.fillInField(description_field, "MACHINETEST1");
		ToolBox.fillInField(name_field, "MACHINETEST1");
		btn_sauver_et_continuer.click();
		// vérifier les données entrées
		assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Machine \"MACHINETEST1\" enregistré')]"))
				.isDisplayed());
		assertTrue(driver.findElement(By.xpath("//td[text() = 'Modifier Machine: MACHINETEST1']")).isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(btn_annuler));
		btn_annuler.click();
		// vérifier les données entrées précédemments
		assertTrue(driver.findElement(By.xpath(
				"//span[text()= 'MACHINETEST1']/following::span[text()= 'MACHINETEST1']/following::span[text()= 'MACHINETEST1']/following::span[text() = 'non']"))
				.isDisplayed());
		return PageFactory.initElements(driver, PageMachine.class);
	}

}
