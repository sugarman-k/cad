package cad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Shapes.Shape;

public class fileClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9198769201233120370L;
	private CAD cad;
	private PaintPanel paintpanel;
	fileClass(CAD cad,PaintPanel paintpanel){
		this.cad=cad;
		this.paintpanel=paintpanel;
	}
	public void SaveFile(){
		JFileChooser filechooser=new JFileChooser();
		filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= filechooser.showSaveDialog(cad);
		if(result==JFileChooser.CANCEL_OPTION){
			return;
		}
		File fileName=filechooser.getSelectedFile();
		fileName.canWrite();
		if(fileName!=null||fileName.exists()){
			int n=JOptionPane.showConfirmDialog(filechooser, "是否要覆盖文件？","是",JOptionPane.YES_NO_CANCEL_OPTION);
			if(n==JOptionPane.NO_OPTION){
				return;
			}
		}
	
		try{			
			FileOutputStream fos=new FileOutputStream(fileName+".cad");
			ObjectOutputStream output=new ObjectOutputStream(fos);
			output.writeInt(paintpanel.listShape.size());
			for(int i=0;i<paintpanel.listShape.size();i++){
				Shape a=paintpanel.listShape.get(i);
				output.writeObject(a);
			}
			output.close();
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void OpenFile(){
		JFileChooser filechooser=new JFileChooser();
	//	filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result= filechooser.showOpenDialog(cad);
		if(result==JFileChooser.APPROVE_OPTION){
			File fileName=filechooser.getSelectedFile();
			fileName.canRead();
	//		String file=fileName.getPath();
			try{
	//			paintpanel.listShape.clear();
				FileInputStream fis=new FileInputStream(fileName);
				ObjectInputStream input=new ObjectInputStream(fis);
				int count=input.readInt();
				Shape a;
				for(int i=0;i<count;i++){
					a=(Shape)input.readObject();
					paintpanel.listShape.add(a);
				}
			paintpanel.repaint();
			input.close();
			}
			catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(cad,"没有找到源文件！","没有找到源文件",JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(cad,"读文件是发生错误！","读取错误",JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(cad,"不能创建对象！","已到文件末尾",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
