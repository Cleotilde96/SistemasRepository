package config;

import java.net.InetAddress;

public enum EnumCConection  {
	 
		CONNECTIONDATA("jdbc:sqlserver://"+Server()+":1433;databaseName=PerliExpress","perli","perli"),
		CONNECTIONDATACFDI("jdbc:sqlserver://"+Server()+":1433;databaseName=BD_PerliCFDI","perli","perli");
		
	    private final String JDBC_URL;
	    private final String JDBC_USER;
	    private final String JDBC_PASSWORD;
	    private static String SERVER;
	    
	    public String getJDBC_URL() {
			return JDBC_URL;
		}

		public String getJDBC_USER() {
			return JDBC_USER;
		}

		public String getJDBC_PASSWORD() {
			return JDBC_PASSWORD;
		}

		private EnumCConection(String jDBC_URL, String jDBC_USER, String jDBC_PASSWORD) {
			JDBC_URL = jDBC_URL;
			JDBC_USER = jDBC_USER;
			JDBC_PASSWORD = jDBC_PASSWORD;
		}
		public static String Server(){
	    	try {
	    	
	    	//SERVER =obtieneNomServidor(); 
	    SERVER = "PERLIEXP";
	    //  SERVER ="perli-pc2";
	    		/*HACER METODO EN DONDE APUNTE A PC2 */
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return SERVER;
	    }
		
		public static String obtieneNomServidor() {
						

			String host="";

			try {
			host=InetAddress.getLocalHost().getHostName().toUpperCase();
			if (host.equals("SISTEMAS1-I") || host.equals("SISTEMASE") || host.equals("") || host.equals("SISTEMAS3")) {
			host="PERLI-PC2";
			}
			else if(host.equals("ASISTENTEVENTAS-PC")){
				
				host="PERLIEXP";
			}
			
			} catch (Exception e) {
			
			}
			
			
			return host;
		}
		
}
