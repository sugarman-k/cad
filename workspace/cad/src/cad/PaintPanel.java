package cad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shape;
import Shapes.line;

public class PaintPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener {
	private static final long serialVersionUID=1;
	private Point startPoint=new Point(0,0);
	private Point endPoint=new Point(0,0);
	private Color color = Color.black;
	private boolean click=false;
	private int ShapeType;
	private ArrayList<Shape> listShape=new ArrayList<Shape>();
//	private HashMap<Integer,Shape> ShapeType=new  HashMap<Integer,Shape>();
	public PaintPanel(){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
//		Dimension size = getSize();
//		int width = size.width;
//		int height = size.height;
//		g.setColor(Color.white);
//		g.fillRect(0, 0, width, height);
		
		for(Shape s:listShape)
		{
			s.draw(g);
		}
		if(click){
			switch(ShapeType){
			case 1:
				new line(this.startPoint,this.endPoint,this.color).draw(g);
				break;
			case 2:
				new Rectangle(this.startPoint,this.endPoint,this.color).draw(g);
				break;
			case 3:
				new Circle(this.startPoint,this.endPoint,this.color).draw(g);
				break;	
			}
		}
	}
	

	public void setShape(int ShapeType)
	{
		this.ShapeType=ShapeType;
	}
	public void drawLine(Graphics g){
		new line(this.startPoint,this.endPoint,this.color).draw(g);	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(click)
		{
			this.endPoint=e.getPoint();
			this.repaint();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
		if(click==false){
			this.startPoint=e.getPoint();
			
		}
		else{
			switch(ShapeType){
			case 1:
				listShape.add(new line(this.startPoint,this.endPoint,this.color));
				break;
			case 2:
				listShape.add(new Rectangle(this.startPoint,this.endPoint,this.color));
				break;
			case 3:
				listShape.add(new Circle(this.startPoint,this.endPoint,this.color));
				break;
		    }
		}
		click=!click;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.requestFocus();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
