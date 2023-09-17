package iuh.vn.edu.fit.lab_week2_20048881_nguyenvanphu;

import java.io.*;

import iuh.vn.edu.fit.connect.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        EntityManager em = ConnectDB.getConnectDB().getEmf().createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();
    }

    public void destroy() {
    }
}