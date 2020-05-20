package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import model.Pessoa;

public class StepsMapper {

	private static Pessoa pessoa;
	
	@Given("o usuario insira $SALARIO no campo salario")
	public void salarioSejaInserido(@Named("SALARIO") double salario) {
		pessoa = new Pessoa(salario);
	}
	
	@When("o usuario clicar no botao calcular")
	public void calcularSejaClicado() {}
	
	@Then("o sistema deve exibir o valor $INSS para o INSS")
	public void compararINSS(@Named("INSS") double INSS) {
		Assert.assertEquals(pessoa.getINSS(), INSS);
	}
	
	@Then("o sistema deve exibir o valor $IRRF para o IRRF")
	public void compararIRRF(@Named("IRRF") double IRRF) {
		Assert.assertEquals(pessoa.getIRRF(), IRRF);
	}
	
}
