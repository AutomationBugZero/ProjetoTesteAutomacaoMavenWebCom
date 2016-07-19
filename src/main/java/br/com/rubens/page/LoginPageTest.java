/**
 * 
 */
package br.com.rubens.page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import br.com.rubens.framework.Util;
import br.com.rubens.interfaces.ISeleniumUtils;

/**
 * @author Rubens de Medeiros lobo
 *  <p>
 *	Boas praticas Page Objects
 *  <p>
 *	Esta classe guardara todos os objetos e metodos da pagina de login da apliação
 */
public class LoginPageTest implements ISeleniumUtils {

	//WebDriver driver;
	
	public WebDriver webDriver = driver;
	
	By username=By.xpath(".//*[@id='user_login']");
	By password=By.id("user_password");
	By loginButton=By.xpath("html/body/div[1]/div/div/div/form/button");
	
	
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

	public void LogarPageLogin(String UserName, String Pass) {
		MenuPrincipalPageTest menu=new MenuPrincipalPageTest();
		Util util=new Util();

		LoginPageTest login=new LoginPageTest();			
		
		util.waitForElement(webDriver, username,10,".\\Evidencia\\Print_erro");
					
		login.TypeUserName(UserName);
		login.TypePassword(Pass);
		login.ClickonLoginButton();
			
		util.waitForTextToAppear(webDriver, "Sair", webDriver.findElement(menu.linkSair),10,".\\Evidencia\\Print_erro");
			
	}	
}
