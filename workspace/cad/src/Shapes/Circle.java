package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Circle extends Shapes{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6129570280342978946L;
	double radius;
	float f=1;
	public Circle(Point startPoint,Point endPoint,Color color,BasicStroke basicStroke){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color=color;
		this.basicStroke=basicStroke;
	}
		
//	@Override
//	public void SetStroke(float f) {
//		// TODO Auto-generated method stub
//		this.basicStroke=new BasicStroke(f);
//	}


//	@Override
//	public void SetColor(Color color) {
//		// TODO Auto-generated method stub
//		this.color = color;
//	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		radius=startPoint.distance(endPoint);
		Graphics2D g2d=(Graphics2D)g;
		g2d.setStroke(basicStroke);
		g2d.draw(new Ellipse2D.Double(startPoint.x-radius, startPoint.y-radius,radius*2,radius*2));
	}
	@Override
	public boolean isSelected(Point mousePoint) {
		// TODO Auto-generated method stub
		boolean b = false;
		ArrayList<Shape> AreaShape=getAreaShape();
		if(AreaShape.get(0).contains(mousePoint)){
			b=true;
		}
		return b;
	}
	@Override
	public ArrayList<Shape> getAreaShape() {
		// TODO Auto-generated method stub
		ArrayList<Shape> AreaShape  = new ArrayList<Shape>();
		radius=startPoint.distance(endPoint);
		AreaShape.add(new Ellipse2D.Double(startPoint.x-radius, startPoint.y-radius,radius*2,radius*2));
//		AreaShape.add(new Ellipse2D.Double(startPoint.x - radius-2, startPoint.y - radius-2,
//				2 * radius+4, 2 * radius+4));
//		AreaShape.add(new Ellipse2D.Double(startPoint.x - radius+2, startPoint.y - radius+2,
//				2 * radius-4, 2 * radius-4));
		return AreaShape;
	}

	@Override
	public Shapes CopyShape() {
		// TODO Auto-generated method stub
		return new Circle(this.startPoint,this.endPoint,this.color,this.basicStroke);
	}
	
	

}
