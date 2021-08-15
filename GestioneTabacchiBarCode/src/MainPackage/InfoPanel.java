package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	private MainFrame frame;

	private JLabel labelTitle;

	
	private GregorianCalendar calendar = new GregorianCalendar();

	private JButton buttonBack;
	private JComboBox<String> selectedMonth;
	private JComboBox<Integer> selectedDay;

	private JLabel labelTotalSelectedDay;
	private JButton buttonConfirmDay;
	
	private JLabel labelTotalStorage;
	
	private Double totalStorage;
	
	private BigDecimal rightTotal;
	
	private double	totalSalesToday;
	private int MonthChooser;
	public InfoPanel(MainFrame mainFrame) {
		this.frame = mainFrame;

		this.setLayout(null);

		initComponent();
		addEventsAtComponent();
		addComponent();

	}

	private void initComponent() {


		labelTitle = new JLabel ("Pannello Informative");
		labelTitle.setOpaque(true);
		labelTitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelTitle.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelTitle.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelTitle.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		labelTitle.setBounds((frame.getWidth()/2) -150, 5, 300, 50);


		buttonBack = new JButton("Indietro");
		buttonBack.setBounds(0, frame.getHeight() - 80, 100, 50);

		selectedMonth = new JComboBox<String>();
		selectedMonth.setBounds(100, 100, 150, 30);

		inizializeMonth(calendar.get(Calendar.MONTH)+1);


		selectedDay = new JComboBox<Integer>();
		selectedDay.setBounds(100, 150, 150, 30);
		inizializateDay(calendar.get(Calendar.DAY_OF_MONTH));

		totalSalesToday = frame.getDataBase().getTotalDaily(calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR));
		
		rightTotal = new BigDecimal(Double.toString(totalSalesToday)); 
		
		labelTotalSelectedDay = new JLabel("EURO "+ String.format("%.2f", rightTotal));
		labelTotalSelectedDay.setBounds(300, 130, 200, 40);
		
		buttonConfirmDay = new JButton("Conferma"); 
		buttonConfirmDay.setBounds(125, 200, 100, 30);
		
		totalStorage = frame.getDataBase().getTotalStorage();
		
		labelTotalStorage = new JLabel("Euro : "+String.format("%.2f", totalStorage));
		labelTotalStorage.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelTotalStorage.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelTotalStorage.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelTotalStorage.setFont(new Font("Comic Sans MS",Font.BOLD,14));
		labelTotalStorage.setBounds(750, 640, 150, 30);
		
	}



	private void addComponent() {
		this.add(buttonBack);
		this.add(labelTitle);	
		this.add(selectedMonth);
		this.add(selectedDay);
		this.add(buttonConfirmDay);
		this.add(labelTotalSelectedDay);
		this.add(labelTotalStorage);
		
	}

	private void addEventsAtComponent() {
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				frame.switchTo(new ChoosePanel(frame));

			}

		});

		selectedMonth.addItemListener(new ItemListener() {



			@Override
			public void itemStateChanged(ItemEvent arg0) {


				inizializateDay(calendar.get(Calendar.DAY_OF_MONTH));
				MonthChooser = selectedMonth.getSelectedIndex()+1;


			}
		});

		
		buttonConfirmDay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				totalSalesToday = frame.getDataBase().getTotalDaily((int)selectedDay.getSelectedItem(), MonthChooser, 2015);

				rightTotal = new BigDecimal(Double.toString(totalSalesToday)); 
				labelTotalSelectedDay.setText("EURO "+ String.format("%.2f", rightTotal));
				
			}
		});

	}


	private void inizializateDay(int d)
	{
		selectedDay.removeAllItems();
		
		for (int i = 1; i < 32; i++) {

			if(i>28)
			{

				if(!selectedMonth.getSelectedItem().toString().equals("Febbraio"))
				{
					if(i>30)
					{
						if(!(selectedMonth.getSelectedItem().toString().equals("Aprile")||selectedMonth.getSelectedItem().toString().equals("Giugno")||selectedMonth.getSelectedItem().toString().equals("Settembre")||selectedMonth.getSelectedItem().toString().equals("Novembre")))
						{
							selectedDay.addItem(i);

						}
					}
					else
					{
						selectedDay.addItem(i);
					}
				}


			}
			else
			{
				selectedDay.addItem(i);
			}

		}

		if (selectedMonth.getSelectedItem().toString().equals("Seleziona")) 
		{
			selectedDay.removeAll();	
		}

		
		selectedDay.setSelectedItem(d);
		this.repaint();
	}

	private void inizializeMonth(int i) {

		selectedMonth.addItem("Gennaio");
		selectedMonth.addItem("Febbraio");
		selectedMonth.addItem("Marzo");
		selectedMonth.addItem("Aprile");
		selectedMonth.addItem("Maggio");
		selectedMonth.addItem("Giugno");
		selectedMonth.addItem("Luglio");
		selectedMonth.addItem("Agosto");
		selectedMonth.addItem("Settembre");
		selectedMonth.addItem("Ottobre");
		selectedMonth.addItem("Novembre");
		selectedMonth.addItem("Dicembre");



		if(i == 1 )
		{
			selectedMonth.setSelectedItem("Gennaio");
		}
		if(i == 2)
		{
			selectedMonth.setSelectedItem("Febbraio");
		}
		if(i == 3 )
		{
			selectedMonth.setSelectedItem("Marzo");
		}
		if(i == 4 )
		{
			selectedMonth.setSelectedItem("Aprile");
		}
		if(i == 5 )
		{
			selectedMonth.setSelectedItem("Maggio");
		}
		if(i == 6 )
		{
			selectedMonth.setSelectedItem("Giugno");
		}
		if(i == 7 )
		{
			selectedMonth.setSelectedItem("Luglio");
		}
		if(i == 8 )
		{
			selectedMonth.setSelectedItem("Agosto");
		}
		if(i ==  9)
		{
			selectedMonth.setSelectedItem("Settembre");
		}
		if(i == 10 )
		{
			selectedMonth.setSelectedItem("Ottobre");
		}
		if(i == 11 )
		{
			selectedMonth.setSelectedItem("Novembre");
		}
		if(i == 12)
		{
			selectedMonth.setSelectedItem("Dicembre");
		}

		MonthChooser = selectedMonth.getSelectedIndex()+1;
	}


}
