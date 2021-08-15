package MainPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChoosePanel extends JPanel{


	public MainFrame frame;



	private JButton gestione;
	private JButton informative;
	private JButton vendite;
	private int wButton = 100;
	private int hButton = 60;

	public ChoosePanel(MainFrame mainFrame)
	{
		super();
		this.frame = mainFrame;

		this.setLayout(null);
		this.setBackground(Color.GREEN);
		
		gestione = new JButton("Gestione");
		informative = new JButton("Informative");
		vendite = new JButton("Vendite");
		gestione.setBounds((frame.getWidth()/2 - 50) -wButton, (frame.getHeight()/2 -50) - hButton, wButton, hButton);
		informative.setBounds((frame.getWidth()/2 + 50), (frame.getHeight()/2 -50) - hButton,wButton, hButton);
		vendite.setBounds(frame.getWidth()/2 - wButton/2, frame.getHeight()/2 +20, wButton, hButton);
		this.add(gestione);
		this.add(informative);
		this.add(vendite);
		
		
		gestione.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.switchTo(new ManagementPanel(frame));
				
			}
		});
		
		informative.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.switchTo(new InfoPanel(frame));
				
			}
		});
		
		vendite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.switchTo(new SellPanel(frame));
				
			}
		});
	}





}
