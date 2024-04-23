package visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Saisies extends JFrame{
	private static JLabel Lnb1, Lnb2;
	private static JTextField tfReponse;
	
	public static void correction() {
		int nb1, nb2, nb3, reponse = 0;
		
		nb1 = Integer.parseInt(Lnb1.getText());
		nb2 = Integer.parseInt(Lnb2.getText());
		nb3 = nb1+nb2;
		
		try {
			reponse = Integer.parseInt(tfReponse.getText());
		}
		catch( java.lang.NumberFormatException e) {}
		
		if(reponse == nb3) {
			JOptionPane.showMessageDialog(null,  "Bravo ! Excellente reponse", "Correction", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null,  "Mauvaise reponse. C'etait : " + nb3, "Correction", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void init() {
		Random r = new Random();
		int a, b;
		a = r.nextInt(51);
		b = r.nextInt(51);
		Lnb1.setText(a+"");
		Lnb2.setText(b+"");
		tfReponse.setText("");
	}
	
	public static void main(String[] args) {
		Saisies f = new Saisies();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel leFond, leNord, leSud;
		JButton bCorrection, bInit, bQuit;
		JLabel lPlus, lEgal;
		
		leFond = new JPanel();
		leNord = new JPanel();
		leSud = new JPanel();
		
		bCorrection = new JButton("Correction");
		bInit = new JButton("Nouveau Calcul");
		bQuit = new JButton("Quitter");
		
		
		
		lPlus = new JLabel("+");
		lEgal = new JLabel("=");
		
		Lnb1 = new JLabel("0");
		Lnb2 = new JLabel("0");
		tfReponse = new JTextField();
		
		
		bQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		bInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				init();
			}
		});
		bCorrection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				correction();
			}
		});
		tfReponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				correction();
			}
		});
		
		init();
		
		leNord.add(Lnb1);
		leNord.add(lPlus);
		leNord.add(Lnb2);
		leNord.add(lEgal);
		leNord.add(tfReponse);
		
		leSud.add(bInit);
		leSud.add(bCorrection);
		leSud.add(bQuit);
		
		leFond.setLayout(new BorderLayout());
		leNord.setLayout(new GridLayout(1,5));
		leSud.setLayout(new GridLayout(1,3));
		
		leFond.add(leNord, BorderLayout.NORTH);
		leFond.add(leSud, BorderLayout.SOUTH);
		leFond.setBackground(Color.BLUE);
		
		f.add(leFond);
		f.setSize(300, 400);
		f.setLocation(500,100);
		f.setVisible(true);
	}

}
