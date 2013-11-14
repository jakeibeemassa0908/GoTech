package presentation;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presentation.IconicButton.*;
import java.awt.event.MouseListener;

import domainePartie1.Carte;
import domainePartie1.Simulateur;


import presentation.CarteGraphique;
import presentation.AfficheurGraphique;
import presentation.Menu;
import presentation.BarBoutons;
import presentation.EditPanel;
public class InterfaceGraphique extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarBoutons bar;
	private Menu menu;
	private CarteGraphique m_carteGraphique;
	private EditPanel m_panneauEdition;
	
    private static Simulateur m_simulateur;
    private AfficheurGraphique m_afficheurGraphique;

	public InterfaceGraphique(Simulateur p_simulateur, AfficheurGraphique p_afficheurGraphique) {
		
		super("Intervensim");
		setPreferredSize(new Dimension(920, 600));
		
		m_afficheurGraphique = p_afficheurGraphique;
		m_simulateur = p_simulateur;
		
		
		
		
		
		// Ajout de la carte graphique au centre
		m_carteGraphique = new CarteGraphique(m_afficheurGraphique, m_simulateur);
		getContentPane().add(m_carteGraphique, BorderLayout.CENTER);
		
		// Ajout Panneau Edition
		m_panneauEdition = new EditPanel();
		getContentPane().add(m_panneauEdition, BorderLayout.WEST);
		
		// Ajout du menu et de la barre des buttons
		menu = new Menu();
		//bar = new BarBoutons();
		
		//getContentPane().add(bar, BorderLayout.WEST);
		this.setJMenuBar(menu);
		
		
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

	}
	
	public void ajouterCarteListener(MouseListener listener){
		m_carteGraphique.addMouseListener(listener);
	}
	
	public void rafraichirCarte() {
		m_carteGraphique.repaint();
	}
}
