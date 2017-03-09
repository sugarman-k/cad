package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6129570280342978946L;
	double radius;
	
	public Circle(Point startPoint,Point endPoint,Color color){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		radius=startPoint.distance(endPoint);
		Graphics2D g2d=(Graphics2D)g;
		g2d.draw(new Ellipse2D.Double(startPoint.x-radius, startPoint.y-radius,radius*2,radius*2));
	}

}
