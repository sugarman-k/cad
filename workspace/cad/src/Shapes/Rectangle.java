package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Rectangle extends Shapes
{
	private static final long serialVersionUID = -3673535204877802349L;
	public Rectangle(Point startPoint,Point endPoint,Color color,BasicStroke basicStroke)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
		this.basicStroke=basicStroke;
	}
	@Override
	public void draw(Graphics g) 
	{
		g.setColor(color);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(basicStroke);
		g.drawRect(Math.min(startPoint.x, endPoint.x),Math.min(startPoint.y, endPoint.y),Math.abs(endPoint.x-startPoint.x),Math.abs(endPoint.y-startPoint.y));
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
		AreaShape.add(new Rectangle2D.Double(Math.min(startPoint.x, endPoint.x),Math.min(startPoint.y, endPoint.y),Math.abs(endPoint.x-startPoint.x),Math.abs(endPoint.y-startPoint.y)));
		return AreaShape;
	}
}
