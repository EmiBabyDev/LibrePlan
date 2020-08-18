package Projet_1.LibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PageLogin is the class of the login page
 * 
 * @author formation
 *
 */
public class PageLogin {
	Logger log = LoggerFactory.getLogger(PageLogin.class);

	@FindBy(name = "j_username")
	WebElement field_username;
	@FindBy(name = "j_password")
	WebElement field_password;
	@FindBy(name = "button")
	WebElement btn_submit;

	// Login Alexis
	@FindBy(xpath = "//input[@name='j_username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='j_password']")
	WebElement password;

	/**
	 * toLogin() is the connection method to the application in the Index page
	 * 
	 * @param driver
	 *            u p
	 * @return instantiating the index page
	 */
	public PageIndex toLogIn(WebDriver driver, String u, String p) {
		ToolBox.fillInField(field_username, u);
		ToolBox.fillInField(field_password, p);
		btn_submit.click();
		return PageFactory.initElements(driver, PageIndex.class);
	}
	
	public PageAccueil fillInLogin(WebDriver driver) {
		username.clear();
		username.sendKeys("admin");
		password.clear();
		password.sendKeys("admin");
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
