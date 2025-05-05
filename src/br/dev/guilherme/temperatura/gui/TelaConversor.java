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
	private JButton buttonFahrenheit;

	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	private JLabel labelMensagemErro1;

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

		// botão para converter para Fahrenheit
		buttonFahrenheit = new JButton();
		buttonFahrenheit.setText("Fahrenheit");
		buttonFahrenheit.setBounds(210, 100, 140, 50);

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
		labelMensagemErro.setBounds(75, 190, 280, 50);

		labelMensagemErro1 = new JLabel("Utilize somente números e pontos."); // mensagem de erro da linha de baixo
		// configurando a mensagem de erro de baixo
		Font tamanhoFonteMensagemErro1 = new Font(null, Font.BOLD, 20); // Cria uma estilização de fonte
		labelMensagemErro1.setVisible(false); // Define que não é visivel no momento
		labelMensagemErro1.setForeground(Color.RED); // Define a cor da letra
		labelMensagemErro1.setFont(tamanhoFonteMensagemErro1); // faz o a mensagem de erro utilizar a fonte
		labelMensagemErro1.setBounds(40, 215, 330, 50);

		// Adicionando os componentes no painel de conteúdo do JFrame (tela)
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonKelvin);
		container.add(buttonFahrenheit);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		container.add(labelMensagemErro1);

		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*
				 * os comandos try e catch é quase que um verdadeiro ou falso se for verdadeiro
				 * (funcionou) ele executa o comando, se for falso (erro) ele executará o
				 * comando do catch
				 */

				try {

					String celsius = textCelsius.getText();
					// criando uma variavel para guardar o valor em double
					double celsiusDouble = Double.parseDouble(celsius);

					/*
					 * utilizei o if e else para ele só calcular se o numero for maior ou igual a
					 * -273.15 que é o zero absoluto
					 * 
					 * 
					 * passa o resultado para o labelResultado o %.2f serve para deixa o resultado
					 * com apenas 2 casas decimais
					 */
					if (celsiusDouble >= -273.15) {

						// criando um objeto
						Temperatura temperatura = new Temperatura();

						temperatura.setCelsius(celsiusDouble); // utiliza a classe temperatura para realizar o calculo

						double temperaturaKelvin = temperatura.converterParaKelvin(); // pega o valor comvertido e
																						// guarda no
																						// temperaturaKelvin

						/*
						 * passa o resultado para o labelResultado o %.2f serve para deixa o resultado
						 * com apenas 2 casas decimais seleciona onde o labelResultado vai aparecer
						 */
						labelResultado.setText(String.format("%.2f", temperaturaKelvin) + " Kelvin");
						labelResultado.setBounds(120, 180, 360, 50);

						// torna o resultado visivel e a mensagem de erro some
						labelResultado.setVisible(true);
						labelMensagemErro.setVisible(false);
						labelMensagemErro1.setVisible(false);
					} else {
						labelMensagemErro.setText(" O valor minímo é -273.15");
						labelResultado.setVisible(false); // faz o resultado que já estiver sumir
						labelMensagemErro.setVisible(true); // faz aparecer a mensagem de erro
						labelMensagemErro1.setVisible(false); // faz sumir o erro da ,
					}

					// se for falso (erro)
				} catch (NumberFormatException exception) {

					// remove o resultado
					labelResultado.setVisible(false);

					// faz aparecer a mensagem de erro
					labelMensagemErro.setVisible(true);
					labelMensagemErro1.setVisible(true);

				}

			}

		});

		// mesma coisa que a parte de cima, porem agora para o Fahreinheit
		buttonFahrenheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					String celsius = textCelsius.getText();
					double celsiusDouble = Double.parseDouble(celsius);

					if (celsiusDouble >= -273.15) {

						Temperatura temperatura = new Temperatura();

						temperatura.setCelsius(celsiusDouble);

						double temperaturaFahrenheit = temperatura.converterParaFahrenheit();

						labelResultado.setText(String.format("%.2f", temperaturaFahrenheit) + " Fahrenheit");
						labelResultado.setBounds(120, 180, 360, 50);
						labelResultado.setVisible(true); // faz aparecer o resultado
						labelMensagemErro.setVisible(false); // faz sumir a mensagem de erro
						labelMensagemErro1.setVisible(false); // faz sumir a outra mensagem de erro
					} else {
						labelMensagemErro.setText(" O valor minímo é -273.15");
						labelResultado.setVisible(false); // faz o resultado que já estiver sumir
						labelMensagemErro.setVisible(true); // faz aparecer a mensagem de erro do -273.15
						labelMensagemErro1.setVisible(false);
					}

				} catch (NumberFormatException exception) {

					labelResultado.setVisible(false);
					labelMensagemErro.setVisible(true);
					labelMensagemErro1.setVisible(true);

				}
			}
		});

		// o setVisible é a ultima coisa que deve aparecer
		tela.setVisible(true);

	}

}
