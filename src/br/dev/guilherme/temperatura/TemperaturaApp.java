package br.dev.guilherme.temperatura;

import br.dev.guilherme.temperatura.model.Temperatura;

public class TemperaturaApp {

	public static void main(String[] args) {
		
		Temperatura temperatura = new Temperatura();
		temperatura.setCelsius(30);
		temperatura.converterParaFahreinheit();
		temperatura.converterParaKelvin();
		
		

		

	}

}
