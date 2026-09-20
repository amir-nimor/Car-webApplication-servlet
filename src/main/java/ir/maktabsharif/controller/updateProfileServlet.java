package ir.maktabsharif.controller;

import ir.maktabsharif.model.Role;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "updateProfile",value = "/update")
public class updateProfileServlet extends HttpServlet {


    private UserRepositoryImpl userRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userRepository = (UserRepositoryImpl) getServletContext().getAttribute("userRepository");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("page/login.jsp").forward(req,resp);
        req.getRequestDispatcher("page/updateProfile.jsp").forward(req,resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String name =  req.getParameter("name");
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        String phoneNumber =  req.getParameter("phoneNumber");
        Integer id =(Integer) session.getAttribute("id");

        User user = new User(name,phoneNumber,username,password);
        user.setId(id);
        if ("admin".equals(username) && "admin".equals(password)){
            user.setRole(Role.ADMIN);
        }else {
            user.setRole(Role.USER);
        }

        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("phoneNumber",phoneNumber);
        session.setAttribute("name",name);

        userRepository.update(user);

        req.getRequestDispatcher("page/sucsses.jsp").forward(req,resp);
    }


}
