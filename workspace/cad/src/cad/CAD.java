package cad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

//import Shapes.textbox;



public class CAD extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	public static CAD cad;
//	private ArrayList<Shape> listShape=new ArrayList<Shape>();
	
//	private class ShapePanel extends JPanel{
//		private static final long serialVersionUID=1;
//
//		@Override
//		protected void paintComponent(Graphics g) {
//			// TODO Auto-generated method stub
//			super.paintComponent(g);
//			for(Shape s:listShape)
//			{
//				s.draw(g);
//			}
//		}
//		
//	}
//	public void add(Shape s)
//	{
//		listShape.add(s);
//	}
	public CAD(int width,int height)
	{
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.width=width;
		this.height=height;
		this.setTitle("cad");
		this.setLocationRelativeTo(null);
	}
	public void draw()
	{
		
		setSize(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		CAD cad= new CAD(640,450);
		PaintPanel paint=new PaintPanel();
		cad.add(paint, BorderLayout.CENTER);
		//paint.setSize(640,450);
	//	cad.add(paint);
	//	CAD.setSize(640, 450);
	//	CAD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	CAD.setTitle("cad");
	//	frame.setResizable(true);
		ButtonGroup buttonGroup=new ButtonGroup();
		JToolBar toolBar1=new JToolBar();
		JToolBar toolBar2=new JToolBar();
		cad.add(toolBar1,BorderLayout.EAST);
		cad.add(toolBar2,BorderLayout.NORTH);
		toolBar1.setPreferredSize(new Dimension(56, 180));
		toolBar1.setOrientation(SwingConstants.VERTICAL);
	//	toolBar2
		toolBar2.setOrientation(SwingConstants.HORIZONTAL);
		JButton lineButton=new JButton("直线");
		JButton rectangleButton=new JButton("矩形");
		JButton circleButton=new JButton("圆形");
		JButton textButton=new JButton("文字");
		ColorPanel colorPanel=new ColorPanel();
//		colorPanel.setPreferredSize(new Dimension(58,100));
		toolBar1.add(lineButton);
		toolBar1.add(rectangleButton);
		toolBar1.add(circleButton);
		toolBar1.add(textButton);
		toolBar1.add(colorPanel);
		lineButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				paint.unSelected();
				paint.setShape(1);
				paint.repaint();			
			}			
		});
		rectangleButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				paint.unSelected();
				paint.setShape(2);
				paint.repaint();	
			}		
		});
		circleButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				paint.unSelected();
				paint.setShape(3);
				paint.repaint();		
			}
			
		});
		textButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				paint.unSelected();
				paint.getInput();
				paint.setShape(4);
				paint.repaint();
			}
			
		});
		colorPanel.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				paint.setColor(colorPanel.forwardButton.getBackground());
				paint.changeColor(colorPanel.forwardButton.getBackground());
			}
			
		});
		JButton openButton=new JButton("打开");
		JButton saveButton=new JButton("保存");
		toolBar2.add(openButton);
		toolBar2.add(saveButton);
		openButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				paint.openPaint();
			}
			
		});
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				paint.savePaint();
			}
			
		});
		
		
		cad.add(paint, BorderLayout.CENTER);
	  //paint.setPreferredSize(new java.awt.Dimension(640, 450));
//		ColorPanel colorPanel=new ColorPanel();
//		PaintPanel paintPanel=new PaintPanel();
//		toolBar1.add(colorPanel);
//		toolBar1.add(paintPanel);
	
		
//		frame.add(pic);
//	//	frame.add(button1,BorderLayout.EAST);
//		button1.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				//Picture pic = new Picture(420,300);
//				pic.add(r1);
//				pic.draw();
//				frame.repaint();
//			}
//			
//		}
//		);

		cad.pack();

		cad.draw();
	}

}
