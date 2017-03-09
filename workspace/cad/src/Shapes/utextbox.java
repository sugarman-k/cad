package Shapes;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class utextbox extends JFrame implements ActionListener{
	JTextField jtf=new JTextField(10);
	JLabel jl=new JLabel();
	JPanel jp=new JPanel();
	public String s;
	//public Text text;
	public utextbox()
	{
		this.setTitle("нд╠╬©Р");
		jtf.addActionListener(this);
		jp.add(jtf);
		jp.add(jl);
		this.add(jp);
		this.setBounds(300,250,300,200);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		text.setString(jtf.getText());
//			new Text()=jtf.getText();
//		text.draw(g);
	}
//	public static void main(String args[])
//	{
//		textbox q=new textbox();
//	}
}
