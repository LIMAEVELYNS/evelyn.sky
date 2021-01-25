package suporte;

import java.sql.Driver;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.CucumberException;

public class Hooks {
	
	@Before
	public void setUpBefore(Scenario scenario) throws CucumberException{
		// Navegando para o site
			Web.criarDriver();
		
	}

	@After
	public void AfterScenario(Scenario scenario) throws CucumberException {
	 Web.closeExplorer();

	}
}
