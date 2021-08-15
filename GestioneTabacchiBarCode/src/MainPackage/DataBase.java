package MainPackage;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DataBase {

	Connection myConn;
	Statement myStat;
	ResultSet myResBrand;
	ResultSet myResSells;

	public DataBase() {
		openConnection();
	}


	private boolean openConnection() {

		try {
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tabacchino","root","");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		}

	}


	public boolean closeConnection()
	{
		if(myConn!= null)
		{
			try {
				myConn.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}


	public void registerNewBrand(String barCodeR, String brandR, double priceR, int minSillR)
	{

		String barCode = barCodeR;
		String brand = brandR;
		int quantity = 0;
		double price = priceR;
		int minSill = minSillR;

		try {

			String sql = "INSERT INTO sigarette (BarCode,Marca,Quantit‡,Prezzo,Quantit‡Minima) "+ //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
					"VALUES ('"+barCode+"', '"+brand+"', '"+quantity+"', '"+price+"', '"+minSill+"')";
			myStat = (Statement) myConn.createStatement();
			myStat.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}

	}


	public void registerNewSell(String barCodeR, int dayR, int monthR, int yearR, int hourR, int minuteR, int secondR, double priceR)
	{
		String barCode = barCodeR;
		int day = dayR;
		int month = monthR+1;
		int year = yearR;
		int hour = hourR;
		int minute = minuteR;
		int second = secondR;
		double price = priceR;

		try {

			String sql = "INSERT INTO vendite (BarCode,Giorno,Mese,Anno,Ora,Minuti,Secondi,Prezzo) "+ //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
					"VALUES ('"+barCode+"', '"+day+"', '"+month+"', '"+year+"', '"+hour+"', '"+minute+"', '"+second+"', '"+price+"')";
			myStat = (Statement) myConn.createStatement();
			myStat.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}

	}


	public double getPrice (String barCodeR)
	{


		try{
			String sql = "select * from sigarette "; 
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{
				if(myResBrand.getString("BarCode").equals(barCodeR))
				{

					return myResBrand.getDouble("Prezzo");

				}
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}



		return 0;

	}

	public String getBrandName (String barCodeR)
	{


		try{
			String sql = "select * from sigarette "; 
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{
				if(myResBrand.getString("BarCode").equals(barCodeR))
				{

					return myResBrand.getString("Marca");

				}
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}



		return "???";

	}

	public DefaultListModel<String> getAllBrand()
	{
		DefaultListModel<String> brand  = new DefaultListModel();

		try{
			String sql = "select * from sigarette "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{
				brand.addElement(myResBrand.getString("Marca"));
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}


		return brand;
	}

	public DefaultListModel<String> getAllBarCode() {
		DefaultListModel<String> barCodes  = new DefaultListModel();

		try{
			String sql = "select * from sigarette "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{
				barCodes.addElement(myResBrand.getString("BarCode"));
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}


		return barCodes;
	}


	public DefaultListModel<String> getAllSells() {

		
		DefaultListModel<String> sells  = new DefaultListModel();

		try{
			String sql = "select * from vendite "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResSells=myStat.executeQuery(sql);
			
			while(myResSells.next())
			{
				
				String code = myResSells.getString("BarCode");
				int hour = myResSells.getInt("Ora");
				int minute = myResSells.getInt("Minuti");
				


				sells.addElement(getBrandName(code)+" - EURO: "+getPrice(code)+" Alle Ore "+hour+":"+minute);
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}


		return sells;
	}


	public void addPacks(String brandBarCode, int packNumbers)
	{

		int currentValue = 0;

		try{
			String sql = "select * from sigarette "; 
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{

				if(myResBrand.getString("BarCode").equals(brandBarCode))
				{
					currentValue = myResBrand.getInt("Quantit‡");
				}
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}




		try
		{
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = (PreparedStatement) myConn.prepareStatement(
					"UPDATE sigarette SET Quantit‡ = ? WHERE BarCode = ?");

			// set the preparedstatement parameters
			ps.setInt(1,(packNumbers + currentValue));
			ps.setString(2,brandBarCode);


			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			ps.close();
		}
		catch (SQLException se)
		{
			// log the exception
			try {
				throw se;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public boolean removePacks(String brandBarCode, int packNumbers)
	{

		int currentValue = 0;

		try{
			String sql = "select * from sigarette "; 
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{

				if(myResBrand.getString("BarCode").equals(brandBarCode))
				{
					currentValue = myResBrand.getInt("Quantit‡");
				}
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}



		if((currentValue - packNumbers ) < 0)
		{
			return false;
		}

		else
		{


			try
			{
				// create our java preparedstatement using a sql update query
				PreparedStatement ps = (PreparedStatement) myConn.prepareStatement(
						"UPDATE sigarette SET Quantit‡ = ? WHERE BarCode = ?");

				// set the preparedstatement parameters
				ps.setInt(1,(currentValue - packNumbers));
				ps.setString(2,brandBarCode);


				// call executeUpdate to execute our sql update statement
				ps.executeUpdate();
				ps.close();
			}
			catch (SQLException se)
			{
				// log the exception
				try {
					throw se;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			return true;

		}
	}


	public double getTotalDaily(int dayOfMonth, int month, int year) {
		
		
		double total = 0;
		
		try{
			String sql = "select * from vendite "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResSells=myStat.executeQuery(sql);
			
			while(myResSells.next())
			{
				
				if(dayOfMonth == myResSells.getInt("Giorno") && month == myResSells.getInt("Mese") && year == myResSells.getInt("Anno"))
				{
					total += getPrice(myResSells.getString("BarCode"));
				}
				
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		
		
		
		return total;
	}


	public DefaultListModel<String> getTodaySells() {
		
		DefaultListModel<String> sells  = new DefaultListModel();

		GregorianCalendar calendar = new GregorianCalendar();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) +1 ;
		int year = calendar.get(Calendar.YEAR);
		
		
		try{
			String sql = "select * from vendite WHERE Giorno = "+day+" AND Mese = "+month+" AND Anno = "+year+" "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResSells=myStat.executeQuery(sql);
			
			while(myResSells.next())
			{
				
				String code = myResSells.getString("BarCode");
				int hour = myResSells.getInt("Ora");
				int minute = myResSells.getInt("Minuti");
				
				sells.addElement(getBrandName(code)+" - EURO: "+getPrice(code)+" Alle Ore "+hour+":"+minute);
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}


		return sells;
	}


	public Double getTotalStorage() {
		
		double total = 0.0;
		
		try{
			String sql = "select * from sigarette "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResSells=myStat.executeQuery(sql);
			
			while(myResSells.next())
			{
				
				double tempTotalBrand = 0;
				tempTotalBrand = myResSells.getInt("Quantit‡")*myResSells.getDouble("Prezzo");
				
				total += tempTotalBrand;
				
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		
		
		return total;
	}


	public DefaultListModel<String> getAllBrandAndQuantity() {
		
		
		DefaultListModel<String> brand  = new DefaultListModel();

		try{
			String sql = "select * from sigarette "; //RICORDA DI LASCIARE UNO SPAZIO DOPO IL NOME DELLA TABELLA
			myStat = (Statement) myConn.createStatement();
			myResBrand=myStat.executeQuery(sql);
			while(myResBrand.next())
			{
				brand.addElement(myResBrand.getString("Marca")+" - "+myResBrand.getString("Quantit‡"));
			}
			myStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (myStat != null) 
			{ 
				try {
					myStat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}


		return brand;
		
		
	}




}
