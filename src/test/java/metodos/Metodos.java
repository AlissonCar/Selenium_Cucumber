package metodos;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import conexoes.DriversFactory;

public class Metodos extends DriversFactory {
	
	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}
	
	public void clicar(String atributo, String texto) {
		driver.findElement(By.xpath("//"+atributo+"[text()='"+texto+"']")).click();
	}
	
	public void scroll(int n1, int n2) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+n1+","+n2+")");
	}
	
	public void escrever (By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}
	
	public void validarTexto(By elemento, String textoEsperado) {
		String textoCapturado = driver.findElement(elemento).getText();
		assertTrue(textoCapturado.contains(textoEsperado));
	}

}
