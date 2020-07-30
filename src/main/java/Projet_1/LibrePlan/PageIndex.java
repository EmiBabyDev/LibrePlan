package Projet_1.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * PageIndex is the class of Index Page
 * @author formation
 *
 */
public class PageIndex extends BandeauMenu{
	Logger log = LoggerFactory.getLogger(PageLogin.class);
	
	/**
	 * isCalendarPresent() is the method of checking the calendar object
	 * @param log
	 * @return boolean of ToolBox method
	 */
	public boolean isCalendarPresent(Logger log){	
		return ToolBox.isElementPresent(ongl_calendrier, log);
	}

}
