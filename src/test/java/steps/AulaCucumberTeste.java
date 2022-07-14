package steps;

import java.io.IOException;

import elementos.Elementos;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import runner.Executa;

public class AulaCucumberTeste {
	Metodos metodos= new Metodos();
	Elementos el = new Elementos();
	
	String name="teste";
	
	@Before
	public void iniciarTeste() {
		Executa.abrirNavegador();
	}
	@After
	public void finalizarTeste() {
		Executa.fecharNavegador();
	}


	@Given("que esteja no formulario")
	public void queEstejaNoFormulario() {
		metodos.scroll(0, 350);
		metodos.clicar(el.menuElements);
		metodos.clicar("span","Text Box");
	}

	@When("preencher as informacoes")
	public void preencherAsInformacoes() throws IOException {
		metodos.escrever(el.userName, this.name);
		metodos.escrever(el.userEmail, "teste@teste.com");
		metodos.escrever(el.currentAddress, "teste address");
		metodos.escrever(el.permanentAddress, "permanentAddress");
		metodos.scroll(0, 300);
		metodos.clicar(el.btnsubmit);
	}

	@Then("envio o formulario")
	public void envioOFormulario() throws IOException {
		metodos.validarTexto(el.resultName, this.name);
		Executa.screenShot(this.name);
	}

	
}
