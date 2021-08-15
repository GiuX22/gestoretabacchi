package MainPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;



@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	private JPanel contentPanel;

	private DataBase dataBase;

	private int width;
	private int height;

	private static MainFrame mainFrame=null;

	private MainFrame() {

		dataBase = new DataBase();
		initFrame();
		contentPanel = new JPanel(new BorderLayout());

		this.setLocationRelativeTo(null);
		
		contentPanel.setOpaque(false);
		add(contentPanel);

		switchTo(new ChoosePanel(this));
	}

	public static MainFrame getIstanceMainframe()
	{
		if(mainFrame==null)
		{
			mainFrame=new MainFrame();

			return mainFrame;
		}
		return mainFrame;

	}

	
	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}

	
	private void initFrame() {

		width = 900;
		height = 700; 
		this.setSize(width, height); 
		this.setUndecorated(false);
		this.setTitle("Gestore Tabacchi");
		this.setResizable(false);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void switchTo(final JPanel panel)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				contentPanel.removeAll();
				contentPanel.add(panel, BorderLayout.CENTER);
				contentPanel.updateUI();
				panel.requestFocus();
			}
		});
	}



	public DataBase getDataBase() {
		return dataBase;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		@SuppressWarnings("unused")        
		MainFrame main = MainFrame.getIstanceMainframe();

	}







}

