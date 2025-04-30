package br.dev.guilherme.temperatura.model;

public class Temperatura {

	private double celsius;

	public double getCelsius() {
		return celsius;
	}

	public void setCelsius(double celsius) {
		
		if (celsius >= 273.15) {
			this.celsius = celsius;
		}
		}

	// realizando o calculo de celcius para kelvin
	public double converterParaKelvin() {
		double kelvin = getCelsius() + 273.15;
		return kelvin;

	}

	// realizando o calculo de celcius para fahreinheit
	public double converterParaFahreinheit() {
		double fahreinheit = (getCelsius() * 9 / 5) + 32;
		return fahreinheit;
	}

}
