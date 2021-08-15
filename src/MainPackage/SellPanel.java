package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

public class SellPanel extends JPanel {

	private MainFrame frame;

	private JLabel labelTitle;

	private GregorianCalendar calendar;

	private JLabel labelTotalSales;
	private JLabel labelTotalSalesInfo;

	private double totalSalesToday;

	private JLabel labelFastSales;

	private JLabel labelBarCode;
	private JTextField textFieldBarCode;

	private JButton buttonStartOrStop;
	private JButton buttonConfirm;

	private JLabel labelLastSales;
	private JLabel labelLastPackage;

	private JList <String> totaySales;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollSells;


	private JButton buttonBack;

	private boolean isFastSalesRun;

	public SellPanel(MainFrame mainFrame) {
		this.frame = mainFrame;
		this.setLayout(null);

		initComponent();
		addEventsAtComponent();
		addComponent();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					while(true)
					{
						textFieldBarCode.requestFocusInWindow();
						Thread.sleep(5000);						
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}).start();
		

	}

	private void initComponent() {

		isFastSalesRun = false;

		calendar = new GregorianCalendar();

		labelTitle = new JLabel ("Pannello Vendite");
		labelTitle.setOpaque(true);
		labelTitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelTitle.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelTitle.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelTitle.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		labelTitle.setBounds((frame.getWidth()/2) -150, 5, 300, 50);


		labelBarCode = new JLabel("Codice A Barre");
		labelBarCode.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelBarCode.setVerticalAlignment((int) CENTER_ALIGNMENT);
		//		labelBarCode.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelBarCode.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		labelBarCode.setBounds(350, 100, 200, 30);

		textFieldBarCode = new JTextField();
		textFieldBarCode.setBounds(350, 140, 200, 30);

		buttonStartOrStop = new JButton("Start");
		buttonStartOrStop.setBounds( 100 , 220, 100 , 30);

		labelFastSales = new JLabel("Vendita Automatica");
		labelFastSales.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelFastSales.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelFastSales.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		labelFastSales.setBounds(50 , 145 , 200, 30);

		buttonConfirm = new JButton("Conferma");
		buttonConfirm.setBounds(400, 180, 100 , 30);

		labelLastSales = new JLabel("Ultime Vendite");
		labelLastSales.setOpaque(true);
		labelLastSales.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelLastSales.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelLastSales.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelLastSales.setFont(new Font("Comic Sans MS",Font.BOLD,18));
		labelLastSales.setBounds(350, 280 , 200, 50);


		listModel = new DefaultListModel();

		listModel = frame.getDataBase().getTodaySells();

		labelLastPackage = new JLabel();
		labelLastPackage.setBounds(600, 150, 180, 100);



		totaySales = new JList<String>(listModel);

		scrollSells = new JScrollPane();
		scrollSells.setViewportView(totaySales);
		scrollSells.setBounds(250, 350, 400, 300);
		scrollSells.setAutoscrolls(true);

		labelTotalSales = new JLabel("Totale Giornaliero");
		labelTotalSales.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelTotalSales.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelTotalSales.setFont(new Font("Comic Sans MS",Font.BOLD,14));
		labelTotalSales.setBounds(750, 610, 150, 30);

		int lastIndex = totaySales.getModel().getSize() - 1;
		if (lastIndex >= 0) {
			totaySales.ensureIndexIsVisible(lastIndex);
		}


		totalSalesToday = frame.getDataBase().getTotalDaily(calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR));

		labelTotalSalesInfo = new JLabel("Euro : "+String.format("%.2f", totalSalesToday));
		labelTotalSalesInfo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelTotalSalesInfo.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelTotalSalesInfo.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelTotalSalesInfo.setFont(new Font("Comic Sans MS",Font.BOLD,14));
		labelTotalSalesInfo.setBounds(750, 640, 150, 30);

		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(0, frame.getHeight() - 80, 100, 50);
	}

	private void addComponent() {

		this.add(labelTitle);
		this.add(labelBarCode);
		this.add(textFieldBarCode);

		this.add(buttonStartOrStop);
		this.add(labelFastSales);
		this.add(buttonConfirm);

		this.add(labelLastSales);
		this.add(scrollSells);

		this.add(buttonBack);
		this.add(labelTotalSales);
		this.add(labelTotalSalesInfo);

		this.add(labelLastPackage);
	}

	private void addEventsAtComponent() {

		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				frame.switchTo(new ChoosePanel(frame));

			}
		});

		buttonStartOrStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(isFastSalesRun)
				{
					buttonStartOrStop.setText("Start");
					isFastSalesRun = false;
				}
				else
				{
					buttonStartOrStop.setText("Stop");
					isFastSalesRun = true;
				}

			}
		});





		textFieldBarCode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


				calendar = new GregorianCalendar();

				if(!(textFieldBarCode.getText().equals("")))
				{		
					
					
					String tempString = textFieldBarCode.getText().replace(" ", "");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					textFieldBarCode.setText(tempString);
					frame.getDataBase().registerNewSell(textFieldBarCode.getText(), 
							calendar.get(Calendar.DAY_OF_MONTH),
							calendar.get(Calendar.MONTH), 
							calendar.get(Calendar.YEAR), 
							calendar.get(Calendar.HOUR_OF_DAY), 
							calendar.get(Calendar.MINUTE), 
							calendar.get(Calendar.SECOND),
							frame.getDataBase().getPrice(textFieldBarCode.getText()));

					
					

					listModel.addElement(frame.getDataBase().getBrandName(textFieldBarCode.getText())+" - "
							+"Euro: "+frame.getDataBase().getPrice(textFieldBarCode.getText())+" Alle Ore "
							+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)
							);

					labelLastPackage.setText(frame.getDataBase().getBrandName(textFieldBarCode.getText()) + " EURO: "+frame.getDataBase().getPrice(textFieldBarCode.getText()));

					BigDecimal tempTotal = new BigDecimal(Double.toString(frame.getDataBase().getTotalDaily(calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR))));
									
					labelTotalSalesInfo.setText("Euro : "+String.format("%.2f", tempTotal));

					frame.getDataBase().removePacks(textFieldBarCode.getText(), 1);

					textFieldBarCode.setText("");

					listModel.lastElement();



					int lastIndex = totaySales.getModel().getSize() - 1;
					if (lastIndex >= 0) {
						totaySales.ensureIndexIsVisible(lastIndex);
					}


				}


				
				
			}
		});


		buttonConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				calendar = new GregorianCalendar();

				if(!(textFieldBarCode.getText().equals("")))
				{					
					frame.getDataBase().registerNewSell(textFieldBarCode.getText(), 
							calendar.get(Calendar.DAY_OF_MONTH),
							calendar.get(Calendar.MONTH), 
							calendar.get(Calendar.YEAR), 
							calendar.get(Calendar.HOUR_OF_DAY), 
							calendar.get(Calendar.MINUTE), 
							calendar.get(Calendar.SECOND),
							frame.getDataBase().getPrice(textFieldBarCode.getText()));



					listModel.addElement(frame.getDataBase().getBrandName(textFieldBarCode.getText())+" - "
							+"Euro: "+frame.getDataBase().getPrice(textFieldBarCode.getText())+" Alle Ore "
							+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)
							);

					labelLastPackage.setText(frame.getDataBase().getBrandName(textFieldBarCode.getText()) + " EURO: "+frame.getDataBase().getPrice(textFieldBarCode.getText()));

					BigDecimal tempTotal = new BigDecimal(Double.toString(frame.getDataBase().getTotalDaily(calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR))));
					
					labelTotalSalesInfo.setText("Euro : "+String.format("%.2f", tempTotal));

					frame.getDataBase().removePacks(textFieldBarCode.getText(), 1);

					textFieldBarCode.setText("");

					listModel.lastElement();



					int lastIndex = totaySales.getModel().getSize() - 1;
					if (lastIndex >= 0) {
						totaySales.ensureIndexIsVisible(lastIndex);
					}


				}


			}
		});

	}



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


		if(isFastSalesRun)
		{
			g.setColor(Color.GREEN);
			g.fillOval(133, 175, 38, 38);
		}
		else
		{
			g.setColor(Color.RED);
			g.fillOval(133, 175, 38, 38);
		}

		g.setColor(Color.BLACK);
		g.drawOval(133, 175, 38, 38);
		g.drawRect(25, 130, 250, 130);
		this.repaint();

	}

}
