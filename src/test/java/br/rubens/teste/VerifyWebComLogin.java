/**
 * 
 */
package br.rubens.teste;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import br.com.rubens.framework.Util;
import br.com.rubens.interfaces.ISeleniumUtils;
import br.com.rubens.page.LoginPageTest;

/**
 * @author Rubens Medeiros Lobo
 *
 *         Realiza o login na aplicação
 *
 */
public class VerifyWebComLogin implements ISeleniumUtils {

	public WebDriver webDriver = driver;

	@Test(priority = 1, description = "Realiza o login na aplicação", groups = "domain")
	public void VerifyValidLogin() throws IOException, InterruptedException {
		Util util = new Util();
		String[] dados = util.GetDataTable(".\\DataTable\\DataTabe.xls", 3);

		webDriver.get(dados[0]);

		LoginPageTest login = new LoginPageTest();
		login.LogarPageLogin(dados[1], dados[2]);
		
		System.out.println("Login WebCom");
		
	}

}