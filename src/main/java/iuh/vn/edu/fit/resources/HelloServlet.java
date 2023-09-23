package iuh.vn.edu.fit.resources;

import java.io.*;
import java.util.List;

import iuh.vn.edu.fit.models.Product;
import iuh.vn.edu.fit.repositories.ConnectDB;
import iuh.vn.edu.fit.repositories.ProductReponsitory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "MyHelloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if("MappingTable".equals(action)) {
        ProductReponsitory productReponsitory = new ProductReponsitory();
            System.out.println(productReponsitory.getAll().get(0));

//            HttpSession session = request.getSession();
//            response.setContentType("text/html");

//            EntityManager em = ConnectDB.getConnectDB().getEmf().createEntityManager();
//            EntityTransaction tr = em.getTransaction();
//            tr.begin();
//            session.invalidate();
//            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if ("allproduct".equals(action)) {
            ProductReponsitory productReponsitory = new ProductReponsitory();
            List<Product> products = productReponsitory.getAllProductsWithImages();
            request.setAttribute("products", products);
            request.getRequestDispatcher("/all-products.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
    }
}