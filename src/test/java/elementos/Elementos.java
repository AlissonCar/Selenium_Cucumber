package elementos;

import org.openqa.selenium.By;

public class Elementos {
	
	public By menuElements = By.xpath("//h5[text()='Elements']");
	
	public By userName= By.xpath("//input[@id='userName']");
	public By userEmail = By.xpath("//input[@id='userEmail']");
	public By currentAddress = By.xpath("//textarea[@id='currentAddress']");
	public By permanentAddress = By.xpath("//textarea[@id='permanentAddress']");
	public By btnsubmit = By.xpath("//button[@id='submit']");
	public By resultName = By.xpath("//p[@id='name']");
}
