package projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class AzulOuvinte extends PrincipalGenius implements ActionListener {
	public AzulOuvinte (JToggleButton botao) {
		this.botaoAzul = botao;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no azul");
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					piscar(botaoAzul);
					vetorJogador.add(1);
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
