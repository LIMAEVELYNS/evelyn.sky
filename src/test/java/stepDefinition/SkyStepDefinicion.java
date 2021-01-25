
package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.InicioPage;
import pages.ProgramacoesPage;
import suporte.Web;

public class SkyStepDefinicion {

	private WebDriver navegador = Web.getDriver();

	InicioPage inicio = new InicioPage(navegador);
	ProgramacoesPage programacoes = new ProgramacoesPage(navegador);

	@Given("^que seja selecionado Menu programacao$")
	public void que_seja_selecionado_Menu_programacao() {
		inicio.acesarMenuProgramacao();

	}

	@When("^seleciono passando agora$")
	public void seleciono_passando_agora() {
		programacoes.selecionarBotaoPassandoAgora();
	}

	@When("^clico na programacao agora$")
	public void clico_na_programacao_agora() {
		programacoes.selecionarProgramacaoAgora();

	}

	@Then("^sera apresentado pop-up com programacao selecionada$")
	public void sera_apresentado_pop_up_com_programacao_selecionada() {
		programacoes.compatarTextoProgramacoes();
	}

}