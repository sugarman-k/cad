package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Shapes implements Serializable{
	public Point startPoint;
	public Point endPoint;
	public Color color;
	public BasicStroke basicStroke;
//	protected String s;
//	public abstract void SetStroke(float f);
	public abstract void draw(Graphics g);
	public abstract boolean isSelected(Point mousePoint);
	public abstract ArrayList<Shape> getAreaShape();
	public void SetColor(Color color){
		this.color=color;
	};
	public void SetStroke(float f) {
		// TODO Auto-generated method stub
		this.basicStroke=new BasicStroke(f);
	}
	public abstract Shapes CopyShape();

}
