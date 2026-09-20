package ir.maktabsharif.controller;

import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "admin",value = "/admin")
public class adminServlet extends HttpServlet {

    private UserRepositoryImpl userRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userRepository = (UserRepositoryImpl) getServletContext().getAttribute("userRepository");
    }



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("page/admin.jsp").forward(req,resp);
    }
}
