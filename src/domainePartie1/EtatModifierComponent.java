package domainePartie1;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;





public class EtatModifierComponent extends EtatDEdition {


	private static Noeud noeud_selectione = null;
	private static Carte.Arc arc_selectione = null;
	
	public EtatModifierComponent(Simulateur simulateur){
		super(simulateur);
	}
	
	
		
	
	public Noeud reqNoeudSelectione(){
		return noeud_selectione;
	}
	public Carte.Arc reqArcSelectione(){
		return arc_selectione;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		noeud_selectione = m_simulateur.reqNoeud(e.getX(), e.getY());
		
	
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		m_simulateur.deplacerNoeud(noeud_selectione, e.getX(), e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}
	
	

}
