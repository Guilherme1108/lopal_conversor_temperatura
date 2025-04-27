package br.dev.guilherme.temperatura.gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;
	
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	
	
	public void criarTelaConversor() {

		JFrame tela = new JFrame();
		tela.setSize(410, 340); //tamanho da tela (x, y)
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //faz o programa encerrar quando clicar em fechar
		tela.setResizable(false); //não permite mudar o tamanho da janela
		tela.setLayout(null); // quando nos mesmos que vamos selecionar onde os objetos estão
		tela.setTitle("Conversor de Temperatura");
		
		
		// torna a tela como o local onde irá aparecer os dados
		Container container = tela.getContentPane();
		
		//texto que vai aparecer
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(50, 20, 300, 30);
		
		// Cria o local onde tem como digitar
		textCelsius = new JTextField();
		textCelsius.setBounds(50, 50, 300, 30);
		
		// botão para converter para Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(50, 100, 140, 50);
		
		// botão para converter para Fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(210, 100, 140, 50);
		
		// cria o resultado que irá aparecer
		labelResultado = new JLabel();
		
		// Cria uma fonte para o resultado
		Font tamanhoFonteResultado = new Font(null, Font.BOLD, 36);
		labelResultado.setFont(tamanhoFonteResultado); // faz o resultado utilizar a fonte que já foi passada
		labelResultado.setVisible(false); // faz com que não apareça no momento

		
		// Adicionando os componentes no painel de conteúdo do JFrame (tela)
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonKelvin);
		container.add(buttonFahreinheit);
		container.add(labelResultado);
		
		// o setVisible é a ultima coisa a aparecer
		tela.setVisible(true);

		
	}

}
