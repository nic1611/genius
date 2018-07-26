package projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class VerdeOuvinte extends PrincipalGenius implements ActionListener {
	public VerdeOuvinte (JToggleButton botao) {
		this.botaoVerde = botao;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no verde");
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					piscar(botaoVerde);
					vetorJogador.add(3);
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
