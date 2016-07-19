/**
 * 
 */
package br.rubens.teste;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import br.com.rubens.framework.Util;
import br.com.rubens.interfaces.ISeleniumUtils;
import br.com.rubens.page.CadastroClientePageTest;
import br.com.rubens.page.ListaCadastroClientePageTest;
import br.com.rubens.page.LoginPageTest;
import br.com.rubens.page.MenuPrincipalPageTest;

/**
 * @author Rubens de Medeiros Lobo
 *
 *         Caso de teste executa cadastro do cliente
 *
 *
 */
public class VerifyWebComCadastroCliente implements ISeleniumUtils {

	public WebDriver webDriver = driver;

	@Test(priority = 2, description = "Executar cadastro do cliente", groups = "domain")
	public void VerifyValidCadastroCliente() throws IOException,
			InterruptedException {
		Util util = new Util();
		String[] dados = util.GetDataTable(".\\DataTable\\DataTabe.xls", 13);

		driver.get("www.yahoo.com");
		
		System.out.println("Acesso Yahoo");
		
		//LoginPageTest login = new LoginPageTest();
		//login.LogarPageLogin(dados[1], dados[2]);

		//MenuPrincipalPageTest menu = new MenuPrincipalPageTest(webDriver);

		//menu.NavegarMenuPrincipalCadastroCliente();

		//ListaCadastroClientePageTest listaCliente = new ListaCadastroClientePageTest(
		//		webDriver);

		//listaCliente.ClicaButtonAdicionarCliente();

		//CadastroClientePageTest CadastrarCliente = new CadastroClientePageTest(
		//		webDriver);

		//CadastrarCliente.EfetuarCadastroCliente(dados[3].trim(),
		//		dados[4].trim(), dados[5].trim(), dados[6].trim(),
		//		dados[7].trim(), dados[8].trim(), dados[9].trim(),
		//		dados[10].trim(), dados[11].trim(), dados[12].trim());

	}

}
