package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Circle extends Shapes
{
	private static final long serialVersionUID = -6129570280342978946L;
	double radius;
	float f=1;
	public Circle(Point startPoint,Point endPoint,Color color,BasicStroke basicStroke){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color=color;
		this.basicStroke=basicStroke;
	}
		
	@Override
	public void draw(Graphics g) 
	{
		g.setColor(color);
		radius=startPoint.distance(endPoint);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(basicStroke);
		g2d.draw(new Ellipse2D.Double(startPoint.x-radius, startPoint.y-radius,radius*2,radius*2));
	}
	@Override
	public boolean isSelected(Point mousePoint) 
	{
		boolean b = false;
		ArrayList<Shape> AreaShape=getAreaShape();
		if(AreaShape.get(0).contains(mousePoint)){
			b=true;
		}
		return b;
	}
	@Override
	public ArrayList<Shape> getAreaShape() 
	{
		ArrayList<Shape> AreaShape  = new ArrayList<Shape>();
		radius=startPoint.distance(endPoint);
		AreaShape.add(new Ellipse2D.Double(startPoint.x-radius, startPoint.y-radius,radius*2,radius*2));
		return AreaShape;
	}	
}
