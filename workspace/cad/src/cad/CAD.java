package cad;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;



public class CAD {

	public static void main(String[] args) {
		JFrame frame= new JFrame();
		frame.setSize(640, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("cad");
	//	frame.setResizable(true);
		ButtonGroup buttonGroup=new ButtonGroup();
		JToolBar toolBar1=new JToolBar();
		JToolBar toolBar2=new JToolBar();
		frame.add(toolBar1,BorderLayout.EAST);
		frame.add(toolBar2,BorderLayout.NORTH);
		//toolBar1.setSize(50, 300);
		toolBar1.setOrientation(SwingConstants.VERTICAL);
		//toolBar2.setSize(75, 20);
		toolBar2.setOrientation(SwingConstants.HORIZONTAL);
		JButton lineButton=new JButton("直线");
		JButton rectangleButton=new JButton("矩形");
		JButton circleButton=new JButton("圆形");
		JButton textButton=new JButton("文字");
		toolBar1.add(lineButton);
		toolBar1.add(rectangleButton);
		toolBar1.add(circleButton);
		toolBar1.add(textButton);
		JButton openButton=new JButton("打开");
		JButton saveButton=new JButton("保存");
		toolBar2.add(openButton);
		toolBar2.add(saveButton);
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

		frame.pack();
		frame.setVisible(true);
	}

}
