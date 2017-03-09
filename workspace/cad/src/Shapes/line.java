package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class line extends Shape {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2570452506368997137L;

	public line (Point startPoint,Point endPoint,Color color){
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.color=color;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
	}

}
