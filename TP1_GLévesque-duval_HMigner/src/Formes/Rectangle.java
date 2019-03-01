package Formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Forme{
	
	private int largeur;
	private int hauteur;
	private Color remplissage;

	public Rectangle(Color contour, Color remplissage, int epaisseur) {
		super(contour, epaisseur);
		this.remplissage = remplissage;
		
		
	}
	
	public int getLargeur() {
		return largeur;
	}
	
	public int getHauteur() {
		return hauteur;
	}
	
	public Color getRemplissage() {
		return remplissage;
	}
	
	public void setRemplissage(Color remplissage) {
		this.remplissage = remplissage;
	}

	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		
		if(x2>x1 && y2>y1) {
			setX1( x1 );
			setX2( x2 );
			setY1( y1 );
			setY2( y2 );
			largeur = x2-x1;
			hauteur = y2-y1;
		}else if(x1>x2 && y2>y1) {
			setX1( x2 );
			setX2( x1 );
			setY1( y1 );
			setY2( y2 );
			largeur = x1-x2;
			hauteur = y2-y1;
		}else if(x2>x1 && y1>y2 ) {
			setX1( x1 );
			setX2( x2 );
			setY1( y2 );
			setY2( y1 );
			largeur = x2-x1;
			hauteur = y1-y2;
		}else {
			setX1( x2 );
			setX2( x1 );
			setY1( y2 );
			setY2( y1 );
			largeur = x1-x2;
			hauteur = y1-y2;
		}
		
		
		
	}

	@Override
	public void tracer( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( getRemplissage() );
		g2.fillRect( getX1(), getY1(), largeur, hauteur );
		g2.setColor( getContour() );
		g2.drawRect( getX1(), getY1(), largeur, hauteur);
	}
	
}
