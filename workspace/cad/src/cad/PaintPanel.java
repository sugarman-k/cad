package cad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Shapes.Circle;
import Shapes.Rectangle;
import Shapes.Shapes;
import Shapes.Text;
import Shapes.line;

public class PaintPanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener, Serializable
{	
	private static final long serialVersionUID = 498827436606239861L;
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
	private AffineTransform trans=new AffineTransform();
	private double sx=1;
	private double sy=1;
	private int index=-1;
	public ArrayList<Shapes> listShape=new ArrayList<Shapes>();
	public PaintPanel()
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);		
		for(Shapes s:listShape)
		{
			s.draw(g);
		}
		if(Pressed){
			switch(ShapeType){
			case 1:
				new line(this.startPoint,this.endPoint,this.color,this.basicStroke,this.trans).draw(g);
				break;
			case 2:
				new Rectangle(this.startPoint,this.endPoint,this.color,this.basicStroke).draw(g);
				break;
			case 3:
				new Circle(this.startPoint,this.endPoint,this.color,this.basicStroke).draw(g);
				break;	
			case 4:				
				new Text(this.startPoint,this.endPoint,this.color,input,this.basicStroke).draw(g);
				break;
			}
		}
	}
	
	public void setShape(int ShapeType)
	{
		this.ShapeType=ShapeType;
	}	
	public void getInput()
	{
		this.input=JOptionPane.showInputDialog("«Î ‰»ÎŒƒ◊÷");
	}
	public void savePaint()
	{
		fileClass save=new fileClass(CAD.cad ,this);
		save.SaveFile();
		repaint();
	}
	public void openPaint()
	{
		fileClass open=new fileClass(CAD.cad ,this);
		open.OpenFile();
		repaint();
	}
	public void setColor(Color color) 
	{
		this.color = color;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){		
			f=(float) (0.8*f);
			changeStroke(f);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			f=(float) (1.2*f);
			changeStroke(f);
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			sx=1.1*sx;
			changeSize(sx,sy);
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
	public void mouseDragged(MouseEvent e) 
	{
		this.endPoint=e.getPoint();
		this.repaint();
		if(Selected)
		{
			moveShape(e);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
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
	public void mousePressed(MouseEvent e)
	{
		this.startPoint=e.getPoint();
		this.Pressed = true;
		if(Selected){
			SMoved=e.getPoint();
		}
	} 
	@Override
	public void mouseReleased(MouseEvent e)
	{
		this.endPoint=e.getPoint();
		this.Pressed = false;
		switch(ShapeType){
		case 1:
			listShape.add(new line(this.startPoint,this.endPoint,this.color,this.basicStroke,this.trans));
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
	public void changeColor(Color color)
	{
		if(Selected)
		{
			Shapes s=listShape.get(index);
			s.SetColor(color);
			this.repaint();
		}
	}
	public void changeStroke(float f)
	{
		if(Selected)
		{
			Shapes s=listShape.get(index);
			s.SetStroke(f);
			this.repaint();
	    }
	}
	public void changeSize(double sx,double sy)
	{
		if(Selected){
			Shapes s=listShape.get(index);
			s.SetScale(sx, sy);
			this.repaint();
		}
	}
	public void moveShape(MouseEvent e)
	{
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
	public void unSelected()
	{
		this.Selected=false;
	}
}
