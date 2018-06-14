import java.io.IOException;
 import java.sql.SQLException;
 import java.util.List;

 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.*;

 @WebServlet("/products")
 public class ProductsServlet extends HttpServlet {

     // @Resource("jdbc/YourDB") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
   
     private ProductDAO productDAO = new ProductDAO();
    

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         try {
           
                       List<Product> products = productDAO.list();
         
             request.setAttribute("products", products); // Will be available as ${products} in JSP
            request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
         } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
     }

}