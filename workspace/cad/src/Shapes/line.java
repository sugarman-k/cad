package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class line extends Shapes {

	private static final long serialVersionUID = -2570452506368997137L;
	public line (Point startPoint,Point endPoint,Color color,BasicStroke basicStroke,AffineTransform trans)
	{
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.color=color;
		this.basicStroke=basicStroke;
		this.trans=trans;
	}
	@Override
	public void draw(Graphics g) 
	{
		g.setColor(color);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(basicStroke);
		g2d.setTransform(trans);
		g.drawLine(this.startPoint.x, this.startPoint.y, this.endPoint.x, this.endPoint.y);
	}
	@Override
	public boolean isSelected(Point mousePoint)
	{
		boolean b = false;
		ArrayList<Shape> AreaShape=getAreaShape();
		if(((Line2D.Double)AreaShape.get(0)).ptSegDist(mousePoint)<5){
			b=true;
		}
		return b;
	}
	@Override
	public ArrayList<Shape> getAreaShape()
	{
		ArrayList<Shape> AreaShape  = new ArrayList<Shape>();
		AreaShape.add(new Line2D.Double(startPoint, endPoint));
		return AreaShape;
	}
}
