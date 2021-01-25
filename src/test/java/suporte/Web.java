package suporte;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Web {
	// private static WebDriver driver;

	private static WebDriver driver;

	// Getters and Setters
	public static WebDriver getDriver() {

		// Caso o driver nao esteja gerado ainda
		if (driver == null)
			criarDriver();

		return driver;
	}

	// Cria a instancia do driver
	@SuppressWarnings("deprecation")
	public static void criarDriver() {

		boolean driverOK = false;
		int count = 0;
		do {
			try {

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability("requireWindowFocus", true);
				System.setProperty("webdriver.ie.driver", "resources/Executaveis/IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				// Log.info("Driver criado com sucesso: " + driver);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("https://www.sky.com.br/");
				driverOK = true;
			} catch (Exception e) {
				// Log.error("Erro ao carregar o driver: " + e);
				count++;

				if (count == 3) {
					driverOK = false;
				}
			}
		} while (!driverOK);

	}

	// Metodo para matar os processos do Intenet Explorer
	public static void closeExplorer() {

		try {
			Web.getDriver().close();
			driver = null;
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("cmd.exe", "/c", "taskkill /im iexplore.exe");
			processBuilder.start();
		} catch (IOException e) {
			// Log.error("Erro ao fechar o Chrome: " + e);
		}

	}

}
