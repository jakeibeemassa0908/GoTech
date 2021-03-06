package presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


import domainePartie1.Position;
import domainePartie1.Simulateur;
import presentation.Afficheur;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.Dimension;


public class CarteGraphique extends JPanel implements MouseInputListener{
	
	
	private static Afficheur m_afficheur;
	private static  Simulateur m_simulateur;
	private JViewport viewport;
	private JPopupMenu noeudPopup;
	private static final String SUPPRIMER_NOEUD= "Supprimer";
	
	
	
	public CarteGraphique(Afficheur afficheurGraphique, Simulateur p_simulateur) {
		
		
		
		this.m_simulateur = p_simulateur;
		this.m_afficheur = afficheurGraphique;
		
		final CarteGraphique mycarte = this;
		
		setBackground(Color.WHITE);
		setVisible(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		this.viewport = (JViewport)getParent();
		noeudPopup = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Supprimer");
		menuItem.setActionCommand(SUPPRIMER_NOEUD);
		menuItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				 
						m_simulateur.supprimer_component();
						mycarte.repaint();
					
				  
			  }
			  });
		noeudPopup.add(menuItem);
		addPopup(this, noeudPopup);
		}
		
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		m_afficheur.afficherReseau(g, this.m_simulateur);
	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		m_simulateur.mouseClicked(e);
	
			this.repaint();
		
		
	}
	


	@Override
	public void mouseEntered(MouseEvent e) {
	
		m_simulateur.mouseEntered(e);
		this.repaint();
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		m_simulateur.mouseExited(e);
		this.repaint();
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		m_simulateur.mousePressed(e);
		this.repaint();
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		m_simulateur.mouseReleased(e);
		this.repaint();
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		
		m_simulateur.mouseDragged(e);
		this.repaint();
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		
		m_simulateur.mouseMoved(e);
		this.repaint();
		
	}

	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					
					showMenu(e);
					
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					
					showMenu(e);
					
				}
			}
			private void showMenu(MouseEvent e) {
			
					if(m_simulateur.existeComponent(e.getX(), e.getY()) == true){
						popup.show(e.getComponent(), e.getX(), e.getY());
						
					}
				
				
			}
		});
	}



}
    		

		
		
	

