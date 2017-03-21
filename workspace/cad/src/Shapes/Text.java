package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Text extends Shapes
{
	private static final long serialVersionUID = 9021721290982222682L;
	String s;
	FontMetrics fm;
	Rectangle2D rec;
	double StringAscent;
	public Text(Point startPoint,Point endPoint,Color color,String s,BasicStroke basicStroke)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
		this.s=s;
		this.basicStroke=basicStroke;

	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(basicStroke);
		g.setFont(new Font("¿¬Ìå",Font.BOLD,Math.abs(endPoint.x-startPoint.x)));
		g.drawString(s, startPoint.x, startPoint.y);
		fm=g.getFontMetrics();
		rec=fm.getStringBounds(s, g);		
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
		AreaShape.add(new Rectangle2D.Double(startPoint.x,startPoint.y-(int)rec.getHeight(),(int)rec.getWidth(),(int)rec.getHeight()));
		return AreaShape;
	}
}
