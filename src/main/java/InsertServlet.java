//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

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

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    String id=request.getParameter("tid");
    String name = request.getParameter("tname");
    String desc = request.getParameter("tdes");
    String price = request.getParameter("tprice");
    try {

      //loading drivers for mysql
      // Class.forName("com.mysql.jdbc.Driver");

      //creating connection with the database 
      Connection con = getMysqlDataSource().getConnection();
      PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");

      ps.setString(1, id);
      ps.setString(2, name);
      ps.setString(3, desc);
      ps.setString(4,price);
      int i = ps.executeUpdate();
      
      response.sendRedirect("products"); 

    } catch (Exception se) {
      se.printStackTrace();
    }

  }
}
