package 文本编辑器;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
public class SearchFrame extends JFrame{
	private JButton button;
	private JTextField textField;
	private JRadioButton searchButton;
	private JRadioButton replaceButton;
	private JTextArea text;
	private JLabel searchLabel,replaceLabel;
	private JTextField replaceField;
	public SearchFrame(JTextArea text) {
		this.text=text;
		searchLabel=new JLabel("查找目标：");
		replaceLabel=new JLabel("替换为：");
		
		replaceField=new JTextField(10);
		searchButton=new JRadioButton("查找");
		replaceButton=new JRadioButton("替换");
		textField=new JTextField(10);
		button=new JButton("下一个");
		JPanel panel=new JPanel();
		this.add(panel);
		ButtonGroup buttonGroup=new ButtonGroup();
		panel.add(searchButton);
		panel.add(replaceButton);
		buttonGroup.add(searchButton);
		buttonGroup.add(replaceButton);
		panel.add(searchLabel);
		panel.add(textField);
		panel.add(replaceLabel);
		panel.add(replaceField);
		panel.add(button);
		button.addMouseListener(new ButtonListener());
		this.setTitle("查找");
		
		this.setSize(150, 240);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private boolean search(String mod) {
		int start=text.getText().indexOf(mod);
		if(start==-1)
			return false;
		text.setSelectionStart(start+mod.length());
		return true;
	}
	
	class ButtonListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			if(searchButton.isSelected()) {
				if(textField.getText().length()==0) {
					new NoticeFrame("无模式字符串");
					return;
				}
				text.requestFocus();
				BoyerMoore kmp=new BoyerMoore(textField.getText(),40000);
				String temp="";
//				System.out.println(text.getSelectionStart());
				int start=text.getSelectionStart();
				for(int i=start;i<text.getText().length();i++) {
					temp=temp+String.valueOf(text.getText().charAt(i));
				}
				int end=kmp.search(temp);
				if(end==-1) {
					new NoticeFrame("未找到");
				}
				else {
					text.setSelectionStart(end+1+start);
				}
			}
			else if(replaceButton.isSelected()) {
//				String temp=text.getText().replaceFirst(textField.getText(), replaceField.getText());
//				text.setText(temp);
				if(textField.getText().length()==0) {
					new NoticeFrame("无模式字符串");
					return;
				}
				
				BoyerMoore kmp=new BoyerMoore(textField.getText(),40000);
				
				String o="";
				int start=text.getSelectionStart();
				for(int i=start;i<text.getText().length();i++) {
					o=o+String.valueOf(text.getText().charAt(i));
				}
				
				int end=kmp.search(o);
				String temp=replaceString(text.getText(),end+1-textField.getText().length()+start,end+start,replaceField.getText());
				text.setText(temp);
				text.setSelectionStart(end+1+start);
				text.requestFocus();
			}
			
		}
	}
	
	private String replaceString(String t,int start,int end,String re) {
		String temp="";
		for(int i=0;i<t.length();i++) {
			if(i==start) {
				temp=temp+re;
				i=i+(end-start);
			}
			else {
				temp=temp+String.valueOf(t.charAt(i));
			}
		}
		
		return temp;
	}
	
}
