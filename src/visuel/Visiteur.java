package visuel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Visiteur extends JFrame{
	private static JPanel fond;
	private static JButton bOK;
	private static boolean allume = true;
	
	public static void clicBouton() {
		if(allume) {
			fond.setBackground(Color.BLACK);
			bOK.setText("Jour");
		}
		else {
			fond.setBackground(Color.WHITE);
			bOK.setText("Nuit");
		}
		allume = !allume;
			
	}
	public static void main(String[] args) {
		Visiteur f = new Visiteur();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fond = new JPanel();
		bOK = new JButton("OK");
		
		bOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clicBouton();
			}
		});
		
		fond.setBackground(Color.WHITE);
		fond.add(bOK);
		f.add(fond);
		f.setSize(400, 600);
		f.setLocation(300, 300);
		f.setVisible(true);
		
		
	}

}
