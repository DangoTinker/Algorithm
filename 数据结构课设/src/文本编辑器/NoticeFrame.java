package �ı��༭��;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
public class NoticeFrame extends JFrame{
	private JButton button;
	private JLabel label;
	public NoticeFrame(String text) {
		JPanel panel=new JPanel(new FlowLayout());
		button=new JButton("ȷ��");
		label=new JLabel(text);
		this.add(panel);
		panel.add(label);
		panel.add(button);
		button.addMouseListener(new ButtonListener());
		this.setTitle("֪ͨ");
		
		this.setSize(300,100);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				dispose();
			}catch(Exception ex) {
				
			}
		}
		
		
	}
}
