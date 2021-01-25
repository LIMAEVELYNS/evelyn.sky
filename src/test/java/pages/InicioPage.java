package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Log;

public class InicioPage extends BasePage {
	public InicioPage(WebDriver navegador) {
		super(navegador);
	}

	// elementos
	By bemvindo = By.xpath("//div[@class=\"modal-content\"]/div[@class=\"modal-header borderless\"]//button[@class=\"close\"]");
	By menuprogramacao = By.xpath("//strong[contains(text(),'Programação')]");



	//Metodo para fechar apenas o pop-up BemVindo
	public InicioPage clicarBemVindo() {
		try {
			if (navegador.findElement(bemvindo).isDisplayed()) {
				navegador.findElement(bemvindo).click();
			}
			
		} catch (Exception e) {
			Log.error("Ocorreu erro ao clicar no botao fechar do pop-up Bem Vindo da pagina inicial");
		}
		

		return this;
	}

	//Metodo para clicar no menu programacoes
	public ProgramacoesPage clicarMenuProgramacao() {
		try {
			navegador.findElement(menuprogramacao).click();
			return new ProgramacoesPage(navegador);			
		} catch (Exception e) {
			Log.error("Ocorreu erro ao clicar no menu Programacoes da tela inicial");
		}
		return new ProgramacoesPage(navegador);

	}

	//Chamar esse metodo quando quiser realizar: Fechar pop-up bem vindo > selecione menu programacoes
	public ProgramacoesPage acesarMenuProgramacao() {
		clicarBemVindo();
		clicarMenuProgramacao();
		
		return new ProgramacoesPage(navegador);

	}
}
