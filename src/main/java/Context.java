import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Context implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	ServletContext ctx = servletContextEvent.getServletContext();
        
    	//initialize DB Connection
        ctx.setInitParameter("dbURL","jdbc:mysql://localhost:3306/Shanthini");
       ctx.setInitParameter("dbUser","root");
       ctx.setInitParameter("dbPassword"," ");
    
    
       try {
        DBConnectionManager connectionManager = new DBConnectionManager("dbURL", "dbUser", "dbPassword");
        ctx.setAttribute("DBConnection", connectionManager.getConnection());
        System.out.println("DB Connection initialized successfully.");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    	
    	
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
       
    }

}