package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage extends BasePage {
	
	public DirectoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[9]/a")
	WebElement Directory;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")
	WebElement Search1;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	WebElement Search_button;
	
	public void Driectory_click() {
		Directory.click();
	}
	
	public void Directory_list() {
		Search1.click();
		Select s=new Select(Search1);
		
		 List<WebElement> optionList = s.getOptions();
		 for(int i=0;i<optionList.size();i++){
			 System.out.println(optionList.get(i).getText());
		 		 
		 if(optionList.get(i).getText().equals("Automaton Tester")) {
			 optionList.get(i).click();
			 break;
		 }
		 }
		 }
	
	public void Search_but() {
		Search_button.click();
	}
	
	
}
