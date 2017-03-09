package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public abstract class Shape implements Serializable{
	protected Point startPoint;
	protected Point endPoint;
	protected Color color;
//	protected String s;
	public abstract void draw(Graphics g);

}
