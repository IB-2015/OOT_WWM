package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_DropOutDialogue extends JDialog {

	//MARK: - Constructor
	public View_DropOutDialogue(WWMModel model) {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Aussteigen");
		setBounds(100, 100, 450, 300);

		//Create a JPanel for the label
		JPanel labelPanel = new JPanel();
		labelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		labelPanel.setOpaque(false);
		labelPanel.setLayout(new GridLayout(0, 1, 0, 0));
		//Create and add the label
		JLabel lblAussteigen = new JLabel("Aussteigen?");
		lblAussteigen.setForeground(Color.WHITE);
		lblAussteigen.setOpaque(false);
		lblAussteigen.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanel.add(lblAussteigen);
		//Add the panel to the contentPane
		getContentPane().add(labelPanel, BorderLayout.CENTER);

		//Create a JPanel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//Create and add the buttons
		//Button "NO"
		JButton btnNo = new View_JButton("Nein");
		btnNo.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPanel.add(btnNo);
		getRootPane().setDefaultButton(btnNo);
		//Button "YES"
		JButton btnYes = new View_JButton("Ja");
		btnYes.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				model.setGameEnd();
				dispose();
			}
		});
		buttonPanel.add(btnYes);
		//Add the panel to the contentPane
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		//Finish creating the Dialogue
		pack();
		this.setVisible(true);
	}
}