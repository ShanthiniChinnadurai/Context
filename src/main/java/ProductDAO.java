import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import javax.sql.DataSource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/product")
public class ProductDAO {
    public String url = "jdbc:mysql://localhost:3306/Shanthini";
   ServletContext servletContext= getServletContext();
    public void service(ServletRequest req,ServletResponse res)
    throws IOException,ServletException
    {
     DBConnectionManager db = (DBConnectionManager) servletContext.getAttribute("DBConnection");
     res.setContentType("text/html");
     
    PrintWriter out=res.getWriter();
    out.print(db);
    }
	private ServletContext getServletContext() {
		return null;
	}

    
        public List<Product> list() throws SQLException {
            List<Product> products = new ArrayList<Product>();
    
            try (
               
               
                
                //Connection connection = DriverManager.getConnection(url, "root", "");
                // Connection connection = dataSource.getConnection();
                PreparedStatement statement = db.prepareStatement("SELECT id, name, description, price FROM product");
                ResultSet resultSet = statement.executeQuery();

                //sqlqry="";
                //resultset rs = query()
            ) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getInt("price"));
                    products.add(product);
                }
            }
            return products;
        }
        
		public Product getProduct(int id) throws SQLException {
            Product product = null;
            String sql = "SELECT * FROM product WHERE id = ?";
             
            Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/Shanthini", "root", "");
             
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
             
            ResultSet resultSet = statement.executeQuery();
             
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                 
                product = new Product(id, name, description, price);
            }
             
            resultSet.close();
            statement.close();
             
            return product;
        }
    
    }
	