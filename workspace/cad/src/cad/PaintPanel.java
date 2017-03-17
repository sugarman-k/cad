package cad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shapes;
import Shapes.Text;
import Shapes.line;
//import Shapes.string;
//import Shapes.textbox;

public class PaintPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener, Serializable {
	private static final long serialVersionUID = 498827436606239861L;
//	private static final long serialVersionUID=1;
	private static final String JOptionPanel = null;
	private Point startPoint=new Point(0,0);
	private Point endPoint=new Point(0,0);
	private Color color = Color.black;
	private float f=1;
	private BasicStroke basicStroke=new BasicStroke(f);
	private boolean Pressed=false;
	private boolean Selected=false;
	private int ShapeType;
	private String input;
	private Point SMoved;
	public int index=-1;
	public ArrayList<Shapes> listShape=new ArrayList<Shapes>();
//  ate String ;
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
		
		for(Shapes s:listShape)
		{
			s.draw(g);
		}
		if(Pressed){
			switch(ShapeType){
			case 1:
				new line(this.startPoint,this.endPoint,this.color,this.basicStroke).draw(g);
				break;
			case 2:
				new Rectangle(this.startPoint,this.endPoint,this.color,this.basicStroke).draw(g);
				break;
			case 3:
				new Circle(this.startPoint,this.endPoint,this.color,this.basicStroke).draw(g);
				break;	
			case 4:
				
//				new textbox().text.draw(g);
//				Text text=new Text(this.startPoint,this.endPoint,this.color);
//				text.draw(g);
//				text.setString(input);
				new Text(this.startPoint,this.endPoint,this.color,input,this.basicStroke).draw(g);
//				text.draw(g); 
//				listShape.add(text);
				break;
			}
		}
	}
	

	public void setShape(int ShapeType)
	{
		this.ShapeType=ShapeType;
	}
	public void getInput(){
		this.input=JOptionPane.showInputDialog("«Î ‰»ÎŒƒ◊÷");
	}
	public void savePaint(){
		fileClass save=new fileClass(CAD.cad ,this);
		save.SaveFile();
		repaint();
	}
	public void openPaint(){
		fileClass open=new fileClass(CAD.cad ,this);
		open.OpenFile();
		repaint();
	}
	public void setColor(Color color) {
		this.color = color;
	}
//	public void drawLine(Graphics g){
//		new line(this.startPoint,this.endPoint,this.color,this.basicStroke).draw(g);	
//	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){		
			f=(float) (0.8*f);
			changeStroke(f);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			f=(float) (1.2*f);
			changeStroke(f);
		}
		if(e.getKeyCode()==KeyEvent.VK_DELETE){
			listShape.remove(index);
			repaint();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.endPoint=e.getPoint();
		this.repaint();
		if(Selected){
//			this.startPoint=e.getPoint();
			moveShape(e);
	//		index=-1;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
//		Shapes s=null;
		for(index=0;index<listShape.size();index++)
		{
			Shapes s=listShape.get(index);
			if(s.isSelected(e.getPoint()))
			{
				Selected=true;
				break;
			}
			unSelected();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.startPoint=e.getPoint();
		this.Pressed = true;
		if(Selected){
			SMoved=e.getPoint();
		}
	} 
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.endPoint=e.getPoint();
		this.Pressed = false;
		switch(ShapeType){
		case 1:
			listShape.add(new line(this.startPoint,this.endPoint,this.color,this.basicStroke));
			break;
		case 2:
			listShape.add(new Rectangle(this.startPoint,this.endPoint,this.color,this.basicStroke));
			break;
		case 3:
			listShape.add(new Circle(this.startPoint,this.endPoint,this.color,this.basicStroke));
			break;
		case 4:
			listShape.add(new Text(this.startPoint,this.endPoint,this.color,input,this.basicStroke));
			break;
	    }
		ShapeType=0;
		this.repaint();
		
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
	public void changeColor(Color color){
		if(Selected){
		//	Shapes s=listShape.remove(index);
			Shapes s=listShape.get(index);
			s.SetColor(color);
		//	listShape.remove(index);
		//	listShape.add(s);
			this.repaint();
		}
	}
	public void changeStroke(float f){
		if(Selected){
		//	Shapes s=listShape.remove(index);
			Shapes s=listShape.get(index);
			s.SetStroke(f);
		//	listShape.remove(index);
		//	listShape.add(index,s);
			this.repaint();
	    }
	}
	public void moveShape(MouseEvent e){
		Shapes s=listShape.remove(index);		
		int xd=e.getX()-SMoved.x;
		int yd=e.getY()-SMoved.y;
		s.startPoint.x+=xd;
		s.startPoint.y+=yd;
		s.endPoint.x+=xd;
		s.endPoint.y+=yd;
		listShape.add(index,s);
		SMoved=e.getPoint();
		this.repaint();
	}
	public void unSelected(){
		this.Selected=false;
	}

}
