package projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class VermelhoOuvinte extends PrincipalGenius implements ActionListener {
	public VermelhoOuvinte (JToggleButton botao) {
		this.botaoVermelho = botao;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no vermelho");
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					piscar(botaoVermelho);
					vetorJogador.add(2);
					validarJogada();
				} catch (Exception e) {
					// TODO: handle exception
				}
					
				
			}
		}).start();
	}
	
	private void piscar(JToggleButton botao) throws InterruptedException {
		botao.setSelected(true);
		Thread.sleep(200);
		botao.setSelected(false);
		Thread.sleep(200);
		botao.setSelected(true);
		Thread.sleep(200);
		botao.setSelected(false);
		Thread.sleep(200);
	}

}
