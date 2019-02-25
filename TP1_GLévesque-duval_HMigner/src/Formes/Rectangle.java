package Formes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme{
	
	private int largeur;
	private int hauteur;

	public Rectangle(int x1, int y1, int x2, int y2, Color contour, Color remplissage) {
		super(x1, y1, x2, y2, contour, remplissage);
		
	}

	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		
		if(x2>x1 && y2>y1) {
			largeur = x2-x1;
			hauteur = y2-y1;
		}else if(x1>x2 && y2>y1) {
			setX1( x2 );
			setX2( x1 );
			largeur = x1-x2;
			hauteur = y2-y1;
		}else if(x2>x1 && y1>y2 ) {
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
		g.setColor( getContour() );
		g.drawRect( getX1()-1, getY1()-1, largeur+1, hauteur+1);
		g.setColor( getRemplissage() );
		g.fillRect( getX1(), getY1(), largeur, hauteur );
	}
	
}
