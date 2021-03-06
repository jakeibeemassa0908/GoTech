package domainePartie1;


import java.util.ArrayList;






public class Noeud implements Comparable<Noeud>
	//d�but classe noeud
	{

		
		private Position m_position;
		private ArrayList<Carte.Arc> m_listeArcsAdjacents;
		private float m_cout; // pour Dijkstra 
		private Carte.Arc m_predecesseur;
		
		public Noeud()
		{
			this.m_cout = 0;
			this.m_listeArcsAdjacents = new ArrayList<Carte.Arc>();
			this.m_position = new Position(0,0);
			
		}
		
		public Noeud(Position pos)
		{
			this.m_position = pos;
			this.m_cout = 0;
			this.m_listeArcsAdjacents = new ArrayList<Carte.Arc>();
		}
		//Getters and setters noeuds
		public Carte.Arc reqPredecesseur()
		{
			return this.m_predecesseur;
		}
		public void setPredecesseur(Carte.Arc arc)
		{
			this.m_predecesseur = arc;
		}
		
		public ArrayList<Carte.Arc> reqListeArcsAdjacents()
		{
			return this.m_listeArcsAdjacents;
		}
		public float reqCout()
		{
			return this.m_cout;
		}
		
		public void setCout(float r)
		{
			this.m_cout = r;
		}
		
		public Position reqPosition()
		{
			return this.m_position;
		}
		
		public void setPosition(Position nouvellePos)
		{
			m_position = nouvellePos;
		}
		//fin getters and setters noeuds



		@Override
		public int compareTo(Noeud n) {
			return m_position.compareTo(n.reqPosition());
		}
		
	
	
		
	}// fin classe noeud


