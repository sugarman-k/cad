package cad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPanel extends JPanel{
	private static final long serialVersionUID = 4438735624024500512L;
	private JButton blueButton;
	private JButton greenButton;
	private JButton redButton;
	private JButton yellowButton;
	private JButton blackButton;
	private JButton greyButton;
	private JButton purpleButton;
	private JButton whiteButton;
	protected JButton forwardButton;
	private JLabel selectedLabel;

	public ColorPanel(){
		super();
		initGUI();
	}
	private void initGUI(){
		this.setLayout(null);
		{	
			blueButton=new JButton();
			this.add(blueButton);
			blueButton.setBounds(0, 0, 28, 28);
			blueButton.setBackground(new Color(0,0,225));
			blueButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent evt) {
					blueActionPerformed(evt);
				}				
			});
			greenButton=new JButton();
			this.add(greenButton);
			greenButton.setBounds(28, 0 , 28, 28);
			greenButton.setBackground(new Color(128,255,128));
			greenButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent evt) {
					greenActionPerformed(evt);
				}				
			});
			redButton=new JButton();
			this.add(redButton);
			redButton.setBounds(0, 28, 28,28);
			redButton.setBackground(new Color(255,0,0));
			redButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent evt) {
					redActionPerformed(evt);
				}				
			});
			yellowButton=new JButton();
			this.add(yellowButton);
			yellowButton.setBounds(28,28, 28, 28);
			yellowButton.setBackground(new Color(255,255,0));
			yellowButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent evt) {
					yellowActionPerformed(evt);
				}				
			});
		}
			blackButton = new JButton();
			this.add(blackButton);
			blackButton.setBounds(0, 56, 28, 28);
			blackButton.setBackground(new java.awt.Color(0,0,0));
			blackButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					blackActionPerformed(evt);
				}
			});
			greyButton = new JButton();
			this.add(greyButton);
			greyButton.setBounds(28, 56, 28, 28);
			greyButton.setBackground(new java.awt.Color(192,192,192));
			greyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					greyActionPerformed(evt);
				}
			});
			purpleButton = new JButton();
			this.add(purpleButton);
			purpleButton.setBounds(0, 84, 28, 28);
			purpleButton.setBackground(new java.awt.Color(128,0,128));
			purpleButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					purpleActionPerformed(evt);
				}
			});
			whiteButton = new JButton();
			this.add(whiteButton);
			whiteButton.setBounds(28, 84, 28, 28);
			whiteButton.setBackground(new java.awt.Color(255,255,255));
			whiteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					whiteActionPerformed(evt);
				}
			});
		{
			forwardButton=new JButton();
			this.add(forwardButton);
			forwardButton.setBounds(0, 140, 56, 28);
			forwardButton.setBackground(new Color(0,0,0));
		}
		{
			selectedLabel=new JLabel();
			this.add(selectedLabel);
			selectedLabel.setText("бЁжа");
			selectedLabel.setBounds(0, 114, 56, 21);
		}
	}
	private void blueActionPerformed(ActionEvent evt){
		forwardButton.setBackground(blueButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void greenActionPerformed(ActionEvent evt){
		forwardButton.setBackground(greenButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void redActionPerformed(ActionEvent evt){
		forwardButton.setBackground(redButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void yellowActionPerformed(ActionEvent evt){
		forwardButton.setBackground(yellowButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void blackActionPerformed(ActionEvent evt){
		forwardButton.setBackground(blackButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void greyActionPerformed(ActionEvent evt){
		forwardButton.setBackground(greyButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void purpleActionPerformed(ActionEvent evt){
		forwardButton.setBackground(purpleButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void whiteActionPerformed(ActionEvent evt){
		forwardButton.setBackground(whiteButton.getBackground());
		forwardButtonActionPerformed(evt);
	}
	private void forwardButtonActionPerformed(ActionEvent evt){
		if(this.getBackground().equals(new Color(238,238,238))){
			this.setBackground(new Color(238,238,237));
		}else{
			this.setBackground(new Color(238,238,238));
		}
	}

}
