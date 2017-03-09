package Shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Text extends Shape{

/**
	 * 
	 */
	private static final long serialVersionUID = 9021721290982222682L;
	//	textbox text;
	String s;
	public Text(Point startPoint,Point endPoint,Color color,String s){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.color = color;
		this.s=s;

	}
	public void setString(String s){
		this.s=s;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
	//	new textbox();
	//	Graphics2D g2d=(Graphics2D)g;
		g.setFont(new Font("¿¬Ìå",Font.BOLD,Math.abs(startPoint.x-endPoint.x)));
		g.drawString(s, startPoint.x, startPoint.y);
		
		g.getFontMetrics().stringWidth(s);
	//	g.getFontMetrics().
		
	}
}
