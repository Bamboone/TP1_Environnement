package Formes;

import java.awt.Color;
import java.awt.Graphics;

public class Trait extends Forme{

	public Trait(Color contour) {
		super(contour);
	}

	@Override
	public void setParametres( int x1, int y1, int x2, int y2 ) {
		setX1( x1 );
		setX2( x2 );
		setY1( y1 );
		setY2( y2 );
	}

	@Override
	public void tracer( Graphics g ) {
		g.setColor( getContour() );
		g.drawLine( getX1(), getY1(), getX2(), getY2() );
	}
}
