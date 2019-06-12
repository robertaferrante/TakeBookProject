package takebook.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
		/**SINGLETON*/
		/**DBConnection serve per la connessione al DB*/
public class DBConnection {
	private static DBConnection instance;
	private static String driver = "thin";
	private static String user = "c##TAKEBOOK";
	private static String pass = "TAKEBOOK";
	private static String host = "localhost";
	private static String port = "1521";
	private static String db = "xe";
	//attributo che contiene la connessione che restituisce materialmente la connessione
	private Connection conn; 

	//costruttore privato singleton
	private DBConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		String connString = String.format("jdbc:oracle:%s:%s/%s@//%s:%s/%s", driver, user, pass, host, port, db);
		try {
			conn = DriverManager.getConnection(connString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//metodo public e static che dice che se è stato già creato un oggetto di tipo connessione non lo crea nuovamente
	public static DBConnection getDBConnection() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}

}
