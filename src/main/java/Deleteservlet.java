//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/delete")
public class Deleteservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	public static DataSource getMysqlDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
    
        // Set dataSource Properties
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("Shanthini");
        dataSource.setUser("root");
        dataSource.setPassword("");
        return dataSource;
      }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String myid= request.getParameter("id");
        
        try{          
                     //Class.forName("com.mysql.jdbc.Driver");         
                  Connection  con=null;
                             PreparedStatement statement=null;
                             con=getMysqlDataSource().getConnection();        
                             statement= con.prepareStatement("DELETE FROM `product` WHERE id=?");
                             statement.setString(1, myid);
                             int i=statement.executeUpdate();
                             out.println(i);
                             response.sendRedirect("products");
                          

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
    }

}