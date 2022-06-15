package conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class conexBDSQL {
	public Connection conex(){
		Connection cn=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String server="";
			//server="perli-pc2";
			server="perliexp";
			cn = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName=PerliExpress","perli","perli");
			//cn = DriverManager.getConnection("jdbc:sqlserver://perli-pc2;databaseName=PerliExpress","perli","perli");
			//System.out.println("todo bien");
		} catch (Exception e) {
			System.out.println("error:" +e);
			// TODO: handle exception
		}
		
		return cn;
	}
	//public static void main(String[] args) {
	 //conexBDSQL con = new conexBDSQL();
		//con.conex();
//		Date date = new Date(0);
////		//Caso 1: obtener la hora y salida por pantalla con formato:
////		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
////		System.out.println("Hora: "+hourFormat.format(date));
////		
////		//Caso 2: obtener la fecha y salida por pantalla con formato:
////		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
////		System.out.println("Fecha: "+dateFormat.format(date));
	//}

}
