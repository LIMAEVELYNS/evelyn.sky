package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver navegador;
	
	static String guardaTexto="";
	static String mensagemPop="";

	public BasePage(WebDriver navegador) {
		this.navegador = navegador;
	}

}
