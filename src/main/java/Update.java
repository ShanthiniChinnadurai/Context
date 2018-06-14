import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class Update extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        out.println(id);

        try {

            Product products = productDAO.getProduct(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateForm.jsp");
            request.setAttribute("productid", id);
            request.setAttribute("prd", products);
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        ProductDAO productDAO = new ProductDAO();
        Product newprd = new Product(id, name, description, price);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shanthini", "root", "");
            String sql = "UPDATE product SET name =?,description =?,price=? WHERE id = ?";
            PreparedStatement statement;
            statement = con.prepareStatement(sql);

            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, price);
            statement.setInt(4, id);
            statement.executeUpdate();
            List<Product> products = productDAO.list();
            request.setAttribute("products", products); // Will be available as ${products} in JSP
            request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);

        } catch (Exception se) {
            se.printStackTrace();
            
        }
    }
}
