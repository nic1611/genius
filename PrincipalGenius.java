package projeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PrincipalGenius {
	static List<Integer> vetorComputador = new ArrayList<>();
	static List<Integer> vetorJogador = new ArrayList<>();
	static int pts = 0;
	static int rand = 0;

	JToggleButton botaoPiscar = null;
	JToggleButton botaoVerde = null;
	JToggleButton botaoAzul = null;
	JToggleButton botaoVermelho = null;
	JToggleButton botaoAmarelo = null;
	JToggleButton botaoFase2 = null;
	JToggleButton botaoFase4 = null;
	JToggleButton botaoFase5 = null;
	JToggleButton verPontos = null;

	static Random random = new Random();

	JToggleButton[] vetorBotao = new JToggleButton[4];

	public static void main(String[] args) {
		new PrincipalGenius().processar();
	}

	private void processar() {

		this.botaoAmarelo = new JToggleButton();
		this.botaoAzul = new JToggleButton();
		this.botaoVermelho = new JToggleButton();
		this.botaoVerde = new JToggleButton();
		this.botaoPiscar = new JToggleButton("Pisque-4");
		this.botaoFase2 = new JToggleButton("Pisque-1");
		this.botaoFase4 = new JToggleButton("Pisque-2");
		this.botaoFase5 = new JToggleButton("Pisque-3");
		this.verPontos = new JToggleButton("Pts");

		botaoAmarelo.setBackground(new Color(255, 255, 0));
		botaoAzul.setBackground(new Color(000, 000, 255));
		botaoVermelho.setBackground(new Color(255, 000, 000));
		botaoVerde.setBackground(new Color(000, 255, 000));
		verPontos.setBackground(Color.white);
		botaoPiscar.setBackground(Color.white);
		botaoFase2.setBackground(Color.white);
		botaoFase4.setBackground(Color.white);
		botaoFase5.setBackground(Color.white);
		botaoAmarelo.setPreferredSize(new Dimension(65, 25));
		botaoAzul.setPreferredSize(new Dimension(65, 25));
		botaoVermelho.setPreferredSize(new Dimension(65, 25));
		botaoVerde.setPreferredSize(new Dimension(65, 25));
		verPontos.setPreferredSize(new Dimension(65, 25));

		JPanel painelBotoes = new JPanel();
		JPanel painelCores = new JPanel();
		JPanel verPonto = new JPanel();
		painelBotoes.add(this.botaoFase2);
		painelBotoes.add(this.botaoFase4);
		painelBotoes.add(this.botaoFase5);
		painelBotoes.add(this.botaoPiscar);
		verPonto.add(this.verPontos);
		painelCores.add(this.botaoAmarelo);
		painelCores.add(this.botaoAzul);
		painelCores.add(this.botaoVermelho);
		painelCores.add(this.botaoVerde);
		painelBotoes.setBackground(Color.gray);
		painelCores.setBackground(Color.darkGray);
		verPonto.setBackground(Color.gray);

		JFrame tela = new JFrame("Genius");
		tela.setLayout(new BorderLayout());
		tela.add(BorderLayout.WEST, painelCores);
		tela.add(BorderLayout.NORTH, painelBotoes);
		tela.add(BorderLayout.CENTER, verPonto);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// tela.setSize(800, 600);
		// painelBotoes.setSize(800, 600);
		tela.pack();
		tela.setVisible(true);
		tela.setLocationRelativeTo(null);// Faz aplicação abrir no meio da tela

		botaoAmarelo.addActionListener(new AmareloOuvinte(this.botaoAmarelo));
		botaoAzul.addActionListener(new AzulOuvinte(this.botaoAzul));
		botaoVermelho.addActionListener(new VermelhoOuvinte(this.botaoVermelho));
		botaoVerde.addActionListener(new VerdeOuvinte(this.botaoVerde));
		botaoPiscar.addActionListener(new BotaoIniciarContinuarOuvinte(this.vetorBotao));
		botaoFase2.addActionListener(new BotaoFase2(this.vetorBotao));
		botaoFase4.addActionListener(new BotaoFase4(this.vetorBotao));
		botaoFase5.addActionListener(new BotaoFase5(this.vetorBotao));
		verPontos.addActionListener(e -> JOptionPane.showConfirmDialog(botaoAzul, "Seus pontos sao: " + pts));

		this.vetorBotao[0] = this.botaoAmarelo;
		this.vetorBotao[1] = this.botaoAzul;
		this.vetorBotao[2] = this.botaoVermelho;
		this.vetorBotao[3] = this.botaoVerde;

	}

	protected void validarJogada() {
		if (vetorComputador.size() == vetorJogador.size()) {
			for (int i = 0; i < vetorJogador.size(); i++) {
				if (vetorJogador.get(i) == vetorComputador.get(i)) {
					System.out.println("Computador[" + i + "]:" + vetorComputador.get(i));
				} else {

					JOptionPane.showConfirmDialog(botaoAmarelo, "Errou a sequencia. Seus pontos foram: " + pts);
					System.exit(0);

				}

			}
			JOptionPane.showConfirmDialog(botaoAzul,
					"Voce acertou a sequência. " + "Por favor clique em cancelar para continuar");
			pts = pts + 1;

		}
	}
}
