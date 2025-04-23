package br.dev.guilherme.temperatura.model;

public class Temperatura {
	

	private double celsius;
	
	//testando
	private double kelvin;
	private double fahreinheit;

	public double getCelsius() {
			return celsius;
		}

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	public double converterParaKelvin() {
	
		//testando, voltar para igual o fahreinheit depois
	 kelvin = celsius + 273.15;
	return this.kelvin;
	
	}
	
	public double converterParaFahreinheit() {
		double fahreinheit = (celsius * 9 / 5) + 32;
		return fahreinheit;
	}
	
	public void exibirDados() {
		System.out.println(fahreinheit);
		System.out.println(kelvin);
	}
	
}
