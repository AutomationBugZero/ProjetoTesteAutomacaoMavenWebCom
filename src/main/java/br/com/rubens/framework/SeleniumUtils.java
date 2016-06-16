package br.com.rubens.framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Classe de configura��o utilizada na instancia��o do objeto Webdriver
 * 
 * @author Alexandre Araujo /alexandretnparaujo@gmail.com
 *
 */
public class SeleniumUtils {

	public static WebDriver DRIVER;

	// public final String profileFirefoxPath =
	// "/home/user/.mozilla/firefox/aw8hg7o6.default";

	/**
	 * Create a Protected static WebDriver Object.
	 * 
	 * @author 
	 * @param browserNumber
	 *            <p>
	 *            3 - Firefox - DEFAULT
	 *            <p>
	 *            2 - Chrome &nbsp; - Windows S.O ONLY - REMOVED
	 *            <p>
	 *            1 - Internet Explorer - Windows S.O ONLY (of course) - REMOVED
	 *            <p>
	 * 
	 * @param waitPageSeconds
	 *            &nbsp; Page Load timeout.
	 *            <p>
	 * 
	 * @param waitElementSeconds
	 *            &nbsp; Elements from page timeout
	 *            <p>
	 * 
	 * @return A static object to SeleniumUtils.DRIVER protected var.
	 */
	public WebDriver setUpDriver(int browserNumber, int waitPageSeconds, int waitElementSeconds) {

		Util util = new Util();

		if (SeleniumUtils.DRIVER == null) {
			WebDriver driver = null;
			if (browserNumber == 1) {
				// util.killProcess("iexplore.exe");
				// util.killProcess("IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",
						"./src/test/resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browserNumber == 2) {
				util.killProcess("chrome.exe");
				util.killProcess("chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",
						"./src/test/resources/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserNumber == 3) {
				// FirefoxProfile profile = new FirefoxProfile(new
				// File(profileFirefoxPath));
				driver = new FirefoxDriver(/* profile */);

			}
			driver.manage().window().maximize();
			SeleniumUtils.DRIVER = driver;
		}
		this.WaitPageLoad(waitPageSeconds);
		this.WaitElementLoad(waitElementSeconds);
		return SeleniumUtils.DRIVER;
	}

	/**
	 * Configura o tempo maximo de espera do carregamento da pagina.
	 * 
	 * @author Alexandre Araujo /alexandretnparaujo@gmail.com
	 * @param seconds
	 *            &nbsp; Tempo de espera do carregamento da pagina em segundos.
	 */
	private final void WaitPageLoad(int seconds) {
		SeleniumUtils.DRIVER.manage().timeouts()
				.pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Configura o tempo maximo de espera de carregamento do elemento que
	 * comp�e a pagina.
	 * 
	 * @author Alexandre Araujo /alexandretnparaujo@gmail.com
	 * @param seconds
	 *            &nbsp; Tempo de espera do carregamento do elemento da pagina.
	 */
	private final void WaitElementLoad(int seconds) {
		SeleniumUtils.DRIVER.manage().timeouts()
				.implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * @param isProductionEnvironment
	 *            - true for secure.rubens / false for secure-testing.rubens
	 * @return Url String
	 */
	public String Url(boolean isProductionEnvironment) {
		String url = null;
		if (isProductionEnvironment) {
			url = "http://192.168.100.173:8080/webcom/login.do";
		} else {
			url = "https://secure-testing.rubens.com.br/login/";
		}
		return url;
	}
}
