package visuel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MaJolieFenetre extends JFrame{

	public static void main(String[] args) {
		MaJolieFenetre f = new MaJolieFenetre();
		JPanel fond = new JPanel();
		JButton b1 = new JButton();
		JButton b2 = new JButton("Quitter");
		
		b1.setText("Surprise");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				surprise();
			}
		});
		
		fond.add(b1);
		fond.add(b2);
		
		fond.setBackground(Color.RED);
		f.add(fond);
		
		f.setSize(600, 300);
		f.setTitle("La plus belle fenetre c'est la mienne");
		f.setLocation(700, 400);
		//f.pack(); //Ne prendre que la place necessaire au contenu de la fenetre
		
		f.setVisible(true);

	}

	public static void surprise() {
		JOptionPane.showMessageDialog(null, "coucou");
	}
}
