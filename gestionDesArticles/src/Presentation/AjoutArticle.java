package Presentation;




import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AjoutArticle extends JFrame {

	private JLabel labelLibele;
	private JLabel labelPrix;
	private JLabel labelQuantite;
	private JTextField textLibele;
	private JTextField textPrix;
	private JTextField textQuantite;
	private JButton buttonValider;

	public AjoutArticle(ControlleurArticle control) {
		this.setTitle("AjoutEtudiant");
		this.setSize(520, 350);
		this.initialiser();
		this.dessiner();
		this.executer(control);
	}

//	public AjoutArticle(String Libele,Float Prix, String Quantite) { 
//		this();
//		textLibele.setText(Libele);
//		textPrix.setText(Prix);
//		textQuantite.setText(Quantite);
//	}

	private void initialiser() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		labelLibele = new JLabel("Libele :");
		labelPrix = new JLabel("Prix :");
		labelQuantite = new JLabel("Quantite :");
		textLibele = new JTextField(30);
		textPrix = new JTextField(30);
		textQuantite = new JTextField(30);
		buttonValider = new JButton("Valider");

	}

	private void dessiner() {
		this.setLayout(new BorderLayout());

		JPanel centre = new JPanel();
		JPanel BarVideDroite = new JPanel();
		JPanel BarVideGauche = new JPanel();
		JPanel BarVideUp = new JPanel();
		JPanel BarBottom = new JPanel();
		BarBottom.setLayout(new GridBagLayout());

		int MarginWidth = 100;
		int MarginHeight = 50;

		BarVideDroite.setPreferredSize(new Dimension(MarginWidth, 300));
		BarVideGauche.setPreferredSize(new Dimension(MarginWidth, 300));
		BarVideUp.setPreferredSize(new Dimension(300, MarginHeight));
		BarBottom.setPreferredSize(new Dimension(300, 100));

		centre.setLayout(new GridLayout(3, 2, 0, 10));
		centre.add(labelLibele);
		centre.add(textLibele);
		centre.add(labelPrix);
		centre.add(textPrix);
		centre.add(labelQuantite);
		centre.add(textQuantite);

		this.add(centre, BorderLayout.CENTER);
		this.add(BarVideGauche, BorderLayout.WEST);
		this.add(BarVideDroite, BorderLayout.EAST);
		this.add(BarVideUp, BorderLayout.NORTH);
		BarBottom.add(buttonValider, new GridBagConstraints());
		this.add(BarBottom, BorderLayout.SOUTH);
	}
	
	private void executer(ControlleurArticle control) {
		buttonValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String lib = textLibele.getText();
					Float Prix = Float.parseFloat(textPrix.getText());
					Integer Qte = Integer.parseInt(textQuantite.getText());
					control.validerAjoute(lib, Prix,Qte);
				}catch (NumberFormatException e1) {
					printError(e1);
				}
				
				
			}

		});

	}
	
	private void printError(NumberFormatException e) {
		JOptionPane.showMessageDialog(this, e, "Dialog",JOptionPane.ERROR_MESSAGE);
	}
	
}
