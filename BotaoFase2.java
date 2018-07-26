package projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JToggleButton;

public class BotaoFase2 extends PrincipalGenius implements ActionListener {
	JToggleButton[] vetorBotao = null;

	public BotaoFase2(JToggleButton[] botao) {
		this.vetorBotao = botao;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					vetorComputador = new ArrayList<>();
					random = new Random();
					rand = random.nextInt(4);
						piscar(vetorBotao[rand]);
						vetorComputador.add(rand);
						
					vetorJogador = new ArrayList<>();
					for (int j = 0; j < vetorComputador.size(); j++) {
						System.out.println("Computador [" + j + "]:" + vetorComputador.get(j));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

	private void piscar(JToggleButton botao) throws InterruptedException {
		botao.setSelected(true);
		Thread.sleep(300);
		botao.setSelected(false);
		Thread.sleep(300);		
	}

}
