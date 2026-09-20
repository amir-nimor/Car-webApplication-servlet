package ir.maktabsharif.controller;

import ir.maktabsharif.model.Role;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login",value = "/login")
public class LoginServlet extends HttpServlet {

    private UserRepositoryImpl userRepository;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userRepository = (UserRepositoryImpl) getServletContext().getAttribute("userRepository");
    }



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("page/login.jsp").forward(req,resp);
    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String name =  req.getParameter("name");
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        String phoneNumber =  req.getParameter("phoneNumber");

        User user = new User(name,phoneNumber,username,password);
        if ("admin".equals(username) && "admin".equals(password)){
            user.setRole(Role.ADMIN);
        }else {
            user.setRole(Role.USER);
        }

        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("phoneNumber",phoneNumber);
        session.setAttribute("name",name);

        String token = generateToken(username,password);

        user.setToken(token);

        Cookie cookie = new Cookie("token",token);

        userRepository.create(user);
        resp.addCookie(cookie);

        session.setAttribute("id",user.getId());
        session.setAttribute("user",user);

        req.setAttribute("username",username);
        req.setAttribute("name",name);
        req.setAttribute("id",user.getId());
        req.getRequestDispatcher("page/sucsses.jsp").forward(req,resp);

    }

    protected String generateToken(String username,String password){
        return "TOKEN-"+username+"-"+password;
    }

}
