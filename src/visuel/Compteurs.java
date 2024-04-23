package visuel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Compteurs extends JFrame{
	private static JLabel leLabel;
	private static int cpt=0;
	
	public static void quitter() {
		System.exit(0);
	}
	public static void clicInit() {
		cpt=0;
		leLabel.setText("0");
	}
	public static void clicOk() {
		cpt++;
		leLabel.setText(Integer.toString(cpt));
	}
	
	public static void main(String[] args) {
		Compteurs f=new Compteurs();
		JButton bOK, BQuit, BInit;
		JPanel leFond = new JPanel();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		bOK = new JButton("OK");
		BQuit = new JButton("Quitter");
		BInit = new JButton("Reinitialiser");
		leLabel = new JLabel("0");
		leLabel.setForeground(Color.RED);
		
		bOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				clicOk();
			}	
		});
		
		BInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				clicInit();
			}	
		});
		
		BQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				quitter();
			}
		});
		
		leFond.add(leLabel);
		leFond.add(bOK);
		leFond.add(BInit);
		leFond.add(BQuit);
		f.add(leFond);
		f.setLocation(400,400);
		f.setSize(400, 100);
		f.setVisible(true);
		
	}

}
