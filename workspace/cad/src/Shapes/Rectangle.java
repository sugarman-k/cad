package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3673535204877802349L;

	public Rectangle(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawRect(Math.min(startPoint.x, endPoint.x),Math.min(startPoint.y, endPoint.y),Math.abs(endPoint.x-startPoint.x),Math.abs(endPoint.y-startPoint.y));
	}

}
