package model;

public class Pessoa {

	private double salario;
	
	public Pessoa(double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getINSS() {
		if (salario < 1830.30) {
			return salario * 0.08;
		} else if (salario > 1830.29 && salario < 3050.53) {
			return salario * 0.09;
		} else if (salario > 3050.53 && salario < 6101.07) {
			return salario * 0.11;
		} else {
			return 671.11;
		}
	}
	
	public double getIRRF() {
		if (salario > 1903.99 && salario < 2826.66) {
			return (salario * 0.075) - 142.8;
		} else if (salario > 2826.65 && salario < 3751.06) {
			return (salario * 0.15) - 354.8;
		} else if (salario > 3751.05 && salario < 4664.69) {
			return (salario * 0.225) - 636.13;
		} else {
			return (salario * 0.275) - 869.36;
		}
	}
}
