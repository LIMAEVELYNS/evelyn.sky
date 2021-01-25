package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class ProgramacoesPage extends BasePage {
	public ProgramacoesPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	// elementos
	By passandoAgora = By.xpath("//span[contains(text(),'Passando Agora')]");
	By listaPassandoAgora = By.xpath(
			"//div[@class=\"time-nav-container\"]//following-sibling::div[@class=\"virtual-list\"]//div[@class=\"channel-schedule-container\"]//div[@class=\"program-schedule-item\"]");
	By popProgramacao = By.xpath("//span[contains(text(),'fechar')]");
	By textoProgramacao = By.linkText("Programação");

	public ProgramacoesPage selecionarBotaoPassandoAgora() {

		
			// espera por dez sengundos
			WebDriverWait aguardar = new WebDriverWait(navegador, 5);
			aguardar.until(ExpectedConditions.visibilityOf(navegador.findElement(passandoAgora)));

			// rolando a pagina até nome programacao
			navegador.findElement(textoProgramacao).sendKeys(Keys.PAGE_DOWN);
			try {
			// Clicar no botão passando agora
			navegador.findElement(passandoAgora).click();

		} catch (Exception e) {
			Log.error("Ocorreu erro ao clicar no botão passando agora");
		}

		return this;
	}

	public ProgramacoesPage selecionarProgramacaoAgora() {

		
			// recuperando a lista de programacoes
			WebElement elementos = navegador.findElement(listaPassandoAgora);
			List<WebElement> texto = elementos.findElements(
					By.xpath("//div[@class=\"schedule-inner schedule-live\"]//h2[@class=\"program-schedule-title\"]"));

			// Retorna o nome da programacao que será aberta
			System.out.print(texto.get(0).getText());

			// Armazenando o texto do primeiro elemento retornado
			guardaTexto = texto.get(0).getText();
			try {
			// Esperar o elemento ser apresentado e seleciona a primeira programacao
			// retornada na lista
			texto.get(0).click();

		} catch (Exception e) {
			Log.error("Gerou erro ao clicar na programacao atual");
		}

		return this;
	}

	public ProgramacoesPage compatarTextoProgramacoes() {

		
			// Recuperando texto do pop-up e comparando textos // String mensagemPop =
			navegador.findElement(popProgramacao).getText();

			// visualizar texto da programacao selecionada
			System.out.print(navegador.findElement(popProgramacao).getText());

			WebElement textoPop = navegador.findElement(By.xpath("//div[@class=\"sky-modal-program-title\"]"));
			mensagemPop = textoPop.getText();
			
			try {
			assertEquals(BasePage.guardaTexto, mensagemPop);
			navegador.findElement(popProgramacao).click();

		} catch (Exception e) {
			Log.error("Gerou erro na comparação dos textos");
		}

		return this;
	}

}
