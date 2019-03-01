package Formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Forme{
	
	private int[] pointsX;
	private int[] pointsY;
	private Color remplissage;

	public Triangle(Color contour, Color remplissage, int epaisseur) {
		super(contour, epaisseur);
		this.remplissage = remplissage;
		
	}
	
	public Color getRemplissage() {
		return remplissage;
	}
	
	public void setRemplissage(Color remplissage) {
		this.remplissage = remplissage;
	}

	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		
		if(x2>=x1 && y2>=y1) {
			setX1( x1 );
			setX2( x2 );
			setY1( y1 );
			setY2( y2 );
			pointsX = new int[] {x1, (x2+x1)/2, x2};
			pointsY = new int[] {y2, y1, y2};
		}else if(x1>=x2 && y2>=y1) {
			setX1( x2 );
			setX2( x1 );
			setY1( y1 );
			setY2( y2 );
			pointsX = new int[] {x2, (x2+x1)/2, x1};
			pointsY = new int[] {y2, y1, y2};
		}else if(x2>=x1 && y1>=y2 ) {
			setX1( x1 );
			setX2( x2 );
			setY1( y2 );
			setY2( y1 );
			pointsX = new int[] {x1, (x2+x1)/2, x2};
			pointsY = new int[] {y1, y2, y1};

		}else if(x1>=x2 && y1>=y2 ){
			setX1( x2 );
			setX2( x1 );
			setY1( y1 );
			setY2( y2 );
			pointsX = new int[] {x1, (x1+x2)/2, x2};
			pointsY = new int[] {y1, y2, y1};
		}
		
		
		
	}

	@Override
	public void tracer( Graphics g ) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke( new BasicStroke(getEpaisseur()) );
		g2.setColor( getRemplissage() );
		g2.fillPolygon( pointsX, pointsY, 3 );
		g2.setColor( getContour() );
		g2.drawPolygon(pointsX, pointsY, 3);
	}
}