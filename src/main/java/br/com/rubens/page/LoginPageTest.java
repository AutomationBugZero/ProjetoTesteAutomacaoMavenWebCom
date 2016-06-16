/**
 * 
 */
package br.com.rubens.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



import br.com.rubens.interfaces.ISeleniumUtils;

/**
 * @author Rubens de Medeiros lobo
 *
 *	Boas praticas Page Objects
 *
 *	Esta classe guardara todos os objetos e metodos da pagina de login da apliação
 */
public class LoginPageTest implements ISeleniumUtils {

	//WebDriver driver;
	
	public WebDriver webDriver = driver;
	
	By username=By.xpath(".//*[@id='user_login']");
	By password=By.id("user_password");
	By loginButton=By.xpath("html/body/div[1]/div/div/div/form/button");
	By linkSair=By.xpath(".//*[@id='bemvindo']/a");
	
	
	public void TypeUserName(String UserName)
	{
		webDriver.findElement(username).sendKeys(UserName);
	}
	public void TypePassword(String Pass)
	{
		webDriver.findElement(password).sendKeys(Pass);
	}
	public void ClickonLoginButton()
	{
		webDriver.findElement(loginButton).click();
	}
	public void validAcessAplication()
	{
		Assert.assertTrue(linkSair.toString().contains("bemvindo"));
	}
	public void LogarPageLogin(String UserName, String Pass) throws InterruptedException
	{
		LoginPageTest login=new LoginPageTest();
		login.TypeUserName(UserName);
		login.TypePassword(Pass);
		login.ClickonLoginButton();
		Thread.sleep(2000);
		login.validAcessAplication();
	}	
}
