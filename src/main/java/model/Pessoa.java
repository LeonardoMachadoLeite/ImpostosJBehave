package model;

public class Pessoa {

	public static void main(String[] args) {
		for (double salario = 1000; salario <= 6000; salario+=1000) {
			Pessoa p = new Pessoa(salario);
			System.out.print("|");
			System.out.print(p.salarioBruto);
			System.out.print("|");
			System.out.print(p.getINSS());
			System.out.print("|");
			System.out.print(p.getIRRF());
			System.out.print("|");
			System.out.println();
		}
		
	}
	
	private double salarioBruto, inss, irrf;
	
	public Pessoa(double salarioBruto) {
		this.salarioBruto = salarioBruto;
		this.calcularINSS();
		this.calcularIRRF();
	}
	
    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public void calcularINSS() {
        if(salarioBruto < 1830.30){
            this.inss = salarioBruto * 0.08;
        } else if(salarioBruto > 1830.29 && salarioBruto < 3050.53){
            this.inss = salarioBruto * 0.09;
        } else if(salarioBruto > 3050.52 && salarioBruto < 6101.06){
            this.inss = salarioBruto * 0.11;
        } else {
            this.inss = 671.11;
        }
    }

    public double getINSS() {
        return this.inss;
    }

    public void calcularIRRF() {
        double salario; 
        this.irrf = 60.86;
         salario = this.salarioBruto - getINSS();
         if(salario > 1903.98 && salario < 2826.66){
             this.irrf = (salario * 0.075) - 142.80;
         } else if(salario > 2826.65 && salario < 3751.06){
             this.irrf = (salario * 0.15) - 354.80;
         }else if(salario > 3751.05 && salario < 4664.69){
             this.irrf = (salario * 0.225) - 636.13;
         }else if(salario > 4664.68){
             this.irrf = (salario * 0.275) - 869.36;
         }
         
    }
    public double getIRRF(){
        return this.round(this.irrf);
    }
	
    private double round(double value) {
    	double ans = Math.round(value*100);
    	return ans / 100.0;
    }
    
}
