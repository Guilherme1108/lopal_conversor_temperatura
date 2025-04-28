package br.dev.guilherme.temperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.guilherme.temperatura.model.Temperatura;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;

	private JButton buttonKelvin;
	private JButton buttonFahreinheit;

	private JLabel labelResultado;
	private JLabel labelMensagemErro;

	public void criarTelaConversor() {

		JFrame tela = new JFrame();
		tela.setSize(410, 340); // tamanho da tela (x, y)
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // faz o programa encerrar quando clicar em fechar
		tela.setResizable(false); // não permite mudar o tamanho da janela
		tela.setLayout(null); // quando nos mesmos que vamos selecionar onde os objetos estão
		tela.setTitle("Conversor de Temperatura");

		// torna a tela como o local onde irá aparecer os dados
		Container container = tela.getContentPane();

		// texto que vai aparecer
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(50, 20, 300, 30); // (x, y, plano cartesiano) (x, y, tamanho do objeto)

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
		Font tamanhoFonteResultado = new Font(null, Font.BOLD, 20);
		labelResultado.setFont(tamanhoFonteResultado); // faz a mensagem do resultado utilizar a fonte
		labelResultado.setVisible(false); // faz com que não apareça no momento

		// criando a mensagem de erro
		labelMensagemErro = new JLabel("Os dados estão incorretos.");

		// cria uma fonte para o erro
		Font tamanhoFonteMensagemErro = new Font(null, Font.BOLD, 20); // Cria uma estilização de fonte
		labelMensagemErro.setVisible(false); // Define que não é visivel no momento
		labelMensagemErro.setForeground(Color.RED); // Define a cor da letra
		labelMensagemErro.setFont(tamanhoFonteMensagemErro); // faz o a mensagem de erro utilizar a fonte
		labelMensagemErro.setBounds(75, 180, 260, 50);

		// Adicionando os componentes no painel de conteúdo do JFrame (tela)
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonKelvin);
		container.add(buttonFahreinheit);
		container.add(labelResultado);
		container.add(labelMensagemErro);

		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*
				 * os comandos try e catch é quase que um verdadeiro ou falso se for verdadeiro
				 * (funcionou) ele executa o comando, se for falso (erro) ele executará o
				 * comando do catch
				 */

				try {

					labelMensagemErro.setVisible(false);

					String celsius = textCelsius.getText().replace(",",
							"."); /*
									 * o replace serve para mudar a virgula por um . porque se não o calculo da
									 * errado
									 */
					// criando uma variavel para guardar o valor em double
					double celsiusDouble = Double.parseDouble(celsius);

					// criando um objeto
					Temperatura temperatura = new Temperatura();

					temperatura.setCelsius(celsiusDouble); // utiliza a classe temperatura para realizar o calculo

					double temperaturaKelvin = temperatura.converterParaKelvin(); // pega o valor comvertido e guarda no
																					// temperaturaKelvin

					/*
					 * passa o resultado para o labelResultado 
					 * o %.2f serve para deixa o resultado com apenas 2 casas decimais
					 */
					labelResultado.setText(String.format("%.2f", temperaturaKelvin) + " Kelvin");
					labelResultado.setBounds(120, 180, 360, 50);

					// torna o resultado visivel
					labelResultado.setVisible(true);

					// se for falso (erro)
				} catch (NumberFormatException exception) {

					// remove o resultado
					labelResultado.setVisible(false);

					// faz aparecer a mensagem de erro
					labelMensagemErro.setVisible(true);

				}

			}

		});

		// mesma coisa que a parte de cima, porem agora para o Fahreinheit
		buttonFahreinheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					labelMensagemErro.setVisible(false);

					String celsius = textCelsius.getText().replace(",", ".");
					double celsiusDouble = Double.parseDouble(celsius);

					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(celsiusDouble);

					double temperaturaFahreinheit = temperatura.converterParaFahreinheit();
					labelResultado.setText(String.format("%.2f", temperaturaFahreinheit) + " Fahreinheit");
					labelResultado.setBounds(120, 180, 360, 50);
					labelResultado.setVisible(true);

				} catch (NumberFormatException exception) {

					labelResultado.setVisible(false);
					labelMensagemErro.setVisible(true);

				}
			}
		});

		// o setVisible é a ultima coisa que deve aparecer
		tela.setVisible(true);

	}

}
