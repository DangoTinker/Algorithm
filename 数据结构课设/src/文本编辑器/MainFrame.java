package 文本编辑器;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
public class MainFrame extends JFrame {
//	private File file=null;
	private HashMap<String,File> fileMap;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem saveOtherFile;
	private JMenuItem saveFile;
	private JMenu searchMenu;
	private JMenuItem search;
	private JMenu statisticMenu;
	private JMenuItem statistic;
	private JMenuItem openFile;
	private JMenuItem newFile;
	private HashMap<String,JTextArea> textAreaMap;
	private HashMap<String,JMenuItem> menuItemMap;
	private HashMap<String,JPanel> panelMap;
	private JFrame frame;
	private JPanel bottomPanel;
	private JPanel topPanel;
	private JPanel basePanel;
	private String now;
	private JButton closeButton;
	private CardLayout card=new CardLayout();
	public MainFrame () throws Exception{
		fileMap=new HashMap<String,File>();
		basePanel=new JPanel(new BorderLayout());
		panelMap=new HashMap<String,JPanel>();
		this.add(basePanel);
		menuItemMap=new HashMap<String,JMenuItem>();
		textAreaMap=new HashMap();
//		panelMap=new HashMap();
		topPanel=new JPanel(new BorderLayout());
		basePanel.add(topPanel,BorderLayout.NORTH);
		menuBar=new JMenuBar();
		fileMenu=new JMenu("文件");
		openFile=new JMenuItem("打开");
		saveFile=new JMenuItem("保存");
		saveOtherFile=new JMenuItem("另存为");
		statisticMenu=new JMenu("统计");
		statistic=new JMenuItem("字数");
		searchMenu=new JMenu("搜索");
		search=new JMenuItem("查找");
		newFile=new JMenuItem("新建");
		
		closeButton=new JButton("关闭");
		
		fileMenu.add(newFile);
		
		searchMenu.add(search);
		
		
		menuBar.add(fileMenu);
		menuBar.add(searchMenu);
		menuBar.add(statisticMenu);
		
		statisticMenu.add(statistic);
		fileMenu.add(openFile);
		
		fileMenu.add(saveFile);
		fileMenu.add(saveOtherFile);
//		buttonOpenFile=new JButton("打开");
//		buttonSaveFile=new JButton("保存");
		bottomPanel=new JPanel();
		basePanel.add(bottomPanel,BorderLayout.CENTER);
		bottomPanel.setLayout(card); 
//		text=new JTextArea(20,20);
//		panel.setLayout(card);
		this.setTitle("文本编辑器");
		topPanel.add(menuBar,BorderLayout.WEST);
		topPanel.add(closeButton,BorderLayout.EAST);
//		text.setLineWrap(true);
//		panel.add(text,BorderLayout.CENTER);
//		JScrollPane scroll=new JScrollPane(text);
//		panel.add(scroll);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		

		openFile.addMouseListener(new OpenFileListener());
		saveFile.addMouseListener(new SaveFileListener());
		saveOtherFile.addMouseListener(new SaveOtherFileListener());
		statistic.addMouseListener(new StatisticListener());
		search.addMouseListener(new SearchListener());
		newFile.addMouseListener(new NewFileListener());
		closeButton.addMouseListener(new CloseListener());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	/*
	private boolean search(String mod) {
		int start=text.getText().indexOf(mod);
		if(start==-1)
			return false;
		text.setSelectionStart(start+mod.length());
		return true;
	}
	*/
	class OpenFileListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
//				System.out.println(((JMenuItem)e.getSource()).getText());
				openFile();
			}catch(Exception ex) {
				new NoticeFrame(ex.toString());
				ex.printStackTrace();
			}
		}
	}
	
	class NewFileListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				JPanel temp=new JPanel(new BorderLayout());
				textAreaMap.put("新建文本文件.txt", new JTextArea());
				
				temp.add(textAreaMap.get("新建文本文件.txt"),BorderLayout.CENTER);
//				textAreaMap.get(openFile.getFile()).setLineWrap(true);
				JScrollPane scroll=new JScrollPane(textAreaMap.get("新建文本文件.txt"));
				temp.add(scroll);
				scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

				bottomPanel.add(temp,"新建文本文件.txt");
				JMenuItem item=new JMenuItem("新建文本文件.txt");
				menuItemMap.put("新建文本文件.txt", item);
				fileMenu.add(item);
				item.addMouseListener(new ChangeListener());
				now="新建文本文件.txt";
				panelMap.put("新建文本文件.txt", temp);
				card.show(bottomPanel, "新建文本文件.txt");
				bottomPanel.repaint();
				textAreaMap.get("新建文本文件.txt").requestFocus();
				MainFrame.this.setTitle(now);
				fileMap.put("新建文本文件.txt", null);
				temp.updateUI();
			}catch(Exception ex) {
				new NoticeFrame(ex.toString());
				ex.printStackTrace();
			}
		}
	}
	
	class ChangeListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			card.show(bottomPanel,((JMenuItem)e.getSource()).getText());
			bottomPanel.repaint();
//			textAreaMap.get(((JButton)e.getSource()).getText());
			now=((JMenuItem)e.getSource()).getText();
			MainFrame.this.setTitle(now);
		}
	}
	
	
	private void openFile() throws Exception{
		FileDialog openFile=new FileDialog(frame,"打开文件",FileDialog.LOAD);
		openFile.setVisible(true);
		if(openFile.getFile()!=null) {
//			file=new File(openFile.getDirectory()+openFile.getFile());
			this.setTitle(openFile.getFile());
			InputStream input=new FileInputStream(openFile.getDirectory()+openFile.getFile());
			JPanel temp=new JPanel(new BorderLayout());
			textAreaMap.put(openFile.getFile(), new JTextArea());
			
			textAreaMap.get(openFile.getFile()).setText(new String(input.readAllBytes()));
			temp.add(textAreaMap.get(openFile.getFile()),BorderLayout.CENTER);
//			textAreaMap.get(openFile.getFile()).setLineWrap(true);
			JScrollPane scroll=new JScrollPane(textAreaMap.get(openFile.getFile()));
			temp.add(scroll);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMap.put(openFile.getFile(), temp);
			bottomPanel.add(temp,openFile.getFile());
			JMenuItem item=new JMenuItem(openFile.getFile());
			fileMenu.add(item);
			item.addMouseListener(new ChangeListener());
			menuItemMap.put(openFile.getFile(), item);
			now=openFile.getFile();
			
			
			fileMap.put(openFile.getFile(), new File(openFile.getDirectory()+openFile.getFile()));
			card.show(bottomPanel, openFile.getFile());
			temp.updateUI();
			textAreaMap.get(openFile.getFile()).requestFocus();
		}
	}
	
	private void saveOtherFile() throws Exception{
		FileDialog saveFile=new FileDialog(frame,"打开文件",FileDialog.SAVE);
		saveFile.setVisible(true);
		if(saveFile.getFile()!=null) {
			OutputStream input=new FileOutputStream(saveFile.getDirectory()+saveFile.getFile());
			input.write(textAreaMap.get(now).getText().getBytes());
		}
		
	}
	class SaveOtherFileListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				if(now==null) {
					new NoticeFrame("未选中文件");
				}
				else
				saveOtherFile();
			}catch(Exception ex) {
				new NoticeFrame(ex.toString());
			}
		}
		
	}
	
	
	private void saveFile() throws Exception{
		File file=fileMap.get(now);
		if(file!=null) {
//			System.out.println(file.getPath());
			OutputStream out=new FileOutputStream(file.getPath());
			out.write(textAreaMap.get(now).getText().getBytes());

		}
		else {
			saveOtherFile();
		}
	}
	
	
	class SaveFileListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			try {
				saveFile();
				new NoticeFrame("保存成功");
			}catch(Exception ex) {
				new NoticeFrame(ex.toString());
			}
		}
	}
	
	private int countsOfCharacter(String text) {
		text=textAreaMap.get(now).getText();
		return text.length();
	}
	private int countsOfRow(String text) {
		if(text.length()==0)
			return 0;
		text=textAreaMap.get(now).getText();
		int count=0;
		for(int i=0;i<text.length();i++){
			if(text.charAt(i)=='\n') {
				count++;
			}
		}
		return count+1;
	}
	class StatisticListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			if(now!=null) {
				int counts=countsOfCharacter(textAreaMap.get(now).getText());
				int rows=countsOfRow(textAreaMap.get(now).getText());
				new NoticeFrame("字数："+String.valueOf(counts)+"\n行数："+String.valueOf(rows));
			}
			else {
				new NoticeFrame("未选中文件");
			}
		}
	}
	
	class SearchListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			if(now!=null) {
				new SearchFrame(textAreaMap.get(now));
			}
			else {
				new NoticeFrame("未选中文件");
			}
		}
	}
	
	class CloseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			fileMenu.remove(menuItemMap.get(now));
			bottomPanel.remove(panelMap.get(now));
//			System.out.println(textAreaMap.get(now).getText());
			textAreaMap.get(now).setText("");;
//			System.out.println(textAreaMap.get(now).getText());
			if(fileMenu.getItemCount()!=4) {
				now=fileMenu.getItem(4).getText();
				
				card.show(bottomPanel, now);
				MainFrame.this.setTitle(now);
				bottomPanel.updateUI();
			}else {
				now=null;
				MainFrame.this.setTitle("文本编辑器");
				bottomPanel.removeAll();
				bottomPanel.updateUI();
			}
		}
	}
	
}
