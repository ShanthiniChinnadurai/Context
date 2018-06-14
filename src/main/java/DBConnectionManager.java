import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;

public class DBConnectionManager {

	private Connection connection;
	
	public DBConnectionManager(String dbURL, String dbUser, String dbPassword) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}
	
	public Connection getConnection(){
		return this.connection;
	}

	public PreparedStatement prepareStatement(String string) {
		return null;
	}
}