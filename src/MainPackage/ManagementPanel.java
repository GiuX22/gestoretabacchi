package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ManagementPanel extends JPanel{

	private MainFrame frame;
	private JLabel labelTitle;

	private JButton buttonBack;

	private JLabel labelAddPack;
	private JLabel labelAddPackCode;
	private JLabel labelAddPackNumber;
	private JTextField textFieldAddPackCode;
	private JComboBox<Integer> textFieldAddPackNumber;
	private JButton buttonAddPack;

	private JLabel labelPopPack;
	private JLabel labelPopPackCode;
	private JLabel labelPopPackNumber;
	private JTextField textFieldPopPackCode;
	private JTextField textFieldPopPackNumber;
	private JButton buttonPopPack;

	private JLabel labelAddNewBrand;
	private JLabel labelBarCodeNewBrand;
	private JLabel labelNewBrand;
	private JLabel labelPriceNewBrand;
	private JLabel labelSillNewBrand;
	private JTextField textFieldBarCodeNewBrand;
	private JTextField textFieldNewBrand;
	private JTextField textFieldPriceNewBrand;
	private JTextField textFieldSillNewBrand;
	private JButton buttonNewBrand;

	private JList <String> presentBrand;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollBrand;


	public ManagementPanel(MainFrame mainFrame) {
		this.frame = mainFrame;

		this.setLayout(null);

		initComponent();
		addEventsAtComponent();
		addComponent();



		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.switchTo(new ChoosePanel(frame));

			}
		});


	}








	private void initComponent() {

		//Label Titolo
		labelTitle = new JLabel ("Pannello Di Gestione");
		labelTitle.setBackground( Color.YELLOW);
		labelTitle.setOpaque(true);
		labelTitle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelTitle.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelTitle.setBorder( BorderFactory.createLineBorder(Color.BLACK));
		labelTitle.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		labelTitle.setBounds((frame.getWidth()/2) -150, 5, 300, 50);

		//Bottone Back
		buttonBack = new JButton ("Indietro");
		buttonBack.setBounds(0, this.getFrameHeight() - 50, 100, 50);

		//Elementi per Aggiungere Pacchetti
		labelAddPack = new JLabel("Aggiungi Pacchetti");
		labelAddPack.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		labelAddPack.setOpaque(true);
		labelAddPack.setBackground(Color.RED);
		labelAddPack.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelAddPack.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelAddPack.setBounds(150 , 100 , 200, 50);

		labelAddPackCode = new JLabel("Codice A Barre");
		labelAddPackCode.setBounds(150, 150, 150, 30);
		labelAddPackCode.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelAddPackCode.setVerticalAlignment((int) CENTER_ALIGNMENT);
		textFieldAddPackCode = new JTextField();
		textFieldAddPackCode.setBounds(150, 180, 150, 30);

		labelAddPackNumber = new JLabel("N°");
		labelAddPackNumber.setBounds(310, 150, 40, 30);
		labelAddPackNumber.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelAddPackNumber.setVerticalAlignment((int) CENTER_ALIGNMENT);
		textFieldAddPackNumber = new JComboBox<Integer>();
		textFieldAddPackNumber.addItem(10);
		textFieldAddPackNumber.addItem(20);

		textFieldAddPackNumber.setBounds(310, 180, 40 , 30);

		buttonAddPack = new JButton("Aggiungi");
		buttonAddPack.setBounds(200, 220 , 100, 30);


		//Elementi per Rimuovere Pacchetti
		labelPopPack = new JLabel("Rimuovi Pacchetti");
		labelPopPack.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		labelPopPack.setOpaque(true);
		labelPopPack.setBackground(Color.RED);
		labelPopPack.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelPopPack.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelPopPack.setBounds(550 , 100 , 200, 50);

		labelPopPackCode = new JLabel("Codice A Barre");
		labelPopPackCode.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelPopPackCode.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelPopPackCode.setBounds(550, 150, 150, 30);
		textFieldPopPackCode = new JTextField();
		textFieldPopPackCode.setBounds(550, 180, 150, 30);

		labelPopPackNumber = new JLabel("N°");
		labelPopPackNumber.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelPopPackNumber.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelPopPackNumber.setBounds(710, 150, 40, 30);
		textFieldPopPackNumber = new JTextField();
		textFieldPopPackNumber.setBounds(710, 180, 40, 30);

		buttonPopPack = new JButton("Rimuovi");
		buttonPopPack.setBounds(600, 220, 100, 30);


		//Elementi per Aggiungere Nuova Marca
		labelAddNewBrand = new JLabel("Aggiungi Nuova Marca");
		labelAddNewBrand.setFont(new Font("Comic Sans MS",Font.BOLD,18));
		labelAddNewBrand.setBounds(300, 280, 300, 50);
		labelAddNewBrand.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelAddNewBrand.setVerticalAlignment((int) CENTER_ALIGNMENT);
		labelAddNewBrand.setOpaque(true);
		labelAddNewBrand.setBackground(Color.YELLOW);


		labelBarCodeNewBrand = new JLabel("Codice A Barre");
		labelBarCodeNewBrand.setBounds(150, 330, 150, 30);
		textFieldBarCodeNewBrand = new JTextField();
		textFieldBarCodeNewBrand.setBounds(150, 360, 150, 30);

		labelBarCodeNewBrand.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelBarCodeNewBrand.setVerticalAlignment((int) CENTER_ALIGNMENT);

		labelNewBrand = new JLabel("Marca"); 
		labelNewBrand.setBounds(335, 330, 150, 30);
		textFieldNewBrand = new JTextField();
		textFieldNewBrand.setBounds(335, 360, 150, 30);

		labelNewBrand.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelNewBrand.setVerticalAlignment((int) CENTER_ALIGNMENT);

		labelPriceNewBrand = new JLabel("Prezzo");
		labelPriceNewBrand.setBounds(525, 330, 100, 30);
		textFieldPriceNewBrand = new JTextField();
		textFieldPriceNewBrand.setBounds(525, 360, 100, 30);

		labelPriceNewBrand.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelPriceNewBrand.setVerticalAlignment((int) CENTER_ALIGNMENT);

		labelSillNewBrand = new JLabel("Soglia Minima");
		labelSillNewBrand.setBounds(650, 330, 100, 30);
		textFieldSillNewBrand = new JTextField("");
		textFieldSillNewBrand.setBounds(650, 360, 100, 30);

		labelSillNewBrand.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		labelSillNewBrand.setVerticalAlignment((int) CENTER_ALIGNMENT);


		buttonNewBrand = new JButton("Registra");
		buttonNewBrand.setBounds(400, 400, 100, 30);



		//Prova scrollbar
		listModel = new DefaultListModel();



		listModel = frame.getDataBase().getAllBrandAndQuantity();

		presentBrand = new JList(listModel);
		presentBrand.setVisibleRowCount(3);

		scrollBrand = new JScrollPane();


		scrollBrand.setViewportView(presentBrand);
		scrollBrand.setBounds(150, 500, 300, 100);


		int lastIndex = presentBrand.getModel().getSize() - 1;
		if (lastIndex >= 0) {
			presentBrand.ensureIndexIsVisible(lastIndex);
		}

	}

	private void addEventsAtComponent() 
	{
		buttonNewBrand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {


				if(!isBrandPresentyet(textFieldBarCodeNewBrand.getText()))
				{
					frame.getDataBase().registerNewBrand(textFieldBarCodeNewBrand.getText(),
							textFieldNewBrand.getText(), 
							Double.parseDouble(textFieldPriceNewBrand.getText()), 
							Integer.parseInt(textFieldSillNewBrand.getText()));

					listModel.addElement(textFieldNewBrand.getText());

				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Marca Già Registrata!");
				}

				textFieldBarCodeNewBrand.setText("");
				textFieldNewBrand.setText("");
				textFieldPriceNewBrand.setText("");
				textFieldSillNewBrand.setText("");

				int lastIndex = presentBrand.getModel().getSize() - 1;
				if (lastIndex >= 0) {
					presentBrand.ensureIndexIsVisible(lastIndex);
				}

			}



		});


		buttonAddPack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				frame.getDataBase().addPacks(textFieldAddPackCode.getText(), (Integer)textFieldAddPackNumber.getSelectedItem());

				JOptionPane.showMessageDialog(null, "Aggiunta una stecca di "+ frame.getDataBase().getBrandName(textFieldAddPackCode.getText()));
				
				textFieldAddPackCode.setText("");
				


			}
		});

		textFieldAddPackCode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				frame.getDataBase().addPacks(textFieldAddPackCode.getText(), (Integer)textFieldAddPackNumber.getSelectedItem());
				
				JOptionPane.showMessageDialog(null, "Aggiunta una stecca di "+ textFieldAddPackCode.getText());

				textFieldAddPackCode.setText("");

			}
		});

		buttonPopPack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(!(frame.getDataBase().removePacks(textFieldPopPackCode.getText(), Integer.parseInt(textFieldPopPackNumber.getText()))))
				{
					//Gestire il perchè si stanno rimuovendo troppi pacchetti
				}



			}
		});


	}


	private void addComponent() {
		this.add(labelTitle);
		this.add(buttonBack);

		this.add(labelAddPack);
		this.add(labelAddPackCode);
		this.add(labelAddPackNumber);
		this.add(textFieldAddPackCode);
		this.add(textFieldAddPackNumber);
		this.add(buttonAddPack);

		this.add(labelPopPack);
		this.add(labelPopPackCode);
		this.add(labelPopPackNumber);
		this.add(textFieldPopPackCode);
		this.add(textFieldPopPackNumber);
		this.add(buttonPopPack);

		this.add(labelAddNewBrand);
		this.add(labelBarCodeNewBrand);
		this.add(labelNewBrand);
		this.add(labelPriceNewBrand);
		this.add(labelSillNewBrand);
		this.add(textFieldBarCodeNewBrand);
		this.add(textFieldNewBrand);
		this.add(textFieldPriceNewBrand);
		this.add(textFieldSillNewBrand);
		this.add(buttonNewBrand);

		this.add(scrollBrand);
	}

	private int getFrameHeight()
	{
		return frame.getHeight()-30;
	}

	public boolean isBrandPresentyet(String barCode) {

		DefaultListModel <String> tempList = frame.getDataBase().getAllBarCode();

		for (int i = 0; i < tempList.size(); i++) {

			if(tempList.get(i).equals(barCode))
			{
				return true;
			}

		}

		return false;
	}
}


